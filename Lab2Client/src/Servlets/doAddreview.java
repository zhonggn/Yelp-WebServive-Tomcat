package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ServiceProxy;

import javax.servlet.http.HttpSession;

import model.Category;
import model.User;
import model.Review;
/**
 * Servlet implementation class doAddElem
 */
public class doAddreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddreview() {
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
		String qdone;		 
		 try{	
			    HttpSession session = request.getSession();
			 	String review = request.getParameter("inputReview");
			 	String rate = request.getParameter("inputRate");
			 	String eleid = request.getParameter("inputEleId");
			 	String email = (String)session.getAttribute("email");
			 	
			 	System.out.println("my email is :" + email);
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
			 	
				qdone = proxy.addreview(review, rate, eleid, email);
				//HttpSession session = request.getSession();
				//session.setAttribute("email",email);
				if(qdone.substring(0,4).equals("true")){
					User[] user = proxy.getUser("select * from users where emailid = '"+email+"'");
					User currUser = user[0];
					int uid = currUser.getUid();
					Review[] rv = proxy.getReview(uid);
					request.setAttribute("user", currUser);
					request.setAttribute("review", rv);
					RequestDispatcher rd = request.getRequestDispatcher("showUserInfo.jsp");
					rd.forward(request, response);
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					out.println("add review fail");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
