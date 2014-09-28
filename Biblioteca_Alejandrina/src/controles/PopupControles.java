/**====================================================================================
 * Archivo      : PopupControles.java » Paquete: controles » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tiempo.Tiempo;

public class PopupControles extends JFrame{

	JPanel panelContenedor = new JPanel();
	JLabel lblDefinir;
	JTextField txtDefinir;
	JButton btnDefinir;
	public PopupControles() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearControles();
		
		
		add(panelContenedor);
		setVisible(true);
	}
	
	
	
	public void crearControles(){
		lblDefinir = new JLabel("Defina Fecha:");
		txtDefinir = new JTextField(15);
		btnDefinir = new JButton("Definir");
		
		btnDefinir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int dias =0;
				Tiempo.calcularFechaReal();
				if (txtDefinir.getText().matches("\\d*") && !"".equals(txtDefinir.getText())){
					dias = Integer.parseInt(txtDefinir.getText());
					Tiempo.setContadorDias(dias);
					Tiempo.calcularFechaSistema();
					JOptionPane.showMessageDialog(null, Tiempo.getFechaReal());
				}
				
				
			}
		});
		
		panelContenedor.add(lblDefinir);
		panelContenedor.add(txtDefinir);
		panelContenedor.add(btnDefinir);
		
		
		
	}
	
	public static void main(String[] args){
		new PopupControles();
	}
	
	
	
	
	
	
	
	

}
