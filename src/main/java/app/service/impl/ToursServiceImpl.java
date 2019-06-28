package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.model.Tours;
import app.service.ToursService;

public class ToursServiceImpl extends ToursBaseServiceImpl implements ToursService{
	@Override
	public List<Tours> listTours() {
		try {
			return getToursDAO().listTours();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Tours findById(Serializable key) {
		try {
			return getToursDAO().findById(key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Tours saveOrUpdate(Tours entity) {
		try {
			return getToursDAO().saveOrUpdate(entity);
		} catch (Exception e) {
//			logger.error(e);
			throw e;
		}
	}

	

	@Override
	public boolean deleteTours(Integer id) {
		try {
			Tours tours = getToursDAO().findById(id);
			return delete(tours);
		} catch (Exception e) {
//			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean delete(Tours entity) {
		try {
			getToursDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
}
