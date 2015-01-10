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
 * Servlet implementation class doDeleteElem
 */
public class doDeleteElem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDeleteElem() {
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
			 	String ename = request.getParameter("inputElemName");
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.deleteElem(ename);
				HttpSession session = request.getSession();
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("message","Element delete successfully");
					response.sendRedirect("/Lab2Client/View/main?cid=0");
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("deleteElem.jsp");
					out.println("element does not exist");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
