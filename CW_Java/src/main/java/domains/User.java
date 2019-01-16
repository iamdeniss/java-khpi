package main.java.domains;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int user_id;
	@Basic
	private String login;
	@Basic
	@Column(name = "passwrd")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
    private Collection<Order> orders;
	
	public User () {}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public int getUserID() {
		return user_id;
	}

	public void setUserID(int userID) {
		this.user_id = user_id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
