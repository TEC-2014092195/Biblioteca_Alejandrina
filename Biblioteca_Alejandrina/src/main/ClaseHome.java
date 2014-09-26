/**====================================================================================
 * Archivo      : ClaseHome.java » Paquete: main » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */


package main;


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

import registro.articulo.claseRegistroArticulos;
import registro.clientes.ClaseRegistroClientes;
import consultas.ClaseConsulta; 
import consultas.TablaConsultas;
import logicaRegistro.Registro;
import prestamo.articulo.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaseHome.
 */
public class ClaseHome extends JFrame implements ActionListener{
	
	/** The ventana. */
	public static JFrame ventana = new JFrame();
	
	/** The grid. */
	static GridBagConstraints grid = new GridBagConstraints(); 
	
	/** The panel cards. */
	static JPanel panelCards = new JPanel();
	
	/** The panel contenedor. */
	static JPanel panelContenedor = new JPanel();
	
	/** The lbl background. */
	static JLabel lblBackground;
	
	/** The btn salir. */
	static JButton btnRegistroPersonas,btnRegistroArticulos,btnConsultas,btnPrestamos,btnDevoluciones,btnSalir;
	
	/** The cardlayout. */
	static CardLayout cardlayout;
	
	/** The panel home. */
	static JPanel panelHome = new JPanel();
	
	/** The content pane. */
	static Container contentPane;
	
	
	/**
	 * Crear widgets.
	 */
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
		grid.insets = new Insets(57, -505, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnRegistroPersonas = new JButton("Registro Personas");
		btnRegistroPersonas.setOpaque(false);
//		btnRegistroPersonas.setContentAreaFilled(false);
		btnRegistroPersonas.setBorderPainted(false);
		btnRegistroPersonas.setPreferredSize(new Dimension(140, 140));
		btnRegistroPersonas.setBackground(Color.WHITE);
		btnRegistroPersonas.setFocusable(false);
		panelContenedor.add(btnRegistroPersonas,grid);
		panelContenedor.setComponentZOrder(btnRegistroPersonas, 0);
		
		
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, -170, 0, 0); // Extrenal Pad (top, left, bottom, right)
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
		grid.insets = new Insets(65, 175, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnConsultas = new JButton("<html><p align=\"center\">"+"Consultas  </br> de </br>Artículos"+"</p></html>");
		btnConsultas.setOpaque(false);
//		btnConsultas.setContentAreaFilled(false);
		btnConsultas.setBorderPainted(false);
		btnConsultas.setPreferredSize(new Dimension(140, 140));
		btnConsultas.setBackground(Color.WHITE);
		btnConsultas.setFocusable(false);
		btnConsultas.setBounds(390, 237, 150, 150);
		panelContenedor.add(btnConsultas,grid);
		panelContenedor.setComponentZOrder(btnConsultas, 0);
		
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(57, 500, 0, 0); // Extrenal Pad (top, left, bottom, right)
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
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(285, -335, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnPrestamos = new JButton("Préstamos");
		btnPrestamos.setOpaque(false);
//		btnPrestamos.setContentAreaFilled(false);
		btnPrestamos.setBorderPainted(false);
		btnPrestamos.setPreferredSize(new Dimension(140, 140));
		btnPrestamos.setBackground(Color.WHITE);
		btnPrestamos.setFocusable(false);
		btnPrestamos.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnPrestamos,grid);
		panelContenedor.setComponentZOrder(btnPrestamos, 0);
		
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets(285, 340, 0, 0); // Extrenal Pad (top, left, bottom, right)
		btnDevoluciones = new JButton("Devoluciones");
		btnDevoluciones.setOpaque(false);
//		btnDevoluciones.setContentAreaFilled(false);
		btnDevoluciones.setBorderPainted(false);
		btnDevoluciones.setPreferredSize(new Dimension(140, 140));
		btnDevoluciones.setBackground(Color.WHITE);
		btnDevoluciones.setFocusable(false);
		btnDevoluciones.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnDevoluciones,grid);
		panelContenedor.setComponentZOrder(btnDevoluciones, 0);
		
		
		panelHome.add(panelContenedor);
		
		btnSalir.addActionListener(this);
		btnRegistroPersonas.addActionListener(this);
		btnRegistroArticulos.addActionListener(this);
		btnConsultas.addActionListener(this);
		btnPrestamos.addActionListener(this);
		
		panelCards.add("Home", panelHome);
		
		LogIn li = new LogIn();
		panelCards.add("LogIn", li.getContenedor());
		
		ClaseRegistroClientes rc = new ClaseRegistroClientes(); 
		panelCards.add("RegistroPersonas", rc.getContenedor());
		
		claseRegistroArticulos ra = new claseRegistroArticulos();
		panelCards.add("RegistroArticulos", ra.getContenedor());
		
		ClaseConsulta cc = new ClaseConsulta();
		panelCards.add("Consultas", cc.getContenedor());
		
		PrestarArticulo prestamos = new PrestarArticulo();
		panelCards.add("Prestamos", prestamos.getContenedor());
		
		
		
		
		
		cardlayout.show(panelCards, "LogIn");
		
		contentPane.add(panelCards);
		
		
		
		
		
	}
	

	/**
	 * Crear frame.
	 */
	public void crearFrame(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		ventana.setSize( (int)width-300, (int)height-50 );
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Biblioteca Alejandrina");
		ventana.setLayout(new GridLayout());
		
		Registro.recuperarEstadoSistema(); //Recupera el estado del archivo de texto registrodatos.txt
		
		contentPane = ventana.getContentPane();
		
		cardlayout = new CardLayout();
		panelCards.setLayout(cardlayout); //panelCards para añadir los demás Paneles
		
		
		crearWidgets();
		
		ventana.setVisible(true);
	}

	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
		}else if (e.getSource() == btnConsultas){
			TablaConsultas.llenarTabla();
			cardlayout.show(panelCards, "Consultas");
			ventana.revalidate();
			ventana.repaint();
		}else if(e.getSource()==btnPrestamos){
			cardlayout.show(panelCards, "Prestamos");
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
