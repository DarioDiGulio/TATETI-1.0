 package Test;

import javax.swing.JOptionPane;
import Clases.Jugadores.*;

public class TestJugadores {

	public static void main(String[] args) {
		ejecutarTest();
	}

	private static void ejecutarTest() {
		seteosIniciales();
		ejecutarTestX();
		ejecutarTestO();
	}

	private static void ejecutarTestO() {
		String mensajeFinalDeTestO = "";
		mensajeFinalDeTestO = testJugador(new JugadorO());
		mostrar(mensajeFinalDeTestO, "JugadorO");
	}

	private static void ejecutarTestX() {
		String mensajeFinalDeTestX = "";
		mensajeFinalDeTestX = testJugador(new JugadorX());
		mostrar(mensajeFinalDeTestX, "JugadorX");
	}

	private static void seteosIniciales() {
		JugadorO jugadorO2 = new JugadorO();
		JugadorX jugadorX2 = new JugadorX();

		jugadorO2.gano();
		jugadorX2.gano();
		jugadorO2.empato();
		jugadorX2.empato();
		jugadorO2.perdio();
		jugadorX2.perdio();
	}

	private static String testJugador(Jugador jugador) {
		String mensajeFinalDeTest = "";

		mensajeFinalDeTest += testearLetraJugador(jugador) + "\n";
		mensajeFinalDeTest += testearGanarJugador(jugador) + "\n";
		mensajeFinalDeTest += testearEmpatarJugador(jugador) + "\n";
		mensajeFinalDeTest += testearPerderJugador(jugador) + "\n";

		return mensajeFinalDeTest;
	}

	private static String obtenerTipoJugador(Jugador jugador) {
		char[] nombreClaseJugador = new char[jugador.getClass().getSimpleName().toCharArray().length - 1];
		nombreClaseJugador = jugador.getClass().getSimpleName().toCharArray();
		char tipoJugador = nombreClaseJugador[nombreClaseJugador.length - 1];
		return tipoJugador + "";
	}

	private static String testearLetraJugador(Jugador jugador) {
		String mensajeFinalDeTest;
		String tipoJugador = obtenerTipoJugador(jugador);
		if (jugador.getLetrajugador().toString().equals(tipoJugador)) {
			mensajeFinalDeTest = "1. Tiene asignada la letra correcta.";
		} else {
			mensajeFinalDeTest = "1. Tiene asignada una letra equivocada.";
		}
		return mensajeFinalDeTest;
	}

	private static String testearGanarJugador(Jugador jugador) {
		String mensajeFinalDeTest = "";
		if (jugador.getVictorias() == 1) {
			jugador.gano();
			if (jugador.getVictorias() == 2) {
				mensajeFinalDeTest = "2. Puede ganar correctamente.";
			} else {
				mensajeFinalDeTest = "2. Tiene un problema en el método ganar.";
			}
		} else {
			mensajeFinalDeTest = "2. Tiene un problema en el método ganar.";
		}

		return mensajeFinalDeTest;
	}

	private static String testearEmpatarJugador(Jugador jugador) {
		String mensajeFinalDeTest = "";
		if (jugador.getEmpates() == 1) {
			jugador.empato();
			if (jugador.getEmpates() == 2) {
				mensajeFinalDeTest = "3. Puede empatar correctamente.";
			} else {
				mensajeFinalDeTest = "3. Tiene un problema en el método empatar.";
			}
		} else {
			mensajeFinalDeTest = "3. Tiene un problema en el método empatar.";
		}
		return mensajeFinalDeTest;
	}

	private static String testearPerderJugador(Jugador jugador) {
		String mensajeFinalDeTest = "";
		if (jugador.getDerrotas() == 1) {
			jugador.perdio();
			if (jugador.getDerrotas() == 2) {
				mensajeFinalDeTest = "4. Puede perder correctamente.";
			} else {
				mensajeFinalDeTest = "4. Tiene un problema en el método perder.";
			}
		} else {
			mensajeFinalDeTest = "4. Tiene un problema en el método perder.";
		}
		return mensajeFinalDeTest;
	}

	public static void mostrar(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 1, null);
	}

}
