package app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import app.model.Tours;

//public interface ToursDao {
//	public List<Tours> listTours();
//	
//
//}
//public interface ToursDao extends CrudRepository<Tours, Long>{
//
//
//
//}

public interface ToursDao extends BaseDAO<Integer, Tours> {
//	Tours findByEmail(String email);
//
//	List<Tours> searchStudentUsingCretial(String name, int gender);

	List<Tours> listTours();

}