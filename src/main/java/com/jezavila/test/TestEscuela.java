package com.jezavila.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jezavila.util.HibernateUtil;

import model.Alumnos;

public class TestEscuela {

	public static void main(String[] args) {
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
