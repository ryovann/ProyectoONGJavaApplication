package grafica.controller;

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
}
