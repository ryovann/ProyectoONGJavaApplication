package logicaPersistencia.valueObject;

public class VO_Persona {
	//ATRIBUTOS DE TABLA PERSONA EN LA BASE DE DATOS 
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String sexo;
	private String fecha_nac;
	private String pais_nac; 
	private String ciudad_nac;
	private String estado_civil;
	private String ocupacion;
	private String direccion;
	private String fecha_reside;
	private String email;
	private String motivo_contacto;
	private String ci_venezolana;
	

	public VO_Persona(String primer_nombre, String segundo_nombre,String primer_apellido,String segundo_apellido,String sexo,
			String fecha_nac,String pais_nac,String ciudad_nac,String estado_civil,String ocupacion,String direccion,
			String fecha_reside,String email,String motivo_contacto, String ci_venezolana){
		
		this.primer_nombre= primer_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_nombre = segundo_nombre;
		this.segundo_apellido = segundo_apellido;
		this.sexo = sexo;
		this.fecha_nac = fecha_nac;
		this.pais_nac=pais_nac;
		this.ciudad_nac = ciudad_nac;
		this.estado_civil = estado_civil;
		this.ocupacion = ocupacion;
		this.direccion = direccion;
		this.fecha_reside = fecha_reside;
		this.email = email;
		this.motivo_contacto= motivo_contacto;
		this.ci_venezolana=ci_venezolana;
	}
	public VO_Persona(String primer_nombre, String segundo_nombre, String primer_apellido,
			String segundo_apellido, String sexo, String estado_civil, String email, String ocupacion,
			String motivo_contacto, String reside_desde, String domicilio, String id_pais_nac, String fecha_nac,
			String ciudad_nac){
		
		this.primer_nombre= primer_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_nombre = segundo_nombre;
		this.segundo_apellido = segundo_apellido;
		this.sexo = sexo;
		this.fecha_nac = fecha_nac;
		this.pais_nac=pais_nac;
		this.ciudad_nac = ciudad_nac;
		this.estado_civil = estado_civil;
		this.ocupacion = ocupacion;
		this.direccion = direccion;
		this.fecha_reside = fecha_reside;
		this.email = email;
		this.motivo_contacto= motivo_contacto;
	}


	public String getPrimer_nombre() {
		return primer_nombre;
	}


	public String getSegundo_nombre() {
		return segundo_nombre;
	}


	public String getPrimer_apellido() {
		return primer_apellido;
	}


	public String getSegundo_apellido() {
		return segundo_apellido;
	}


	public String getSexo() {
		return sexo;
	}


	public String getFecha_nac() {
		return fecha_nac;
	}


	public String getPais_nac() {
		return pais_nac;
	}


	public String getCiudad_nac() {
		return ciudad_nac;
	}


	public String getEstado_civil() {
		return estado_civil;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getFecha_reside() {
		return fecha_reside;
	}


	public String getEmail() {
		return email;
	}


	public String getMotivo_contacto() {
		return motivo_contacto;
	}
	
	public String getCi_venezolana() {
		return ci_venezolana;
	}
}
