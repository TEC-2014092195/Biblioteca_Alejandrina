/**====================================================================================
 * Archivo      : ImagenRenderer.java � Paquete: prestamo.articulo � Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
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
 * The Class CalificacionRenderer. Clase para el formato de calificaci�n, que es por celdas
 */
public class CalificacionRenderer extends JLabel implements TableCellRenderer {
	
	
	/**
	 * Implementaci�n de Component, para la celda de las estrellas
	 * 
	 * @return Jlabel implementa TableCellRenderer
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

			//Asigna la imagen correspondiente a la celda de calificaci�n
			this.setIcon(new ImageIcon(getClass().getResource(
					"/recursos/"+((String)value)+"estrellas.png")));
			
			//Asigna la aliniaci�n horizontal
			this.setHorizontalAlignment(SwingConstants.CENTER);
			
			//Asigna el texto
			this.setToolTipText("Calificaci�n: "+((String)value));

			//Configuraci�n de la celda
			setOpaque(true);
			setBackground(Color.DARK_GRAY);
	  
		
	   
	       return this;

	}
}
