package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.model.Places;
import app.model.TourDetails;
import app.service.PlacesService;
import app.service.TourDetailsService;

public class PlacesServiceImpl extends PlacesBaseServiceImpl implements PlacesService {
	
	@Override
	public List<Places> loadPlaces() {
		try {
			return getPlacesDAO().listPlaces();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Places saveOrUpdate(Places entity) {
		try {
			return getPlacesDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deletePlace(Integer id) {
		try {
			Places place = getPlacesDAO().findById(id);
			return delete(place);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean delete(Places entity) {
		try {
			getPlacesDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Places findById(Serializable key) {
		try {
			return getPlacesDAO().findById(key);
		} catch (Exception e) {
			return null;
		}
	}

}