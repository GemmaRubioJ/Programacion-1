package juegoDeLaVida;

public class Tripleta {
	private int numGeneraciones;
	private int numVivas;
	private int numNuevas;
	
	public Tripleta (int numGeneraciones, int numVivas, int numNuevas) {
		this.numGeneraciones = numGeneraciones;
		this.numVivas= numVivas;
		this.numNuevas = numNuevas;
	}

	public int getNumGeneraciones() {
		return numGeneraciones;
	}

	public void setNumGeneraciones(int numGeneraciones) {
		this.numGeneraciones = numGeneraciones;
	}

	public int getNumVivas() {
		return numVivas;
	}

	public void setNumVivas(int numVivas) {
		this.numVivas = numVivas;
	}

	public int getNumNuevas() {
		return numNuevas;
	}

	public void setNumNuevas(int numNuevas) {
		this.numNuevas = numNuevas;
	}
	
	@Override
	public String toString() {
		return "    " + numGeneraciones + "            " +  numVivas 
				+ "             " + numNuevas;
	}
	
}


