package Clases.Tablero;

public interface Tableable {
	
	public void setValor(int alto, int ancho, String valor);
	
	public String getValorTablero(int alto, int ancho);
	
	public boolean estaVacio();
	
	public boolean estaLleno();
	
	public int cantidadDeElementosIngresados();
	
	public String obtenerGanador();
}
