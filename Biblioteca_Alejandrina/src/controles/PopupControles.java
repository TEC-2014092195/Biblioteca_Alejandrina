/**====================================================================================
 * Archivo      : PopupControles.java » Paquete: controles » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package controles;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Notificaciones.TablaArticulos;
import logicaRegistro.Articulo;
import logicaRegistro.Cliente;
import logicaRegistro.Registro;
import mail.Email;
import tiempo.Tiempo;


/**
 * Clase PopupControles
 */
public class PopupControles extends JFrame{

	//Páneles de la clase
	JPanel panelContenedor = new JPanel();
	JLabel lblDefinir;
	JTextField txtDefinir;
	JButton btnDefinir;

	
	/**
	 * Constructor de la clase PopupControles
	 */

	JLabel lblToleranciaN;
	JTextField txtToleranciaN;
	
	JLabel lblToleranciaM;
	JTextField txtToleranciaM;
	JButton btnTolerancia;
	public static int diasToleranciaN = 0;
	public static int diasToleranciaM = 0;

	public PopupControles() {
		// Obtener las dimensiones del monitor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setLocation((int)width-400, (int) height-300);
		setSize(190, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		crearControles();
		
		setAlwaysOnTop(true);
		add(panelContenedor);
		setVisible(true);
	}
	
	
	/**
	 * Crear controles
	 */
	public void crearControles(){
		lblDefinir = new JLabel("Simular paso días:");
		txtDefinir = new JTextField(10);
		btnDefinir = new JButton("Definir Días");
		
		btnDefinir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int dias =0;
				Tiempo.calcularFechaReal();
				if (txtDefinir.getText().matches("\\d*") && !"".equals(txtDefinir.getText())){
					dias = Integer.parseInt(txtDefinir.getText());
										
					if (dias>0){
						Tiempo.simularCambioDia(dias);
						Registro.articulosRegistrados.get(0).aumentarDiasPrestado(dias);
						enviarCorreos(dias);
					}else{
						JOptionPane.showMessageDialog(null, "Los días deben ser mayores a cero");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Los valores no pueden ser nulos y solo acepta números");
				}
				
				
			}
		});
		
		panelContenedor.add(lblDefinir);
		panelContenedor.add(txtDefinir);
		panelContenedor.add(btnDefinir);
		
		lblToleranciaN = new JLabel("Simular Tolerancia (n días):");
		txtToleranciaN= new JTextField(10);
		
		
		panelContenedor.add(lblToleranciaN);
		panelContenedor.add(txtToleranciaN);

		
		lblToleranciaM = new JLabel("Simular Tolerancia (m días):");
		txtToleranciaM= new JTextField(10);
		
		
		
		
		panelContenedor.add(lblToleranciaM);
		panelContenedor.add(txtToleranciaM);
		btnTolerancia = new JButton("Definir Tolerancia");
		btnTolerancia.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				if (txtToleranciaN.getText().matches("\\d*") && !"".equals(txtToleranciaN.getText()) && txtToleranciaM.getText().matches("\\d*") && !"".equals(txtToleranciaM.getText())){
					
					
					
						diasToleranciaN = Integer.parseInt(txtToleranciaN.getText());
						diasToleranciaM = Integer.parseInt(txtToleranciaM.getText());
						TablaArticulos.llenarTabla();
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Los valores no pueden ser nulos y solo acepta números");
				}
				
					
										
					
					
				
				
				
			}
		});
		panelContenedor.add(btnTolerancia);
		
		
		
	}
	
	/**
	 * EnviarCorreos
	 * @param limiteDias
	 */
	void enviarCorreos(int limiteDias){
		for (Cliente clie : Registro.clientesRegistrados){
			for (Articulo art : clie.getPrestamos()){
				if (art.getDiasPrestado() > limiteDias){
					Email e = new Email("","","","","");
					e.enviarDespues(clie.getCorreo());
				}
				else if (art.getDiasPrestado() == limiteDias){
					Email e = new Email("","","","","");
					e.enviarDia(clie.getCorreo());
				}
			}
			
		}
	}
	
	public static void main(String[] args){
		new PopupControles();
	}
	
	
	
	
	
	
	
	

}
