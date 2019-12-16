package Interface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	private int alto;
	private int ancho;
	private static final long serialVersionUID = 1L;

	public Ventana() {
		setTamanio();
		setLocationRelativeTo(null);
		setTitle("Hola mundo");
		setLogo();
		add(new LaminaTablero());
	}

	private void setLogo() {
		Image logo = Toolkit.getDefaultToolkit().getImage("src/Interface/Imagenes/logoUpward.png");
		setIconImage(logo);
	}

	private void setTamanio() {
		this.ancho = (dimensionPantalla().width) / 3;
		this.alto = (dimensionPantalla().height) / 2;
		setSize(ancho, alto);
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	private Dimension dimensionPantalla() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

}
