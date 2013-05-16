package com.kusandriadi.jaxb.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="address")
@XmlType(propOrder = { "street", "city" })
public class Address {
	
	@XmlElement(required=true)
	private String street;
	
	@XmlElement(required=true)
	private String city;
	
	@XmlTransient
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@XmlTransient
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/*
	 *  all methods below made for test purpose
	 */
	public Address street(String street) {
		setStreet(street);
		return this;
	}
	
	public Address city(String city) {
		setCity(city);
		return this;
	}
}
