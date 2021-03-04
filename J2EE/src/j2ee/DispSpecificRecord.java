package j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;

public class DispSpecificRecord 
{
	public static void dSR() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
//		Enumeration e=DriverManager.getDrivers();
//		while(e.hasMoreElements())
//		{
//			System.out.println(e.nextElement());
//		}		
		
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
//		System.out.println(c);
		
		String q="Select * from new_table where sId=?";
		PreparedStatement stmt=c.prepareStatement(q);
		
		System.out.println("Enter the Id of student whose Record Need to be displayed");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		stmt.setInt(1, x);
		ResultSet r=stmt.executeQuery();
		
		//displaying Specific records
		System.out.println();
		while(r.next())
		{
			System.out.println(r.getInt("sId")+" "+r.getString("sName")+" "+r.getDouble("sMarks"));
		}
		System.out.println();
		
		stmt.close();
		c.close();
	}
	
}
