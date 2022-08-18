package com.yashu.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	/*@Column(name="user_id")
	private int userid;*/
	
	
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="address_line_one")
	@NotBlank(message="Please enter the Address!")
	private String addressLineOne;
	@Column(name="address_line_two")
	@NotBlank(message="Please enter the Address!")
	private String addreddLineTwo;
	@NotBlank(message="Please enter the City!")
	private String city;
	@NotBlank(message="Please enter the State!")
	private String state;
	@NotBlank(message="Please enter the Country!")
	private String country;
	@Column(name="postal_code")
	@NotBlank(message="Please enter the PostalCode!")
	private String postalcode;
	private boolean shipping;
	private boolean billing;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddreddLineTwo() {
		return addreddLineTwo;
	}
	public void setAddreddLineTwo(String addreddLineTwo) {
		this.addreddLineTwo = addreddLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", user=" + user + ", addressLineOne=" + addressLineOne + ", addreddLineTwo="
				+ addreddLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalcode="
				+ postalcode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	
	
	
	

}
