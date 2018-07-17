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

import grafica.controller.FormularioRegistro_Controller;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtSegundoNombre;
	private JTextField txtSegundoApellido;
	private JTextField txtCiudadNacimiento;
	private JTextField txtNumeroCIUY;
	private JTextField txt_pasaporte;
	private JTextField txtTelefono;
	private JTextField txtOtroTelefono;
	private JTextField txtCorreoElectronico;
	private JTextField txtDetalleViveConOtro;
	private JTextField txtCantHijos;
	private JTextField txtCantidadHijosExtranjero;

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
		setBounds(100, 100, 800, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDatosPersonales.setBounds(10, 36, 774, 92);
		contentPane.add(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
		lblSegundoNombre.setBounds(10, 11, 111, 14);
		panelDatosPersonales.add(lblSegundoNombre);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(10, 55, 111, 14);
		panelDatosPersonales.add(lblSegundoApellido);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setBounds(125, 8, 111, 20);
		panelDatosPersonales.add(txtSegundoNombre);
		txtSegundoNombre.setColumns(10);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBounds(127, 52, 109, 20);
		panelDatosPersonales.add(txtSegundoApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(423, 11, 124, 14);
		panelDatosPersonales.add(lblFechaDeNacimiento);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		cmbSexo.setBounds(285, 8, 128, 20);
		panelDatosPersonales.add(cmbSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(246, 11, 40, 14);
		panelDatosPersonales.add(lblSexo);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento");
		lblPaisDeNacimiento.setBounds(246, 55, 115, 14);
		panelDatosPersonales.add(lblPaisDeNacimiento);
		
		JComboBox cmbPaisNacimiento = new JComboBox();
		cmbPaisNacimiento.setBounds(374, 52, 140, 20);
		panelDatosPersonales.add(cmbPaisNacimiento);
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento");
		lblCiudadDeNacimiento.setBounds(524, 55, 124, 14);
		panelDatosPersonales.add(lblCiudadDeNacimiento);
		
		txtCiudadNacimiento = new JTextField();
		txtCiudadNacimiento.setBounds(659, 52, 105, 20);
		panelDatosPersonales.add(txtCiudadNacimiento);
		txtCiudadNacimiento.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(210, 103, 46, 14);
		panelDatosPersonales.add(label);
		
		JComboBox cmbFechaNac_Dia = new JComboBox();
		cmbFechaNac_Dia.setBounds(553, 8, 57, 20);
		panelDatosPersonales.add(cmbFechaNac_Dia);
		cmbFechaNac_Dia.addItem("DD");
		int dia = 1;
		while(dia<32){
			 cmbFechaNac_Dia.addItem(dia);
			 dia++;
		}
		
		JComboBox cmbFechaNacMes = new JComboBox();
		cmbFechaNacMes.setBounds(620, 8, 58, 20);
		panelDatosPersonales.add(cmbFechaNacMes);
		cmbFechaNacMes.addItem("MM");
		int mes =1;
		while(mes<13){
			cmbFechaNacMes.addItem(mes);
			mes++;
		}
		
		JComboBox cmbFechaNacAnio = new JComboBox();
		cmbFechaNacAnio.setBounds(688, 8, 76, 20);
		panelDatosPersonales.add(cmbFechaNacAnio);
		cmbFechaNacAnio.addItem("AAAA");
		int anio=1910;
		while(anio<=2018){
			cmbFechaNacAnio.addItem(anio);
			anio++;
		}
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDatosPersonales.setBounds(10, 11, 141, 14);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre");
		lblPrimerNombre.setBounds(365, 12, 93, 14);
		contentPane.add(lblPrimerNombre);
		
		JLabel lblPrimerApelldo = new JLabel("Primer apelldo");
		lblPrimerApelldo.setBounds(585, 12, 93, 14);
		contentPane.add(lblPrimerApelldo);
		
		JLabel lblCedulaVenezolana = new JLabel("Cedula venezolana");
		lblCedulaVenezolana.setBounds(161, 12, 126, 14);
		contentPane.add(lblCedulaVenezolana);
		
		JLabel lblDocumentacin = new JLabel("Documentaci\u00F3n");
		lblDocumentacin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDocumentacin.setBounds(10, 139, 141, 14);
		contentPane.add(lblDocumentacin);
		
		JPanel panelDocumentacion = new JPanel();
		panelDocumentacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDocumentacion.setLayout(null);
		panelDocumentacion.setBounds(10, 164, 568, 144);
		contentPane.add(panelDocumentacion);
		
		JLabel lblCedulaUruguaya = new JLabel("Cedula uruguaya");
		lblCedulaUruguaya.setBounds(10, 22, 100, 14);
		panelDocumentacion.add(lblCedulaUruguaya);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(112, 11, 107, 37);
		panelDocumentacion.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton radio_ci_uy_si = new JRadioButton("Si");
		radio_ci_uy_si.setBounds(6, 7, 44, 23);
		panel_2.add(radio_ci_uy_si);
		
		JRadioButton radio_ci_uy_no = new JRadioButton("No");
		radio_ci_uy_no.setBounds(52, 7, 49, 23);
		panel_2.add(radio_ci_uy_no);
		
		JLabel lblNumero_ci_uy = new JLabel("Numero");
		lblNumero_ci_uy.setBounds(243, 22, 57, 14);
		panelDocumentacion.add(lblNumero_ci_uy);
		
		txtNumeroCIUY = new JTextField();
		txtNumeroCIUY.setBounds(310, 19, 86, 20);
		panelDocumentacion.add(txtNumeroCIUY);
		txtNumeroCIUY.setColumns(10);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud");
		lblCarnetDeSalud.setBounds(10, 58, 92, 14);
		panelDocumentacion.add(lblCarnetDeSalud);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(112, 48, 107, 37);
		panelDocumentacion.add(panel_3);
		
		JRadioButton radio_carnet_salud_si = new JRadioButton("Si");
		radio_carnet_salud_si.setBounds(6, 7, 39, 23);
		panel_3.add(radio_carnet_salud_si);
		
		JRadioButton radio_carnet_salud_no = new JRadioButton("No");
		radio_carnet_salud_no.setBounds(47, 7, 54, 23);
		panel_3.add(radio_carnet_salud_no);
		
		JLabel lblVigenteHasta = new JLabel("Vigente hasta");
		lblVigenteHasta.setBounds(243, 58, 86, 14);
		panelDocumentacion.add(lblVigenteHasta);
		
		JComboBox cmbCarnetSaludVigenteDia = new JComboBox();
		cmbCarnetSaludVigenteDia.setBounds(339, 55, 57, 20);
		panelDocumentacion.add(cmbCarnetSaludVigenteDia);
		cmbCarnetSaludVigenteDia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox cmbCarnetSaludVigenteMes = new JComboBox();
		cmbCarnetSaludVigenteMes.setBounds(406, 55, 58, 20);
		panelDocumentacion.add(cmbCarnetSaludVigenteMes);
		cmbCarnetSaludVigenteMes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox cmbCarnetSaludVigenteAnio = new JComboBox();
		cmbCarnetSaludVigenteAnio.setBounds(474, 55, 76, 20);
		panelDocumentacion.add(cmbCarnetSaludVigenteAnio);
		cmbCarnetSaludVigenteAnio.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1934", "1935", "1936", "1937", "1938", "1939", "1940"}));
		
		JLabel lblPasaporte = new JLabel("Pasaporte:");
		lblPasaporte.setBounds(10, 98, 76, 14);
		panelDocumentacion.add(lblPasaporte);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(112, 86, 107, 37);
		panelDocumentacion.add(panel_4);
		
		JRadioButton radio_pasaporteSi = new JRadioButton("Si");
		radio_pasaporteSi.setBounds(6, 7, 39, 23);
		panel_4.add(radio_pasaporteSi);
		
		JRadioButton radio_pasaporteNo = new JRadioButton("No");
		radio_pasaporteNo.setBounds(47, 7, 54, 23);
		panel_4.add(radio_pasaporteNo);
		
		JLabel lblNumero_pasaporte = new JLabel("Numero:");
		lblNumero_pasaporte.setBounds(243, 98, 57, 14);
		panelDocumentacion.add(lblNumero_pasaporte);
		
		txt_pasaporte = new JTextField();
		txt_pasaporte.setColumns(10);
		txt_pasaporte.setBounds(310, 95, 86, 20);
		panelDocumentacion.add(txt_pasaporte);
		
		JPanel panelContacto = new JPanel();
		panelContacto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContacto.setBounds(588, 164, 196, 144);
		contentPane.add(panelContacto);
		panelContacto.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 11, 58, 14);
		panelContacto.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(78, 8, 108, 20);
		panelContacto.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtOtroTelefono = new JTextField();
		txtOtroTelefono.setColumns(10);
		txtOtroTelefono.setBounds(78, 36, 108, 20);
		panelContacto.add(txtOtroTelefono);
		
		JLabel lblTelAlternativo = new JLabel("Otro tel");
		lblTelAlternativo.setBounds(10, 39, 58, 14);
		panelContacto.add(lblTelAlternativo);
		
		JLabel lblCorreoElectronico = new JLabel("Direccion de email\r\n");
		lblCorreoElectronico.setBounds(10, 88, 176, 14);
		panelContacto.add(lblCorreoElectronico);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBounds(10, 113, 176, 20);
		panelContacto.add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 176, 2);
		panelContacto.add(separator);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContacto.setBounds(588, 139, 196, 14);
		contentPane.add(lblContacto);
		
		JPanel panelEscolaridad = new JPanel();
		panelEscolaridad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEscolaridad.setBounds(10, 344, 568, 100);
		contentPane.add(panelEscolaridad);
		panelEscolaridad.setLayout(null);
		
		JLabel lblUltimoNivelCursado = new JLabel("Ultimo nivel cursado");
		lblUltimoNivelCursado.setBounds(10, 14, 131, 14);
		panelEscolaridad.add(lblUltimoNivelCursado);
		
		JComboBox cmbNivelCursado = new JComboBox();
		cmbNivelCursado.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Terciario/Tecnica", "Grado universitario", "Postgrado universitario", "No especifica"}));
		cmbNivelCursado.setBounds(151, 11, 167, 20);
		panelEscolaridad.add(cmbNivelCursado);
		
		JRadioButton radio_nivelCursadoCompleto = new JRadioButton("Completo");
		radio_nivelCursadoCompleto.setBounds(324, 10, 109, 23);
		panelEscolaridad.add(radio_nivelCursadoCompleto);
		
		JRadioButton radio_NivelCursadoIncompleto = new JRadioButton("Incompleto");
		radio_NivelCursadoIncompleto.setBounds(440, 10, 109, 23);
		panelEscolaridad.add(radio_NivelCursadoIncompleto);
		
		JLabel lblTituloObtenido = new JLabel("Titulo obtenido");
		lblTituloObtenido.setBounds(10, 60, 97, 14);
		panelEscolaridad.add(lblTituloObtenido);
		
		JComboBox cmbTituloObtenido = new JComboBox();
		cmbTituloObtenido.setBounds(117, 57, 201, 20);
		panelEscolaridad.add(cmbTituloObtenido);
		
		JLabel lblHomologado = new JLabel("Homologado");
		lblHomologado.setBounds(345, 60, 71, 14);
		panelEscolaridad.add(lblHomologado);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(422, 49, 107, 37);
		panelEscolaridad.add(panel_8);
		
		JRadioButton radio_HomologadoSi = new JRadioButton("Si");
		radio_HomologadoSi.setBounds(6, 7, 44, 23);
		panel_8.add(radio_HomologadoSi);
		
		JRadioButton radio_HomologadoNo = new JRadioButton("No");
		radio_HomologadoNo.setBounds(52, 7, 49, 23);
		panel_8.add(radio_HomologadoNo);
		
		JLabel lblEscolaridad = new JLabel("Escolaridad");
		lblEscolaridad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEscolaridad.setBounds(10, 319, 141, 14);
		contentPane.add(lblEscolaridad);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIdiomas.setBounds(588, 320, 141, 14);
		contentPane.add(lblIdiomas);
		
		JPanel panelIdioma = new JPanel();
		panelIdioma.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIdioma.setBounds(588, 344, 196, 187);
		contentPane.add(panelIdioma);
		panelIdioma.setLayout(null);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(10, 11, 46, 14);
		panelIdioma.add(lblIdioma);
		
		JComboBox cmbIdioma = new JComboBox();
		cmbIdioma.setBounds(66, 8, 120, 20);
		panelIdioma.add(cmbIdioma);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(10, 36, 46, 14);
		panelIdioma.add(lblNivel);
		
		JComboBox cmbNivelIdioma = new JComboBox();
		cmbNivelIdioma.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Intermedio", "Avanzado"}));
		cmbNivelIdioma.setBounds(76, 33, 110, 20);
		panelIdioma.add(cmbNivelIdioma);
		
		JList listIdiomasAgregados = new JList();
		listIdiomasAgregados.setBounds(10, 98, 176, 76);
		panelIdioma.add(listIdiomasAgregados);
		
		JButton btnAgregarIdioma = new JButton("Agregar");
		btnAgregarIdioma.setBounds(97, 64, 89, 23);
		panelIdioma.add(btnAgregarIdioma);
		
		JButton btnQuitarIdioma = new JButton("Quitar");
		btnQuitarIdioma.setBounds(8, 64, 79, 23);
		panelIdioma.add(btnQuitarIdioma);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 480, 568, 119);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(208, 47, 67, 14);
		panel_9.add(lblEstadoCivil);
		
		JComboBox cmbEstadoCivil = new JComboBox();
		cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Casado/a", "Divorciado", "Viudo"}));
		cmbEstadoCivil.setBounds(285, 44, 124, 20);
		panel_9.add(cmbEstadoCivil);
		
		JLabel lblVinoCon = new JLabel("Vino con");
		lblVinoCon.setBounds(10, 47, 67, 14);
		panel_9.add(lblVinoCon);
		
		JComboBox cmbVinoCon = new JComboBox();
		cmbVinoCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Acompa\u00F1ado"}));
		cmbVinoCon.setBounds(87, 44, 111, 20);
		panel_9.add(cmbVinoCon);
		
		JLabel lblViveCon = new JLabel("Vive con");
		lblViveCon.setBounds(10, 8, 67, 14);
		panel_9.add(lblViveCon);
		
		JComboBox cmbViveCon = new JComboBox();
		cmbViveCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Familia", "Amigos", "Otro"}));
		cmbViveCon.setBounds(87, 8, 101, 20);
		panel_9.add(cmbViveCon);
		
		txtDetalleViveConOtro = new JTextField();
		txtDetalleViveConOtro.setBounds(411, 8, 147, 20);
		panel_9.add(txtDetalleViveConOtro);
		txtDetalleViveConOtro.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(195, 11, 46, 14);
		panel_9.add(lblDetalle);
		
		JComboBox cmbDetalleViveConFamilia = new JComboBox();
		cmbDetalleViveConFamilia.setModel(new DefaultComboBoxModel(new String[] {"Padre i/o madre", "Con hijos", "En pareja con hijos", "En pareja", "Otra familia"}));
		cmbDetalleViveConFamilia.setBounds(251, 8, 147, 20);
		panel_9.add(cmbDetalleViveConFamilia);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setBounds(10, 86, 101, 14);
		panel_9.add(lblCantidadDeHijos);
		
		txtCantHijos = new JTextField();
		txtCantHijos.setBounds(121, 83, 46, 20);
		panel_9.add(txtCantHijos);
		txtCantHijos.setColumns(10);
		
		JLabel lblCantidadDeHijos_1 = new JLabel("Cantidad de hijos en el extranjero");
		lblCantidadDeHijos_1.setBounds(177, 86, 204, 14);
		panel_9.add(lblCantidadDeHijos_1);
		
		txtCantidadHijosExtranjero = new JTextField();
		txtCantidadHijosExtranjero.setColumns(10);
		txtCantidadHijosExtranjero.setBounds(391, 83, 46, 20);
		panel_9.add(txtCantidadHijosExtranjero);
		
		JLabel lblSituacionFamiliar = new JLabel("Situacion familiar");
		lblSituacionFamiliar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSituacionFamiliar.setBounds(10, 455, 141, 14);
		contentPane.add(lblSituacionFamiliar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(588, 542, 196, 23);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmarRegistro = new JButton("CONFIRMAR REGISTRO");
		btnConfirmarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioRegistro_Controller controlador = FormularioRegistro_Controller.getIntancia();
				String primer_nombre =lblPrimerNombre.getText();
				String segundo_nombre = txtSegundoNombre.getText();
				String primer_apellido = "";
				String segundo_apellido = txtSegundoApellido.getText();
				String sexo = cmbSexo.getSelectedItem().toString();
				String dia_nac = cmbFechaNac_Dia.getSelectedItem().toString();
				String mes_nac = cmbFechaNacMes.getSelectedItem().toString();
				String anio_nac =cmbFechaNacAnio.getSelectedItem().toString();
				String pais_nac = cmbPaisNacimiento.getSelectedItem().toString();
				String estado_civil = cmbEstadoCivil.getSelectedItem().toString();
				
			}
		});
		btnConfirmarRegistro.setBounds(588, 576, 196, 23);
		contentPane.add(btnConfirmarRegistro);
		
		JLabel lblPrimerApellidoCampo = new JLabel("primer_apellido");
		lblPrimerApellidoCampo.setBounds(677, 12, 107, 14);
		contentPane.add(lblPrimerApellidoCampo);
		
		JLabel lblPrimerNombreCampo = new JLabel("primer_nombre");
		lblPrimerNombreCampo.setBounds(468, 12, 107, 14);
		contentPane.add(lblPrimerNombreCampo);
		
		JLabel lblCIVenezolana = new JLabel("ci_venezolana");
		lblCIVenezolana.setBounds(261, 12, 93, 14);
		contentPane.add(lblCIVenezolana);
		
		
		
	}
}
