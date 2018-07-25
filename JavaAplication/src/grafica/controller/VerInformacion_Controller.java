package grafica.controller;

import java.util.HashMap;

import grafica.window.FormularioRegistro;
import logicaPersistencia.facade.Facade;
import logicaPersistencia.valueObject.VO_Documentos;
import logicaPersistencia.valueObject.VO_Formacion_Academica;

public class VerInformacion_Controller {
	private static VerInformacion_Controller instancia = null;
	
	private VerInformacion_Controller(){};
	
	public static VerInformacion_Controller getIntancia(){
		
		if (instancia == null){
			instancia= new VerInformacion_Controller();
		}
		return instancia;
		
	}
	
	public HashMap<String,String> Datos_Persona(String ci_venezolana){
		VO_Documentos vod = new VO_Documentos(ci_venezolana);
		Facade f = new Facade();
		HashMap<String,String> datos = f.Datos_Persona(vod);
		return datos;
	}
	
	public HashMap<String,String> Datos_Formacion_Academica(String ci_venezolana){
		VO_Formacion_Academica vofa = new VO_Formacion_Academica(ci_venezolana);
		Facade f = new Facade();
		HashMap<String,String> formacion_academica = f.Datos_Formacion_Academica(vofa);
		return formacion_academica;
	}
	
	public HashMap<String,String> Documentos(String ci_v){
		VO_Documentos vod = new VO_Documentos(ci_v);
		Facade f= new Facade();
		HashMap<String,String> documentos = f.Documentos(vod);
		return documentos;
	}
	
	public HashMap<String,String> Obtener_Profesion(String ci_v,String nivel, String completado){
		int comp =0;
		if (completado.equals("completo")){
			comp=1;
		}
		VO_Formacion_Academica vo = new VO_Formacion_Academica(nivel,comp,ci_v);
		Facade f= new Facade();
		HashMap<String,String> tiene_profesion = f.Obtener_Profesion(vo);
		return tiene_profesion;
	}
	
	public HashMap<String,String> Obtener_tenefonos(String ci_v){
		VO_Documentos vo= new VO_Documentos(ci_v);
		Facade f= new Facade();
		HashMap<String,String> telefonos = f.Obtener_Telefonos(vo);
		return telefonos;
	}
	
	public HashMap<String,String> Obtener_Familia_Persona (String ci_v){
		VO_Documentos vo= new VO_Documentos(ci_v);
		Facade f= new Facade();
		HashMap<String,String> familia_persona = f.Obtener_Familia_Persona(vo);
		return familia_persona;
	}
	
	public String[] Obtener_Idiomas(String ci_v){
		VO_Documentos vo= new VO_Documentos(ci_v);
		Facade f = new Facade();
		String[] idiomas = f.Obtener_Idiomas(vo);
		return idiomas;
	}
	public void modificarBoton(){
		FormularioRegistro formulario = new FormularioRegistro(1);
	}
}

