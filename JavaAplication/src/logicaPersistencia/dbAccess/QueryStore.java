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
	
}
