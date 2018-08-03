package grafica.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import grafica.controller.Listados_Controller;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listados extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listados frame = new Listados();
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
	public Listados() {
		setResizable(false);
		setTitle("Generador de listados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBounds(10, 11, 664, 74);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		JLabel lblSeleccionarCriterioDe = new JLabel("Seleccionar criterio de busqueda");
		lblSeleccionarCriterioDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccionarCriterioDe.setBounds(10, 11, 256, 14);
		panelBusqueda.add(lblSeleccionarCriterioDe);
		

		
		JLabel lblBusqueda = new JLabel("Texto de la busqueda");
		lblBusqueda.setBounds(10, 44, 199, 14);
		panelBusqueda.add(lblBusqueda);
		
		Listados_Controller controlador = Listados_Controller.getIntancia();
		
		
		txtBusquedaTexto = new JTextField();
		
		txtBusquedaTexto.setBounds(276, 41, 246, 20);
		panelBusqueda.add(txtBusquedaTexto);
		txtBusquedaTexto.setColumns(10);
		
		JComboBox cmbCriterioBusqueda = new JComboBox();
		cmbCriterioBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Nombre y apellido", "Edad", "Pais de Origen"}));
		cmbCriterioBusqueda.setBounds(276, 10, 199, 20);
		panelBusqueda.add(cmbCriterioBusqueda);
		
		JLabel lblAnios = new JLabel("A\u00F1os");
		lblAnios.setVisible(false);
		lblAnios.setBounds(366, 44, 46, 14);
		panelBusqueda.add(lblAnios);
		
		JComboBox cmbPaisDeOrigen = new JComboBox();
		cmbPaisDeOrigen.setBounds(276, 41, 199, 20);
		panelBusqueda.add(cmbPaisDeOrigen);
		cmbPaisDeOrigen.setVisible(false);
		cmbPaisDeOrigen.setModel(controlador.ObtenerPaises());
		
		txtBusquedaTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(cmbCriterioBusqueda.getSelectedIndex()==1){
					String data = String.valueOf(e.getKeyChar());
					if(!verificarInteger(data)){
						e.consume();
					}
				}
				
				
			}
		});
		
	
		JButton btnExportarListado = new JButton("Exportar listado");
		btnExportarListado.setBounds(552, 90, 122, 23);
		contentPane.add(btnExportarListado);
		btnExportarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listados_Controller controlador = Listados_Controller.getIntancia();
				int type = 0;
				if(cmbCriterioBusqueda.getSelectedIndex()==0){
					if(txtBusquedaTexto.getText().equals("")){
						type = 0;
						controlador.generarReporte(type,"");
					}else{
						type = 1;
						controlador.generarReporte(type,txtBusquedaTexto.getText());
					}
				}else if(cmbCriterioBusqueda.getSelectedIndex()==1){
					//Criterio de edad
					type=2;
					if(txtBusquedaTexto.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Error de edad: Se debe ingresar una edad valida","ERROR DE EDAD",JOptionPane.ERROR_MESSAGE);
						
					}else{
						if(verificarInteger(txtBusquedaTexto.getText())){
							controlador.generarReporte(type,txtBusquedaTexto.getText());
						}else{
							JOptionPane.showMessageDialog(null, "Error de edad: La edad no puede contener texto","ERROR DE EDAD",JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				}else if(cmbCriterioBusqueda.getSelectedIndex()==2){
					//Criterio de pais
					type=3;
					controlador.generarReporte(type,cmbPaisDeOrigen.getSelectedItem().toString());
				}
				
				
				
			}
		});
		cmbCriterioBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbCriterioBusqueda.getSelectedIndex()==0){
					txtBusquedaTexto.setVisible(true);
					cmbPaisDeOrigen.setVisible(false);
					lblAnios.setVisible(false);
					txtBusquedaTexto.setBounds(276, 41, 246, 20);
					lblBusqueda.setText("Texto de la busqueda");
					txtBusquedaTexto.setText("");
				}else if(cmbCriterioBusqueda.getSelectedIndex()==1){
					txtBusquedaTexto.setVisible(true);
					cmbPaisDeOrigen.setVisible(false);
					lblAnios.setVisible(true);
					txtBusquedaTexto.setBounds(276, 41, 80, 20);
					txtBusquedaTexto.setText("");
					lblBusqueda.setText("Edad de las personas");
				}else if(cmbCriterioBusqueda.getSelectedIndex()==2){
					txtBusquedaTexto.setVisible(false);
					cmbPaisDeOrigen.setVisible(true);
					lblAnios.setVisible(false);
					lblBusqueda.setText("Pais de origen de las personas");
				}
			}
		});
		
		
		
		
		
	}
	public boolean verificarInteger(String data){
		try{
			int parsed = Integer.parseInt(data);
			return true;
		}catch (Exception es){
			return false;
		}
	}
}
