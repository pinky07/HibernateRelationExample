package com.infotech.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {

	@Id
	@Column(name="phone_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "brand",length=50)
    private String brand;
	
	@Column(name = "model",length=50)
    private String model;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="user_phone", joinColumns = @JoinColumn(name="phone_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
	private User user;
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Phone [Id=" + id + ", brand=" + brand + ", model=" + model + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
   
}
