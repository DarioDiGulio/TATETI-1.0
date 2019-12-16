package Clases.Jugadores;

public enum LetrasJugadores {
	X(1), O(2);
	
	private int numeroAsociado;

	private LetrasJugadores(int numeroAsociado) {
		this.numeroAsociado = numeroAsociado;
	}

	public int getNumeroAsociado() {
		return numeroAsociado;
	}
	
	
}
