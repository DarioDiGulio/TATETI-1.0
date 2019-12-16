package Interface;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LaminaTablero extends JPanel {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Ventana ventana = new Ventana();
		int ancho = ventana.getAncho();
		int alto = ventana.getAlto();
		g.drawLine(ancho / 4, alto / 4, ancho - (ancho / 4), alto / 4);
		g.drawLine(ancho / 4, alto - (alto / 4), ancho - (ancho / 4), alto - (alto / 4));
		g.drawLine(ancho / 3, alto / 4, ancho / 3, alto - (alto / 3));
		g.drawLine((ancho / 5) * 2, alto / 10, (ancho / 5) * 3, alto / 10);
	}

}
