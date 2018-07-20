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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FormularioRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtSegundoNombre;
	private JTextField txtSegundoApellido;
	private JTextField txtCiudadNacimiento;
	private JTextField txtNumeroCIUY;
	private JTextField txtPasaporte;
	private JTextField txtTelefono;
	private JTextField txtOtroTelefono;
	private JTextField txtCorreoElectronico;
	private JTextField txtDetalleViveConOtro;
	private JTextField txtCantHijos;
	private JTextField txtCantidadHijosExtranjero;
	private JTextField txtPrimerNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtCIVenezolana;
	private JTextArea txtMotivoContacto = new JTextArea();
	private int tipoDeRegistro = 0; //Variable para saber el tipo de formulario
	private JTextField text_direccion;

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
	
	
	public void RellenarFormularioFromContinuarRegistro(int ciVenezolana,String primerNombre,String primerApellido,String motivoContacto){
		setTitle("Formulario de Registro: "+primerNombre+" "+primerApellido+" - "+ciVenezolana);
		txtCIVenezolana.setText(""+ciVenezolana);
		txtCIVenezolana.setEditable(false);
		txtPrimerNombre.setText(primerNombre);
		txtPrimerNombre.setEditable(false);
		txtPrimerApellido.setText(primerApellido);
		txtPrimerApellido.setEditable(false);
		txtMotivoContacto.setText(motivoContacto);
	}
	
	
	
	public FormularioRegistro() {
		setTitle("Formulario de Registro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDatosPersonales.setBounds(10, 28, 792, 190);
		contentPane.add(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
		lblSegundoNombre.setBounds(4, 69, 111, 14);
		panelDatosPersonales.add(lblSegundoNombre);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(221, 69, 105, 14);
		panelDatosPersonales.add(lblSegundoApellido);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setBounds(125, 66, 86, 20);
		panelDatosPersonales.add(txtSegundoNombre);
		txtSegundoNombre.setColumns(10);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBounds(336, 66, 91, 20);
		panelDatosPersonales.add(txtSegundoApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(415, 11, 124, 14);
		panelDatosPersonales.add(lblFechaDeNacimiento);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		cmbSexo.setBounds(277, 124, 128, 20);
		panelDatosPersonales.add(cmbSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(221, 127, 40, 14);
		panelDatosPersonales.add(lblSexo);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento");
		lblPaisDeNacimiento.setBounds(437, 69, 115, 14);
		panelDatosPersonales.add(lblPaisDeNacimiento);
		
		JComboBox cmbPaisNacimiento = new JComboBox();
		cmbPaisNacimiento.setBounds(571, 66, 140, 20);
		panelDatosPersonales.add(cmbPaisNacimiento);
		cmbPaisNacimiento.addItem("Uruguay");
		cmbPaisNacimiento.addItem("Venezuela");
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento");
		lblCiudadDeNacimiento.setBounds(415, 127, 124, 14);
		panelDatosPersonales.add(lblCiudadDeNacimiento);
		
		txtCiudadNacimiento = new JTextField();
		txtCiudadNacimiento.setBounds(549, 124, 105, 20);
		panelDatosPersonales.add(txtCiudadNacimiento);
		txtCiudadNacimiento.setColumns(10);
		
		JComboBox cmbFechaNac_Dia = new JComboBox();
		cmbFechaNac_Dia.setBounds(571, 8, 57, 20);
		panelDatosPersonales.add(cmbFechaNac_Dia);
		cmbFechaNac_Dia .setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		
		JComboBox cmbFechaNac_Mes = new JComboBox();
		cmbFechaNac_Mes.setBounds(638, 8, 58, 20);
		panelDatosPersonales.add(cmbFechaNac_Mes);
		cmbFechaNac_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox cmbFechaNac_Anio = new JComboBox();
		cmbFechaNac_Anio.setBounds(706, 8, 76, 20);
		panelDatosPersonales.add(cmbFechaNac_Anio);
		cmbFechaNac_Anio.addItem("AAAA");
		int anio=1910;
		while(anio<=2018){
			cmbFechaNac_Anio.addItem(anio);
			anio++;
		}
		
		JLabel lblPrimerNombree = new JLabel("Primer nombre");
		lblPrimerNombree.setBounds(4, 11, 107, 14);
		panelDatosPersonales.add(lblPrimerNombree);
		
		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setBounds(125, 8, 86, 20);
		panelDatosPersonales.add(txtPrimerNombre);
		txtPrimerNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(221, 11, 106, 14);
		panelDatosPersonales.add(lblPrimerApellido);
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setBounds(319, 8, 86, 20);
		panelDatosPersonales.add(txtPrimerApellido);
		txtPrimerApellido.setColumns(10);
		
		JLabel lblCedulaVenezolana = new JLabel("Cedula venezolana");
		lblCedulaVenezolana.setBounds(4, 127, 111, 14);
		panelDatosPersonales.add(lblCedulaVenezolana);
		
		txtCIVenezolana = new JTextField();
		txtCIVenezolana.setBounds(125, 124, 86, 20);
		panelDatosPersonales.add(txtCIVenezolana);
		txtCIVenezolana.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Direcci\u00F3n");
		lblNewLabel.setBounds(4, 157, 107, 20);
		panelDatosPersonales.add(lblNewLabel);
		
		text_direccion = new JTextField();
		text_direccion.setBounds(125, 157, 529, 26);
		panelDatosPersonales.add(text_direccion);
		text_direccion.setColumns(10);
		
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDatosPersonales.setBounds(10, 11, 127, 14);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblDocumentacin = new JLabel("Documentaci\u00F3n");
		lblDocumentacin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDocumentacin.setBounds(10, 234, 141, 14);
		contentPane.add(lblDocumentacin);
		
		JPanel panelDocumentacion = new JPanel();
		panelDocumentacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDocumentacion.setLayout(null);
		panelDocumentacion.setBounds(10, 249, 568, 144);
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
		lblNumero_ci_uy.setBounds(229, 22, 57, 14);
		panelDocumentacion.add(lblNumero_ci_uy);
		
		txtNumeroCIUY = new JTextField();
		txtNumeroCIUY.setBounds(296, 19, 86, 20);
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
		lblVigenteHasta.setBounds(229, 58, 86, 14);
		panelDocumentacion.add(lblVigenteHasta);
		
		JComboBox cmbCarnetSaludVigente_Dia = new JComboBox();
		cmbCarnetSaludVigente_Dia.setBounds(320, 55, 57, 20);
		panelDocumentacion.add(cmbCarnetSaludVigente_Dia);
		cmbCarnetSaludVigente_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox cmbCarnetSaludVigente_Mes = new JComboBox();
		cmbCarnetSaludVigente_Mes.setBounds(387, 55, 58, 20);
		panelDocumentacion.add(cmbCarnetSaludVigente_Mes);
		cmbCarnetSaludVigente_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox cmbCarnetSaludVigente_Anio = new JComboBox();
		cmbCarnetSaludVigente_Anio.setBounds(455, 55, 76, 20);
		panelDocumentacion.add(cmbCarnetSaludVigente_Anio);
		cmbCarnetSaludVigente_Anio.setModel(new DefaultComboBoxModel(new String[] {"AAAA"}));
		anio=1910;
		while(anio<=2018){
			cmbCarnetSaludVigente_Anio.addItem(anio);
			anio++;
		}
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
		lblNumero_pasaporte.setBounds(229, 98, 57, 14);
		panelDocumentacion.add(lblNumero_pasaporte);
		
		txtPasaporte = new JTextField();
		txtPasaporte.setColumns(10);
		txtPasaporte.setBounds(296, 95, 86, 20);
		panelDocumentacion.add(txtPasaporte);
		
		JPanel panelContacto = new JPanel();
		panelContacto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContacto.setBounds(588, 249, 214, 280);
		contentPane.add(panelContacto);
		panelContacto.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 11, 58, 14);
		panelContacto.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(78, 8, 126, 20);
		panelContacto.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtOtroTelefono = new JTextField();
		txtOtroTelefono.setColumns(10);
		txtOtroTelefono.setBounds(78, 39, 126, 20);
		panelContacto.add(txtOtroTelefono);
		
		JLabel lblTelAlternativo = new JLabel("Otro tel");
		lblTelAlternativo.setBounds(10, 42, 58, 14);
		panelContacto.add(lblTelAlternativo);
		
		JLabel lblCorreoElectronico = new JLabel("Direccion de email\r\n");
		lblCorreoElectronico.setBounds(10, 99, 176, 14);
		panelContacto.add(lblCorreoElectronico);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBounds(10, 124, 194, 20);
		panelContacto.add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 194, 2);
		panelContacto.add(separator);
		
		JLabel lblMotivoDeContacto = new JLabel("Motivo de contacto");
		lblMotivoDeContacto.setBounds(10, 155, 176, 14);
		panelContacto.add(lblMotivoDeContacto);
		
		
		txtMotivoContacto.setBounds(10, 180, 194, 89);
		panelContacto.add(txtMotivoContacto);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContacto.setBounds(588, 234, 196, 14);
		contentPane.add(lblContacto);
		
		JPanel panelEscolaridad = new JPanel();
		panelEscolaridad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEscolaridad.setBounds(10, 429, 568, 100);
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
		lblHomologado.setBounds(324, 60, 71, 14);
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
		lblEscolaridad.setBounds(10, 411, 141, 14);
		contentPane.add(lblEscolaridad);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIdiomas.setBounds(588, 538, 141, 14);
		contentPane.add(lblIdiomas);
		
		JPanel panelIdioma = new JPanel();
		panelIdioma.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIdioma.setBounds(588, 562, 214, 182);
		contentPane.add(panelIdioma);
		panelIdioma.setLayout(null);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(10, 11, 46, 14);
		panelIdioma.add(lblIdioma);
		
		JComboBox cmbIdioma = new JComboBox();
		cmbIdioma.setBounds(84, 8, 120, 20);
		panelIdioma.add(cmbIdioma);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(10, 36, 46, 14);
		panelIdioma.add(lblNivel);
		
		JComboBox cmbNivelIdioma = new JComboBox();
		cmbNivelIdioma.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Intermedio", "Avanzado"}));
		cmbNivelIdioma.setBounds(84, 33, 120, 20);
		panelIdioma.add(cmbNivelIdioma);
		
		JList listIdiomasAgregados = new JList();
		listIdiomasAgregados.setBounds(10, 98, 194, 73);
		panelIdioma.add(listIdiomasAgregados);
		
		JButton btnAgregarIdioma = new JButton("Agregar");
		btnAgregarIdioma.setBounds(115, 64, 89, 23);
		panelIdioma.add(btnAgregarIdioma);
		
		JButton btnQuitarIdioma = new JButton("Quitar");
		btnQuitarIdioma.setBounds(8, 64, 89, 23);
		panelIdioma.add(btnQuitarIdioma);
		
		JPanel panelSituacionFamiliar = new JPanel();
		panelSituacionFamiliar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSituacionFamiliar.setBounds(10, 562, 568, 119);
		contentPane.add(panelSituacionFamiliar);
		panelSituacionFamiliar.setLayout(null);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(208, 47, 67, 14);
		panelSituacionFamiliar.add(lblEstadoCivil);
		
		JComboBox cmbEstadoCivil = new JComboBox();
		cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Casado/a", "Divorciado", "Viudo"}));
		cmbEstadoCivil.setBounds(285, 44, 124, 20);
		panelSituacionFamiliar.add(cmbEstadoCivil);
		
		JLabel lblVinoCon = new JLabel("Vino con");
		lblVinoCon.setBounds(10, 47, 67, 14);
		panelSituacionFamiliar.add(lblVinoCon);
		
		JComboBox cmbVinoCon = new JComboBox();
		cmbVinoCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Acompa\u00F1ado"}));
		cmbVinoCon.setBounds(87, 44, 111, 20);
		panelSituacionFamiliar.add(cmbVinoCon);
		
		JLabel lblViveCon = new JLabel("Vive con");
		lblViveCon.setBounds(10, 8, 67, 14);
		panelSituacionFamiliar.add(lblViveCon);
		
		JComboBox cmbViveCon = new JComboBox();
		cmbViveCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Familia", "Amigos", "Otro"}));
		cmbViveCon.setBounds(87, 5, 101, 20);
		panelSituacionFamiliar.add(cmbViveCon);
		
		txtDetalleViveConOtro = new JTextField();
		txtDetalleViveConOtro.setBounds(408, 5, 147, 20);
		panelSituacionFamiliar.add(txtDetalleViveConOtro);
		txtDetalleViveConOtro.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(195, 8, 46, 14);
		panelSituacionFamiliar.add(lblDetalle);
		
		JComboBox cmbDetalleViveConFamilia = new JComboBox();
		cmbDetalleViveConFamilia.setModel(new DefaultComboBoxModel(new String[] {"Padre i/o madre", "Con hijos", "En pareja con hijos", "En pareja", "Otra familia"}));
		cmbDetalleViveConFamilia.setBounds(251, 5, 147, 20);
		panelSituacionFamiliar.add(cmbDetalleViveConFamilia);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setBounds(10, 86, 101, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos);
		
		txtCantHijos = new JTextField();
		txtCantHijos.setBounds(121, 83, 46, 20);
		panelSituacionFamiliar.add(txtCantHijos);
		txtCantHijos.setColumns(10);
		
		JLabel lblCantidadDeHijos_1 = new JLabel("Cantidad de hijos en el extranjero");
		lblCantidadDeHijos_1.setBounds(177, 86, 204, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos_1);
		
		txtCantidadHijosExtranjero = new JTextField();
		txtCantidadHijosExtranjero.setColumns(10);
		txtCantidadHijosExtranjero.setBounds(391, 83, 46, 20);
		panelSituacionFamiliar.add(txtCantidadHijosExtranjero);
		
		JLabel lblSituacionFamiliar = new JLabel("Situacion familiar");
		lblSituacionFamiliar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSituacionFamiliar.setBounds(10, 538, 141, 14);
		contentPane.add(lblSituacionFamiliar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(424, 760, 154, 23);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 696, 568, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(10, 11, 96, 29);
		panel.add(lblOcupacion);
		
		JComboBox cmbOcupacion = new JComboBox();
		cmbOcupacion.setBounds(116, 15, 136, 20);
		panel.add(cmbOcupacion);
		cmbOcupacion.addItem("Trabajo fijo");
		cmbOcupacion.addItem("Trabajo zafral o temporal");
		cmbOcupacion.addItem("Desocupado");
		cmbOcupacion.addItem("Jubilado/Pensionista");
		cmbOcupacion.addItem("Estudiante");
		
		
		JLabel lblResideDesde = new JLabel("Reside desde");
		lblResideDesde.setBounds(262, 18, 96, 14);
		panel.add(lblResideDesde);
		
		JComboBox cmbResideDesde_Dia = new JComboBox();
		cmbResideDesde_Dia.setBounds(347, 15, 57, 20);
		panel.add(cmbResideDesde_Dia);
		cmbResideDesde_Dia.addItem("DD");
		 cmbResideDesde_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox cmbResideDesde_Mes = new JComboBox();
		cmbResideDesde_Mes.setBounds(414, 15, 58, 20);
		panel.add(cmbResideDesde_Mes);
		cmbResideDesde_Mes.addItem("MM");
		cmbResideDesde_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox cmbResideDesde_Anio = new JComboBox();
		cmbResideDesde_Anio.setBounds(482, 15, 76, 20);
		panel.add(cmbResideDesde_Anio);
		cmbResideDesde_Anio.addItem("AAAA");
		anio=1910;
		while(anio<2019){
			cmbResideDesde_Anio.addItem(anio);
			anio++;
		}
		JButton btnConfirmarRegistro = new JButton("CONFIRMAR REGISTRO");
		btnConfirmarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioRegistro_Controller controlador = FormularioRegistro_Controller.getIntancia();
				//DATOS QUE NECESITA TABLA PERSONA 
				String ci_venezolana =txtCIVenezolana.getText();
				String primer_nombre = txtPrimerNombre.getText();
				String segundo_nombre = txtSegundoNombre.getText();
				String primer_apellido = txtPrimerApellido.getText();
				String segundo_apellido = txtSegundoApellido.getText();
				String sexo = cmbSexo.getSelectedItem().toString();
				String dia_nac = cmbFechaNac_Dia.getSelectedItem().toString();
				String mes_nac = cmbFechaNac_Mes.getSelectedItem().toString();
				String anio_nac =cmbFechaNac_Anio.getSelectedItem().toString();
				String pais_nac = cmbPaisNacimiento.getSelectedItem().toString();
				String ciudad_nac = txtCiudadNacimiento.getText();
				String estado_civil = cmbEstadoCivil.getSelectedItem().toString();
				String ocupacion= cmbOcupacion.getSelectedItem().toString();
				String direccion = text_direccion.getText();
				String dia_reside =cmbResideDesde_Dia.getSelectedItem().toString();
				String mes_reside=cmbResideDesde_Mes.getSelectedItem().toString();
				String anio_reside =cmbResideDesde_Anio.getSelectedItem().toString();
				String email =txtCorreoElectronico.getText();
				String motivo_contacto = txtMotivoContacto.getText();
				controlador.UpdatePersona(primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, dia_nac, mes_nac, anio_nac, pais_nac, ciudad_nac, estado_civil, ocupacion, direccion, dia_reside, mes_reside, anio_reside, email, motivo_contacto, ci_venezolana);
				//FALTAN LOS IDIOMAS
				System.out.println("se hizo el update");
				
				//telefonos 
				String tel1 = txtTelefono.getText();
				String tel2=txtOtroTelefono.getText();
				controlador.InsertarTelefono(ci_venezolana,tel1);
				if(tel2.equals("")){
					System.out.println("tel2 vacio");
				}else {controlador.InsertarTelefono(ci_venezolana,tel2);
				}
				
				//empiezo con la documentacion 
				String ci_uruguaya =txtNumeroCIUY.getText();
				String pasaporte=txtPasaporte.getText();
				String dia_carnet_salud=cmbCarnetSaludVigente_Dia.getSelectedItem().toString();
				String mes_carnet_salud=cmbCarnetSaludVigente_Mes.getSelectedItem().toString();
				String anio_carnet_salud=cmbCarnetSaludVigente_Anio.getSelectedItem().toString();
				controlador.UpdateDocumentos(ci_uruguaya, pasaporte, dia_carnet_salud, mes_carnet_salud, anio_carnet_salud, ci_venezolana);
				
				
				//EMPIEZO CON LA ESCOLARIDAD
				String nivel_escolar = cmbNivelCursado.getSelectedItem().toString();
				int completado=0;
				if (radio_nivelCursadoCompleto.isSelected()){
					completado=1;
				}
				int homologacion =0;
				if (radio_HomologadoSi.isSelected()){
					homologacion =1;
				}
				controlador.InsertarFormacion_Academica(nivel_escolar,completado,ci_venezolana);
				
			}
		});
		btnConfirmarRegistro.setBounds(588, 760, 214, 23);
		contentPane.add(btnConfirmarRegistro);
		
		
		
	}
	public FormularioRegistro(int type){
		this();
		this.tipoDeRegistro = type;
		if(type==0){
			setTitle("Formulario de Registro: Usuario nuevo");
		}
	}
}
