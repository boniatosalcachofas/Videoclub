package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal implements Cloneable{
	int a = 0;
	static ArrayList<Pelicula> arrayPeliculas = new ArrayList();
	static ArrayList<CD> arrayCds = new ArrayList();
	static int dia = 1;
	static int selectorColeccion = 0;

	public static void main(String[] args) throws CloneNotSupportedException{
		while (true) {
			menuPrincipal();
		}
	}

	public static void menuPrincipal() throws CloneNotSupportedException {
		// posible error
		Scanner scInt = new Scanner(System.in);

		System.out.println("MENU: DIA " + dia + "\n" + "1.- Introducir nuevo producto.\n" + "2.- Eliminar producto\n"
				+ "3.- Ver listado de películas\n" + "4.- Ver listado de CDs\n" + "5.- Alquilar película\n"
				+ "6.- Vender disco\n" + "7.- Ver películas en alquiler\n" + "8.- Ver ganancias\n"
				+ "9.- Pasar al día siguiente");

		int eleccion = scInt.nextInt();

		switch (eleccion) {

		case 1:
			nuevoProducto();
			break;
		case 2:
			mostrarInformacion();
		case 3:
			System.out.println("haha");
			break;
		case 4:
			System.out.println("hehe");
			break;

		}

	}

	public static void nuevoProducto() throws CloneNotSupportedException {
		// posible error
		Scanner scInt = new Scanner(System.in);
		int eleccion = 0;

		System.out.println("¿Desea introducir una pelicula o un CD?\n" + "1.- Pelicula\n" + "2.- CD");

		eleccion = scInt.nextInt();
		
		
		switch (eleccion) {

		case 1:

			crearPeliculas();
			break;
		case 2:
			crearCds();
			break;

		}

	}

	public static void crearPeliculas() throws CloneNotSupportedException {

		crearObjetoMultimedia(true);
		int posicionPeli = arrayPeliculas.size() - 1;

		int cantidadPeliculas = arrayPeliculas.get(posicionPeli).introducirPelicula();
		int peliculasIntroducidas = 1;

		while (peliculasIntroducidas < cantidadPeliculas) {

			Pelicula objetoTemporal;
			objetoTemporal = (Pelicula)arrayPeliculas.get(posicionPeli).clonarPelicula();
			objetoTemporal.generadorCodBarras();
			arrayPeliculas.add(objetoTemporal);
			peliculasIntroducidas++;

		}
		

	}
	
	public static void crearCds()  {
		
		crearObjetoMultimedia(false);
		int posicionCd = arrayCds.size() - 1;

		int cantidadCds = arrayCds.get(posicionCd).introducirCd();
		int CdsIntroducidas = 1;

		while (CdsIntroducidas < cantidadCds) {

			CD objetoTemporal;
			objetoTemporal = (CD)arrayCds.get(posicionCd).clonarCd();
			objetoTemporal.generadorCodBarras();
			arrayCds.add(objetoTemporal);
			CdsIntroducidas++;

		}
		
		
	}

	private static void crearObjetoMultimedia(boolean peliCd) {

		if (peliCd) {
			Pelicula objetoTemporal = Pelicula.NOVEDADES;
			objetoTemporal = antiguedadPelicula(objetoTemporal);
			arrayPeliculas.add(objetoTemporal);
		} else if (!peliCd) {

			CD objetoTemporal = CD.NOVEDADES;
			objetoTemporal = antiguedadCd(objetoTemporal);
			arrayCds.add(objetoTemporal);
		}
	}

	private static Pelicula antiguedadPelicula(Pelicula objetoTemporal) {
		Scanner scInt = new Scanner(System.in);

		while (true) {

			// posible error

			System.out.println("Antiguedad de la pelicula:" + "\n1.- Novedad" + "\n2.- Semi-novedad" + "\n3.- Antigua");

			int eleccion = scInt.nextInt();

			if (eleccion == 1) {
				objetoTemporal = Pelicula.NOVEDADES;
				break;
			} else if (eleccion == 2) {
				objetoTemporal = Pelicula.SEMI_NOVEDADES;
				break;
			} else if (eleccion == 3) {
				objetoTemporal = Pelicula.ANTIGUAS;
				break;
			}

			else
				System.out.println("Por favor, elija un valor valido");
		}
		return objetoTemporal;
	}
	
	public static CD antiguedadCd(CD objetoTemporal) {
		
		Scanner scInt = new Scanner(System.in);

		while (true) {

			// posible error

			System.out.println("Antiguedad del CD:" + "\n1.- Novedad" + "\n2.- Semi-novedad" + "\n3.- Antigua");

			int eleccion = scInt.nextInt();

			if (eleccion == 1) {
				objetoTemporal = CD.NOVEDADES;
				break;
			} else if (eleccion == 2) {
				objetoTemporal = CD.SEMI_NOVEDADES;
				break;
			} else if (eleccion == 3) {
				objetoTemporal = CD.ANTIGUAS;
				break;
			}

			else
				System.out.println("Por favor, elija un valor valido");
		}
		return objetoTemporal;
		
	}
	
	public static void mostrarInformacion() {
		//posible error
		Scanner scInt = new Scanner(System.in);
		
		boolean stock = false;
		
		if (arrayPeliculas.size() > 0) {
			for (int i = 0; i < arrayPeliculas.size(); i++) {

				stock = true;
				System.out.print((i + 1) + ".- " + arrayPeliculas.get(i).name().toLowerCase() + ": ");
				arrayPeliculas.get(i).mostrarDatos();

			} 
		}
		if (arrayCds.size() > 0) {
			for (int i = 0; i < arrayCds.size(); i++) {

				stock = true;
				System.out.print((i + (arrayPeliculas.size() - 1)) + ".- " + arrayCds.get(i).name().toLowerCase() + ": ");
				arrayCds.get(i).mostrarDatos();

			} 
		}
		if (!stock) System.out.println("No hay stock de peliculas o cds");
		int eleccion = scInt.nextInt();
	}
	
	 

	
	public static void eliminarProducto() {
		
		
		
	}

}
