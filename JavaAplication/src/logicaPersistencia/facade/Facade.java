package logicaPersistencia.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;

import logicaPersistencia.dbAccess.dbFunctions;
import logicaPersistencia.valueObject.VO_Documentos;
import logicaPersistencia.valueObject.VO_Familia_Persona;
import logicaPersistencia.valueObject.VO_Formacion_Academica;
import logicaPersistencia.valueObject.VO_Persona;
import logicaPersistencia.valueObject.VO_Tiene_Profesion;
import logicaPersistencia.valueObject.VO_telefonos_Persona;
import logicaPersistencia.valueObject.ValueObject_UsuariosBusqueda;

public class Facade {
	private String[] config;
	public Facade(){
		//Constructor de la clase facade
		super();
		configure();
		//Configuro los parametros de conexion a la base de datos
	}
	//Clase que permite obtener los parametros de configuracion del servidor
	public void configure(){
		String url,username,password,driver;
		//Strings donde guardo temporalmente los diferentes parametros de configuracion
		String filePath = "config/config.params";
		//Ruta al archivo de configuracion
		Properties p = new Properties();
		//Properties object el cual me permite obtener la configuracion
		try {
			//Cargo las diferentes lineas del archivo de configuracion
			p.load(new FileInputStream(filePath));
			//Inicio a guardar temporalmente los datos en las variables
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			driver = p.getProperty("driver");
			//termino de guardar los datos temporalmente
			config = new String[4];
			//Inicializo el array de configuracion e ingreso datos
			config[0] = driver;
			config[1] = url;
			config[2] = username;
			config[3] = password;
			//---------------------------------------------------------
			System.out.println("Facade.configure: Se configuraron los parametros correctamente");
			//---------------------------------------------------------
			//Termino de inicializar y de ingresar datos
		} catch (FileNotFoundException e) {
			System.out.println("Error al encontrar el archivo de configuracion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet UsuariosNuevosBusqueda_Function(ValueObject_UsuariosBusqueda data){
		//Funcion que permite buscar en la base datos los nuevos usuarios registrados
		//Obtengo los datos encapsulados en el ValueObject
		int type = data.getType();
		String value = data.getValue();
		int typeOfSearch = data.getTypeOfSearch();
		
		//---------------------------------------------------------
		System.out.println("Facade.UsuariosBusquedaFunction: Se inicializa un objeto dbFunctions");
		//---------------------------------------------------------
		dbFunctions dbAccess = new dbFunctions(config);
		//---------------------------------------------------------
		System.out.println("Facade.UsuariossBusquedaFunction: Se llama a dbAccess para realizar consulta");
		//---------------------------------------------------------
		ResultSet toBeReturnedData = dbAccess.listarUsuarios(typeOfSearch,type, value);
		System.out.println("Facade.UsuariosBusquedaFunction: Datos recibidos correctamente desde dbAccess, retornando informacion");
		return toBeReturnedData;
	}
	public ResultSet ListarPaises_Function(){
		//---------------------------------------------------------
		System.out.println("Facade.ListarPaises_Function: Se inicializa un objeto dbFunctions");
		//---------------------------------------------------------
		dbFunctions dbAccess = new dbFunctions(config);
		//---------------------------------------------------------
		System.out.println("Facade.ListarPaises_Function: Se llama a dbAccess para realizar consulta");
		//---------------------------------------------------------
		ResultSet toBeReturnedData = dbAccess.ListarPaises();
		System.out.println("Facade.ListarPaises_Function: Datos recibidos correctamente desde dbAccess, retornando informacion");
		return toBeReturnedData;
	}
	public ResultSet ListarIdiomas_Function(){
		//---------------------------------------------------------
		System.out.println("Facade.ListarIdiomas_Function: Se inicializa un objeto dbFunctions");
		//---------------------------------------------------------
		dbFunctions dbAccess = new dbFunctions(config);
		//---------------------------------------------------------
		System.out.println("Facade.ListarIdiomas_Function: Se llama a dbAccess para realizar consulta");
		//---------------------------------------------------------
		ResultSet toBeReturnedData = dbAccess.ListarIdiomas();
		System.out.println("Facade.ListarIdiomas_Function: Datos recibidos correctamente desde dbAccess, retornando informacion");
		return toBeReturnedData;
	}
	public ResultSet ListarProfesiones_Function(){
		//---------------------------------------------------------
		System.out.println("Facade.ListarProfesiones_Function: Se inicializa un objeto dbFunctions");
		//---------------------------------------------------------
		dbFunctions dbAccess = new dbFunctions(config);
		//---------------------------------------------------------
		System.out.println("Facade.ListarProfesiones_Function: Se llama a dbAccess para realizar consulta");
		//---------------------------------------------------------
		ResultSet toBeReturnedData = dbAccess.ListarProfesiones();
		System.out.println("Facade.ListarProfesiones_Function: Datos recibidos correctamente desde dbAccess, retornando informacion");
		return toBeReturnedData;
	}
	
	
	
	public void UpdatePersona(VO_Persona vop){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.UpdatePersona(vop.getPrimer_nombre(), vop.getSegundo_nombre(),vop.getPrimer_apellido(),
					vop.getSegundo_apellido(), vop.getSexo(), vop.getFecha_nac(), vop.getPais_nac(), 
						vop.getCiudad_nac(), vop.getEstado_civil(), vop.getOcupacion(), vop.getDireccion(), 
							vop.getFecha_reside(), vop.getEmail(), vop.getMotivo_contacto(),vop.getCi_venezolana());
		
	}
	
	public void InsertarTelefono(VO_telefonos_Persona votp){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.InsertarTelefono(votp.getCi_venezolana(),votp.getTel1());
	}
	
	public void UpdateDocumentos(VO_Documentos vod){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.UpdateDocumentos(vod.getCi_uruguaya(),vod.getPasaporte(),vod.getFecha_carnet_salud(),vod.getCi_venezolana());
	}
	
	public void InsertarFormacion_Academica(VO_Formacion_Academica vofa){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.InsertarFormacion_Academica(vofa.getNivel(),vofa.getCompletado(),vofa.getCi_venezolana());
	}
	
	public void InsertarTiene_profesion(VO_Tiene_Profesion votp){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.InsertarTiene_profesion(votp.getId_titulo(),votp.getHomologacion(),votp.getCi_venezolana());
	}
	
	public void Insertar_familia_persona(VO_Familia_Persona vofp){
		dbFunctions dbAccess = new dbFunctions(config);
		dbAccess.Insertar_familia_persona(vofp.getCi_venezolana(),vofp.getVive_con(),vofp.getDetalle(),vofp.getVino_con(),vofp.getCant_hijos(),vofp.getHijos_exterior());
	}
}
