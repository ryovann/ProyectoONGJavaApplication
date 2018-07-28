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
import grafica.controller.VerInformacion_Controller;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;

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
	private JComboBox cmbFechaNac_Dia = new JComboBox();
	private JComboBox cmbFechaNac_Mes = new JComboBox();
	private JComboBox cmbFechaNac_Anio = new JComboBox();
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
	private int anio;
	private JComboBox cmbSexo = new JComboBox();
	private JComboBox cmbCarnetSaludVigente_Anio = new JComboBox();
	private JComboBox cmbOcupacion = new JComboBox();
	private JComboBox cmbResideDesde_Dia = new JComboBox();
	private JComboBox cmbResideDesde_Mes = new JComboBox();
	private JComboBox cmbResideDesde_Anio = new JComboBox();
	JComboBox cmbCarnetSaludVigente_Mes = new JComboBox();
	JComboBox cmbCarnetSaludVigente_Dia = new JComboBox();
	JLabel lblVigenteHasta = new JLabel("Vigente hasta");
	JLabel lblNumero_ci_uy = new JLabel("Numero");
	JLabel lblNumero_pasaporte = new JLabel("Numero:");
	JComboBox cmbEstadoCivil = new JComboBox();
	JComboBox cmbVinoCon = new JComboBox();
	JButton btnConfirmarRegistro = new JButton("CONFIRMAR REGISTRO");

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormularioRegistro frame = new FormularioRegistro();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
	public void RellenarFormularioFromModificarUsuario(int ciVenezolana){
		txtCIVenezolana.setText(String.valueOf(ciVenezolana));
		txtCIVenezolana.setEnabled(false);
		btnConfirmarRegistro.setText("CONFIRMAR MODIFICACION");
		RellenarFormularioConBD();
		VerInformacion_Controller controlador = VerInformacion_Controller.getIntancia();
		//obtengo los datos de la tabla persona
		HashMap<String,String> datos_persona = controlador.Datos_Persona(ciVenezolana+"");
		///////////////////////////////////////////////////////////////////////////////
		//Muestro datos de persona relleno los campos que poseen datos guardados en datos_persona
		txtPrimerNombre.setText(datos_persona.get("primer_nombre"));
		txtSegundoNombre.setText(datos_persona.get("segundo_nombre"));
		txtPrimerApellido.setText(datos_persona.get("primer_apellido"));
		txtSegundoApellido.setText(datos_persona.get("segundo_apellido"));
		String[] fecha = datos_persona.get("fecha_nac").split("/");
		
		cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Casado/a", "Divorciado", "Viudo", "Concubinato"}));
		cmbEstadoCivil.setSelectedItem(datos_persona.get("estado_civil"));
		
		cmbFechaNac_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cmbFechaNac_Dia .setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		cmbFechaNac_Dia.setSelectedItem(fecha[0]);
		cmbFechaNac_Mes.setSelectedItem(fecha[1]);
		anio=1910;
		cmbFechaNac_Anio.addItem("AAAA");
		while(anio<2019){
			cmbFechaNac_Anio.addItem(anio);
			anio++;
		}
		
		cmbFechaNac_Anio.setSelectedItem(Integer.parseInt(fecha[2]));
		cmbPaisNacimiento.setSelectedItem(datos_persona.get("pais_nac"));
		txtCiudadNacimiento.setText(datos_persona.get("ciudad_nac"));
		text_direccion.setText(datos_persona.get("domicilio"));
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		cmbSexo.setSelectedItem(datos_persona.get("sexo"));
		txtCorreoElectronico.setText(datos_persona.get("email"));
		cmbOcupacion.addItem("Trabajo fijo");
		cmbOcupacion.addItem("Trabajo zafral o temporal");
		cmbOcupacion.addItem("Desocupado");
		cmbOcupacion.addItem("Jubilado/Pensionista");
		cmbOcupacion.addItem("Estudiante");
		cmbOcupacion.setSelectedItem(datos_persona.get("ocupacion"));
		cmbResideDesde_Anio.addItem("AAAA");
		anio=1910;
		while(anio<2019){
			cmbResideDesde_Anio.addItem(anio);
			anio++;
		}
		String[] reside_desde = datos_persona.get("reside_desde").split("/");
		
		
		cmbResideDesde_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbResideDesde_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		cmbResideDesde_Dia.setSelectedItem(reside_desde[0]);
		cmbResideDesde_Mes.setSelectedItem(reside_desde[1]);
		cmbResideDesde_Anio.setSelectedItem(Integer.parseInt(reside_desde[2]));
		txtMotivoContacto.setText(datos_persona.get("motivo_contacto"));
		
		
		
		
		
		//obtengo los docuentos 
		HashMap<String,String> documentos = controlador.Documentos(ciVenezolana+"");
		cmbCarnetSaludVigente_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cmbCarnetSaludVigente_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbCarnetSaludVigente_Anio.setModel(new DefaultComboBoxModel(new String[] {"AAAA"}));
		
		while(anio<=2070){
			cmbCarnetSaludVigente_Anio.addItem(anio);
			anio++;
		}
		
		if(documentos.get("carnet_salud").equals("---")){
			radio_carnet_salud_no.setSelected(true);;
		}else{
			radio_carnet_salud_no.setSelected(false);
			radio_carnet_salud_si.setSelected(true);
			lblVigenteHasta.setVisible(true);
			cmbCarnetSaludVigente_Dia.setVisible(true);
			cmbCarnetSaludVigente_Mes.setVisible(true);
			cmbCarnetSaludVigente_Anio.setVisible(true);
			String[] fecha_carnet_salud = documentos.get("carnet_salud").split("/");
			cmbCarnetSaludVigente_Dia.setSelectedItem(fecha_carnet_salud[0]);
			cmbCarnetSaludVigente_Mes.setSelectedItem(fecha_carnet_salud[1]);
			cmbCarnetSaludVigente_Anio.setSelectedItem(Integer.parseInt(fecha_carnet_salud[2]));
		}
		
		if(documentos.get("ci_uruguaya").equals("---")){
			radio_ci_uy_no.setSelected(true);
			radio_ci_uy_si.setSelected(false);
		}else{
			radio_ci_uy_no.setSelected(false);
			radio_ci_uy_si.setSelected(true);
			lblNumero_ci_uy.setVisible(true);
			txtNumeroCIUY.setVisible(true);
			txtNumeroCIUY.setText(documentos.get("ci_uruguaya"));
		}
		if(documentos.get("pasaporte").equals("---")){
			radio_pasaporteNo.setSelected(true);
			radio_pasaporteSi.setSelected(false);
		}else{
			radio_pasaporteNo.setSelected(false);
			radio_pasaporteSi.setSelected(true);
			lblNumero_pasaporte.setVisible(true);
			txtPasaporte.setVisible(true);
			txtPasaporte.setText(documentos.get("pasaporte"));
		}
		
		//obtengo los datos de la formacion academica 
		HashMap<String,String> formacion_academica = controlador.Datos_Formacion_Academica(ciVenezolana+"");
		
		cmbNivelCursado.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Terciario/Tecnica", "Grado universitario", "Postgrado universitario", "No especifica"}));
		
		cmbNivelCursado.setSelectedItem(formacion_academica.get("nivel"));
		
		if(formacion_academica.get("completado").equals("Completo")){
			radio_NivelCursadoIncompleto.setSelected(false);
			radio_nivelCursadoCompleto.setSelected(true);
			verificarEscoladidad();
		}else{
			radio_NivelCursadoIncompleto.setSelected(true);
			radio_nivelCursadoCompleto.setSelected(false);
			verificarEscoladidad();
		}
		
		
		
		
		//obtengo profesion 
		HashMap<String,String> tiene_profesion = controlador.Obtener_Profesion(ciVenezolana+"",formacion_academica.get("nivel"), formacion_academica.get("completado"));
		
		if(cmbNivelCursado.getSelectedIndex()>=2){
			cmbTituloObtenido.setSelectedItem(tiene_profesion.get("titulo"));
			if(tiene_profesion.get("homologacion").equals("Si")){
				radio_HomologadoSi.setSelected(true);
				radio_HomologadoNo.setSelected(false);

			}else{
				radio_HomologadoNo.setSelected(true);
				radio_HomologadoSi.setSelected(false);

			}
		}
		
		
		
		//obtengo telefonos 
		HashMap<String,String> telefonos = controlador.Obtener_tenefonos(ciVenezolana+"");
		
		txtTelefono.setText(telefonos.get("tel1"));
		txtOtroTelefono.setText(telefonos.get("tel2"));
		
		//obtengo familia_persona 
		HashMap<String,String> familia_persona = controlador.Obtener_Familia_Persona(ciVenezolana+"");
		cmbViveCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Familia", "Amigos", "Otro"}));
	
		String[] viveCon = familia_persona.get("vive_con").split(": ");
		cmbViveCon.setSelectedItem(viveCon[0]);
		
		cmbDetalleViveConFamilia.setModel(new DefaultComboBoxModel(new String[] {"Padre i/o madre", "Con hijos", "En pareja con hijos", "En pareja", "Otra familia"}));
		
		if(viveCon.length!=1){
			cmbDetalleViveConFamilia.setSelectedItem(viveCon[1]);
		}
		cmbVinoCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Acompa\u00F1ado"}));
		cmbVinoCon.setSelectedItem(familia_persona.get("vino_con"));
		
		txtCantHijos.setText(familia_persona.get("cant_hijos"));
		txtCantidadHijosExtranjero.setText(familia_persona.get("hijos_extranjero"));
		
		
		
		
		
		//obtengo los idiomas 
		String[] idiomas = controlador.Obtener_Idiomas(ciVenezolana+"");
		
		DefaultListModel oldModel = new DefaultListModel();
		
		for(int i=0; i<idiomas.length;i++){
			if(idiomas[i]!=null){
				oldModel.addElement(idiomas[i]);
			}
		}
		listIdiomasAgregados.setModel(oldModel);
		
		
		
		
		
		
		
		
		
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
	
	
	public static boolean Verificar_Email(String email) {
		 
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        boolean result;
        if (mather.find() == true) {
            result=true;
        } else {
            result=false;
        }
        return result;
    }
	

 
	public FormularioRegistro(int type) {
		tipoDeRegistro = type;
		
		if(type==0){
			setTitle("Formulario de Registro: Usuario nuevo");
		}else if(type==2){
			setTitle("Formulario de modificacion: ");
		}
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
		
		if(tipoDeRegistro!=2){
			cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		}
		
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
		
		
		cmbFechaNac_Dia.setBounds(571, 8, 57, 20);
		panelDatosPersonales.add(cmbFechaNac_Dia);
		if(tipoDeRegistro!=2){
			cmbFechaNac_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			cmbFechaNac_Dia .setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		}
		
		
		
		cmbFechaNac_Mes.setBounds(638, 8, 58, 20);
		panelDatosPersonales.add(cmbFechaNac_Mes);
		
		
		
		cmbFechaNac_Anio.setBounds(706, 8, 76, 20);
		panelDatosPersonales.add(cmbFechaNac_Anio);
		
		if(tipoDeRegistro!=2){
			//Si el tipo de form es un registro o continuacion de registro
			cmbFechaNac_Anio.addItem("AAAA");
			int anio=1910;
			while(anio<=2018){
				cmbFechaNac_Anio.addItem(anio);
				anio++;
			}
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
		txtCIVenezolana.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCIVenezolana.getText().length()>=8){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						try{
							int parsed = Integer.parseInt(data);
						}catch (Exception es){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
						try{
							int parsed = Integer.parseInt(data);
						}catch (Exception es){
							e.consume();
						}
					
				}
				
			}
			
		
		});
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
		
		
		lblNumero_ci_uy.setBounds(229, 11, 57, 14);
		lblNumero_ci_uy.setVisible(false);
		panelDocumentacion.add(lblNumero_ci_uy);
		
		txtNumeroCIUY = new JTextField();
		txtNumeroCIUY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNumeroCIUY.getText().length()>=8){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						if(!verificarInteger(data)){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
					if(!verificarInteger(data)){
						e.consume();
					}
					
				}
			}
		});
		txtNumeroCIUY.setBounds(291, 8, 242, 20);
		panelDocumentacion.add(txtNumeroCIUY);
		txtNumeroCIUY.setVisible(false);
		txtNumeroCIUY.setColumns(10);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud");
		lblCarnetDeSalud.setBounds(10, 50, 100, 14);
		panelDocumentacion.add(lblCarnetDeSalud);
		
		
		lblVigenteHasta.setBounds(229, 50, 86, 14);
		lblVigenteHasta.setVisible(false);
		panelDocumentacion.add(lblVigenteHasta);
		
		if(tipoDeRegistro!=2){
			cmbCarnetSaludVigente_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			cmbCarnetSaludVigente_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		}
		
		
		cmbCarnetSaludVigente_Dia.setBounds(320, 47, 57, 20);
		panelDocumentacion.add(cmbCarnetSaludVigente_Dia);
		cmbCarnetSaludVigente_Dia.setVisible(false);
		
		
		cmbCarnetSaludVigente_Mes.setBounds(387, 47, 58, 20);
		cmbCarnetSaludVigente_Mes.setVisible(false);
		panelDocumentacion.add(cmbCarnetSaludVigente_Mes);
		
		
		
		cmbCarnetSaludVigente_Anio.setBounds(457, 47, 76, 20);
		cmbCarnetSaludVigente_Anio.setVisible(false);
		panelDocumentacion.add(cmbCarnetSaludVigente_Anio);
		
		
		if(tipoDeRegistro!=2){
			//Si el tipo de form es un registro o continuacion de registro
			cmbCarnetSaludVigente_Anio.addItem("AAAA");
			anio=2018;
			while(anio<=2070){
				cmbCarnetSaludVigente_Anio.addItem(anio);
				anio++;
			}
		}
		JLabel lblPasaporte = new JLabel("Pasaporte:");
		lblPasaporte.setBounds(10, 89, 76, 14);
		panelDocumentacion.add(lblPasaporte);
		
		
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
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtTelefono.getText().length()>=12){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						if(!verificarInteger(data)){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
					if(!verificarInteger(data)){
						e.consume();
					}
					
				}
			}
		});
		txtTelefono.setBounds(78, 8, 126, 20);
		panelContacto.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtOtroTelefono = new JTextField();
		txtOtroTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtOtroTelefono.getText().length()>=12){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						if(!verificarInteger(data)){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
					if(!verificarInteger(data)){
						e.consume();
					}
					
				}
			}
		});
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
		panelTxtMotivoContacto.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 194, 67);
		panelTxtMotivoContacto.add(scrollPane);
		scrollPane.setViewportView(txtMotivoContacto);
		txtMotivoContacto.setLineWrap(true);
		txtMotivoContacto.setColumns(26);
		txtMotivoContacto.setRows(5);
		txtMotivoContacto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtMotivoContacto.getText().length()>250){
					if(e.getKeyChar() != e.VK_BACK_SPACE){
						e.consume();
					}
				}
				
					
			}
		});
		
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
		if(tipoDeRegistro!=2){
			cmbNivelCursado.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Terciario/Tecnica", "Grado universitario", "Postgrado universitario", "No especifica"}));
		}
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
		
		
		if(tipoDeRegistro!=2){
			cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero/a", "Casado/a", "Divorciado", "Viudo", "Concubinato"}));
		}
		
		cmbEstadoCivil.setBounds(285, 50, 124, 20);
		panelSituacionFamiliar.add(cmbEstadoCivil);
		
		JLabel lblVinoCon = new JLabel("Vino con");
		lblVinoCon.setBounds(10, 53, 67, 14);
		panelSituacionFamiliar.add(lblVinoCon);
		
		if(tipoDeRegistro!=2){
			
			cmbVinoCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Acompa\u00F1ado"}));
		}
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
		
		
		if(tipoDeRegistro!=2){
			cmbViveCon.setModel(new DefaultComboBoxModel(new String[] {"Solo", "Familia", "Amigos", "Otro"}));
		}
		cmbViveCon.setBounds(87, 11, 101, 20);
		panelSituacionFamiliar.add(cmbViveCon);
		
		
		txtDetalleViveConOtro.setBounds(251, 11, 304, 20);
		panelSituacionFamiliar.add(txtDetalleViveConOtro);
		txtDetalleViveConOtro.setColumns(10);
		
		
		lblDetalle.setBounds(195, 14, 46, 14);
		panelSituacionFamiliar.add(lblDetalle);
		
		
		if(tipoDeRegistro!=2){
			cmbDetalleViveConFamilia.setModel(new DefaultComboBoxModel(new String[] {"Padre i/o madre", "Con hijos", "En pareja con hijos", "En pareja", "Otra familia"}));
		}
		cmbDetalleViveConFamilia.setBounds(251, 11, 147, 20);
		panelSituacionFamiliar.add(cmbDetalleViveConFamilia);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setBounds(10, 92, 101, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos);
		
		txtCantHijos = new JTextField();
		txtCantHijos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCantHijos.getText().length()>=3){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						if(!verificarInteger(data)){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
					if(!verificarInteger(data)){
						e.consume();
					}
					
				}
				
				
			}
		});
		txtCantHijos.setBounds(121, 89, 46, 20);
		panelSituacionFamiliar.add(txtCantHijos);
		txtCantHijos.setColumns(10);
		JLabel lblCantidadDeHijos_1 = new JLabel("Cantidad de hijos en el extranjero");
		lblCantidadDeHijos_1.setBounds(177, 92, 204, 14);
		panelSituacionFamiliar.add(lblCantidadDeHijos_1);
		txtCantidadHijosExtranjero = new JTextField();
		txtCantidadHijosExtranjero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCantidadHijosExtranjero.getText().length()>=3){
					if(e.getKeyCode()!=e.VK_BACK_SPACE){
						e.consume();
					}else{
						String data = String.valueOf(e.getKeyChar());
						if(!verificarInteger(data)){
							e.consume();
						}
					}
				}else{
					String data = String.valueOf(e.getKeyChar());
					
					if(!verificarInteger(data)){
						e.consume();
					}
					
				}
			}
		});
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
		cmbOcupacion.setBounds(116, 15, 136, 20);
		panel.add(cmbOcupacion);
		if(tipoDeRegistro!=2){
			cmbOcupacion.addItem("Trabajo fijo");
			cmbOcupacion.addItem("Trabajo zafral o temporal");
			cmbOcupacion.addItem("Desocupado");
			cmbOcupacion.addItem("Jubilado/Pensionista");
			cmbOcupacion.addItem("Estudiante");
		}
		
		
		
		JLabel lblResideDesde = new JLabel("Reside desde");
		lblResideDesde.setBounds(262, 18, 96, 14);
		panel.add(lblResideDesde);
		
		
		
		cmbResideDesde_Dia.setBounds(347, 15, 57, 20);
		panel.add(cmbResideDesde_Dia);
		if(tipoDeRegistro!=2){
			
		
		cmbResideDesde_Dia.addItem("DD");
		cmbResideDesde_Mes.addItem("MM");
		cmbResideDesde_Dia.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbResideDesde_Mes.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		}
		cmbResideDesde_Mes.setBounds(414, 15, 58, 20);
		panel.add(cmbResideDesde_Mes);
		
		
		
		
		cmbResideDesde_Anio.setBounds(482, 15, 76, 20);
		panel.add(cmbResideDesde_Anio);
		
		if(tipoDeRegistro!=2){
			cmbResideDesde_Anio.addItem("AAAA");
			anio=1910;
			while(anio<2019){
				cmbResideDesde_Anio.addItem(anio);
				anio++;
			}
		}
		radio_NivelCursadoIncompleto.setSelected(true);
		radio_HomologadoNo.setSelected(true);
		
		
		btnConfirmarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioRegistro_Controller controlador = FormularioRegistro_Controller.getIntancia();
				//DATOS QUE NECESITA TABLA PERSONA 
				boolean docInserted = false;
				boolean textInCIVN = false,textInCIUY = false;
				try{
					//VERIFICACION DE TEXTO EN CI VENEZOLANA
					int civn = Integer.parseInt(txtCIVenezolana.getText());
					textInCIVN = false;
				}catch (Exception e){
					textInCIVN = true;
				}
				try{
					//VERIFICACION DE TEXTO EN CI URUGUAYA
					int ciuy = Integer.parseInt(txtNumeroCIUY.getText());
					textInCIUY = false;
				}catch (Exception e){
					textInCIUY = true;
				}
				
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
				int id_persona = 0;
				
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
				boolean verificar_email = Verificar_Email(email);
				boolean cerrar_ventana = false;
				if(hijos_exterior>cant_hijos){//no dijo toda la cantidad de hijos
					JOptionPane.showMessageDialog(null, "La cantida de hijos en el exterior es mayor a la cantidad de hijos en total, eso no es posible", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}else if (!verificar_email){
					JOptionPane.showMessageDialog(null, "El email es inválido", "ERROR EMAIL", JOptionPane.ERROR_MESSAGE);
				}else if(dia_nac.equals("DD") ||mes_nac.equals("MM")|| anio_nac.equals("AAAA")){
					JOptionPane.showMessageDialog(null, "Fecha de nacimiento inválida", "ERROR FECHA DE NACIMIENTO", JOptionPane.ERROR_MESSAGE);
				}else if(dia_reside.equals("DD")|| mes_reside.equals("MM")|| anio_reside.equals("AAAA")){
					JOptionPane.showMessageDialog(null, "Fecha de residencia inválida", "ERROR FECHA DE RESIDENCIA", JOptionPane.ERROR_MESSAGE);
				}else if(txtMotivoContacto.getText().length()>255){
					JOptionPane.showMessageDialog(null, "Motivo de contacto demasiado largo (max 255 chars)", "ERROR MOTIVO DE CONTACTO", JOptionPane.ERROR_MESSAGE);
				}else if(textInCIVN){
					JOptionPane.showMessageDialog(null, "La cedula venezolana no puede contener texo", "ERROR CEDULA VENEZOLANA", JOptionPane.ERROR_MESSAGE);
				}else if(textInCIUY){
					JOptionPane.showMessageDialog(null, "La cedula uruguaya no puede contener texto", "ERROR CEDULA URUGUAYA", JOptionPane.ERROR_MESSAGE);
				}else{
					//if tipo es 0 o 1 insertar o hacer update
					if(tipoDeRegistro==1||tipoDeRegistro==2){
						//UPDATE PERSONA
						controlador.UpdatePersona(primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, dia_nac, mes_nac, anio_nac, pais_nac, ciudad_nac, estado_civil, ocupacion, direccion, dia_reside, mes_reside, anio_reside, email, motivo_contacto, ci_venezolana);
						System.out.println("se hizo el update");
					}else{
						//INSERT PERSONA
						id_persona = controlador.InsertPersona(primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, dia_nac, mes_nac, anio_nac, pais_nac, ciudad_nac, estado_civil, ocupacion, direccion, dia_reside, mes_reside, anio_reside, email, motivo_contacto);
						System.out.println("se hizo el insert de persona");
					}
					
					System.err.println(id_persona);
					
					if(tipoDeRegistro==1 || tipoDeRegistro==2){
						//UPDATE DOCUMENTOS
						controlador.UpdateDocumentos(ci_uruguaya, pasaporte, dia_carnet_salud, mes_carnet_salud, anio_carnet_salud, ci_venezolana);
						System.out.println("se actualizaron los documentos");
					}else{
						if(id_persona != -1){
							//INSERT DOCUMENTOS
							docInserted = controlador.InsertDocumentos(id_persona, ci_uruguaya, pasaporte, dia_carnet_salud, mes_carnet_salud, anio_carnet_salud, ci_venezolana);
							System.out.println("se insertaron los documentos");
						}
						
					}
					
					if(tipoDeRegistro==1||tipoDeRegistro==2){
						if(tipoDeRegistro==2){
							controlador.EliminarDatosPersona(ci_venezolana);//ELIMINO LOS TELEFONOS
						}
						
						if(tel1.equals("") || tel1==null){
							System.out.println("tel1 vacio");
						}else{
							controlador.InsertarTelefono(ci_venezolana,tel1);
							System.out.println("se inserto tel1");
							
						}
						if(tel2.equals("") || tel2==null){
							System.out.println("tel2 vacio");
							
						}else if (!tel2.equals(tel1)) { //si los dos telefonos son distintos
							controlador.InsertarTelefono(ci_venezolana,tel2);
							System.out.println("se inserto tel 2");
						}
						
						controlador.InsertarFormacion_Academica(nivel_escolar,completado,ci_venezolana);
						System.out.println("se inserto la formacion academica");
						controlador.InsertarTiene_profesion(id_titulo,homologacion,ci_venezolana);
						System.out.println("se inserto la profesion");
						
						controlador.Insertar_familia_persona(vive_con,detalle,vino_con,cant_hijos,hijos_exterior,ci_venezolana);
						System.out.println("se inserto la situacion familiar");
						
						String row;
						String[] separado;
						
						for(int i =0;i<listIdiomasAgregados.getModel().getSize();i++){
							row = listIdiomasAgregados.getModel().getElementAt(i).toString();
							separado = row.split(" - ");
							//INSERT IDIOMAS
							controlador.InsertarIdiomaPersona(separado[0],separado[1],ci_venezolana);//idioma,nivel*//
						}
						cerrar_ventana=true;
					}else {
						if(docInserted){
							//SI ES NUEVO USUARIO Y SE LOGRO INSERTAR LO ANTTERIOR 
							if(tel1.equals("") || tel1==null){
								System.out.println("tel1 vacio");
							}else{
								controlador.InsertarTelefono(ci_venezolana,tel1);
								System.out.println("se inserto tel1");
							}
							if(tel2.equals("") || tel2==null){
								System.out.println("tel2 vacio");
								
							}else if (!tel2.equals(tel1)){ // si los telefonos son distintos, que lo inserte 
								controlador.InsertarTelefono(ci_venezolana,tel2);
								System.out.println("se inserto tel 2");
							}
							
							controlador.InsertarFormacion_Academica(nivel_escolar,completado,ci_venezolana);
							System.out.println("se inserto la formacion academica");
							controlador.InsertarTiene_profesion(id_titulo,homologacion,ci_venezolana);
							System.out.println("se inserto la profesion");
							
							controlador.Insertar_familia_persona(vive_con,detalle,vino_con,cant_hijos,hijos_exterior,ci_venezolana);
							System.out.println("se inserto la situacion familiar");
							
							String row;
							String[] separado;
							
							for(int i =0;i<listIdiomasAgregados.getModel().getSize();i++){
								row = listIdiomasAgregados.getModel().getElementAt(i).toString();
								separado = row.split(" - ");
								//INSERT IDIOMAS
								controlador.InsertarIdiomaPersona(separado[0],separado[1],ci_venezolana);//idioma,nivel*//
							}//end for
							cerrar_ventana=true;
						} //end if docinserted
					}// end else 
				}
				if(cerrar_ventana){
					JOptionPane.showMessageDialog(null, "Se han guardado lo datos correctamente");
					dispose();
				}
				
			}
			
		});
		btnConfirmarRegistro.setBounds(588, 695, 214, 23);
		contentPane.add(btnConfirmarRegistro);
		RellenarFormularioConBD();
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
	public boolean verificarInteger(String data){
		try{
			int parsed = Integer.parseInt(data);
			return true;
		}catch (Exception es){
			return false;
		}
	}
}
