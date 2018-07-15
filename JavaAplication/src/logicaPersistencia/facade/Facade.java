package logicaPersistencia.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;

import logicaPersistencia.dbAccess.dbFunctions;
import logicaPersistencia.valueObject.ValueObject_UsuariosNuevosBusqueda;

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
	public ResultSet UsuariosNuevosBusqueda_Function(ValueObject_UsuariosNuevosBusqueda data){
		//Funcion que permite buscar en la base datos los nuevos usuarios registrados
		//Obtengo los datos encapsulados en el ValueObject
		int type = data.getType();
		String value = data.getValue();
		//---------------------------------------------------------
		System.out.println("Facade.UsuariosNuevosBusquedaFunction: Se inicializa un objeto dbFunctions");
		//---------------------------------------------------------
		dbFunctions dbAccess = new dbFunctions(config);
		//---------------------------------------------------------
		System.out.println("Facade.UsuariosNuevosBusquedaFunction: Se llama a dbAccess para realizar consulta");
		//---------------------------------------------------------
		ResultSet toBeReturnedData = dbAccess.ListarUsuariosNuevos(type, value);
		System.out.println("Facade.UsuariosNuevosBusquedaFunction: Datos recibidos correctamente desde dbAccess, retornando informacion");
		return toBeReturnedData;
	}
}
