package main.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.domains.User;
import main.java.repository.UserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
//	@Autowired
//    TransactionManager transactionManager;
	@Autowired
    UserRepository userRepository;

    public void add(final User user) {
//        transactionManager.doInTransaction(new TransactionOperation<Void>() {
//            @Override
//            public Void operation() throws SQLException {
//                userRepository.insertUser(jdbcTemplate, user);
//                return null;
//            }
//        });
    	userRepository.insertUser(user);
    }

    public User isLoginUsed(final String login) {
//        return transactionManager.doInTransaction(new TransactionOperation<User>() {
//            @Override
//            public User operation(JdbcTemplate jdbcTemplate) throws SQLException{
//                return userRepository.findByLogin(jdbcTemplate, login);
//            }
//        });
    	return userRepository.findByLogin(login);
    }

    public boolean findByLoginAndPassword(final String login, final String password) {
//        return transactionManager.doInTransaction(new TransactionOperation<Boolean>() {
//            @Override
//            public Boolean operation(JdbcTemplate jdbcTemplate) throws SQLException {
//                return userRepository.findByLognAndPass(jdbcTemplate, login, password);
//            }
//        });
    	return userRepository.findByLognAndPass(login, password);
    }
    
    public int findId(final String login) {
//        return transactionManager.doInTransaction(new TransactionOperation<Integer>() {
//            @Override
//            public Integer operation(JdbcTemplate jdbcTemplate) throws SQLException {
//                return userRepository.findUserId(jdbcTemplate, login);
//            }
//        });
    	return userRepository.findUserId(login);
    }
}
