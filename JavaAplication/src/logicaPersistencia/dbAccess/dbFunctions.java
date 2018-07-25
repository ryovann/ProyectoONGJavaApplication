package logicaPersistencia.dbAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class dbFunctions {
	// Esta clase contiene todos los metodos que permitiran
	// Insertar datos en la base de datos
	private QueryStore querys = new QueryStore();// Objeto que contiene todas
													// las consultas
	private ConnectionMaker ConnectionObject;

	public dbFunctions(String[] config) {
		// El array config contiene todos los parametros para la conexion a la
		// base de datos
		// Estos parametros se configuran en facade

		// ---------------------------------------------------------
		System.out.println("dbFunctions: Comienza intento de inicializar ConnectionObject");
		// ---------------------------------------------------------

		ConnectionObject = new ConnectionMaker(config[0], config[1], config[2], config[3]);

		// ---------------------------------------------------------
		System.out.println("dbFunctions: ConnectionObject Inicializado correctamente");
		// ---------------------------------------------------------
		// En la linea anterior inicializo el objeto ConnectionObject el cual
		// permite
		// Realizar la conexion con la base de datos
	}

	public ResultSet listarUsuarios(int typeOfSearch, int type, String value) {
		ConnectionObject.initializeConnection();// Inicializo la conexion

		if (type == 0) {
			// Aqui debo programar la consulta cuando
			// el parametro de busqueda sea la cedula venezolana

			try {
				// Creo el objecto PreparedStatement para poder realizar la
				// consulta
				PreparedStatement preparedS = ConnectionObject.getConnection()
						.prepareStatement(querys.select_Lista__CIVenezolana());
				// Seteo el parametro de cedula venezolana al valor que es
				// pasado por parametro
				preparedS.setInt(1, typeOfSearch);
				preparedS.setInt(2, Integer.parseInt(value));
				ResultSet rs;// objeto resultset que guardara los datos
				// ---------------------------------------------------------
				System.out.println("dbFunctions.ListarUsuarios: Realizando consulta a la base de datos");
				// ---------------------------------------------------------
				rs = preparedS.executeQuery();// ejecuto la consulta.
				// ---------------------------------------------------------
				System.out.println("dbFuncions.ListarUsuarios: Consulta realizada con exito");
				// ---------------------------------------------------------
				return rs;
			} catch (SQLException e) {
				System.out.println("dbFunctions.ListarUsuarios: Error en la consulta: ");
				e.printStackTrace();
			}
		} else {
			// Debo programar la consulta para el segundo tipo de parametro
			try {
				// Creo el objecto PreparedStatement para poder realizar la
				// consulta
				PreparedStatement preparedS = ConnectionObject.getConnection()
						.prepareStatement(querys.select_Lista__NombreApellido());
				// Seteo el parametro de nombre y apellido al valor que es
				// pasado por parametro
				preparedS.setInt(1, typeOfSearch);
				preparedS.setString(2, "%" + value + "%");
				ResultSet rs;// objeto resultset que guardara los datos
				// ---------------------------------------------------------
				System.out.println("dbFunctions.ListarUsuarios: Realizando consulta a la base de datos");
				// ---------------------------------------------------------
				rs = preparedS.executeQuery();// ejecuto la consulta.
				// ---------------------------------------------------------
				System.out.println("dbFuncions.ListarUsuarios: Consulta realizada con exito");
				// ---------------------------------------------------------
				return rs;
			} catch (SQLException e) {
				System.out.println("dbFunctions.ListarUsuarios: Error en la consulta: ");
				e.printStackTrace();
			}

		}
		return null;

	}

	public void UpdatePersona(String primer_nombre, String segundo_nombre, String primer_apellido,
			String segundo_apellido, String sexo, String fecha_nac, String pais_nac, String ciudad_nac,
			String estado_civil, String ocupacion, String direccion, String fecha_reside, String email,
			String motivo_contacto, String ci_venezolana) {

		ConnectionObject.initializeConnection();// Inicializo la conexion
		String qpaisNac = querys.buscar_pais_por_nombre();// tengo que buscar el
															// id del pais

		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(qpaisNac);
			// Seteo el parametro del nombre del pais al valor que es pasado por
			// parametro
			preparedS.setString(1, pais_nac);
			ResultSet rs = preparedS.executeQuery();// ejecuto la consulta.
			int id_pais_nac = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay pais con ese nombre, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_pais_nac = rs.getInt("id_pais");
				}
				// una vez que tengo la id del pais puedo actualizar la tabla
				String qUpdate = querys.UpdatePersona();
				PreparedStatement preparedS2 = ConnectionObject.getConnection().prepareStatement(qUpdate);
				// pongo los parametros correspondientes
				preparedS2.setString(1, segundo_nombre);
				preparedS2.setString(2, segundo_apellido);
				preparedS2.setString(3, sexo);
				preparedS2.setString(4, estado_civil);
				preparedS2.setString(5, email);
				preparedS2.setString(6, ocupacion);
				preparedS2.setString(7, motivo_contacto);
				preparedS2.setString(8, fecha_reside);
				preparedS2.setString(9, direccion);
				preparedS2.setInt(10, id_pais_nac);
				preparedS2.setString(11, fecha_nac);
				preparedS2.setString(12, ciudad_nac);
				preparedS2.setString(13, ci_venezolana);

				preparedS2.executeUpdate();// ejecuto update
				System.out.println("Se hizo el update de la persona, estoy en dbfunctions");
				preparedS2.close();
			} // end else
			rs.close();
			preparedS.close();
		} catch (SQLException e) {
			System.out.println("dbFunctions.UpdatePersona: Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void InsertarTelefono(String ci_venezolana, String tel) {
		ConnectionObject.initializeConnection();
		String q = querys.idPersona_por_ci_venezolana();// tengo que buscar el
														// id de la persona
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(q);
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();// ejecuto la consulta.
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula, estoy en dbfunctions");
				}
			} // end else
			rs.close();
			preparedS.close();

			// ahora tengo que tomar la consulta para insertar el telefono
			PreparedStatement preparedS2 = ConnectionObject.getConnection().prepareStatement(querys.InsertarTelefono());
			preparedS2.setInt(1, id_persona);
			preparedS2.setString(2, tel);
			preparedS2.executeUpdate();
			System.out.println("se inserto el telefono");

			preparedS2.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.InsertarTelefono: Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void UpdateDocumentos(String ci_uruguaya, String pasaporte, String fecha_carnet_salud,
			String ci_venezolana) {
		ConnectionObject.initializeConnection();
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.UpdateDocumentos());
			preparedS.setInt(1, Integer.parseInt(ci_uruguaya));
			preparedS.setString(2, pasaporte);
			if (fecha_carnet_salud.equals("null-null-null")) {
				preparedS.setString(3, null);
			} else {
				preparedS.setString(3, fecha_carnet_salud);
			}
			preparedS.setString(4, ci_venezolana);
			preparedS.executeUpdate();
			System.out.println("Se insertaron los documentos ");
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.UpdateDocumentos: Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void InsertarFormacion_Academica(String nivel, int completado, String ci_venezolana) {
		ConnectionObject.initializeConnection();
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection()
					.prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula, estoy en dbfunctions");
				}
				// una ve que tengo la id de la persona puedo insertar en la
				// tabla formacion_academica
				PreparedStatement preparedS2 = ConnectionObject.getConnection()
						.prepareStatement(querys.InsertarFormacion_Academica());
				preparedS2.setInt(1, id_persona);
				preparedS2.setString(2, nivel);
				preparedS2.setInt(3, completado);
				preparedS2.executeUpdate();
				System.out.println("se inserto la formacion academica, estoy en dbFunctions");
			} // end else
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.InsertarFormacion_Academica: Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void InsertarTiene_profesion(int id_titulo, int homologacion, String ci_venezolana) {
		ConnectionObject.initializeConnection();
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection()
					.prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula, estoy en dbfunctions");
				}
				PreparedStatement preparedS2 = ConnectionObject.getConnection()
						.prepareStatement(querys.InsertarProfesion());
				preparedS2.setInt(1, id_persona);
				preparedS2.setInt(2, id_titulo);
				preparedS2.setInt(3, homologacion);
				preparedS2.executeUpdate();
				System.out.println("se inserto la profesion, estoy en dbFunctions");
			} // end else
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.InsertarProfesion(): Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public void Insertar_familia_persona(String ci_venezolana, String vive_con, String detalle, int vino_con,
			int cant_hijos, int hijos_exterior) {
		ConnectionObject.initializeConnection();
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection()
					.prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula, estoy en dbfunctions");
				}
				if (detalle != null) {
					vive_con = vive_con + ": " + detalle;
				}
				PreparedStatement preparedS2 = ConnectionObject.getConnection()
						.prepareStatement(querys.InsertarFamilia_Persona());
				preparedS2.setInt(1, id_persona);
				preparedS2.setString(2, vive_con);
				preparedS2.setInt(3, vino_con);
				preparedS2.setInt(4, cant_hijos);
				preparedS2.setInt(5, hijos_exterior);
				preparedS2.executeUpdate();
				System.out.println("se inserto situacion familiar, estoy en dbFunctions");
			} // end else
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.InsertarFamilia_Persona(): Error en la consulta: ");
			e.printStackTrace();
		}
	}

	public ResultSet ListarPaises() {
		ConnectionObject.initializeConnection();
		String query = querys.select_ListaPaises();
		ResultSet rs;

		try {
			Statement stmt = ConnectionObject.getConnection().createStatement();
			// ---------------------------------------------------------
			System.out.println("dbFunctions.ListarPaises: Realizando consulta a la base de datos");
			// ---------------------------------------------------------
			rs = stmt.executeQuery(query);// Ejecuto la consulta
			// ---------------------------------------------------------
			System.out.println("dbFuncions.ListarPaises: Consulta realizada con exito");
			// ---------------------------------------------------------
			return rs;
		} catch (SQLException e) {
			System.err.println("dbFunctions.ListarPaises: Error en la consulta");
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet ListarIdiomas() {
		ConnectionObject.initializeConnection();
		String query = querys.select_ListarIdiomas();
		ResultSet rs;

		try {
			Statement stmt = ConnectionObject.getConnection().createStatement();
			// ---------------------------------------------------------
			System.out.println("dbFunctions.ListarIdiomas: Realizando consulta a la base de datos");
			// ---------------------------------------------------------
			rs = stmt.executeQuery(query);// Ejecuto la consulta
			// ---------------------------------------------------------
			System.out.println("dbFuncions.ListarIdiomas: Consulta realizada con exito");
			// ---------------------------------------------------------
			return rs;
		} catch (SQLException e) {
			System.err.println("dbFunctions.ListarIdiomas: Error en la consulta");
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet ListarProfesiones() {
		ConnectionObject.initializeConnection();
		String query = querys.select_ListarProfesiones();
		ResultSet rs;

		try {
			Statement stmt = ConnectionObject.getConnection().createStatement();
			// ---------------------------------------------------------
			System.out.println("dbFunctions.ListarProfesiones: Realizando consulta a la base de datos");
			// ---------------------------------------------------------
			rs = stmt.executeQuery(query);// Ejecuto la consulta
			// ---------------------------------------------------------
			System.out.println("dbFuncions.ListarProfesiones: Consulta realizada con exito");
			// ---------------------------------------------------------
			return rs;
		} catch (SQLException e) {
			System.err.println("dbFunctions.ListarProfesiones: Error en la consulta");
			e.printStackTrace();
			return null;
		}
	}

	public void InsertarIdiomaPersona(String idioma, String nivel, String ci_venezolana) {
		ConnectionObject.initializeConnection();
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection()
					.prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0, id_idioma = 0;
			if (rs == null) {
				System.err.println("dbFunctions.insertarIdiomaPersona: No hay una persona con esa cedula");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					// Se guarda la persona en la variable
				}

				rs = null;
				preparedS = ConnectionObject.getConnection().prepareStatement(querys.id_idioma_por_nombre());
				preparedS.setString(1, idioma);
				rs = preparedS.executeQuery();
				while (rs.next()) {
					id_idioma = rs.getInt("id_idioma");
					// Se guarda el id_idioma en la variable
				}
				rs.close();
				preparedS = ConnectionObject.getConnection().prepareStatement(querys.InsertarIdiomaPersona());
				preparedS.setInt(1, id_persona);
				preparedS.setInt(2, id_idioma);
				preparedS.setString(3, nivel);
				preparedS.executeQuery();
				System.out.println("Se inserto un idioma para una persona");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void InsertarPersona(String primer_nombre, String segundo_nombre, String primer_apellido,
			String segundo_apellido, String sexo, String estado_civil, String email, String ocupacion,
			String motivo_contacto, String reside_desde, String domicilio, String id_pais_nac, String fecha_nac,
			String ciudad_nac) {
		
		//se debe programar el insert de persona

	}
	
	public HashMap<String,String> Datos_Persona(String ci_venezolana){
		ConnectionObject.initializeConnection();
		HashMap<String,String> datos = null;
		try {
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_venezolana);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0, id_idioma = 0;
			if (rs == null) {
				System.err.println("dbFunctions.Datos_Persona: No hay una persona con esa cedula");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					// Se guarda la persona en la variable
					System.out.println("dbFunctions.Datos_Persona: se encontro a la persona por la cedula venezolana");
				}
				rs=null;
				preparedS = ConnectionObject.getConnection().prepareStatement(querys.Obtener_Datos_Persona());
				preparedS.setInt(1, id_persona);
				rs = preparedS.executeQuery();
				System.out.println("dbFunctions.Datos_Persona: se ejecuto obtener datos persona");
				datos = new HashMap<String, String>();
				while (rs.next()) {
					//voy obteniendo los datos e insertandolos en el HashMap, la clave es el nombre del atributo
					String segundo_nombre= rs.getString("segundo_nombre");
					System.out.println(segundo_nombre);
					//puede ser que no tenga segundo nombre
					if (segundo_nombre!=null){
						datos.put("segundo_nombre",segundo_nombre );
					}else{
						datos.put("segundo_nombre", "---");
					}
					
					String segundo_apellido = rs.getString("segundo_apellido");
					if (segundo_apellido!=null){
						datos.put("segundo_apellido",segundo_apellido);
					}else {
						datos.put("segundo_apellido","---");
					}
					
					String sexo = rs.getString("sexo");
					if(sexo!=null){
						datos.put("sexo", sexo);
					}else{
						datos.put("sexo","---");
					}
					
					String email = rs.getString("email");
					if(email!=null){
						datos.put("email",email);
					} else{
						datos.put("email","---");
					}
					
					String ocupacion = rs.getString("ocupacion");
					if(ocupacion!=null){
						datos.put("ocupacion", ocupacion);
					}else{
						datos.put("ocupacion","---");
					}
					//tengo que transformar la fecha 
					String reside_desde = rs.getString("reside_desde");
					if(reside_desde!=null){
						String[] parts = reside_desde.split("-");
						datos.put("reside_desde",parts[2]+"/"+parts[1]+"/"+parts[0]);
					}else {
						datos.put("reside_desde","---");
					}
					
					String domicilio = rs.getString("domicilio");
					if(domicilio!=null){
						datos.put("domicilio", domicilio);
					}else{
						datos.put("domicilio", "---");
					}
					
					String id_pais_nac = rs.getInt("id_pais_nac")+"";
					if (id_pais_nac.equals("")){
						datos.put("pais_nac", "---");
					}else{
						// tengo que buscar al nombre del pais 
						int id_pais = rs.getInt("id_pais_nac");
						preparedS =ConnectionObject.getConnection().prepareStatement(querys.Buscar_paisNac_por_idPais());
						preparedS.setInt(1,id_persona);
						ResultSet rs2 = preparedS.executeQuery();
						while (rs2.next()){
							String nombre_pais_nac = rs2.getString("nombre_pais");
							datos.put("pais_nac", nombre_pais_nac);
						}
						rs2.close();
					}
					
					String fecha_nac = rs.getString("fecha_nac");
					if(fecha_nac!=null){
						//tengo que transformar la fecha
						String[] parts;
						parts = fecha_nac.split("-");
						datos.put("fecha_nac", parts[2]+"/"+parts[1]+"/"+parts[0]);
					}else{
						datos.put("fecha_nac", "---");
					}
					
					String ciudad_nac = rs.getString("ciudad_nac");
					if(ciudad_nac!=null){
						datos.put("ciudad_nac", ciudad_nac);
					}else {
						datos.put("ciudad_nac", "---");
					}
					
					String estado_civil = rs.getString("estado_civil");
					if(estado_civil!=null){
						datos.put("estado_civil", estado_civil);
					}else{
						datos.put("estado_civil", "---");
					}
						
				} //end while
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;
	}
	
	public HashMap<String,String> Datos_Formacion_Academica(String ci_v){
		ConnectionObject.initializeConnection();
		HashMap<String,String> formacion_academica=null;
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_v);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula, estoy en Datos_Formacion_Academca, dbfunctions "+id_persona);
				}
				
			} // end else
			rs=null;
			preparedS = ConnectionObject.getConnection().prepareStatement(querys.Obtener_Datos_Formacion_Academica());
			preparedS.setInt(1,id_persona);
			rs = preparedS.executeQuery();
			if (rs !=null){
				formacion_academica = new HashMap<String,String>();
				while (rs.next()){
					String nivel = rs.getString("nivel");
					formacion_academica.put("nivel", nivel);
					int completado = rs.getInt("completado");
					if(completado == 0){
						formacion_academica.put("completado","completo");
					}else{
						formacion_academica.put("completado","no completo");
					}
				}
			}else{
				System.out.println("dbfunctions.Datos_Formacion_Academica(): la persona no tiene formacion academica");
			}
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.Datos_Formacion_Academica: Error en la consulta: ");
			e.printStackTrace();
		}
		return formacion_academica;
	}
	
	public HashMap<String,String> Documentos(String ci_v){
		ConnectionObject.initializeConnection();
		HashMap<String,String> documentos =null;
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_v);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula,dbFunctions.Documentos() "+id_persona);
				}
				
			} // end else
			rs=null;
			preparedS = ConnectionObject.getConnection().prepareStatement(querys.Obtener_Datos_Documentos());
			preparedS.setInt(1,id_persona);
			rs = preparedS.executeQuery();
			if (rs !=null){
				documentos = new HashMap<String,String>();
				while (rs.next()){
					String ci_uru = rs.getInt("ci_uruguaya")+"";
					if(ci_uru.equals("0")|| ci_uru==null){ // si no tiene cedula uruguaya
						documentos.put("ci_uruguaya", "---");
					}else{
						documentos.put("ci_uruguaya", ci_uru);
					}
					
					String pasaporte = rs.getString("pasaporte");
					if(pasaporte!=null){
						documentos.put("pasaporte", pasaporte);
					}else{// no tiene pasaporte 
						documentos.put("pasaporte", "---");
					}
					
					String carnet_salud = rs.getString("carnet_salud");
					if (carnet_salud!=null){
						//tengo que modificar la fecha 
						String[] parts;
						parts = carnet_salud.split("-");
						documentos.put("carnet_salud", parts[2]+"/"+parts[1]+"/"+parts[0]);
					}else{// no tiene carnet de salud 
						
						documentos.put("carnet_salud", "---");
					}
				}
			}else{
				System.out.println("dbfunctions.Documentos(): la persona no tiene formacion academica");
			}
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.Documentos(): Error en la consulta: ");
			e.printStackTrace();
		}
		return documentos;
	}
	
	public HashMap<String,String> Obtener_Profesion(String ci_v, String nivel, int completado){
		ConnectionObject.initializeConnection();
		HashMap<String,String> tiene_profesion =null;
		try {
			// consigo el id de la persona
			PreparedStatement preparedS = ConnectionObject.getConnection().prepareStatement(querys.idPersona_por_ci_venezolana());
			preparedS.setString(1, ci_v);
			ResultSet rs = preparedS.executeQuery();
			int id_persona = 0;
			if (rs == null) { // SI ES UN rs VACIO
				System.out.println("no hay persona con esa cedula venezolana, estoy en dbfunctions");
			} else {
				while (rs.next()) {
					id_persona = rs.getInt("id_persona");
					System.out.println("se encontro id_persona por la cedula,dbFunctions.Obtener_Profesion() "+id_persona);
				}
				
			} // end else
			rs=null;
			preparedS = ConnectionObject.getConnection().prepareStatement(querys.Obtener_Datos_Tiene_Profesion());
			preparedS.setInt(1,id_persona);
			rs = preparedS.executeQuery();
			if (rs !=null){
				tiene_profesion = new HashMap<String,String>();
				tiene_profesion.put("titulo", "---");
				tiene_profesion.put("homologacion", "---");
				if (completado==0){ // si esta completo
					if (nivel.equals("Terciario/Tecnica")|| nivel.equals("Grado universitario")|| nivel.equals("Postgrado universitario")){	
						while (rs.next()){
							String titulo = rs.getString("titulo");
							tiene_profesion.put("titulo", titulo);
							
							int homologacion = rs.getInt("homologacion");
							if(homologacion==1){
								tiene_profesion.put("homologacion", "Si");
							}else{
								tiene_profesion.put("homologacion", "No");
							}
						}//end while
					}//end if
				}//end if completo
			}else{
				System.out.println("dbfunctions.Obtener_profesion(): la persona no tiene formacion academica");
			}
			rs.close();
			preparedS.close();

		} catch (SQLException e) {
			System.out.println("dbFunctions.Obtener_profesion(): Error en la consulta: ");
			e.printStackTrace();
		}
		return tiene_profesion;
	}

}
