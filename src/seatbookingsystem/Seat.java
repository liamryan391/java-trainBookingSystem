package seatbookingsystem;

public class Seat {
	
	private String seatClass,seatNum,eMail;
	private double seatPrice;
	private Boolean isWindow,isAisle,isTable;
	
	// creating a constructor as method are not needed.
	public Seat(String seatNum, String seatClass, Boolean isWindow, Boolean isAisle, Boolean isTable, double seatPrice, String eMail) {
		this.seatNum = seatNum;
		this.seatClass = seatClass;
		this.isWindow = isWindow;
		this.isAisle = isAisle;
		this.isTable = isTable;
		this.seatPrice = seatPrice;
		this.eMail = eMail;
		
	}

	public String toString() {
		String result = seatNum + " " + seatClass + " " + isWindow + " " + isAisle + " " + isTable + " " + seatPrice + " " + eMail +" ";
		
		return result;
		
	}
	public void reserve (String seatNum) {

	}

	public void cancel () {
		
	}

	public String getSeatNum() {
		return seatNum;
	}
	
	public String getEmail() {
		return eMail;
}
	
	public void setEmail (String eMail) {
		
	}

}


