public class Character {
	private int idCharacter;
	private String nombre;
	private Avatar avatar;
	private Arma arma;
	private Poder poder;
	
	// Metodo constructor sin identificador
	public Character (String nombre, Avatar avatar, Arma arma, Poder poder) {
		this.nombre = nombre;
		this.avatar = avatar;
		this.arma = arma;
		this.poder = poder;
	}
	
	// Metodo constructor para lectura de BD y obtener el id
	public Character (int idCharacter, String nombre, Avatar avatar, Arma arma, Poder poder) {
		this.idCharacter = idCharacter;
		this.nombre = nombre;
		this.avatar = avatar;
		this.arma = arma;
		this.poder = poder;
	}
	
	// Metodos getter y setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Poder getPoder() {
		return poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}
	
	public int getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}
	
	// método toString que muestra el todos los datos del character y del poder del character
	//según sea danyo o defensa.
	@Override 
	public String toString() {
		String explicacion1 = "";
		String explicacion2 = "";
		System.out.println("Tu Character se llama " + nombre + "\nCon tu Avatar " + avatar.getNombre()+"\ntienes " + avatar.getVida() + " puntos de vida, ");
		System.out.println("El arma es " + arma.getNombre() + "\nSumas " + arma.getDanyo() + " al danyo que te hagan");
		if(poder.getdanyoDef() > 0) {
			explicacion2 =""; 
			System.out.println("posees " + poder.getNombre() + " que te da " + poder.getdanyoDef() + " de vida ");
		} else {
			explicacion2 ="";
			System.out.println("posees " + poder.getNombre() + " que te quita " + poder.getdanyoDef() + " del daño que te hagan.");
		}
		
		return explicacion1 + explicacion2;
	}
	
}