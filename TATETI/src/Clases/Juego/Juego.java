package Clases.Juego;

import javax.swing.JOptionPane;
import Clases.Jugadores.Jugador;
import Clases.Jugadores.JugadorO;
import Clases.Jugadores.JugadorX;
import Clases.Jugadores.LetrasJugadores;
import Clases.Tablero.Tablero;

public class Juego {
	private Tablero tablero;
	private JugadorX jugadorX;
	private JugadorO jugadorO;
	private Jugador primero;

	public Juego() {
		this.tablero = new Tablero();
		this.jugadorX = new JugadorX();
		this.jugadorO = new JugadorO();
		this.sortearPrimero();
	}

	public Jugador getPrimero() {
		return this.primero;
	}

	private void mostrarInstrucciones() {
		StringBuilder instrucciones = new StringBuilder();
		instrucciones.append("\n1. El tablero está compuesto por coordenadas.\n");
		instrucciones.append("2. A cada jugador se le pedirá que ingrese una coordenada por turno.\n");
		instrucciones.append("3. Luego de ingresar cada coordenada, los jugadores podrán ver cómo quedó el tablero.\n");
		instrucciones.append("4. Al llegar a un empate o ganador, el juego se detiene atuomáticamente y lo anuncia.\n");
		instrucciones.append("5. Finalmente se les preguntará si desean volver a jugar.\n");
		instrucciones.append(
				"6. En caso de aceptar, el proceso volverá a comenzar, de lo contrario se mostrarán los resultados históricos.\n");
		mostrar(instrucciones.toString(), "Instrucciones");
	}

	private void mostrarTableroVacio() {
		mostrarTablero();
	}

	private void sortearPrimero() {
		if (aleatoreoEsPar()) {
			setPrimero(this.jugadorO);
		} else {
			setPrimero(this.jugadorX);
		}

	}

	private boolean aleatoreoEsPar() {
		int numero = (int) (Math.random() * 2 + 1);
		return numero % 2 == 0;
	}

	private void setPrimero(Jugador primero) {
		this.primero = primero;
	}

	public void jugar() {
		mostrarInstrucciones();
		mostrarTableroVacio();
		sortearPrimero();
		pedirRondas();
		mostrarFinal();
	}

	private void pedirRondas() {
		Jugador segundo = obtenerSegundo(this.primero);

		while (sePuedaSeguirJugando()) {
			Ronda ronda = pedirRonda(this.primero);
			cargarRonda(ronda, this.primero);
			mostrarTablero();
			if (sePuedaSeguirJugando()) {
				ronda = pedirRonda(segundo);
				cargarRonda(ronda, segundo);
				mostrarTablero();
			}
		}
	}

	private boolean sePuedaSeguirJugando() {
		return !hayGanador() && !this.tablero.estaLleno();
	}

	private void mostrarTablero() {
		mostrar(this.tablero.toString());
	}

	private void mostrarFinal() {
		if (hayGanador()) {
			mostrar("El ganador es " + this.tablero.getGanador(), "¡Hay Ganador!");
		} else {
			mostrar("Empataron", "¡Empate!");
		}
	}

	private boolean hayGanador() {
		return this.tablero.obtenerGanador() != null;
	}

	private Jugador obtenerSegundo(Jugador primero) {
		Jugador segundo = null;
		if (primero.getLetrajugador().equals(LetrasJugadores.O)) {
			segundo = this.jugadorX;
		} else {
			segundo = this.jugadorO;
		}
		return segundo;
	}

	public void cargarRonda(Ronda ronda, Jugador jugador) {
		try {
			this.tablero.setValor(ronda.getAlto() - 1, ronda.getAncho() - 1, ronda.getJugador().toString());
		} catch (Exception e) {
			mostrar("Error " + e);
			cargarRonda(pedirRonda(jugador));
		}
	}

	public void cargarRonda(Ronda ronda) {
		this.tablero.setValor(ronda.getAlto() - 1, ronda.getAncho() - 1, ronda.getJugador().toString());
	}

	public Tablero getTablero() {
		return tablero;
	}

	private void mostrar(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 2);
	}

	private void mostrar(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	private Ronda pedirRonda(Jugador jugador) {
		mostrar(jugador.getClass().getSimpleName() + " es tu turno.");
		Ronda ronda = null;
		try {
			String respuesta = JOptionPane.showInputDialog("Ingrese Alto");
			int alto = Integer.parseInt(respuesta);
			respuesta = JOptionPane.showInputDialog("Ingrese Ancho");
			int ancho = Integer.parseInt(respuesta);
			ronda = new Ronda(alto, ancho, jugador.getLetrajugador());
		} catch (Exception e) {
			mostrar(e + "");
		}
		return ronda;
	}

}
