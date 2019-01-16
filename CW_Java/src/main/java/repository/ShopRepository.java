package main.java.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import main.java.domains.Good;

@Repository
public class ShopRepository {
//	private static String FIND_ALL = "select * from javacw.goods";
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Good> findAll() throws SQLException {		
		Query query = entityManager.createQuery("SELECT g FROM Good g");
	    return (List<Good>) query.getResultList();
    }
}
