package test;

import org.junit.Assert;
import org.junit.Test;

import domain.User;
import processor.CarReservationProcessor;

public class CarReservationProcessorTest {

	CarReservationProcessor carReservationprocessor = new CarReservationProcessor();
	
	@Test
	public void testReserveProcessPositive(){
		User user = new User(301, "Henry");
		System.out.println("\n\tInside testReserveProcessPositive method:");
		try {
			Assert.assertTrue(carReservationprocessor.processRequest(user, "Camry", "31/03/2019", "10:00:00", 4));
		} catch (Exception e) {
			System.out.println("Unable to process");
		}
	}
	
	@Test
	public void testReserveProcessOverlappingDates(){
		User user = new User(201, "John");
		System.out.println("\n\tInside testReserveProcessOverlappingDates method:");
		try {
			Assert.assertTrue(carReservationprocessor.processRequest(user, "CRV", "20/03/2019", "15:15:00", 4));
			System.out.println("");
			Assert.assertFalse(carReservationprocessor.processRequest(user, "CRV", "21/03/2019", "10:10:15", 2));
		} catch (Exception e) {
			System.out.println("Unable to process");
		}
	}
	
	@Test
	public void testReserveProcessDateTime(){
		User user = new User(6, "Emma");
		System.out.println("\n\tInside testReserveProcessDateTime method:");
		try {
			Assert.assertTrue(carReservationprocessor.processRequest(user, "Accord", "20/03/2019", "15:15:00", 4));
			System.out.println("");
			Assert.assertFalse(carReservationprocessor.processRequest(user, "Accord", "20/03/2019", "15:15:00", 2));
		} catch (Exception e) {
			System.out.println("Unable to process");
		}
	}
	
	@Test
	public void testReserveProcessMultipleTimesSuccess(){
		User user = new User(10, "Tom");
		System.out.println("\n\tInside testReserveProcessMultipleTimesSuccess method:");
		try {
			Assert.assertTrue(carReservationprocessor.processRequest(user, "Pilot", "15/03/2019", "16:10:00", 3));
			System.out.println("");
			Assert.assertTrue(carReservationprocessor.processRequest(user, "Pilot", "19/03/2019", "15:10:00", 3));
		} catch (Exception e) {
			System.out.println("Unable to process");
		}
	}
	
	@Test
	public void testReserveProcessFailure(){
		User user = new User(10, "Tom");
		System.out.println("\n\tInside testReserveProcessFailure method");
		try {
			carReservationprocessor.processRequest(user, "Pilot", "03/03/2019", "02:44:00", 1);
			
		} catch (Exception e) {
			System.out.println("Please provide valid input");
		}
	}
}

