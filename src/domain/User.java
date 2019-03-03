package domain;
/**
 * 
 * @author Ankitha 
 * User class to accept userName and userId
 */
public class User {
	int userId;
	String userName;
	
	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User() { }	

}
