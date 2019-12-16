package Clases.Jugadores;

abstract public class Jugador implements Jugable {
	private LetrasJugadores letraJugador;

	public LetrasJugadores getLetrajugador() {
		return this.letraJugador;
	}

	abstract public int getVictorias();

	abstract public int getEmpates();

	abstract public int getDerrotas();

	abstract public void perdio(); 

	abstract public void gano();

	abstract public void empato();

	public void setLetraJugador(LetrasJugadores letra) {
		this.letraJugador = letra;
	}
}
