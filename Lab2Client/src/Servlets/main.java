package Servlets;
import model.Category;
import model.Element;
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
 * Servlet implementation class main
 */
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
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
			 	int cid = Integer.parseInt(request.getParameter("cid"));
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				Category[] cList = proxy.getCategory("select * from category");
				request.setAttribute("category", cList);
				//request.getRequestDispatcher("main.jsp").forward(request,response);
				if(cid != 0){
					Element[] eles = proxy.getElement(cid);
					if(eles != null){
						request.setAttribute("element", eles);
						
					}
				}
				request.getRequestDispatcher("main.jsp").forward(request,response);
				
				
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
