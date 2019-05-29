package models;

public class Client extends Person {
	
	private String UserName;
	private String Password;
	private int UserType;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	/*
	public Version purchaceMap(int UserType, String cityName) {
		
	}*/
	

}
