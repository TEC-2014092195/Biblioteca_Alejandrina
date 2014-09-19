/**====================================================================================
 * Archivo      : ArticuloAbstracto.java » Paquete: plantillas.paneles » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package plantillas.paneles;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import redimensionar.Imagen;

@SuppressWarnings("serial")
public class ArticuloAbstracto extends JFrame{
	
	JPanel panelAbstracto;
	
	GridBagConstraints grid;
	JPanel panelGrilla;
	
	JLabel lblImagen;
	JLabel lblTipoArticulo;
	JLabel lblEstrellas;
	
	JLabel[] lblDatos = new JLabel[4]; 
	
	
	Color lblColor = Color.WHITE;
	Color panelColor = new Color(83,80,71);
	Border lblBorde = BorderFactory.createEmptyBorder(2, 5, 2, 5);
	
	//Funcion para el reporte de articulos
	public ArticuloAbstracto() {
		
	}
	
	public Container getContenedorArticulo(String tipoArticulo, String dato1, String dato2, String dato3, String dato4,String calificacion, String urlImagen){
		panelAbstracto = new JPanel();
		panelAbstracto.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		
		panelGrilla = new JPanel();
		panelGrilla.setLayout(new GridBagLayout());
		
		panelGrilla.setBackground(panelColor);
		
		panelGrilla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		grid = new GridBagConstraints();
		
		BufferedImage imgArticulo = null;
		try {
			imgArticulo = Imagen.getImagenRedimensionada(urlImagen);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(imgArticulo));
		lblImagen.setPreferredSize(new Dimension(imgArticulo
				.getWidth(), imgArticulo.getHeight()));
		grid.gridy=0; //Fila
		grid.gridx=0; //Columna
		grid.gridheight=6;
		panelGrilla.add(lblImagen, grid);
		
		
		grid.gridy=0;
		grid.gridx=1;
		grid.gridheight=1;
		lblTipoArticulo = new JLabel(tipoArticulo.toUpperCase());
		lblTipoArticulo.setForeground(lblColor);
		lblTipoArticulo.setBorder(lblBorde);
		panelGrilla.add(lblTipoArticulo,grid);
		
		grid.gridy=1;
		grid.gridx=1;
		lblDatos[0] = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">" + dato1
						+ "</p></html>", SwingConstants.CENTER); // Dato1 = NombreArticulo
		lblDatos[0].setForeground(lblColor);
		lblDatos[0].setBorder(lblBorde);
		panelGrilla.add(lblDatos[0],grid);
		
		
		
		grid.gridy=2;
		grid.gridx=1;
		lblDatos[1] = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">" + dato2
						+ "</p></html>", SwingConstants.CENTER);
		lblDatos[1].setFont(new Font(lblDatos[1].getFont().getFamily(),
				Font.ITALIC, lblDatos[1].getFont().getSize()));
		lblDatos[1].setForeground(lblColor);
		lblDatos[1].setBorder(lblBorde);
		panelGrilla.add(lblDatos[1],grid);
		
		
		grid.gridy=3;
		grid.gridx=1;
		lblDatos[2] = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">" + dato3
						+ "</p></html>", SwingConstants.CENTER);
		lblDatos[2].setForeground(lblColor);
		lblDatos[2].setBorder(lblBorde);
		panelGrilla.add(lblDatos[2],grid);
		
		
		grid.gridy=4;
		grid.gridx=1;
		lblDatos[3] = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">" + dato4
						+ "</p></html>", SwingConstants.CENTER);
		lblDatos[3].setFont(new Font(lblDatos[3].getFont().getFamily(),
				Font.ITALIC, lblDatos[3].getFont().getSize()));
		lblDatos[3].setForeground(lblColor);
		lblDatos[3].setBorder(lblBorde);
		panelGrilla.add(lblDatos[3],grid);
		
		
		grid.gridy=5;
		grid.gridx=1;
		ImageIcon imgEstrellas = new ImageIcon( getClass().getResource("/recursos/"+calificacion+"estrellas.png") ); 
		lblEstrellas = new JLabel(imgEstrellas);
		lblEstrellas.setPreferredSize( new Dimension( imgEstrellas.getIconWidth() , imgEstrellas.getIconHeight() ) );
		lblEstrellas.setBorder(lblBorde);
		panelGrilla.add(lblEstrellas,grid);

		
		panelAbstracto.add(panelGrilla);
		
		return panelAbstracto;
	}


}
