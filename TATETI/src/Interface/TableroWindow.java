package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TableroWindow {

	private JFrame frmTateti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroWindow window = new TableroWindow();
					window.frmTateti.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TableroWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTateti = new JFrame();
		frmTateti.getContentPane().setBackground(new Color(112, 128, 144));
		frmTateti.setTitle("TATETI 1.0 - By Upward");
		frmTateti.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Desktop\\Proyectos Personales\\TATETI\\src\\Interface\\Imagenes\\logoUpward.png"));
		frmTateti.setForeground(Color.BLACK);
		frmTateti.setBounds(100, 100, 450, 300);
		frmTateti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmTateti.setJMenuBar(menuBar);

		JMenu mnJuego = new JMenu("Juego");
		mnJuego.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(mnJuego);

		JMenuItem mntmEmpezar = new JMenuItem("Empezar");
		mnJuego.add(mntmEmpezar);

		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mnJuego.add(mntmReiniciar);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnJuego.add(mntmSalir);

		JMenu mnHistorial = new JMenu("Historial");
		menuBar.add(mnHistorial);

		JMenuItem mntmMostrarHistorial = new JMenuItem("Mostrar Historial");
		mnHistorial.add(mntmMostrarHistorial);

		JCheckBoxMenuItem chckbxmntmModoOscur = new JCheckBoxMenuItem("Modo Oscuro");
		menuBar.add(chckbxmntmModoOscur);
	}

}
