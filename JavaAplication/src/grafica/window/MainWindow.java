package grafica.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Inicio - Manos Veneguayas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);
		
		JMenuItem mntmCompletarRegistro = new JMenuItem("Completar registro");
		mntmCompletarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evento que muestra la pestaña completar registro
				
				
				
				
			}
		});
		menuUsuarios.add(mntmCompletarRegistro);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar usuario");
		menuUsuarios.add(mntmModificarUsuario);
		
		JMenuItem mntmEliminarUsuario = new JMenuItem("Eliminar usuario");
		menuUsuarios.add(mntmEliminarUsuario);
		
		JMenuItem mntmVerInformacionDe = new JMenuItem("Ver informacion de usuario");
		menuUsuarios.add(mntmVerInformacionDe);
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmRealizarBusqueda = new JMenuItem("Realizar busqueda");
		mnListados.add(mntmRealizarBusqueda);
		
		JMenuItem menuItem = new JMenuItem("");
		mnListados.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Oculto todas las pestañas antes de mostrar la ventana
		
	}
}
