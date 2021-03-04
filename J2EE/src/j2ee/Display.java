package j2ee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Display 
{
	public static void display() throws Exception
	{
		//1
		Driver d=new com.mysql.jdbc.Driver();
//		System.out.println(d);
		DriverManager.registerDriver(d);
		
		//2
		String db="jdbc:mysql://localhost:3306/test?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
//		System.out.println(con);
		
		//3
		String q="Select * from new_table";
		Statement stmt=con.createStatement();
		ResultSet r=stmt.executeQuery(q);
		
		//displaying records
		System.out.println();
		while(r.next())
		{
			System.out.println(r.getInt("sId")+" "+r.getString("sName")+" "+r.getDouble("sMarks"));
		}
		System.out.println();
		
		//5
		stmt.close();
		con.close();
		DriverManager.deregisterDriver(d);
	}
}
