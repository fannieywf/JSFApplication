package de.javajsf.knowledgeaccelerator.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.charts.data.NumericPoint;

import de.javajsf.knowledgeaccelerator.beans.PointBean;

public class DataService {
	
	Logger log = LogManager.getLogger(DataService.class);
	
	public void logInfoMethod() {
		log.info("Methode");
		}
	
	public static List<Object> createList() {
		
		List<Object> pts = new ArrayList<>();
				
		for (int row = 0; row < PointBean.points_size; row++) {
			pts.add(new NumericPoint(PointBean.points.get(row).getX(), PointBean.points.get(row).getY()));
		}

		return pts;
	}
	
	public static void main(String[] args) {
		System.out.println("Running DataService...");
		DataService ds = new DataService();
		System.out.println("pts after createList: " + ds.createList());
		
	}

}
