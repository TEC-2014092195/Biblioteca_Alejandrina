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

public class ClaseHome extends JFrame implements ActionListener {

	
	// Frame de la ventana principal de toda la aplicación.
	public static JFrame ventana = new JFrame();

	// Tipo de Panel General que contiene todos los demás paneles a agregar 
	static JPanel panelCards = new JPanel();

	// Label para cargar Imagen de Inicio en panelHome
	JLabel lblBackground;

	// Botones del panelHome
	JButton btnRegistroClientes, btnRegistroArticulos, btnConsultas,
			btnPrestamos, btnDevoluciones, btnSalir;

	// Layout asignado a panelCards para visuaizar los diferentes paneles que contiene
	static CardLayout cardlayout = new CardLayout();

	// Panel de las acciones principales del sistema
	static JPanel panelHome = new JPanel();

	// Contenedor que obtendrá el contenedor del Frame ventana
	Container contentPane;
	
	/**
     * Crea todos los elementos o componentes del <code>panelHome</code> 
     */
	public void crearPanelHome() {
		//Crea y asigna el tipo de Layout de los contenedores
		JPanel panelContenedor = new JPanel();
		GridBagConstraints grid = new GridBagConstraints();
		
		panelContenedor.setLayout(new GridBagLayout());
		panelHome.setLayout(new FlowLayout());
		
		// Inicio agregar componentes a los paneles
		// Inicia grid en la posición x,y iguales a 0
		grid.gridx = 0;
		grid.gridy = 0;
		// Insets (top, left, bottom, right)
		grid.insets = new Insets(-43, 0, 0, 0); 
		// Mostrar "Inicio.jpg" en lblBackground  
		ImageIcon img = new ImageIcon(getClass().getResource(
				"/recursos/Inicio.jpg"));
		lblBackground = new JLabel(img);
		panelContenedor.add(lblBackground, grid);


		
		// Insets (top, left, bottom, right)
		grid.insets = new Insets(57, -505, 0, 0); 
		btnRegistroClientes = new JButton("Registro Personas");
		btnRegistroClientes.setOpaque(false);
		btnRegistroClientes.setBorderPainted(false);
		btnRegistroClientes.setPreferredSize(new Dimension(140, 140));
		btnRegistroClientes.setBackground(Color.WHITE);
		btnRegistroClientes.setFocusable(false);
		panelContenedor.add(btnRegistroClientes, grid);
		panelContenedor.setComponentZOrder(btnRegistroClientes, 0);

		// Insets (top, left, bottom, right)
		grid.insets = new Insets(57, -170, 0, 0);
		btnRegistroArticulos = new JButton("Registro Artículos");
		btnRegistroArticulos.setOpaque(false);
		btnRegistroArticulos.setBorderPainted(false);
		btnRegistroArticulos.setPreferredSize(new Dimension(140, 140));
		btnRegistroArticulos.setBackground(Color.WHITE);
		btnRegistroArticulos.setFocusable(false);
		btnRegistroArticulos.setBounds(220, 236, 150, 150);
		panelContenedor.add(btnRegistroArticulos, grid);
		panelContenedor.setComponentZOrder(btnRegistroArticulos, 0);

		// Insets (top, left, bottom, right)
		grid.insets = new Insets(65, 175, 0, 0);
		btnConsultas = new JButton("<html><p align=\"center\">"
				+ "Consultas  </br> de </br>Artículos" + "</p></html>");
		btnConsultas.setOpaque(false);
		btnConsultas.setBorderPainted(false);
		btnConsultas.setPreferredSize(new Dimension(140, 140));
		btnConsultas.setBackground(Color.WHITE);
		btnConsultas.setFocusable(false);
		btnConsultas.setBounds(390, 237, 150, 150);
		panelContenedor.add(btnConsultas, grid);
		panelContenedor.setComponentZOrder(btnConsultas, 0);

		// Insets (top, left, bottom, right)
		grid.insets = new Insets(57, 500, 0, 0);
		btnSalir = new JButton("Salir");
		btnSalir.setOpaque(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setPreferredSize(new Dimension(140, 140));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setFocusable(false);
		btnSalir.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnSalir, grid);
		panelContenedor.setComponentZOrder(btnSalir, 0);

		// Insets (top, left, bottom, right)
		grid.insets = new Insets(285, -335, 0, 0); 
		btnPrestamos = new JButton("Préstamos");
		btnPrestamos.setOpaque(false);
		btnPrestamos.setBorderPainted(false);
		btnPrestamos.setPreferredSize(new Dimension(140, 140));
		btnPrestamos.setBackground(Color.WHITE);
		btnPrestamos.setFocusable(false);
		btnPrestamos.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnPrestamos, grid);
		panelContenedor.setComponentZOrder(btnPrestamos, 0);

		// Insets (top, left, bottom, right)
		grid.insets = new Insets(285, 340, 0, 0); 
		btnDevoluciones = new JButton("Devoluciones");
		btnDevoluciones.setOpaque(false);
		btnDevoluciones.setBorderPainted(false);
		btnDevoluciones.setPreferredSize(new Dimension(140, 140));
		btnDevoluciones.setBackground(Color.WHITE);
		btnDevoluciones.setFocusable(false);
		btnDevoluciones.setBounds(553, 236, 150, 150);
		panelContenedor.add(btnDevoluciones, grid);
		panelContenedor.setComponentZOrder(btnDevoluciones, 0);
		
		// Añadir al panelHome todos sus Widgets contenidos en panelContenedor
		panelHome.add(panelContenedor);

		//Agregar ActionListener a cada Botón
		btnSalir.addActionListener(this);
		btnRegistroClientes.addActionListener(this);
		btnRegistroArticulos.addActionListener(this);
		btnConsultas.addActionListener(this);
		btnPrestamos.addActionListener(this);

	}

	/**
     * Crea todos los elementos o componentes del JFrame <code>ventana</code>
     * Incia con el método Registro.<code>recuperarEstadoSistema</code>() para obtener los datos almacenados del sistema
     * 
     * @see       #agregarCards()
     * @see		  #crearPanelHome()
     *  
     */
	public void crearFrame() {
		
		// Recupera el estado del archivo de texto "Biblioteca_Alejandrina/data/registrodatos.txt".
		Registro.recuperarEstadoSistema();

		
		// Obtener las dimensiones del monitor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		// Asigna las propiedades de la ventana.
		ventana.setSize((int) width - 300, (int) height - 50);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Biblioteca Alejandrina");
		ventana.setLayout(new GridLayout());
		
		// Obtiene el Container de la ventana 
		contentPane = ventana.getContentPane();
		
		// panelCards para añadir los demás Paneles
		panelCards.setLayout(cardlayout);
		
		// Crea los componentes del panelHome
		crearPanelHome();
		
		// Agrega las Cards (o sea los paneles) a panelCards
		agregarCards();
		
		// Agrega al contenedor de ventana panelCards
		contentPane.add(panelCards);
		
		// Visualiza la ventana
		ventana.setVisible(true);
	}
	
	
	/**
     * Método para agregar nuevos paneles a panelCards y define el panel que deseo mostrar con la acción: 
     * cardlayout.show(panelCards, <code>"Nombre_Panel_a_Mostrar"</code>).
     * 
     */
	public void agregarCards(){
		
		// Agrega a panelCards el panelHome con el "ID" o "name" para identificarlo en el panelCards
		panelCards.add("Home", panelHome);

		LogIn li = new LogIn();
		// Agrega a panelCards el contenedor de la clase LogIn y le asigna name="LogIn"
		panelCards.add("LogIn", li.getContenedor());

		ClaseRegistroClientes rc = new ClaseRegistroClientes();
		// Agrega a panelCards el contenedor de la clase ClaseRegistroClientes y le asigna name="RegistroClientes"
		panelCards.add("RegistroClientes", rc.getContenedor());

		claseRegistroArticulos ra = new claseRegistroArticulos();
		// Agrega a panelCards el contenedor de la clase ClaseRegistroArticulos y le asigna name="RegistroArticulos"
		panelCards.add("RegistroArticulos", ra.getContenedor());

		ClaseConsulta cc = new ClaseConsulta();
		// Agrega a panelCards el contenedor de la clase ClaseConsulta y le asigna name="Consultas"
		panelCards.add("Consultas", cc.getContenedor());

		PrestarArticulo prestamos = new PrestarArticulo();
		// Agrega a panelCards el contenedor de la clase PrestarArticulo y le asigna name="Prestamos"
		panelCards.add("Prestamos", prestamos.getContenedor());
		
		// Define el panel que se desea mostrar del panelCards con el name asignado anticipadamente 
		cardlayout.show(panelCards, "Home");
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			
			//Salir del sistema
			System.exit(0);
		} else if (e.getSource() == btnRegistroClientes) {
			
			//Mostrar en cardlayout "RegistroClientes"
			cardlayout.show(panelCards, "RegistroClientes");
			ventana.revalidate();
			ventana.repaint();
		} else if (e.getSource() == btnRegistroArticulos) {
			
			//Mostrar en cardlayout "RegistroArticulos"
			cardlayout.show(panelCards, "RegistroArticulos");
			ventana.revalidate();
			ventana.repaint();
		} else if (e.getSource() == btnConsultas) {
			
			//Mostrar en cardlayout "Consultas"
			TablaConsultas.llenarTabla();
			cardlayout.show(panelCards, "Consultas");
			ventana.revalidate();
			ventana.repaint();
		} else if (e.getSource() == btnPrestamos) {
			
			//Mostrar en cardlayout "Prestamos"
			cardlayout.show(panelCards, "Prestamos");
			ventana.revalidate();
			ventana.repaint();
		}

	}

	/**
	 * Obtine el <code>cardlayout</code> para que otras clases realicen la acción: 
	 * ClaseHome.<code>cardlayout</code>.show(ClaseHome.panelCards, "Nombre_Panel_a_Visualizar");
	 * 
	 * @return cardlayout.
	 */
	public CardLayout getCardLayout() {
		return cardlayout;
	}

	/**
	 * Obtine el JPanel <code>panelCards</code> para que otras clases realicen la acción: 
	 * ClaseHome.cardlayout.show(ClaseHome.<code>panelCards</code>, "Nombre_Panel_a_Visualizar");
	 * 
	 * @return panelCards.
	 */
	public Container getPanelCards() {
		return panelCards;
	}

	

}
