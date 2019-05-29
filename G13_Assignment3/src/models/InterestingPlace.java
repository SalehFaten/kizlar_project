package models;

public class InterestingPlace {
	
	private String PlaceName;
	private int PlaceId;
	private int CityId;
	private String Location;
	private String Classification;
	private String Description;
	private int RecomendedTime;
	
	public String getPlaceName() {
		return PlaceName;
	}
	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}
	public int getPlaceId() {
		return PlaceId;
	}
	public void setPlaceId(int placeId) {
		PlaceId = placeId;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getClassification() {
		return Classification;
	}
	public void setClassification(String classification) {
		Classification = classification;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getRecomendedTime() {
		return RecomendedTime;
	}
	public void setRecomendedTime(int recomendedTime) {
		RecomendedTime = recomendedTime;
	}

}
