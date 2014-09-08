/**====================================================================================
 * Archivo      : claseNotificaciones.java » Paquete: Notificaciones » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones.copy;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;




// TODO: Auto-generated Javadoc
/**
 * The Class claseNotificaciones.
 */
public class claseNotificaciones extends JFrame implements ActionListener{
	
	/** The btn3. */
	JButton btn,btn2,btn3;
	
	/** The index. */
	int index=0;
	
	/** The lstbtn. */
	JButton[] lstbtn = new JButton[30]; 
	
	/** The lbl. */
	JLabel lbl;
	
	/** The gbc. */
	GridBagConstraints gbc;
	
	/** The v. */
	JFrame v;
	
	/** The gblayout. */
	GridBagLayout gblayout;
	
	/** The flag. */
	boolean flag=false;
	
	/** The j. */
	JPanel j;
	
	/** The paises. */
	Hashtable<String,String> paises = new Hashtable<String,String>();
	
	/** The scroll. */
	JScrollPane scroll;
	
	
	/**
	 * Instantiates a new clase notificaciones.
	 */
	public claseNotificaciones(){
		
		v = new JFrame("notificaciones");
		v.setSize(800, 600);
		v.setLocationRelativeTo(null);
		
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		v.setLayout(new FlowLayout());
		//v.setLayout(null);
		j = new JPanel();
		
		j.setLayout(new BoxLayout(j, BoxLayout.PAGE_AXIS));
		
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("imagen.png")); //getClass().getResource("/recursos/imagen.png")
		} catch (IOException e) {
		}
	     
	    JLabel jLabel = new JLabel(new ImageIcon(img));
	     
	    j.add(jLabel);
		
		
		
		btn = new JButton("Boton");
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setFocusable(false);
		btn.addActionListener(this);
		gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,10,10); // Extrenal Pad (bottom, left, right, top) 
		
		j.add(btn,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		//gbc.gridwidth = 1;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		
		
		
		lbl = new JLabel("");
		
		
		j.add(lbl,gbc);
		
		gbc.gridx=1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		//gbc.gridwidth = 1;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		
		btn2 = new JButton("Boton2");
		btn2.setBackground(Color.WHITE);
		btn2.setForeground(Color.BLACK);
		btn2.setFocusable(false);
		btn2.addActionListener(this);
	
		
		j.add(btn2,gbc);
		
		//j.setBackground(Color.GRAY);
		
		
		lbl.setText("Kevin");
		j.setBounds(50, 100, 250, 250);
		
		scroll = new JScrollPane(j, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		scroll.setWheelScrollingEnabled(true);
		scroll.getVerticalScrollBar().setUnitIncrement(50);
		
		scroll.setBounds(0, 0, 350, 350);
		//scroll.setViewportBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		v.add(scroll);
		
		
		v.setVisible(true);
		Color colorV = new Color(239,239,239);
		v.setBackground(colorV);
		
		
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn){
			if (index < 30){
			
			lbl.setText("Black");
			flag=true;
			lstbtn[index] = new JButton("btn"+index);
			
			
			j.add(Box.createVerticalStrut(25));
			j.add(lstbtn[index]);
			j.revalidate();
			j.repaint();
			//btn3.revalidate();
			index++;
			paises.put("ES", "España");
			paises.put("UK", "Reino Unido");
			paises.put("US", "Estados Unidos");
			paises.put("FR", "Francia");
			
			String clave = "US";		
			System.out.println("El valor de la clave " + clave + " es " + paises.get(clave));
			paises.replace(clave, "kevin");
			System.out.println("Claves: "+paises.get(clave));
			}
			
			
			
		}else if(e.getSource()==btn2){
			if(index>0){
			System.out.println(index);
			index--;
			j.remove(lstbtn[index]);
			System.out.println(j.getComponentCount());
			j.remove(j.getComponentCount()-1);
			j.revalidate();
			j.repaint();
			}
		}
		
	}

	
	

}
