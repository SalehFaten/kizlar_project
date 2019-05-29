package models;

import java.util.Vector;

public class Person {
	
	private String FirstName;
	private String LastName;
	private String Tel;
	private String Email;
	private String AccountNum;
	private boolean Regestered;
	
	
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
	public boolean isRegestered() {
		return Regestered;
	}
	public void setRegestered(boolean regestered) {
		Regestered = regestered;
	}
	
	/*
	public Vector<String> register(String FirstName, String LastName, String Tel, String Email, String AccountNum, int UserType){
		
	}*/
	
	
	
	
	

}
