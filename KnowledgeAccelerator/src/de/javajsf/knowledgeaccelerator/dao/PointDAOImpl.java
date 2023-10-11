package de.javajsf.knowledgeaccelerator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import de.javajsf.knowledgeaccelerator.hibernate.HibernateUtil;
import de.javajsf.knowledgeaccelerator.model.Point;

/**
 * @author yuenfannie
 *
 */
public class PointDAOImpl implements PointDAO {
	
	public static List<Point> points = new ArrayList<>();

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Point findPoint(Double x, Double y) {
		System.out.println("findPoint...");
		System.out.println("sessionFactory.getCurrentSession...");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session.beginTransaction...");		
		Transaction tx = session.beginTransaction();
		System.out.println("session.createQuery...");
		Point point = session.createQuery("FROM Point WHERE x=:xx AND y=:yy", Point.class)
				.setParameter("xx", x)
				.setParameter("yy", y)
				.uniqueResult();
		System.out.println("tx.commit...");
		tx.commit();
		System.out.println("return point...");
		return point;
	}

	@Override
	public boolean addPoint(Point newPoint) {
		System.out.println("addPoint...");
		System.out.println("sessionFactory.getCurrentSession...");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session.beginTransaction...");
		Transaction tx = session.beginTransaction();
		System.out.println("save...");
		session.save(newPoint);
		System.out.println("tx.commit...");
		tx.commit();
		System.out.println("return tx.getStatus...");
		return tx.getStatus()==TransactionStatus.COMMITTED;
	}

	@Override
	public List<Point> getAll() {
		System.out.println("getAll...");
		System.out.println("sessionFactory.getCurrentSession...");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session.beginTransaction...");
		Transaction tx = session.beginTransaction();
		System.out.println("session.createQuery...");
		Query<Point> q = session.createQuery("FROM Point", Point.class);
		System.out.println("q.getResultList...");
		List<Point> points = q.getResultList();
		System.out.println("tx.commit...");
		tx.commit();
		System.out.println("return points...");
		return points;
	}
	

	public static void main(String[] args) {
		System.out.println("Test PointDAOImpl...");
		PointDAOImpl dao = new PointDAOImpl();
		System.out.println("Point after findPoint: " + dao.findPoint(new Double(23.4), new Double(43.0)));
		System.out.println("findPoint...done");
		System.out.println("addPoint? " + dao.addPoint(new Point(23.4, 43.0)));
		System.out.println("addPoint...done");
		System.out.println("points after getAll: " + dao.getAll());
		System.out.println("getAll...done");
		
	}

}
