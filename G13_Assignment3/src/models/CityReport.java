package models;

import java.util.Vector;

public class CityReport {
	
	private String CityName;
	private int CityId;
	private int NumOneTimePurchase;
	private int NumOfClients;
	private int NumUpdates;
	private int NumOfViews;
	private int NumOfDownloads;
	private Vector<Client> ExistingClients;
	
	
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public int getNumOneTimePurchase() {
		return NumOneTimePurchase;
	}
	public void setNumOneTimePurchase(int numOneTimePurchase) {
		NumOneTimePurchase = numOneTimePurchase;
	}
	public int getNumOfClients() {
		return NumOfClients;
	}
	public void setNumOfClients(int numOfClients) {
		NumOfClients = numOfClients;
	}
	public int getNumUpdates() {
		return NumUpdates;
	}
	public void setNumUpdates(int numUpdates) {
		NumUpdates = numUpdates;
	}
	public int getNumOfViews() {
		return NumOfViews;
	}
	public void setNumOfViews(int numOfViews) {
		NumOfViews = numOfViews;
	}
	public int getNumOfDownloads() {
		return NumOfDownloads;
	}
	public void setNumOfDownloads(int numOfDownloads) {
		NumOfDownloads = numOfDownloads;
	}
	public Vector<Client> getExistingClients() {
		return ExistingClients;
	}
	public void setExistingClients(Vector<Client> existingClients) {
		ExistingClients = existingClients;
	}
	

}
