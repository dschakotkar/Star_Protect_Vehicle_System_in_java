package login;

import login.UnderWriter;
import java.util.*;
import login.Admin;
import login.UnderWriter1;

public class Star_Protect_Vehicle_System 
{
	private static Scanner sc;

	public static void main(String[] args) {
		int choose;
		sc = new Scanner(System.in);
		
		System.out.println("----Welcome to the Star Protect Vehicle------- ");
		
		System.out.println("----Enter the 1 for Admin Login :");
		System.out.println("----Enter the 2 for UnderWriter Login :");
		choose=sc.nextInt();
		
		UnderWriter1[] UW1=null;
		switch(choose)
		{
		case 1:
			Admin.AdminLogin();
			break;
		case 2:
			//UW1=anotherMethod(UW1);
			if(choose!=2)
			{
				UnderWriter.UnderWriterLogin(UW1);
			}
			else{
				System.out.println("First Admin have to register the Underwriter..");
				System.out.println("We don't have registerd any UnderWriter yet...");
				System.out.println("Please wait till Admin register .");
				System.out.println();
				main(args);				//calling the main method again 
			}
			
			break;
		default:
			System.out.println("----Please choose correct option.");
			break;	
		}

	}
	
	
	public static void Main2(UnderWriter1[] UW1, Admin ad)
	{
		int choose1 = 0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("----Welcome to the Star Protect Vehicle------- ");
		
		System.out.println("----Enter the 1 for Admin Login :");
		System.out.println("----Enter the 2 for UnderWriter Login :");
		choose1=sc.nextInt();
		
		switch(choose1)
		{
		case 1:
			Admin.AdminLogin();
			break;
		case 2:
			//UW1=anotherMethod(UW1);
			UnderWriter.UnderWriterLogin(UW1);
			break;
		default:
			System.out.println("----Please choose correct option.");
			break;	
		}
		
		
		sc.close();
	}
	
	 public static UnderWriter1[] anotherMethod(UnderWriter1[] underwriters) {
	        return underwriters;
	    }

}



