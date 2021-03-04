package j2ee;

import java.util.Scanner;

public class Mains 
{
	public static void main(String[] args) throws Exception 
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1:Add\t2:Display Specific Record \t3:Update\t4:Delete\t5:Display All\t0:Exit");			
			int x=sc.nextInt();
			switch(x)
			{
			case 1:AddRecord.add();
			break;
			case 2:DispSpecificRecord.dSR();
			break;
			case 3:Update.update();
			Display.display();
			break;
			case 4:Delete.delete();
			Display.display();
			break;
			case 5:Display.display();
			break;
			default:System.out.println("Bye Bye!"); 
				System.exit(0);
			}
		}
	}
}
