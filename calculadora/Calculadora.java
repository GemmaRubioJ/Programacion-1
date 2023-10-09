package calculadora;

import java.util.Scanner;

/**
 * Implementa un programa Java que te muestre por pantalla el siguiente menú de acciones
 *¡Bienvenidos a mi primera calculadora!
 *1.- Sumar
 *2.- Restar
 *3.- Multiplicar
 *4.- Dividir
 *5.- Salir
 */

public class Calculadora {
	/**
	 * Pre:---
	 * Post: este metodo muestra por pantalla las opciones del menu.
	 */
	public static void menu () {
		System.out.println("¡Bienvenidx a mi caculadora!");
		System.out.println("1.-Sumar");
		System.out.println("2.-Restar");
		System.out.println("3.-Multiplicar");
		System.out.println("4.-Dividir");
		System.out.println("5.-Salir");	
	}
	
	/**
	 * Pre:---
	 * Post: este metodo recibe dos enteros como parametros y muestra la suma por pantalla.
	 */
	public static void sumar() {
		System.out.println("Introduce el primer numero que quieres sumar:");
		Scanner entrada = new Scanner (System.in);
		int x = entrada.nextInt();
		System.out.println("Introduce el segundo numero que quieres sumar:");
		int y = entrada.nextInt();
		System.out.println("La suma de " + x + " y " + y + " es " + (x + y));
	} 
	/**
	 * Pre:---
	 * Post: este metodo recibe dos enteros como parametros y muestra por pantalla su resta.
	 */
	public static void restar() {
		System.out.println("Introduce el primer numero que quieres restar:");
		Scanner entrada = new Scanner (System.in);
		int x = entrada.nextInt();
		System.out.println("Introduce el segundo numero que quieres restar:");
		int y = entrada.nextInt();
		System.out.println("La resta de " + x + " y " + y + " es " + (x - y));
	}
	/**
	 * Pre:---
	 * Post: este metodo recibe dos enteros como parametros y muestra por pantalla su multiplicacion.
	 */
	public static void multiplicar() {
		System.out.println("Introduce el primer numero que quieres multiplicar:");
		Scanner entrada = new Scanner (System.in);
		int x = entrada.nextInt();
		System.out.println("Introduce el segundo numero que quieres multiplicar:");
		int y = entrada.nextInt();
		System.out.println("La multiplicacion de " + x + " y " + y + " es " + (x * y));
	}
	/**
	 * Pre:---
	 * Post: este metodo recibe dos enteros como parametros y muestra su division por pantalla.
	 */
	public static void dividir() {
		System.out.println("Introduce el primer numero que quieres dividir:");
		Scanner entrada = new Scanner (System.in);
		int x = entrada.nextInt();
		System.out.println("Introduce el segundo numero que quieres dividir:");
		int y = entrada.nextInt();
		System.out.println("La division de " + x + " y " + y + " es " + (x / y));
	}
	/**
	 * Pre:---
	 * Post: este metodo pide al usuario la accion que desea realizar y ejecuta el metodo correspondiente a dicha accion
	 */
	public static void main (String[] args) {
		menu(); 
		while (1 == 1 ) {
		System.out.println("¿Que accion deseas realizar?:");
		Scanner entrada = new Scanner (System.in);
		int i = entrada.nextInt();	
			if (i <= 0 || i >5) {
				menu();
			} else if (i == 1) {
				sumar();			
			}else if ( i == 2) {
				restar();
			}else if ( i == 3) {
				multiplicar();
			}else if (i == 4) {
				dividir();
			}else {	
				System.out.println("¡Adios!");
				break;
			} 
		}	
	}
}
