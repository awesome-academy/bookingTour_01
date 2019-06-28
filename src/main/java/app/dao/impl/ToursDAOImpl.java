package app.dao.impl;

import java.util.List;

import app.dao.GenericDAO;
import app.dao.ToursDao;
import app.model.Tours;

public class ToursDAOImpl extends GenericDAO<Integer, Tours> implements ToursDao{

	public ToursDAOImpl() {
		super(Tours.class);
		
	}

//	public ToursDAOImpl(SessionFactory sessionfactory) {
//		setSessionFactory(sessionfactory);
//	}
//	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Tours> listTours() {
		return getSession().createQuery("from Tours").getResultList();
	}
	
	
}


//
////@SuppressWarnings("unused")
//public class ToursDAOImpl extends GenericDAO<Integer, Tours> implements ToursDao{
//
//	public ToursDAOImpl() {
//		super(Tours.class);
//		
//	}
//
////	public ToursDAOImpl(SessionFactory sessionfactory) {
////		setSessionFactory(sessionfactory);
////	}
////	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);
////	@Autowired
////	 private SessionFactory sessionFactory;
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Tours> listTours() {
////		  Session session = sessionFactory.getCurrentSession();
////	        CriteriaBuilder cb = session.getCriteriaBuilder();
////	        CriteriaQuery < Tours > cq = cb.createQuery(Tours.class);
////	        Root < Tours > root = cq.from(Tours.class);
////	        cq.select(root);
////	        Query query = session.createQuery(cq);
////	        return query.getResultList();
//////		return sessionFactory.getCurrentSession().createCriteria(Tours.class).list();
//////				getSession().createCriteria(Tours.class).list();
//////				createQuery("from Tours").getResultList();
//		return getSession().createQuery("from Tours").getResultList();
//	}
//	
//	
//}
