package logicaPersistencia.dbAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbFunctions {
	//Esta clase contiene todos los metodos que permitiran
	//Insertar datos en la base de datos 
	private QueryStore querys = new QueryStore();//Objeto que contiene todas las consultas
	private ConnectionMaker ConnectionObject;
	
	public dbFunctions(String[] config){
		//El array config contiene todos los parametros para la conexion a la base de datos
		//Estos parametros se configuran en facade
		
		
		//---------------------------------------------------------
		System.out.println("dbFunctions: Comienza intento de inicializar ConnectionObject");
		//---------------------------------------------------------
		
		ConnectionObject = new ConnectionMaker(config[0], config[1], config[2], config[3]);
		
		//---------------------------------------------------------
		System.out.println("dbFunctions: ConnectionObject Inicializado correctamente");
		//---------------------------------------------------------
		//En la linea anterior inicializo el objeto ConnectionObject el cual permite
		//Realizar la conexion con la base de datos
	}
	public ResultSet ListarUsuariosNuevos(int type,String value){
		ConnectionObject.initializeConnection();//Inicializo la conexion
		if(type==0){
			//Aqui debo programar la consulta cuando 
			//el parametro de busqueda sea la cedula venezolana
			
			try {
				//Creo el objecto PreparedStatement para poder realizar la consulta
				PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.select_NuevosUsuarios_Lista__CIVenezolana());
				//Seteo el parametro de cedula venezolana al valor que es pasado por parametro
				preparedS.setInt(1, Integer.parseInt(value));
				ResultSet rs;//objeto resultset que guardara los datos
				//---------------------------------------------------------
				System.out.println("dbFunctions.ListarUsuariosNuevos: Realizando consulta a la base de datos");
				//---------------------------------------------------------
				rs = preparedS.executeQuery();//ejecuto la consulta.
				//---------------------------------------------------------
				System.out.println("dbFuncions.ListarUsuariosNuevos: Consulta realizada con exito");
				//---------------------------------------------------------
				return rs;
			} catch (SQLException e) {
				System.out.println("dbFunctions.ListarUsuariosNuevos: Error en la consulta: ");
				e.printStackTrace();
			}
		}else{
			//Debo programar la consulta para el segundo tipo de parametro
			try {
				//Creo el objecto PreparedStatement para poder realizar la consulta
				PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.select_NuevosUsuarios_Lista__NombreApellido());
				//Seteo el parametro de nombre y apellido al valor que es pasado por parametro
				preparedS.setString(1, "%"+value+"%");
				ResultSet rs;//objeto resultset que guardara los datos
				//---------------------------------------------------------
				System.out.println("dbFunctions.ListarUsuariosNuevos: Realizando consulta a la base de datos");
				//---------------------------------------------------------
				rs = preparedS.executeQuery();//ejecuto la consulta.
				//---------------------------------------------------------
				System.out.println("dbFuncions.ListarUsuariosNuevos: Consulta realizada con exito");
				//---------------------------------------------------------
				return rs;
			} catch (SQLException e) {
				System.out.println("dbFunctions.ListarUsuariosNuevos: Error en la consulta: ");
				e.printStackTrace();
			}
			
			
			
		}
		return null;
		
	}

}
