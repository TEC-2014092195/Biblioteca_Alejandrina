/**====================================================================================
 * Archivo      : ClaseIntroduccion.java » Paquete: PruebaMain » Proyecto: Biblioteca Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Main;

import javax.swing.JWindow;  
import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit; 

public class ClaseIntroduccion extends JWindow { 
	Image img=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/Logo.jpg"));
	Image img2=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/load.gif"));
	public ClaseIntroduccion() { 
		try { 
			setSize(800,600); 
			setLocationRelativeTo(null);
			setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
			
			setVisible(true);
			Thread.sleep(2500); 
			dispose(); 
			
		}catch(Exception exception) { 
				//javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null,"Error"+exception.getMessage(), "Error:", javax.swing.JOptionPane.DEFAULT_OPTION); 
		} 
		
	} 
	
	public void paint(Graphics g) { //paint( Graphics g ) es automaticamente llamado al iniciar el programa
		g.drawImage(img,0,0,this);
		g.drawImage(img2,550,520,this);
		//http://www.cs.nyu.edu/courses/fall00/V22.0101-003/repaint.html
	} 
	 	
}