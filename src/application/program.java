package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/YY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/YY): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/YY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/YY): ");
			checkOut = sdf.parse(sc.next());
		
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation" + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		sc.close();
		}	
	}


