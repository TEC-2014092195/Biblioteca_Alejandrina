/**====================================================================================
 * Archivo      : ClaseHome.java » Paquete: Main » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */


package Main;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import RegistroArticulo.*;

public class ClaseHome extends JFrame implements ActionListener{
	
	static JFrame ventana = new JFrame();
	static GridBagConstraints grid = new GridBagConstraints(); 
	static JPanel panelCards = new JPanel();
	static JPanel panelContenedor = new JPanel();
	
	static JLabel lblBackground;
	static JButton btnRegistroPersonas,btnRegistroArticulos,btnConsultas,btnSalir;
	static CardLayout cardlayout;
	static JPanel panelHome = new JPanel();
	static Container contentPane;
	
	public void crearWidgets(){

		
		panelContenedor.setLayout(new GridBagLayout());
		
		
		panelHome.setLayout(new FlowLayout()); //Panel HOME
		
		grid = new GridBagConstraints();
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(-43, 0, 0, 0); // Extrenal Pad (top, left, bottom, right)
		ImageIcon img = new ImageIcon(getClass().getResource("/recursos/Inicio.jpg")); 
		
		lblBackground = new JLabel(img);
//		lblBackground.setBounds(-10, -17, img.getIconWidth(), img.getIconHeight());
		panelContenedor.add(lblBackground,grid);
		
		
		//----------Inicio_Botones
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, -532, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnRegistroPersonas = new JButton("Registro Personas");
		btnRegistroPersonas.setOpaque(false);
//		btnRegistroPersonas.setContentAreaFilled(false);
		btnRegistroPersonas.setBorderPainted(false);
		btnRegistroPersonas.setPreferredSize(new Dimension(140, 140));
		btnRegistroPersonas.setBackground(Color.WHITE);
		btnRegistroPersonas.setFocusable(false);
		//btnRegistroPersonas.setBounds(50, 236, 150, 150);
		panelContenedor.add(btnRegistroPersonas,grid);
		panelContenedor.setComponentZOrder(btnRegistroPersonas, 0);
		
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, -195, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnRegistroArticulos = new JButton("Registro Artículos");
		btnRegistroArticulos.setOpaque(false);
//		btnRegistroArticulos.setContentAreaFilled(false);
		btnRegistroArticulos.setBorderPainted(false);
		btnRegistroArticulos.setPreferredSize(new Dimension(140, 140));
		btnRegistroArticulos.setBackground(Color.WHITE);
		btnRegistroArticulos.setFocusable(false);
		btnRegistroArticulos.setBounds(220, 236, 150, 150);
		panelContenedor.add(btnRegistroArticulos,grid);
		panelContenedor.setComponentZOrder(btnRegistroArticulos, 0);
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, 139, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnConsultas = new JButton("<html><p align=\"center\">"+"Consultas  </br>de </br>Artículos"+"</p></html>");
		btnConsultas.setOpaque(false);
//		btnConsultas.setContentAreaFilled(false);
		btnConsultas.setBorderPainted(false);
		btnConsultas.setPreferredSize(new Dimension(140, 140));
		btnConsultas.setBackground(Color.WHITE);
		btnConsultas.setFocusable(false);
		btnConsultas.setBounds(385, 237, 150, 150);
		panelContenedor.add(btnConsultas,grid);
		panelContenedor.setComponentZOrder(btnConsultas, 0);
		
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, 476, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnSalir = new JButton("Salir");
		btnSalir.setOpaque(false);
//		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setPreferredSize(new Dimension(140, 140));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setFocusable(false);
		btnSalir.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnSalir,grid);
		panelContenedor.setComponentZOrder(btnSalir, 0);
		
		panelHome.add(panelContenedor);
		
		btnSalir.addActionListener(this);
		btnRegistroPersonas.addActionListener(this);
		btnRegistroArticulos.addActionListener(this);
		
		panelCards.add("Home", panelHome);
		
		ClaseRegistroClientes rc = new ClaseRegistroClientes(); 
		panelCards.add("RegistroPersonas", rc.getContenedor());
		
		CopyOfclaseRegistroArticulos ra = new CopyOfclaseRegistroArticulos();
		panelCards.add("RegistroArticulos", ra.getContenedor());
		
		
		cardlayout.show(panelCards, "Home");
		
		contentPane.add(panelCards);
		
		
		
		
	}
	

	public void crearFrame(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		ventana.setSize( (int)width-300, (int)height-50 );
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Biblioteca Alejandrina");
		ventana.setLayout(new GridLayout());
		
		
		
		contentPane = ventana.getContentPane();
		
		cardlayout = new CardLayout();
		panelCards.setLayout(cardlayout); //SuperPanel para añadir los demás Paneles
		
		
		crearWidgets();
		
		ventana.setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSalir){
			System.exit(0);
		}else if(e.getSource()==btnRegistroPersonas){
			
			cardlayout.show(panelCards, "RegistroPersonas");
			ventana.revalidate();
			ventana.repaint();
		}else if(e.getSource()==btnRegistroArticulos){
			
			cardlayout.show(panelCards, "RegistroArticulos");
			ventana.revalidate();
			ventana.repaint();
		}
		
	}
	
	
	
	public CardLayout getCardLayout(){
		return cardlayout;
	}
	
	public Container getPanelCards(){
		return panelCards;
	}
	
	public Container getFrame(){
		return ventana;
	}
}
