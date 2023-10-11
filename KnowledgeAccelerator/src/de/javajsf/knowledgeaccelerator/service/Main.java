package de.javajsf.knowledgeaccelerator.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static Logger log = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		log.info("Log begins...");
		
		DataService ds = new DataService();
		ds.logInfoMethod();
		ds.createList();
		
		log.info("Log ends...");
	}
	
}
