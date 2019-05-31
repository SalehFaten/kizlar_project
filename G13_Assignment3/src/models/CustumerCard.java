package models;

import java.util.Vector;

public class CustumerCard {
	
	private String FirstName;
	private String LastName;
	private String Tel;
	private String Email;
	private String AccountNum;
	private int UserType;
	private Vector<String> History;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(String accountNum) {
		AccountNum = accountNum;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	public Vector<String> getHistory() {
		return History;
	}
	public void setHistory(Vector<String> history) {
		History = history;
	}
	
	

}
