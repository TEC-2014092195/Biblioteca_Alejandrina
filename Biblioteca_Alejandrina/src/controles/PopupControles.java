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
	public PopupControles() {
		// Obtener las dimensiones del monitor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setLocation((int)width-400, (int) height-300);
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearControles();
		
		
		add(panelContenedor);
		setVisible(true);
	}
	
	
	/**
	 * Crear controles
	 */
	public void crearControles(){
		lblDefinir = new JLabel("Simular paso días:");
		txtDefinir = new JTextField(10);
		btnDefinir = new JButton("Definir");
		
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
					}
					
				}
				
				
			}
		});
		
		panelContenedor.add(lblDefinir);
		panelContenedor.add(txtDefinir);
		panelContenedor.add(btnDefinir);
		
		
		
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
