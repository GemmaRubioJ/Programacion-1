
public class Poder {
	private int idPoder;
	private String nombre;
	private int danyoDef;
	
	public Poder (int idPoder, String nombre, int danyoDef) {
		this.idPoder = idPoder;
		this.nombre = nombre;
		this.danyoDef = danyoDef;
	}
	
	public Poder (String nombre, int danyoDef) {
		this.nombre = nombre;
		this.danyoDef = danyoDef;
	}
	
	public int getIdPoder() {
		return idPoder;
	}
	
	public void setIdPoder(int idPoder) {
		this.idPoder = idPoder;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getdanyoDef() {
		return danyoDef;
	}
	
	public void setdanyoDef(int danyoDef) {
		this.danyoDef = danyoDef;
	}
	
	public String toString() {
		return "Nombre: " + nombre + " Daño Defensa: " + danyoDef;
	}
}