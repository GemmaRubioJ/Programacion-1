package practica1;

import java.util.Scanner;

/**
 * 
 * @author Gemi
 * 
 */

public class Main {
	/**
	 * Pre: --- 
	 * Post: Este metodo main ejecuta un programa que genera una liga de
	 * futbol con sus correspodientes datos de equipos y jugadores para despues
	 * poder obtener ciertas estadísticas a traves de la seleccion de diferentes
	 * opciones en un menu.
	 */
	public static void main (String[] args) {
		Liga liga = new Liga();
		System.out.println("¡Bienvenido al Club de Socios de la Liga Femenina Iberdrola!");;
		while (true) {
			menu();
			try {
				Scanner entrada = new Scanner(System.in);
				int menu = entrada.nextInt();
				if( menu == 1) {
					liga.showClasificacion();
				} else if ( menu == 2) {
					liga.showGoleadores();
				} else if (menu == 3) {
					liga.showExpulsados();
				} else if ( menu == 4) {
					liga.showEquiposGoleadores();
				} else if (menu == 5) {
					System.out.println("Saliendo... !Gracias por usar el Programa de Socios!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Introduce un dato valido, por favor.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo muestra por pantalla el menu.
	 */
	
	public static void menu () {
		System.out.println("-------------------------------------------" + "\n" +
				"¿Qué acción desea realizar?" + "\n" +
				"1 - Ver la clasificación ordenada por puntos ( pulse 1)" + "\n" + 
				"2 - Ver las 5 máximas goleadoras ( pulse 2)" + "\n" + 
				"3 - Ver las 5 jugadores con más expulsiones ( pulse 3)" + "\n" +
				"4 - ver los 3 equipos más goleadores ( pulse 4)" + "\n" +
				"5- Salir del Sistema ( pulse 5)" + "\n" + 
				"----------------------------------------------");
		
		
	}
}
