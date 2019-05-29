package models;

import java.util.Vector;

public class Map {
	
	private String MapId;
	private int CityId;
	private String Description;
	private Vector<Path> MapPaths;
	private Vector<InterestingPlace> MapInterestingPlace;
	private Vector<Version> MapVersions;
	
	public String getMapId() {
		return MapId;
	}
	public void setMapId(String mapId) {
		MapId = mapId;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Vector<Path> getMapPaths() {
		return MapPaths;
	}
	public void setMapPaths(Vector<Path> mapPaths) {
		MapPaths = mapPaths;
	}
	public Vector<InterestingPlace> getMapInterestingPlace() {
		return MapInterestingPlace;
	}
	public void setMapInterestingPlace(Vector<InterestingPlace> mapInterestingPlace) {
		MapInterestingPlace = mapInterestingPlace;
	}
	public Vector<Version> getMapVersions() {
		return MapVersions;
	}
	public void setMapVersions(Vector<Version> mapVersions) {
		MapVersions = mapVersions;
	}
	
	

}
