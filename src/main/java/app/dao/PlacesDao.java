package app.dao;

import java.util.List;

import app.model.Places;
import app.model.TourDetails;

public interface PlacesDao extends BaseDAO<Integer, Places> {
	List<Places> listPlaces();
}