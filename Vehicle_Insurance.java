package login;

import java.time.LocalDate;

public class Vehicle_Insurance {
	
	//Private Variables declarations
	private int PolicyNo;
	private int VehicleNo;
	private String VehicleType;
	private String CustomerName;
	private int EngineNo;
	private int ChasisNo;
	private long PhoneNo;
	private double PremiumAmnt;
	private String Type;            	//(Full Insurance/ThirdParty)
	private LocalDate FromDate;			//dd-mm-yyyy
	private LocalDate ToDate;           //dd-mm-yyyy
	private int UnderWriterId;
	
	//Constructors.
	Vehicle_Insurance(int policyNo, int vehicleNo, String vehicleType, String customerName, int engineNo,
			int chasisNo, long phoneNo, double premiumAmnt, String type, LocalDate fromDate, LocalDate toDate, int UnderWriterid) {

		this.PolicyNo = policyNo;
		this.VehicleNo = vehicleNo;
		this.VehicleType = vehicleType;
		this.CustomerName = customerName;
		this.EngineNo = engineNo;
		this.ChasisNo = chasisNo;
		this.PhoneNo = phoneNo;
		this.PremiumAmnt = premiumAmnt;
		this.Type = type;
		this.FromDate = fromDate;
		this.ToDate = toDate;
		this.UnderWriterId=UnderWriterid;
	}

	//getters and setters
	public int getUnderWriterId() {
		return UnderWriterId;
	}


	public void setUnderWriterId(int underWriterId) {
		UnderWriterId = underWriterId;
	}


	public int getPolicyNo() {
		return PolicyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.PolicyNo = policyNo;
	}

	public int getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.VehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.VehicleType = vehicleType;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		this.CustomerName = customerName;
	}

	public int getEngineNo() {
		return EngineNo;
	}

	public void setEngineNo(int engineNo) {
		this.EngineNo = engineNo;
	}

	public int getChasisNo() {
		return ChasisNo;
	}

	public void setChasisNo(int chasisNo) {
		this.ChasisNo = chasisNo;
	}

	public long getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.PhoneNo = phoneNo;
	}

	public double getPremiumAmnt() {
		return PremiumAmnt;
	}

	public void setPremiumAmnt(double premiumAmnt) {
		this.PremiumAmnt = premiumAmnt;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public LocalDate getFromDate() {
		return FromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.FromDate = fromDate;
	}

	public LocalDate getToDate() {
		return ToDate;
	}

	public void setToDate(LocalDate toDate) {
		this.ToDate = toDate;
	}
}
 