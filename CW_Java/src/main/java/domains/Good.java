package main.java.domains;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Good implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Basic
	private String name;
	@Basic
	private int price;
	@Basic
	private String description;
	@Basic
	private String photo;
	
	public Good() {}
	
	public Good(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public Good(String name, int price, String description, String photo) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.photo = photo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
