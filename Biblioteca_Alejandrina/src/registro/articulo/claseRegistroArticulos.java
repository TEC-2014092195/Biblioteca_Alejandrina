/**====================================================================================
 * Archivo      : claseRegistroArticulos.java » Paquete: registro.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package registro.articulo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.*;

import logicaRegistro.Articulo;
import logicaRegistro.Registro;
import main.ClaseHome;
import redimensionar.Imagen;

// TODO: Auto-generated Javadoc
/**
 * The Class claseRegistroArticulos. Clase de interfaz Crea la interfaz para
 * ingresar un nuevo artículo o editar uno existente
 */
public class claseRegistroArticulos extends JFrame implements ActionListener {

	//Conjunto de Etiquetas que se usan para las secciones del registro
	JLabel lblTipo, lblLogo, lblDescripcion, lblCalificacion;

	//Conjunto de botones que van en el cuadro de registro
	JButton btnImagenArticulo, btnGuardar, btnAtras;

	//Imagen de calificación (estrellas)
	ImageIcon imgCalificacion;

	//Arreglo de eqtiquetas en donde van a ir las entradas de texto para los datos
	JLabel[] lblDatos = new JLabel[5];


	//Entradas de texto para los datos
	JTextField[] txtDatos = new JTextField[4];
	
	//El Panel que contiene todos los datos.
	JPanel panelGrid, panelContenedor;

	//String que guarda el tipo de artículo que se va a guardar.
	String[] strTipo;

	//String que guarda los datos de Libro
	String[] strLibro = { "Título de obra", "Autor(es)", "Editorial",
			"Edición", "Calificación" };

	//String que guarda los datos de Revista
	String[] strRevista = { "Título de publicación", "Nombre de Revista", "Año", "Lugar",
			"Calificación" };

	//String que guarda los datos de Película
	String[] strPelicula = { "Título de obra", "Género", "Año", "Duración",
			"Calificación" };

	//String que guarda los datos de la Serie
	String[] strSerie = { "Nombre", "Temporada", "Año", "Empresa",
			"Calificación" };
	
	//String que guarda los datos de la categoría General
	String[] strGeneral = { "Título o Nombre", "Autor", "Año", "Breve Descripción" , "Calificación" };

	//String que guarda la dirección de la imagen
	String dirImagen = "";
	
	//String que guarda la calificación en números
	String strCalificacion = "0";
	
	//ComboBox para elegir el tipo de artículo que se va a registrar
	JComboBox<String> cbTipo;

	//Arreglo de RadioButtons que se usan para las estrellas
	JRadioButton[] radioButton = new JRadioButton[6];

	//Panel Contenedor de toda la ventana
	JPanel panelFrame;

	//Para asignar el layout de este frame
	GridBagConstraints gbc_1, gbc_2;

	//Color del label
	Color colorlbl = new Color(80, 30, 26);
	
	//Instancia de la clase Articulo, para registrar un artículo
	Articulo articulo_reg;
	
	//Copia de la imagen que se requiere para guardar
	BufferedImage nueva_imagen = null;
	
	//Archivo usado para guardar imagen seleccionada
	File selectedFile = null;
	
	//String para obtener la extención del archivo
	private String ex = "";
	private String preex;

	/**
	 * Constructor de la clase
	 */
	public claseRegistroArticulos() {

		//Se crean todos objetos del frame,
		//y se ponen en los páneles que los contendrán
		panelFrame = new JPanel();
		
		//Se asigna un Layout al panelFrmae
		panelFrame.setLayout(new FlowLayout());

		panelContenedor = new JPanel();
		panelGrid = new JPanel();

		//Configuración de botón para seleccionar imagen
		btnImagenArticulo = new JButton("<html><p align=\"center\">"
				+ "Imagen de Articulo </br> -Elegir Imagen-" + "</p></html>");
		btnImagenArticulo.setForeground(colorlbl);

		//Configuración de botón para guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);

		//Configuración de la etiqueta para Obra
		lblDatos[0] = new JLabel("Titulo de obra");
		lblDatos[0].setForeground(colorlbl);

		//Configuración de la etiqueta para Autor
		lblDatos[1] = new JLabel("Autor(es)");
		lblDatos[1].setForeground(colorlbl);

		//Configuración de la etiqueta para Editorial
		lblDatos[2] = new JLabel("Editorial");
		lblDatos[2].setForeground(colorlbl);

		//Configuración de la etiqueta para Edición
		lblDatos[3] = new JLabel("Edicion");
		lblDatos[3].setForeground(colorlbl);

		//Configuración de la etiqueta para Calificación
		lblDatos[4] = new JLabel("Calificación");
		lblDatos[4].setForeground(colorlbl);

		//Configuración de la etiqueta para Artículo
		lblTipo = new JLabel("Tipo Articulo");
		lblTipo.setForeground(colorlbl);

		//Configuración de la etiqueta para Descripción
		lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setForeground(colorlbl);

		//Se instancian los campos de texto
		txtDatos[0] = new JTextField(20);
		txtDatos[1] = new JTextField(20);
		txtDatos[2] = new JTextField(20);
		txtDatos[3] = new JTextField(20);

		
		//Configuración del ComboBox para el tipo
		strTipo = new String[] { "Libro", "Revista", "Película", "Serie", "General" };
		cbTipo = new JComboBox<String>(strTipo);

		//Se crea el Grupo de Botones y el panel para los radioButtons
		ButtonGroup group = new ButtonGroup();
		JPanel radioPanel = new JPanel(new GridLayout(1, 0));

		//Se configuran los RadioButtons para que tengan un número
		for (int i = 0; i < radioButton.length; i++) {
			radioButton[i] = new JRadioButton("" + i);
			group.add(radioButton[i]);
			radioButton[i].setActionCommand("" + i);
			radioButton[i].addActionListener(this);
			radioButton[i].setBackground(new Color(233, 75, 62));
			radioButton[i].setForeground(colorlbl);
			radioPanel.add(radioButton[i]);
		}
		radioPanel.setBackground(new Color(233, 75, 62));
		radioButton[0].setSelected(true);

		gbc_1 = new GridBagConstraints();
		gbc_2 = new GridBagConstraints();

		// Fin creación
		//Empieza impresión de objetos en los páneles
		panelContenedor.setLayout(new GridBagLayout());
		panelGrid.setLayout(new GridBagLayout());

		gbc_1.anchor = GridBagConstraints.LINE_END;
		
		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(8, 10, 0, 10);
		
		// Inicia grid en la posición x,y iguales a 0
		gbc_1.gridx = 0;
		gbc_1.gridy = 0;
		gbc_1.gridheight = 1;
		panelGrid.add(lblDatos[0], gbc_1);

		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(0, 10, 0, 10);
		
		gbc_1.gridx = 0;
		gbc_1.gridy = 1;

		panelGrid.add(lblDatos[1], gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 2;
		panelGrid.add(lblDatos[2], gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 3;
		panelGrid.add(lblDatos[3], gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 4;
		panelGrid.add(lblDatos[4], gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 5;
		panelGrid.add(lblTipo, gbc_1);

		gbc_1.gridx = 2;
		gbc_1.gridy = 7;
		gbc_1.anchor = GridBagConstraints.CENTER;
		gbc_1.insets = new Insets(20, 0, 0, 0);
		panelGrid.add(btnGuardar, gbc_1);
		btnGuardar.addActionListener(this);
		gbc_1.gridwidth = 1;

		// Derecha
		gbc_1.anchor = GridBagConstraints.CENTER;
		gbc_1.insets = new Insets(10, 0, 5, 10);

		gbc_1.gridx = 1;
		gbc_1.gridy = 0;
		panelGrid.add(txtDatos[0], gbc_1);

		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(0, 0, 5, 10);
		gbc_1.gridx = 1;
		gbc_1.gridy = 1;
		panelGrid.add(txtDatos[1], gbc_1);

		gbc_1.gridx = 1;
		gbc_1.gridy = 2;
		panelGrid.add(txtDatos[2], gbc_1);

		gbc_1.gridx = 1;
		gbc_1.gridy = 3;
		panelGrid.add(txtDatos[3], gbc_1);

		gbc_1.gridx = 1;
		gbc_1.gridy = 4;
		panelGrid.add(radioPanel, gbc_1);

		gbc_1.gridx = 1;
		gbc_1.gridy = 5;
		cbTipo.setBackground(Color.WHITE);
		cbTipo.addActionListener(this);
		panelGrid.add(cbTipo, gbc_1);

		gbc_1.gridx = 2;
		gbc_1.gridy = 0;
		gbc_1.gridheight = 7;
		gbc_1.insets = new Insets(0, 30, 20, 30);

		//Configuraciones de btnImagenArticulo
		btnImagenArticulo.setOpaque(false);
		btnImagenArticulo.setBorderPainted(false);
		btnImagenArticulo.setBackground(Color.WHITE);
		btnImagenArticulo.setFocusable(false);
		btnImagenArticulo.addActionListener(this);
		btnImagenArticulo.setPreferredSize(new Dimension(180, 150));
		panelGrid.add(btnImagenArticulo, gbc_1);

		gbc_1.gridx = 2;
		gbc_1.gridy = 6;
		gbc_1.gridheight = 1;
		
		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(0, 30, 0, 30);

		imgCalificacion = new ImageIcon(getClass().getResource("/recursos/0estrellas.png"));
		
		//Label Calificación
		lblCalificacion = new JLabel("");
		lblCalificacion.setIcon(imgCalificacion);
		panelGrid.add(lblCalificacion, gbc_1);

		panelGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Fin Agregar campos
		panelGrid.setBackground(new Color(233, 75, 62));

		ImageIcon imgLogo = new ImageIcon(getClass().getResource(
				"/recursos/BALogo.png"));
		lblLogo = new JLabel("");
		lblLogo.setIcon(imgLogo);
		gbc_1.gridx = 0;
		gbc_1.gridy = 0;
		gbc_1.gridheight = 1;
		
		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(32, -2, 25, 0);
		panelContenedor.add(lblLogo, gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 1;
		
		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(0, 0, 0, 0);
		panelContenedor.add(panelGrid, gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 2;
		gbc_1.anchor = GridBagConstraints.LINE_END;
		
		//Insets (top, left, bottom, right)
		gbc_1.insets = new Insets(25, 0, 0, 0);
		
		//Configuraciones del btnAtras
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		panelContenedor.add(btnAtras, gbc_1);

		panelFrame.add(panelContenedor);

	}

// TODO ActionListener()
	/**
     * Realiza las acciones de todos los los botones y el comboBox<code>cbTipo</code>
     * 
     * 
     */
	public void actionPerformed(ActionEvent e) {
		//Condicionales y acciones de cbTipo
		if (e.getSource() == cbTipo) {
			String tipo = (String) cbTipo.getSelectedItem();

			switch (tipo) {
			case "Libro":
				datosLibro();

				break;
			case "Revista":
				datosRevista();

				break;
			case "Película":
				datosPelicula();

				break;
			case "Serie":
				datosSerie();

				break;
			case "General":
				datosGeneral();
				
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción Inválida");
				break;
			}

			panelContenedor.revalidate();
			panelContenedor.repaint();

		//Acción de btnImagenArticulo
		} else if (e.getSource() == btnImagenArticulo) {
			ex="";
			ElegirImagen();

			panelContenedor.revalidate();
			panelContenedor.repaint();
			
			//Acción del btnGuardar
			//Se guardan los datos en un archivo txt, y la imagen en un directorio propio
		} else if (e.getSource() == btnGuardar) {
			
			
			if ( verificarDatos() ){
				
				try{
					BufferedImage scalaIMG = Imagen.getImagenRedimensionada(dirImagen,100,100);
					
					ImageIO.write(scalaIMG, ex, new File( "Biblioteca_Alejandrina/recursosImagen/articulo"+Registro.articulosRegistrados.size()+"."+ex ));
					dirImagen = "Biblioteca_Alejandrina/recursosImagen/articulo"+Registro.articulosRegistrados.size()+"."+ex;
				}
				catch(Exception r){r.printStackTrace();}//TODO imagen
				
				guardarDatos();
				String s = "";
				
				s+="Tipo: "+cbTipo.getSelectedItem().toString()+"\n";
				s+="Dato 1: "+txtDatos[0].getText()+"\n";
				s+="Dato 2: "+txtDatos[1].getText()+"\n";
				s+="Dato 3: "+txtDatos[2].getText()+"\n";
				s+="Dato 4: "+txtDatos[3].getText()+"\n";
				s+="Imagen: "+dirImagen+"\n";
				s+="Calificación: "+strCalificacion+"\n";
				
				JOptionPane.showMessageDialog(null, s);
				
				limpiarDatos();
				
			//Excepción para saber si falta algún campo por llenar
			}else{
				JOptionPane.showMessageDialog(null, "Fatan datos por completar");
			}
			
		//Acción del btnAtras	
		} else if (e.getSource() == btnAtras) {

			limpiarDatos();
			ClaseHome home = new ClaseHome();

			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.ventana.revalidate();
			home.ventana.repaint();
			
		} 
		//Switch para colocar imagen de estrellas en la pantalla
		else {
			switch (e.getActionCommand()) {
			case "0":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/0estrellas.png")));
				strCalificacion = "0";
				break;
			case "1":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/1estrellas.png")));
				strCalificacion = "1";
				break;
			case "2":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/2estrellas.png")));
				strCalificacion = "2";
				break;
			case "3":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/3estrellas.png")));
				strCalificacion = "3";
				break;
			case "4":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/4estrellas.png")));
				strCalificacion = "4";
				break;
			case "5":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/5estrellas.png")));
				strCalificacion = "5";
				break;
			default:
				break;
			}
		}

	}
	
	
	/**
     * Obtiene el contenedor
     * 
     * @return panelFrame
     * 
     */
	public Container getContenedor() {
		return panelFrame;
	}
	
	public void guardarDatos(){
		
		articulo_reg = new Articulo( cbTipo.getSelectedItem().toString() , txtDatos[0].getText(), txtDatos[1].getText(), txtDatos[2].getText(), txtDatos[3].getText(), dirImagen, strCalificacion);
		Registro.articulosRegistrados.add(articulo_reg);
		Registro.guardarEstadoActualSistema();
		
	}
	
	/**
     * Comprueba que los campos de texto tengan la información correcta 
     */
	public boolean verificarDatos(){
		
		for (int i = 0; i < txtDatos.length; i++){
			if ( txtDatos[i].getText().matches("\\s*") ){
				return false;
			}
		}
		
		if ( dirImagen == "" ){
			return false;
		}
		
		return true;
	}

	/**
     * Configura la información de la pantalla cuando se selecciona Libros en la categoría
     * Utiliza <code>strLibro</code> para configurar los objetos
     *  
     */
	public void datosLibro() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strLibro[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	/**
     * Configura la información de la pantalla cuando se selecciona General en la categoría
     * Utiliza <code>strGeneral</code> para configurar los objetos
     *  
     */
	public void datosGeneral() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strGeneral[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}
	

	/**
     * Configura la información de la pantalla cuando se selecciona Revista en la categoría
     * Utiliza <code>strRevista</code> para configurar los objetos
     *  
     */
	public void datosRevista() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strRevista[i]);
			txtDatos[i].setText("");
		}

		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	
	/**
     * Configura la información de la pantalla cuando se selecciona Película en la categoría
     * Utiliza <code>strPelicula</code> para configurar los objetos
     *  
     */
	public void datosPelicula() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strPelicula[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	
	/**
     * Configura la información de la pantalla cuando se selecciona Serie en la categoría
     * Utiliza <code>strSerie</code> para configurar los objetos
     *  
     */
	public void datosSerie() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strSerie[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);

	}
	
	
	/**
     * Limpia los datos de la pantalla
     * 
     *  @see #datosLibro()
     *  @see #limpiarImagen()
     */
	public void limpiarDatos() {
		datosLibro();
		LimpiarImagen();
		ex = "";
	}
	
	/**
     * Limpia la Imagen que se puso cuando se seleccionó una. Lo hace con <code>btnImagenArticulo</code>
     *  
     */
	public void LimpiarImagen() {
		btnImagenArticulo.setIcon(null);
		btnImagenArticulo.setText("<html><p align=\"center\">"
				+ "Imagen de Articulo </br> -Elegir Imagen-" + "</p></html>");
		btnImagenArticulo.setForeground(colorlbl);
		btnImagenArticulo.setPreferredSize(new Dimension(180, 150));
		
		dirImagen = "";
	}

	/**
     * Elige la imagen mediante un <code>JFileChooser</code>() y la guarda en una variable tipo BufferedImage 
     */
	public void ElegirImagen() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images",
				"jpg", "png", "gif", "bmp");
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			//Se guarda la extención del archivo
			preex = selectedFile.getName();
			for(int n=0; n<preex.length(); n++){
				if((preex.length() - n) <= 3){
					char c = preex.charAt(n);
					ex += c;
				}
			}
			
			String path = selectedFile.getPath();
			
			dirImagen = path;

			BufferedImage imgArticulo = null;
			
			//Se redimensiona la imagen
			try {
				imgArticulo = Imagen.getImagenRedimensionada(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//Se le asigna la imagen al botón
			btnImagenArticulo.setIcon(new ImageIcon(imgArticulo));

			btnImagenArticulo.setPreferredSize(new Dimension(imgArticulo
					.getWidth(), imgArticulo.getHeight()));
			btnImagenArticulo.setText("");
		}
	}

}
