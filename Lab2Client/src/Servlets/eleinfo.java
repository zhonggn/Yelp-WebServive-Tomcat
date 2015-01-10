package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Connection.ServiceProxy;
import model.Category;
import model.Element;

/**
 * Servlet implementation class eleinfo
 */
public class eleinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eleinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 
		 try{			
			 	int eid = Integer.parseInt(request.getParameter("eid"));
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				Element eleinfo = proxy.getElemInfo("select * from element where eid = '"+eid+"'");
				request.setAttribute("eleinfo", eleinfo);
				request.getRequestDispatcher("eleinfo.jsp").forward(request,response);
				
				
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
