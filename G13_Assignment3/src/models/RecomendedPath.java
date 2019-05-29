package models;

import java.util.Vector;

public class RecomendedPath extends Path{
	
	private Vector<InterestingPlace> PlacesInPath;
	private Vector<String> RecomendedTimeOfPath;
	
	public Vector<InterestingPlace> getPlacesInPath() {
		return PlacesInPath;
	}
	public void setPlacesInPath(Vector<InterestingPlace> placesInPath) {
		PlacesInPath = placesInPath;
	}
	public Vector<String> getRecomendedTimeOfPath() {
		return RecomendedTimeOfPath;
	}
	public void setRecomendedTimeOfPath(Vector<String> recomendedTimeOfPath) {
		RecomendedTimeOfPath = recomendedTimeOfPath;
	}

}
