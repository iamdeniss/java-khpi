package main.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.domains.User;

@Repository
public class UserRepository {
//	private static String FIND_BY_LOGIN = "select * from javacw.users where login = ?";
//	private static String INSERT_USER = "insert into javacw.users(login, passwrd) values(?, ?)";
//	private static String FIND_BY_LOGIN_AND_PASSWORD = "select * from javacw.users where login = ? and passwrd = ?";
//	private static String FIND_USER_ID = "select id from javacw.users where login = ?";
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void insertUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
    }
	
	@SuppressWarnings("unchecked")
	public User findByLogin(String login) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
		query.setParameter("login", login);
		List<User> users = (List<User>)query.getResultList();
		if(users.isEmpty()) {
			return null;
		} else return users.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public boolean findByLognAndPass(String login, String password) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		List<User> users  = (List<User>)query.getResultList();
		if(!users.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public int findUserId(String login) {
		Query query = entityManager.createQuery("SELECT u.id FROM User u WHERE u.login = :login");
		query.setParameter("login", login);
	    return (int) query.getSingleResult();
	}
	
//	private static class UserMapper implements RowMapper {
//		@Override
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user = new User();
//            user.setLogin(rs.getString("login"));
//            user.setPassword(rs.getString("passwrd"));
//            return user;
//		}
//	}
}
