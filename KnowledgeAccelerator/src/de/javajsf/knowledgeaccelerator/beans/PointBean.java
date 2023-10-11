package de.javajsf.knowledgeaccelerator.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.charts.data.NumericPoint;

import de.javajsf.knowledgeaccelerator.dao.PointDAOImpl;
import de.javajsf.knowledgeaccelerator.model.ChartJsView;
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
		System.out.println("init PointBean...");
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
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
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
	
	public void addInput() {
		System.out.println("set inputX & inputY...");
		point.setX(inputX);
		point.setY(inputY);		
		System.out.println("point after setX & setY: " + point);

		System.out.println("dao.addPoint...");
		dao.addPoint(point);
		System.out.println("dao.getAll...");
		points = dao.getAll();
		System.out.println("points after dao.getAll: " + points);
		System.out.println("points are gotten.");
		points_size = points.size();
		System.out.println("points_size: (PB)" + points_size);

		}
	
	public void showChart() {
	}

	public static void main(String[] args) {
		System.out.println("Running PointBean...");
		PointBean pb = new PointBean();
		System.out.println("getAll by init...");
		pb.init();
		System.out.println("addInput...");
		pb.addInput();
		System.out.println("showChart...");
		pb.showChart();
	}
	
}
