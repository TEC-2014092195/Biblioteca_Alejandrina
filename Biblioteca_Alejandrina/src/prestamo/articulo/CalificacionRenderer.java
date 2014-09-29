/**====================================================================================
 * Archivo      : ImagenRenderer.java » Paquete: prestamo.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package prestamo.articulo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


/**
 * The Class CalificacionRenderer. Clase para el formato de calificación, que es por celdas
 */
public class CalificacionRenderer extends JLabel implements TableCellRenderer {
	
	
	/**
	 * Implementación de Component, para la celda de las estrellas
	 * 
	 * @return Jlabel implementa TableCellRenderer
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

			//Asigna la imagen correspondiente a la celda de calificación
			this.setIcon(new ImageIcon(getClass().getResource(
					"/recursos/"+((String)value)+"estrellas.png")));
			
			//Asigna la aliniación horizontal
			this.setHorizontalAlignment(SwingConstants.CENTER);
			
			//Asigna el texto
			this.setToolTipText("Calificación: "+((String)value));

			//Configuración de la celda
			setOpaque(true);
			setBackground(Color.DARK_GRAY);
	  
		
	   
	       return this;

	}
}
