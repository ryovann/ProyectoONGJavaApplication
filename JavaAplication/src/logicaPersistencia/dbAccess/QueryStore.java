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
		String query = "INSERT INTO DOCUMENTOS(id_persona,ci_venezolana,ci_uruguaya,pasaporte,carnet_salud) values (?,?,?,?)";
		return query;
		//esto esta bien
	}
	
}
