package Test;

import javax.swing.JFrame;

import Interface.Ventana;

public class TestVentana {

	public static void main(String[] args) {
		Ventana marco1 = new Ventana();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
