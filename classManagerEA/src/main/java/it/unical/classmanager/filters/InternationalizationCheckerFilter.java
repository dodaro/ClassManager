package it.unical.classmanager.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Servlet Filter implementation class InternationalizationCheckerFilter
 */
public class InternationalizationCheckerFilter implements Filter {
	

    /**
     * Default constructor. 
     */
    public InternationalizationCheckerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		

		String localeParam = httpRequest.getParameter("locale");
		
		if(localeParam != null) {
			if(!(localeParam.equals("it") && localeParam.equals("en"))) {
				
				/*
				 * TODO: evitare di far passare il parametro
				 */
				
				chain.doFilter(request, response);
				return;
			}
		}
		
		

		Map<String, Cookie> cookieMap = new HashMap<String, Cookie> ();
		Cookie[] cookies = httpRequest.getCookies();

		for(Cookie cookie : cookies){
		    cookieMap.put(cookie.getName(), cookie);
		}
		
		Cookie tmpCookie = cookieMap.get("localeLang");

		if(tmpCookie == null) {
			
			tmpCookie = new Cookie("localeLang", "it");
			httpResponse.addCookie(tmpCookie);
			
		}
		else {
			String localeLang = tmpCookie.getValue();
			
			if(!(localeLang.equals("it") && localeLang.equals("en"))) {
				
				tmpCookie.setMaxAge(0);
				Cookie newCookie = new Cookie("localeLang", "it");
				httpResponse.addCookie(newCookie);
				
			}
		}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
