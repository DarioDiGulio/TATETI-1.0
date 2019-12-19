package Test;

import javax.swing.JOptionPane;

import Clases.Juego.Juego;
import Clases.Juego.Ronda;
import Clases.Jugadores.LetrasJugadores;

public class TestJuego {
	public static void main(String[] args) {
		ejecutarTest();
	}

	private static void ejecutarTest() {
		String mensaje = "";
		mensaje += testearSorteoPrimero();
		mensaje += testearEmpate();
		mensaje += testearVictoriaX();
		mensaje += testearVictoriaO();
		mostrar(mensaje);
	}

	private static String testearVictoriaO() {
		String mensaje = "";
		Juego juego = new Juego();
		try {
			juego.cargarRonda(new Ronda(1, 2, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(2, 2, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(3, 2, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(2, 1, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(3, 3, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(1, 1, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(1, 3, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(2, 3, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(3, 1, LetrasJugadores.X));
			if (juego.getTablero().obtenerGanador().contains("O")) {
				mensaje += "2. El juego soporta una victoria del jugador O correctamente." + "\n";
			} else {
				mensaje += "2. El juego no soporta una victoria del jugador O correctamente." + "\n";
			}
		} catch (Exception e) {
			mensaje += e + "\n";
		}
		return mensaje;
	}

	private static String testearVictoriaX() {
		String mensaje = "";
		Juego juego = new Juego();
		try {
			juego.cargarRonda(new Ronda(1, 2, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(2, 2, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(3, 2, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(2, 1, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(3, 3, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(1, 1, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(1, 3, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(2, 3, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(3, 1, LetrasJugadores.O));
			if (juego.getTablero().obtenerGanador().contains("X")) {
				mensaje += "2. El juego soporta una victoria del jugador X correctamente." + "\n";
			} else {
				mensaje += "2. El juego no soporta una victoria del jugador X correctamente." + "\n";
			}
		} catch (Exception e) {
			mensaje += e + "\n";
		}
		return mensaje;
	}

	private static String testearEmpate() {
		String mensaje = "";
		Juego juego = new Juego();
		try {
			juego.cargarRonda(new Ronda(1, 1, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(1, 3, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(2, 1, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(2, 3, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(3, 2, LetrasJugadores.O));
			juego.cargarRonda(new Ronda(1, 2, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(2, 2, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(3, 1, LetrasJugadores.X));
			juego.cargarRonda(new Ronda(3, 3, LetrasJugadores.X));
			if (juego.getTablero().obtenerGanador() == null) {
				mensaje += "2. El juego soporta un empate correctamente." + "\n";
			} else {
				mensaje += "2. El juego no soporta un empate correctamente." + "\n";
			}
		} catch (Exception e) {
			mensaje += e + "\n";
		}
		return mensaje;
	}

	public static String testearSorteoPrimero() {
		String mensaje = "";
		Juego juego = new Juego();
		String letraJuego = juego.getPrimero().getLetrajugador().toString();
		Juego juego1 = new Juego();
		String letraJuego1 = juego1.getPrimero().getLetrajugador().toString();
		Juego juego2 = new Juego();
		String letraJuego2 = juego2.getPrimero().getLetrajugador().toString();
		Juego juego3 = new Juego();
		String letraJuego3 = juego3.getPrimero().getLetrajugador().toString();
		Juego juego4 = new Juego();
		String letraJuego4 = juego4.getPrimero().getLetrajugador().toString();
		if (letraJuego != letraJuego1 || letraJuego != letraJuego2 || letraJuego != letraJuego3
				|| letraJuego != letraJuego4) {
			mensaje += "1. El juego sortea correctamente al primer jugador." + "\n";
		} else {
			mensaje += "1. El juego no sortea correctamente al primer jugador." + "\n";
		}
		return mensaje;
	}

	public static void mostrar(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 2);
	}

	public static void mostrar(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
