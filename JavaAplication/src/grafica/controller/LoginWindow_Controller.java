package grafica.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import grafica.window.MainWindow;

public class LoginWindow_Controller {
	private static LoginWindow_Controller instancia =null;
	private LoginWindow_Controller(){};
	public static LoginWindow_Controller getInstancia(){
		if (instancia == null){
			instancia= new LoginWindow_Controller();
		}
		return instancia;
	}
	public boolean ingresarBtnAcction(String pass) {
		String storedPassword = obtainConfiguredPassword();
		if (pass.equals(storedPassword)) {
			MainWindow ventanaPrincipal = new MainWindow();
			ventanaPrincipal.setLocationRelativeTo(null);
			ventanaPrincipal.setVisible(true);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "¡¡Contraseña incorrecta!!\n Inténtalo nuevamente");
			return false;
		}
	}
	public String obtainConfiguredPassword() {
		// this method will return the password stored and preconfigured in the
		// configuration
		String filePath = "config/config.params";
		Properties data = new Properties();
		String stringToBeReturned= "";
		try {
			data.load(new FileInputStream(filePath));
			stringToBeReturned = data.getProperty("p");
			return stringToBeReturned;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar archivo de configuración en IngresarBtnAcction");
			e.printStackTrace();
			return "";
		}

		
	}
}
