package grafica.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import grafica.window.FormularioRegistro;
import grafica.window.TableModel;
import grafica.window.VerInformacion;
import logicaPersistencia.facade.Facade;
import logicaPersistencia.valueObject.ValueObject_UsuariosBusqueda;

public class MainWindow_Controller {
	public static MainWindow_Controller instancia =null;
	private MainWindow_Controller(){};
	public static MainWindow_Controller getInstancia(){
		if (instancia == null){
			instancia= new MainWindow_Controller();
		}
		return instancia;
	}
	 public DefaultTableModel btnBuscarFunction(int typeOfSearch, int queryType, String value) {
			// queryType es un int que se utiliza para identificar
			// si se utilizo la cedula venezolana o otro criterio
			//columnNames guarda los nombres de las columnas a mostrar en la tabla
			String[] columnNames = { "Cedula venezolana", "Primer nombre", "Apellido", "Motivo de Contacto" };
			//Creo una tabla default a la cual no le agrego filas pero si columnas, las cuales esatn en ColumnNames
			DefaultTableModel model = new TableModel(null, columnNames);
			//Creo un array que guardara temporalmente los datos que van a ser agregados a el modelo
			String[] rows = new String[4];
			//Si los datos son del tipo correcto se ejecuta el bloque if
			if (verifyInteger(value, queryType)) {
				// este objeto guarda los datos y se pasan a facade
				
				ValueObject_UsuariosBusqueda valueObject = new ValueObject_UsuariosBusqueda(typeOfSearch, queryType, value);
				
				// ---------------------------------------------------------
				System.out.println("MainWindow_Controller.btnBuscarFunction: Se creo un objectValue");
				// ---------------------------------------------------------

				// ---------------------------------------------------------
				System.out.println("MainWindow_Controller.btnBuscarFunction: Se crea una nueva instancia de Facade y se intenta obtener configuracion");
				// ---------------------------------------------------------
				Facade facade = new Facade();
				ResultSet recivedData;//objeto que guardara la informacion obtenida de la base de datos
				// ---------------------------------------------------------
				System.out.println("MainWindow_Controller.btnBuscarFunction: Se llamo a facade.UsuariosNuevosBusqueda");
				// ---------------------------------------------------------
				recivedData = facade.UsuariosNuevosBusqueda_Function(valueObject);
				// ---------------------------------------------------------
				System.out.println("MainWindow_Controller.btnBuscarFunction: Datos recibidos correctamente desde Facade.UsuariosNuevosBusqueda_Function");
				// ---------------------------------------------------------
				try {
					while (recivedData.next()) {
						//Inicio creacion de fila con datos de usuario
						rows[0] = recivedData.getString("ci_venezolana");
						rows[1] = recivedData.getString("primer_nombre");
						rows[2] = recivedData.getString("primer_apellido");
						rows[3] = recivedData.getString("motivo_contacto");
						//termino creacion de fila con datos de usuario
						model.addRow(rows);//Agrego la fila al modelo
						
					}
					return model;//Retorno modelo de tabla
				} catch (SQLException e) {
					e.printStackTrace();
					return new DefaultTableModel();
				}
			}else{
				return new DefaultTableModel();
			}
		}
	public boolean verifyInteger(String value, int queryType) {
		boolean partialResult = false;
		try {
			Integer.parseInt(value);
			partialResult = true;
		} catch (NumberFormatException e) {
			partialResult = false;
			
		}
		if (queryType == 0 && partialResult) {
			return true;
		} else {
			if(queryType==1){
				return true;
			}else{
				JOptionPane.showMessageDialog(null, "La cédula debe ser unicamente numerica\nSin puntos ni guiones");
				return false;
			}
		}
	}
	public void btnContinuarRegistroFunction(int ciVenezolana, String primerNombre, String primerApellido, String motivoContacto){
		FormularioRegistro formRegistro = new FormularioRegistro(1);
		formRegistro.RellenarFormularioFromContinuarRegistro(ciVenezolana,primerNombre,primerApellido,motivoContacto);
		formRegistro.setLocationRelativeTo(null);
		formRegistro.setVisible(true);
	}
	
	
	public void usuariosAgregarUsuarioMenuItem(){
		FormularioRegistro formRegistro = new FormularioRegistro(0);
		formRegistro.setLocationRelativeTo(null);
		formRegistro.setVisible(true);
	}
	public void MostrarInformacionDeUsuario(int ciVenezolana, String primerNombre, String primerApellido, String motivoContacto){
		VerInformacion ventanaInformacion = new VerInformacion(ciVenezolana,primerNombre,primerApellido,motivoContacto);
		ventanaInformacion.setLocationRelativeTo(null);
		ventanaInformacion.setVisible(true);
		
	}
	public void eliminarUsuario(int cedulaVenezolana, String primerNombre, String primerApellido){
		int question = JOptionPane.showOptionDialog(null, "Realmente desea eliminar de los registros a: "+primerNombre+" "+primerApellido+"?", "Pregunta", 0,JOptionPane.YES_NO_OPTION, null, null, null);
		System.out.println(question);
		
		
		
		
		
		
	}
	
}
