package videoclub;

import java.util.Scanner;

public class Cd extends Multimedia implements CodBarras{


	private static int codGenerico = 20000;
	private String nombreArtista;
	
	public void generadorCodBarras() {

		this.setCodBarras(codGenerico);
		codGenerico++;
	}
	
	public int introducirCd() {
		Scanner scLine = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Titulo del disco");
		this.setTitulo(scLine.nextLine());
		System.out.println("Nombre del artista");
		this.nombreArtista = scLine.nextLine();
		System.out.println("Precio del producto:");
		this.setPrecio(scInt.nextDouble());
		System.out.println("Cantidad de unidades");
		int cantidad = scInt.nextInt();
		
		this.setCodBarras(codGenerico);
		codGenerico++;
		
		return cantidad;
	}
	
	public void mostrarDatos(int i) {
		
		System.out.println(i + ".- " + this.getCodBarras() + " " + this.getTitulo() + ", " + this.nombreArtista + ", " + this.getPrecio() + " euros.");		
	}
	
	
	public double revenueSale() {
		
		return this.getPrecio();
		
	}
	
	
	public Cd() {
		super();
	}
	
	public Cd(Cd cdCopia) {
		this(cdCopia.getTitulo(), cdCopia.getPrecio(), cdCopia.nombreArtista);
		
	}
	
	

	public Cd(String titulo, double precio, String nombreArtista) {
		super(titulo, precio);
		this.nombreArtista = nombreArtista;
	}

	//getters and setters
	
	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}
	
	public String getNombreArtista() {
		return nombreArtista;
	}
	
	public static int getCodGenerico() {
		return codGenerico;
	}

	public static void setCodGenerico(int codGenerico) {
		Cd.codGenerico = codGenerico;
	}

	

}
