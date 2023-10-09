package practica1;

/**
 * 
 * Esta clase declara objetos de tipo Liga
 * @author Gemi
 */
public class Liga {
	private String nombre;
	private Equipo[] clasificacion = new Equipo[15];
	
	
	/**
	 * Pre: ---
	 * Post: Este metodo construye un objeto de tipo Liga sin necesidad de recibir nada por 
	 * parámetro. El nombre se da por defecto y los equipos y jugadores que la conforman 
	 * se generan de manera aleatoria.
	 */
	public Liga () {
		this.nombre = "Liga Femenina Iberdrola";
		generarClasificacion();
	}
	
	/**
	 * metodo get del atributo nombre
	 * @return clasificaion
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo get del atributo clasificacion
	 * @return clasificacion
	 */
	public Equipo[] getClasificacion() {
		return clasificacion;
	}

	/**
	 * metodo set del atributo clasificacion 
	 * @param clasificacion
	 */
	public void setClasificacion(Equipo[] clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	/**
	 * Pre:---
	 * Post: Este método genera la clasificacion de equipos. Genera una tabla de quince objetos
	 * de tipo Equipo utilizando los nombres de equipo y de estadio que se
	 * guardan en estas tablas. El resto de atributos se generan
	 * aleatoriamente dentro de la clase Equipo.
	 */
	
	public void generarClasificacion() {
		String nombre[] = {"Deportivo Alaves", "Alhama Femenino", "Athletic Club", "Atletico de Madrid", "FC Barcelona", 
				"UDG Tenerife", "Levante UD", "Madrid CFF", "Real Betis Feminas", "Real Madrid", "Real Sociedad", 
				"Sevilla Futbol Club", "Sporting de Huelva", "Valencia Feminas CF", "Villarreal CF"};
		String estadio[] = {"Mendizorra", "Complejo Deportivo del Gadalentín", "San Mamés", " Civitas Metropolitano", "Camp Nou", 
				"La Palmera", "Ciudad de Valencia", "Estadio Fernando Torres", "Benito Villamarín", "Santiago Bernabeu", "Reale Arena", 
				"Ramon Sanchez Pizjuan", "Estadio el Molinon", "Mestalla", "Estadio de la Ceramica"};
		for (int i = 0; i < 15; i++) {
			clasificacion[i]= new Equipo (nombre[i], estadio[i]);
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método muestra por pantalla los datos de un objeto de tipo Liga.
	 */
	
	public void showLiga() {
		System.out.println("Nombre de la Liga : " + nombre + " /n ");
		for(int i = 0; i < clasificacion.length; i++) {
			clasificacion[i].showEquipo();
		}
		System.out.println();
	}
	
	/**
	 * Pre:---
	 * Post: Este método muestra los quince equipos ordenados según su puntuación obtenida 
	 * de mayor a menor.
	 */
	
	public void showClasificacion() {
		for (int i = 0; i < clasificacion.length; i++) {
			Equipo aux;
			for ( int j = 0; j < clasificacion.length -1; j++) {
				if ( clasificacion[j].getPuntos() < clasificacion[i].getPuntos()) {
					aux = clasificacion[i];
					clasificacion[i] = clasificacion[j];
					clasificacion[j] = aux;
				}
			}
		}
		// este bucle muestra por pantalla el equipo y sus puntos.
		for (int i = 0; i < clasificacion.length; i++) {
			System.out.println(clasificacion[i].getNombre() + " ha obtenido " + clasificacion[i].getPuntos()
					+ " puntos ");
			System.out.println();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo muestra por pantalla los cinco jugadores con mas goles. 
	 * Creando una tabla de objetos de tipo Jugador, la ordena de mayor a menor
	 * segun el numero de goles y muestra por pantalla los 5 con mayor numero.
	 */
	
	public void showGoleadores() {
		Jugador totalJugadores[] = new Jugador[165];
		int contador = 0;
		for( int i  = 0; i < clasificacion.length; i++) {
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				totalJugadores[contador] = clasificacion[i].getJugadores()[j];
				contador++;
			}
		}
		for( int i = 0; i < totalJugadores.length; i++) {
			Jugador aux;
			for( int j = 0; j < totalJugadores.length -1; j++) {
				if (totalJugadores[j].getGoles() < totalJugadores[i].getGoles()) {
					aux = totalJugadores[i];
					totalJugadores[i] = totalJugadores[j];
					totalJugadores[j]= aux;
				}
			}
		}
		for ( int i = 0; i < 5; i++) {
			System.out.println(totalJugadores[i].getNombre() + " con un total de " + totalJugadores[i].getGoles() + " goles. ");
			System.out.println();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo muestra por pantalla los tres jugadores con mas expulsiones. 
	 * Crea una tabla de objetos de tipo Jugador y los ordena por numero de expulsiones
	 * teniendo en cuenta las tarjetas rojas y amarillas (dos hacen una expulsion).
	 */
	
	public void showExpulsados() {
		Jugador totalJugadores[] = new Jugador[165];
		int contador = 0;
		// Estos bucles rellenan la tabla con los 165 jugadores.
		for( int i  = 0; i < clasificacion.length; i++) {
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				totalJugadores[contador] = clasificacion[i].getJugadores()[j];
				contador++;
			}
		}
		for( int i = 0; i < totalJugadores.length; i++) {
			Jugador aux;
			for( int j = 0; j < totalJugadores.length -1; j++) {
				if ((totalJugadores[j].getTarjetasRojas() + totalJugadores[j].getTarjetasAmarillas()/2) < 
						(totalJugadores[i].getTarjetasRojas() + totalJugadores[i].getTarjetasAmarillas()/2)) {
					aux = totalJugadores[i];
					totalJugadores[i] = totalJugadores[j];
					totalJugadores[j]= aux;
				}
			}
		}
		for ( int i = 0; i < 3; i++) {
			System.out.println(totalJugadores[i].getNombre() + " --- " + totalJugadores[i].getTarjetasRojas() + " tarjetas rojas y " +
					totalJugadores[i].getTarjetasAmarillas() + " tarjetas amarillas " + " ---> " + (totalJugadores[i].getTarjetasRojas() + 
							totalJugadores[i].getTarjetasAmarillas() /2) + " expulsiones");
			System.out.println();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera una tabla con los 15 equipos y los ordena de mayor a menor
	 * por el numero de goles totales que han obtenido.
	 */
	
	public void showEquiposGoleadores() {
		int golesPorEquipo [] = new int[15];
		// Estos bucles rellenan la tabla con el total de goles de cada equipo.
		for( int i  = 0; i < clasificacion.length; i++) {
			int golesTotales = 0;
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				golesTotales += clasificacion[i].getJugadores()[j].getGoles();
			}
			golesPorEquipo[i] = golesTotales;
		}	
		//Estos bucles ordenan de mayor a menor el total de goles de cada equipo.
		for (int i = 0; i < golesPorEquipo.length; i++) {
			int aux = 0;
			Equipo auxiliar;
			for (int j = 0; j < golesPorEquipo.length -1; j++) {
				if (golesPorEquipo[j] < golesPorEquipo[i]) {
					aux = golesPorEquipo[i];
					golesPorEquipo[i] = golesPorEquipo[j];
					golesPorEquipo[j] = aux;
					// Ahora se ordenan los equipos.
					auxiliar = clasificacion[i];
					clasificacion[i] = clasificacion[j];
					clasificacion[j] = auxiliar;
				}
			}
		}
		 //Este bucle muestra por pantalla el nombre de los tres equipos con mas goles con sus goles correspondientes.
		for (int i = 0; i < 3; i++) {
			System.out.println(clasificacion[i].getNombre() + " con un total de " + golesPorEquipo[i] + " goles.");
		}
	}
	
}
