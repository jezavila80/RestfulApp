package com.jezavila.ws.rest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jezavila.database.ConnectionDB;
import model.Alumnos;
import com.jezavila.jdbc.DatabaseService;
import com.jezavila.ws.rest.vo.VOUsuario;

@Path("/JavaJez")
public class ServiceLogin {

	@POST
	@Path("/validaUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOUsuario validaUsuario(VOUsuario vo) {
		vo.setUserValido(false);
		if (vo.getUsuario().equals("JJ") && vo.getPassword().equals("jezreel")) {
			// insertBeanAlumno();
			vo.setPassword("********");
			vo.setUserValido(true);
			// ConnectionDB.getConnection().insertAlumno();

		}
		return vo;
	}

	@POST
	@Path("/consultaAlumno")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Alumnos validaUsuario(Alumnos vo) {
		if (vo.getId_alumno() != 0) {
			vo = consultaBeanAlumno(vo);
			// vo.setUserValido(true);
			// ConnectionDB.getConnection().insertAlumno();

		}
		return vo;
	}

	@POST
	@Path("/insertaAlumno")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Alumnos insertaAlumno(Alumnos vo) {
		if (vo.getId_alumno() != 0) {
			vo = insertaBeanAlumno(vo);
		}
		return vo;
	}

	public static Alumnos consultaBeanAlumno(Alumnos al) {
		try {
			Connection myConn = DatabaseService.getConnection();

			System.out.println("Connection successful");

			PreparedStatement ps = myConn
					.prepareStatement("Select * From alumnos where id_alumno = " + al.getId_alumno());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				al.setNombres(rs.getString("nombres"));
				al.setApellido_pat(rs.getString("apellido_pat"));
				al.setApellido_mat(rs.getString("apellido_mat"));
				al.setFecha_admision(rs.getDate("fecha_admision"));
				System.out.println("-----------------------------------" + "\n" + "Id_alumno: "
						+ rs.getString("id_alumno") + "\n" + "Nombre: " + rs.getString("nombres") + "\n"
						+ "Apellido Pat: " + rs.getString("apellido_pat") + "\n" + "Apellido Mat: "
						+ rs.getString("apellido_mat") + "\n" + "-----------------------------------" + "\n");
			} else {
				al.setErrorNo("-1");
				al.setErrorDescrip("No se encontraron registros!");
				System.out.println("No se encontraron registros!");
			}
			try {
				rs.close();
			} catch (Exception ex1) {
			}
			try {
				ps.close();
			} catch (Exception ex1) {
			}
			myConn = null;
			DatabaseService.closeConnection();
			System.out.println("Connection close");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public static Alumnos insertaBeanAlumno(Alumnos al) {
		try {
			Connection myConn = DatabaseService.getConnection();

			System.out.println("Connection successful");

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dfString = df.format(new java.util.Date());
			String query = "Insert into alumnos (nombres, apellido_pat, apellido_mat, fecha_admision) values";
			query += String.format(" ('%s', '%s', '%s', '%s');", al.getNombres(), al.getApellido_pat(), al.getApellido_mat(), df.format(al.getFecha_admision()));

			System.out.println("Query: " + query + " - " + dfString);
			PreparedStatement ps = myConn.prepareStatement(query);
			int res = ps.executeUpdate();
			if (res > 0) {
				al.setErrorNo("0");
				al.setErrorDescrip("Se insertaron " + res + " registros!");
				System.out.println("-----------------------------------" + "\n" + "Nombre: " + al.getNombres() + "\n"
						+ "Apellido Pat: " + al.getApellido_pat() + "\n" + "Apellido Mat: " + al.getApellido_mat()
						+ "\n" + "-----------------------------------" + "\n");
			} else {
				al.setErrorNo("-1");
				al.setErrorDescrip("No se encontraron registros!");
			}
			try {
				ps.close();
			} catch (Exception ex1) {
			}
			myConn = null;
			DatabaseService.closeConnection();
			System.out.println("Connection close");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
