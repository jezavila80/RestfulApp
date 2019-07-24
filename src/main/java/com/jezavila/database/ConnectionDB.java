package com.jezavila.database;

import org.hibernate.Session;

import com.jezavila.util.HibernateUtil;

import model.Alumnos;

public class ConnectionDB {
	
	private static ConnectionDB conn; 

	public static ConnectionDB getConnection() {
		if (conn == null) {
			conn = new ConnectionDB();
			return conn;
		}
		return conn;
	}
	
	public void insertAlumno() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Alumnos message = new Alumnos("Jezreel","Avila","Fierros");

		session.save(message);    
		
//		Query query = session.createQuery("from alumnos where id_alumno = :id ");
//		query.setParameter("id", 5);
//		
//		List<?> list = query.list();
//		
//		Alumnos alumno = (Alumnos)list.get(0);
//		
//		System.out.println("Alumno : " + alumno);

			// execute search
			

		session.getTransaction().commit();
		session.close();
	}

}
