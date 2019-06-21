package app.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.CarDAO;
import app.model.Car;

@Service
@Transactional
public class CarService {

	@Autowired
	private CarDAO carDAO;

	public void save(Car car) {
		carDAO.save(car);
	}

	public List<Car> listAll() {
		return (List<Car>) carDAO.findAll();
	}

	public Car get(int id) {
		return carDAO.findById(id).get();
	}

	public void delete(int id) {
		carDAO.deleteById(id);
	}
}
