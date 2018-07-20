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
	
	public void UpdatePersona(String primer_nombre, String segundo_nombre,String primer_apellido,String segundo_apellido,String sexo,
			String fecha_nac,String pais_nac,String ciudad_nac,String estado_civil,String ocupacion,String direccion,
			String fecha_reside,String email,String motivo_contacto,String ci_venezolana){
		
		ConnectionObject.initializeConnection();//Inicializo la conexion
		String qpaisNac=querys.buscar_pais_por_nombre();//tengo que buscar el id del pais 
		
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(qpaisNac);
			//Seteo el parametro del nombre del pais al valor que es pasado por parametro
			preparedS.setString(1,pais_nac);
			ResultSet rs=preparedS.executeQuery();//ejecuto la consulta.
			int id_pais_nac=0;
			if ( rs ==null){ //SI ES UN rs VACIO
				System.out.println("no hay pais con ese nombre, estoy en dbfunctions");
			}else{
				while (rs.next()){
	                id_pais_nac = rs.getInt("id_pais");
				} 
				//una vez que tengo la id del pais puedo actualizar la tabla
				String qUpdate = querys.UpdatePersona();
				PreparedStatement preparedS2 = ConnectionObject.getConnection().prepareStatement(qUpdate);
				//pongo los parametros correspondientes 
				preparedS2.setString(1,segundo_nombre);
				preparedS2.setString(2,segundo_apellido);
				preparedS2.setString(3,sexo);
				preparedS2.setString(4,estado_civil);
				preparedS2.setString(5,email);
				preparedS2.setString(6,ocupacion);
				preparedS2.setString(7,motivo_contacto);
				preparedS2.setString(8,fecha_reside);
				preparedS2.setString(9,direccion);
				preparedS2.setInt(10,id_pais_nac);
				preparedS2.setString(11,fecha_nac);
				preparedS2.setString(12,ciudad_nac);
				preparedS2.setString(13,ci_venezolana);
				
				preparedS2.executeUpdate();//ejecuto update
				System.out.println("Se hizo el update de la persona, estoy en dbfunctions");
				preparedS2.close();
			}//end else
			rs.close();	
			preparedS.close();					
		} catch (SQLException e) {
			System.out.println("dbFunctions.UpdatePersona: Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void InsertarTelefono(String ci_venezolana, String tel){
		ConnectionObject.initializeConnection();
		String q=querys.idPersona_por_ci_venezolana();//tengo que buscar el id de la persona 
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(q);
			preparedS.setString(1,ci_venezolana);
			ResultSet rs=preparedS.executeQuery();//ejecuto la consulta.
			int id_persona=0;
			if ( rs ==null){ //SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			}else{
				while (rs.next()){
	                id_persona= rs.getInt("id_persona");
	                System.out.println("se encontro id_persona por la cedula, estoy en dbfunctions");
				} 
			}//end else
			rs.close();	
			preparedS.close();
			
			//ahora tengo que tomar la consulta para insertar el telefono 
			PreparedStatement preparedS2 = ConnectionObject.getConnection().prepareStatement(querys.InsertarTelefono());
			 preparedS2.setInt(1, id_persona);
			 preparedS2.setString(1, tel);
			 preparedS2.executeUpdate();
			 System.out.println("se inserto el telefono");
			 
			 preparedS2.close();
			 
		} catch (SQLException e) {
			System.out.println("dbFunctions.InsertarTelefono: Error en la consulta: ");
			e.printStackTrace();
		}
	}
	
	public void UpdateDocumentos(String ci_uruguaya, String pasaporte, String fecha_carnet_salud,String ci_venezolana){
		ConnectionObject.initializeConnection();
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.UpdateDocumentos());
			preparedS.setInt(1,Integer.parseInt(ci_uruguaya));
			preparedS.setString(2, pasaporte);
			preparedS.setString(3, fecha_carnet_salud);
			preparedS.setString(4, ci_venezolana);
			preparedS.executeUpdate();
			
			preparedS.close();
			 
		} catch (SQLException e) {
			System.out.println("dbFunctions.UpdateDocumentos: Error en la consulta: ");
			e.printStackTrace();
		}
	}

}
