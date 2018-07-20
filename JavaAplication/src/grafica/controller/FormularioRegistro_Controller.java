package grafica.controller;

import logicaPersistencia.facade.Facade;
import logicaPersistencia.valueObject.VO_Documentos;
import logicaPersistencia.valueObject.VO_Formacion_Academica;
import logicaPersistencia.valueObject.VO_Persona;
import logicaPersistencia.valueObject.VO_telefonos_Persona;

public class FormularioRegistro_Controller {
	//SINGLETON
	public static FormularioRegistro_Controller instancia = null;
	
	private FormularioRegistro_Controller(){};
	
	public static FormularioRegistro_Controller getIntancia(){
		
		if (instancia == null){
			instancia= new FormularioRegistro_Controller();
		}
		return instancia;
		
	}
	
	public void UpdatePersona(String primer_nombre, String segundo_nombre,String primer_apellido,String segundo_apellido,String sexo,String dia_nac,
	String mes_nac,String anio_nac,String pais_nac,String ciudad_nac,String estado_civil,String ocupacion,String direccion,String dia_reside,
	String mes_reside,String anio_reside,String email,String motivo_contacto,String ci_venezolana ){
		
		String fecha_nacimiento = anio_nac+"-"+mes_nac+"-"+dia_nac;
		String fecha_reside =  anio_reside+"-"+mes_reside+"-"+dia_reside;
		VO_Persona vop= new VO_Persona(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,sexo,
						fecha_nacimiento,pais_nac,ciudad_nac,estado_civil,ocupacion,direccion, fecha_reside,
						email,motivo_contacto,ci_venezolana);
		Facade f = new Facade();
		f.UpdatePersona(vop);
	}
	
	public void InsertarTelefono(String ci_venezolana,String tel1,String tel2){
		
		VO_telefonos_Persona votp= new VO_telefonos_Persona(ci_venezolana, tel1);
		Facade f = new Facade();
		f.InsertarTelefono(votp);
	}
	
	public void UpdateDocumentos(String ci_uruguaya,String pasaporte, String dia, String mes, String anio,String ci_venezolana){
		String fecha_carnet_salud = anio+"-"+mes+"-"+dia;
		VO_Documentos vod= new VO_Documentos(ci_uruguaya,pasaporte,fecha_carnet_salud,ci_venezolana);
		Facade f= new Facade();
		f.UpdateDocumentos(vod);
	}
	
	public void InsertarFormacion_Academica(String nivel_escolar,int completado,String ci_venezolana){
		VO_Formacion_Academica vofa= new VO_Formacion_Academica(nivel_escolar,completado,ci_venezolana);
		Facade f= new Facade();
		f.InsertarFormacion_Academica(vofa);
	}
}
