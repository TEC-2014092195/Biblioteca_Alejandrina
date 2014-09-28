/**====================================================================================
 * Archivo      : Notificaciones.java » Paquete: Notificaciones » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones;

import javax.swing.*;
import javax.swing.border.Border;




import javax.swing.table.DefaultTableModel;

import java.awt.*;






// TODO: Auto-generated Javadoc
/**
 * The Class Notificaciones.
 */
public class Notificaciones{
	JDialog popupNotificacion = new JDialog();
	TablaArticulos tabla = new TablaArticulos();
	
	public Notificaciones(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		// Asigna las propiedades de la ventana.
		popupNotificacion.setSize((int) width - 300, (int) height - 50);
		popupNotificacion.setLocationRelativeTo(null);
		
		
		
		popupNotificacion.add(tabla);
		filtroPrestado();
		
		popupNotificacion.setVisible(true);
		
		
		
		
		
	}
	private void filtroPrestado() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			TablaArticulos.sorter.sort();
			rf = RowFilter.regexFilter("true", 7);
			TablaArticulos.sorter.setRowFilter(rf);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		
	}
	
	
	
	
	

	
	

}
