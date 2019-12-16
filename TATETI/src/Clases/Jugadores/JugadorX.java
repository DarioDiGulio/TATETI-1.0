package Clases.Jugadores;

public class JugadorX extends Jugador {
	
	private static int victorias = 0;
	private static int empates = 0;
	private static int derrotas = 0;
	
	public JugadorX() {
		super.setLetraJugador(LetrasJugadores.X);
	}

	@Override
	public void gano() {
		victorias++;
	}

	@Override
	public void perdio() {
		derrotas++;
	}

	@Override
	public void empato() {
		empates++;
	}

	@Override
	public int getVictorias() {
		return victorias;
	}

	@Override
	public int getEmpates() {
		return empates;
	}

	@Override
	public int getDerrotas() {
		return derrotas;
	}
	

}