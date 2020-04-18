package de.javajsf.knowledgeaccelerator.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import de.javajsf.knowledgeaccelerator.hibernate.HibernateUtil;
import de.javajsf.knowledgeaccelerator.model.Point;

/**
 * @author yuenfannie
 */

public class PointDAOImpl implements PointDAO {
	
	public static List<Point> points = new ArrayList<>();
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Point findPoint(Double x, Double y) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Point point = session.createQuery("FROM Point WHERE x=:xx AND y=:yy", Point.class)
				.setParameter("xx", x)
				.setParameter("yy", y)
				.uniqueResult();
		tx.commit();
		return point;
	}
	
	@Override
	public boolean addPoint(Point newPoint) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(newPoint);
		tx.commit();
		return tx.getStatus()==TransactionStatus.COMMITTED;
	}

	@Override
	public List<Point> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query<Point> q = session.createQuery("FROM Point", Point.class);
		List<Point> points = q.getResultList();
		tx.commit();
		return points;
	}
	
	public static void main(String[] args) {
		PointDAOImpl dao = new PointDAOImpl();
	}
}
