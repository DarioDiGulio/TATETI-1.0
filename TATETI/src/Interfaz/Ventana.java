package Interfaz;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana {

	JFrame ventana;
	JPanel panelInicio;
	JTextField jugadorUno;
	JTextField jugadorDos;
	JButton comenzar;
	JLabel fondo;
	JPanel panelJuego;

	public Ventana() {
		setVentana();
		setPanelInicio();
		setFondo();
		setJugadores();
		setBoton();
		this.panelInicio.add(this.fondo, 0);
		this.panelInicio.add(this.jugadorUno, 0);
		this.panelInicio.add(this.jugadorDos, 0);
		this.panelInicio.add(this.comenzar, 0);
		this.ventana.add(this.panelInicio);
		this.ventana.setVisible(true);
	}

	private void setVentana() {
		this.ventana = new JFrame("TATETI");
		this.ventana.setLayout(null);
		this.ventana.setSize(450, 600);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ventana.setResizable(false);
	}

	private void setPanelInicio() {
		this.panelInicio = new JPanel();
		this.panelInicio.setSize(this.ventana.getWidth(), this.ventana.getHeight());
		this.panelInicio.setLayout(null);
		this.panelInicio.setVisible(true);

	}

	private void setFondo() {
		this.fondo = new JLabel();
		this.fondo.setSize(this.ventana.getWidth(), this.ventana.getHeight());
		this.fondo.setVisible(true);
		this.fondo.setIcon(new ImageIcon("src/Interfaz/Imagenes/fondo.jpg"));
	}

	private void setJugadores() {
		this.jugadorUno = new JTextField("Nombre del Jugador 1: ");
		this.jugadorUno.setBounds(60, 350, 150, 20);
		this.jugadorUno.setVisible(true);

		this.jugadorDos = new JTextField("Nombre del Jugador 2: ");
		this.jugadorDos.setBounds(250, 350, 150, 20);
		this.jugadorDos.setVisible(true);

	}

	private void setBoton() {
		this.comenzar = new JButton("Comenzar el juego");
		this.comenzar.setBounds(150, 450, 150, 20);
		this.comenzar.setVisible(true);
		this.comenzar.setBackground(Color.WHITE);
		setMouseListenerBotonComenzar();
	}

	private void setMouseListenerBotonComenzar() {
		this.comenzar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent eventoClick) {
				System.out.println(".mouseClicked()");
			}
		});
	}

}
