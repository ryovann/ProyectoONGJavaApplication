package grafica.controller;

import java.util.HashMap;

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
}
