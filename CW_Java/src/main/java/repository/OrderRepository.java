package main.java.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import main.java.domains.Order;

@Repository
public class OrderRepository {
	@PersistenceContext
    private EntityManager entityManager;
	
	public int insertOrder(Order order) {
		entityManager.persist(order);
		entityManager.flush();
		return order.getOrderId();
	}
}
