package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ankitha
 * Car class to accept carId, carType and List of reservations for each car
 */
public class Car {
	String carId;
	CarType carTypeName;
	List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Car(String carId, CarType carTypeName, List<Reservation> reservations) {
		super();
		this.carId = carId;
		this.carTypeName = carTypeName;
		this.reservations = reservations;
	}
	
	public CarType getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(CarType carTypeName) {
		this.carTypeName = carTypeName;
	}
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
