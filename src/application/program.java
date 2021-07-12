package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import model.entities.Reservation;
import model.exceptions.DomainException;

public class program {

	public static void main(String[] args) {
		 
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Checkin date(dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Checkout date(dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Checkin date(dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date(dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			reservation.updateDates(checkin, checkout);
			System.out.print("Reservation: " + reservation);
			
			sc.close();
		}
		
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error while scheduling: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("An unexpected error occurred");
		}
	}

}
