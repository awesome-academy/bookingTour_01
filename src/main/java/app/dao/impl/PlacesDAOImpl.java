package app.dao.impl;

import java.util.List;

import app.dao.GenericDAO;
import app.dao.PlacesDao;
import app.model.Places;

public class PlacesDAOImpl extends GenericDAO<Integer, Places> implements PlacesDao {
	public PlacesDAOImpl() {
		super(Places.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> listPlaces() {
		return getSession().createQuery("FROM Places").getResultList();
	}
}