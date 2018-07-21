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
import javax.swing.JOptionPane;
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
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaString;
	private JPanel panelListaUsuarios;
	private JTable tableUsuariosNuevos;
	private JRadioButton radio_UsuariosNuevos = new JRadioButton("Buscar usuarios nuevos");
	private JRadioButton radio_UsuariosYaRegistrados = new JRadioButton("Buscar usuarios ya registrados");
	private JPanel panelMenuAccionesUsuarios = new JPanel();
	private JButton btnEliminarUsuario = new JButton("Eliminar usuario");
	private JButton btnModificarUsuario = new JButton("Modificar usuario");
	private JButton btnVerInformacionUsuario = new JButton("Ver informacion de usuario");
	private JLabel lblUsuarioSeleccionado = new JLabel("Usuario seleccionado: Diego del Valle");
	private JButton btnContinuarRegistro = new JButton("Continuar registro");

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
		setBounds(100, 100, 800, 508);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUsuarios = new JMenu("Usuarios");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow_Controller controlador = MainWindow_Controller.getInstancia();
				controlador.usuariosAgregarUsuarioMenuItem();
			}
		});
		menuBar.add(menuUsuarios);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow_Controller controlador = MainWindow_Controller.getInstancia();
				controlador.usuariosAgregarUsuarioMenuItem();
			}
		});
		menuUsuarios.add(mntmNewMenuItem);
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmRealizarBusqueda = new JMenuItem("Realizar busqueda");
		mnListados.add(mntmRealizarBusqueda);
		
		JMenuItem mntmGenerarLista = new JMenuItem("Generar lista");
		mnListados.add(mntmGenerarLista);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNuevasPersonas = new JPanel();
		panelNuevasPersonas.setBounds(0, 0, 784, 448);
		contentPane.add(panelNuevasPersonas);
		panelNuevasPersonas.setLayout(null);
		
		JLabel lblListaDeNuevos = new JLabel("Busqueda de usuarios ");
		lblListaDeNuevos.setFont(new Font("Arial", Font.BOLD, 18));
		lblListaDeNuevos.setBounds(10, 11, 764, 23);
		panelNuevasPersonas.add(lblListaDeNuevos);
		
		JPanel panelBusquedaUsuarios = new JPanel();
		panelBusquedaUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusquedaUsuarios.setBounds(10, 45, 764, 79);
		panelNuevasPersonas.add(panelBusquedaUsuarios);
		panelBusquedaUsuarios.setLayout(null);
		
		JLabel lblBuscarUsuario = new JLabel("Buscar por: ");
		lblBuscarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarUsuario.setBounds(10, 50, 110, 18);
		panelBusquedaUsuarios.add(lblBuscarUsuario);
		
		txtBusquedaString = new JTextField();
		txtBusquedaString.setBounds(297, 51, 362, 21);
		panelBusquedaUsuarios.add(txtBusquedaString);
		txtBusquedaString.setColumns(10);
		
		JComboBox cmbCriterioBusqueda = new JComboBox();
		cmbCriterioBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Cedula Venezolana", "Nombre y Apellido"}));
		cmbCriterioBusqueda.setBounds(130, 51, 157, 20);
		panelBusquedaUsuarios.add(cmbCriterioBusqueda);
		
		panelListaUsuarios = new JPanel();
		panelListaUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelListaUsuarios.setBounds(10, 135, 764, 302);
		panelNuevasPersonas.add(panelListaUsuarios);
		panelListaUsuarios.setLayout(null);
		tableUsuariosNuevos = new JTable();
		
		JScrollPane scrollPaneListaUsuariosNuevos = new JScrollPane();
		scrollPaneListaUsuariosNuevos.setBounds(10, 11, 744, 193);
		panelListaUsuarios.add(scrollPaneListaUsuariosNuevos);
		
		
		tableUsuariosNuevos.setBorder(null);
		scrollPaneListaUsuariosNuevos.setViewportView(tableUsuariosNuevos);
		
		JButton btnBuscar = new JButton("Buscar");
		JSeparator separatorAccionesUsuarios = new JSeparator();
		
		btnBuscar.addActionListener(new ActionListener() {
			//Eventto del boton para buscar personas que son nuevas
			public void actionPerformed(ActionEvent arg0) {
				tableUsuariosNuevos.setModel(new DefaultTableModel());
				//Instancio el controlador
				MainWindow_Controller controller = MainWindow_Controller.getInstancia();
				//int que identifica que tipo de criterio selecciono
				int type = cmbCriterioBusqueda.getSelectedIndex();
				//Texto para la busqueda
				String value = txtBusquedaString.getText();
				//Llamo al metodo que se encarga de
				//controlar la funcionalidad del boton buscar
				//Luego debo recibir los datos y mostrarlos
				DefaultTableModel model = controller.btnBuscarFunction(type, value);
				if(model.getRowCount()!=0){
					tableUsuariosNuevos.setModel(model);//muestro los datos en la tabla
					
					panelListaUsuarios.setVisible(true);//muestro el panel con la lista
					
					
					if(radio_UsuariosNuevos.isSelected()){
						panelMenuAccionesUsuarios.setVisible(true);
						btnContinuarRegistro.setVisible(true);
						lblUsuarioSeleccionado.setText("Usuario seleccionado: Ninguno");
						lblUsuarioSeleccionado.setVisible(true);
						btnModificarUsuario.setVisible(false);
						btnEliminarUsuario.setVisible(false);
						btnVerInformacionUsuario.setVisible(false);
						separatorAccionesUsuarios.setVisible(false);
					}else{
						
						panelMenuAccionesUsuarios.setVisible(true);
						btnContinuarRegistro.setVisible(false);
						lblUsuarioSeleccionado.setText("Usuario seleccionado: Ninguno");
						lblUsuarioSeleccionado.setVisible(true);
						btnModificarUsuario.setVisible(true);
						btnEliminarUsuario.setVisible(true);
						btnVerInformacionUsuario.setVisible(true);
						separatorAccionesUsuarios.setVisible(true);
					}
					
				}else{
					panelListaUsuarios.setVisible(false);
					scrollPaneListaUsuariosNuevos.setBorder(null);
					radio_UsuariosNuevos.setSelected(true);
					lblUsuarioSeleccionado.setVisible(false);
					btnContinuarRegistro.setVisible(false);
					separatorAccionesUsuarios.setVisible(false);
					btnModificarUsuario.setVisible(false);
					btnEliminarUsuario.setVisible(false);
					btnVerInformacionUsuario.setVisible(false);
					panelMenuAccionesUsuarios.setVisible(false);
				}
				
				
				
				
				
				
				
			}
		});
		btnBuscar.setBounds(669, 50, 89, 23);
		panelBusquedaUsuarios.add(btnBuscar);
		
		JLabel lblSeleccionarTipoDe = new JLabel("Seleccionar tipo de busqueda");
		lblSeleccionarTipoDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccionarTipoDe.setBounds(10, 11, 221, 18);
		panelBusquedaUsuarios.add(lblSeleccionarTipoDe);
		
		
		
		radio_UsuariosYaRegistrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_UsuariosYaRegistrados.isSelected()){
					radio_UsuariosNuevos.setSelected(false);
				}else{
					radio_UsuariosNuevos.setSelected(true);
				}
			}
		});
		radio_UsuariosNuevos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radio_UsuariosNuevos.isSelected()){
					radio_UsuariosYaRegistrados.setSelected(false);
				}else{
					radio_UsuariosYaRegistrados.setSelected(true);
				}
			}
		});
		radio_UsuariosNuevos.setBounds(237, 11, 221, 23);
		panelBusquedaUsuarios.add(radio_UsuariosNuevos);
		
		
		radio_UsuariosYaRegistrados.setBounds(460, 11, 221, 23);
		panelBusquedaUsuarios.add(radio_UsuariosYaRegistrados);
		
		
		panelMenuAccionesUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenuAccionesUsuarios.setBounds(10, 215, 744, 76);
		panelListaUsuarios.add(panelMenuAccionesUsuarios);
		panelMenuAccionesUsuarios.setLayout(null);
		
		
		lblUsuarioSeleccionado.setBounds(10, 11, 526, 14);
		panelMenuAccionesUsuarios.add(lblUsuarioSeleccionado);
		
		
		btnContinuarRegistro.setBounds(549, 7, 185, 23);
		panelMenuAccionesUsuarios.add(btnContinuarRegistro);
		
		
		separatorAccionesUsuarios.setBounds(10, 36, 724, 2);
		panelMenuAccionesUsuarios.add(separatorAccionesUsuarios);
		
		
		btnVerInformacionUsuario.setBounds(524, 42, 210, 23);
		panelMenuAccionesUsuarios.add(btnVerInformacionUsuario);
		
		
		btnModificarUsuario.setBounds(10, 42, 185, 23);
		panelMenuAccionesUsuarios.add(btnModificarUsuario);
		
		
		btnEliminarUsuario.setBounds(205, 42, 126, 23);
		panelMenuAccionesUsuarios.add(btnEliminarUsuario);
		btnContinuarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idSelectedRow = tableUsuariosNuevos.getSelectedRow();
				if(idSelectedRow==-1){
					JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario");
				}else{
					int ciVenezolana = Integer.parseInt((String) tableUsuariosNuevos.getModel().getValueAt(idSelectedRow, 0));
					String primerNombre = (String) tableUsuariosNuevos.getModel().getValueAt(idSelectedRow, 1);
					String primerApellido =  (String) tableUsuariosNuevos.getModel().getValueAt(idSelectedRow, 2);
					String motivoContacto =  (String) tableUsuariosNuevos.getModel().getValueAt(idSelectedRow, 3);
					MainWindow_Controller controlador = MainWindow_Controller.getInstancia();
					controlador.btnContinuarRegistroFunction(ciVenezolana,primerNombre,primerApellido,motivoContacto);
				}
				
				
				
			}
		});
		panelListaUsuarios.setVisible(false);
		scrollPaneListaUsuariosNuevos.setBorder(null);
		radio_UsuariosNuevos.setSelected(true);
		lblUsuarioSeleccionado.setVisible(false);
		btnContinuarRegistro.setVisible(false);
		separatorAccionesUsuarios.setVisible(false);
		btnModificarUsuario.setVisible(false);
		btnEliminarUsuario.setVisible(false);
		btnVerInformacionUsuario.setVisible(false);
		panelMenuAccionesUsuarios.setVisible(false);
	}
}