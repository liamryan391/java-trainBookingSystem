package seatbookingsystem;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem {

	private static Scanner input = new Scanner(System.in);
	
//	private static final Seat[] seats = new Seat[18];
	static ArrayList<Seat> seats = new ArrayList<Seat>();

	public static void main(String[] args) throws Exception {	
	 loadSeats();
		
		String choice = "";
		
		do {
			System.out.println("\n-- MAIN MENU --");
			System.out.println("1 - Reserve Seat");
			System.out.println("2 - Cancel Seat");
			System.out.println("3- View Seat Reservartions");
			System.out.println("Q- Quit");
			System.out.println("Pick:");
			
			choice = input.next().toUpperCase();
			switch (choice) {
			case "1" : {
					reserveSeats();
					break;
			}
			case "2" : {
					cancelSeats();
					break;
			}
			case "3" : {
					displaySeats();
					break;
			}
			
		}
			
		} while(!choice.equals("Q"));
		System.out.println("--GOODBYE--");
		
	}

	private static void loadSeats() throws FileNotFoundException {
	//	Scanner file = new Scanner (new FileReader("M:\\Data\\seats.txt"));
		Scanner file = new Scanner (new FileReader("C:\\Courwork\\Booking system\\seats.txt"));

		
		while (file.hasNext()) {
			String seatNum = file.next();
			String seatClass = file.next();
			boolean isWindow = Boolean.parseBoolean(file.next());
			boolean isAisle = Boolean.parseBoolean(file.next());
			boolean isTable = Boolean.parseBoolean(file.next());
			double seatPrice = file.nextDouble();
			String eMail = file.next();
		
			seats.add(new Seat(seatNum, seatClass, isWindow, isAisle, isTable, seatPrice, eMail));


		}
		file.close();
		
	}
	private static void displaySeats() {
		
		System.out.println("\n-- LIST OF SEATS --");
		for(Seat seats : seats) {
			System.out.println(seats.toString());
		}
		
	}
	private static void reserveSeats() throws FileNotFoundException {
		displaySeats();
		
		
		
		System.out.println("Enter seat number ");
		String seatNum = input.next();
		
		System.out.println("Please enter your email address");
		String eMail = input.next();
			for(Seat seats: seats) {
			if(seatNum.toUpperCase().equals(seats.getSeatNum()))
			
			seats.reserve(seatNum);
			seats.setEmail(eMail);
		}
		
	}	
	private static void cancelSeats() {
		System.out.println("\n-- CANCEL A SEAT--");
		
		System.out.println("Enter seat number");
		String seatNum = input.next();
		for(Seat seats: seats) {
		//System.out.println(seats.toString());
		if(seatNum.toUpperCase().equals(seats.getSeatNum())) {
			
			seats.cancel();
		}
			
		}
		

}
		 
		public static void savedata() throws IOException{
			//BufferedWriter writer = new BufferedWriter(new FileWriter("M:\\Data\\seats.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Courwork\\Booking system\\seats.txt"));
			for (Seat seats: seats) {
				writer.write(seats.toString());
		}
		
			writer.close();
		
		
	}
}



