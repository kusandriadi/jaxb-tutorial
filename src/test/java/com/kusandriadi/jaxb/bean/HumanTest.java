package com.kusandriadi.jaxb.bean;

import static org.testng.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kusandriadi.jaxb.factory.HumanFactory;

public class HumanTest {
	
	private People people1;
	private People people2;
	
	private Address address1;
	private Address address2;
	
	@BeforeClass
	public void init() {
		address1 = new Address().street("sudirman").city("jakarta");
		address2 = new Address().street("thamrin").city("jakarta");
		
		people1 = new People("01").name("pieter").age(22).phone("021-7892819");
		people1.address(address1);
		
		people2 = new People("02").name("vidal").age(18).phone("021-2819182");
		people2.address(address1);
		people2.address(address2);
	}
	
	@Test
	public void testHumanMarshallerAndUnmarshaller() throws JAXBException, Exception {
		Human human = new Human();
		
		human.addPeople(people1);
		String contents = constructMarshaller(human);
		assertEquals(contents, testOnePeople());
		
		human.addPeople(people2);
		contents = constructMarshaller(human);
		assertEquals(contents, testTwoPeople());
		
		Unmarshaller unmarshaller = HumanFactory.getHumanContext().createUnmarshaller();
		Human unmarshallHuman = (Human) unmarshaller.unmarshal(buildFile());
		
		assertEquals(2, unmarshallHuman.getPeople().size());
		assertEquals(2, unmarshallHuman.getPeople().get(1).getAddress().size());
		assertEquals("pieter", unmarshallHuman.getPeople().get(0).getName());
		assertEquals("vidal", unmarshallHuman.getPeople().get(1).getName());
	}
	
	private String constructMarshaller(Human human) throws JAXBException, Exception {
		File configFile = buildFile();
		Marshaller marshaller = HumanFactory.getHumanContext().createMarshaller();
		marshaller.marshal(human, configFile);
		return FileUtils.readFileToString(configFile);
	}
	
	private File buildFile() {
		return new File("target", "human.xml");
	}
	
	private final String testOnePeople() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
				"<human>" +
				"<people id=\"01\">" +
					"<name>pieter</name>" +
					"<age>22</age>" +
					"<phone>021-7892819</phone>" +
					"<addresses>" +
						"<address>" +
							"<street>sudirman</street>" +
							"<city>jakarta</city>" +
						"</address>" +
					"</addresses>" +
				"</people>" +
			"</human>";
	}
	
	private final String testTwoPeople() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
				"<human>" +
				"<people id=\"01\">" +
					"<name>pieter</name>" +
					"<age>22</age>" +
					"<phone>021-7892819</phone>" +
					"<addresses>" +
						"<address>" +
							"<street>sudirman</street>" +
							"<city>jakarta</city>" +
						"</address>" +
					"</addresses>" +
				"</people>" +
				"<people id=\"02\">" +
					"<name>vidal</name>" +
					"<age>18</age>" +
					"<phone>021-2819182</phone>" +
					"<addresses>" +
						"<address>" +
							"<street>sudirman</street>" +
							"<city>jakarta</city>" +
						"</address>" +
						"<address>" +
							"<street>thamrin</street>" +
							"<city>jakarta</city>" +
						"</address>" +
					"</addresses>" +
				"</people>" +
			"</human>";
	}

}
