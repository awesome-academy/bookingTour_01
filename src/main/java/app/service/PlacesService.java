package app.service;

import java.util.List;

import app.model.Places;
import app.model.TourDetails;

public interface PlacesService extends BaseService<Integer, Places> {
	boolean deletePlace(Integer id);
	List<Places> loadPlaces();
}