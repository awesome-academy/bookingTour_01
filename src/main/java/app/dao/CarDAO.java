package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Car;

@Repository
public interface CarDAO extends JpaRepository<Car, Integer> {

}
