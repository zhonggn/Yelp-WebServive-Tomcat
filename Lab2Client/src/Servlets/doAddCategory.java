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
 * Servlet implementation class doAddCategory
 */
public class doAddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddCategory() {
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
			 	String cname = request.getParameter("inputCategory");
			 	
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.addCategory(cname);
				//HttpSession session = request.getSession();
				//session.setAttribute("email",email);
				if(qdone.substring(0,4).equals("true")){
					Category[] cList = proxy.getCategory("select * from category");
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					request.setAttribute("category", cList);
					out.println("Add category successfully");
					rd.include(request,response);
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("addCategory.jsp");
					//out.println(qdone.substring(6));
					//out.println("\n <a href=\"signIn.jsp\"><br> Go back to signIn again</a>");
					out.println("category already exist");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
