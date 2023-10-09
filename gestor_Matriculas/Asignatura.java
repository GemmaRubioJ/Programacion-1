package practica4;
/*
 * Esta clase crcea objetos de tipo Asignatura que tienen como atributos
 * codigo (INT) y nombre (String), e implementa la interfaz Comparable
 *  sobreescribiendo el método compareTo().
 */

public class Asignatura implements Comparable<Asignatura>{
	
	int codigo;
	String nombreA;
	
	public Asignatura (int codigo, String nombreA) {
		this.codigo = codigo;
		this.nombreA = nombreA;
	}
	
	public Asignatura () {
		this.codigo = 0;
		this.nombreA = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombreA;
	}

	public void setNombre(String nombreA) {
		this.nombreA = nombreA;
	}
	
	@Override
	public String toString() {
		return codigo + " " + nombreA;
	}
	
	public int compareTo (Asignatura i) {
		if (this.nombreA.compareTo(i.getNombre()) > 0) {
			return 1;
		}else if (this.nombreA.compareTo(i.getNombre()) < 0) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
	
}
