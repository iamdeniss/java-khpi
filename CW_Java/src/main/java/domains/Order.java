package main.java.domains;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int orderId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
	@Basic
	@Column(name = "adr")
	private String adress;
	@Basic
	private String card;
	@Basic
	private String goods;
	
	private int total;

	public Order(User userId, String adress, String card, String goods) {
		this.userId = userId;
		this.adress = adress;
		this.card = card;
		this.goods = goods;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getCard() {
		return card;
	}
	
	public void setCard(String card) {
		this.card = card;
	}
	
	public String getGoods() {
		return goods;
	}
	
	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
