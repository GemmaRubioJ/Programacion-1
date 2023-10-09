package juegoDeLaVida;

public class Pruebas {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Prueba de BLOQUE en 30 generaciones;
		 */
		String[][] pruebaBloque = new String [4][4];
		pruebaBloque[0][0] = " ";
		pruebaBloque[0][1] = " ";
		pruebaBloque[0][2] = " ";
		pruebaBloque[0][3] = " ";
		pruebaBloque[1][0] = " ";
		pruebaBloque[1][1] = "*";
		pruebaBloque[1][2] = "*";
		pruebaBloque[1][3] = " ";
		pruebaBloque[2][0] = " ";
		pruebaBloque[2][1] = "*";
		pruebaBloque[2][2] = "*";
		pruebaBloque[2][3] = " ";
		pruebaBloque[3][0] = " ";
		pruebaBloque[3][1] = " ";
		pruebaBloque[3][2] = " ";
		pruebaBloque[3][3] = " ";
		System.out.println("PRIMERA PRUEBA = BLOQUE");
		Main.crearGeneraciones(pruebaBloque, 30);
		System.out.println();
		
		/*
		 * Prueba INTERMITENTE en 30 generaciones.
		 */
		String[][] pruebaIntermitente = new String[5][5];
		pruebaIntermitente[0][0] = " ";
		pruebaIntermitente[0][1] = " ";
		pruebaIntermitente[0][2] = " ";
		pruebaIntermitente[0][3] = " ";
		pruebaIntermitente[0][4] = " ";
		pruebaIntermitente[1][0] = " ";
		pruebaIntermitente[1][1] = " ";
		pruebaIntermitente[1][2] = " ";
		pruebaIntermitente[1][3] = " ";
		pruebaIntermitente[1][4] = " ";
		pruebaIntermitente[2][0] = " ";
		pruebaIntermitente[2][1] = "*";
		pruebaIntermitente[2][2] = "*";
		pruebaIntermitente[2][3] = "*";
		pruebaIntermitente[2][4] = " ";
		pruebaIntermitente[3][0] = " ";
		pruebaIntermitente[3][1] = " ";
		pruebaIntermitente[3][2] = " ";
		pruebaIntermitente[3][3] = " ";
		pruebaIntermitente[3][4] = " ";
		pruebaIntermitente[4][0] = " ";
		pruebaIntermitente[4][1] = " ";
		pruebaIntermitente[4][2] = " ";
		pruebaIntermitente[4][3] = " ";
		pruebaIntermitente[4][4] = " ";
		System.out.println("SEGUNDA PRUEBA = INTERMITENTE");
		Main.crearGeneraciones(pruebaIntermitente, 30);
		
		/*
		 * Prueba del FARO en 30 generaciones.
		 */
		String[][] pruebaFaro = new String[6][6];
		pruebaFaro[0][0] = " ";
		pruebaFaro[0][1] = " ";
		pruebaFaro[0][2] = " ";
		pruebaFaro[0][3] = " ";
		pruebaFaro[0][4] = " ";
		pruebaFaro[0][5] = " ";
		pruebaFaro[1][0] = " ";
		pruebaFaro[1][1] = "*";
		pruebaFaro[1][2] = "*";
		pruebaFaro[1][3] = " ";
		pruebaFaro[1][4] = " ";
		pruebaFaro[1][5] = " ";
		pruebaFaro[2][0] = " ";
		pruebaFaro[2][1] = "*";
		pruebaFaro[2][2] = "*";
		pruebaFaro[2][3] = " ";
		pruebaFaro[2][4] = " ";
		pruebaFaro[2][5] = " ";
		pruebaFaro[3][0] = " ";
		pruebaFaro[3][1] = " ";
		pruebaFaro[3][2] = " ";
		pruebaFaro[3][3] = "*";
		pruebaFaro[3][4] = "*";
		pruebaFaro[3][5] = " ";
		pruebaFaro[4][0] = " ";
		pruebaFaro[4][1] = " ";
		pruebaFaro[4][2] = " ";
		pruebaFaro[4][3] = "*";
		pruebaFaro[4][4] = "*";
		pruebaFaro[4][5] = " ";
		pruebaFaro[5][0] = " ";
		pruebaFaro[5][1] = " ";
		pruebaFaro[5][2] = " ";
		pruebaFaro[5][3] = " ";
		pruebaFaro[5][4] = " ";
		pruebaFaro[5][5] = " ";	
		System.out.println("TERCERA  PRUEBA = FARO");
		Main.crearGeneraciones(pruebaFaro, 30);
	}

}
