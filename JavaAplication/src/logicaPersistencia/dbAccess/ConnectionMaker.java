package logicaPersistencia.dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker {
	private Connection con;
	private String url;
	private String username;
	private String password;
	private String driver;
	private boolean correctConnection = false;
	public ConnectionMaker(String driver, String url, String username, String password){
		//Constructor para inicializar los atributos de la clase
		super();
		//Inicializo los parametros de conexion al servidor de base de datos
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public void initializeConnection(){
		//Metodo que crea la conexion
		try {
			Class.forName(driver);//Cargo el driver en memoria
			con = DriverManager.getConnection(url,username,password);//Creo la conexion
			//---------------------------------------------------------
			System.out.println("ConnectionMaker.initializeConnection: Se inicializo una conexion");
			//---------------------------------------------------------
			correctConnection = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		//Metodo que me permie usar la conexion creada anteriormente
		if(correctConnection){
			return con;
			//Devuelvo la conexion si fue creada con exito
		}else{
			return null;
		}
	}
	public int closeConnection(){
		if(correctConnection){
			try {
				con.close();
				//---------------------------------------------------------
				System.out.println( "ConnectionMaker.closeConnection: Conexion terminada con exito");
				//---------------------------------------------------------
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//---------------------------------------------------------
			System.out.println("ConnectionMaker.closeConnection: No hay ninguna conexion establecida actualmene");
			//---------------------------------------------------------
		}
		return 0;
	}

}
