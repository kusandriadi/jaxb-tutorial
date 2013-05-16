package com.kusandriadi.jaxb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "human")
public class Human {
	
	@XmlElement(required=true)
	private List<People> people = new ArrayList<People>();
	
	public List<People> getPeople() {
		return people;
	}
	
	/*
	 *  all methods below made for test purpose
	 */
	public Human addPeople(People people) {
		getPeople().add(people);
		return this;
	}
}
