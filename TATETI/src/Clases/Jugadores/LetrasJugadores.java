package Clases.Jugadores;

public enum LetrasJugadores {
	X("|  X  |"), O("|  O  |");

	private String valorAsociado;

	private LetrasJugadores(String valorAsociado) {
		this.valorAsociado = valorAsociado;
	}

	public String getValorAsociado() {
		return valorAsociado;
	}

}
