package juegoDeLaVida;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static Scanner entrada;
	
	/**
	 * Pre:---
	 * Post: muestra un menú para accionar el juego, o salir del programa, llamando
	 * a los métodos necesarios para que el juego se ejecute.
	 */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String [][] tablero;
		System.out.println("¡BIENVENIDO AL JUEGO DE LA VIDA!");
		while(true) {
			mostrarMenu();
			int menu = entrada.nextInt();
			if (menu == 1) {
				tablero = creartablero();
				System.out.println("Introduce el número de generaciones de la colonia : ");
				while (true) {
					int generaciones = entrada.nextInt();
					if (generaciones > 0) {
						crearGeneraciones(tablero, generaciones);
						break;
					} else {
						System.out.println("Introduce un número correcto de generaciones");
					}
				}
			} if (menu == 2) {
				System.out.println("¡Adiós!");
				break;
			}
		}

	}
	
	/**
	 * Pre:---
	 * Post: Muestra las opciones que tiene el menú.
	 */
	
	public static void mostrarMenu () {
		System.out.println("¿Qué deseas hacer");
		System.out.println(" 1 . Jugar " );
		System.out.println(" 2 . Salir " );
	}
	
	/**
	 * Pre:---
	 * Post:Este método pide al usuario el número de filas y columnas 
	 * del tablero, y genera uno de dicho tamaño con un 20% de probabilidad
	 * de célula vivas.
	 * 
	 */
	
	public static String[][] creartablero() {
		Scanner entrada = new Scanner(System.in);
		boolean filasbien = false;
		int filas = 0;
		int columnas = 0;
		while (true) {
			System.out.println("Introduce el número de filas del tablero : ");
			filas = entrada.nextInt();
			if (filas > 0) {
				filasbien = true;
				System.out.println("Introduce el número de columnas del tablero:");
				columnas = entrada.nextInt();
				if(columnas > 0) {
					String[][] tablero = new String [filas][columnas];
					for (int i = 0; i < tablero.length; i++) {
						for (int j = 0; j < tablero[i].length; j++) {
							
							int vida = (int) Math.round(Math.random() * 9);
							
							if (vida < 2) {
								tablero[i][j]= "*";
							} else {
								tablero[i][j] =" ";
								}
						}
					} return tablero;
				} else {
					System.out.println("El número de columnas es incorrecto. Introduce un valor mayor que 0.");
				}
			} else {
				System.out.println("El número de filas es incorrecto. Introduce un valor mayor que 0.");
				filasbien = false;
			}
		}
	}
	
	
	/**
	 * Pre:---
	 * Post: Muestra el tablero que se le pasa como parámetro
	 */
	
	public static void mostrarTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	/**
	 * Pre:---
	 * Post: Este método recibe como parámetro el tablero inicial y el número de
	 * generaciones que va a durar la colonia, y genera hasta que terminen las 
	 * generaciones o no queden células vivas . A la vez que esto, se van guardando
	 * en un objeto de tipo Tripleta, los datos referentes a cada generación.
	 */
	
	public static void crearGeneraciones(String[][] tablero, int generaciones) {
		ArrayList <Tripleta> datos = new ArrayList <Tripleta>();
		Tripleta tripleta;
		for (int i = 0; i <= generaciones; i++) {
			System.out.println("GENERACIÓN " + i + "\n");
			mostrarTablero(tablero);
			int celulasVivas = 0;
			for (int j = 0; j < tablero.length; j++) {
				for (int k = 0; k < tablero[j].length; k++) {
					if (tablero[j][k].equals("*")) {
						celulasVivas++;
					}
				}
			}
			if (i == 0) {
				tripleta = new Tripleta (i, celulasVivas, celulasVivas);
				datos.add(tripleta);
			} else {
				int celulasNuevas = celulasVivas - datos.get(i-1).getNumVivas();
				tripleta = new Tripleta (i, celulasVivas, celulasNuevas);
				datos.add(tripleta);
			}
			if (celulasVivas == 0) {
				System.out.println("COLONIA EXTINGUIDA");
				break;
			} else {
				System.out.println("Número de células vivas: " + celulasVivas);
			}
			tablero = siguienteTablero(tablero);
			System.out.println();
		}
		showTripleta(datos);
	}
	
	
	
	/**
	 * Pre:---
	 * Post: Este método muestra por consola el ArrayList que contiene los objetos de 
	 * tipo Tripleta.
	 */
		
	public static void showTripleta(ArrayList<Tripleta> datos) {
		System.out.println("Generación " + "Células vivas " + "Células nuevas ");
		for(int i = 0; i < datos.size(); i++) {
			System.out.println(datos.get(i).toString());
		}
		System.out.println();
	}
	
	
	
	/**
	 * Pre:---
	 * Port: Este método recibe un tablero y genera la próxima generación del mismo
	 * según las normas del juego.
	 */
	
	public static String[][] siguienteTablero (String[][] tablero) {
		String[][] nuevoTablero = new String[tablero.length][tablero[0].length];
		for(int i = 0; i < tablero.length; i++) {
			for ( int j = 0; j < tablero[i].length; j++) {
				int contador = comprobarVecinas (tablero, i, j );
					if (comprobarVida (tablero[i][j])) {
						if (contador < 2 || contador > 3) {
							nuevoTablero[i][j] = " ";
						}
						if (contador == 2 || contador == 3) {
							nuevoTablero[i][j]= "*";
						}
					} else {
						if (contador == 3) {
							nuevoTablero[i][j] = "*";
						} else {
							nuevoTablero[i][j]= " ";
						}
					}
				}
			}
		return nuevoTablero;
	}
		
	
	
	/**
	 * Pre:---
	 * Pot: Este método recibe por parámetro el tablero, y una posición en este y 
	 * comprueba sus casillas vecinas para saber el número de células vivas que hay. 
	 * Va comprobando los límites del tablero.
	 * 
	 */
	
	public static int comprobarVecinas (String[][] tablero, int fila, int columna) {
		int contador = 0;
		
		// Si la celda no está en la esquina superior izquierda ni el borde izquierdo
		if (fila != 0 && columna != 0) {
			if (comprobarVida (tablero[fila-1][columna-1])) {
				contador ++;
			}
		}
		
		// Si la celda no está en el borde superior
		if (fila != 0) {
			if (comprobarVida (tablero[fila-1][columna])) {
				contador ++;
			}
		}
		
		// Si la celda no está en el borde superior ni la esquina derecha
		if(fila != 0 && columna != tablero[fila].length-1) {
			if (comprobarVida (tablero[fila-1][columna+1])) {
				contador++;
			}
		}
		
		// Si la celda no está en el borde derecho
		if (columna != tablero[fila].length -1) {
			if (comprobarVida(tablero[fila][columna+1])) {
				contador++;
			}
		}
		
		// Si la celda no está en el borde inferior ni el borde derecho
		if( fila != tablero.length-1 && columna != tablero[fila].length-1) {
			if (comprobarVida(tablero[fila+1][columna+1])) {
				contador++;
			}
		}
		
		// Si la celda no está en el borde inferior
		if (fila != tablero.length -1) {
			if (comprobarVida (tablero[fila+1][columna])) {
				contador++;
			}
		}
		
		// Si la celda no está en el borde inferior ni la esquina izquierda
		if (fila != tablero.length-1 && columna != 0) {
			if (comprobarVida (tablero[fila+1][columna-1])) {
				contador++;
			}
		}
		
		// Si la celda no está en el borde izquierdo
		if (columna != 0) {
			if (comprobarVida (tablero[fila][columna-1])) {
				contador++;
			}
		}
		return contador;
	}
	
	
	/** 
	 * Pre:---
	 * Post: Este método comprueba si en una celda del tablero hay vida ("*")
	 * o no (" ") y lo devuelve en una ariable boolean.
	 */
	public static boolean comprobarVida (String celda) {
		boolean vida = false;
		if (celda.equals("*")) {
			vida = true;
		}else if (celda.equals(" ")) {
			vida = false;
		}
		return vida;
	}
	

}
