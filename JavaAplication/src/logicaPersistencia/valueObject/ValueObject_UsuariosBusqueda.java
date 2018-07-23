package logicaPersistencia.valueObject;

public class ValueObject_UsuariosBusqueda {
	//ValueObject que contiene los datos y el tipo de la busqueda
	//Este ValueObject Sera usado para realizar la busqueda en la bd
	private int type; //tipo de busqueda
	private String value; //Criterio de busqueda
	private int typeOfSearch;
	public ValueObject_UsuariosBusqueda(int typeOfSearch, int type, String value){
		this.type = type;
		this.value = value;
		this.typeOfSearch = typeOfSearch;
	}	
	public int getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	public int getTypeOfSearch(){
		return typeOfSearch;		
	}
	
}