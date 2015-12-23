/**
 * This script retrieves files and organizes them using a navigable GUI, creating dependencies
 * among files based on their path.
 * 
 * The script retrieves files in JSON format, calling the FileBrowserController (path "/contents?dir=" where
 * "dir" is the root directory from where you want to start to get files.
 * 
 * The main code to care about is explained in the "render" function below
 */

$(function(){

	var filemanager = $('.filemanager'),
	breadcrumbs = $('.breadcrumbs'),
	fileList = filemanager.find('.data');

	var root = "files/enterpriseApplication/lectures"
		$.getJSON('/contents?dir=' + root ,function(data) {

			var response = [data],
			currentPath = '',
			breadcrumbsUrls = [];

			var folders = [],
			files = [];

			// This event listener monitors changes on the URL. We use it to
			// capture back/forward navigation in the browser.

			$(window).on('hashchange', function(){

				changeTo(window.location.hash);

				// We are triggering the event. This will execute 
				// this function on page load, so that we show the correct folder:

			}).trigger('hashchange');


			// Hiding and showing the search box

			filemanager.find('.search').click(function(){

				var search = $(this);

				search.find('span').hide();
				search.find('input[type=search]').show().focus();

			});


			// Listening for keyboard input on the search field.
			// We are using the "input" event which detects cut and paste
			// in addition to keyboard input.

			filemanager.find('input').on('input', function(e){

				folders = [];
				files = [];

				var value = this.value.trim();

				if(value.length) {

					filemanager.addClass('searching');

					// Update the hash on every key stroke
					window.location.hash = 'search=' + value.trim();

				}

				else {

					filemanager.removeClass('searching');
					window.location.hash = encodeURIComponent(currentPath);

				}

			}).on('keyup', function(e){

				// Clicking 'ESC' button triggers focusout and cancels the search

				var search = $(this);

				if(e.keyCode == 27) {

					search.trigger('focusout');

				}

			}).focusout(function(e){

				// Cancel the search

				var search = $(this);

				if(!search.val().trim().length) {

					window.location.hash = encodeURIComponent(currentPath);
					search.hide();
					search.parent().find('span').show();

				}

			});


			// Clicking on folders

			fileList.on('click', 'li.folders', function(e){
				e.preventDefault();

				var nextDir = $(this).find('a.folders').attr('href');

				if(filemanager.hasClass('searching')) {

					// Building the breadcrumbs

					breadcrumbsUrls = generateBreadcrumbs(nextDir);

					filemanager.removeClass('searching');
					filemanager.find('input[type=search]').val('').hide();
					filemanager.find('span').show();
				}
				else {
					breadcrumbsUrls.push(nextDir);
				}

				window.location.hash = encodeURIComponent(nextDir);
				currentPath = nextDir;
			});


			// Clicking on breadcrumbs

			breadcrumbs.on('click', 'a', function(e){
				e.preventDefault();

				var index = breadcrumbs.find('a').index($(this)),
				nextDir = breadcrumbsUrls[index];

				breadcrumbsUrls.length = Number(index);

				window.location.hash = encodeURIComponent(nextDir);

			});


			// Navigates to the given hash (path)

			function changeTo(hash) {

				hash = decodeURIComponent(hash).slice(1).split('=');

				if (hash.length) {
					var rendered = '';

					// if hash has search in it

					if (hash[0] === 'search') {

						filemanager.addClass('searching');
						rendered = searchData(response, hash[1].toLowerCase());

						if (rendered.length) {
							currentPath = hash[0];
							render(rendered);
						}
						else {
							render(rendered);
						}

					}

					// if hash is some path

					else if (hash[0].trim().length) {

						rendered = searchByPath(hash[0]);

						if (rendered.length) {

							currentPath = hash[0];
							breadcrumbsUrls = generateBreadcrumbs(hash[0]);
							render(rendered);

						}
						else {
							currentPath = hash[0];
							breadcrumbsUrls = generateBreadcrumbs(hash[0]);
							render(rendered);
						}

					}

					// if there is no hash

					else {
						currentPath = data.path;
						breadcrumbsUrls.push(data.path);
						render(searchByPath(data.path));
					}
				}
			}

			// Splits a file path and turns it into clickable breadcrumbs

			function generateBreadcrumbs(nextDir){
				var path = nextDir.split('/').slice(0);
				for(var i=1;i<path.length;i++){
					path[i] = path[i-1]+ '/' +path[i];
				}
				return path;
			}


			// Locates a file by path

			function searchByPath(dir) {
				var path = dir.split('/'),
				demo = response,
				flag = 0;

				for(var i=0;i<path.length;i++){
					for(var j=0;j<demo.length;j++){
						if(demo[j].name === path[i]){
							flag = 1;
							demo = demo[j].items;
							break;
						}
					}
				}

				demo = flag ? demo : [];
				return demo;
			}


			// Recursively search through the file tree

			function searchData(data, searchTerms) {

				data.forEach(function(d){
					if(d.type === 'folder') {

						searchData(d.items,searchTerms);

						if(d.name.toLowerCase().match(searchTerms)) {
							folders.push(d);
						}
					}
					else if(d.type === 'file') {
						if(d.name.toLowerCase().match(searchTerms)) {
							files.push(d);
						}
					}
				});
				return {folders: folders, files: files};
			}


			/**
			 *  Render the HTML for the file manager
			 *  
			 *  it receives a list of data containing file and directories and put them in the dom
			 *  following a particular structure
			 */
			function render(data) {

				var scannedFolders = [],
				scannedFiles = [];

				if(Array.isArray(data)) {

					data.forEach(function (d) {

						if (d.type === 'folder') {
							scannedFolders.push(d);
						}
						else if (d.type === 'file') {
							scannedFiles.push(d);
						}

					});

				}
				else if(typeof data === 'object') {

					scannedFolders = data.folders;
					scannedFiles = data.files;

				}


				// Empty the old result and make the new one

				fileList.empty().hide();

				if(!scannedFolders.length && !scannedFiles.length) {
					filemanager.find('.nothingfound').show();
				}
				else {
					filemanager.find('.nothingfound').hide();
				}

				if(scannedFolders.length) {

					scannedFolders.forEach(function(f) {

						var itemsLength = f.items.length,
						name = escapeHTML(f.name),
						icon = '<span class="icon folder"></span>';

						if(itemsLength) {
							icon = '<span class="icon folder full"></span>';
						}

						if(itemsLength == 1) {
							itemsLength += ' item';
						}
						else if(itemsLength > 1) {
							itemsLength += ' items';
						}
						else {
							itemsLength = 'Empty';
						}

						/*
						 * a folder contains an href to the path of the file
						 */
						var folder = $('<li class="folders"><a href="'+ f.path +'" title="'+ f.path +'" class="folders">'+icon+'<span class="name">' + name + '</span> <span class="details">' + itemsLength + '</span></a></li>');

						folder.appendTo(fileList);
						
						/*
						 * A folder could be evaluable; if the case a "circular progress bar" is appended to the DOM
						 * in order to show the corresponding score.
						 */
						if(f.evaluable){

							var id = f.name + "_circle";
							var score = f.score;
							
							fileList.append("<div id=" + id + " class=circle data-size=60><div class='.score_label'></div></div>");

							//creates the progress bar
							var circle = $('#'+id).circleProgress({
								value: normalize(score),
								size: 70,
								fill: {
						            gradient: ["rgb(229, 249, 255)", "rgb(255, 255, 255)"]
						        }
							});


							circle.on('circle-animation-progress', function(e, v) {
								var obj = $(this).data('circle-progress'),
								ctx = obj.ctx,
								s = obj.size,
								sv = (100 * obj.value).toFixed(),
								fill = obj.arcFill;

								ctx.save();
								ctx.font = "bold " + s / 2.5 + "px sans-serif";
								ctx.textAlign = 'center';
								ctx.textBaseline = 'middle';
								ctx.fillStyle = fill;
								ctx.fillText(sv, s / 2, s / 2);
								ctx.restore();
							});

							/*
							 * This function is called when the progress bar is clicked. A modal is showed in which the user
							 * can modify the score of the corresponding folder
							 */	
							$('#' + id).click(function(){

								var score = $('.circle').circleProgress('value');
								$("#oldScore_modal").val(score*100);
								$("#scoreUpdate_modal").modal().show();
							});
						}

					});

				}

				if(scannedFiles.length) {

					scannedFiles.forEach(function(f) {

						var fileSize = bytesToSize(f.size),
						name = escapeHTML(f.name),
						fileType = name.split('.'),
						icon = '<span class="icon file"></span>';

						fileType = fileType[fileType.length-1];

						icon = '<span class="icon file f-'+fileType+'">.'+fileType+'</span>';

						var file = $('<li class="files"><a path="'+ f.path+'" title="'+ f.path +'" class="files visualizable">'+icon+'<span class="name">'+ name +'</span> <span class="details">'+fileSize+'</span></a></li>');
						file.appendTo(fileList);

						/*
						 * The modal "#visualizer" is used as a container to show different type of files
						 * When a file ".visualizable" is clicked the href of the <a> element of the modal
						 * is filled using the path of the file clicked. Then the modal is shown and the file
						 * is visualized.
						 * 
						 * You can also download or delete the file.
						 */
						$(".visualizable").click(function(){

							var path = $(this).attr("path");
							$("#visualizer").attr("href", "download?path=" + path);
							$('#visualizer_modal').modal('show');
							$("#visualizer").gdocsViewer({ width: '100%', height: '100%' });
							event.preventDefault();
						});
					});

				}


				// Generate the breadcrumbs

				var url = '';

				if(filemanager.hasClass('searching')){

					url = '<span>Search results: </span>';
					fileList.removeClass('animated');

				}
				else {

					fileList.addClass('animated');

					breadcrumbsUrls.forEach(function (u, i) {

						var name = u.split('/');

						if (i !== breadcrumbsUrls.length - 1) {
							url += '<a href="'+u+'"><span class="folderName">' + name[name.length-1] + '</span></a> <span class="arrow">></span> ';
						}
						else {
							url += '<span class="folderName">' + name[name.length-1] + '</span>';
						}

					});

				}

				breadcrumbs.text('').append(url);


				// Show the generated elements

				fileList.show();

			}


			// This function escapes special html characters in names

			function escapeHTML(text) {
				return text.replace(/\&/g,'&amp;').replace(/\</g,'&lt;').replace(/\>/g,'&gt;');
			}


			// Convert file sizes from bytes to human readable units

			function bytesToSize(bytes) {
				var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
				if (bytes == 0) return '0 Bytes';
				var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
				return Math.round(bytes / Math.pow(1024, i), 2) + ' ' + sizes[i];
			}

		});
});

function normalize(value){

	var max = 100;
	var min = 0;

	return (value - min)/(max - min);
}


/**
 * called when the download button is clicked
 */
$(document).ready(function(){

	$("#download_btn_modal").click(function(){
		var url = $("#visualizer").attr("href");
		var blob = new Blob([url]);
		var evt = document.createEvent("HTMLEvents");
		evt.initEvent("click");
		$("<a>", {
			download: url,
			href: webkitURL.createObjectURL(blob)
		}).get(0).dispatchEvent(evt);
	});
});

/**
 * called when the download button is clicked
 */
$(document).ready(function(){

	$("#delete_btn_modal").click(function(){
		var url = $("#visualizer").attr("href");
		$.get( "/contents/delete", {"path" : url}, function(data){

			if(data == true)
				window.location.replace("fileBrowser");
		});	
	});
});
