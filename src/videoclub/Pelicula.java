package videoclub;

import java.util.Scanner;

public enum Pelicula implements CodBarras, Cloneable{

	NOVEDADES(3, 1), SEMI_NOVEDADES(2, 2), ANTIGUAS(1, 4);

	private static int codGenerico = 10000;
	private int codBarras;
	private String titulo;
	private int precio;
	private int diasAlquilados;

	public void generadorCodBarras() {

		codBarras = codGenerico;
		codGenerico++;

	}

	public int introducirPelicula() {
		Scanner scLine = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		System.out.println("Titulo de la pelicula");
		this.titulo = scLine.nextLine();
		System.out.println("Cantidad de unidades");
		int cantidad = scInt.nextInt();

		codBarras = codGenerico;
		codGenerico++;

		return cantidad;
	}
	
	public Object clonarPelicula() throws CloneNotSupportedException 
	   {
	      return (CD)super.clone();
	   }
	

	public void mostrarDatos() {

		System.out.println(this.codBarras + " " + this.titulo + ", " + this.precio + " euros, " + this.diasAlquilados
				+ " dias restantes");

	}


	private Pelicula(int precio, int diasAlquilados) {

		this.precio = precio;
		this.diasAlquilados = diasAlquilados;

	}

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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}

	public void setDiasAlquilados(int diasAlquilados) {
		this.diasAlquilados = diasAlquilados;
	}

}
