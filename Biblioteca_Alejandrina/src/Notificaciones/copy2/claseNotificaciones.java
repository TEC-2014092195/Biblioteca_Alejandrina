/**====================================================================================
 * Archivo      : claseNotificaciones.java » Paquete: Notificaciones » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones.copy2;


import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;





















import redimensionar.Imagen;

public class claseNotificaciones extends JFrame implements ActionListener, MouseListener{
	
	GridBagConstraints gridInfo;
	GridBagConstraints gridGrilla = new GridBagConstraints();
	
	
	JPanel panelGeneral = new JPanel();
	JPanel panelGrilla = new JPanel();
	JPanel panelContenedor = new JPanel();
	static int Posx=0;
	static int Posy=0;
	
	
	JScrollPane scroll;
	
	private MouseListener CombinacionEditar;
	
	
	public claseNotificaciones(){
		JFrame frm = new JFrame("Prueba");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		frm.setSize( (int)width-300, (int)height-50 );
		
		frm.setLocationRelativeTo(null);
		
		
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		
		
		panelGeneral.setLayout( new FlowLayout() );
		
		panelGrilla.setLayout( new GridBagLayout() );
		
		
		
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		addNotificacion();
		
		
		
		scroll = new JScrollPane(panelGeneral, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(null);
		scroll.setWheelScrollingEnabled(true);
		scroll.getVerticalScrollBar().setUnitIncrement(50);
		scroll.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		
		panelContenedor.add(scroll);
		panelContenedor.setBorder(BorderFactory.createEmptyBorder(20,50,20,50)); // Extrenal Pad (top, left, bottom, right)
		frm.add(panelContenedor);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public Container crearNotificacion(String pCategoria, String pDireccionImagen,
			String pTitulo, String pAutor, int pDiasPrestamo, int pDiasRetraso,
			String pPrestamista, String pFechaPrestamo) {

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridBagLayout());
		gridInfo = new GridBagConstraints();

		JLabel lblArticuloImagen = new JLabel();

		JLabel lbl, lblPrueba, lblTipoDoc, lblNombreDoc, lblImagenLibro, lblEstrellas, lblSeparador, lblDiasPrestamo, lblCanDiasPrestamo;

		/** The lbl can fecha prestamo. */
		JLabel lblDiasRetraso, lblCanDiasRetraso, lblPrestadoA, lblNomPrestadoA, lblFechaPrestamo, lblCanFechaPrestamo;

		/** The lbl nom autor. */
		JLabel lblCategoria, lblTitulo, lblDescripcion, lblNomDescripcion, lblAutor, lblNomAutor;
		
		Color bgColorRed = new Color(222, 87, 101),
			  bgColorYellow = new Color(219, 165, 49);
		Color lblColor=null,lblColorAutor=null;
		
		// ----------------------------
		if ( pCategoria == "NotificacionAmarrilla"){  //Corregir  
			lblColor = new Color(51 , 51, 51);
			lblColorAutor = Color.WHITE;
			panelInfo.setBackground(bgColorYellow);
		}else{
			lblColor = Color.WHITE;
			lblColorAutor = new Color(51 , 51, 51);
			panelInfo.setBackground(bgColorRed);
		}
		
		

		gridInfo.gridx = 0;
		gridInfo.gridy = 0;
		gridInfo.gridwidth = 1;
		gridInfo.gridheight = 4;
		gridInfo.anchor = GridBagConstraints.LINE_END;
		gridInfo.insets = new Insets(10, 0, 0, 15); // Extrenal Pad (top, left, bottom, right)
		lblArticuloImagen = getLabelImagen();
		panelInfo.add(lblArticuloImagen, gridInfo);

		gridInfo.gridx = 1;// columna
		gridInfo.gridy = 0;
		gridInfo.gridwidth = 1;
		gridInfo.gridheight = 1;
		gridInfo.anchor = GridBagConstraints.CENTER;
		gridInfo.insets = new Insets(10, 0, 5, 0); // Extrenal Pad (top, left, bottom, right)
		
		lblCategoria = new JLabel(pCategoria);
		lblCategoria.setFont(new Font(lblCategoria.getFont().getFamily(),
				Font.BOLD, lblCategoria.getFont().getSize()));
		lblCategoria.setForeground(lblColor);
		panelInfo.add(lblCategoria, gridInfo);

		gridInfo.gridx = 1;
		gridInfo.gridy = 1;
		gridInfo.insets = new Insets(0, 0, 5, 0);
		lblTitulo = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">"
						+ "Dios no tiene Favoritos tiene Íntimos"
						+ "</p></html>", SwingConstants.CENTER);
		lblTitulo.setForeground(lblColor);
		panelInfo.add(lblTitulo, gridInfo);

		gridInfo.gridx = 1;
		gridInfo.gridy = 2;
		gridInfo.insets = new Insets(0, 0, 5, 0);
		lblAutor = new JLabel(
				"<html><p align=\"center\" style=\"width:120px\">"
						+ "Marcos Brunet" + "</p></html>",
				SwingConstants.CENTER);
		lblAutor.setFont(new Font(lblAutor.getFont().getFamily(), Font.ITALIC,
				lblAutor.getFont().getSize()));
		lblAutor.setForeground(lblColorAutor);
		panelInfo.add(lblAutor, gridInfo);

		gridInfo.gridx = 1;
		gridInfo.gridy = 3;
		gridInfo.anchor = GridBagConstraints.CENTER;
		gridInfo.insets = new Insets(0, 0, 5, 0); // Extrenal Pad (top, left, bottom, right)

		lblEstrellas = new JLabel(new ImageIcon(getClass().getResource(
				"/recursos/5estrellas.png")) );
		panelInfo.add(lblEstrellas, gridInfo);

		gridInfo.gridx = 0;

		gridInfo.gridy = 4;
		gridInfo.gridwidth = 1;
		gridInfo.anchor = GridBagConstraints.LINE_END;
		gridInfo.insets = new Insets(0, 10, 0, 0); // Extrenal Pad (top, left, bottom, right)

		lblDiasPrestamo = new JLabel("Dias préstamo: ");
		lblDiasPrestamo.setForeground(lblColor);

		panelInfo.add(lblDiasPrestamo, gridInfo);
		
		
		gridInfo.gridx=1;
		
		gridInfo.gridy=4;
		gridInfo.gridwidth=1;
		gridInfo.anchor = GridBagConstraints.LINE_START;
		gridInfo.insets = new Insets(0,10,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblCanDiasPrestamo = new JLabel("5");
		//lblCanDiasPrestamo.setFont(new Font(lblCanDiasPrestamo.getFont().getFamily(), Font.PLAIN, 11));
		lblCanDiasPrestamo.setForeground(lblColor);
		panelInfo.add(lblCanDiasPrestamo,gridInfo);
		
		
		gridInfo.gridx = 0;
		gridInfo.gridy = 5;
		gridInfo.gridheight = 1;

		gridInfo.anchor = GridBagConstraints.LINE_END;
		gridInfo.insets = new Insets(0, 10, 0, 0); // Extrenal Pad (top, left, bottom, right)

		lblDiasRetraso = new JLabel("Dias retraso: ");
		lblDiasRetraso.setForeground(lblColor);

		panelInfo.add(lblDiasRetraso, gridInfo);
		
		gridInfo.gridx=1;
		
		gridInfo.gridy=5;
		gridInfo.gridheight=1;
		gridInfo.gridwidth=1;
		gridInfo.anchor = GridBagConstraints.LINE_START;
		gridInfo.insets = new Insets(0,10,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblCanDiasRetraso = new JLabel("5");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblCanDiasRetraso.setForeground(lblColor);
		panelInfo.add(lblCanDiasRetraso,gridInfo);
		
		gridInfo.gridx=0;
		gridInfo.gridy=6;
		gridInfo.gridheight=1;
		
		gridInfo.anchor = GridBagConstraints.LINE_END;
		gridInfo.insets = new Insets(0, 10, 0, 0); // Extrenal Pad (top, left, bottom, right)

		lblPrestadoA = new JLabel("Prestado a: ");
		lblPrestadoA.setForeground(lblColor);
		panelInfo.add(lblPrestadoA,gridInfo);
		
		gridInfo.gridx=1;
		
		gridInfo.gridy=6;
		gridInfo.gridheight=1;
		gridInfo.gridwidth=1;
		gridInfo.anchor = GridBagConstraints.LINE_START;
		gridInfo.insets = new Insets(0,10,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblNomPrestadoA = new JLabel("Kevin Hdez");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblNomPrestadoA.setForeground(lblColor);
		panelInfo.add(lblNomPrestadoA,gridInfo);
		
		
		gridInfo.gridx=0;
		gridInfo.gridy=7;
		gridInfo.gridheight=1;
		
		gridInfo.anchor = GridBagConstraints.LINE_END;
		gridInfo.insets = new Insets(0, 10, 10, 0); // Extrenal Pad (top, left, bottom, right)

		lblFechaPrestamo = new JLabel("Fecha préstamo: ");
		lblFechaPrestamo.setForeground(lblColor);
		
		panelInfo.add(lblFechaPrestamo,gridInfo);
		
		
		gridInfo.gridx=1;
		
		gridInfo.gridy=7;
		gridInfo.gridheight=1;
		gridInfo.gridwidth=1;
		gridInfo.anchor = GridBagConstraints.LINE_START;
		gridInfo.insets = new Insets(0,10,10,0);   // Extrenal Pad (top, left, bottom, right)
		
		lblCanFechaPrestamo = new JLabel("8 Agosto 2014");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblCanFechaPrestamo.setForeground(lblColor);
		panelInfo.add(lblCanFechaPrestamo,gridInfo);
		
		panelInfo.addMouseListener(this);
		
		return panelInfo;

	}
	

	
	public JLabel getLabelImagen(){
		JLabel lblImagen = new JLabel(); 
		
		String path = getClass().getResource("/recursos/Libro5.jpg").getPath();
    	BufferedImage imgArticulo = null;
		try {
			imgArticulo = Imagen.getImagenRedimensionada( path,60,90 );
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblImagen.setIcon( new ImageIcon(imgArticulo) );
		lblImagen.setPreferredSize( new Dimension( imgArticulo.getWidth(), imgArticulo.getHeight() ) );
		
		return lblImagen;
	}
	
	
	public void addNotificacion(){
		
		gridGrilla = getGridGrilla();
		Container nuevo = crearNotificacion("Libro", "pDireccionImagen", "pTitulo", "pAutor", 5, 5, "pPrestamista", "pFechaPrestamo");
		panelGrilla.add(nuevo,gridGrilla);
		
		panelGeneral.add(panelGrilla);
	}
	
	public GridBagConstraints getGridGrilla(){
		
		gridGrilla.gridx = Posx;
		gridGrilla.gridy = Posy;
		gridGrilla.insets = new Insets(2,2,2,2);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		if (Posx < 2){
			
			Posx++;
		}else{
			
			Posx=0;
			Posy++;
		}
		
		
		return gridGrilla;
	}
	
	public void actionPerformed(ActionEvent e){
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton()==3){
//			System.out.println("Boton Der");
//			System.out.println( ((JLabel) ((Container) e.getComponent()).getComponent(2)).getText() );
//			JOptionPane.showMessageDialog(null, ((JLabel) ((Container) e.getComponent()).getComponent(2)).getText());
			JOptionPane.showMessageDialog(null, e.getComponent());
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
