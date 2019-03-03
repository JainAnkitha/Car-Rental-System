package domain;

import java.util.Date;
/**
 * 
 * @author Ankitha
 * Reservation class to track user details along with start and end date of the car reservation
 */
public class Reservation {
	User user;
	Date startDate;
	Date endDate;
	int daysRequested;
	
	public Reservation(User user, Date startDate, Date endDate, int daysRequested) {
		super();
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.daysRequested = daysRequested;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getDaysRequested() {
		return daysRequested;
	}
	public void setDaysRequested(int daysRequested) {
		this.daysRequested = daysRequested;
	}	

}
