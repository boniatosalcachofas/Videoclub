package videoclub;

import java.util.Scanner;

public class Multimedia {

	
	private int codBarras;
	private String titulo;
	private double precio;

	
	
	//Constructor
	public Multimedia() {
		super();
	}
	
	public Multimedia(String titulo, double precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		
	}

	//getters and setters
	public int getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
