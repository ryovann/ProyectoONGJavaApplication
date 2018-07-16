package grafica.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;

public class FormularioRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_numero_ci_uy;
	private JTextField textField_pasaporte;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioRegistro frame = new FormularioRegistro();
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
	public FormularioRegistro() {
		setTitle("Formulario de registro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 36, 774, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
		lblSegundoNombre.setBounds(10, 11, 105, 14);
		panel.add(lblSegundoNombre);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(10, 55, 111, 14);
		panel.add(lblSegundoApellido);
		
		textField = new JTextField();
		textField.setBounds(125, 8, 111, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 52, 109, 20);
		panel.add(textField_1);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(423, 11, 124, 14);
		panel.add(lblFechaDeNacimiento);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		comboBox_6.setBounds(285, 8, 128, 20);
		panel.add(comboBox_6);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(246, 11, 40, 14);
		panel.add(lblSexo);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento");
		lblPaisDeNacimiento.setBounds(246, 55, 115, 14);
		panel.add(lblPaisDeNacimiento);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(374, 52, 140, 20);
		panel.add(comboBox_7);
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento");
		lblCiudadDeNacimiento.setBounds(524, 55, 124, 14);
		panel.add(lblCiudadDeNacimiento);
		
		textField_2 = new JTextField();
		textField_2.setBounds(659, 52, 105, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(210, 103, 46, 14);
		panel.add(label);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(553, 8, 57, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(620, 8, 58, 20);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(688, 8, 76, 20);
		panel.add(comboBox_5);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDatosPersonales.setBounds(10, 11, 141, 14);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre");
		lblPrimerNombre.setBounds(348, 12, 93, 14);
		contentPane.add(lblPrimerNombre);
		
		JLabel lblPrimerApelldo = new JLabel("Primer apelldo");
		lblPrimerApelldo.setBounds(565, 12, 112, 14);
		contentPane.add(lblPrimerApelldo);
		
		JLabel lblCedulaVenezolana = new JLabel("Cedula venezolana");
		lblCedulaVenezolana.setBounds(161, 12, 126, 14);
		contentPane.add(lblCedulaVenezolana);
		
		JLabel lblDocumentacin = new JLabel("Documentaci\u00F3n");
		lblDocumentacin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDocumentacin.setBounds(10, 139, 141, 14);
		contentPane.add(lblDocumentacin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 164, 568, 144);
		contentPane.add(panel_1);
		
		JLabel lblCedulaUruguaya = new JLabel("Cedula uruguaya");
		lblCedulaUruguaya.setBounds(10, 22, 100, 14);
		panel_1.add(lblCedulaUruguaya);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(112, 11, 107, 37);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtn_ci_uy_si = new JRadioButton("Si");
		rdbtn_ci_uy_si.setBounds(6, 7, 44, 23);
		panel_2.add(rdbtn_ci_uy_si);
		
		JRadioButton rdbtnci_uy_no = new JRadioButton("No");
		rdbtnci_uy_no.setBounds(52, 7, 49, 23);
		panel_2.add(rdbtnci_uy_no);
		
		JLabel lblNumero_ci_uy = new JLabel("Numero");
		lblNumero_ci_uy.setBounds(243, 22, 57, 14);
		panel_1.add(lblNumero_ci_uy);
		
		textField_numero_ci_uy = new JTextField();
		textField_numero_ci_uy.setBounds(310, 19, 86, 20);
		panel_1.add(textField_numero_ci_uy);
		textField_numero_ci_uy.setColumns(10);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud");
		lblCarnetDeSalud.setBounds(10, 58, 92, 14);
		panel_1.add(lblCarnetDeSalud);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(112, 48, 107, 37);
		panel_1.add(panel_3);
		
		JRadioButton radioButton_carnet_salud_si = new JRadioButton("Si");
		radioButton_carnet_salud_si.setBounds(6, 7, 39, 23);
		panel_3.add(radioButton_carnet_salud_si);
		
		JRadioButton radioButton_carnet_salud_no = new JRadioButton("No");
		radioButton_carnet_salud_no.setBounds(47, 7, 54, 23);
		panel_3.add(radioButton_carnet_salud_no);
		
		JLabel lblVigenteHasta = new JLabel("Vigente hasta");
		lblVigenteHasta.setBounds(243, 58, 86, 14);
		panel_1.add(lblVigenteHasta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(339, 55, 57, 20);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(406, 55, 58, 20);
		panel_1.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(474, 55, 76, 20);
		panel_1.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1934", "1935", "1936", "1937", "1938", "1939", "1940"}));
		
		JLabel lblPasaporte = new JLabel("Pasaporte:");
		lblPasaporte.setBounds(10, 98, 76, 14);
		panel_1.add(lblPasaporte);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(112, 86, 107, 37);
		panel_1.add(panel_4);
		
		JRadioButton radioButton_pasaporteSi = new JRadioButton("Si");
		radioButton_pasaporteSi.setBounds(6, 7, 39, 23);
		panel_4.add(radioButton_pasaporteSi);
		
		JRadioButton radioButton_pasaporteNo = new JRadioButton("No");
		radioButton_pasaporteNo.setBounds(47, 7, 54, 23);
		panel_4.add(radioButton_pasaporteNo);
		
		JLabel lblNumero_pasaporte = new JLabel("Numero:");
		lblNumero_pasaporte.setBounds(243, 98, 57, 14);
		panel_1.add(lblNumero_pasaporte);
		
		textField_pasaporte = new JTextField();
		textField_pasaporte.setColumns(10);
		textField_pasaporte.setBounds(310, 95, 86, 20);
		panel_1.add(textField_pasaporte);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(588, 164, 196, 144);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 11, 58, 14);
		panel_5.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setBounds(78, 8, 108, 20);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(78, 36, 108, 20);
		panel_5.add(textField_4);
		
		JLabel lblTelAlternativo = new JLabel("Otro tel");
		lblTelAlternativo.setBounds(10, 39, 58, 14);
		panel_5.add(lblTelAlternativo);
		
		JLabel lblCorreoElectronico = new JLabel("Direccion de email\r\n");
		lblCorreoElectronico.setBounds(10, 88, 176, 14);
		panel_5.add(lblCorreoElectronico);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 113, 176, 20);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 176, 2);
		panel_5.add(separator);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContacto.setBounds(588, 139, 196, 14);
		contentPane.add(lblContacto);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(10, 344, 568, 187);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblUltimoNivelCursado = new JLabel("Ultimo nivel cursado");
		lblUltimoNivelCursado.setBounds(10, 14, 131, 14);
		panel_6.add(lblUltimoNivelCursado);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Terciario/Tecnica", "Grado universitario", "Postgrado universitario"}));
		comboBox_9.setBounds(151, 11, 167, 20);
		panel_6.add(comboBox_9);
		
		JRadioButton rdbtnCompleto = new JRadioButton("Completo");
		rdbtnCompleto.setBounds(324, 10, 109, 23);
		panel_6.add(rdbtnCompleto);
		
		JRadioButton rdbtnIncompleto = new JRadioButton("Incompleto");
		rdbtnIncompleto.setBounds(440, 10, 109, 23);
		panel_6.add(rdbtnIncompleto);
		
		JLabel lblTituloObtenido = new JLabel("Titulo obtenido");
		lblTituloObtenido.setBounds(10, 60, 97, 14);
		panel_6.add(lblTituloObtenido);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(117, 57, 201, 20);
		panel_6.add(comboBox_12);
		
		JLabel lblHomologado = new JLabel("Homologado");
		lblHomologado.setBounds(324, 60, 88, 14);
		panel_6.add(lblHomologado);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(422, 49, 107, 37);
		panel_6.add(panel_8);
		
		JRadioButton radioButton = new JRadioButton("Si");
		radioButton.setBounds(6, 7, 44, 23);
		panel_8.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("No");
		radioButton_1.setBounds(52, 7, 49, 23);
		panel_8.add(radioButton_1);
		
		JLabel lblEscolaridad = new JLabel("Escolaridad");
		lblEscolaridad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEscolaridad.setBounds(10, 319, 141, 14);
		contentPane.add(lblEscolaridad);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIdiomas.setBounds(588, 320, 141, 14);
		contentPane.add(lblIdiomas);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(588, 344, 196, 187);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(10, 11, 46, 14);
		panel_7.add(lblIdioma);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(66, 8, 120, 20);
		panel_7.add(comboBox_10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(10, 36, 46, 14);
		panel_7.add(lblNivel);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(76, 33, 110, 20);
		panel_7.add(comboBox_11);
		
		JList list = new JList();
		list.setBounds(10, 98, 176, 76);
		panel_7.add(list);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(107, 64, 79, 23);
		panel_7.add(btnAgregar);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(8, 64, 79, 23);
		panel_7.add(btnQuitar);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(528, 590, 67, 14);
		contentPane.add(lblEstadoCivil);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(605, 587, 124, 20);
		contentPane.add(comboBox_8);
	}
}
