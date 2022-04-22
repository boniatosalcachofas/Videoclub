package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	int a = 0;
	static ArrayList<Pelicula> arrayPeliculas = new ArrayList();
	static int dia = 1;
	static int selectorColeccion = 0;

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
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
			System.out.println("dhk");
		case 3:
			System.out.println("haha");
			break;
		case 4:
			System.out.println("hehe");
			break;

		}

	}

	public static void nuevoProducto() {
		// posible error
		Scanner scInt = new Scanner(System.in);
		int eleccion = 0;

		System.out.println("¿Desea introducir una pelicula o un CD?\n" + "1.- Pelicula\n" + "2.- CD");

		eleccion = scInt.nextInt();
		
		
		switch (eleccion) {

		case 1:

			crearPeliculas();
			break;

		}

	}

	private static void crearPeliculas() {

		crearObjetoPelicula();
		int posicionPeli = arrayPeliculas.size() - 1;

		int cantidadPeliculas = arrayPeliculas.get(posicionPeli).introducirPelicula();
		int peliculasIntroducidas = 1;

		while (peliculasIntroducidas < cantidadPeliculas) {

			Pelicula objetoTemporal;
			objetoTemporal = arrayPeliculas.get(posicionPeli);
			arrayPeliculas.add(objetoTemporal);
			peliculasIntroducidas++;

		}

	}

	private static void crearObjetoPelicula() {

		Pelicula objetoTemporal = Pelicula.NOVEDADES;
		objetoTemporal = antiguedadPelicula(objetoTemporal);
		arrayPeliculas.add(objetoTemporal);
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

}
