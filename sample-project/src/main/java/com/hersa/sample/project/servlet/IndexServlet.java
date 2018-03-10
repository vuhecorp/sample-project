package com.hersa.sample.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hersa.sample.project.ClientContext;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*	@Autowired
	private ApplicationContext applicationContext; */   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
			ClientContext clientContext = (ClientContext) applicationContext.getBean("clientContext", ClientContext.class);
//			boolean welcome = clientContext.getClientSettings().isDispWelcomePage();
			boolean welcome = clientContext.getDisplayWelcomePage().getBooleanValue();
			if (welcome) {
				response.sendRedirect("themes/" + clientContext.getClient().getClientId()+ "/pages/index.xhtml");
			}else {
				response.sendRedirect("signon/signon.xhtml");
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
