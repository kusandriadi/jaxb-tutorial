package com.kusandriadi.jaxb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="people")
@XmlType(propOrder = { "name", "age", "phone", "address"})
public class People {
	
	@XmlAttribute
	private String id;
	
	@XmlElement(required=true)
	private String name;
	
	@XmlElement
	private int age;
	
	@XmlElement(required=true)
	private String phone;
	
	@XmlElementWrapper(name = "addresses", required = true)
	private List<Address> address = new ArrayList<Address>();
	
	public People() {}
	
	public People(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@XmlTransient
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlTransient
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlTransient
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@XmlTransient
	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	/*
	 *  all methods below made for test purpose
	 */
	public People name(String name) {
		setName(name);
		return this;
	}
	
	public People age(int age) {
		setAge(age);
		return this;
	}
	
	public People phone(String phone) {
		setPhone(phone);
		return this;
	}
	
	public People address(Address address) {
		getAddress().add(address);
		return this;
	}
	
	public People addresses(List<Address> address) {
		setAddress(address);
		return this;
	}
}
