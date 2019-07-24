package com.jezavila.domain;

import java.sql.Date;

import javax.persistence.Column;

public class Alumnos {

	private int id_alumno;
	private String nombres;
	private String apellido_pat;
	private String apellido_mat;
	private Date fecha_admision;

	public Alumnos() {

	}

	public Alumnos(String nombres, String apellidoPat, String apellidoMat) {
		this.nombres = nombres;
		this.apellido_pat = apellidoPat;
		this.apellido_mat = apellidoMat;
		this.fecha_admision = new java.sql.Date(new java.util.Date().getTime());
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido_pat() {
		return apellido_pat;
	}

	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}

	public String getApellido_mat() {
		return apellido_mat;
	}

	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}

	public Date getFecha_admision() {
		return fecha_admision;
	}

	public void setFecha_admision(Date fecha_admision) {
		this.fecha_admision = fecha_admision;
	}

	@Override
	public String toString() {
		return "Alumnos [id_alumno=" + id_alumno + ", nombres=" + nombres + ", apellido_pat=" + apellido_pat
				+ ", apellido_mat=" + apellido_mat + ", fecha_admision=" + fecha_admision + "]";
	}

}
