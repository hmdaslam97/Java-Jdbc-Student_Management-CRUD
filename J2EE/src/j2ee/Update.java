package j2ee;

import java.sql.*;
import java.util.Scanner;

public class Update 
{
	public static void update() throws Exception 
	{
		//1
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
//		System.out.println(d);
		
		//2
		String db="jdbc:mysql://localhost:3306/test?user=root&password=root";
		Connection con=DriverManager.getConnection(db);
//		System.out.println(con);
		
		Scanner sc=new Scanner(System.in);
		try
		{
			String q="update new_table "+
					"set sMarks=? where sId=?";
			String q1="update new_table "+
					"set sName=? where sId=?";
			String q2="select sId,sName from test.new_table where sName like ?";
			
			while(true)
			{
				System.out.println("Update\nMarks:1\tName:2\tReturn to Main:0");
				int x=sc.nextInt();
				switch(x)
				{
				case 1:PreparedStatement stmt=con.prepareStatement(q);
				System.out.println("Enter Id of student whose marks need to be updated");
				int id1=sc.nextInt();
				System.out.println("Enter Marks to be updated");
				double m1=sc.nextDouble();
				stmt.setDouble(1, m1);
				stmt.setInt(2, id1);
				
				int x1=stmt.executeUpdate();
				System.out.println(x1+" Row Updated");
				stmt.close();
				break;
				
				case 2:				
				PreparedStatement stmt2=con.prepareStatement(q2);
				System.out.println("Enter Name to be updated");
				String s1=sc.next();
				
				stmt2.setString(1, s1);
				
				ResultSet rr=stmt2.executeQuery(q2);								
				while(rr.next())
				{
					System.out.println(rr.getInt("sId")+" "+rr.getString("sName")+" "+rr.getDouble("sMarks"));
				}
				
				PreparedStatement stmt1=con.prepareStatement(q1);
				int x2=stmt1.executeUpdate();
				System.out.println("Enter Id of student whose marks need to be updated");
				int id2=sc.nextInt();
				
				stmt1.setString(1, s1);
				stmt1.setInt(2, id2);				
				System.out.println(x2+" Row Updated");
				stmt1.close();
				stmt2.close();
				break;
				
				default:return;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		con.close();
		DriverManager.deregisterDriver(d);
	}
}
