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
 * Servlet implementation class doDeleteCat
 */
public class doDeleteCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDeleteCat() {
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
			 	String catName = request.getParameter("inputCategory");
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.deleteCat(catName);
				HttpSession session = request.getSession();
				
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("message","Category delete successfully");
					response.sendRedirect("/Lab2Client/View/main?cid=0");
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("deleteCat.jsp");
					//out.println(qdone.substring(6));
					//out.println("\n <a href=\"signIn.jsp\"><br> Go back to signIn again</a>");
					out.println("category does not exist");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
