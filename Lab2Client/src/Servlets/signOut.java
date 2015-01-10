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
 * Servlet implementation class signOut
 */
public class signOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone;		 
		 try{	
			 	HttpSession session = request.getSession();
				String email = (String)session.getAttribute("email");
			    proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.signOut(email);
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("email",null);
					RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
					rd.forward(request, response);	
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
					out.println("logOut failed");
					rd.include(request,response);
				}
				
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
