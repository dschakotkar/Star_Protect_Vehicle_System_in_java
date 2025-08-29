package login;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import login.Star_Protect_Vehicle_System;
import login.UnderWriter1;
import login.UnderWriter;

public class Admin 
{

	private int id=1111;                              //auto geneatated...
	private String passward="Admin@1111";			//one special character atleast
	
	//getters and setters
	public int getId()
	{
		return id;
	}
	public String getPassward()
	{
		return passward;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setPassward(String passward)
	{
		this.passward=passward;
	}
	
	 
	public static void  AdminLogin()
	{
		//local variables
		int id;
		String passward;
		
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin();	
		System.out.println("----Inside the Admin Login---- ");
		
		System.out.println("Enter the Admin Id: ");
		id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Admin Passward: ");
		passward=sc.nextLine();
		
		if(id==ad.getId() && passward.equalsIgnoreCase(ad.getPassward()))
		{

			UnderWriter1[] UW=null;
			
			int choose1=-1;
			
			while(choose1!=0) {

			System.out.println("----Admin Login Successfull.......");
			System.out.println("1.UnderWriter Registration.");
			System.out.println("2.Search By UnderWriter Id.");
			System.out.println("3.Update UnderWriter password.");
			System.out.println("4.Delete UnderWriter by Id.");
			System.out.println("5.View All UnderWriter.");
			System.out.println("6.View All Vehicle specific to underWriter Id.");
			System.out.println("0 Go to main Menu");
			choose1=sc.nextInt();
			
			
			switch(choose1)
			{
			case 1:
				System.out.println("UnderWriter Registration.");
				UW=Admin.Registration(sc);
				
				break;
			case 2:
				System.out.println("Search By Id");
				int sid=sc.nextInt();
				Admin.SearchByUnderWriterId(UW, sid, sc);
				break;
			case 3:
				System.out.println("Update UnderWriter Passward.");
				System.out.println("Enter id of the UnderWriter:");
				int id1=sc.nextInt();sc.nextLine();
				System.out.println("Enter the New Passward");
				String pass=sc.nextLine();
				Admin.UpdatUnderWriterPassward(UW, pass, id1);
				break;
			case 4:
				System.out.println("Delete UnderWriter By It's  Id");
				Admin.deleteUnderwriterById(sc,UW);
				break;
			case 5:
				System.out.println("View All UnderWriter.");
				Admin.ViewAllUnderWriter(UW);
				break;
			case 6:
				System.out.println("View All Vehicle specific to underWriter Id");
				UnderWriter.viewAllVehicleUnderUnderWriter(UnderWriter.vehicle_insurance_global);
				break;
			case 7:
				
				System.out.println("Go to main Menu..");
//				Star_Protect_Vehicle_System.Main2(UW, ad);
//				sc.close();
				break;
			default:
				System.out.println("Please Enter the valid Option from given above.");
				break;
			}//case end
				
			}//while end
			System.out.println("Go to main Menu..press 1 ");
			int c=sc.nextInt();
			
			if(c==1) {
				Star_Protect_Vehicle_System.Main2(UW, ad);	
			}
			else {
				System.out.println("you enterd wrong number.");
			}
			sc.close();    //if the enterd value is 0 then terminate the loop
			
			
		}   //if end
		else{
			System.out.println("Login  Failed please try again ...!");
			
		}  //else end
		
	}      //function end
	
	public static int getsizeofUnderWriter(UnderWriter1[] uw1)
	{	
		int n=uw1.length;
		return n;
	}
	public static UnderWriter1[] Registration(Scanner sc)
	{
		System.out.println("How many UnderWriter you want to register..:");
		int n=sc.nextInt();
		UnderWriter1[] uW1=new UnderWriter1[n];
		
		for(int i=0;i<n;i++)
		{
			int id=100+i;sc.nextLine();
			System.out.println("Underwriter Id: "+id);
			
			System.out.println("Enter underwriter name:");
			String name=sc.nextLine();
			System.out.println("Enter underwriter DOB(dd/mm/yyy):");
			String date1=sc.next();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDate dob = LocalDate.parse(date1, formatter1); 
			System.out.println("Enter underwriter Joining Date(dd/mm/yyyy):");
			String date2=sc.next();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDate dateOfJoining = LocalDate.parse(date2, formatter2); 
			System.out.println("Enter the default Passward:");
			sc.nextLine();
			String defaultPassward=sc.nextLine();
			
			uW1[i]=new UnderWriter1(id, name, dob, dateOfJoining, defaultPassward);
			registerUnderwriter(uW1, i, new UnderWriter1(id, name, dob, dateOfJoining, defaultPassward));
			
		}
		Star_Protect_Vehicle_System.anotherMethod(uW1);
		return uW1;
	}
	
	//update the given underwiter array
	
	public static void registerUnderwriter(UnderWriter1[] underwriter, int index, UnderWriter1 underwriter1) {
		underwriter[index] = underwriter1; // Update the object array
    }
	
	public static void SearchByUnderWriterId(UnderWriter1[] uw1, int id, Scanner sc)
	{
		//for(UnderWriter1 UW : uw1)
		boolean check=false;
		for(int i=0;i<uw1.length;i++)
		{
			if(uw1[i].getUnderwriterId()==id)
			{
				System.out.println("Id-"+uw1[i].getUnderwriterId());
				System.out.println("Name-"+uw1[i].getName());
				System.out.println("DOB-"+uw1[i].getDOB());
				System.out.println("Date Of Joining-"+uw1[i].getJoiningDate());
				System.out.println("Default Passward-"+uw1[i].getDefaultPassword());
				check=true;
			}
		}
		if(check==false)
		{
			System.out.println("Invalid UnderWriter Id");
			 System.out.println("1.Re-Enter UnderWriter Id");
			 System.out.println("2.Go Back to the previous Screen.");
			 int option=sc.nextInt();sc.nextLine();
			 switch(option)
			 {
			 	case 1:
			 		System.out.println("Enter the Id: ");
			 		id=sc.nextInt();sc.nextLine();
			 		Admin.SearchByUnderWriterId(uw1,id,sc);
				 	break;
			 	case 2:
			 		Star_Protect_Vehicle_System.Main2(uw1,new Admin());
			 		break;
				default:
					 System.out.println("Please do again wrong input...!");
					 break;
			 }
			
		}
	}
	public static void UpdatUnderWriterPassward(UnderWriter1[] uw2, String pass, int id )
	{
		for(int i=0;i<uw2.length;i++)
		{
			if(uw2[i].getUnderwriterId()==id)
			{
				uw2[i].setDefaultPassword(pass);
			}
		}
	}
	public static void ViewAllUnderWriter(UnderWriter1[] uw4)
	{
		for(UnderWriter1 UW : uw4)
		{
			System.out.println("Id-"+UW.getUnderwriterId());
			System.out.println("Name-"+UW.getName());
			System.out.println("Date of Birth-"+UW.getDOB());
			System.out.println("Date of Joinig-"+UW.getJoiningDate());		
		}
	}
	public static void deleteUnderwriterById(Scanner scanner, UnderWriter1[] underwriters) {
        System.out.println("Enter Underwriter Id:");
        int id = scanner.nextInt();
        
        for (int i = 0; i < underwriters.length; i++) {
        	
            if (underwriters[i] != null && underwriters[i].getUnderwriterId() == id) {
                underwriters[i].setUnderwriterId(0);// underwriters[i]= null;
                underwriters[i].setName(null);
                underwriters[i].setDOB(null);
                underwriters[i].setJoiningDate(null);
                underwriters[i].setDefaultPassword(null);
                System.out.println("Underwriter with Id " + id + " deleted successfully.");
                return;
            }
            else
            {
            	System.out.println("Wrong UnderWriter Id:");
            	System.out.println("1. ReEnter UnderWriter ID:");
            	System.out.println("2. Go back to Previous Screen:");
            	int option=scanner.nextInt();
            	switch(option)
            	{
            		case 1:
            			deleteUnderwriterById(scanner,underwriters);
            			break;
            		case 2:
            			Star_Protect_Vehicle_System.Main2(underwriters,new Admin());
            			break;
            		default:
            			System.out.println("Invalid input...!");
            			break;
            	}
            	
            }
        }
        System.out.println("Underwriter with Id " + id + " not found.");
    }
	
	
}
