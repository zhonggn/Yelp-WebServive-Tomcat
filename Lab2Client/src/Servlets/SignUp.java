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

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone;		 
		 try{			
			    String fname = request.getParameter("fname");
			 	String lname = request.getParameter("lname");
			    String email = request.getParameter("email");
			 	String pass = request.getParameter("pass");
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.signUp(fname, lname, email,pass);
				HttpSession session = request.getSession();
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("userSession", session);
					//out.println("WELCOME to yelp :"+ email);//Displaying the message on the servlet itself.
					RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
					rd.forward(request, response);
					
				}else if(qdone.substring(0,5).equals("Exist")){
					session.setAttribute("userSession", session);
					RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
					out.println("Please use another email!");
					rd.include(request,response);
				}else{
					out.println(qdone.substring(6));
					out.println("\n <a href=\"SignUp.jsp\"><br>Go back to SignUp again</a>");
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
