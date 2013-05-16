package com.kusandriadi.jaxb.factory;

import javax.xml.bind.JAXBContext;

import com.kusandriadi.jaxb.bean.Human;

public class HumanFactory {
	
	private static JAXBContext humanFactory;
	
	public static synchronized JAXBContext getHumanContext() throws Exception {
		if (humanFactory == null) {
			humanFactory = JAXBContext.newInstance(
					Human.class);
		}
		return humanFactory;
	}

}
