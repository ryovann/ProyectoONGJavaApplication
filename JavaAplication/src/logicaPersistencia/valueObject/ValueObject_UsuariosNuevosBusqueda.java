package logicaPersistencia.valueObject;

public class ValueObject_UsuariosNuevosBusqueda {
	//ValueObject que contiene los datos y el tipo de la busqueda
	//Este ValueObject Sera usado para realizar la busqueda en la bd
	private int type; //tipo de busqueda
	private String value; //Criterio de busqueda
	public ValueObject_UsuariosNuevosBusqueda(int type, String value){
		this.type = type;
		this.value = value;
	}	
	public int getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	
}
