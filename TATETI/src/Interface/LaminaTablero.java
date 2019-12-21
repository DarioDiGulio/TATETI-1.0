package Interface;

import java.awt.Graphics;

import javax.swing.JPanel;

import Clases.Juego.Juego;

public class LaminaTablero extends JPanel {

	private static final long serialVersionUID = 1L;
	private Juego juego;
	private int altoTotal;
	private int anchoTotal;

//	public LaminaTablero() {
//		setTamanio();
//		crearJuego();
//	}

	private void crearJuego() {
		this.juego = new Juego();
	}

	private void setTamanio() {
		Ventana ventana = new Ventana();
		this.anchoTotal = ventana.getAncho();
		this.altoTotal = ventana.getAlto();
	}

	public void paintComponent(Graphics g) {
		crearJuego();
		setTamanio();
		super.paintComponent(g);
		g.drawString(this.juego.getTablero().toString(), this.altoTotal / 2, this.anchoTotal / 2);
	}

}
