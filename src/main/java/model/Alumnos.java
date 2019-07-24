package model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="alumnos")
public class Alumnos {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -3134773351903947762L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="id_alumno")	
	private int id_alumno;	
	
	@Column(name="nombres")	
	private String nombres;
	
	@Column(name="apellido_pat")	
	private String apellido_pat;
	
	@Column(name="apellido_mat")	
	private String apellido_mat;
	
	@Column(name="fecha_admision")
	private Date fecha_admision;
	
	private String errorNo = "0";
	
	private String errorDescrip = "";

	public Alumnos() {
		
	}
	
	public Alumnos(String nombres, String apellidoPat, String apellidoMat) {
		this.nombres = nombres;
		this.apellido_pat = apellidoPat;
		this.apellido_mat = apellidoMat;
		this.fecha_admision = new java.sql.Date(new java.util.Date().getTime());
	}

	@Override
	public String toString() {
		return "Alumnos [id_alumno=" + id_alumno + ", nombres=" + nombres
				+ ", apellido_pat=" + apellido_pat + ", apellido_mat="
				+ apellido_mat + ", fecha_admision=" + fecha_admision + "]";
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
	
	public String getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorDescrip() {
		return errorDescrip;
	}

	public void setErrorDescrip(String errorDescrip) {
		this.errorDescrip = errorDescrip;
	}
}
