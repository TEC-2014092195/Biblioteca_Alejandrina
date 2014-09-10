/**====================================================================================
 * Archivo      : Imagen.java » Paquete: redimensionar » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package redimensionar;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	
	/**
	 * Gets the imagen redimensionada.
	 *
	 * @param src the src
	 * @return the imagen redimensionada
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedImage getImagenRedimensionada(String src) throws IOException{
		 
		
		BufferedImage bi = ImageIO.read(new File(src));
		
		BufferedImage resizedImage=null;
		
		resizedImage = resize(bi,180,150);
		
		
		return resizedImage;
	}
	
	public static BufferedImage getImagenRedimensionada(String src, int ancho, int alto) throws IOException{
		 
		
		BufferedImage bi = ImageIO.read(new File(src));
		
		BufferedImage resizedImage=null;
		
		resizedImage = resize(bi, ancho, alto);
		
		
		return resizedImage;
	}
	
	/**
	 * Resize.
	 *
	 * @param src the src
	 * @param width the width
	 * @param height the height
	 * @return the buffered image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedImage resize(BufferedImage src, int width, int height) throws IOException {
		int newWidth;
        int newHeight;
        
        Float scale;
        if (src.getWidth() > src.getHeight()) {
            scale = Float.valueOf(width) / Float.valueOf(src.getWidth());
        } else {
            scale = Float.valueOf(height) / Float.valueOf(src.getHeight());
        }
        
        newWidth = Float.valueOf(src.getWidth() * scale).intValue();
        newHeight = Float.valueOf(src.getHeight() * scale).intValue();
		
	    BufferedImage bi = scale(src, newWidth, newHeight);
		
	    return bi;
	}
	
	/**
	 * Scale.
	 *
	 * @param src the src
	 * @param width the width
	 * @param height the height
	 * @return the buffered image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedImage scale(BufferedImage src, int width, int height) throws IOException {
	    BufferedImage dest = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g = dest.createGraphics();
	    AffineTransform at = AffineTransform.getScaleInstance(
	            (double)width/src.getWidth(),
	            (double)height/src.getHeight());
	    g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)); //RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY
	    //RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC
	    g.drawImage(src,at,null);       
	    
	    return dest;
	}

}
