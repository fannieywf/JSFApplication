package de.javajsf.knowledgeaccelerator.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import de.javajsf.knowledgeaccelerator.dao.PointDAOImpl;
import de.javajsf.knowledgeaccelerator.model.Point;

@SessionScoped
@ManagedBean
public class PointBean {
	
	private PointDAOImpl dao;
	private Point point;
	
	public static List<Point> points;
	public static int points_size;
	
	private Object pt;
	private List<Object> pts;
	
	private Double inputX;
	private Double inputY;

	@PostConstruct
	public void init() {
		dao = new PointDAOImpl();
		point = new Point();
		points = dao.getAll();
		
		pt = new Object();
		pts = new ArrayList<>();
	}

	public PointDAOImpl getDao() {
		return dao;
	}

	public void setDao(PointDAOImpl dao) {
		this.dao = dao;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public static List<Point> getPoints() {
		return points;
	}

	public static void setPoints(List<Point> points) {
		PointBean.points = points;
	}

	public Object getPt() {
		return pt;
	}

	public void setPt(Object pt) {
		this.pt = pt;
	}

	public List<Object> getPts() {
		return pts;
	}

	public void setPts(List<Object> pts) {
		this.pts = pts;
	}

	public Double getInputX() {
		return inputX;
	}

	public void setInputX(Double inputX) {
		this.inputX = inputX;
	}

	public Double getInputY() {
		return inputY;
	}

	public void setInputY(Double inputY) {
		this.inputY = inputY;
	}
	
	public void addInput() {
		point.setX(inputX);
		point.setY(inputY);
		
		dao.addPoint(point);
		points = dao.getAll();
		points_size = points.size();
	}
	
	public void showChart() {
	}
	
	
}
