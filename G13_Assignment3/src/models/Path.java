package models;

public class Path {
	
	private String PathName;
	private int CityId;
	private int PathId;
	private String Description;
	
	public String getPathName() {
		return PathName;
	}
	public void setPathName(String pathName) {
		PathName = pathName;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public int getPathId() {
		return PathId;
	}
	public void setPathId(int pathId) {
		PathId = pathId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
