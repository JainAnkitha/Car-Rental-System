package processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Car;
import domain.CarType;
import domain.Reservation;
import domain.User;

public class DummyCarList {

	/**
	 * Method to load dummy data and return the data in the form of a List
	 * @return List of Car objects
	 */
	public static List<Car> loadDummyData(){

		List<Car> carList = new ArrayList<>();
		try {

			List<Reservation> reservations = new ArrayList<Reservation>();
			User dummyUser = new User(101, "Jane");
			Reservation dummyReservation = new Reservation(dummyUser, getDate("02/04/2019 12:12:12") , getDate("04/04/2019 12:12:12"), 2);
			reservations.add(dummyReservation);
			Car entry1 = new Car ("VA113T1", CarType.TOYOTA1,reservations );
			carList.add(entry1);

			Car entry2 = new Car("MD712T2", CarType.TOYOTA2, new ArrayList<Reservation>());
			carList.add(entry2);

			Car entry3 = new Car("DC254T3", CarType.TOYOTA3, new ArrayList<Reservation>());
			carList.add(entry3);

			Car entry4 = new Car("MO345T4", CarType.TOYOTA4, new ArrayList<Reservation>());
			carList.add(entry4);

			Car entry5 = new Car("MD333T5", CarType.TOYOTA5, new ArrayList<Reservation>());
			carList.add(entry5);

			Car entry6 = new Car("CA098H1", CarType.HONDA1, new ArrayList<Reservation>());
			carList.add(entry6);

			Car entry7 = new Car("WA345H2", CarType.HONDA2, new ArrayList<Reservation>());
			carList.add(entry7);

			Car entry8 = new Car("PA915H3", CarType.HONDA3, new ArrayList<Reservation>());
			carList.add(entry8);

			Car entry9 = new Car("CO010H4", CarType.HONDA4, new ArrayList<Reservation>());
			carList.add(entry9);

			Car entry10 = new Car("TX660H5", CarType.HONDA5, new ArrayList<Reservation>());
			carList.add(entry10);

		} catch (ParseException e) {
			System.out.println("Unable to load dummy data");
		}
		return carList;		
	}

	private static Date getDate(String s) throws ParseException{
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(s);
	}

}
