package grafica.controller;

import java.util.HashMap;

import logicaPersistencia.facade.Facade;
import logicaPersistencia.valueObject.VO_Documentos;

public class VerInformacion_Controller {
	private static VerInformacion_Controller instancia = null;
	
	private VerInformacion_Controller(){};
	
	public static VerInformacion_Controller getIntancia(){
		
		if (instancia == null){
			instancia= new VerInformacion_Controller();
		}
		return instancia;
		
	}
	
	public HashMap<String,String> Datos_Persona(String string){
		VO_Documentos vod = new VO_Documentos(string);
		Facade f = new Facade();
		HashMap<String,String> datos = f.Datos_Persona(vod);
		return datos;
	}
}
