package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import app.dao.PlacesDao;
import app.dao.TourDetailsDao;

public class PlacesBaseServiceImpl {
	
	@Autowired
	protected PlacesDao placesDAO;

	public PlacesDao getPlacesDAO() {
		return placesDAO;
	}

	public void setPlacesDAO(PlacesDao placesDAO) {
		this.placesDAO = placesDAO;
	}


}