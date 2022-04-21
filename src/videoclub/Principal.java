package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	ArrayList<Pelicula> arrayPeliculas = new ArrayList();
	static int dia = 1;

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
		//posible error
		Scanner scInt = new Scanner(System.in);

			System.out.println("MENU: DIA " + dia + "\n"
					+ "1.- Introducir nuevo producto.\n"
					+ "2.- Eliminar producto\n"
					+ "3.- Ver listado de películas\n"
					+ "4.- Ver listado de CDs\n"
					+ "5.- Alquilar película\n"
					+ "6.- Vender disco\n"
					+ "7.- Ver películas en alquiler\n"
					+ "8.- Ver ganancias\n"
					+ "9.- Pasar al día siguiente");

			int eleccion = scInt.nextInt();
			
			
			switch(eleccion) {
			
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
	
	public static  eleccion() {
		
		int eleccion;
		
	}
	
	public static void nuevoProducto() {
		
		Scanner scInt = new Scanner(System.in);
		int eleccion
		
		System.out.println("¿Desea introducir una pelicula o un CD?");
		
	}

	}
