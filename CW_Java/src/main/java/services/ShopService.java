package main.java.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.domains.Good;
import main.java.repository.ShopRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ShopService {
//	@Autowired
//	private TransactionManager transactionManager;
	@Autowired
	private ShopRepository shopRepository;
	
	public List<Good> getAllTovars() {
//	      return transactionManager.doInTransaction(new TransactionOperation<List<Good>>() {
//	         @Override
//	         public List<Good> operation(JdbcTemplate jdbcTemplate) throws SQLException {
		List<Good> goods = null;
	            try {
					goods = shopRepository.findAll();
				} catch (SQLException e) {
					System.out.println("SQL Exception...");
				}
	            return goods;
//	         }
//	      });
	}
}
