package logicaPersistencia.dbAccess;

public class QueryStore {
	public String select_NuevosUsuarios_Lista__CIVenezolana(){
		//String de consulta
		//Permite obtener una lista de los nuevos usuarios registrados
		//Utilizando la cedula venezolana como criterio de busqueda
		String query = "SELECT P.id_persona,ci_venezolana, primer_nombre, primer_apellido, motivo_contacto FROM PERSONA P INNER JOIN DOCUMENTOS D ON D.ID_PERSONA = P.ID_PERSONA WHERE P.ESTADO = 0 AND D.CI_VENEZOLANA = (?)";
		return query;
	}
	
	public String select_NuevosUsuarios_Lista__NombreApellido(){
		//String de consulta
		//Permite obtener una lista de los nuevos usuarios registrados
		//Utilizando el nombre y apellido como criterio de busqueda
		String query = "SELECT P.id_persona,ci_venezolana, primer_nombre, primer_apellido, motivo_contacto FROM PERSONA P INNER JOIN DOCUMENTOS D ON D.ID_PERSONA = P.ID_PERSONA WHERE P.ESTADO = 0 AND CONCAT(PRIMER_NOMBRE,' ',PRIMER_APELLIDO) LIKE (?)";
		return query;
	}
	
	public String buscar_pais_por_nombre(){
		String query ="SELECT id_pais FROM paises WHERE nombre_pais=(?)";
		return query;
	}
	
	public String UpdatePersona(){
		String query="UPDATE persona as p INNER JOIN documentos d on p.id_persona=d.id_persona"
				+ "SET segundo_nombre=(?), segundo_apellido=(?), sexo=(?),estado_civil=(?),"
				+ "email=(?), ocupacion=(?), motivo_contacto=(?), "
				+ "estado=0,reside_desde = (?),domicilio=(?), id_pais_nac=(?), "
				+ "fecha_nac =(?),ciudad_nac =(?)"
				+ "WHERE ci_venezolana =(?)";
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
		String query ="update documentos d set ci_uruguaya=(?), pasaporte=(?), carnet_salud=(?) where d.ci_venezolana=(?)";
		return query;
	}
}
