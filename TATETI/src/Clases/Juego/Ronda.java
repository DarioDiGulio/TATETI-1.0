package Clases.Juego;

import Clases.Jugadores.LetrasJugadores;

public class Ronda {
	private int alto;
	private int ancho;
	private String jugador;

	public Ronda(int alto, int ancho, LetrasJugadores jugador) {
		setAlto(alto);
		setAncho(ancho);
		setJugador(jugador);
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto > 0 && alto < 4) {
			this.alto = alto;
		} else {
			throw new IllegalAccessError("No ingresaste un alto correcto. [1, 2 o 3 son válidos]");
		}
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho > 0 && ancho < 4) {
			this.ancho = ancho;
		} else {
			throw new IllegalAccessError("No ingresaste un ancho correcto. [1, 2 o 3 son válidos]");
		}
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(LetrasJugadores jugador) {
		this.jugador = jugador.toString();
	}

}
