package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import app.dao.ToursDao;
import app.model.Tours;

//@Service("ToursService")
//@Transactional
//(propagation = Propagation.SUPPORTS, readOnly = true)
//public class ToursService  {
//	
//	@Autowired
//	private ToursDao toursDao;
//
////	@Override
//	public List<Tours> listTours() {
//		
//		return (List<Tours>) toursDao.findAll();
//	}
//	
//}
public interface ToursService  extends  BaseService<Integer, Tours> {
	boolean deleteTours(Integer id);

//	Student findByEmail(String email);
//
//	List<Student> searchStudents(String name, int gender);

	List<Tours> listTours();

//	boolean deleteTours(Integer id);
}