package practica1;

/**
 * 
 * Esta clase declara objetos de tipo equipo
 * @author Gemi
 */

public class Equipo {
	private String nombre;
	private String estadio;
	private int fundacion;
	private Jugador[] jugadores = new Jugador[11];
	private int puntos;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	
	/**
	 * Pre: ---
	 * Post: Este metodo constructor recibe como parametro el nombre y
	 *  el estadio. El resto de datos se generan aleatoriamente con
	 * otros metodos de la clase Equipo. 
	 * @param nombre del equipo
	 * @param estadio donde juega el equipo
	 */
	
	public Equipo (String nombre, String estadio) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.generarFundacion();
		this.generarJugadores();
		this.generarPuntos(partidosGanados, partidosEmpatados);
		this.generarGanados();
		this.generarPerdidos();
		this.generarEmpatados();
	}
	
	/** metodo get del atributo nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/** metodo set del atributo nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** metodo get del atributo estadio
	 * 
	 * @return estadio
	 */
	public String getEstadio() {
		return estadio;
	}

	/** metodo set del atributo estadio
	 * 
	 * @param estadio
	 */
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	/** metodo get del atributo fundacion
	 * 
	 * @return fundacion
	 */
	public int getFundacion() {
		return fundacion;
	}

	/** metodo set del atributo fundacion
	 * 
	 * @param fundacion
	 */
	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}
	
	/** metodo get del atributo jugadores
	 * 
	 * @return jugadores
	 */
	public Jugador[] getJugadores() {
		return jugadores;
	}

	/**
	 *  metodo set del atributo jugadores
	 * @param jugadores
	 */
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	/**metodo get del atributo puntos
	 * 
	 * @return puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/** metodo set del atributo puntos
	 * 
	 * @param puntos
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/** metodo get del atributo partidosGanados
	 * 
	 * @return partidosGanados
	 */
	public int getPartidosGanados() {
		return partidosGanados;
	}

	/**
	 *  metodo set del atributo partidosGanados
	 * @param partidosGanados
	 */
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	/**
	 *  metodo get del atributo partidosPerdidos
	 * @return partidosPerdidos
	 */
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	/**
	 *  metodo set del atributo partidosPerdidos
	 * @param partidosPerdidos
	 */
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	/** metodo get del atributo partidosEmpatados
	 * 
	 * @return partidosEmpatados
	 */
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	/** metodo set del atributo partidosEmpatados
	 * 
	 * @param partidosEmpatados
	 */
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	
	
	/**
	 * Pre:---
	 * Post: Este metodo muestra por pantalla los datos de cada uno de los objetos Equipo.
	 */
	
	public void showEquipo() {
		System.out.println("Nombre : " + nombre + " / " + "Estadio : " + estadio + " / " + "Fundacion : " + fundacion + " / " 
				 + " / " + "Puntos : " + puntos + " / " + "Partidos Ganados : " + partidosGanados + 
				" / " + "Partidos Perdidos : " + partidosPerdidos +  " / " + "Partidos Empatados : " + partidosEmpatados);
		System.out.println("Jugadores del " + nombre + " :/n");
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i].showJugador();
		}
		System.out.println();
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera aleatoriamente un año de fundación entre 1950 y el 2000.
	 */
	
	public void generarFundacion() {
		fundacion = (int) (Math.random()*(2000 - 1950) + 1950);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera aleatoriamente un numero de partidos ganados de cero a diez.
	 */
	
	public void generarGanados() {
		partidosGanados = (int) (Math.random()*10);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera aleatoriamente un numero de partidos perdidos de cero a diez.
	 */
	
	public void generarPerdidos() {
		partidosPerdidos = (int) (Math.random()*10);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera aleatoriamente un numero de partidos empatados de cero a diez.
	 */
	
	public void generarEmpatados() {
		partidosEmpatados = (int) (Math.random()*10);
	}
	
	
	/**
	 * Pre:---
	 * Post: Este metodo recibe por parametro el numero de partidos ganados ( que valen 3 puntos) y 
	 * el numero de partidos empatados (que valen 1 punto) y calcula el total de puntos que tiene un equipo. 
	 * @param partidosGanados, el numero de partidos ganados que se ha generado aleatoriamente en otro metodo
	 * de esta clase.
	 * @param partidosEmpatados, el numero de partidos empatados generado
	 * aleatoriamente en otro metodo de esta clase
	 * @return puntos
	 */
	
	public int generarPuntos (int partidosGanados, int partidosEmpatados) {
		puntos = ((partidosGanados*3) + partidosEmpatados); 
		return puntos;
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera 11 jugadores para cada uno de los equipos.
	 */
	
	public void generarJugadores() {
		for (int i = 0; i < 11; i++) {
			jugadores[i] = new Jugador();
		}
	}
	
	
}
