		package grafica.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
import javax.swing.JScrollPane;

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
	private JTextField txtDetalleViveConOtro = new JTextField();
	private JTextField txtCantHijos;
	private JTextField txtCantidadHijosExtranjero;
	private JTextField txtPrimerNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtCIVenezolana;
	private JTextArea txtMotivoContacto = new JTextArea();
	private JList listIdiomasAgregados = new JList();
	private int tipoDeRegistro = 0; //Variable para saber el tipo de formulario
	private JTextField text_direccion;
	private JComboBox cmbPaisNacimiento = new JComboBox();
	private JComboBox cmbTituloObtenido = new JComboBox();
	private JComboBox cmbIdioma = new JComboBox();
	private JComboBox cmbViveCon = new JComboBox();
	private JComboBox cmbDetalleViveConFamilia = new JComboBox();
	private JComboBox cmbNivelCursado = new JComboBox();
	private JRadioButton radio_carnet_salud_no = new JRadioButton("No");
	private JRadioButton radio_carnet_salud_si = new JRadioButton("Si");
	private JRadioButton radio_ci_uy_si = new JRadioButton("Si");
	private JRadioButton radio_ci_uy_no = new JRadioButton("No");
	private JRadioButton radio_pasaporteNo = new JRadioButton("No");
	private JRadioButton radio_pasaporteSi = new JRadioButton("Si");
	private JRadioButton radio_HomologadoNo = new JRadioButton("No");
	private JRadioButton radio_HomologadoSi = new JRadioButton("Si");
	private JRadioButton radio_nivelCursadoCompleto = new JRadioButton("Completo");
	private JRadioButton radio_NivelCursadoIncompleto = new JRadioButton("Incompleto");
	private JLabel lblHomologado = new JLabel("Homologado");
	private JLabel lblTituloObtenido = new JLabel("Titulo obtenido");
	

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
	public void RellenarFormularioConBD(){
		FormularioRegistro_Controller controlador = FormularioRegistro_Controller.getIntancia();
		cmbPaisNacimiento.setModel(controlador.ObtenerPaises());
		cmbIdioma.setModel(controlador.ObtenerIdiomas());
		cmbTituloObtenido.setModel(controlador.ObtenerProfesiones());
		cmbTituloObtenido.setVisible(false);
		radio_carnet_salud_no.setSelected(true);
		radio_ci_uy_no.setSelected(true);
		radio_pasaporteNo.setSelected(true);
		txtDetalleViveConOtro.setVisible(false);
		cmbDetalleViveConFamilia.setVisible(false);
		
	}
	
	
	
	public FormularioRegistro() {
		setTitle("Formulario de Registro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setVisible(false);
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDatosPersonales.setBounds(10, 36, 792, 161);
		contentPane.add(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
		lblSegundoNombre.setBounds(10, 50, 105, 14);
		panelDatosPersonales.add(lblSegundoNombre);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(221, 50, 105, 14);
		panelDatosPersonales.add(lblSegundoApellido);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setBounds(125, 47, 86, 20);
		panelDatosPersonales.add(txtSegundoNombre);
		txtSegundoNombre.setColumns(10);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBounds(329, 47, 91, 20);
		panelDatosPersonales.add(txtSegundoApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(415, 11, 124, 14);
		panelDatosPersonales.add(lblFechaDeNacimiento);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		cmbSexo.setBounds(277, 86, 128, 20);
		panelDatosPersonales.add(cmbSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(226, 89, 40, 14);
		panelDatosPersonales.add(lblSexo);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento");
		lblPaisDeNacimiento.setBounds(430, 50, 115, 14);
		panelDatosPersonales.add(lblPaisDeNacimiento);
		
		
		cmbPaisNacimiento.setBounds(555, 47, 140, 20);
		panelDatosPersonales.add(cmbPaisNacimiento);
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento");
		lblCiudadDeNacimiento.setBounds(415, 89, 124, 14);
		panelDatosPersonales.add(lblCiudadDeNacimiento);
		
		txtCiudadNacimiento = new JTextField();
		txtCiudadNacimiento.setBounds(555, 86, 105, 20);
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
		lblPrimerNombree.setBounds(10, 11, 107, 14);
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
		lblCedulaVenezolana.setBounds(10, 89, 111, 14);
		panelDatosPersonales.add(lblCedulaVenezolana);
		
		txtCIVenezolana = new JTextField();
		txtCIVenezolana.setBounds(125, 86, 86, 20);
		panelDatosPersonales.add(txtCIVenezolana);
		txtCIVenezolana.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Direcci\u00F3n");
		lblNewLabel.setBounds(10, 128, 107, 20);
		panelDatosPersonales.add(lblNewLabel);
		
		text_direccion = new JTextField();
		text_direccion.setBounds(125, 128, 535, 20);
		panelDatosPersonales.add(text_direccion);
		text_direccion.setColumns(10);
		
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDatosPersonales.setBounds(10, 11, 127, 14);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblDocumentacin = new JLabel("Documentaci\u00F3n");
		lblDocumentacin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDocumentacin.setBounds(10, 208, 141, 14);
		contentPane.add(lblDocumentacin);
		
		JPanel panelDocumentacion = new JPanel();
		panelDocumentacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDocumentacion.setLayout(null);
		panelDocumentacion.setBounds(10, 233, 568, 119);
		contentPane.add(panelDocumentacion);
		
		JLabel lblCedulaUruguaya = new JLabel("Cedula uruguaya");
		lblCedulaUruguaya.setBounds(10, 11, 100, 14);
		panelDocumentacion.add(lblCedulaUruguaya);
		
		JLabel lblNumero_ci_uy = new JLabel("Numero");
		lblNumero_ci_uy.setBounds(229, 11, 57, 14);
		lblNumero_ci_uy.setVisible(false);
		panelDocumentacion.add(lblNumero_ci_uy);
		
		txtNumeroCIUY = new JTextField();
		txtNumeroCIUY.setBounds(291, 8, 242, 20);
		panelDocumentacion.add(txtNumeroCIUY);
		txtNumeroCIUY.setVisible(false);
		txtNumeroCIUY.setColumns(10);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud");
		lblCarnetDeSalud.setBounds(10, 50, 100, 14);
		panelDocumentacion.add(lblCarnetDeSalud);
		
		JLabel lblVigenteHasta = new JLabel("Vigente hasta");
		lblVigenteHasta.setBounds(229, 50, 86, 14);
		lblVigenteHasta.setVisible(false);
		panelDocumentacion.add(lblVigenteHasta);
		
		JComboBox cmbCarnetSaludVigente_Dia = new JComboBox();
		cmbCarnetSaludVigente_Dia.setBounds(320, 47, 57, 20);
		panelDocumentacion.add(cmbCarnetSaludVigente_Dia);
		cmbCarnetSaludVigente_Dia.setVisible(false);
		cmbCarnetSaludVigente_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox cmbCarnetSaludVigente_Mes = new JComboBox();
		cmbCarnetSaludVigente_Mes.setBounds(387, 47, 58, 20);
		cmbCarnetSaludVigente_Mes.setVisible(false);
		panelDocumentacion.add(cmbCarnetSaludVigente_Mes);
		cmbCarnetSaludVigente_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox cmbCarnetSaludVigente_Anio = new JComboBox();
		cmbCarnetSaludVigente_Anio.setBounds(457, 47, 76, 20);
		cmbCarnetSaludVigente_Anio.setVisible(false);
		panelDocumentacion.add(cmbCarnetSaludVigente_Anio);
		cmbCarnetSaludVigente_Anio.setModel(new DefaultComboBoxModel(new String[] {"AAAA"}));
		anio=2018;
		while(anio<=2070){
			cmbCarnetSaludVigente_Anio.addItem(anio);
			anio++;
		}
		JLabel lblPasaporte = new JLabel("Pasaporte:");
		lblPasaporte.setBounds(10, 89, 76, 14);
		panelDocumentacion.add(lblPasaporte);
		
		JLabel lblNumero_pasaporte = new JLabel("Numero:");
		lblNumero_pasaporte.setBounds(229, 89, 57, 14);
		lblNumero_pasaporte.setVisible(false);
		panelDocumentacion.add(lblNumero_pasaporte);
		
		txtPasaporte = new JTextField();
		txtPasaporte.setColumns(10);
		txtPasaporte.setBounds(291, 86, 242, 20);
		txtPasaporte.setVisible(false);
		panelDocumentacion.add(txtPasaporte);
		
		radio_ci_uy_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radio_ci_uy_no.isSelected()){
				radio_ci_uy_si.setSelected(false);
				txtNumeroCIUY.setVisible(false);
				lblNumero_ci_uy.setVisible(false);
			}else{
				radio_ci_uy_si.setSelected(true);
				txtNumeroCIUY.setVisible(true);
				lblNumero_ci_uy.setVisible(true);
			}
			}
		});
		radio_ci_uy_no.setBounds(162, 7, 49, 23);
		panelDocumentacion.add(radio_ci_uy_no);
		
		
		radio_ci_uy_si.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radio_ci_uy_si.isSelected()){
					radio_ci_uy_no.setSelected(false);
					txtNumeroCIUY.setVisible(true);
					lblNumero_ci_uy.setVisible(true);
				}else{
					radio_ci_uy_no.setSelected(true);
					txtNumeroCIUY.setVisible(false);
					lblNumero_ci_uy.setVisible(false);
				}
			}
		});
		radio_ci_uy_si.setBounds(116, 7, 44, 23);
		panelDocumentacion.add(radio_ci_uy_si);
		
		
		radio_carnet_salud_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_carnet_salud_no.isSelected()){
					radio_carnet_salud_si.setSelected(false);
					lblVigenteHasta.setVisible(false);
					cmbCarnetSaludVigente_Dia.setVisible(false);
					cmbCarnetSaludVigente_Mes.setVisible(false);
					cmbCarnetSaludVigente_Anio.setVisible(false);
					
				}else{
					radio_carnet_salud_si.setSelected(true);
					lblVigenteHasta.setVisible(true);
					cmbCarnetSaludVigente_Dia.setVisible(true);
					cmbCarnetSaludVigente_Mes.setVisible(true);
					cmbCarnetSaludVigente_Anio.setVisible(true);
					
					
					
					
				}
			}
		});
		radio_carnet_salud_no.setBounds(162, 46, 54, 23);
		panelDocumentacion.add(radio_carnet_salud_no);
		
		
		radio_carnet_salud_si.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_carnet_salud_si.isSelected()){
					radio_carnet_salud_no.setSelected(false);
					lblVigenteHasta.setVisible(true);
					cmbCarnetSaludVigente_Dia.setVisible(true);
					cmbCarnetSaludVigente_Mes.setVisible(true);
					cmbCarnetSaludVigente_Anio.setVisible(true);
					
				}else{
					radio_carnet_salud_no.setSelected(true);
					lblVigenteHasta.setVisible(false);
					cmbCarnetSaludVigente_Dia.setVisible(false);
					cmbCarnetSaludVigente_Mes.setVisible(false);
					cmbCarnetSaludVigente_Anio.setVisible(false);
				}
			}
		});
		radio_carnet_salud_si.setBounds(116, 46, 39, 23);
		panelDocumentacion.add(radio_carnet_salud_si);
		radio_pasaporteNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_pasaporteNo.isSelected()){
					radio_pasaporteSi.setSelected(false);
					lblNumero_pasaporte.setVisible(false);
					txtPasaporte.setVisible(false);
				}else{
					radio_pasaporteSi.setSelected(true);
					lblNumero_pasaporte.setVisible(true);
					txtPasaporte.setVisible(true);
				}
			}
		});
		
		
		radio_pasaporteNo.setBounds(162, 85, 54, 23);
		panelDocumentacion.add(radio_pasaporteNo);
		radio_pasaporteSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_pasaporteSi.isSelected()){
					radio_pasaporteNo.setSelected(false);
					lblNumero_pasaporte.setVisible(true);
					txtPasaporte.setVisible(true);
				}else{
					radio_pasaporteNo.setSelected(true);
					lblNumero_pasaporte.setVisible(false);
					txtPasaporte.setVisible(false);
				}
			}
		});
		
		
		radio_pasaporteSi.setBounds(116, 85, 39, 23);
		panelDocumentacion.add(radio_pasaporteSi);
		
		JPanel panelContacto = new JPanel();
		panelContacto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContacto.setBounds(588, 233, 214, 234);
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
		lblCorreoElectronico.setBounds(10, 70, 194, 14);
		panelContacto.add(lblCorreoElectronico);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBounds(10, 95, 194, 20);
		panelContacto.add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		JLabel lblMotivoDeContacto = new JLabel("Motivo de contacto");
		lblMotivoDeContacto.setBounds(10, 131, 194, 14);
		panelContacto.add(lblMotivoDeContacto);
		
		JPanel panelTxtMotivoContacto = new JPanel();
		panelTxtMotivoContacto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTxtMotivoContacto.setBounds(10, 156, 194, 67);
		panelContacto.add(panelTxtMotivoContacto);
		panelTxtMotivoContacto.setLayout(new BorderLayout(0, 0));
		panelTxtMotivoContacto.add(txtMotivoContacto, BorderLayout.CENTER);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContacto.setBounds(588, 208, 196, 14);
		contentPane.add(lblContacto);
		
		JPanel panelEscolaridad = new JPanel();
		panelEscolaridad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEscolaridad.setBounds(10, 388, 568, 79);
		contentPane.add(panelEscolaridad);
		panelEscolaridad.setLayout(null);
		
		JLabel lblUltimoNivelCursado = new JLabel("Ultimo nivel cursado");
		lblUltimoNivelCursado.setBounds(10, 11, 131, 14);
		panelEscolaridad.add(lblUltimoNivelCursado);
		
		
		
		
		
		cmbNivelCursado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idNivelSelected = cmbNivelCursado.getSelectedIndex();
				if(idNivelSelected==5){
					radio_HomologadoNo.setVisible(false);
					radio_HomologadoSi.setVisible(false);
					radio_nivelCursadoCompleto.setVisible(false);
					radio_NivelCursadoIncompleto.setVisible(false);
					cmbTituloObtenido.setVisible(false);
					lblHomologado.setVisible(false);
					lblTituloObtenido.setVisible(false);
				}else{
					
					radio_nivelCursadoCompleto.setVisible(true);
					radio_NivelCursadoIncompleto.setVisible(true);
					verificarEscoladidad();
					
				}
			}
		});
		cmbNivelCursado.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Terciario/Tecnica", "Grado universitario", "Postgrado universitario", "No especifica"}));
		cmbNivelCursado.setBounds(151, 8, 167, 20);
		panelEscolaridad.add(cmbNivelCursado);
		radio_nivelCursadoCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radio_nivelCursadoCompleto.isSelected()){
					radio_NivelCursadoIncompleto.setSelected(false);
					
					verificarEscoladidad();
				}else{
					radio_NivelCursadoIncompleto.setSelected(true);
					verificarEscoladidad();
				}
			}
		});
		
		
		radio_nivelCursadoCompleto.setBounds(329, 7, 109, 23);
		panelEscolaridad.add(radio_nivelCursadoCompleto);
		radio_NivelCursadoIncompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radio_NivelCursadoIncompleto.isSelected()){
					
					radio_nivelCursadoCompleto.setSelected(false);
					verificarEscoladidad();
				}else{
					radio_nivelCursadoCompleto.setSelected(true);
					verificarEscoladidad();
				}
			}
		});
		
		
		radio_NivelCursadoIncompleto.setBounds(440, 7, 109, 23);
		panelEscolaridad.add(radio_NivelCursadoIncompleto);
		
		
		lblTituloObtenido.setBounds(10, 49, 97, 14);
		lblTituloObtenido.setVisible(false);
		panelEscolaridad.add(lblTituloObtenido);
		
		//Profesion
		cmbTituloObtenido.setBounds(117, 46, 201, 20);
		panelEscolaridad.add(cmbTituloObtenido);
		
		
		lblHomologado.setBounds(330, 49, 71, 14);
		lblHomologado.setVisible(false);
		panelEscolaridad.add(lblHomologado);
		radio_HomologadoNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_HomologadoNo.isSelected()){
					radio_HomologadoSi.setSelected(false);
				}else{
					radio_HomologadoSi.setSelected(true);
				}
			}
		});
		
		
		radio_HomologadoNo.setBounds(453, 45, 49, 23);
		radio_HomologadoNo.setVisible(false);
		panelEscolaridad.add(radio_HomologadoNo);
		radio_HomologadoSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radio_HomologadoSi.isSelected()){
				radio_HomologadoNo.setSelected(false);
			}else{
				radio_HomologadoNo.setSelected(true);
			}
			}
		});
		
		
		radio_HomologadoSi.setBounds(407, 45, 44, 23);
		radio_HomologadoSi.setVisible(false);
		panelEscolaridad.add(radio_HomologadoSi);
		
		JLabel lblEscolaridad = new JLabel("Escolaridad");
		lblEscolaridad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEscolaridad.setBounds(10, 363, 141, 14);
		contentPane.add(lblEscolaridad);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIdiomas.setBounds(588, 478, 141, 14);
		contentPane.add(lblIdiomas);
		
		JPanel panelIdioma = new JPanel();
		panelIdioma.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIdioma.setBounds(588, 503, 214, 181);
		contentPane.add(panelIdioma);
		panelIdioma.setLayout(null);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(10, 11, 46, 14);
		panelIdioma.add(lblIdioma);
		
		
		cmbIdioma.setBounds(84, 8, 120, 20);
		panelIdioma.add(cmbIdioma);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(10, 36, 46, 14);
		panelIdioma.add(lblNivel);
		
		JComboBox cmbNivelIdioma = new JComboBox();
		cmbNivelIdioma.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Intermedio", "Avanzado"}));
		cmbNivelIdioma.setBounds(84, 33, 120, 20);
		panelIdioma.add(cmbNivelIdioma);
		
		JButton btnAgregarIdioma = new JButton("Agregar");
		btnAgregarIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedIdioma = cmbIdioma.getSelectedItem().toString();//Idioma seleccionado
				String selectedNivel = cmbNivelIdioma.getSelectedItem().toString(); //Nivel Seleccionado
				boolean isInList = false; //Variable para verificar si el idioma no esta en la listta
				for(int i = 0; i<listIdiomasAgregados.getModel().getSize();i++){//For para recorrer la lista
					if(listIdiomasAgregados.getModel().getElementAt(i).toString().contains((selectedIdioma))){
						//Si la lista contiene un elemento con el idioma seleccionado se vuelve true 
						isInList = true;
					}
				}
				if(!isInList){//Si isInList es false(No esta en la lista
					DefaultListModel oldModel = new DefaultListModel();//objeto temporal que contiene los elementos de la lista
					if(listIdiomasAgregados.getModel().getSize()!=0){//Si la lista tiene al menos un idioma agregado
						for(int i = 0; i<listIdiomasAgregados.getModel().getSize();i++){//Recorro la lista y agrego los elementos a oldModel
							oldModel.addElement(listIdiomasAgregados.getModel().getElementAt(i).toString());
						}
						oldModel.addElement(selectedIdioma+" - "+selectedNivel);//Agrego el nuevo idioma al modelo
						listIdiomasAgregados.setModel(oldModel);//Muestro en la lista los idiomas actualizados
					}else{//Si no hay un elemento en la lista lo agrego y muestro la nueva lista
						oldModel.addElement(selectedIdioma+" - "+selectedNivel);
						listIdiomasAgregados.setModel(oldModel);
					}
						
					

				
				
					
					
				}
			}
		});
		btnAgregarIdioma.setBounds(115, 64, 89, 23);
		panelIdioma.add(btnAgregarIdioma);
		
		JButton btnQuitarIdioma = new JButton("Quitar");
		btnQuitarIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel oldModel = new DefaultListModel();
				int selectedIdioma = listIdiomasAgregados.getSelectedIndex();
				if(selectedIdioma!=-1){
					if(listIdiomasAgregados.getModel().getSize()!=0){
						for(int i = 0; i<listIdiomasAgregados.getModel().getSize();i++){
							oldModel.addElement(listIdiomasAgregados.getModel().getElementAt(i));
						}
						oldModel.removeElementAt(selectedIdioma);
						listIdiomasAgregados.setModel(oldModel);
						
					}
				}
				
				
				
				
			}
		});
		btnQuitarIdioma.setBounds(8, 64, 89, 23);
		panelIdioma.add(btnQuitarIdioma);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 98, 194, 72);
		panelIdioma.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(listIdiomasAgregados);
		
		JPanel panelSituacionFamiliar = new JPanel();
		panelSituacionFamiliar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSituacionFamiliar.setBounds(10, 503, 568, 119);
		contentPane.add(panelSituacionFamiliar);
		panelSituacionFamiliar.setLayout(null);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(208, 53, 67, 14);
		panelSituacionFamiliar.add(lblEstadoCivil);
		
		JComboBox cmbEstadoCivil = new JComboBox();
		cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Casado/a", "Divorciado", "Viudo"}));
		cmbEstadoCivil.setBounds(285, 50, 124, 20);
		panelSituacionFamiliar.add(cmbEstadoCivil);
		
		JLabel lblVinoCon = new JLabel("Vino con");
		lblVinoCon.setBounds(10, 53, 67, 14);
		panelSituacionFamiliar.add(lblVinoCon);
		
		JComboBox cmbVinoCon = new JComboBox();
		cmbVinoCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Acompa\u00F1ado"}));
		cmbVinoCon.setBounds(87, 50, 111, 20);
		panelSituacionFamiliar.add(cmbVinoCon);
		
		JLabel lblViveCon = new JLabel("Vive con");
		
		lblViveCon.setBounds(10, 14, 67, 14);
		panelSituacionFamiliar.add(lblViveCon);
		cmbViveCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idViveConSelectedIndex = cmbViveCon.getSelectedIndex();
				switch (idViveConSelectedIndex) {
				case 0:
					cmbDetalleViveConFamilia.setVisible(false);
					txtDetalleViveConOtro.setVisible(false);
					lblDetalle.setVisible(false);
					break;
				case 1:
					cmbDetalleViveConFamilia.setVisible(true);
					txtDetalleViveConOtro.setVisible(false);
					lblDetalle.setVisible(true);
					break;
				case 2:
					cmbDetalleViveConFamilia.setVisible(false);
					txtDetalleViveConOtro.setVisible(false);
					lblDetalle.setVisible(false);
					break;
				case 3:
					cmbDetalleViveConFamilia.setVisible(true);
					txtDetalleViveConOtro.setVisible(true);
					lblDetalle.setVisible(true);
					break;
				default:
					break;
				}
			}
		});
		
		
		cmbViveCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Familia", "Amigos", "Otro"}));
		cmbViveCon.setBounds(87, 11, 101, 20);
		panelSituacionFamiliar.add(cmbViveCon);
		
		
		txtDetalleViveConOtro.setBounds(251, 11, 304, 20);
		panelSituacionFamiliar.add(txtDetalleViveConOtro);
		txtDetalleViveConOtro.setColumns(10);
		
		
		lblDetalle.setBounds(195, 14, 46, 14);
		panelSituacionFamiliar.add(lblDetalle);
		
		
		cmbDetalleViveConFamilia.setModel(new DefaultComboBoxModel(new String[] {"Padre i/o madre", "Con hijos", "En pareja con hijos", "En pareja", "Otra familia"}));
		cmbDetalleViveConFamilia.setBounds(251, 11, 147, 20);
		panelSituacionFamiliar.add(cmbDetalleViveConFamilia);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setBounds(10, 92, 101, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos);
		
		txtCantHijos = new JTextField();
		txtCantHijos.setBounds(121, 89, 46, 20);
		panelSituacionFamiliar.add(txtCantHijos);
		txtCantHijos.setColumns(10);
		
		JLabel lblCantidadDeHijos_1 = new JLabel("Cantidad de hijos en el extranjero");
		lblCantidadDeHijos_1.setBounds(177, 92, 204, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos_1);
		
		txtCantidadHijosExtranjero = new JTextField();
		txtCantidadHijosExtranjero.setColumns(10);
		txtCantidadHijosExtranjero.setBounds(391, 89, 46, 20);
		panelSituacionFamiliar.add(txtCantidadHijosExtranjero);
		
		JLabel lblSituacionFamiliar = new JLabel("Situacion familiar");
		lblSituacionFamiliar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSituacionFamiliar.setBounds(10, 478, 141, 14);
		contentPane.add(lblSituacionFamiliar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(424, 695, 154, 23);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 633, 568, 51);
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
				//FALTAN LOS IDIOMAS
				//telefonos 
				String tel1 = txtTelefono.getText();
				String tel2=txtOtroTelefono.getText();
				//empiezo con la documentacion 
				String ci_uruguaya ="0";
				if (radio_ci_uy_si.isSelected()){
					 ci_uruguaya =txtNumeroCIUY.getText();
				}
				String pasaporte= null;
				if(radio_pasaporteSi.isSelected()){
					pasaporte=txtPasaporte.getText();
				}
				String dia_carnet_salud=null;
				String mes_carnet_salud=null;
				String anio_carnet_salud=null;
				if(radio_carnet_salud_si.isSelected()){
					 dia_carnet_salud=cmbCarnetSaludVigente_Dia.getSelectedItem().toString();
					 mes_carnet_salud=cmbCarnetSaludVigente_Mes.getSelectedItem().toString();
					 anio_carnet_salud=cmbCarnetSaludVigente_Anio.getSelectedItem().toString();
				}
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
				int id_titulo = cmbTituloObtenido.getSelectedIndex()+1;//el indice+1 equivale a l clave en la base de datos
				//ya que el combobox esta cargada desde la misma 
				
				//EMPIEZO CON SITUACION FAMILIAR
				String vive_con=cmbViveCon.getSelectedItem().toString();
				String detalle=null;
				if (cmbViveCon.getSelectedIndex()==1){ //vive con familia
					detalle = cmbDetalleViveConFamilia.getSelectedItem().toString();
				}else if (cmbViveCon.getSelectedIndex()==3) { //otro
					detalle = txtDetalleViveConOtro.getText();
				}
				int vino_con=cmbVinoCon.getSelectedIndex();//si es 0 vino solo, si es 1 vino acompañado
				//FALTA PONER TRY CATCH DE CUANDO CANT_HIJOS O HIJOS_EXTERIOR NO SON UN INT
				int cant_hijos = Integer.parseInt(txtCantHijos.getText());
				int hijos_exterior=Integer.parseInt(txtCantidadHijosExtranjero.getText());
				
				//ejecuto todas las consultas 
				
				if(hijos_exterior>cant_hijos){//no dijo toda la cantidad de hijos
					JOptionPane.showMessageDialog(null, "La cantida de hijos en el exterior es mayor a la cantidad de hijos en total, eso no es posible");
				}else {
					controlador.UpdatePersona(primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, dia_nac, mes_nac, anio_nac, pais_nac, ciudad_nac, estado_civil, ocupacion, direccion, dia_reside, mes_reside, anio_reside, email, motivo_contacto, ci_venezolana);
					System.out.println("se hizo el update");
					
					if(tel1.equals("") || tel1==null){
						System.out.println("tel1 vacio");
					}else{
						controlador.InsertarTelefono(ci_venezolana,tel1);
						System.out.println("se inserto tel1");
					}
					if(tel2.equals("") || tel2==null){
						System.out.println("tel2 vacio");
						
					}else {
						controlador.InsertarTelefono(ci_venezolana,tel2);
						System.out.println("se inserto tel 2");
					}
					
					controlador.UpdateDocumentos(ci_uruguaya, pasaporte, dia_carnet_salud, mes_carnet_salud, anio_carnet_salud, ci_venezolana);
					System.out.println("se actualizaron los documentos");
					
					controlador.InsertarFormacion_Academica(nivel_escolar,completado,ci_venezolana);
					System.out.println("se inserto la formacion academica");
					controlador.InsertarTiene_profesion(id_titulo,homologacion,ci_venezolana);
					System.out.println("se inserto la profesion");
					
					controlador.Insertar_familia_persona(vive_con,detalle,vino_con,cant_hijos,hijos_exterior,ci_venezolana);
					System.out.println("se inserto la situacion familiar");
				}	
			}
			
		});
		btnConfirmarRegistro.setBounds(588, 695, 214, 23);
		contentPane.add(btnConfirmarRegistro);
		RellenarFormularioConBD();
		
		
	}
	public FormularioRegistro(int type){
		this();
		this.tipoDeRegistro = type;
		if(type==0){
			setTitle("Formulario de Registro: Usuario nuevo");
		}
			
	}
	public void verificarEscoladidad(){
		int idNivelSelected = cmbNivelCursado.getSelectedIndex();
		if(idNivelSelected>=2 && radio_nivelCursadoCompleto.isSelected()){
			radio_HomologadoNo.setVisible(true);
			radio_HomologadoSi.setVisible(true);
			lblHomologado.setVisible(true);
			cmbTituloObtenido.setVisible(true);
			lblTituloObtenido.setVisible(true);
		}else{
			radio_HomologadoNo.setVisible(false);
			radio_HomologadoSi.setVisible(false);
			cmbTituloObtenido.setVisible(false);
			lblHomologado.setVisible(false);
			lblTituloObtenido.setVisible(false);
		}
	}
}
