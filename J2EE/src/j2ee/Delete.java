package j2ee;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete 
{
	public static void delete() throws SQLException 
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
			String q="Delete from new_table "+
					"where sId=?";
			PreparedStatement stmt=con.prepareStatement(q);
			System.out.println("Enter the Id of Student Whose record should be Deleted");
			int sId=sc.nextInt();
			stmt.setInt(1, sId);
			
			int x=stmt.executeUpdate();
			System.out.println(x+" Row Deleted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
