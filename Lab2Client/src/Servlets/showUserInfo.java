package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Connection.ServiceProxy;
import javax.servlet.http.HttpSession;
import model.Category;
import model.User;
import model.Review;

/**
 * Servlet implementation class showUserInfo
 */
public class showUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//String qdone;		 
		 try{	
			    //System.out.println("show something");
			    HttpSession session = request.getSession();
			    String email = (String)session.getAttribute("email");
			    System.out.println("woshi"+email);
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				User[] user = proxy.getUser("select * from users where emailid = '"+email+"'");
				User currUser = user[0];
				int uid = currUser.getUid();
				Review[] review = proxy.getReview(uid);
				request.setAttribute("user", currUser);
				request.setAttribute("review", review);
				RequestDispatcher rd = request.getRequestDispatcher("showUserInfo.jsp");
				rd.forward(request, response);
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
