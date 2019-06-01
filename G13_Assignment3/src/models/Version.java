package models;

import java.util.Vector;

public class Version {
	
	private int VersionNum;
	private int CityId;
	private int PriceOnePurchase;
	private int PriceForClient;
	private boolean ApprovedVersion;
	private  Vector<Map> VersionMaps;
	
	public int getVersionNum() {
		return VersionNum;
	}
	public void setVersionNum(int versionNum) {
		VersionNum = versionNum;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public int getPriceOnePurchase() {
		return PriceOnePurchase;
	}
	public void setPriceOnePurchase(int priceOnePurchase) {
		PriceOnePurchase = priceOnePurchase;
	}
	public int getPriceForClient() {
		return PriceForClient;
	}
	public void setPriceForClient(int priceForClient) {
		PriceForClient = priceForClient;
	}
	public boolean isApprovedVersion() {
		return ApprovedVersion;
	}
	public void setApprovedVersion(boolean approvedVersion) {
		ApprovedVersion = approvedVersion;
	}
	public Vector<Map> getVersionMaps() {
		return VersionMaps;
	}
	public void setVersionMaps(Vector<Map> versionMaps) {
		VersionMaps = versionMaps;
	}
	/*
	public void setTotalPrice(int newPrice, int UserType) {
		
	}
	
	public Version SearchVersion(int VersionNum, int CityId) {
		
	}
	*/

}
