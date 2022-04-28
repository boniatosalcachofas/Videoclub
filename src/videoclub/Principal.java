package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal{
	int a = 0;
	static ArrayList<Pelicula> arrayPeliculas = new ArrayList();
	static ArrayList<Cd> arrayCds = new ArrayList();
	static int dia = 1;
	static int selectorColeccion = 0;

	public static void main(String[] args) {
		while (true) {
			menuPrincipal();
		}
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
			mostrarInformacion(true, true);
			break;
		case 3:
			mostrarInformacion(true, false);
			break;
		case 4:
			mostrarInformacion(false, true);
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
		case 2:
			crearCds();
			break;

		}

	}

	public static void crearPeliculas() {

		Pelicula objetoTemporal = new Pelicula();
		int cantidadCopias = objetoTemporal.introducirPelicula();
		arrayPeliculas.add(objetoTemporal);
		int numPeliculas = 1;
		
		if (cantidadCopias > 1) {
			crearCopia(cantidadCopias, numPeliculas, true);
		}
	}
	
	public static void crearCds() {
		
		Cd objetoTemporal = new Cd();
		int cantidadCopias = objetoTemporal.introducirCd();
		arrayCds.add(objetoTemporal);
		int numCds = 1;
	
		if (cantidadCopias > 1) {
			crearCopia(cantidadCopias, numCds, false);
		}
		
	}
	
	//True informa al metodo de que ha recibido una pelicula y false un cd
	private static void crearCopia(int cantidadCopias, int numProductos, boolean peliCd) {
		
		
		if (peliCd) {
			int posicionPeli = arrayPeliculas.size()-1;
			
			while (numProductos < cantidadCopias) {
				Pelicula objetoTemporal = new Pelicula(arrayPeliculas.get(posicionPeli));
				objetoTemporal.generadorCodBarras();
				arrayPeliculas.add(objetoTemporal);
				numProductos++;
			} 
		}else if(!peliCd) {
			while (numProductos < cantidadCopias) {
				int posicionCd = arrayCds.size() - 1;
				Cd objetoTemporal = new Cd(arrayCds.get(posicionCd));
				objetoTemporal.generadorCodBarras();
				arrayCds.add(objetoTemporal);
				numProductos++;
			}
			
		}
	}
	
	
	


	
	//Dos boolean para reconocer si mostrar peliculas o cds
	public static void mostrarInformacion(boolean mostrarPelicula, boolean mostrarCd) {
		//posible error
		Scanner scInt = new Scanner(System.in);
		
		boolean stock = false;
		
		if (mostrarPelicula) {
			if (arrayPeliculas.size() > 0) {
				for (int i = 0; i < arrayPeliculas.size(); i++) {

					stock = true;
					arrayPeliculas.get(i).mostrarDatos((i + 1));

				}
			} 
		}
		if (mostrarCd) {
			if (arrayCds.size() > 0) {
				for (int i = 0; i < arrayCds.size(); i++) {

					if (mostrarPelicula) {
						arrayCds.get(i).mostrarDatos((arrayPeliculas.size() + i + 1));
					}else if (!mostrarPelicula) arrayCds.get(i).mostrarDatos((i + 1));

					stock = true;
					
				}
			} 
		}
		if (!stock) System.out.println("No hay stock de peliculas o cds");
		else if (stock && mostrarPelicula && mostrarCd) {
			int eleccion = scInt.nextInt();
			eliminarProducto(eleccion - 1);
		}
	}
	
	 

	
	public static void eliminarProducto(int posiProducto) {
		ArrayList <Multimedia> arrayCompacto = new ArrayList();
		arrayCompacto.addAll(arrayPeliculas);
		arrayCompacto.addAll(arrayCds);
		if(arrayCompacto.get(posiProducto) instanceof Pelicula) arrayPeliculas.remove(posiProducto);
		else if(arrayCompacto.get(posiProducto) instanceof Cd) arrayCds.remove(posiProducto-arrayPeliculas.size());
		
	}

}
