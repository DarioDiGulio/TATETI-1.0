package Clases.Tablero;

import Clases.Jugadores.LetrasJugadores;

public class Tablero implements Tableable {
	private String[][] tablero;
	public static final int ALTO_TABLERO = 3;
	public static final int ANCHO_TABLERO = 3;
	private int elementosTotalesDisponibles;
	private LetrasJugadores ganador;

	public Tablero() {
		this.tablero = new String[ALTO_TABLERO][ANCHO_TABLERO];
		this.elementosTotalesDisponibles = ALTO_TABLERO * ANCHO_TABLERO;
		inicializarTablero();
		this.ganador = null;
	}

	private void inicializarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = "(" + (i + 1) + "," + (j + 1) + ")";
			}
		}
	}

	@Override
	public void setValor(int alto, int ancho, String valor) {

		if (esPosicionValida(alto, ancho)) {
			if (estaPosicionVacia(alto, ancho)) {
				this.tablero[alto][ancho] = "|  " + valor + "  |";
			}
		}

	}

	private boolean estaPosicionVacia(int alto, int ancho) {
		boolean estaPosocionVacia = true;

		if (getValorTablero(alto, ancho) == "X" || getValorTablero(ancho, alto) == "O") {
			estaPosocionVacia = false;
			throw new IllegalArgumentException("La ubicación pretendida del valor no está vacía.");
		}

		return estaPosocionVacia;
	}

	private boolean esPosicionValida(int alto, int ancho) {
		boolean esPosicionValida = true;

		if (alto > ALTO_TABLERO || ancho > ANCHO_TABLERO) {
			esPosicionValida = false;
			throw new IllegalArgumentException("La ubicación pretendida del valor no es válida.");
		}

		if (alto < 0 || ancho < 0) {
			esPosicionValida = false;
			throw new IllegalArgumentException("La ubicación pretendida del valor no es válida.");
		}

		return esPosicionValida;
	}

	@Override
	public String getValorTablero(int alto, int ancho) {
		return this.tablero[alto][ancho];
	}

	@Override
	public boolean estaVacio() {
		return cantidadDeElementosIngresados() == 0;
	}

	@Override
	public boolean estaLleno() {
		return cantidadDeElementosIngresados() == this.elementosTotalesDisponibles;
	}

	@Override
	public int cantidadDeElementosIngresados() {
		int contador = 0;

		for (int i = 0; i < ALTO_TABLERO; i++) {
			for (int j = 0; j < ANCHO_TABLERO; j++) {
				if (!estaPosicionVacia(i, j)) {
					contador++;
				}
			}
		}

		if (contador < 0) {
			throw new IllegalAccessError("No se pueden contar los elementos ingresados.");
		}

		return contador;
	}

	private String obtenerJugadorDelTablero(int alto, int ancho) {
		return this.tablero[alto][ancho].toString();
	}

	@Override
	public String obtenerGanador() {
		String ganador = null;

		if (this.cantidadDeElementosIngresados() > 4) {
			ganador = comprobarFilas();
			if (ganador == null) {
				ganador = comprobarColumnas();
				if (ganador == null) {
					ganador = comprobarDiagonales();
				}
			}
			if (ganador != null) {
				setGanador(ganador);
			}
		}

		return ganador;
	}

	private String comprobarColumnas() {
		String ganador = null;

		if (comprobarPrimerColumna()) {
			ganador = obtenerJugadorDelTablero(0, 0);
		} else if (comprobarSegundaColumna()) {
			ganador = obtenerJugadorDelTablero(1, 0);
		} else if (comprobarTercerColumna()) {
			ganador = obtenerJugadorDelTablero(2, 0);
		}

		return ganador;
	}

	private LetrasJugadores obtenerLetraGanador(String ganador) {
		LetrasJugadores letraGanador = null;
		if (ganador.equals("X")) {
			letraGanador = LetrasJugadores.X;
		} else {
			letraGanador = LetrasJugadores.O;
		}
		return letraGanador;
	}

	private String comprobarDiagonales() {
		String ganador = null;

		if (comprobarDiagonalA()) {
			ganador = obtenerJugadorDelTablero(0, 0);
		} else if (comprobarDiagonalB()) {
			ganador = obtenerJugadorDelTablero(0, 2);
		}

		return ganador;
	}

	private boolean comprobarDiagonalB() {
		return getValorTablero(0, 2).equals(getValorTablero(1, 1))
				&& getValorTablero(1, 1).equals(getValorTablero(2, 0));
	}

	private boolean comprobarDiagonalA() {
		return getValorTablero(0, 0).equals(getValorTablero(1, 1))
				&& getValorTablero(1, 1).equals(getValorTablero(2, 2));
	}

	private boolean comprobarTercerColumna() {
		return getValorTablero(0, 2).equals(getValorTablero(1, 2))
				&& getValorTablero(1, 2).equals(getValorTablero(2, 2));
	}

	private boolean comprobarSegundaColumna() {
		return getValorTablero(0, 1).equals(getValorTablero(1, 1))
				&& getValorTablero(1, 1).equals(getValorTablero(2, 1));
	}

	private boolean comprobarPrimerColumna() {
		return getValorTablero(0, 0).equals(getValorTablero(1, 0))
				&& getValorTablero(1, 0).equals(getValorTablero(2, 0));
	}

	private String comprobarFilas() {
		String ganador = null;

		if (comprobarPrimerFila()) {
			ganador = obtenerJugadorDelTablero(0, 0);
		} else if (comprobarSegundaFila()) {
			ganador = obtenerJugadorDelTablero(1, 0);
		} else if (comprobarTercerFila()) {
			ganador = obtenerJugadorDelTablero(2, 0);
		}

		return ganador;
	}

	private boolean comprobarTercerFila() {
		return getValorTablero(2, 0).equals(getValorTablero(2, 1))
				&& getValorTablero(2, 1).equals(getValorTablero(2, 2));
	}

	private boolean comprobarSegundaFila() {
		return getValorTablero(1, 0).equals(getValorTablero(1, 1))
				&& getValorTablero(1, 1).equals(getValorTablero(1, 2));
	}

	private boolean comprobarPrimerFila() {
		return getValorTablero(0, 0).equals(getValorTablero(0, 1))
				&& getValorTablero(0, 1).equals(getValorTablero(0, 2));
	}

	public LetrasJugadores getGanador() {
		return this.ganador;
	}

	private void setGanador(String ganador) {
		this.ganador = obtenerLetraGanador(ganador);
	}

	@Override
	public String toString() {
		String mostraTablero = "";

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				mostraTablero += this.tablero[i][j];
			}
			mostraTablero += "\n";
		}

		return mostraTablero;
	}

}
