package grafica.window;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import grafica.controller.LoginWindow_Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\img\\logo_veneguaya.png"));
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Ingresar - Manos Veneguayas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 377);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarAlSistema = new JLabel("Ingresar al sistema");
		lblIngresarAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarAlSistema.setFont(new Font("Arial", Font.BOLD, 16));
		lblIngresarAlSistema.setBounds(65, 181, 170, 33);
		contentPane.add(lblIngresarAlSistema);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new String(txtPassword.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "¡¡Debes ingresar una contraseña!!","ERROR de login",JOptionPane.ERROR_MESSAGE);
				}else{
					LoginWindow_Controller controller = LoginWindow_Controller.getInstancia();
					boolean returnedValue = controller.ingresarBtnAcction(new String(txtPassword.getPassword()));
					if(returnedValue){
						setVisible(false);
					}
				}
				
			}
		});
		btnNewButton.setBackground(new Color(240,240,240));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(65, 256, 170, 33);
		
		
		contentPane.add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(65, 225, 170, 20);
		contentPane.add(txtPassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(65, 50, 170, 120);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		File archivoImagen = new File("resources/img/logo_veneguaya.png");
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setIcon(new ImageIcon(archivoImagen.getPath()));
		
		
		
	
		
		
		
	}
}
