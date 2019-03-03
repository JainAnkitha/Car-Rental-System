package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import domain.User;
import processor.CarReservationProcessor;

public class CarReservationMain {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char proceed = 'Y';
		int userId;
		String userName;
		String carRequested;
		String startDaterequested;
		String startTimeRequested;
		int noOfDaysRequested;
		
		User user = new User();
		CarReservationProcessor carReservationProcessor = new CarReservationProcessor();

		do{
			
			try {
				System.out.println("\n\t\t\t\"Welcome to Car Reservation System\"");
				System.out.println("1.Please enter your UserId: ");
				userId = Integer.parseInt(br.readLine());
				System.out.println("2.Please enter your UserName: ");
				userName = br.readLine();
				
				System.out.println("3.Please enter the type of the car from the below list- Example:Camry");
				System.out.println("Toyota Cars: (Avalon/Camry/Corolla/Highlander/Prius)");
				System.out.println("Honda Cars: (Accord/CRV/Civic/Odyssey/Pilot)");
				carRequested = br.readLine();
				
				System.out.println("4.Please enter Start Date(dd/MM/yyyy):");
				startDaterequested = br.readLine();
				
				System.out.println("5.Please enter Start Time(HH:mm:ss):");
				startTimeRequested = br.readLine();
				
				System.out.println("6.Please enter number of Days:");
				noOfDaysRequested = Integer.parseInt(br.readLine());
				
				user.setUserId(userId);
				user.setUserName(userName);
				
				carReservationProcessor.processRequest(user, carRequested, startDaterequested, startTimeRequested, noOfDaysRequested );
				
				System.out.println("\nDo you wish to continue(Y/N)?");
				proceed = br.readLine().charAt(0);
				
			}catch (IOException e) {
				System.out.println("\nPlease enter valid car reservation details..");
			} catch (Exception e) {
				System.out.println("\nPlease enter valid input..");
			}
			
		}while(proceed != 'N');
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Unable to close the BufferedReader object" +e.getMessage());
		}

	}

}
