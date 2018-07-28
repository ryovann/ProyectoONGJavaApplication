package grafica.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import logicaPersistencia.facade.Facade;
import logicaPersistencia.valueObject.VO_Documentos;
import logicaPersistencia.valueObject.VO_Familia_Persona;
import logicaPersistencia.valueObject.VO_Formacion_Academica;
import logicaPersistencia.valueObject.VO_Persona;
import logicaPersistencia.valueObject.VO_Persona_Idioma;
import logicaPersistencia.valueObject.VO_Tiene_Profesion;
import logicaPersistencia.valueObject.VO_telefonos_Persona;

public class FormularioRegistro_Controller {
	//SINGLETON
	private static FormularioRegistro_Controller instancia = null;
	
	private FormularioRegistro_Controller(){};
	
	public static FormularioRegistro_Controller getIntancia(){
		
		if (instancia == null){
			instancia= new FormularioRegistro_Controller();
		}
		return instancia;
		
	}
	
	public void UpdatePersona(String primer_nombre, String segundo_nombre,String primer_apellido,String segundo_apellido,String sexo,String dia_nac,
	String mes_nac,String anio_nac,String pais_nac,String ciudad_nac,String estado_civil,String ocupacion,String direccion,String dia_reside,
	String mes_reside,String anio_reside,String email,String motivo_contacto,String ci_venezolana ){
		
		String fecha_nacimiento = anio_nac+"-"+mes_nac+"-"+dia_nac;
		String fecha_reside =  anio_reside+"-"+mes_reside+"-"+dia_reside;
		VO_Persona vop= new VO_Persona(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,sexo,
						fecha_nacimiento,pais_nac,ciudad_nac,estado_civil,ocupacion,direccion, fecha_reside,
						email,motivo_contacto,ci_venezolana);
		Facade f = new Facade();
		f.UpdatePersona(vop);
	}
	
	public void InsertarTelefono(String ci_venezolana,String tel1){
		VO_telefonos_Persona votp= new VO_telefonos_Persona(ci_venezolana, tel1);
		Facade f = new Facade();
		f.InsertarTelefono(votp);
	}
	
	public void UpdateDocumentos(String ci_uruguaya,String pasaporte, String dia, String mes, String anio,String ci_venezolana){
		String fecha_carnet_salud = anio+"-"+mes+"-"+dia;
		VO_Documentos vod= new VO_Documentos(ci_uruguaya,pasaporte,fecha_carnet_salud,ci_venezolana);
		Facade f= new Facade();
		f.UpdateDocumentos(vod);
	}
	
	public void InsertarFormacion_Academica(String nivel_escolar,int completado,String ci_venezolana){
		VO_Formacion_Academica vofa= new VO_Formacion_Academica(nivel_escolar,completado,ci_venezolana);
		Facade f= new Facade();
		f.InsertarFormacion_Academica(vofa);
	}
	public DefaultComboBoxModel ObtenerPaises(){
		//Funcion que retorna un ComboBoxModel con una lista de paises
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Se crea una nueva instancia de facade y se intenta obtener la configuracion");
		// ---------------------------------------------------------
		Facade facade = new Facade();
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Se llamo a facade.ListarPaises_Function");
		// ---------------------------------------------------------
		ResultSet recivedData = facade.ListarPaises_Function();
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Datos recibidos correctamente desde Facade.ListarPaises_Function");
		// ---------------------------------------------------------
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		try {
			while(recivedData.next()){
				modelo.addElement(recivedData.getString("nombre_pais"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
	}
	public DefaultComboBoxModel ObtenerIdiomas(){
		//Funcion que retorna un ComboBoxModel con una lista de idiomas
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerIdiomas: Se crea una nueva instatncia de facade y se intenta obtener la configuracion");
		// ---------------------------------------------------------
		
		Facade facade = new Facade();
		
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerIdiomas: Se llamo a facade.ListarIdiomas_Function");
		// ---------------------------------------------------------
		
		ResultSet recivedData = facade.ListarIdiomas_Function();
		
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerIdiomas: Datos recibidos correctamente desdee facade.ListarIdiomas_Function");
		// ---------------------------------------------------------
		
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			while(recivedData.next()){
				model.addElement(recivedData.getString("nombre_idioma"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
		
	}
	public DefaultComboBoxModel ObtenerProfesiones(){
		//Funcion que retorna un ComboBoxModel con una lista de profesiones
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerProfesiones: Se crea una nueva instatncia de facade y se intenta obtener la configuracion");
		// ---------------------------------------------------------
		
		Facade facade = new Facade();
		
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerProfesiones: Se llamo a facade.ListarProfesiones_Function");
		// ---------------------------------------------------------
		
		ResultSet recivedData = facade.ListarProfesiones_Function();
		
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerProfesiones: Datos recibidos correctamente desdee facade.ListarProfesiones_Function");
		// ---------------------------------------------------------
		
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		try {
			while(recivedData.next()){
				modelo.addElement(recivedData.getString("titulo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
	}
	
	public void InsertarTiene_profesion(int id_titulo, int homologacion, String ci_venezolana){
		VO_Tiene_Profesion votp= new VO_Tiene_Profesion(id_titulo,homologacion,ci_venezolana);
		Facade f = new Facade();
		f.InsertarTiene_profesion(votp);
	}
	
	public void Insertar_familia_persona(String vive_con, String detalle, int vino_con,int cant_hijos,int hijos_exterior,String ci_venezolana){
		VO_Familia_Persona vofp = new VO_Familia_Persona(ci_venezolana,vive_con,detalle,vino_con,cant_hijos,hijos_exterior);
		Facade f = new Facade();
		f.Insertar_familia_persona(vofp);
	}

	public void InsertarIdiomaPersona(String idioma, String nivel, String ci_venezolana) {
		VO_Persona_Idioma vopi = new VO_Persona_Idioma(idioma,nivel,ci_venezolana);
		Facade f = new Facade();
		f.InsertarIdiomaPersona(vopi);
		
	}

	
	public boolean InsertDocumentos(int id_persona, String ci_uruguaya, String pasaporte, String dia_carnet_salud, String mes_carnet_salud,
			String anio_carnet_salud, String ci_venezolana) {
			String fecha_carnet_salud = anio_carnet_salud+"-"+mes_carnet_salud+"-"+dia_carnet_salud;
			VO_Documentos vod = new VO_Documentos(id_persona,ci_uruguaya,pasaporte,fecha_carnet_salud,ci_venezolana);
			boolean completed = false;
			Facade f = new Facade();
			completed = f.InsertarDocumentos(vod);
			
			return completed;
		}

		public int InsertPersona(String primer_nombre, String segundo_nombre, String primer_apellido,
				String segundo_apellido, String sexo, String dia_nac, String mes_nac, String anio_nac, String pais_nac,
				String ciudad_nac, String estado_civil, String ocupacion, String direccion, String dia_reside,
				String mes_reside, String anio_reside, String email, String motivo_contacto) {
			
			//Creo strings de fechas
			String fecha_nacimiento = anio_nac+"-"+mes_nac+"-"+dia_nac;
			String fecha_reside =  anio_reside+"-"+mes_reside+"-"+dia_reside;
			
			VO_Persona vop = new VO_Persona(primer_nombre, segundo_nombre,primer_apellido,
					segundo_apellido,sexo,estado_civil, email, ocupacion,
					motivo_contacto, fecha_reside, direccion, pais_nac, fecha_nacimiento,
					ciudad_nac);
			//cambie aca
			Facade f = new Facade();
			int recivedData = -1;
			recivedData = f.InsertarPersona(vop);
			return recivedData;
		}
	
	public void EliminarDatosPersona(String ci_venezolana){
		VO_Documentos vo = new VO_Documentos(ci_venezolana);
		Facade f = new Facade();
		f.EliminarDatosPersona(vo);
	}
	
	
	
}
