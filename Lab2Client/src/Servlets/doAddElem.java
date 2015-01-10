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
/**
 * Servlet implementation class doAddElem
 */
public class doAddElem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy=new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddElem() {
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
			 	String ename = request.getParameter("inputElemName");
			 	String des = request.getParameter("inputDecription");
			 	String rate = request.getParameter("inputRate");
			 	String catName = request.getParameter("inputCatName");
			 	String review = request.getParameter("inputReviews");
			 	String email = (String)session.getAttribute("email");
			 	User[] user = proxy.getUser("select * from users where emailid = '"+email+"'");
			 	int uid = user[0].getUid();
			 	proxy.setEndpoint("http://localhost:8080/Lab2/services/Service");
				qdone = proxy.addElement(ename, des, rate, catName, review, uid );
				//HttpSession session = request.getSession();
				//session.setAttribute("email",email);
				if(qdone.substring(0,4).equals("true")){
					Category[] cList = proxy.getCategory("select * from category");
					RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
					request.setAttribute("category", cList);
					out.println("Add element successfully");
					rd.include(request,response);
					
				}else if(qdone.substring(0,2).equals("no")){
					RequestDispatcher rd = request.getRequestDispatcher("addElement.jsp");
					out.println("No match category");
					rd.include(request,response);
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("addElement.jsp");
					out.println("element already exist");
					rd.include(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
