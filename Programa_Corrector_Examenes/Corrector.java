package correctorExamenes;

/** Este programa Java es un corrector de examenes. Permite al profesor
 * introducir en él el número de preguntas de su examen, con las respuestas
 * correctas y las respuestas que ha dado cada alumno. Las compara y le indica
 * al profesor el numero de respuestas correctas del alumno. Puede hacer esto 
 * cuantas veces quiera, y cuando tenga todos los examenes corregidos el
 * programa le indicará el numero total de respuestas correctas de todos los 
 * alumnos y el porcentaje de aciertos de estos.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Corrector2 {
	/**
	 * Pre:---
	 * Post: Pide al usuario el numero de preguntas del test
	 * que serán el indice de la tabla se guardarán las respuestas,
	 * y en caso de excepción devuelve -1 para que el metodo se
	 * vuelva a iniciar.
	 */
	
	public static int cogerNumero (Scanner entrada) {
		try {	
			int preguntas = entrada.nextInt();
			return preguntas;
		}catch(InputMismatchException e) {
				System.out.println("Has introducido un valor no válido. Vuelve a introducir el numero de preguntas : ");
				entrada.nextLine();
		}return -1;
	}	
	
	/**
	 * Pre:---
	 * Post: Pide al usuario las respuestas correctas y las devuelve en
	 * una tabla con el indice indicado en el método anterior. En caso
	 * de excepción devuelve -1 en el último indice de la tabla que 
	 * dejamos vacío para este proposito y así indicar que vuelva a 
	 * iniciarse el método.
	 */
	
	public static int[] cogerRespuestas(Scanner entrada, int preguntas) {
		System.out.println("Introduce las respuestas correctas : ");
		int [] respuestas = new int[preguntas+1]; // en preguntas +1 guardamos el return -1 de los metodos que den una excepcion.
		respuestas[preguntas]=0;
		try {
			for (int i = 0; i < respuestas.length -1; i++) {
				respuestas[i]= entrada.nextInt();
			} return respuestas;
		} catch(InputMismatchException e) {
			respuestas[preguntas]=-1;
			System.out.println("Has introducido un valor no válido.");
			entrada.nextLine();
		} return respuestas;
	}
	
	/**
	 * Pre:---
	 * Post:Pide al usuario las respuestas que ha dado el alumno y 
	 * las devuelve en una tabla con el indice indicado en el primer 
	 * metodo. En caso de excepción devuelve -1 en el últio índice
	 * de la tabla, que dejamos vacío para este propósito y así
	 * indicar que vuelva a iniciarse el método.
	 */
	
	public static int[] cogerAlumno (int preguntas, Scanner entrada) {
		System.out.println("Introduce las respuestas del alumno : ");
		int [] alumno = new int[preguntas+1];
		//alumno[preguntas]= 0;
		try {
			for (int i = 0; i < alumno.length -1; i++) {
				alumno [i] = entrada.nextInt();
			} 
						
			return alumno;
		} catch(InputMismatchException e) {
			alumno[preguntas]=-1;
			System.out.println("Has introducido un valor no válido.");
			entrada.nextLine();
		} return alumno;
	}
	
	/**
	 * Pre:---
	 * Post:Compara las respuestas del alumno con las respuestas correctas y muestra por
	 *  pantalla el total de respuestas correctas del alumno. Devuelve una tabla en la 
	 *  que guarda en su índice 0 el número total de preguntas y e su índice 1 el 
	 *  número total de respuestas correctas de los alumnos.
	 */
	
	public static int[] corregir (int[] alumno, int[] respuestas, int[]tabla) {
		int correctas = 0;
		for (int j = 0; j < alumno.length -1; j++) {
			tabla[0] +=1; // Total respuestas del test
			if( alumno[j] == respuestas[j]) {
				correctas++; // correctas del alumno
				tabla[1] +=1; // correctas totales de todos los alumnos
			}  
		} 
		System.out.println("El total de respuestas correctas del alumno es : " + correctas);
		return (tabla);	
	}
	
	/**
	 * Pre:---
	 * Post: muestra por pantalla el número total de respuestas correctas de todos los test y 
	 * calcula el porcentaje de aciertos totales mostrándolo por pantalla.
	 */
	
	public static void resultado (int[] tabla) {
		System.out.println("El numero total de respuestas correctas es : " + tabla[1]);
		double total = (tabla[1] * 100) / tabla[0];
		System.out.println("El porcentaje de respuestas correctas es : " + total + "%");
	}

	/**
	 * Pre:---
	 * Post: llama a los metodos anteriores y los vuelve a llamar si en 
	 * alguno de ellos ocurre una excepcion. Por último, pregunta al usuario si 
	 * quiere seguir corrigiendo y si no es así finaliza el programa. 
	 */
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner (System.in);
		System.out.println("¿Bienvenidx al corrector de Examenes."); 
		System.out.println("Introduce el numero de preguntas del test : ");
		int preguntas = cogerNumero(entrada);
		
		while(preguntas == -1) {
			preguntas = cogerNumero(entrada);
		} 
		
		int []respuestas = cogerRespuestas(entrada, preguntas);
		if(respuestas[preguntas] == -1) {
			cogerRespuestas(entrada, preguntas);
		}
		int [] alumno = new int[preguntas+1];
		alumno = cogerAlumno(preguntas, entrada);     
		if (alumno[preguntas] == -1) {
			cogerAlumno (preguntas, entrada); 
		}
		int[] tabla = new int[2]; // [0] totalPreguntas ; [1] totalCorrectas;
				corregir(alumno, respuestas, tabla);
		while (true) {
			System.out.println("¿Quieres corregir otro examen?" + "\n" +  "Introduce y para seguir" + "\n" + "Introduce n para finalizar.");
			char YN ='n';
			YN = entrada.next().charAt(0);
			entrada.nextLine();
			if (YN == 'y') {
				alumno = cogerAlumno(preguntas, entrada);
				corregir(alumno, respuestas, tabla);
			}else if (YN == 'n') {
				resultado(tabla);
				break;
			}
		} 	
	}
}


