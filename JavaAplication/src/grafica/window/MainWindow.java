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
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import grafica.controller.MainWindow_Controller;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.Box;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaString;
	private JPanel panelListaUsuarios;
	private JTable tableUsuariosNuevos;

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
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);
		
		JMenuItem mntmAgregarUsuario = new JMenuItem("Agregar usuario");
		menuUsuarios.add(mntmAgregarUsuario);
		
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
		
		JPanel panelNuevasPersonas = new JPanel();
		panelNuevasPersonas.setBounds(0, 0, 784, 440);
		contentPane.add(panelNuevasPersonas);
		panelNuevasPersonas.setLayout(null);
		
		JLabel lblListaDeNuevos = new JLabel("Lista de nuevos usuarios registrados recientemente (Usuarios no confirmados)");
		lblListaDeNuevos.setFont(new Font("Arial", Font.BOLD, 18));
		lblListaDeNuevos.setBounds(10, 11, 764, 23);
		panelNuevasPersonas.add(lblListaDeNuevos);
		
		JPanel panelBusquedaUsuarios = new JPanel();
		panelBusquedaUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusquedaUsuarios.setBounds(10, 45, 764, 79);
		panelNuevasPersonas.add(panelBusquedaUsuarios);
		panelBusquedaUsuarios.setLayout(null);
		
		JLabel lblBuscarUsuario = new JLabel("Buscar usuario: ");
		lblBuscarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarUsuario.setBounds(10, 11, 110, 18);
		panelBusquedaUsuarios.add(lblBuscarUsuario);
		
		txtBusquedaString = new JTextField();
		txtBusquedaString.setBounds(288, 12, 362, 21);
		panelBusquedaUsuarios.add(txtBusquedaString);
		txtBusquedaString.setColumns(10);
		
		JComboBox cmbCriterioBusqueda = new JComboBox();
		cmbCriterioBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Cedula Venezolana", "Nombre y Apellido"}));
		cmbCriterioBusqueda.setBounds(121, 12, 157, 20);
		panelBusquedaUsuarios.add(cmbCriterioBusqueda);
		
		panelListaUsuarios = new JPanel();
		panelListaUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaUsuarios.setBounds(10, 135, 764, 294);
		panelNuevasPersonas.add(panelListaUsuarios);
		panelListaUsuarios.setLayout(null);
		tableUsuariosNuevos = new JTable();
		JButton btnContinuarRegistro = new JButton("Continuar registro");
		btnContinuarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
			}
		});
		btnContinuarRegistro.setBounds(609, 260, 145, 23);
		panelListaUsuarios.add(btnContinuarRegistro);
		
		JScrollPane scrollPaneListaUsuariosNuevos = new JScrollPane();
		scrollPaneListaUsuariosNuevos.setBounds(10, 11, 744, 238);
		panelListaUsuarios.add(scrollPaneListaUsuariosNuevos);
		
		
		tableUsuariosNuevos.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneListaUsuariosNuevos.setViewportView(tableUsuariosNuevos);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.addActionListener(new ActionListener() {
			//Eventto del boton para buscar personas que son nuevas
			public void actionPerformed(ActionEvent arg0) {
				tableUsuariosNuevos.setModel(new DefaultTableModel());
				//Instancio el controlador
				MainWindow_Controller controller = new MainWindow_Controller();
				//int que identifica que tipo de criterio selecciono
				int type = cmbCriterioBusqueda.getSelectedIndex();
				//Texto para la busqueda
				String value = txtBusquedaString.getText();
				//Llamo al metodo que se encarga de
				//controlar la funcionalidad del boton buscar
				//Luego debo recibir los datos y mostrarlos
				DefaultTableModel model = controller.btnBuscarFunction(type, value);
				tableUsuariosNuevos.setModel(model);
				
				
				
				
				
				
			}
		});
		btnBuscar.setBounds(665, 11, 89, 23);
		panelBusquedaUsuarios.add(btnBuscar);
		
		
		
		//Oculto todas las pestañas antes de mostrar la ventana
		
	}
}
