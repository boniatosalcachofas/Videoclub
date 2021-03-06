package videoclub;

import java.util.Scanner;

public class Pelicula extends Multimedia implements CodBarras{


	private static int codGenerico = 10000;
	private int diasAlquilados;
	private String antiguedad;
	boolean alquilada = false;
	
	public int introducirPelicula() {
		Scanner scLine = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Titulo de la pelicula");
		this.setTitulo(scLine.nextLine());
		elegirAntiguedad();
		System.out.println("Cantidad de unidades");
		int cantidad = scInt.nextInt();
		
		this.setCodBarras(codGenerico);
		codGenerico++;
		
		return cantidad;
	}

	public void elegirAntiguedad() {
		
				Scanner scInt = new Scanner(System.in);
				
				System.out.println("Antiguedad de la pelicula:\n"
						+ "1.- Novedad\n"
						+ "2.- Semi-novedad\n"
						+ "3.- Antigua");
				
				
				int eleccion = scInt.nextInt();
				
				switch (eleccion) {
				
				case 1:
					this.antiguedad = "Novedad";
					this.setPrecio(3);
					this.diasAlquilados = 1;
					break;
				case 2:
					this.antiguedad = "Semi-novedad";
					this.setPrecio(2);
					this.diasAlquilados = 2;
					break;
				case 3:
					this.antiguedad = "Antigua";
					this.setPrecio(1);
					this.diasAlquilados = 4;
					break;
				
				}
				
				
		
	}
	
	
	public void generadorCodBarras() {

		this.setCodBarras(codGenerico);
		codGenerico++;

	}


	

	

	public void mostrarDatos(int i) {

		System.out.println(i + ".- " + this.antiguedad + ": " + this.getCodBarras() + " " + this.getTitulo() + ", " + this.getPrecio() + " euros, " + this.diasAlquilados
				+ " dias restantes");

	}
	
	public double alquilarPelicula() {
		
		this.alquilada = true;
		return this.getPrecio();
	}
	
	public void daysLeft() {
		
		if (alquilada) {
			diasAlquilados--;
			if (diasAlquilados == 0) {

				returnFilm();

			} 
		}
		
	}
	
	public void returnFilm() {
		
		alquilada = false;
		System.out.println("La pelicula " + this.getTitulo() + " con codigo " + this.getCodBarras() + " ha sido devuelta");
		
	}

	//constructor
	
	public Pelicula(Pelicula peliCopia) {
		this(peliCopia.getTitulo(), peliCopia.getPrecio(), peliCopia.diasAlquilados, peliCopia.antiguedad);
		
	}
	
	
	public Pelicula() {
		super();
	}

	public Pelicula(String titulo, double precio, int diasAlquilados, String antiguedad) {
		super(titulo, precio);
		this.diasAlquilados = diasAlquilados;
		this.antiguedad = antiguedad;
	}

	//Getters and setters
	
	
	public boolean isAlquilada() {
		return alquilada;
	}

	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}
	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public static int getCodGenerico() {
		return codGenerico;
	}


	public static void setCodGenerico(int codGenerico) {
		Pelicula.codGenerico = codGenerico;
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}

	public void setDiasAlquilados(int diasAlquilados) {
		this.diasAlquilados = diasAlquilados;
	}



}
