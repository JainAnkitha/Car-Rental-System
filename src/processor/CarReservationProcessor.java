package processor;

import java.util.Date;
import java.util.List;

import domain.Car;
import domain.CarType;
import domain.Reservation;
import domain.User;
import util.CarUtil;

public class CarReservationProcessor {

	List<Reservation> reservationList;
	List<Car> carList = DummyCarList.loadDummyData();

	public boolean processRequest(User user, String carRequested, String startDaterequested, String startTimeRequested,
			int noOfDaysRequested) throws Exception {

		CarUtil carUtil = new CarUtil();
		Date startDateTime = carUtil.stringToDate(startDaterequested, startTimeRequested);
		Date endDateTime = carUtil.getEndDate(startDateTime, noOfDaysRequested);
		CarType carTypeName = CarType.fromValue(carRequested);


		if( null != startDateTime && null != endDateTime && null != carTypeName){
			for(Car car : carList){
				if(car.getCarTypeName().equals(carTypeName)){

					reservationList = car.getReservations();
					if(reservationList.isEmpty()){
						Reservation reservation = new Reservation(user, startDateTime, endDateTime, noOfDaysRequested);
						reservationList.add(reservation);
						car.setReservations(reservationList);
						System.out.println("\nCongratulations your car is booked.\nCar Number :"+ car.getCarId() +" ,CarType :" +carTypeName.getCarTypeName() + 
								"\nReservation Start Date :" + reservation.getStartDate() + "\nReservation End Date:" + reservation.getEndDate());
						return true;
					}
					else{
						for(Reservation reservation: reservationList){
							if((isRequestedDateInvalidDate(reservation, startDateTime))){
								System.out.println("Sorry car is not available for "+ startDateTime + ". Please choose a different date/car.");
								return false;
							}
						}

						Reservation newSlotReservation = new Reservation(user, startDateTime, endDateTime, noOfDaysRequested);
						reservationList.add(newSlotReservation);
						System.out.println("\nCongratulations your car is booked.\nCar Number :"+ car.getCarId() +" ,CarType :" +carTypeName.getCarTypeName() + 
								"\nReservation Start Date :" + newSlotReservation.getStartDate() + "\nReservation End Date:" + newSlotReservation.getEndDate());
						return true;

					}
				}			
			}		
		}
		else{
			System.out.println("Please provide valid input");
		}
		return true;			
	}

	private boolean isRequestedDateInvalidDate(Reservation reservation, Date startDatereq) {
		return startDatereq.equals(reservation.getStartDate()) || 
				startDatereq.equals(reservation.getEndDate()) || 
				startDatereq.after(reservation.getStartDate()) && startDatereq.before(reservation.getEndDate());

	}

}
