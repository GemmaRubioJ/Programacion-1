package practica4;

/**
 * Esta clase crea objetos de tipo Alumno que tienen como atributos nip(INT),
 *  apellidos (STRING) y nombre (STRING), e implementa la interfaz Comparable
 *  sobreescribiendo el método compareTo().
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

public class Alumno implements Comparable<Alumno>{
	
	int nip;
	String apellidos;
	String nombre;
	
	public Alumno (int nip, String apellidos, String nombre) {
		this.nip = nip;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}
	
	public Alumno () {
		this.nip = 0;
		this.apellidos = "";
		this.nombre = "";
		
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nip + " " + apellidos + " , " + nombre;
	}
	
	public int compareTo (Alumno i) {
		if (this.apellidos.compareTo(i.getApellidos()) > 0) {
			return 1;
		}else if (this.apellidos.compareTo(i.getApellidos()) < 0) {
			return -1;
		}else {
			return 0;
		}
	}
}
