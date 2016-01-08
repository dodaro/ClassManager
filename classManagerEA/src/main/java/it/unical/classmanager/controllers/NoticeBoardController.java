package it.unical.classmanager.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.unical.classmanager.model.PasswordHashing;
import it.unical.classmanager.model.dao.CommunicationsDAO;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.data.Communications;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.DateTimeFactory;


@Controller
public class NoticeBoardController {

	@Autowired
	private ApplicationContext context;
	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
	private final static String HEADER = "noticeboard/noticeboardHeader.jsp";
	private final static String BODY = "noticeboard/noticeboardBody.jsp";
	
	/**
	 * returns the notice board
	 */
	@RequestMapping(value = "/noticeboard", method = RequestMethod.GET)
	public String noticeBoard(Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		
		/**
		 * handle errors like this, add the RedirectAttributes to the method and add the parameter to pass
		 * this methods redirect passing parameters
		 */
		if ( request.getSession().getAttribute("loggedIn") == null || request.getSession().getAttribute("role") == null ) {
			redirectAttributes.addAttribute("error", "session");
			return "redirect:/sessionerror";
		}
		
		
		
		String init = request.getParameter("init");
		if ( init != null && init.equals("1") ) {
			User user = new User();
			user.setUsername("professorUser");
			user.setFirstName("asd");
			user.setLastName("Rullo");
			user.setPassword("asdasdasd");
			user.setConfirmPassword(user.getPassword());
			user.setHash(PasswordHashing.getInstance().getHashAndSalt(user.getPassword()));
			user.setEmail("email@email.it");
			user.setRole("Professor");
			user.setBirthDate(DateTimeFactory.getRandomDateLessThanYear(
					Calendar.getInstance().get(Calendar.YEAR)-18).getTime());
		
			Professor professor = new Professor(user);
			UserDAO userDao = (UserDAO) context.getBean("userDao");
			userDao.create(professor);
			
			CommunicationsDAO communicationsDAO = (CommunicationsDAO) context.getBean("communicationsDAO");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy-HH:mm");
			for ( int i = 0 ; i < 25 ; i++ ) {
				String stringdate = sdf.format(Calendar.getInstance().getTime());
				Communications comm;
				try {
					comm = new Communications(0, "nuovo messaggio", "testo del messaggio",professor,sdf.parse(stringdate));
					communicationsDAO.create(comm);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			userDao.update(professor);
		}
		
		
		PagedListHolder<Communications> communicationsPage = (PagedListHolder<Communications>) request.getSession().getAttribute("noticesList");
		CommunicationsDAO communicationsDao = (CommunicationsDAO) context.getBean("communicationsDAO");
		if ( communicationsPage == null ) {
			communicationsPage = new PagedListHolder<Communications>(communicationsDao.getAllCommunications());
		} else {
			communicationsPage.setSource(communicationsDao.getAllCommunications());
		}

		
		int noticesPerPage = ( request.getParameter("notices") != null ) ? Integer.parseInt(request.getParameter("notices")) : -1;
		if ( noticesPerPage != -1 ) {
			if ( noticesPerPage < 10 )
				noticesPerPage = 10;
			if ( noticesPerPage > 100 ) {
				noticesPerPage = 100;
			}
		} else {
			noticesPerPage = communicationsPage.getPageSize();
		}
			
		
		
		int pageToGet = ( request.getParameter("page") != null ) ? Integer.parseInt(request.getParameter("page")) : -1;
		if ( pageToGet != -1 ) {
			communicationsPage.setPage(pageToGet -1 );
		}
		
		communicationsPage.setPageSize(noticesPerPage);
		request.getSession().setAttribute("noticesList", communicationsPage);
		model.addAttribute("pageSize", noticesPerPage);
		model.addAttribute("customHeader", NoticeBoardController.HEADER);
		model.addAttribute("customBody", NoticeBoardController.BODY);
		
		int pageNumber = communicationsPage.getPage() + 1;
		int pageCount = communicationsPage.getPageCount();
		
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageCount",pageCount);

		return "layout";
			
	}
	
}