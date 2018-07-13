package grafica.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginWindow_Controller {
	public boolean ingresarBtnAcction(String pass) {
		System.out.println("Recived text: " + pass);
		String storedPassword = obtainConfiguredPassword();
		System.out.println(storedPassword);
		if (pass.equals(storedPassword)) {
			return true;
		} else {
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
