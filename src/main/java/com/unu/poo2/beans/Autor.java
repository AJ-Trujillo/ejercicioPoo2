package com.unu.poo2.beans;

public class Autor {

	private int idAutor;

	public Autor() {
		super();

	}

	public Autor(int idAutor, String nombreAutor, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nacionalidad = nacionalidad;
		this.nombreAutor = nombreAutor;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	private String nacionalidad;
	private String nombreAutor;

}
