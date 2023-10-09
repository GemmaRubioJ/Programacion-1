package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Tarea2 {
	/**
	 * Pre:---
	 * Post:Este método recibe por parámetro la dirección del archivo que debe leer
	 * y realiza unos sumatorios de traslados, de usos circulares (si la estación de origen y la de destino
	 * son idénticas), y de usos totales y los muestra por pantalla.
	 */
	private static void usos(String fichero) {
		File file = new File(fichero);
	
		int totaltraslados=0;
		int totalcirculares = 0;
		int totalusos = 0;
	
		try {
			Scanner f = new Scanner(file);
			boolean primero = true;
			while(f.hasNextLine()) { 
				String linea = f.nextLine();
				if(!primero) { 
					String[] lSep = linea.split(";");
					int traslados  = Integer.parseInt(lSep[2]);
					int circulares = Integer.parseInt(lSep[4]);
					
					if(circulares == traslados) {// compara si son iguales
						totalcirculares++;
				
					} else 
						totaltraslados++;
						
						
					}else primero = false;
			
				}totalusos=totalcirculares+totaltraslados;
		
			System.out.println("Número de usos como traslado: " + (totaltraslados));
			System.out.println("Número de usos cirulares: " + (totalcirculares));
			System.out.println("Número total de usos: " + totalusos);
			
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre:---
	 * Post:Este método pide al usuario que introduce el nombre del archivo de pruebas sobre el que 
	 * desea realizar realizar el resumen de usos y llama al método "usos()" para que lo realice.
	 */
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba el nombre de un fichero de usos del sistema Bizzi \n"); 
		String nomfich= teclado.nextLine();
		
		String fichero = "C:\\Users\\noabl\\eclipse-workspace\\Prog2ev\\src\\practica3\\"+nomfich;
		System.out.println("nombre del fichero " + (fichero));
		
		usos(fichero);
	}
}




