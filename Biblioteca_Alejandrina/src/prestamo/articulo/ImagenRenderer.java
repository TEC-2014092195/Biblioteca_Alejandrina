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

public class ImagenRenderer extends JLabel implements TableCellRenderer {
	


	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		
		
		
		
			
			BufferedImage imgArticulo = null;
			try {
				imgArticulo = Imagen.getImagenRedimensionada((String) value,80,90);
				setIcon(new ImageIcon(imgArticulo));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			setOpaque(true);
			setBackground(Color.DARK_GRAY);
			
			
			
			table.setRowHeight(130);
			this.setHorizontalAlignment(SwingConstants.CENTER);
			table.setRowMargin(2);

	       
	  
		
	   
	       return this;

//		setToolTipText("RGB value: " + newIconImage.g + ", "
//				+ newIconImage.getGreen() + ", " + newIconImage.getBlue());
	}
}
