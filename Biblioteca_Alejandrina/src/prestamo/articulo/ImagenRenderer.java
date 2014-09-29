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
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

import redimensionar.*;


/**
 * The Class ImagenRenderer. Clase para el formato de calificación
 */
public class ImagenRenderer extends JLabel implements TableCellRenderer {
	
	/**
	 * Implementación de Component para crear la celda de la imagen
	 * 
	 * @return JLabel que implementa TableCellRenderer
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

			//Pone la imagen como ícono de la celda
			setIcon(new ImageIcon( (String)value) );
		
			//Configura la celda
			setOpaque(true);
			setBackground(Color.DARK_GRAY);
			table.setRowHeight(130);
			this.setHorizontalAlignment(SwingConstants.CENTER);
			
			table.setRowMargin(2);
	   
	       return this;

	}
}
