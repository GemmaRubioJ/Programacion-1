import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
	static Scanner entrada = new Scanner(System.in);
	static MySQLAccess conexion = new MySQLAccess();
	static ArrayList<Arma> listArmas = new ArrayList<Arma>();
	static ArrayList<Avatar> listAvatares = new ArrayList<Avatar>();
	static ArrayList<Character> listCharacters = new ArrayList<Character>();
	static ArrayList<Poder> listPoderes = new ArrayList<Poder>();
	static ArrayList<Pregunta> listPreguntas = new ArrayList<Pregunta>();
	static ArrayList<Ranking> ranking = new ArrayList<Ranking>();
	
	/**
	 * Pre:---
	 * Post: Este método muestra el menú de opciones del juego de Rol, llama al método que
	 * lee toda la información de la base de datos con la que se va a ejecutar el juego
	 *  y llama a los métodos correspondientes según las opciones introducidas por el usuario. 
	 */
	public static void main(String[] args) {
		while (true) {
			mostrarMenu();
			leerDatosDB();
			try {
				int respuesta = entrada.nextInt();
				entrada.nextLine();
				if (respuesta == 1) {
					mostrarRanking();
				} else if (respuesta == 2) {
					NuevasIdeas();
				} else if (respuesta == 3) {
					jugar();
				} else if (respuesta == 4) {
					System.out.println("_____________________________________________________");
					System.out.println("|                                                   |");
					System.out.println("|      Te esperamos para otra partida,  BYE....     |");
					System.out.println("|___________________________________________________|");
					break;
				} else {
					System.out.println("Introduce una opcion correcta: ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero: ");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método muestra por pantalla las opciones del menú principal del juego
	 */
	private static void mostrarMenu() {
		System.out.println("<<--  WELCOME TO THE GRAPHIC ADVENTURE  -->>");
		System.out.println("\nElige una de las siguientes opciones:");
		System.out.println("[1] Ver ranking ");
		System.out.println("[2] Nuevas Ideas");
		System.out.println("[3] Jugar ");
		System.out.println("[4] Salir del juego \n");
	}
		
	/**
	 * Pre:---
	 * Post:Este método llama a todos los métodos que obtienen de la base de datos los datos
	 * de cada tabla. Se ejecuta cada vez que se muestra el menú.
	 */
	private static void leerDatosDB() {		
		try {
			leerAvatares();
			leerArmas();
			leerPoderes();
			leerCharacters();
			leerPreguntas();
			leerRanking();
		} catch (Exception e) {}	
	}
	
	/**
	 * Pre:---
	 * Post: Este método conecta con la base de datos y hace un select de la tabla "avatares", crea objetos
	 * de tipo avatar y los guarda en un ArrayList.
	 */
	private static void leerAvatares() throws Exception {
		try {
			// Borramos para que cada vez que se actualice no se dupliquen datos
			listAvatares.clear();
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.avatar");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// Almacenamos cada dato en una variable de su tipo correspondiente
				int idAvatar = rs.getInt(1);
				String nombre = rs.getString(2);
				int vida = rs.getInt(3);
				// Creamos un objeto de tipo Avatar con estos datos y lo añadimos a su lista
				listAvatares.add(new Avatar(idAvatar, nombre, vida));
			} 
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	
	/**
	 * Pre:---
	 * Post:Este método conecta con la base de datos y hace un select de la tabla "armas", crea objetos
	 * de tipo arma y los guarda en un ArrayList.
	 */
	private static void leerArmas() throws Exception {
		try {
			// Borramos para que cada vez que se actualice no se dupliquen datos
			listArmas.clear();
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.arma");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// Almacenamos cada dato en una variable de su tipo correspondiente
				int idArma = rs.getInt(1);
				String nombre = rs.getString(2);
				int danyo = rs.getInt(3);
				// Creamos un objeto de tipo Arma con estos datos y lo añadimos a su lista
				listArmas.add(new Arma(idArma, nombre, danyo));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	
	/**
	 * Pre:---
	 * Post:Este método conecta con la base de datos y hace un select de la tabla "poderes", crea objetos
	 * de tipo poder y los guarda en un ArrayList.
	 */
	private static void leerPoderes() throws Exception {
		try {
			listPoderes.clear();
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.poder");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idPoder = rs.getInt(1);
				String nombre = rs.getString(2);
				int danyoDef = rs.getInt(3);
				listPoderes.add(new Poder(idPoder, nombre, danyoDef));
			}
		}  catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	
	/**
	 * Pre:---
	 * Post:Este método conecta con la base de datos y hace un select de la tabla "characters", crea objetos
	 * de tipo character y los guarda en un ArrayList.
	 */
	private static void leerCharacters() throws Exception {
		try {
			listCharacters.clear();
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.character");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// se almacena cada dato en una variable de su tipo correspondiente
				int idCharacter = rs.getInt(1);
				String nombre = rs.getString(2);
				int idAvatar = rs.getInt(3);
				int idArma = rs.getInt(4);
				int idPoder = rs.getInt(5);
				// se llama a los métodos que encuentran la información del avatar, el arma y el poder por el ID que sacamos del select * de characters
				Avatar avatar = findAvatarById(idAvatar);
				Arma arma = findArmaById(idArma);
				Poder poder = findPoderById(idPoder);
				// se crea un objeto de tipo Character con estos datos y lo añadimos a su lista
				Character character = new Character(idCharacter, nombre, avatar, arma, poder);
				listCharacters.add(character);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:---
	 * Post:Este método conecta con la base de datos y hace un select de la tabla "pregunta", crea objetos
	 * de tipo pregunta y los guarda en un ArrayList.
	 */
	private static void leerPreguntas() throws Exception {
		try {
			listPreguntas.clear();
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.pregunta");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idPregunta = rs.getInt(1);
				String texto = rs.getString(2);
				String textoOpcion1 = rs.getString(3);
				String textoOpcion2 = rs.getString(4);
				int valorOpcion1 = rs.getInt(5);
				int valorOpcion2 = rs.getInt(6);
				listPreguntas.add(new Pregunta(idPregunta, texto, textoOpcion1, textoOpcion2, 
						valorOpcion1, valorOpcion2));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:---
	 * Post:Este método conecta con la base de datos y hace un select de la tabla "ranking", crea objetos
	 * de tipo ranking y los guarda en un ArrayList.
	 */
	private static void leerRanking() throws Exception {
		try {
			ranking.clear();
			conexion.conectarBD();
			// Obtenemos con un select los 5 registros del Ranking con mas rondas
			PreparedStatement preparedStatement = conexion.getConnect().prepareStatement
					("select * from ddbbRol.ranking order by rondas desc limit 5");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idRanking = rs.getInt(1);
				int idCharacter = rs.getInt(2);
				int rondas = rs.getInt(3);
				// en cada objeto tipo Ranking se almacena el objeto tipo Character que se busca por su Id
				Character character = findCharacterById(idCharacter);
				ranking.add(new Ranking(idRanking, character, rondas));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}	
	}
	
	/**
	 * Pre:
	 * Post: Este método busca objetos de tipo `avatar` según su Id
	 */
	private static Avatar findAvatarById(int idAvatar) {		
		for(int i = 0; i < listAvatares.size(); i++) {
			if(listAvatares.get(i).getIdAvatar() == idAvatar) {
				return listAvatares.get(i);
			}
		}
		return null;		
	}
	
	/**
	 * Pre:
	 * Post: Este método busca objetos de tipo `arma` según su Id
	 */
	private static Arma findArmaById(int idArma) {
		for(int i = 0; i < listAvatares.size(); i++) {
			if(listArmas.get(i).getIdArma() == idArma) {
				return listArmas.get(i);
			}
		}	
		return null;
	}
	
	/**
	 * Pre:
	 * Post: Este método busca objetos de tipo `poder` según su Id
	 */
	private static Poder findPoderById(int idPoder) {
		for(int i = 0; i < listPoderes.size(); i++) {
			if(listPoderes.get(i).getIdPoder() == idPoder) {
				return listPoderes.get(i);
			}
		}	
		return null;	
	}
		
	/**
	 * Pre:
	 * Post: Este método busca objetos de tipo `character según su Id
	 */
	private static Character findCharacterById(int idCharacter) {
		for(int i = 0; i<listCharacters.size(); i++) {
			if(listCharacters.get(i).getIdCharacter() == idCharacter) {
				return listCharacters.get(i);
			}
		}	
		return null;
	}
	
	/**
	 * Pre:
	 * Post: Este método recorre el ArrayList `ranking`y lo muestra por pantalla
	 */
	private static void mostrarRanking() {	
		for(int i = 0; i < ranking.size(); i++) {
			System.out.println("Posicion " + (i + 1) + " - " + ranking.get(i).toString());
		} System.out.println();
	}

	/**
	 * Pre:
	 * Post: Este método comprueba que la palabra pasada por parámetro tiene solo números
	 */	
	private static boolean isInteger(String numero){
	    try{
	        Integer.parseInt(numero);
	        return true;
	    } catch(NumberFormatException e){
	        return false;
	    }
	}


	/**
	 * Pre:
	 * Post: Este método inicia la partida cuando el usuario introduce la opción `jugar`. Primero 
	 * comprueba que haya characters en la base de datos y pregunta al usuario 
	 * si quiere jugar con uno de los existentes, en cuyo caso inicia el juego eligiendo character. 
	 * En caso de que el usuario no quiera jugar un character existente, inicia el juego creando uno nuevo.
	 */	 
	private static void jugar(){
		if(!listCharacters.isEmpty()) {
			System.out.println("Quieres utilizar un character existente? si / no");
			while(true) {	
				String respuesta = entrada.nextLine();
				//entrada.nextLine();
				if(respuesta.equalsIgnoreCase("si")) {
					// Si quiere elegir un Character previo
					iniciarjuego(elegirCharacter());
					return;				
				} else if (respuesta.equalsIgnoreCase("no")) {
					break;
				} else {
					System.out.println("Introduce una respuesta correcta");
				}
			}
		}
		// Para crear un Character nuevo
		iniciarjuego(crearCharacter());
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro un objeto de tipo character, proveniente del método `crearCharacter()`
	 * o del método `elegirCharacter` 
	 */
	private static void iniciarjuego(Character character) {
		// aleatoriza las preguntas para cada partida
		Collections.shuffle(listPreguntas);
		// Muestra por pantalla el Character elegido.
		System.out.println(character.toString());
		Arma arma = character.getArma();
		Poder poder = character.getPoder();
		int nPregunta = 0;
		int respuesta = 0;
		while(true) {
			Pregunta pregunta = listPreguntas.get(nPregunta);
			// Si el poder es curativo siempre se utiliza
			// condicional o ternaria que se utiliza para asignar un valor booleano a la variable 
			//"poderCurativo" en función de una condición.
			//
			boolean poderCurativo;
			if (character.getPoder().getdanyoDef() > 0) {
				poderCurativo = true;
			}
			else {
				poderCurativo = false;
			}
			// Si el poder es defensivo solo se utiliza si pierdes vida
			boolean poderDefensivo;
			if (character.getPoder().getdanyoDef() < 0) {
				poderDefensivo = true;
			}
			else {
				poderDefensivo = false;
			}
			// Mostramos el texto de la pregunta
			for(Pregunta pregunta2 : listPreguntas) {
				System.out.println(pregunta2.getTexto());
				String opciones = entrada.nextLine();
				//operacion ternaria si es si respuesta es 1 y en caso contrario es 2
				respuesta = (opciones.equalsIgnoreCase("si"))? 1: 2;
				int valorTotal = 0;
				// Dependiendo de la respuesta mostramos una Opcion u otray calculamos la vida actual
				valorTotal = calcularValorOpcion(respuesta, arma, poder, pregunta, poderDefensivo);
				//al Character se le suma o resta vida
				character.getAvatar().setVida(character.getAvatar().getVida() + valorTotal);
				nPregunta++;
				// Si ademas el poder es curativo añadimos los puntos de vida correspondientes
				if (poderCurativo) {
					character.getAvatar().setVida(character.getAvatar().getVida() 
							+ poder.getdanyoDef());
					System.out.println("Tu poder curativo te restaura " + poder.getdanyoDef() 
						+ " puntos de vida.");
				}			
				System.out.println("Vida actual: " + character.getAvatar().getVida());
				System.out.println("+++++++++++++++++++++++++"); 
			}	
			if(character.getAvatar().getVida() <= 0) {
				System.out.println("_____________________________________________________");
				System.out.println("|                                                   |");
				System.out.println("|           OOOH, HAS PERDIDO, TRY AGAIN !          |");
				System.out.println("|___________________________________________________|");
				gameOver(character, nPregunta);
				break;
			}
			// Si se llega al final de las preguntas el jugador ha ganado
			if(nPregunta == listPreguntas.size()) {
				System.out.println("_____________________________________________________");
				System.out.println("|                                                   |");
				System.out.println("|      BIENNN, HAS GANADO, YOU ARE A WINNER !       |");
				System.out.println("|___________________________________________________|");
				gameOver(character, nPregunta);
				break;
			}
		}	
	}
	
	/**
	 * Pre:---
	 * Post: Este método devuelve un character previamente creado, que elije el usuario.
	 */
	private static Character elegirCharacter() {
		System.out.println("Introduce el numero de Character que vas a utilizar: ");
		for(int i = 0; i < listCharacters.size(); i++) {
			System.out.println("["+ listCharacters.get(i).getIdCharacter() +"] " + listCharacters.get(i).getNombre());
		}
		int respuesta = entrada.nextInt();
		entrada.nextLine();
		return listCharacters.get(respuesta-1);
	}
	
	/**
	 * Pre:---
	 * Post: Este método crea y devuelve un nuevo Character con su avatar, arma y poder correspondiente
	 * elegido por el usuario. Llama al método ´guardarCharacter()`
	 * pera guardarlo en la base de datos.
	 */
	private static Character crearCharacter() {
		System.out.println("Introduce el nombre de tu nuevo Character: ");
		String nombre = entrada.nextLine();
		// elección de Avatar
		System.out.println("    AVATAR ");
		System.out.println("Elige el Avatar para el Personaje: ");
		for(int i = 0; i < listAvatares.size(); i++) {
			System.out.println("["+i+"] " + listAvatares.get(i).toString());
		}
		int respuestaAvatar = entrada.nextInt();
		entrada.nextLine(); 
		Avatar avatar = listAvatares.get(respuestaAvatar);
		// elección de Arma 
		System.out.println("    ARMAS ");
		System.out.println("Elige el Arma de tu nuevo Character: ");
		for(int i = 0; i < listArmas.size(); i++) {
			System.out.println("["+i+"] " + listArmas.get(i).toString());
		}
		int respuestaArma = entrada.nextInt();
		entrada.nextLine(); 
		Arma arma = listArmas.get(respuestaArma);
		// elección de poder
		System.out.println("    PODER ");
		System.out.println("Elige el Poder de tu nuevo Character (numero entero): ");
		for(int i = 0; i < listPoderes.size(); i++) {
			System.out.println("["+i+"] " + listPoderes.get(i).toString());
		}
		int respuestaPoder = entrada.nextInt();
		entrada.nextLine(); 
		Poder poder = listPoderes.get(respuestaPoder);
		Character nuevoCharacter = new Character(nombre, avatar, arma, poder);
		//guardamos el objeto tipo Character con el id que le asigna la BD automaticamente
		try {
			int idBaseDatos = guardarCharacter(nuevoCharacter);
			nuevoCharacter.setIdCharacter(idBaseDatos);
		} catch (Exception e) {}
		return nuevoCharacter;
	}
	
	/**
	 * Pre:---
	 * Post: Este método guarda un objeto de tipo Character en la base de datos y devuelve
	 * un entero que es el ID que la bbdd ha generado automáticamente al insertar
	 * el nuevo objeto.
	 */
	private static int guardarCharacter(Character nuevoCharacter) throws Exception {
		int id;
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into ddbbRol.character(nombre, idAvatar, "
										+ "idArma, idPoder) values (?, ?, ?, ?)", 
							Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nuevoCharacter.getNombre());
			preparedStatement.setInt(2, nuevoCharacter.getAvatar().getIdAvatar());
			preparedStatement.setInt(3, nuevoCharacter.getArma().getIdArma());
			preparedStatement.setInt(4, nuevoCharacter.getPoder().getIdPoder());
			preparedStatement.executeUpdate();
			//obtenemos el id que ha asignado la base de datos para poder guardarlo en Ranking
			ResultSet rs = preparedStatement.getGeneratedKeys();
		    rs.next();
		    id = rs.getInt(1);
			System.out.println("Tu nuevo Character se ha guardado");
			return id;
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:
	 * Post: Este método devuelve un entero resultado de calcular el valor real que tiene la
	 * opción elegida de cierta pregunta teniendo en cuenta el arma y el poder del Character.
	 */
	private static int calcularValorOpcion(int respuesta, Arma arma, Poder poder, 
			Pregunta pregunta, boolean poderDefensivo) {
		int valorTotal = 0;
		int valorOpcion = 0;	
		if (respuesta == 1) {
			System.out.println(pregunta.getTextoOpcion1());
			valorOpcion = pregunta.getValorOpcion1();
		} else {
			System.out.println(pregunta.getTextoOpcion2());
			valorOpcion = pregunta.getValorOpcion2();
		}
		boolean pierdesVida;
		if (valorOpcion < 0) {
			pierdesVida = true;
		}
		else {
			pierdesVida = false;
		}
		if (pierdesVida) { 
			System.out.println("Pierdes " + valorOpcion + " puntos de vida.");
			if (poderDefensivo) {
				//El arma se suma poque es positivo el poder resta porque es negativo
				valorTotal = valorOpcion + arma.getDanyo() - poder.getdanyoDef();
				System.out.println(" Pierdes " + valorTotal + " puntos de vida.");
			} else {
				valorTotal = valorOpcion + arma.getDanyo();
				System.out.println("Pierdes " + valorTotal + " puntos de vida.");
			}
		} 
		// Si la Opcion te suma vida, el arma no tiene efecto 
		else {
			valorTotal = valorOpcion;
			System.out.println("Ganas " + valorTotal + " puntos de vida.");
		}
		return valorTotal;
	}
	
	/**
	 * Pre:---
	 * Post: Este método pregunta al usuario si quiere guardar su partida en el ranking
	 * y de ser así, llama al método `guardarRanking()`.
	 */
	private static void gameOver(Character character, int rondas) {
		System.out.println("Guardas en el Ranking\n   Si No");
		while(true) {
			String opcion = entrada.nextLine();
			if(opcion.equalsIgnoreCase("si")) {
				try {
					guardarRanking(character, rondas);
				} catch(Exception e) {}
				break;
			} else if (opcion.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Introduce una opcion correcta");
			}
		}
	}
	
	/**
	 *Pre:---
	 *Post: Este método guarda el resultado de la partida en la tabla `ranking´de 
	 *la base de datos. 
	 */
	private static void guardarRanking(Character character, int rondas) throws Exception {
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into ranking(idCharacter, rondas) values (?, ?)");
			preparedStatement.setInt(1, character.getIdCharacter());
			preparedStatement.setInt(2, rondas);
			// Ejecutamos el insert
			preparedStatement.executeUpdate();
			System.out.println("Registro guardado en el ranking");	
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}	
	}
	
	/**
	 * Pre:---
	 * Post: Este método muestra por pantalla el menú de opciones para insertar nuevas
	 * ideas al juego y según la opción que introduzca el usuario se llama al método 
	 * correspondiente.
	 */
	private static void NuevasIdeas() {
		System.out.println(" Menú para Insertar Nueva Ideas ");
		System.out.println();
		System.out.println("[1] Insertar Avatar ");
		System.out.println("[2] Insertar Arma  ");
		System.out.println("[3] Insertar Poder ");
		System.out.println("[4] Insertar Pregunta ");
		try {
			int respuesta = entrada.nextInt();
			entrada.nextLine();
			// insertar un Avatar
			if (respuesta == 1) {
				System.out.println("    AVATAR " );
				Avatar avatar = DatosAvatar();
				insertarAvatar(avatar);
				System.out.println("El avatar " + avatar.getNombre() + " Se ha guardado.");
			// insertar un Arma
			} else if (respuesta == 2) {
				System.out.println("    ARMA " );
				Arma arma = DatosArma();
				insertarArma(arma);
				System.out.println("El arma " + arma.getNombre() + " Se ha guardado");
			// insertar un Poder
			} else if (respuesta == 3) {
				System.out.println("    PODER " );
				Poder poder = DatosPoder();
				insertarPoder(poder);
				System.out.println("El poder " + poder.getNombre() + " Se ha guardado");
			// insertar una Pregunta
			} else if (respuesta == 4) {
				System.out.println("    PREGUNTA " );
				Pregunta pregunta = DatosPregunta();
				insertarPregunta(pregunta);
				System.out.println("La pregunta con texto: '" + pregunta.getTexto() 
					+ "' ha sido insertada.");
			} 
			else {
				System.out.println("Introduce una opcion correcta");
			}
		} catch (InputMismatchException e) {
			System.out.println("Introduce un numero correcto");
		} catch (Exception e) { e.printStackTrace();}
	}
	
	/**
	 * Pre:---
	 * Post: Este método pide al usuario que introduzca los datos
	 * necesarios para crear un nuevo Avatar y devuelve este objeto
	 * de tipo Avatar.
	 */
	private static Avatar DatosAvatar() {
		System.out.println("Introduce el nombre del avatar:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce un numero para la vida del avatar:");
		while (true) {
			String vida = entrada.nextLine();
			// Comprueba que la vida que ha introducido el usuario es un numero
			if (isInteger(vida) && Integer.parseInt (vida) > 0) {
				return new Avatar (nombre, Integer.parseInt(vida));
			} else {
				System.out.println("Introduce un numero correcto");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método recibe por parámetro el objeto de tipo Avatar que ha creado
	 * el usuario y lo introduce en la base de datos. 
	 */
	private static void insertarAvatar(Avatar avatar) throws Exception {
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into ddbbRol.avatar(nombre, vida) values (?, ?)");
					
			preparedStatement.setString(1, avatar.getNombre());
			preparedStatement.setInt(2, avatar.getVida());
			// Ejecutamos el insert
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método pide al usuario que introduzca los datos
	 * necesarios para crear una nueva arma y devuelve este objeto
	 * de tipo Arma.
	 */
	private static Arma DatosArma() {
		System.out.println("Introduce el nombre del arma:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el daño del arma (numero entero entre 0 y 150):");
		while (true) {
			String danyo = entrada.nextLine();
			// se comprueba que el danyo del arma es un numero positivo menor que 150
			if (isInteger(danyo) && Integer.parseInt (danyo) > 0 && Integer.parseInt(danyo) < 150) {
				return new Arma (nombre,Integer.parseInt(danyo));
			} else {
				System.out.println("Introduce un numero correcto");
			}
		}
	}
	
	/**
	 * Pre:--- 
	 * Post: Este método recibe por parámetro el objeto de tipo Arma que ha creado
	 * el usuario y lo introduce en la base de datos. 
	 */
	private static void insertarArma(Arma arma) throws Exception {
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into arma(nombre, danyo) values (?, ?)");
			preparedStatement.setString(1, arma.getNombre());
			preparedStatement.setInt(2, arma.getDanyo());
			// Ejecutamos el insert
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método pide al usuario que introduzca los datos
	 * necesarios para crear un nuevo poder y devuelve este objeto
	 * de tipo Poder.
	 */
	private static Poder DatosPoder() {
		System.out.println("Introduce el nombre del poder:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el daño (numero entero positivo entre 0 y 500) " 
						+ "o defensa (numero entero negativo hasta -500)");
		while (true) {
			String danyoDefensa = entrada.nextLine();
			//se comprueba que el  danyo no puede sea mayor de 500 ni menor de -500
			if (isInteger(danyoDefensa) && Integer.parseInt (danyoDefensa) > -500
					&& Integer.parseInt(danyoDefensa) < 500) {
				return new Poder (nombre, Integer.parseInt(danyoDefensa));
			} else {
				System.out.println("Introduce un numero");
			}
		}
	}
	
	/**
	 * Pre:--- 
	 * Post: Este método recibe por parámetro el objeto de tipo Poder que ha creado
	 * el usuario y lo introduce en la base de datos. 
	 */
	private static void insertarPoder(Poder poder) throws Exception {
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into poder(nombre, danyoDef) values (?, ?)");
			preparedStatement.setString(1, poder.getNombre());
			preparedStatement.setInt(2, poder.getdanyoDef());
			// Ejecutamos el insert
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
	
	/**
	 * Pre:---
	 * Post: Este método pide al usuario que introduzca los datos
	 * necesarios para crear una nueva pregunta y devuelve este objeto
	 * de tipo Pregunta.
	 */
	private static Pregunta DatosPregunta() {
		System.out.println("Introduce el texto de la pregunta: ");
		String texto = entrada.nextLine();
		System.out.println("Introduce el texto de la opcion 1: ");
		String opcion1 = entrada.nextLine();
		System.out.println("Introduce el texto de la opcion 2: ");
		String opcion2 = entrada.nextLine();
		// Pedimos los valores de las 2 consecuencias 
		System.out.println("Introduce el valor de la opcion 1: ");
		int valorOpcion1 = 0;
		boolean valor1Introducido = false;
		// Comprobamos que el valor de la opcion 1 es un numero
		while (!valor1Introducido) {
			try {
				valorOpcion1 = entrada.nextInt();
				entrada.nextLine();
				valor1Introducido = true;
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero ");
			}
		}
		System.out.println("Introduce el valor de la opcion 2: ");
		// Comprobamos que el valor de la opcion 2 es un numero
		while (true) {
			try {
				int valorOpcion2 = entrada.nextInt();
				entrada.nextLine();
				// se devuelve un nuevo objeto de tipo pregunta
				return new Pregunta(texto, opcion1, opcion2, 
						valorOpcion1, valorOpcion2);
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero ");
			}
		}
	}
	
	/**
	 * Pre:--- 
	 * Post: Este método recibe por parámetro el objeto de tipo Poder que ha creado
	 * el usuario y lo introduce en la base de datos. 
	 */
	private static void insertarPregunta(Pregunta pregunta) throws Exception {
		try {
			conexion.conectarBD();
			PreparedStatement preparedStatement = conexion.getConnect()
					.prepareStatement("insert into pregunta(" + "preguntaRol, " + "opcion1, "
							+ "" + "opcion2, valor1, " + "valor2) "
								+ "values (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, pregunta.getTexto());
			preparedStatement.setString(2, pregunta.getTextoOpcion1());
			preparedStatement.setString(3, pregunta.getTextoOpcion2());
			preparedStatement.setInt(4, pregunta.getValorOpcion1());
			preparedStatement.setInt(5, pregunta.getValorOpcion2());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			conexion.cerrarBD();
		}
	}
}