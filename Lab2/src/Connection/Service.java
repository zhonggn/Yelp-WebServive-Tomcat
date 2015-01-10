package Connection;

import javax.jws.WebService;
import model.Category;
import model.User;
import model.Element;
import model.Review;
@WebService
public class Service {	
	DatabaseConnection db=new DatabaseConnection();
	//ConnectionPooling db=new ConnectionPooling();
	public String signUp(String fname, String lname, String useremail, String pwd)
	{
		System.out.println("Inside Signup");
		String result;
		
		/**This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation*/
		
		result = db.signUp(fname, lname, useremail,pwd);
		
		return result;//this value is returned to the calling servlet
	}	
	public String signIn(String useremail, String pwd)
	{
		System.out.println("Inside SignIn");
		String result;
		
		/**This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation*/
		
		result = db.signIn(useremail,pwd);
		
		return result;//this value is returned to the calling servlet
	}	
	
	public Category[] getCategory(String sql){
		System.out.println("Inside getCategory");
		Category[] result = db.getCategory(sql);
		return result;
	}
	public User[] getUser(String sql){
		System.out.println("Inside getUser");
		User[] result = db.getUser(sql);
		return result;
	}
	public String addCategory(String sql){
		System.out.println("Inside add category");
		String result = db.addCategory(sql);
		return result;
	}
	public String addElement(String ename, String des, String rate, String catName, String review, int uid){
		System.out.println("Inside add element");
		String result = db.addElement(ename, des, rate, catName, review, uid);
		return result;
	}
	public Element[] getElement(Integer cid){
		System.out.println("Inside getElement");
		Element[] result = db.getElement(cid);
		return result;
	}
	public Element getElemInfo(String sql){
		System.out.println("Inside getElemInfo");
		Element result = db.getElemInfo(sql);
		return result;
	}
	public String addreview(String review, String rate, String eleid, String email){
		System.out.println("Inside addreview");
		String result = db.addreview(review, rate, eleid, email);
		return result;
	}
	//return an array of object Review, review has ename, content, rating
	public Review[] getReview(int uid){
		System.out.println("Inside getReview");
		Review[] result = db.getReview(uid);
		return result;
	}
	public String signOut(String email){
		System.out.println("Inside signOut");
		String result = db.signOut(email);
		return result;
	}
	public String deleteCat(String cname){
		System.out.println("Inside deleteCat");
		String result = db.deleteCat(cname);
		return result;
	}
	public String deleteElem(String ename){
		System.out.println("Inside deleteElem");
		String result = db.deleteElem(ename);
		return result;
	}
	
}
