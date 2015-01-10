package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import Connection.ServiceProxy;
import model.Category;
/**
 * Servlet implementation class SignUp
 */
public class signIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signIn() {
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
			 	String email = request.getParameter("email");
			 	String pass = request.getParameter("pass");
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.signIn(email,pass);
				HttpSession session = request.getSession();
				//session.setAttribute("email",email);
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("email", email);
					session.setAttribute("message","");
					//Category[] cList = proxy.getCategory("select * from category");
					//request.setAttribute("result", cList);
					//RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					//rd.forward(request, response);
					
					response.sendRedirect("/Lab2Client/View/main?cid=0");
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
					out.println(qdone.substring(6));
					//out.println("\n <a href=\"signIn.jsp\"><br> Go back to signIn again</a>");
					//out.println("Wrong email or password");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
