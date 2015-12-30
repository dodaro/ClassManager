<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	var data = ${map};
</script>

<p>
<button type="button" onClick="sendData()" class="btn btn-default">Update Scores</button>
</p>
<table id="scores_table" class="table table-bordered table-condensed">
</table>