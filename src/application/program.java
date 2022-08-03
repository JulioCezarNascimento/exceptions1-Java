package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/YY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/YY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/YY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/YY): ");
			checkOut = sdf.parse(sc.next());
		
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
				System.out.println("Reservation" + reservation);
			
			}
		
		}		
		sc.close();
		
	}

}
