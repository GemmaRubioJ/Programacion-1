package practica1;

/**
 * 
 * Esta clase declara objetos de tipo equipo
 * @author Gemi
 */
public class Jugador {
	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetasRojas;
	private int tarjetasAmarillas;
	
	/**
	 * Pre: --- 
	 * Post: metodo constructor de objetos de tipo Jugador que
	 * no recibe nigun parametro porque contruye todos sus 
	 * atributos con metodos propios de la clase.
	 */
	
	public Jugador () {
		this.generarNombre();
		this.generarDorsal();
		this.generarGoles();
		this.generarTarjetasRojas();
		this.generarTarjetasAmarillas();
	}
	
	/**
	 *  metodo get del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *  metodo set del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *  metodo get del atributo dorsal
	 * @return dorsal
	 */
	public int getDorsal() {
		return dorsal;
	}
	
	/** 
	 * metodo set del atributo dorsal
	 * @param dorsal
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	/**
	 *  metodo get del atributo goles
	 * @return dorsal
	 */
	public int getGoles() {
		return goles;
	}

	/**
	 * metodo set del atributo goles
	 * @param goles
	 */
	public void setGoles(int goles) {
		this.goles = goles;
	}

	/**
	 *  metodo get del atributo tarjetasRojas
	 * @return tarjetasRojas
	 */
	public int getTarjetasRojas() {
		return tarjetasRojas;
	}

	/**
	 *  metodo set del atributo tarjetasRojas
	 * @param tarjetasRojas
	 */
	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	/** metodo get del atributo tarjetasAmarillas
	 * 
	 * @return tarjetasAmarillas
	 */
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	/**metodo set del atributo tarjetasAmarillas
	 * 
	 * @param tarjetasAmarillas
	 */
	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo muestra por pantalla todos los atributos de un objeto de clase Jugador.
	 */
	
	public void showJugador() {
		System.out.println("Nombre : " + nombre + " / " + "Dorsal : " + dorsal + " / " + "Goles : " + goles + " / " +
				"Tarjetas Rojas : " + tarjetasRojas + " / " + "Tarjetas Amarillas : " + tarjetasAmarillas);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo asigna un nombre aleatorio a cada uno de los objetos de tipo Jugador.
	 * Para ello selecciona aleatoriamente un nombre y un apellido de cada una de las dos tablas.
	 */
	
	public void generarNombre() {
		String[] nom = {"Ana", "Maria", "Julia", "Lola", "Andrea", "Ainhoa", "Laura", "Yolanda", "Sonia", "Marta"};
		String[] apellido = {"Perez", "Jimenez", "Castro", "Hernandez", "Lopez", "Rubio", "Preciado", "Moreno", "Fernandez", "Valero"};
		int indice = (int) (Math.random()*(9 - 0 +1) + 0);
		int in = (int) (Math.random()*(9 - 0 +1) + 0);
			nombre = nom[indice] + " " + apellido[in];
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera de forma aleatoria un dorsal para el objeto Jugador del 0 al 30. 
	 */
	
	public void generarDorsal () {
		dorsal = (int) (Math.random()*30);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo genera de forma aleatoria la cantidad de goles de un Jugador, pudiendo llegar
	 * hasta 120.
	 */
	
	public void generarGoles () {
		goles = (int) (Math.random()*120);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo asigna un numero aleatorio de tarjetas rojas a un Jugador (maximo 10).
	 */
	
	public void generarTarjetasRojas() {
		tarjetasRojas = (int) (Math.random()*10);
	}
	
	/**
	 * Pre:---
	 * Post: Este metodo asigna un numero aleatorio de tarjetas amarillas a un Jugador (maximo 10).
	 */
	
	public void generarTarjetasAmarillas() {
		tarjetasAmarillas = (int) (Math.random()*15);
	}
	

}
