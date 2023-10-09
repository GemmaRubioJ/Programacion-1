package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;


public class Leer10lineas {
	/**
	 * Pre:---
	 * Post:Este método recibe por parámetro la dirección del archivo origen que debe leer y la dirección donde
	 * debe escribir un nuevo archivo con las 10 primeras líneas del de origen.
	 */

	private static void leerescribir10(String inputFilePath, String outputFilePath) throws IOException {
		
	    int numLineas = 10;
	    File filein = new File(inputFilePath);
	    File fileout = new File(outputFilePath);
	    
		try {
			Scanner f = new Scanner(filein); //archivo origen
				
			FileWriter fw = new FileWriter(fileout);
	        PrintWriter pw = new PrintWriter(fw); //escribe archivo destino
	        
	        
			for ( int i=1; i <= numLineas; i++) { //lee las 10 lineas
				String linea = f.nextLine();
				pw.println(linea);
			}
					
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
			fw.close();
			pw.close();
				
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + filein + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre:---
	 * Post:Este método guarda las variables donde se alojan las direcciones del archivo de origen
	 * y del nuevo archivo a escribir, y llama al método leerescribir10() para que se ejecute.
	 */
	
	
	public static void main(String[] args) throws IOException {
		
		String inputFilePath = "C:\\Users\\noabl\\eclipse-workspace\\Prog2ev\\src\\practica3\\usos-16.csv";
	    String outputFilePath = "C:\\Users\\noabl\\eclipse-workspace\\Prog2ev\\src\\practica3\\pruebas-10.csv";
		
	    leerescribir10( inputFilePath, outputFilePath);
	    
	}
}


