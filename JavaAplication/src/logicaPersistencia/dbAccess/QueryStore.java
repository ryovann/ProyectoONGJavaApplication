package logicaPersistencia.dbAccess;

public class QueryStore {
	public String select_Lista__CIVenezolana(){
		//String de consulta
		//Permite obtener una lista de los nuevos usuarios registrados
		//Utilizando la cedula venezolana como criterio de busqueda
		String query = "SELECT P.id_persona,ci_venezolana, primer_nombre, primer_apellido, motivo_contacto FROM PERSONA P INNER JOIN DOCUMENTOS D ON D.ID_PERSONA = P.ID_PERSONA WHERE P.ESTADO = (?) AND D.CI_VENEZOLANA = (?)";
		return query;
	}
	
	public String select_Lista__NombreApellido(){
		//String de consulta
		//Permite obtener una lista de los nuevos usuarios registrados
		//Utilizando el nombre y apellido como criterio de busqueda
		String query = "SELECT P.id_persona,ci_venezolana, primer_nombre, primer_apellido, motivo_contacto FROM PERSONA P INNER JOIN DOCUMENTOS D ON D.ID_PERSONA = P.ID_PERSONA WHERE P.ESTADO = (?) AND CONCAT(PRIMER_NOMBRE,' ',PRIMER_APELLIDO) LIKE (?)";
		return query;
	}
	public String select_ListaPaises(){
		String query = "SELECT nombre_pais from paises";
		return query;
	}
	public String select_ListarIdiomas(){
		String query = "Select nombre_idioma from idiomas";
		return query;
	}
	public String select_ListarProfesiones(){
		String query = "SELECT titulo from profesiones";
		return query;
	}
	public String buscar_pais_por_nombre(){
		String query ="SELECT id_pais FROM paises WHERE nombre_pais=(?)";
		return query;
	}
	
	public String UpdatePersona(){
		String query="UPDATE persona as p INNER JOIN documentos d on p.id_persona=d.id_persona SET segundo_nombre=(?), segundo_apellido=(?), sexo=(?),estado_civil=(?), email=(?), ocupacion=(?), motivo_contacto=(?), estado=1,reside_desde = (?),domicilio=(?), id_pais_nac=(?), fecha_nac =(?),ciudad_nac =(?) WHERE ci_venezolana =(?)";
		return query;
	}
	
	public String idPersona_por_ci_venezolana(){
		String query = "SELECT p.id_persona FROM persona p INNER JOIN documentos d ON p.id_persona= d.id_persona WHERE d.ci_venezolana=(?)";
		return query;
	}
	
	public String InsertarTelefono(){
		String query="INSERT INTO telefono_persona (id_persona,tel) VALUES ((?),(?))";
		return query;
	}
	
	public String UpdateDocumentos(){
		String query ="UPDATE documentos d SET ci_uruguaya=(?), pasaporte=(?), carnet_salud=(?) WHERE d.ci_venezolana=(?)";
		return query;
	}
	
	public String InsertarFormacion_Academica(){
		String query ="INSERT INTO formacion_academica (id_persona,nivel,completado) VALUES ((?),(?),(?))";
		return query;
	}
	
	public String InsertarProfesion(){
		String query="insert into tiene_profesion (id_persona,id_prof,homologacion) values ((?),(?),(?))";
		return query;
	}
	
	public String InsertarFamilia_Persona(){
		String query = "INSERT INTO familia_persona (id_persona,vive_con,vino_con,cantidad_hijos,cant_hijos_extranjero) VALUES ((?),(?),(?),(?),(?))";
		return query;
	}
	public String InsertarIdiomaPersona(){
		String query = "INSERT INTO sabe_idioma (id_persona,id_idioma, nivel) values (?,?,?)";
		return query;
	}
	public String id_idioma_por_nombre(){
		String query = "SELECT id_idioma from idiomas where nombre_idioma = (?)";
		return query;
	}
	public String insertPersonaNueva(){
		String query = "INSERT INTO PERSONA(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,sexo,estado_civil,email,ocupacion,motivo_contacto,estado,reside_desde,domicilio,id_pais_nac,fecha_nac,ciudad_nac) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return query;
	}
	public String insertDocumentosNuevos(){
		//Cambios aqui
		String query = "INSERT INTO DOCUMENTOS(id_persona,ci_venezolana,ci_uruguaya,pasaporte,carnet_salud) values (?,?,?,?,?)";
		return query;
		//esto esta bien
	}
	
	public String Obtener_Datos_Persona(){
		String query = "SELECT primer_nombre, segundo_nombre, primer_apellido,segundo_apellido,sexo,email,ocupacion,reside_desde,domicilio,id_pais_nac,fecha_nac,ciudad_nac,estado_civil,motivo_contacto FROM Persona WHERE id_persona = (?);";
		return query;
	}
	
	
	public String Obtener_Datos_Documentos(){
		String query = "SELECT ci_uruguaya,pasaporte,carnet_salud FROM documentos WHERE id_persona = (?);";
		return query;
	}
	
	public String Obtener_Datos_Formacion_Academica(){
		String query = "SELECT nivel,completado FROM formacion_academica f  WHERE f.id_persona= (?);";
		return query;
	}
	
	public String Obtener_Datos_Tiene_Profesion(){
		String query = "SELECT titulo,homologacion FROM tiene_profesion tp INNER JOIN profesiones p ON tp.id_prof=p.id_prof WHERE id_persona= (?);";
		return query;
	}
	
	public String Obtener_Datos_Familia_Persona(){
		String query = "SELECT  vive_con,vino_con,cantidad_hijos,cant_hijos_extranjero FROM familia_persona WHERE id_persona= (?);";
		return query;
	}
	
	public String Obtener_Telefonos_Persona(){
		String query = "SELECT tel FROM telefono_persona WHERE id_persona= (?);";
		return query;
	}
	
	public String Obtener_Idiomas(){
		String query = "SELECT nombre_idioma,nivel FROM sabe_idioma s INNER JOIN idiomas i ON s.id_idioma=i.id_idioma WHERE s.id_persona= (?);";
		return query;
	}
	
	public String Eliminar_Persona(){
		String query = "DELETE FROM persona WHERE id_persona = (?)";
		return query;
	}
	
	public String Buscar_paisNac_por_idPais(){
		String query = "SELECT p.nombre_pais FROM paises p INNER JOIN persona per ON p.id_pais=per.id_pais_nac WHERE per.id_persona = (?)";
		return query;
	}
	
	public String eliminarTelefonosPersona(){
		String query = "DELETE FROM telefono_persona where id_persona = (?)";
		return query;
	}
	public String eliminarIdiomasPersona(){
		String query = "DELETE FROM sabe_idioma where id_persona = (?)";
		return query;
	}
	public String eliminarFamiliaPersona(){
		String query = "DELETE FROM familia_persona where id_persona = (?)";
		return query;
	}
	public String eliminarFormacionAcademica(){
		String query = "DELETE FROM formacion_academica where id_persona = (?)";
		return query;
	}
	public String eliminarTieneProfesion(){
		String query = "DELETE FROM tiene_profesion where id_persona = (?)";
		return query;
	}

	

	

	


	
}
