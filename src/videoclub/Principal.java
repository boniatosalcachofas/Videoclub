package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	int a = 0;
	static ArrayList<Pelicula> arrayPeliculas = new ArrayList();
	static ArrayList<Cd> arrayCds = new ArrayList();
	static int dia = 1;
	static double gananciasVenta = 0;
	static int gananciasAlqu = 0;

	public static void main(String[] args) {
		while (true) {
			menuPrincipal();
		}
	}

	public static void menuPrincipal() {
		// posible error
		Scanner scInt = new Scanner(System.in);

		System.out.println("MENU: DIA " + dia + "\n" + "1.- Introducir nuevo producto.\n" + "2.- Eliminar producto\n"
				+ "3.- Ver listado de peliculas\n" + "4.- Ver listado de CDs\n" + "5.- Alquilar pelicula\n"
				+ "6.- Vender disco\n" + "7.- Ver peliculas en alquiler\n" + "8.- Ver ganancias\n"
				+ "9.- Pasar al dia siguiente");

		int eleccion = scInt.nextInt();

		switch (eleccion) {

		case 1:
			nuevoProducto();
			break;
		case 2:
			eliminarProducto();
			break;
		case 3:
			mostrarInformacion(true, false);
			break;
		case 4:
			mostrarInformacion(false, true);
			break;
		case 5:
			alquilarPeli();
			break;
		case 6:
			venderCd();
			break;
		case 7:
			shwRentNoRent(arrayPeliculas, false, true);
			break;
		case 8:
			shwRevenue();
			break;
		case 9:
			switchDay();
			break;

		}

	}
	
	
	public static void switchDay() {
		
		for(int i = 0; i < arrayPeliculas.size(); i++) {
			
			arrayPeliculas.get(i).daysLeft();
			
		}
		dia++;
		
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

	// True informa al metodo de que ha recibido una pelicula y false un cd
	private static void crearCopia(int cantidadCopias, int numProductos, boolean peliCd) {

		if (peliCd) {
			int posicionPeli = arrayPeliculas.size() - 1;

			while (numProductos < cantidadCopias) {
				Pelicula objetoTemporal = new Pelicula(arrayPeliculas.get(posicionPeli));
				objetoTemporal.generadorCodBarras();
				arrayPeliculas.add(objetoTemporal);
				numProductos++;
			}
		} else if (!peliCd) {
			while (numProductos < cantidadCopias) {
				int posicionCd = arrayCds.size() - 1;
				Cd objetoTemporal = new Cd(arrayCds.get(posicionCd));
				objetoTemporal.generadorCodBarras();
				arrayCds.add(objetoTemporal);
				numProductos++;
			}

		}
	}

	public static void eliminarProducto() {
		Scanner scInt = new Scanner(System.in);

		boolean stock = mostrarInformacion(true, true);
		if (stock) {
			int posiProducto = scInt.nextInt() - 1;

			ArrayList<Multimedia> arrayCompacto = new ArrayList();
			arrayCompacto.addAll(arrayPeliculas);
			arrayCompacto.addAll(arrayCds);

			if (arrayCompacto.get(posiProducto) instanceof Pelicula) {
				arrayPeliculas.remove(posiProducto);
			} else if (arrayCompacto.get(posiProducto) instanceof Cd) {
				arrayCds.remove(posiProducto - arrayPeliculas.size());
			}
		}

	}

	public static void alquilarPeli() {
		// posible error
		Scanner scInt = new Scanner(System.in);
		ArrayList<Pelicula> noAlquiladas = new ArrayList();
		
		boolean stock = shwRentNoRent(noAlquiladas, true, false);
		
		if (stock) {
			int eleccion = scInt.nextInt() - 1;
			System.out.println("La prlicula " + noAlquiladas.get(eleccion).getTitulo() + " ha sido alquilada por "
					+ noAlquiladas.get(eleccion).getDiasAlquilados() + " dias");
			gananciasAlqu = gananciasAlqu + (int) noAlquiladas.get(eleccion).alquilarPelicula();
		}
			

	}
	



	public static void venderCd() {
		// Posible error
		Scanner scInt = new Scanner(System.in);

		boolean stock = mostrarInformacion(false, true);

		if (stock) {
			int eleccion = scInt.nextInt() - 1;

			System.out.println("El disco " + arrayCds.get(eleccion).getTitulo() + " de autor " 
					+ arrayCds.get(eleccion).getNombreArtista() + " ha sido vendido por " 
						+ arrayCds.get(eleccion).getPrecio() + " euros");
			
			gananciasVenta = gananciasVenta + arrayCds.get(eleccion).revenueSale();
			arrayCds.remove(eleccion);
		}

	}
	
	public static void shwRevenue () {
		
		System.out.println("Ganancias por alquileres: " + gananciasAlqu + " euros."
				+ "\nGanancias por ventas: " + gananciasVenta + " euros."
				+ "\nGanancias total: " + (gananciasVenta + gananciasAlqu) + " euros.");
		
		
	}
	
	
	
	//los booleanos sirven para elegir que mostrar en dicho metodo, siendo el primero para mostrar las no alquiladas
		//y el segundo para mostrar las alquiladas
		public static boolean shwRentNoRent(ArrayList<Pelicula> noAlquiladas, boolean shwNoRent, boolean shwRent) {
			int numeratedCount = 1;
			boolean stockRent = false;
			boolean stockNoRent = false;
			
			if (arrayPeliculas.size() > 0) {
				for (int i = 0; i < arrayPeliculas.size(); i++) {

					if (!arrayPeliculas.get(i).isAlquilada() && shwNoRent) {
						arrayPeliculas.get(i).mostrarDatos((i + numeratedCount));
						noAlquiladas.add(arrayPeliculas.get(i));
						stockNoRent = true;
					}
					
					else if (arrayPeliculas.get(i).isAlquilada() && shwRent) {
						arrayPeliculas.get(i).mostrarDatos((i + numeratedCount));
						stockRent = true;
					}
					
					
					
					else {
						numeratedCount--;
					}
					
					
				}

			}
			
			if (!stockRent && shwRent) {
				System.out.println("No hay peliculas alquiladas");
				return false;
			} 
			else if (!stockNoRent && shwNoRent){
				System.out.println("Todas las peliculas estan alquiladas o no hay stock de peliculas");
				return false;
				}
			else return true;
		
			
		}
	

	// Dos boolean para reconocer si mostrar peliculas o cds
	public static boolean mostrarInformacion(boolean mostrarPelicula, boolean mostrarCd) {
		// posible error
		Scanner scInt = new Scanner(System.in);

		boolean stockP = false;
		boolean stockC = false;

		if (mostrarPelicula) {
			if (arrayPeliculas.size() > 0) {
				for (int i = 0; i < arrayPeliculas.size(); i++) {

					stockP = true;
					arrayPeliculas.get(i).mostrarDatos((i + 1));

				}
			}
		}
		if (mostrarCd) {
			if (arrayCds.size() > 0) {
				for (int i = 0; i < arrayCds.size(); i++) {

					if (mostrarPelicula) {
						arrayCds.get(i).mostrarDatos((arrayPeliculas.size() + i + 1));
					} else if (!mostrarPelicula)
						arrayCds.get(i).mostrarDatos((i + 1));

					stockC = true;

				}
			}
		}
		if (!stockP && !mostrarCd) {
			noFilmStock();
			return false;
		} else if (!stockC && !mostrarPelicula) {
			noCdStock();
			return false;
		} else if (!stockC && !stockP && mostrarPelicula && mostrarCd) {
			System.out.println("No hay stock de ningun tipo");
			return false;
		} else
			return true;

	}

	public static void noFilmStock() {
		System.out.println("no hay stock de peliculas");
	}
	
	public static void noCdStock() {
		System.out.println("No hay stock de cds");
	}
}
