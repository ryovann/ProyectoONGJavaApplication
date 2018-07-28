package grafica.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import grafica.controller.VerInformacion_Controller;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VerInformacion extends JFrame {
	private JPanel contentPane;
	public VerInformacion(int cedulaVenezolana,String primerNombre, String primerApellido, String motivoContacto) {
		setTitle("Informacion de: "+primerNombre+" "+primerApellido+" - CI: "+cedulaVenezolana);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setBounds(10, 11, 428, 14);
		contentPane.add(lblDatosPersonales);
		lblDatosPersonales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 36, 428, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		System.out.println(cedulaVenezolana);
		
		VerInformacion_Controller controlador = VerInformacion_Controller.getIntancia();
		//obtengo los datos de la tabla persona
		HashMap<String,String> datos_persona = controlador.Datos_Persona(cedulaVenezolana+"");
		
		//obtengo los docuentos 
		HashMap<String,String> documentos = controlador.Documentos(cedulaVenezolana+"");
		
		//obtengo los datos de la formacion academica 
		HashMap<String,String> formacion_academica = controlador.Datos_Formacion_Academica(cedulaVenezolana+"");
		
		//obtengo profesion 
		HashMap<String,String> tiene_profesion = controlador.Obtener_Profesion(cedulaVenezolana+"",formacion_academica.get("nivel"), formacion_academica.get("completado"));
		
		//obtengo telefonos 
		HashMap<String,String> telefonos = controlador.Obtener_tenefonos(cedulaVenezolana+"");
		
		//obtengo familia_persona 
		HashMap<String,String> familia_persona = controlador.Obtener_Familia_Persona(cedulaVenezolana+"");
		
		//obtengo los idiomas 
		String[] idiomas = controlador.Obtener_Idiomas(cedulaVenezolana+"");
		
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre: "+primerNombre);
		lblPrimerNombre.setBounds(10, 11, 199, 14);
		panel.add(lblPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre: "+datos_persona.get("segundo_nombre"));
		lblSegundoNombre.setBounds(219, 11, 199, 14);
		panel.add(lblSegundoNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: "+primerApellido);
		lblPrimerApellido.setBounds(10, 36, 199, 14);
		panel.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido: "+datos_persona.get("segundo_apellido"));
		lblSegundoApellido.setBounds(219, 36, 199, 14);
		panel.add(lblSegundoApellido);
		
		JLabel lblFechaDeNacimientto = new JLabel("Fecha de nacimiento: "+datos_persona.get("fecha_nac"));
		lblFechaDeNacimientto.setBounds(10, 61, 199, 14);
		panel.add(lblFechaDeNacimientto);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento: "+datos_persona.get("pais_nac"));
		lblPaisDeNacimiento.setBounds(219, 61, 199, 14);
		panel.add(lblPaisDeNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion: "+datos_persona.get("domicilio"));
		lblDireccion.setBounds(10, 111, 199, 14);
		panel.add(lblDireccion);
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento: "+ datos_persona.get("ciudad_nac"));
		lblCiudadDeNacimiento.setBounds(10, 86, 199, 14);
		panel.add(lblCiudadDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo: "+datos_persona.get("sexo"));
		lblSexo.setBounds(219, 86, 73, 14);
		panel.add(lblSexo);
		
		JLabel lblDocumentacion = new JLabel("Documentacion");
		lblDocumentacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocumentacion.setBounds(448, 11, 221, 14);
		contentPane.add(lblDocumentacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(448, 36, 221, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//DOCUMENTOS
		JLabel lblCedulaVenezolana = new JLabel("Cedula venezolana: "+cedulaVenezolana);
		lblCedulaVenezolana.setBounds(10, 11, 199, 14);
		panel_1.add(lblCedulaVenezolana);
		
		JLabel lblCedulaUrugaya = new JLabel("Cedula urugaya: "+documentos.get("ci_uruguaya"));
		lblCedulaUrugaya.setBounds(10, 36, 199, 14);
		panel_1.add(lblCedulaUrugaya);
		
		JLabel lblPasaporte = new JLabel("Pasaporte: "+documentos.get("pasaporte"));
		lblPasaporte.setBounds(10, 61, 199, 14);
		panel_1.add(lblPasaporte);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud: "+documentos.get("carnet_salud"));
		lblCarnetDeSalud.setBounds(10, 86, 199, 14);
		panel_1.add(lblCarnetDeSalud);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 209, 428, 64);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//ESCOLARIDAD 
		JLabel lblNivelEducativo = new JLabel("Nivel educativo: "+formacion_academica.get("nivel"));
		lblNivelEducativo.setBounds(10, 11, 199, 14);
		panel_2.add(lblNivelEducativo);
		
		JLabel lblEstadoEscolar = new JLabel("Estado del curso: "+ formacion_academica.get("completado"));
		lblEstadoEscolar.setBounds(219, 11, 199, 14);
		panel_2.add(lblEstadoEscolar);
		
		JLabel lblTitulo = new JLabel("Titulo: "+tiene_profesion.get("titulo"));
		lblTitulo.setBounds(10, 36, 199, 14);
		panel_2.add(lblTitulo);
		
		JLabel lblHomologado = new JLabel("Homologado: "+tiene_profesion.get("homologacion"));
		lblHomologado.setBounds(219, 36, 199, 14);
		panel_2.add(lblHomologado);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 370, 428, 87);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblViveCon = new JLabel("Vive con: "+familia_persona.get("vive_con"));
		lblViveCon.setBounds(10, 11, 199, 14);
		panel_3.add(lblViveCon);
		
		JLabel lblVinoCon = new JLabel("Vino con: "+familia_persona.get("vino_con"));
		lblVinoCon.setBounds(219, 11, 199, 14);
		panel_3.add(lblVinoCon);
		
		JLabel lblCantidadDeHijos_1 = new JLabel("Hijos en el extranjero: "+familia_persona.get("hijos_extranjero"));
		lblCantidadDeHijos_1.setBounds(219, 36, 199, 14);
		panel_3.add(lblCantidadDeHijos_1);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos: "+familia_persona.get("cant_hijos"));
		lblCantidadDeHijos.setBounds(10, 36, 199, 14);
		panel_3.add(lblCantidadDeHijos);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil: "+datos_persona.get("estado_civil"));
		lblEstadoCivil.setBounds(10, 61, 199, 14);
		panel_3.add(lblEstadoCivil);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 284, 428, 50);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblResideDesde = new JLabel("Reside desde:"+datos_persona.get("reside_desde"));
		lblResideDesde.setBounds(219, 11, 199, 14);
		panel_4.add(lblResideDesde);
		
		JLabel lblOcupacion = new JLabel("Ocupacion: "+datos_persona.get("ocupacion"));
		lblOcupacion.setBounds(10, 11, 199, 14);
		panel_4.add(lblOcupacion);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(448, 209, 221, 125);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		//TELEFONOS
		JLabel lblTelefono = new JLabel("Telefono: "+telefonos.get("tel1"));
		lblTelefono.setBounds(12, 11, 199, 14);
		panel_5.add(lblTelefono);
		
		JLabel lblOtroTel = new JLabel("Otro telefono:"+telefonos.get("tel2"));
		lblOtroTel.setBounds(12, 36, 199, 14);
		panel_5.add(lblOtroTel);
		
		JLabel lblDireccionDeEmail = new JLabel("Email: "+datos_persona.get("email"));
		lblDireccionDeEmail.setBounds(10, 61, 201, 14);
		panel_5.add(lblDireccionDeEmail);
		
		JLabel lblInformacionFamiliar = new JLabel("Informacion familiar");
		lblInformacionFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformacionFamiliar.setBounds(10, 345, 428, 14);
		contentPane.add(lblInformacionFamiliar);
		
		JLabel lblEstudios = new JLabel("Estudios");
		lblEstudios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstudios.setBounds(10, 182, 221, 14);
		contentPane.add(lblEstudios);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContacto.setBounds(448, 182, 221, 14);
		contentPane.add(lblContacto);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(448, 370, 221, 87);
		contentPane.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		DefaultListModel oldModel = new DefaultListModel();//objeto temporal que contiene los elementos de la lista
		for(int i=0; i<idiomas.length;i++){
			if(idiomas[i]!=null){
				oldModel.addElement(idiomas[i]);
			}
		}
		list.setModel(oldModel);
		list.setBackground(SystemColor.control);
		scrollPane.setViewportView(list);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdiomas.setBounds(448, 345, 221, 14);
		contentPane.add(lblIdiomas);
		
		JButton btnModificarUsuario = new JButton("Cerrar");
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnModificarUsuario.setBounds(521, 468, 148, 23);
		contentPane.add(btnModificarUsuario);
	}
}
