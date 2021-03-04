package j2ee;
import java.sql.*;
import java.util.Scanner;

public class AddRecord 
{
	public static void add() throws Exception 
	{
		//1
		Driver d=new com.mysql.jdbc.Driver();
//		System.out.println(d);
		DriverManager.registerDriver(d);
		
		//2
		String db="jdbc:mysql://localhost:3306/test?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
//		System.out.println(con);
		
		Scanner sc=new Scanner(System.in);
		//3
		try
		{
			String q="Insert into new_table values (?,?,?)";
			PreparedStatement stmt=con.prepareStatement(q);
			
			System.out.println("Enter ID ");
			int sId=sc.nextInt();
			System.out.println("Enter Name ");
			String sName=sc.next();
			System.out.println("Enter marks ");
			double sMarks=sc.nextDouble();
			
			stmt.setInt(1, sId);
			stmt.setString(2, sName);
			stmt.setDouble(3, sMarks);
			
			int x=stmt.executeUpdate();
			System.out.println(x+" row updated");
			
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		con.close();
		DriverManager.deregisterDriver(d);
	}
}
