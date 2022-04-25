package videoclub;

import java.util.Scanner;

public enum CD implements CodBarras, Cloneable{

	NOVEDADES(3, 1), SEMI_NOVEDADES(2, 2), ANTIGUAS(1, 4);

	private static int codGenerico = 20000;
	private int codBarras;
	private String titulo;
	private String nombreArtista;
	private int precio;
	private int diasAlquilados;

	public void generadorCodBarras() {

		codBarras = codGenerico;
		codGenerico++;
	}
	
	public int introducirCd() {
		Scanner scLine = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Titulo del disco");
		this.titulo = scLine.nextLine();
		System.out.println("Nombre del artista");
		this.nombreArtista = scLine.nextLine();
		System.out.println("Cantidad de unidades");
		int cantidad = scInt.nextInt();
		
		codBarras = codGenerico;
		codGenerico++;
		
		return cantidad;
	}
	
	public void mostrarDatos() {
		
		System.out.println(this.codBarras + " " + this.titulo + ", " + this.nombreArtista + ", " + this.precio + " euros, " + this.diasAlquilados + " dias restantes");
		
	}

	public Object clonarCd() throws CloneNotSupportedException 
	   {
	      return (CD)super.clone();
	   }
	
	
	private CD(int precio, int diasAlquilados) {

		this.precio = precio;
		this.diasAlquilados = diasAlquilados;

	}
	//getters and setters
	public static int getCodGenerico() {
		return codGenerico;
	}

	public static void setCodGenerico(int codGenerico) {
		CD.codGenerico = codGenerico;
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

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
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
