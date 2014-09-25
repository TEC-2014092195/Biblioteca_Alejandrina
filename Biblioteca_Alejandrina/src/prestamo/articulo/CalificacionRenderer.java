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


public class CalificacionRenderer extends JLabel implements TableCellRenderer {
	
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		
			this.setIcon(new ImageIcon(getClass().getResource(
					"/recursos/"+((String)value)+"estrellas.png")));
			
			this.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.setToolTipText("Calificación: "+((String)value));

			setOpaque(true);
			setBackground(Color.DARK_GRAY);
	  
		
	   
	       return this;

	}
}
