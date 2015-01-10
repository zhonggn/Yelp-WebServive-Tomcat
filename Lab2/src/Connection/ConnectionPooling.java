package Connection;

import java.sql.*;

import java.util.HashMap;
import model.Category;
import model.User;
import model.Element;
import model.Review;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
public class ConnectionPooling {
	
	Connection con = null;
	static ResultSet rs1;
	static ResultSet rs;
    Statement stmt = null;
	private HttpServletRequest request;
	boolean [] isAv = null;
    Connection [] cons = null;
    
    private HashMap<Integer, Statement> getStatement(){
    	
    	int i = 0;
    	while(true){
    		if(i == 10){i = 0;}
    		if(isAv[i] == true){
    			
    			System.out.println("Lease connection #" + i);
    			isAv[i] = false;
    			try {
    				
    				HashMap<Integer, Statement> hm = new HashMap<Integer, Statement>();
    				hm.put(i, cons[i].createStatement());
					return hm;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		else{
    			
    			i ++;
    		}
    	}
    }
    
    private void returnStatement(int i){
    	
    	isAv[i] = true;
    }
	
	public ConnectionPooling(){		
		try {			
				isAv = new boolean [10];
				cons = new Connection[10];
				for(int i = 0; i < 10; i ++){
					
					isAv[i] = true;
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection tmp = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp","root","");
					cons[i] = tmp;
				}
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp","root","");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("db connection created.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public String signOut(String email){
		String result = "";
		int rowcount;
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(cal.getTime());
			String updateSql =  "update users set llogin = '"+time+"' where emailid='"+email+"'";
			rowcount = stmt.executeUpdate(updateSql);
			if(rowcount > 0){
				result="true";
				System.out.println("Insert Successful");
			}
			else{
				result="false: update llogtime failed.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
		
	}
	
	public String signUp(String fname, String lname, String useremail, String pwd){
		String result = "";
		
		int rowcount;
		try {
			String checkExistQuery = "select * from users where emailid = '"+useremail+"'";
			rs1=stmt.executeQuery(checkExistQuery);
			if(rs1.next()){
				result="Exist";
			}else{
				String query = "Insert into users (firstname, lastname, emailid, password) values ('"+fname+"','"+lname+"','" + useremail + "', '" + pwd + "')";
				rowcount=stmt.executeUpdate(query);
				if(rowcount > 0){
					result="true";
					System.out.println("Insert Successful");
				}
				else{
					result="false: The data could not be inserted in the database.";
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String signIn(String useremail, String pwd){
		String result = "";
		// rowcount;
		try {
			String query = "select * from users where emailid = '" + useremail + "' and password = '" + pwd + "'";
			//String query = "select * from users";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			if(rs.next()){
				result="true";
				//while(rs.next()){
				//System.out.println(rs.getString(2));
				//}
				System.out.println("SignIn Successful");
			}
			else{
				result="false: Wrong email or password.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Category[] getCategory(String sql){
		List<Category> cl = new ArrayList<Category>();
		try {
			//String query = "select * from category";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Category cat = new Category();
				int id = rs.getInt(1);
				System.out.println("id:" + id);
				cat.setCid(id);
				String name = rs.getString(2);
				System.out.println("name: " + name);
				cat.setCname(name);
				cl.add(cat);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		int size = cl.size();
		Category[] result=new Category[size];
		for(int i=0; i<size; i++){
			result[i] = cl.get(i);
		}
		return result;
	}
	
	public User[] getUser(String sql){
		List<User> ul = new ArrayList<User>();
		try {
			
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				User user = new User();
				int id = rs.getInt(1);
				System.out.println("id:" + id);
				user.setUid(id);
				String fname = rs.getString(2);
				System.out.println("firstname: " + fname);
				user.setFname(fname);
				String lname = rs.getString(3);
				user.setLname(lname);
				String email = rs.getString(4);
				user.setEmail(email);
				String ltime = rs.getString(6);
				user.setLtime(ltime);
				ul.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		int size = ul.size();
		User[] result=new User[size];
		for(int i=0; i<size; i++){
			result[i] = ul.get(i);
		}
		return result;
	}
	
	public Review[] getReview(int uid){
		List<Review> rl = new ArrayList<Review>();
		try {
			String eleinfo = "select ename, content, rate from reviews join element on reviews.eid=element.eid where uid='"+uid+"'";
			System.out.println(eleinfo);
			rs=stmt.executeQuery(eleinfo);
			
			while(rs.next()){
				Review rv = new Review();
				String ename = rs.getString(1);
				System.out.println("ename:" + ename);
				rv.setEname(ename);
				String content = rs.getString(2);
				System.out.println("content: " + content);
			    rv.setContent(content);
				double rate = rs.getDouble(3);
				rv.setRate(rate);
				rl.add(rv);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		int size = rl.size();
		Review[] result=new Review[size];
		for(int i=0; i<size; i++){
			result[i] = rl.get(i);
		}
		return result;
	}
	
	public Element getElemInfo(String sql){
		Element result = new Element();
		try {
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String des = rs.getString(3);
				double rate = rs.getDouble(4);
				int cid = rs.getInt(5);
				result.setEid(id);
				result.setEname(name);
				result.setDescription(des);
				result.setRating(rate);
				result.setCid(cid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
		
	}
	
	//get the all the elements with the cid = cid
	public Element[] getElement(Integer cid){
		List<Element> el = new ArrayList<Element>();
		try {
			String eleSql = "select * from element join category on element.cid = category.cid where category.cid='"+cid+"'";
			System.out.println(eleSql);
			rs=stmt.executeQuery(eleSql);
			
			while(rs.next()){
				Element elem = new Element();
				int id = rs.getInt(1);
				System.out.println("id:" + id);
				elem.setEid(id);
				String ename = rs.getString(2);
				System.out.println("elemName: " + ename);
			    elem.setEname(ename);
				String description = rs.getString(3);
				elem.setDescription(description);
				double rate = rs.getDouble(4);
				elem.setRating(rate);
				elem.setCid(cid);
				el.add(elem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		int size = el.size();
		Element[] result=new Element[size];
		for(int i=0; i<size; i++){
			result[i] = el.get(i);
		}
		return result;
	}
	public String deleteElem(String ename){
		String result = "";
		int rowcount;
		try {
			String query = "select * from element where ename = '"+ename+"'";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			if(rs.next()){
				String deleteSql = "delete from element where ename = '"+ename+"'";
				rowcount=stmt.executeUpdate(deleteSql);
			    if(rowcount > 0){
			    	result="true";
			    	System.out.println("delete Successful");
			    }else{
			    	result="false: The data could not be deleted from the database.";
			    }
				
			}else{
				
				result="false: category does not exist.";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
	
	public String deleteCat(String cname){
		String result = "";
		int rowcount;
		try {
			String query = "select * from category where cname = '"+cname+"'";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			if(rs.next()){
				String deleteSql = "delete from category where cname = '"+cname+"'";
				rowcount=stmt.executeUpdate(deleteSql);
			    if(rowcount > 0){
			    	result="true";
			    	System.out.println("delete Successful");
			    }else{
			    	result="false: The data could not be deleted from the database.";
			    }
				
			}else{
				
				result="false: category does not exist.";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
	public String addCategory(String cname){
		String result = "";
		int rowcount;
		try {
			String query = "select * from category where cname = '"+cname+"'";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			if(rs.next()){
				result="false: category already exist.";
			}else{
				String insertCat = "insert into category(cname) values('"+cname+"')";
				rowcount=stmt.executeUpdate(insertCat);
			    if(rowcount > 0){
			    	result="true";
			    	System.out.println("Insert Successful");
			    }else{
			    	result="false: The data could not be inserted in the database.";
			    }
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
	
	public String addreview(String review, String rate, String eleid, String email){	
		String result = "";
		int rowcount;
		int rowcount2=0;
		try {
			String uidSql="select * from users where emailid = '"+email+"'";
			rs = stmt.executeQuery(uidSql);
			int uid=0;
			if(rs.next()){
				uid = rs.getInt(1);
			}
			String insertSql = "insert into reviews(uid,eid,content,rate) values('"+uid+"','"+eleid+"','"+review+"','"+rate+"')";
			rowcount=stmt.executeUpdate(insertSql);
			
			String avgSql = "select AVG(rate) as avg_rate from reviews where eid = '"+eleid+"'";
			rs1 = stmt.executeQuery(avgSql);
			if(rs1.next()){
				double avgRate = rs1.getDouble(1);
				String updateSql = "update element set rating = "+avgRate+" where eid='"+eleid+"'";
				rowcount2 = stmt.executeUpdate(updateSql);
			}
			if(rowcount > 0 && rowcount2 > 0){
				result="true";
				System.out.println("Insert Successful");
			}else{
				result="false: The review could not be inserted in the database.";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
	
	public String addElement(String ename, String des, String rate, String cname, String review, int uid){
		String result = "";
		int rowcount;
		
		try {
			String query = "select * from element where ename = '"+ename+"'";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			if(rs.next()){
				result="false: element already exist.";
			}else{
				String getCid = "select cid from category where cname = '"+cname+"'";
				ResultSet rsCid;
				rsCid = stmt.executeQuery(getCid);
				int cid;
				if(rsCid.next()){
					cid = rsCid.getInt(1);
					String insertElem = "insert into element(ename, description, rating, cid) values('"+ename+"', '"+des+"', '"+rate+"', '"+cid+"')";
					rowcount=stmt.executeUpdate(insertElem);
					String eleSql = "select * from element where ename = '"+ename+"'";
					ResultSet rseid = stmt.executeQuery(eleSql);
					int rowcountReview=0;
					if(rseid.next()){
						int eid = rseid.getInt(1);
						String insertReview = "insert into reviews(uid, eid,content, rate) values('"+uid+"','"+eid+"','"+review+"','"+rate+"')";
						rowcountReview = stmt.executeUpdate(insertReview);
					}
					
					if(rowcount > 0 && rowcountReview > 0){
				    	result="true";
				    	System.out.println("Insert Successful");
				    }else{
				    	result="false: The data could not be inserted in the database.";
				    }
				}else{
					result = "no such category";
				}	
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
}
