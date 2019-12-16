package Test;

import javax.swing.JOptionPane;

import Clases.Jugadores.LetrasJugadores;
import Clases.Tablero.Tablero;

public class TestTablero {

	public static void main(String[] args) {
		ejecutarTest();
	}

	private static void ejecutarTest() {
		String mensaje = "";
		mensaje += testearInicializacion() + "\n";
		mensaje += testearIngresarElementos() + "\n";
		mensaje += testearCantidadIngresos() + "\n";
		mensaje += testearGanadores();
		mostrar(mensaje, "Resultado");
		mostrarTablero();
	}

	private static void mostrarTablero() {
		Tablero tablero = new Tablero();
		mostrar(tablero.toString(), "Tablero Vacío");
		tablero = llenarTablero(tablero);
		mostrar(tablero.toString(), "Tablero Lleno");

	}

	private static Tablero llenarTablero(Tablero tablero) {
		tablero.setValor(0, 0, LetrasJugadores.X.toString());
		tablero.setValor(0, 1, LetrasJugadores.X.toString());
		tablero.setValor(0, 2, LetrasJugadores.O.toString());
		tablero.setValor(1, 0, LetrasJugadores.O.toString());
		tablero.setValor(1, 1, LetrasJugadores.O.toString());
		tablero.setValor(1, 2, LetrasJugadores.X.toString());
		tablero.setValor(2, 0, LetrasJugadores.O.toString());
		tablero.setValor(2, 1, LetrasJugadores.X.toString());
		tablero.setValor(2, 2, LetrasJugadores.O.toString());
		return tablero;
	}

	private static String testearGanadores() {
		String mensaje = "";
		mensaje += "4." + testearDiagonalA() + "\n";
		mensaje += "5." + testearDiagbonalB() + "\n";
		mensaje += "6." + testearFilaUno() + "\n";
		mensaje += "7." + testearFilaDos() + "\n";
		mensaje += "8." + testearFilaTres() + "\n";
		mensaje += "9." + testearColumnaUno() + "\n";
		mensaje += "10." + testearColumnaDos() + "\n";
		mensaje += "11." + testearColumnaTres() + "\n";
		return mensaje;
	}

	private static String testearColumnaTres() {
		String mensaje = "El tablero no puede reconocer el ganador en la columna tres." + "\n";
		Tablero tablero = new Tablero();

		tablero.setValor(1, 0, "X");
		tablero.setValor(1, 1, "X");
		tablero.setValor(0, 2, LetrasJugadores.O.toString());
		tablero.setValor(1, 2, LetrasJugadores.O.toString());
		tablero.setValor(2, 2, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la columna tres." + "\n";
		}

		mensaje += testearIdentificarGanador(tablero);

		return mensaje;
	}

	private static String testearIdentificarGanador(Tablero tablero) {
		String mensaje = "";

		if (tablero.getGanador().equals(LetrasJugadores.O)) {
			mensaje += "12.El tablero reconoce correctamente la letra del ganador." + "\n";
			;
			mensaje += "Por ejemplo, en este tablero es " + tablero.getGanador().toString() + "." + "\n";
			mensaje += tablero.toString() + "\n";
		} else {
			mensaje += "12.El tablero no reconoce la letra del ganador.";
		}

		return mensaje;
	}

	private static String testearColumnaDos() {
		String mensaje = "El tablero no puede reconocer el ganador en la columna dos.";
		Tablero tablero = new Tablero();

		tablero.setValor(0, 2, "X");
		tablero.setValor(1, 2, "X");
		tablero.setValor(0, 1, LetrasJugadores.O.toString());
		tablero.setValor(1, 1, LetrasJugadores.O.toString());
		tablero.setValor(2, 1, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la columna dos.";
		}

		return mensaje;
	}

	private static String testearColumnaUno() {
		String mensaje = "El tablero no puede reconocer el ganador en la columna uno.";
		Tablero tablero = new Tablero();

		tablero.setValor(0, 2, "X");
		tablero.setValor(1, 1, "X");
		tablero.setValor(0, 0, LetrasJugadores.O.toString());
		tablero.setValor(1, 0, LetrasJugadores.O.toString());
		tablero.setValor(2, 0, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la columna uno.";
		}

		return mensaje;
	}

	private static String testearFilaTres() {
		String mensaje = "El tablero no puede reconocer el ganador en la fila tres.";
		Tablero tablero = new Tablero();

		tablero.setValor(0, 2, "X");
		tablero.setValor(1, 1, "X");
		tablero.setValor(2, 0, LetrasJugadores.O.toString());
		tablero.setValor(2, 1, LetrasJugadores.O.toString());
		tablero.setValor(2, 2, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la fila tres.";
		}

		return mensaje;
	}

	private static String testearFilaDos() {
		String mensaje = "El tablero no puede reconocer el ganador en la fila dos.";
		Tablero tablero = new Tablero();

		tablero.setValor(2, 2, "X");
		tablero.setValor(2, 1, "X");
		tablero.setValor(1, 0, LetrasJugadores.O.toString());
		tablero.setValor(1, 1, LetrasJugadores.O.toString());
		tablero.setValor(1, 2, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la fila dos.";
		}

		return mensaje;
	}

	private static String testearFilaUno() {
		String mensaje = "El tablero no puede reconocer el ganador en la fila uno.";
		Tablero tablero = new Tablero();

		tablero.setValor(2, 2, "X");
		tablero.setValor(2, 1, "X");
		tablero.setValor(0, 0, LetrasJugadores.O.toString());
		tablero.setValor(0, 1, LetrasJugadores.O.toString());
		tablero.setValor(0, 2, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la fila uno.";
		}

		return mensaje;
	}

	private static String testearDiagbonalB() {
		String mensaje = "El tablero no puede reconocer el ganador en la diagonal B.";
		Tablero tablero = new Tablero();

		tablero.setValor(2, 2, "X");
		tablero.setValor(2, 1, "X");
		tablero.setValor(0, 2, LetrasJugadores.O.toString());
		tablero.setValor(1, 1, LetrasJugadores.O.toString());
		tablero.setValor(2, 0, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la diagonal B.";
		}

		return mensaje;
	}

	private static String testearDiagonalA() {
		String mensaje = "El tablero no puede reconocer el ganador en la diagonal A.";
		Tablero tablero = new Tablero();

		tablero.setValor(2, 1, "X");
		tablero.setValor(2, 0, "X");
		tablero.setValor(0, 0, LetrasJugadores.O.toString());
		tablero.setValor(1, 1, LetrasJugadores.O.toString());
		tablero.setValor(2, 2, LetrasJugadores.O.toString());

		if (tablero.obtenerGanador() != null) {
			mensaje = "El tablero puede reconocer el ganador en la diagonal A.";
		}

		return mensaje;
	}

	private static String testearInicializacion() {
		Tablero tablero = new Tablero();
		String mensaje = "";
		if (tablero.toString() != null) {
			try {
				if (tablero.estaVacio()) {
					mensaje += "1. El tablero se crea correctamente.";
				} else {
					mensaje += "1. El tablero tiene problemas para crearse.";
				}
			} catch (Exception e) {
				mensaje += "1. " + e;
			}
		} else {
			mensaje += "1. El tablero tiene problemas para crearse.";
		}
		return mensaje;
	}

	private static String testearIngresarElementos() {
		Tablero tablero = new Tablero();
		String mensaje = "";
		try {
			tablero.setValor(0, 1, LetrasJugadores.X.toString());
		} catch (Exception e) {
			mensaje += "2. " + e;
		}
		if (tablero.getValorTablero(0, 1).equals(LetrasJugadores.X.toString())) {
			tablero.setValor(0, 2, LetrasJugadores.O.toString());
			if (tablero.getValorTablero(0, 2).equals(LetrasJugadores.O.toString())) {
				mensaje += "2. El tablero puede recibir valores correctamente.";
			}
		} else {
			mensaje += "2. El tablero no puede recibir correctamente valores.";
		}

		return mensaje;
	}

	public static String testearCantidadIngresos() {
		Tablero tablero = new Tablero();
		String mensaje = "";
		try {
			tablero.setValor(0, 0, LetrasJugadores.X.toString());
			tablero.setValor(0, 1, LetrasJugadores.O.toString());
			tablero.setValor(1, 0, LetrasJugadores.X.toString());
			tablero.setValor(1, 2, LetrasJugadores.X.toString());
		} catch (Exception exception) {
			mensaje += "Excepción " + exception;
		}
		if (tablero.cantidadDeElementosIngresados() == 4) {
			mensaje += "3. El tablero puede contar correctamente los valores que tiene insertados.";
		} else {
			mensaje += "3. El tablero no puede contar correctamente los valores que tiene insertados.";
		}
		return mensaje;
	}

	public static void mostrar(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 1, null);
	}

}
