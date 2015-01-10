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
import model.Category;

/**
 * Servlet implementation class addCategory
 */
public class addCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//String qdone;		 
		 try{			
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				
				//HttpSession session = request.getSession();
				//session.setAttribute("email",email);
				RequestDispatcher rd = request.getRequestDispatcher("addCategory.jsp");
				rd.forward(request, response);
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
