package j2ee;

import java.sql.*;
import java.util.Scanner;

public class DisplayDupNames 
{
	public static void main(String[] args) throws Exception 
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d); 
//		System.out.println(d);
		
		String db="jdbc:mysql://localhost:3306/test?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
//		System.out.println(con);
		
		Scanner sc=new Scanner(System.in);
		try
		{
			String q="Select * from new_table where sName like '%?%'";
			PreparedStatement stmt=con.prepareStatement(q);
			System.out.println("Enter the Name ");
			String n=sc.next();
			stmt.setString(1, n);
			
			ResultSet r=stmt.executeQuery();
			
			System.out.println();
			while(r.next())
			{
				System.out.println(r.getInt("sId")+" "+r.getString("sName")+" "+r.getDouble("sMarks"));
			}
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
