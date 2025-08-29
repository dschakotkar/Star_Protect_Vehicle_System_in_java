package login;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import login.Vehicle_Insurance;
class UnderWriter {
	
	static Vehicle_Insurance[] vehicle_insurance_global=null;
	
	public static void UnderWriterLogin(UnderWriter1[] UW1)
	{
		Scanner sc=new Scanner(System.in);
		//UnderWriter uw= new UnderWriter();
		
		System.out.println("-----Inside the UnderWriter Login--------- ");
		System.out.println("Enter the UnderWriter Id : ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the UnderWriter Passward : ");
		String passward=sc.nextLine();
			
		UnderWriter1[] uw1 = null;
		
		int id1=0;
		

		for(UnderWriter1 uw11 : UW1)
		{
			if(uw11.getUnderwriterId()==id && uw11.getDefaultPassword().equalsIgnoreCase(passward)) {
			System.out.println("login successfull..");
			uw1=UW1;
			id1=uw11.getUnderwriterId();
			
			int choose=-1;
			Vehicle_Insurance[] vi=null;
			
			while(choose != 0) 
			{
			
			
			System.out.println("Press 1 for Create a new Vehicle Insurance.");
			System.out.println("Press 2 for Renewal of a Policy.");
			System.out.println("Press 3 for Changing the Policy."); //change the type of insurance.
			System.out.println("Press 4 for View Policy");          //all vehicle insurance policies

			choose=sc.nextInt();
				switch(choose)
				{
				case 1:
					vi=UnderWriter.registerInsurance(sc,id1);
					break;
				case 2:
					System.out.println("Enter the incurance policy No.");
					int id2=sc.nextInt();sc.nextLine();
					UnderWriter.RenewalofaPolicy(vi,id2,sc);
					break;
				case 3:
					System.out.println("Enter the Policy No: ");
					int id3=sc.nextInt();sc.nextLine();
					UnderWriter.changingThePolicy(vi,id3,sc);
					break;
				case 4:
					System.out.println("Press 1 for View All registered Insurance.");
					System.out.println("Press 2 for View Customer Insurance details by it's Vehicle No.");
					System.out.println("Press 3 for View Customer Insurance Details by it's Policy No.");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						UnderWriter.showRegisterInsurance(vi);
						break;
					case 2:
						System.out.println("Enter the Vehicle No: ");
						int vehicleNo=sc.nextInt();
						UnderWriter.viewInsuranceByVehicleId(vi, vehicleNo);
						break;
					case 3:
						System.out.println("Enter the Policy No :");
						int pn=sc.nextInt();
						UnderWriter.viewInsuranceByPolicyNo(vi, pn);
						break;
					default:
						System.out.println("Please Enter the Valid number....!");
						break;
						
					}
					break;
				default:
					System.out.println("Please enter the valid input....!");
					break;
				}//end switch
			}//end whil

			} //end if
		}//end for
	}//end underwriterlogin
	
	//view all vehicle under underwriter
	
	
	
	
	//changing the insurance type full insurance to third party and third party to full insurance
	
	public static void changingThePolicy(Vehicle_Insurance[] vi,int id3,Scanner sc)
	{
		for(int i=0;i<vi.length;i++)
		{
			if(vi[i].getPolicyNo()==id3)
			{
				System.out.println("old Insurance type: "+ vi[i].getType());
				System.out.println("Enter the New Insurance Type: ");
				vi[i].setType(sc.nextLine());
				 if(vi[i].getType().equalsIgnoreCase("Full Insurance"))
	        	 {
	        		 vi[i].setPremiumAmnt(10000);
	        	 }
	        	 else if(vi[i].getType().equalsIgnoreCase("Third Party"))
	        	 {
	        		 vi[i].setPremiumAmnt(20000);
	        	 }else
	        	 {
	        		 vi[i].setPremiumAmnt(0);
	        		 System.out.println("Please Enter valid Type.");
	        	 }
				
				
			}
		}
	}
	
	//renewal policy by the underwriter with the help of policy no.
	
	public static void RenewalofaPolicy(Vehicle_Insurance[] vi, int id, Scanner sc)
	{
		for(int i=0;i<vi.length;i++)
		{
			if(vi[i].getPolicyNo()==id)
			{
				
				System.out.println("Policy No: "+vi[i].getPolicyNo());
	        	 System.out.println("Enter Vehicle No:");
	        	 vi[i].setVehicleNo(sc.nextInt());sc.nextLine();
	        	 System.out.println("Enter Vehicle Type (Two Wheeler or Four Wheeler or Three Wheeler):");
	        	 vi[i].setVehicleType(sc.nextLine());
	        	 System.out.println("Enter Customer Name:");
	        	 vi[i].setCustomerName(sc.nextLine());
	        	 System.out.println("Enter Engine NO:");
	        	 
	        	 vi[i].setEngineNo(sc.nextInt());
	        	 System.out.println("Enter Chasis No:");
	        	 vi[i].setChasisNo(sc.nextInt());
	        	 
	        	 System.out.println("Enter Phone No:");
	        	 vi[i].setPhoneNo(sc.nextLong());
	        	 sc.nextLine();
	        	 System.out.println("Enter the Type of Insurance (Third party or Full Insurance):");
	        	 vi[i].setType(sc.nextLine());
	        	           // (Full Insurance/ThirdParty)
	        	 
	        	 if(vi[i].getType().equalsIgnoreCase("Full Insurance"))
	        	 {
	        		 vi[i].setPremiumAmnt(10000);
	        	 }
	        	 else if(vi[i].getType().equalsIgnoreCase("Third Party"))
	        	 {
	        		 vi[i].setPremiumAmnt(20000);
	        	 }else
	        	 {
	        		 vi[i].setPremiumAmnt(0);
	        		 System.out.println("Please Enter valid Type.");
	        	 }
	        
	        	 
	        	 System.out.println("Enter Start Date: (dd/mm/yyyy):");
	        	 String date1=sc.next();
	  			 DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	  			 vi[i].setFromDate(LocalDate.parse(date1, formatter1));  
	  			 System.out.println("Enter the Due Date:(dd/mm/yyyy):");
	       	 
	        	 String date2=sc.next();
	 			 DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	 			 vi[i].setToDate(LocalDate.parse(date2, formatter2));; 
	        	 
	        	 
	        	 vi[i].setUnderWriterId(id);			
			}
		}
	}
	
	//methods for insurance policy by the underwriter
	
	public static Vehicle_Insurance[] registerInsurance(Scanner sc ,int id)
	{
		System.out.println("Enter the no of custemers want to insurance :");
		Vehicle_Insurance[] vehicle_insurance=new Vehicle_Insurance[sc.nextInt()];
		        
        for(int i=0;i<vehicle_insurance.length;i++)
        {
        	
        	 int PolicyNo=i+1000;
        	 System.out.println("Policy No: "+ PolicyNo);
        	 System.out.println("Enter Vehicle No:");
        	 int VehicleNo=sc.nextInt();sc.nextLine();
        	 
        	 System.out.println("Enter Vehicle Type (Two Wheeler or Four Wheeler or Three Wheeler):");
        	 String VehicleType=sc.nextLine();
        	 
        	 System.out.println("Enter Customer Name:");
        	 String CustomerName=sc.nextLine();
        	 System.out.println("Enter Engine NO:");
        	 int EngineNo=sc.nextInt();
        	 System.out.println("Enter Chasis No:");
        	 int ChasisNo=sc.nextInt();
        	 System.out.println("Enter Phone No:");
        	 long PhoneNo=sc.nextLong();sc.nextLine();
        	 System.out.println("Enter the Type of Insurance (Third party or Full Insurance):");
        	 String Type=sc.nextLine();            // (Full Insurance/ThirdParty)
        	 double PremiumAmnt=0;
        	 if(Type.equalsIgnoreCase("Full Insurance"))
        	 {
        		 PremiumAmnt=10000;
        	 }
        	 else if(Type.equalsIgnoreCase("Third Party"))
        	 {
        		 PremiumAmnt=20000;
        	 }else
        	 {
        		 PremiumAmnt=0;
        		 System.out.println("Please Enter valid Type.");
        	 }
        
        	 
        	 System.out.println("Enter Start Date: (dd/mm/yyyy):");
        	 String date1=sc.next();
  			 DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
  			 LocalDate FromDate = LocalDate.parse(date1, formatter1); 
  			 System.out.println("Enter the Due Date:(dd/mm/yyyy):");
       	 
        	 String date2=sc.next();
 			 DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
 			 LocalDate ToDate = LocalDate.parse(date2, formatter2); 
        	 
        	 
        	 int UnderWriterId=id;
        	 
        	 vehicle_insurance[i]=new Vehicle_Insurance(PolicyNo,VehicleNo,VehicleType, CustomerName, EngineNo, ChasisNo,  PhoneNo, PremiumAmnt, Type, FromDate, ToDate, UnderWriterId);
        	 	 
        }
        vehicle_insurance_global=vehicle_insurance;
        return vehicle_insurance;
	}
	
	//Show registered Insurance of Vehicle
	
	public static void showRegisterInsurance(Vehicle_Insurance[] vi)
	{
		
		for(Vehicle_Insurance v: vi)
		{
			
			System.out.println("Policy No: "+v.getPolicyNo()+ "|    Vehicle No: "+v.getVehicleNo()+"|    Vehicle Type: "+v.getVehicleType());
			System.out.println("Customer Name: "+v.getCustomerName()+"|    Engine No: "+v.getChasisNo()+"|    Chasis No: "+v.getChasisNo());
			System.out.println("Phone No: "+v.getPhoneNo()+ "|    Premimum Amount: "+v.getPremiumAmnt()+"|    Insurance Type: "+v.getType());
			System.out.println("From Date: "+v.getFromDate()+"|     To Date: "+v.getToDate()+"|    UnderWriter Id: "+v.getUnderWriterId());
			
		}
	}
	
	//View Insurance By Vehicle ID.
	
	public static void viewInsuranceByVehicleId(Vehicle_Insurance[] vi, int id)
	{
		boolean check=false;
		for(int i=0;i<vi.length;i++)
		{
			
			if(vi[i].getVehicleNo()==id)
			{
				System.out.println("Policy No: "+vi[i].getPolicyNo()+"|    Vehicle No: "+vi[i].getVehicleNo()+"|    Vehicle Type: "+vi[i].getVehicleType());
				System.out.println("Customer Name: "+vi[i].getCustomerName()+"|    Engine No: "+vi[i].getChasisNo()+ "|    Chasis No: "+vi[i].getChasisNo());
				System.out.println("Phone No: "+vi[i].getPhoneNo()+ "|    Premimum Amount: "+vi[i].getPremiumAmnt()+"|     Insurance Type: "+vi[i].getType());
				System.out.println("From Date: "+vi[i].getFromDate()+"|   To Date: "+vi[i].getToDate()+"|    UnderWriter Id: "+vi[i].getUnderWriterId());
				
				check=true;
			}
			
		}
		if(check==false)
		{
			System.out.println("Enterd vehicle id : "+id+ " is not found");
		}
	}
	
	//View Insurance By policy No of Vehicle
	
	public static void viewInsuranceByPolicyNo(Vehicle_Insurance[] vi, int pn)
	{
		boolean check=false;
		for(int i=0;i<vi.length;i++)
		{
			if(vi[i].getPolicyNo()==pn)
			{
				System.out.println("Policy No: "+vi[i].getPolicyNo()+"|    Vehicle No: "+vi[i].getVehicleNo()+"|    Vehicle Type: "+vi[i].getVehicleType());
				System.out.println("Customer Name: "+vi[i].getCustomerName()+"|    Engine No: "+vi[i].getChasisNo()+ "|    Chasis No: "+vi[i].getChasisNo());
				System.out.println("Phone No: "+vi[i].getPhoneNo()+ "|    Premimum Amount: "+vi[i].getPremiumAmnt()+"|    Insurance Type: "+vi[i].getType());
				System.out.println("From Date: "+vi[i].getFromDate()+"|    To Date: "+vi[i].getToDate()+"|    UnderWriter Id: "+vi[i].getUnderWriterId());
				check=true;
				
			}
		}
		if(check==false)
		{
			System.out.println("Entered Vehicle Policy No " +pn +" Not found");
		}
	}

	public static void viewAllVehicleUnderUnderWriter(Vehicle_Insurance[] vehicle_insurance_global2) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the underWriter ID: ");
		int uwid=sc.nextInt();
		for(int i=0;i<vehicle_insurance_global2.length;i++)
		{
			if(vehicle_insurance_global2[i].getUnderWriterId()==uwid)
			{
				System.out.println("Policy No: "+vehicle_insurance_global2[i].getPolicyNo()+"|    Vehicle No: "+vehicle_insurance_global2[i].getVehicleNo()+"|    Vehicle Type: "+vehicle_insurance_global2[i].getVehicleType());
				System.out.println("Customer Name: "+vehicle_insurance_global2[i].getCustomerName()+"|    Engine No: "+vehicle_insurance_global2[i].getChasisNo()+ "|    Chasis No: "+vehicle_insurance_global2[i].getChasisNo());
				System.out.println("Phone No: "+vehicle_insurance_global2[i].getPhoneNo()+ "|    Premimum Amount: "+vehicle_insurance_global2[i].getPremiumAmnt()+"|    Insurance Type: "+vehicle_insurance_global2[i].getType());
				System.out.println("From Date: "+vehicle_insurance_global2[i].getFromDate()+"|    To Date: "+vehicle_insurance_global2[i].getToDate()+"|    UnderWriter Id: "+vehicle_insurance_global2[i].getUnderWriterId());
				
			}
			else {
				System.out.println(uwid +" don't have registered any policy...");
			}
		}
	}
	
	
	
	
	
}//end of UnderWriter class


//Underwriter1 class Start
class UnderWriter1{
	//Private Variables declarations
	private int underwriterId ;           //of type integer which will be autogenerated
	private String name;                
	private LocalDate DOB;                     // of type Date
	private LocalDate JoiningDate;             // of type Date
	private String defaultPassword;       // - Containing the combination of alphanumeric characters
										  // containing at least one special character.
	
	//constructors
	public UnderWriter1(int underwriterId, String name, LocalDate dob2, LocalDate dateOfJoining, String defaultPassword) {
		//super();
		this.underwriterId = underwriterId;
		this.name = name;
		this.DOB = dob2;
		this.JoiningDate = dateOfJoining;
		this.defaultPassword = defaultPassword;
	}
	//getters and setters.
	public int getUnderwriterId() {
		return underwriterId;
	}

	public void setUnderwriterId(int underwriterId) {
		this.underwriterId = underwriterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		this.DOB = dOB;
	}

	public LocalDate getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.JoiningDate = joiningDate;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}
	
}//End of UnderWriter1 class 
