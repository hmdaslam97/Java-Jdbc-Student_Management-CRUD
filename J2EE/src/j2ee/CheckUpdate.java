package j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Scanner;

public class CheckUpdate 
{
	public static void main(String[] args) throws Exception 
	{
		{
			Class.forName("com.mysql.jdbc.Driver");
			Enumeration e=DriverManager.getDrivers();
//			while(e.hasMoreElements())
//			{
//				System.out.println(e.nextElement());
//			}		
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
//			System.out.println(c);
			
			String q="Select * from new_table where Match(sName)Against(Kumar)";
			PreparedStatement stmt=c.prepareStatement(q);
//			System.out.println("Enter the Name of Student");
//			Scanner sc=new Scanner(System.in);
//			String x=sc.next();
//			stmt.setString(1, "Kumar");
			ResultSet r=stmt.executeQuery(q);
			
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
}
