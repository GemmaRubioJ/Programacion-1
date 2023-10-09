package practica4;

import java.util.*;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practica4 {
	/**
	 * Pre:---
	 * Post: Este método lee el archivo asignaturas.txt y guarda en el ArrayList asignaturas,
	 * el cual recibe por parámetro objetos del tipo Asignatura, formados por dos atributos : codigo (int) 
	 * y nombre (String), por eso de todo el contenido del archivo sólo guardamos esos dos atributos.
	 */
	public static ArrayList leerAsignaturas (ArrayList<Asignatura> asignaturas) {
		String ruta = "C:\\Users\\noabl\\eclipse-workspace\\Prog3ev\\src\\practica4\\asignaturas.txt";
		File file = new File (ruta);
		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				String[] asigSeparadas = linea.split(" ");
				//guardamos sólo los datos que vamos a utilizar
				int codigo = Integer.parseInt(asigSeparadas[0]);
				String nombreA = "";
				// este bucle recorre la línea del archivo guardada en asigSeparadas y conforma 
				//el nombre de la asignatura
				for (int i = 4; i < asigSeparadas.length; i++) {
					nombreA = nombreA + asigSeparadas[i] + " ";
				}
				// creamos un nuevo objeto Asignatura con los atributos que hemos sacado del archivo 
				//y lo añadimos al ArrayList asignaturas
				Asignatura asignatura = new Asignatura(codigo, nombreA);
				asignaturas.add(asignatura);
			}
		f.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error al abrir el fichero" );
		}
		return asignaturas;
	}
	
	
	/**
	 * Pre:---
	 * Post: Este método lee el archivo alumnos.csv que contiene la información de cada
	 * alumno (nip, apellidos, nombre), guarda esta información en objetos de tipo Alumno
	 * y devuelve un ArrayList de estos objetos. 
	 */
	public static ArrayList leerAlumnos(ArrayList <Alumno> alumnos) {
		String ruta = "C:\\Users\\noabl\\eclipse-workspace\\Prog3ev\\src\\practica4\\alumnos.csv";
		File file = new File (ruta);
		try {
			Scanner f = new Scanner(file);
			//evitamos la primera linea de cabecera del .csv
			String linea1 = f.nextLine();
			while(f.hasNextLine()) {	
				String linea = f.nextLine();
				String[] alumSeparados = linea.split(";");
				// almacenamos los datos del archivo en objetos del tipo Alumno y los guardamos en su ArrayList
				int nip = Integer.parseInt(alumSeparados[0]);
				String apellidos = alumSeparados[1];
				String nombre = alumSeparados[2];
				Alumno alumno = new Alumno (nip, apellidos, nombre);
				alumnos.add(alumno);
			}  
		f.close();
		}  catch (FileNotFoundException e) {
			System.out.println("El fichero no se ha podido leer correctamente"); 
		}
		return alumnos;
	}
	
	/**
	 * Pre:---
	 * Post: Este método lee el archivo binario matriculas.dat  que guarda información sobre las
	 * matrículas, compuesta por un int nip y un int codigo, referentes al nip del alumno y el código
	 * de la asignatura a la que está matriculado. Devuelve un ArrayList de objetos Matricula que tienen
	 * estos dos atributos (nip, codigo).
	 */
	public static ArrayList leerMatriculas (ArrayList <Matricula> matriculas) {
		String ruta = "C:\\Users\\noabl\\eclipse-workspace\\Prog3ev\\src\\practica4\\matriculas.dat";
		try {
			DataInputStream f = new DataInputStream(new FileInputStream(ruta));
			try {
				while(true) {
					int nip = f.readInt();
					int codigo = f.readInt(); 
					Matricula matricula = new Matricula(nip, codigo);
					matriculas.add(matricula);
				}
				} catch(EOFException e) {}

			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + ruta);
		}
		return matriculas;
	}
	
	/**
	 * Pre:---
	 * Post: Este método muestra por pantalla en número de total de matriculas registradas actualmente 
	 * en el sistema.
	 */
	public static void mostrarMatriculas (ArrayList<Matricula> matriculas) {
		System.out.println("Actualmente hay un total de  : " + matriculas.size() + " matriculas en el sistema.");
	}
		
		
		
	/**
	 * Pre:---
	 * Post: Este método muestra por pantalla el menú de opciones de la aplicación.
	 */
	public static void mostrarMenu() {
		System.out.println("......................................" + "\n" );
		System.out.println("~> Matriculas " + "\n" + 
				"~> Asignatuas {nip} [A / C ]" + "\n" + 
				"~> Alumnos {codigo} [A / N ]" + "\n" + 
				"~> Eliminar {nip} {código}" + "\n" +
				"~> Matricular {nip}  {código}" +  "\n" + 
				"~> Salir" + "\n" + "......................................" + "\n" 
				+ "ORDEN > ");
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro la orden que ha introducido el usuario, y según lo que componga esta orden
	 * realiza una acción u otra. Primero, mira el tamaño de la orden y si es 3, entonces mira si la ultima orden es "C" o "A". 
	 * Si es "C" llama al método ordenarAsignaturas para ordenarlas numéricamente y si es "A", primero comprueba que el nip y el código
	 * introducidos existen en la lista de matriculas y ordena la lista de alumnos alfabéticamente. En caso de que la longitud del comando sea 2,
	 * llama al método ordenarAsignaturas, que devuelve la lista de matriculas ordenadas numéricamente. Por último, una vez ordenada la
	 * lista bien numéricamente, bien alfabéticamente la muestra.
	 */
	public static void opcionesAsignaturas(String[] comandoSep, ArrayList<Matricula> matriculas,
			ArrayList<Asignatura> asignaturas, ArrayList<Alumno> Alumnos) {
		ArrayList <Asignatura> asignaturasOrdenadas = new ArrayList<Asignatura>();
		int nip = Integer.parseInt(comandoSep[1]); 
		if(comandoSep.length == 1) {
			System.out.println("Introduce el NIP del alumno");
		} else if (comandoSep.length == 3) {
			if (comandoSep[2].equalsIgnoreCase("C")) {
				asignaturasOrdenadas = ordenarAsignaturas(asignaturas, matriculas, nip, asignaturasOrdenadas);
			} else if(comandoSep[2].equalsIgnoreCase("A")) {
				/*
				 * Si el usuario introduce la opcion "A", estos bucles recorren la lista de matriculas
				 * buscando que el nip y el código se encuentren en la lista. Después se ordena alfabéticamente.
				 */
				for (int i = 0; i < matriculas.size(); i++) {
					if(matriculas.get(i).getNip() == nip) {
						for( int j= 0; j < asignaturas.size(); j++) {
							if (asignaturas.get(j).getCodigo() == matriculas.get(i).getCodigo()) {
								asignaturasOrdenadas.add(asignaturas.get(j));
							}
						}
					}
				}
				Collections.sort(asignaturasOrdenadas);
			} 
		} else if (comandoSep.length == 2) {
			asignaturasOrdenadas = ordenarAsignaturas(asignaturas, matriculas, nip, asignaturasOrdenadas);
		}
		for (int i = 0; i<asignaturasOrdenadas.size(); i++) {
			System.out.println(asignaturasOrdenadas.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro las listas de asignaturas, de matriculas y de asignaturasOrdenadas y 
	 * comprueba que el nip que ha introducido el usuario se encuentra en la lista de matrículas y luego encuentra
	 * las asignaturas a las que está matriculado y las guarda en `asignaturasOrdenadas`. Después ordena 
	 * numéricamente la lista por su Código y la devuelve.
	 */
	public static ArrayList<Asignatura> ordenarAsignaturas (ArrayList<Asignatura> asignaturas, ArrayList<Matricula> matriculas, 
			int nip, ArrayList<Asignatura> asignaturasOrdenadas) {
		for (int i = 0; i < matriculas.size(); i++) {
			if(matriculas.get(i).getNip() == nip) {
				for( int j= 0; j < asignaturas.size(); j++) {
					if (asignaturas.get(j).getCodigo() == matriculas.get(i).getCodigo()) {
						asignaturasOrdenadas.add(asignaturas.get(j));
					}
				}
			}
		}
		/*
		 * Estos bucles ordenan por el método burbúja la lista de asignaturas.
		 */
		for (int i = 0; i < asignaturasOrdenadas.size(); i++) {      
			Asignatura aux = new Asignatura();
			for (int j =0; j < asignaturasOrdenadas.size(); j++) {
				if (asignaturasOrdenadas.get(i).getCodigo() < asignaturasOrdenadas.get(j).getCodigo()) {
					aux = asignaturasOrdenadas.get(i);
					asignaturasOrdenadas.set(i, asignaturasOrdenadas.get(j));
					asignaturasOrdenadas.set(j, aux);
				}
			}
		}
		return asignaturasOrdenadas;
	}
	
	/**
	 * Pre:---
	 * Post:  Este método recibe por parámetro la orden que ha introducido el usuario, y según lo que componga esta orden
	 * realiza una acción u otra. Primero, mira el tamaño de la orden y si es 3, entonces mira si la ultima orden es "N" o "A". 
	 * Si es "N" llama al método ordenarAlumnos para ordenarlas numéricamente y si es "A", primero comprueba que el nip y el código
	 * introducidos existen en la lista de matriculas y ordena la lista de asignaturas alfabéticamente. En caso de que la longitud 
	 * del comando sea 2, llama al método ordenarAsignaturas, que devuelve la lista de alumnos ordenadas numéricamente. Por último, una vez ordenada 
	 * la lista bien numéricamente, bien alfabéticamente la muestra.
	 */
	public static void opcionesAlumnos(String[] comandoSep, ArrayList<Matricula> matriculas,
			ArrayList<Asignatura> asignaturas, ArrayList<Alumno> alumnos ) {
		ArrayList<Alumno> alumnosOrdenados = new ArrayList<Alumno>();
		int codigo = Integer.parseInt(comandoSep[1]);
		if(comandoSep.length ==1) {
			System.out.println("Introduce un CODIGO de asignatura");
		} else if (comandoSep.length == 3) {
			if (comandoSep[2].equalsIgnoreCase("N")) {
				alumnosOrdenados = ordenarAlumnos(alumnos, matriculas, codigo, alumnosOrdenados);
			} else if (comandoSep[2].equalsIgnoreCase("A")){
				/*
				 * Estos bucles comprueban que el nip y el código de la orden se encuentran en la
				 * lista de matriculas.
				 */
				for (int i = 0; i < matriculas.size(); i++) {
					if(matriculas.get(i).getCodigo() == codigo) {
						for( int j= 0; j < alumnos.size(); j++) {
							if (alumnos.get(j).getNip() == matriculas.get(i).getNip()) {
								alumnosOrdenados.add(alumnos.get(j));
							}
						}
					}
				}
				Collections.sort(alumnosOrdenados);
			}
		}else if (comandoSep.length == 2) {
			alumnosOrdenados = ordenarAlumnos(alumnos, matriculas, codigo, alumnosOrdenados);
		} 
		for (int i = 0; i<alumnosOrdenados.size(); i++) {
			System.out.println(alumnosOrdenados.get(i).toString());
		}

	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro las listas de alumnos, de matriculas y de alumnosOrdenados y 
	 * comprueba que el codigo que ha introducido el usuario se encuentra en la lista de matrículas y luego encuentra
	 * los alumnos que están matriculados en ella y las guarda en `alumnosOrdenados`. Después odena alumnosOrdenados
	 * numéricamente por su Nip y devuelve la lista ordenada. 
	 */
	public static ArrayList<Alumno> ordenarAlumnos (ArrayList<Alumno> alumnos, ArrayList<Matricula> matriculas, 
			int codigo, ArrayList<Alumno> alumnosOrdenados) {
		for (int i = 0; i < matriculas.size(); i++) {
			if(matriculas.get(i).getCodigo() == codigo) {
				for( int j= 0; j < alumnos.size(); j++) {
					if (alumnos.get(j).getNip() == matriculas.get(i).getNip()) {
						alumnosOrdenados.add(alumnos.get(j));
					}
				}
			}
		}
		for (int i = 0; i < alumnosOrdenados.size(); i++) {      
			Alumno aux = new Alumno();
			for (int j =0; j < alumnosOrdenados.size(); j++) {
				if (alumnosOrdenados.get(i).getNip() < alumnosOrdenados.get(j).getNip()) {
					aux = alumnosOrdenados.get(i);
					alumnosOrdenados.set(i, alumnosOrdenados.get(j));
					alumnosOrdenados.set(j, aux);
				}
			}
		}
		return alumnosOrdenados;
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro la lista de mátriculas y la orden que introduce el usuario. 
	 * Si el usuario no introduce el código, elimina de la lista de matriculas todas aquellas en las que
	 * aparezca el nip del usuario. En caso de que introduzca el código de la asignatura, comprueba el
	 * nip y el código y los elimina.
	 */
	public static void eliminarMatriculas(String[] comandoSep, ArrayList<Matricula> matriculas ) {
		int nip = Integer.parseInt(comandoSep[1]); 
		int codigo = 0;
		if (comandoSep.length == 3) {
			codigo = Integer.parseInt(comandoSep[2]);
		}
		if (codigo == 0) {
			for (int i = 0; i < matriculas.size(); i++) {
				if(matriculas.get(i).getNip() == nip) {
					matriculas.remove(i);
					i--;
				}
			}
			System.out.println("-- El alumno ha sido desmatriculado de todas sus asignaturas --");
		} else {
			for (int i = 0; i < matriculas.size(); i++) {
				if(matriculas.get(i).getNip() == nip && matriculas.get(i).getCodigo() == codigo) {
					matriculas.remove(i);
					i--;
				}
			}
			System.out.println("-- El alumno ha sido desmatriculado de la asignatura : " + codigo + " --");
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método sobreescribe el archivo de matriculas.dat según los datos que se hayan modificado en el 
	 * ArrayList de matriculas en los métodos `matricularAlumno` o `eliminarMatricula`. Se le llama directamente
	 * después de estos métodos en el main para que sobreescriba los cambios.
	 */
	public static void escribirArchivo(ArrayList<Matricula> matriculas) {
		try {
			DataOutputStream f = new DataOutputStream(new FileOutputStream("C:\\Users\\noabl\\eclipse-workspace\\Prog3ev\\src\\practica4\\matriculas.dat"));
			for(int i = 0; i < matriculas.size(); i++) {
				f.writeInt(matriculas.get(i).getNip());
				f.writeInt(matriculas.get(i).getCodigo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro todas las listas de alumnos y la orden que ha introducido el usuario.
	 * Comprueba que el alumno existe en la lista de alumnos y que el código de asignatura también existe. Si es así, indica 
	 * que la matricula ya existe, y si no es así, añade el nip y el código a la lista de matriculas. 
	 */
	public static void matricularAlumno(String[] comandoSep, ArrayList<Matricula> matriculas, ArrayList<Alumno> alumnos, ArrayList<Asignatura> asignaturas) {
		int nip = Integer.parseInt(comandoSep[1]); 
		int codigo = Integer.parseInt(comandoSep[2]);;
		boolean existeAlumno = false;
		boolean existeAsignatura = false;
		boolean existeMatricula = false;
		for( int i =0; i<alumnos.size(); i++) {
			if(alumnos.get(i).getNip() == nip) {
				existeAlumno = true;
				System.out.println(" -- El nip del alumno existe -- ");
				break;
			} 
		}
		for( int i =0; i<asignaturas.size(); i++) {
			if(asignaturas.get(i).getCodigo() == codigo) {
				existeAsignatura = true;
				System.out.println(" -- La asignatura existe -- ");
				break;
			} 
		}
		if (existeAlumno && existeAsignatura){
			for(int i =0; i<matriculas.size(); i++) {
				if(matriculas.get(i).getNip() == nip && (matriculas.get(i).getCodigo() == codigo)) {
					existeMatricula = true;
					break;
				}
			}
			if (!existeMatricula) {
				Matricula nuevaMatricula = new Matricula (nip, codigo);
				matriculas.add(nuevaMatricula);
				System.out.println("-- El alumno" + nip + " ha sido matriculado en la asignatura : " + codigo + " --");
			}else {
				System.out.println("La matricula ya existe");
			}
		} else {
			System.out.println("No es posible matricular al alumno");
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método llama a los métodos que leen 3 archivos y guardan la información 
	 * en en los tres ArrayList de las clases de objetos correspondientes (asignaturas, alumnos y
	 * matrículas). Muestra el menú de opciones y recoge la orden de la usuario; según la primera
	 * palabra de esta orden llama al método correspondiente a esa acción; en el caso de los métodos
	 * de matricular o eliminar matrícula, llama seguidamente al método que sobreescribe el archivo 
	 * de matrículas con la nueva información generada.
	 */
	public static void main (String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		System.out.println("Bienvenido al Sistema de Gestión de Matrículas" + "\n" +  "**********************************************");
		Scanner entrada = new Scanner(System.in);
		leerAlumnos(alumnos);
		leerMatriculas (matriculas);
		leerAsignaturas (asignaturas);
		while(true) {
			mostrarMenu();
			String comando = entrada.nextLine();
			String[] comandoSep = comando.split(" ");
			if (comandoSep[0].equals("salir")){
				System.out.println("¡BYE!");
				break;
			} else if (comandoSep[0].equalsIgnoreCase("matriculas")) {
				mostrarMatriculas(matriculas);
			} else if (comandoSep[0].equalsIgnoreCase("asignaturas")) {
				opcionesAsignaturas(comandoSep, matriculas, asignaturas, alumnos);
			} else if (comandoSep[0].equalsIgnoreCase("alumnos")) {
				opcionesAlumnos(comandoSep, matriculas, asignaturas, alumnos);
			} else if(comandoSep[0].equalsIgnoreCase("eliminar")) {
				eliminarMatriculas(comandoSep, matriculas);
				escribirArchivo( matriculas);
			} else if (comandoSep[0].equalsIgnoreCase("matricular")) {
				matricularAlumno(comandoSep, matriculas, alumnos, asignaturas);
				escribirArchivo( matriculas);
			} else {
				System.out.println("Introduce una opción válida");
			}
		}
	}
}
