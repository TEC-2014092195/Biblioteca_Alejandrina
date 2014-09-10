/**====================================================================================
 * Archivo      : claseNotificaciones.java » Paquete: Notificaciones » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;




// TODO: Auto-generated Javadoc
/**
 * The Class claseNotificaciones.
 */
public class claseNotificaciones extends JFrame implements ActionListener{
	
	/** The btn prueba. */
	JButton btnPrueba;
	
	/** The Pos x. */
	int index=0,PosX=0;
	
	/** The lstbtn. */
	JButton[] lstbtn = new JButton[30]; 
	
	/** The lbl can dias prestamo. */
	JLabel lbl,lblPrueba,lblTipoDoc,lblNombreDoc,lblImagenLibro,lblEstrellas,lblSeparador,lblDiasPrestamo,lblCanDiasPrestamo;
	
	/** The lbl can fecha prestamo. */
	JLabel lblDiasRetraso,lblCanDiasRetraso,lblPrestadoA,lblNomPrestadoA,lblFechaPrestamo,lblCanFechaPrestamo;
	
	/** The lbl nom autor. */
	JLabel lblTitulo,lblNomTitulo,lblDescripcion,lblNomDescripcion,lblAutor,lblNomAutor;
	
	/** The gbc. */
	GridBagConstraints gbc;
	
	/** The v. */
	JFrame v;
	
	/** The gblayout. */
	GridBagLayout gblayout;
	
	/** The gbc2. */
	GridBagConstraints gbc2 = new GridBagConstraints();
	
	/** The bandera. */
	boolean flag=false,bandera=false;
	
	/** The j. */
	JPanel j;
	
	/** The panel. */
	JPanel panel =new JPanel();
	
	/** The paises. */
	Hashtable<String,String> paises = new Hashtable<String,String>();
	
	/** The scroll. */
	JScrollPane scroll;
	
	/** The b titled2. */
	Border bGreyLine, bTitled1, bTitled2;
	
	
	/**
	 * Instantiates a new clase notificaciones.
	 */
	public claseNotificaciones(){
		
		v = new JFrame("notificaciones");
		v.setSize(800, 600);
		v.setLocationRelativeTo(null);
		
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		v.setLayout(new FlowLayout());
		
		j = new JPanel();
		
		 
		
		
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(222,87,101));
		
		
		
		gbc2.gridx=0;
		gbc2.gridy=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20,0,5,15);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/Ejemplo2.jpg")); //getClass().getResource("/recursos/Ejemplo2.jpg")
		System.out.println(imagen.getIconWidth() +"\n"+ imagen.getIconHeight());
		
		lblImagenLibro = new JLabel(imagen);
		lblImagenLibro.setPreferredSize( new Dimension( imagen.getIconWidth() , imagen.getIconHeight() ) );
		
		panel.add(lblImagenLibro,gbc2);


		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.PAGE_END;
		gbc2.insets = new Insets(0,10,0,20);     // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		imagen = new ImageIcon( getClass().getResource("/recursos/4estrellas.png") ); 
		
		lblEstrellas = new JLabel(imagen);
		lblEstrellas.setPreferredSize( new Dimension( imagen.getIconWidth() , imagen.getIconHeight() ) );
		panel.add(lblEstrellas,gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.PAGE_START;
		gbc2.insets = new Insets(10,10,0,20);
		
		
		lblTitulo = new JLabel("Libro");
		//lblTitulo.setForeground(new Color(19,64,80));
		
		lblTitulo.setFont(new Font(lblTitulo.getFont().getFamily(), Font.BOLD, lblTitulo.getFont().getSize()));
		lblTitulo.setForeground(Color.WHITE);
		
		panel.add(lblTitulo,gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.PAGE_START;
		gbc2.insets = new Insets(25,10,0,20);
		
		
		
		lblNomTitulo = new JLabel("<html><p align=\"center\" style=\"width:120px\">"+"Dios no tiene Favoritos tiene Íntimos"+"</p></html>", SwingConstants.CENTER);
		lblNomTitulo.setForeground(Color.WHITE);
		panel.add(lblNomTitulo,gbc2);
		
		gbc2.gridx=1;//columna
		gbc2.gridy=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.PAGE_END;
		gbc2.insets = new Insets(0,10,20,20);
		
		
		lblAutor = new JLabel("<html><p align=\"center\" style=\"width:120px\">"+"Marcos Brunet"+"</p></html>", SwingConstants.CENTER);
		lblAutor.setFont(new Font(lblAutor.getFont().getFamily(), Font.ITALIC, lblAutor.getFont().getSize()));
		panel.add(lblAutor,gbc2);
		
		gbc2.gridx=0;
		
		gbc2.gridy=3;
		gbc2.gridheight=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(0,20,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido

		lblDiasPrestamo = new JLabel("Dias préstamo: ");
		lblDiasPrestamo.setForeground(Color.WHITE);
		
		
		panel.add(lblDiasPrestamo,gbc2);
		
		
		gbc2.gridx=1;
		
		gbc2.gridy=3;
		gbc2.gridheight=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(0,20,0,20);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblCanDiasPrestamo = new JLabel("5");
		//lblCanDiasPrestamo.setFont(new Font(lblCanDiasPrestamo.getFont().getFamily(), Font.PLAIN, 11));
		lblCanDiasPrestamo.setForeground(Color.WHITE);
		panel.add(lblCanDiasPrestamo,gbc2);

		
		
		gbc2.gridx=0;
		gbc2.gridy=4;
		gbc2.gridheight=1;
		
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(0,20,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido

		lblDiasRetraso = new JLabel("Dias retraso: ");
		lblDiasRetraso.setForeground(Color.WHITE);
		
		
		panel.add(lblDiasRetraso,gbc2);
		
		gbc2.gridx=1;
		
		gbc2.gridy=4;
		gbc2.gridheight=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(0,20,0,20);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblCanDiasRetraso = new JLabel("5");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblCanDiasRetraso.setForeground(Color.WHITE);
		panel.add(lblCanDiasRetraso,gbc2);
		
		gbc2.gridx=0;
		gbc2.gridy=5;
		gbc2.gridheight=1;
		
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(0,20,0,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido

		lblPrestadoA = new JLabel("Prestado a: ");
		lblPrestadoA.setForeground(Color.WHITE);
		panel.add(lblPrestadoA,gbc2);
		
		
		gbc2.gridx=1;
		
		gbc2.gridy=5;
		gbc2.gridheight=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(0,20,0,20);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblNomPrestadoA = new JLabel("Kevin Hdez");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblNomPrestadoA.setForeground(Color.WHITE);
		panel.add(lblNomPrestadoA,gbc2);

		gbc2.gridx=0;
		gbc2.gridy=6;
		gbc2.gridheight=1;
		
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(0,20,20,0);   // Extrenal Pad (top, left, bottom, right) -->Corregido

		lblFechaPrestamo = new JLabel("Fecha préstamo: ");
		lblFechaPrestamo.setForeground(Color.WHITE);
		panel.add(lblFechaPrestamo,gbc2);
		
		
		gbc2.gridx=1;
		
		gbc2.gridy=6;
		gbc2.gridheight=1;
		gbc2.gridwidth=1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(0,20,20,20);   // Extrenal Pad (top, left, bottom, right) -->Corregido
		
		lblCanFechaPrestamo = new JLabel("8 Agosto 2014");
		//lblCanDiasRetraso.setFont(new Font(lblCanDiasRetraso.getFont().getFamily(), Font.PLAIN, 11));
		lblCanFechaPrestamo.setForeground(Color.WHITE);
		panel.add(lblCanFechaPrestamo,gbc2);
		
		v.add(panel);
		
		
		v.setVisible(true);
		Color colorV = new Color(239,239,239);
		v.setBackground(colorV);
		
		
		
	}
	
	
	/**
	 * Gets the constraints.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the constraints
	 */
	public GridBagConstraints getConstraints(int x, int y){
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx =x;
		grid.gridy =y;
		return grid;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnPrueba){
			if (bandera==false){
				if (index < 30){
					System.out.println(PosX);
					gbc2.gridx=PosX;
					gbc2.gridy=0;
					//gbc2.gridwidth=GridBagConstraints.RELATIVE;
					gbc2.gridheight=GridBagConstraints.RELATIVE;
					gbc2.anchor = GridBagConstraints.EAST;
					
					gbc2.insets = new Insets(10,10,10,10);
					
					lblPrueba = new JLabel("Prueba");
					
					lstbtn[index] = new JButton("btn"+index);
					
					PosX+=1;
					
					
					panel.add(lstbtn[index],gbc2);
					panel.revalidate();
					panel.repaint();
					panel.setBackground(Color.CYAN);
					
					gbc2.gridx=PosX;
					PosX+=1;
					gbc2.gridy=0;
					
				
					gbc2.anchor = GridBagConstraints.EAST;
					gbc2.insets = new Insets(10,10,10,10);
					panel.add(lblPrueba,gbc2);
					panel.revalidate();
					panel.repaint();
					
					
					index++;
				}else{
					bandera=true;
				}
			}else{
				
				bandera=false;
				panel.remove(panel.getComponentCount()-1);
				
				panel.revalidate();
				panel.repaint();
			}
		}
		
	}
	
	

	
	

}
