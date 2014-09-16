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
import Main.ClaseHome;
import redimensionar.Imagen;

// TODO: Auto-generated Javadoc
/**
 * The Class claseRegistroArticulos. Clase de interfaz Crea la interfaz para
 * ingresar un nuevo artículo o editar uno existente
 */
public class claseRegistroArticulos extends JFrame implements ActionListener {

	/** The lbl descripcion. */
	JLabel lblTipo, lblLogo, lblDescripcion, lblCalificacion;// ,lblImagenArticulo;

	/** The btn atras. */
	JButton btnImagenArticulo, btnGuardar, btnAtras;

	ImageIcon imgCalificacion;

	/** The lbl datos. */
	JLabel[] lblDatos = new JLabel[5];


	/** The txt datos. */
	JTextField[] txtDatos = new JTextField[4];

	/** The txta descripcion. */
	

	/** The panel contenedor. */
	JPanel panelGrid, panelContenedor;

	/** The str tipo. */
	String[] strTipo;

	/** The str libro. */
	String[] strLibro = { "Título de obra", "Autor(es)", "Editorial",
			"Edición", "Calificación" };

	/** The str revista. */
	String[] strRevista = { "Título de publicación", "Nombre de Revista", "Año", "Lugar",
			"Calificación" };

	/** The str pelicula. */
	String[] strPelicula = { "Título de obra", "Género", "Año", "Duración",
			"Calificación" };

	/** The str serie. */
	String[] strSerie = { "Nombre", "Temporada", "Año", "Empresa",
			"Calificación" };
	
	String[] strGeneral = { "Título o Nombre", "Autor", "Año", "Breve Descripción" , "Calificación" };

	String dirImagen = "";
	
	String strCalificacion = "0";
	
	/** The cb tipo. */

	JComboBox<String> cbTipo;

	JRadioButton[] radioButton = new JRadioButton[6];

	/** The panelFrame. */
	JPanel panelFrame;

	/** The gbc_2. */
	GridBagConstraints gbc_1, gbc_2;

	Color colorlbl = new Color(80, 30, 26);
	
	Articulo articulo_reg;

	/**
	 * Instantiates a new copy ofclase registro articulos.
	 */
	public claseRegistroArticulos() {

		panelFrame = new JPanel();
		panelFrame.setLayout(new FlowLayout());

		panelContenedor = new JPanel();
		panelGrid = new JPanel();

		btnImagenArticulo = new JButton("<html><p align=\"center\">"
				+ "Imagen de Articulo </br> -Elegir Imagen-" + "</p></html>");
		btnImagenArticulo.setForeground(colorlbl);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);

		lblDatos[0] = new JLabel("Titulo de obra");
		lblDatos[0].setForeground(colorlbl);

		lblDatos[1] = new JLabel("Autor(es)");
		lblDatos[1].setForeground(colorlbl);

		lblDatos[2] = new JLabel("Editorial");
		lblDatos[2].setForeground(colorlbl);

		lblDatos[3] = new JLabel("Edicion");
		lblDatos[3].setForeground(colorlbl);

		lblDatos[4] = new JLabel("Calificación");
		lblDatos[4].setForeground(colorlbl);

		lblTipo = new JLabel("Tipo Articulo");
		lblTipo.setForeground(colorlbl);

		lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setForeground(colorlbl);

		txtDatos[0] = new JTextField(20);
		txtDatos[1] = new JTextField(20);
		txtDatos[2] = new JTextField(20);
		txtDatos[3] = new JTextField(20);

		

		strTipo = new String[] { "Libro", "Revista", "Película", "Serie", "General" };
		cbTipo = new JComboBox<String>(strTipo);

		ButtonGroup group = new ButtonGroup();
		JPanel radioPanel = new JPanel(new GridLayout(1, 0));

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

		// Fin creacion
		panelContenedor.setLayout(new GridBagLayout());
		panelGrid.setLayout(new GridBagLayout());

		gbc_1.anchor = GridBagConstraints.LINE_END;
		gbc_1.insets = new Insets(8, 10, 0, 10); // Extrenal Pad (top, left,
													// bottom, right)
		gbc_1.gridx = 0;
		gbc_1.gridy = 0;
		gbc_1.gridheight = 1;
		panelGrid.add(lblDatos[0], gbc_1);

		gbc_1.insets = new Insets(0, 10, 0, 10); // Extrenal Pad (top, left,
													// bottom, right)
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

		gbc_1.insets = new Insets(0, 0, 5, 10); // Extrenal Pad (top, left,
												// bottom, right)
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
		gbc_1.insets = new Insets(0, 30, 0, 30);

		imgCalificacion = new ImageIcon(getClass().getResource(
				"/recursos/0estrellas.png"));
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
		gbc_1.insets = new Insets(32, -2, 25, 0);
		panelContenedor.add(lblLogo, gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 1;
		gbc_1.insets = new Insets(0, 0, 0, 0);
		panelContenedor.add(panelGrid, gbc_1);

		gbc_1.gridx = 0;
		gbc_1.gridy = 2;
		gbc_1.anchor = GridBagConstraints.LINE_END;
		gbc_1.insets = new Insets(25, 0, 0, 0); // Extrenal Pad (top, left,
												// bottom, right)
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		panelContenedor.add(btnAtras, gbc_1);

		panelFrame.add(panelContenedor);

	}

	public void actionPerformed(ActionEvent e) {
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

		} else if (e.getSource() == btnImagenArticulo) {

			ElegirImagen();

			panelContenedor.revalidate();
			panelContenedor.repaint();
		} else if (e.getSource() == btnGuardar) {
			
			
			if ( verificarDatos() ){
				
				guardarDatos();
				
				
			}else{
				JOptionPane.showMessageDialog(null, "Fatan datos por completar");
			}
			
			
		} else if (e.getSource() == btnAtras) {

			limpiarDatos();
			ClaseHome home = new ClaseHome();

			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.getFrame().revalidate();
			home.getFrame().repaint();

		} else {
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

	public Container getContenedor() {
		return panelFrame;
	}
	
	public void guardarDatos(){
		
		articulo_reg = new Articulo( cbTipo.getSelectedItem().toString() , txtDatos[0].getText(), txtDatos[1].getText(), txtDatos[2].getText(), txtDatos[3].getText(), dirImagen, strCalificacion);
		Registro.recuperarEstadoSistema();
		Registro.articulosRegistrados.add(articulo_reg);
		System.out.println(articulo_reg.toString());
		Registro.guardarEstadoActualSistema();
		
	}
	
	
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

	
	public void datosLibro() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strLibro[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	public void datosGeneral() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strGeneral[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}
	

	
	public void datosRevista() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strRevista[i]);
			txtDatos[i].setText("");
		}

		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	
	public void datosPelicula() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strPelicula[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);
	}

	
	public void datosSerie() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strSerie[i]);
			txtDatos[i].setText("");
		}
		
		radioButton[0].setSelected(true);
		lblCalificacion.setIcon(imgCalificacion);

	}

	public void limpiarDatos() {
		datosLibro();
		LimpiarImagen();
	}

	public void LimpiarImagen() {
		btnImagenArticulo.setIcon(null);
		btnImagenArticulo.setText("<html><p align=\"center\">"
				+ "Imagen de Articulo </br> -Elegir Imagen-" + "</p></html>");
		btnImagenArticulo.setForeground(colorlbl);
		btnImagenArticulo.setPreferredSize(new Dimension(180, 150));
		
		dirImagen = "";
	}

	public void ElegirImagen() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images",
				"jpg", "png", "gif", "bmp");
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println(selectedFile.getPath());
			String path = selectedFile.getPath();
			
			dirImagen = path;

			BufferedImage imgArticulo = null;
			try {
				imgArticulo = Imagen.getImagenRedimensionada(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			btnImagenArticulo.setIcon(new ImageIcon(imgArticulo));

			btnImagenArticulo.setPreferredSize(new Dimension(imgArticulo
					.getWidth(), imgArticulo.getHeight()));
			btnImagenArticulo.setText("");
		}
	}

}
