

import java.sql.*;
import java.util.Scanner;

public class Emp_database  {

	static String connection="com.mysql.jdbc.Driver";
	static String db_url = "jdbc:mysql://localhost:3306/java";
	static String db_uname = "root";
	static String db_upass = "root";
	 static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		insertEmp();
		selectEmp();
		updateEmp();
		deleteEmp();
	}
	
	public static  void insertEmp()
	{
		try {
			System.out.println("Enter id :");
			int x1=sc.nextInt();
			System.out.println("Enter name :");
			String x2=sc.next();
			System.out.println("Enter sal :");
			int x3=sc.nextInt();
			
			Class.forName(connection);
			Connection con = DriverManager.getConnection(db_url,db_uname,db_upass);
			PreparedStatement st = con.prepareStatement("insert into employee (id,name,salary) values('"+x1+"','"+x2+"','"+x3+"')");
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectEmp()
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/java";
			String db_uname = "root";
			String db_upass = "root";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			String q = "Select * from employee";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(q);
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3));
			}
			System.out.println("Data Displayed");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void updateEmp()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/java";
			String db_uname = "root";
			String db_upass = "root";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			PreparedStatement st = con.prepareStatement("update employee set name=?,salary=? where id=?");
			st.setString(1,"aman");
			st.setInt(2, 56320);
			st.setInt(3, 1);
			st.executeUpdate();
			System.out.println("Data Updated..!");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		

	}
	}
	
	
	
	public static void deleteEmp()
	{
		System.out.println("Enter the Employee No to delete");
		String s1=sc.next();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/java";
			String db_uname = "root";
			String db_upass = "root";
			Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
			PreparedStatement st = con.prepareStatement("delete from employee where id="+s1);
			// Statement st=con.createStatement();
			st.executeUpdate();
			System.out.println("Data DELETED..!");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

}
