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
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.HashMap;

public class VerInformacion extends JFrame {
	private JPanel contentPane;
	public VerInformacion(int cedulaVenezolana,String primerNombre, String primerApellido, String motivoContacto) {
		setTitle("Informacion de: "+primerNombre+" "+primerApellido+" - CI: "+cedulaVenezolana);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 543);
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
		
		VerInformacion_Controller controlador = VerInformacion_Controller.getIntancia();
		HashMap<String,String> datos_persona = controlador.Datos_Persona(cedulaVenezolana+"");
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre: ");
		lblPrimerNombre.setBounds(10, 11, 199, 14);
		panel.add(lblPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre: ");
		lblSegundoNombre.setBounds(219, 11, 199, 14);
		panel.add(lblSegundoNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		lblPrimerApellido.setBounds(10, 36, 199, 14);
		panel.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido: ");
		lblSegundoApellido.setBounds(219, 36, 199, 14);
		panel.add(lblSegundoApellido);
		
		JLabel lblFechaDeNacimientto = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimientto.setBounds(10, 61, 199, 14);
		panel.add(lblFechaDeNacimientto);
		
		JLabel lblPaisDeNacimiento = new JLabel("Pais de nacimiento");
		lblPaisDeNacimiento.setBounds(219, 61, 199, 14);
		panel.add(lblPaisDeNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 111, 199, 14);
		panel.add(lblDireccion);
		
		JLabel lblCiudadDeNacimiento = new JLabel("Ciudad de nacimiento");
		lblCiudadDeNacimiento.setBounds(10, 86, 199, 14);
		panel.add(lblCiudadDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(219, 86, 46, 14);
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
		
		JLabel lblCedulaVenezolana = new JLabel("Cedula venezolana");
		lblCedulaVenezolana.setBounds(10, 11, 199, 14);
		panel_1.add(lblCedulaVenezolana);
		
		JLabel lblCedulaUrugaya = new JLabel("Cedula urugaya");
		lblCedulaUrugaya.setBounds(10, 36, 199, 14);
		panel_1.add(lblCedulaUrugaya);
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setBounds(10, 61, 199, 14);
		panel_1.add(lblPasaporte);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud");
		lblCarnetDeSalud.setBounds(10, 86, 199, 14);
		panel_1.add(lblCarnetDeSalud);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 209, 428, 64);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNivelEducativo = new JLabel("Nivel educativo");
		lblNivelEducativo.setBounds(10, 11, 199, 14);
		panel_2.add(lblNivelEducativo);
		
		JLabel lblEstadoEscolar = new JLabel("Estado del curso");
		lblEstadoEscolar.setBounds(219, 11, 199, 14);
		panel_2.add(lblEstadoEscolar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 36, 199, 14);
		panel_2.add(lblTitulo);
		
		JLabel lblHomologado = new JLabel("Homologado");
		lblHomologado.setBounds(219, 36, 199, 14);
		panel_2.add(lblHomologado);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 370, 428, 87);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblViveCon = new JLabel("Vive con");
		lblViveCon.setBounds(10, 11, 199, 14);
		panel_3.add(lblViveCon);
		
		JLabel lblVinoCon = new JLabel("Vino con");
		lblVinoCon.setBounds(219, 11, 199, 14);
		panel_3.add(lblVinoCon);
		
		JLabel lblCantidadDeHijos_1 = new JLabel("Hijos en el extranjero");
		lblCantidadDeHijos_1.setBounds(219, 36, 199, 14);
		panel_3.add(lblCantidadDeHijos_1);
		
		JLabel lblCantidadDeHijos = new JLabel("Cantidad de hijos");
		lblCantidadDeHijos.setBounds(10, 36, 199, 14);
		panel_3.add(lblCantidadDeHijos);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(10, 61, 199, 14);
		panel_3.add(lblEstadoCivil);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 284, 428, 50);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblResideDesde = new JLabel("Reside desde");
		lblResideDesde.setBounds(219, 11, 199, 14);
		panel_4.add(lblResideDesde);
		
		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(10, 11, 199, 14);
		panel_4.add(lblOcupacion);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(448, 209, 221, 125);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 50, 199, 14);
		panel_5.add(lblTelefono);
		
		JLabel lblOtroTel = new JLabel("Otro telefono");
		lblOtroTel.setBounds(10, 75, 199, 14);
		panel_5.add(lblOtroTel);
		
		JLabel lblDireccionDeEmail = new JLabel("Email");
		lblDireccionDeEmail.setBounds(8, 100, 201, 14);
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
		list.setBackground(SystemColor.control);
		scrollPane.setViewportView(list);
		
		JLabel lblIdiomas = new JLabel("Idiomas");
		lblIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdiomas.setBounds(448, 345, 221, 14);
		contentPane.add(lblIdiomas);
		
		JButton btnModificarUsuario = new JButton("Modificar usuario");
		btnModificarUsuario.setBounds(168, 468, 148, 23);
		contentPane.add(btnModificarUsuario);
		
		JButton btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.setBounds(10, 468, 148, 23);
		contentPane.add(btnEliminarUsuario);
	}
}
