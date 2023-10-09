package practica4;

/*
 * Esta clase crea objetos de tipo Matricula que tienen como atributo
 * nip (INT) y codigo (INT).
 */

public class Matricula {
	
	int nip;
	int codigo;
	
	public Matricula (int nip, int codigo) {
		this.nip = nip;
		this.codigo = codigo;
	}
	
	public Matricula () {
		this.nip = nip;
		this.codigo = codigo;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return nip + " " + codigo;
	}
}
