
public class Pregunta {
	private int idPregunta;
	private String texto;
	private String textoOpcion1;
	private String textoOpcion2;
	private int valorOpcion1;
	private int valorOpcion2;
	
	// Constructor con identificador para leer de la BD
	public Pregunta (int idPregunta, String texto, String textoOpcion1, String textoOpcion2,
			int valorOpcion1, int valorOpcion2) {
		this.idPregunta = idPregunta;
		this.texto = texto;
		this.textoOpcion1 = textoOpcion1;
		this.textoOpcion2 = textoOpcion2;
		this.valorOpcion1 = valorOpcion1;
		this.valorOpcion2 = valorOpcion2;
	}
	
	// Constructor sin identificador para insertar Preguntas
	public Pregunta (String texto, String textoOpcion1, String textoOpcion2,
			int valorOpcion1, int valorOpcion2) {
		this.texto = texto;
		this.textoOpcion1 = textoOpcion1;
		this.textoOpcion2 = textoOpcion2;
		this.valorOpcion1 = valorOpcion1;
		this.valorOpcion2 = valorOpcion2;
	}
	
	// métodos getter y setter
	public int getIdPregunta() {
		return idPregunta;
	}
	
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTextoOpcion1() {
		return textoOpcion1;
	}
	
	public void setTextoConsecencia1(String textoOpcion1) {
		this.textoOpcion1 = textoOpcion1;
	}
	
	public String getTextoOpcion2() {
		return textoOpcion2;
	}
	
	public void setTextoOpcion2(String textoOpcion2) {
		this.textoOpcion2 = textoOpcion2;
	}
	
	public int getValorOpcion1() {
		return valorOpcion1;
	}
	
	public void setValorOpcion1(int valorOpcion1) {
		this.valorOpcion1 = valorOpcion1;
	}
	
	public int getValorOpcion2() {
		return valorOpcion2;
	}
	
	public void setValorOpcion2(int valorOpcion2) {
		this.valorOpcion2 = valorOpcion2;
	}

	public String gettextoOpcion1() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
