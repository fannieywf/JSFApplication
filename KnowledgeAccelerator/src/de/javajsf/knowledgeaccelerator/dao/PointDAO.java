package de.javajsf.knowledgeaccelerator.dao;

import java.util.List;

import de.javajsf.knowledgeaccelerator.model.Point;

public interface PointDAO {

	public Point findPoint(Double x, Double y);
	public boolean addPoint(Point newPoint);
	public List<Point> getAll();
}
