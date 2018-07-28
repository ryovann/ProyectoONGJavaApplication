package grafica.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

import logicaPersistencia.facade.Facade;

public class Listados_Controller {
	
	//SINGLETON
		private static Listados_Controller instancia = null;
		
		private Listados_Controller(){};
		
		public static Listados_Controller getIntancia(){
			
			if (instancia == null){
				instancia= new Listados_Controller();
			}
			return instancia;
			
		}
	public DefaultComboBoxModel ObtenerPaises(){
		//Funcion que retorna un ComboBoxModel con una lista de paises
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Se crea una nueva instancia de facade y se intenta obtener la configuracion");
		// ---------------------------------------------------------
		Facade facade = new Facade();
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Se llamo a facade.ListarPaises_Function");
		// ---------------------------------------------------------
		ResultSet recivedData = facade.ListarPaises_Function();
		// ---------------------------------------------------------
		System.out.println("FormularioRegistro_Controller.ObtenerPaises: Datos recibidos correctamente desde Facade.ListarPaises_Function");
		// ---------------------------------------------------------
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		try {
			while(recivedData.next()){
				modelo.addElement(recivedData.getString("nombre_pais"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
		}

}
