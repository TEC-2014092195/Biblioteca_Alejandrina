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

import Main.ClaseHome;
import redimensionar.Imagen;


// TODO: Auto-generated Javadoc
/**
 * The Class claseRegistroArticulos.
 */
public class claseRegistroArticulos extends JFrame implements ActionListener{
	
	/** The lbl descripcion. */
	JLabel lblTipo,lblLogo,lblDescripcion,lblCalificacion;//,lblImagenArticulo;
	
	/** The btn atras. */
	JButton btnImagenArticulo,btnGuardar,btnAtras;
	
	ImageIcon imgCalificacion;
	
	
	/** The lbl datos. */
	JLabel[] lblDatos = new JLabel[5];
	
	/** The txt edicion. */
	JTextField txtTitulo,txtAutor,txtEditorial,txtEdicion;
	
	/** The txt datos. */
	JTextField[] txtDatos = new JTextField[5];
	
	/** The txta descripcion. */
	JTextArea txtaDescripcion;
	
	/** The panel contenedor. */
	JPanel panelGrid,panelContenedor;
	
	/** The str tipo. */
	String[] strTipo;
	
	/** The str libro. */
	String[] strLibro = { "Título de obra", "Autor(es)", "Editorial", "Edición", "Calificación" };
	
	/** The str revista. */
	String[] strRevista = { "Título de obra", "Autor", "Editorial", "Edición", "Calificación" };
	
	/** The str pelicula. */
	String[] strPelicula = { "Título de obra", "Género", "Fecha", "Estrellas", "Calificación" };
	
	/** The str serie. */
	String[] strSerie = { "Nombre", "Temporada", "Año", "Empresa", "Calificación" };
	
	/** The cb tipo. */
	JComboBox cbTipo;
	
	JRadioButton[] radioButton = new JRadioButton[6];
	
	
	/** The frm. */
	JPanel frm;
	
	/** The gbc_2. */
	GridBagConstraints gbc_1,gbc_2;
	
	Color colorlbl = new Color(80,30,26);
	
	
	/**
	 * Instantiates a new copy ofclase registro articulos.
	 */
	public claseRegistroArticulos(){
		
		frm = new JPanel();
		frm.setLayout(new FlowLayout());
		
		panelContenedor = new JPanel();
		panelGrid = new JPanel();
		
		
		
		btnImagenArticulo = new JButton("<html><p align=\"center\">"+"Imagen de Articulo </br> -Elegir Imagen-"+"</p></html>");
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
		txtDatos[4] = new JTextField(20);
		
		txtaDescripcion = new JTextArea(5,20);	
		
		strTipo = new String[] { "Libro","Revista","Película","Serie" };
		cbTipo = new JComboBox(strTipo);
		
		
		
//		JRadioButton ceroButton = new JRadioButton("0");
//	    //birdButton.setActionCommand("0");
//	    ceroButton.setSelected(true);
//	    
//	    JRadioButton unoButton = new JRadioButton("0");
//	    //birdButton.setActionCommand("0");
//	    unoButton.setSelected(true);
//	    
//	    JRadioButton dosButton = new JRadioButton("0");
//	    //birdButton.setActionCommand("0");
//	    dosButton.setSelected(true);
//	    
//	    JRadioButton tresButton = new JRadioButton("0");
//	    //birdButton.setActionCommand("0");
//	    tresButton.setSelected(true);
//	    
//	    JRadioButton cuatroButton = new JRadioButton("0");
//	    //birdButton.setActionCommand("0");
//	    cuatroButton.setSelected(true);
	    
		
		
		
        
        
        
        
        
        
        
        
        ButtonGroup group = new ButtonGroup();
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        
        for (int i = 0; i < radioButton.length; i++ ){
        	radioButton[i] = new JRadioButton(""+i);
        	group.add(radioButton[i]);
        	radioButton[i].setActionCommand(""+i);
        	radioButton[i].addActionListener(this);
        	radioButton[i].setBackground(new Color(233,75,62));
        	radioButton[i].setForeground(colorlbl);
        	radioPanel.add(radioButton[i]);
        }
        radioPanel.setBackground(new Color(233,75,62));
        radioButton[0].setSelected(true);
        
        
	    
		gbc_1 = new GridBagConstraints();
		gbc_2 = new GridBagConstraints();
		
		//Fin creacion
		panelContenedor.setLayout(new GridBagLayout());
		panelGrid.setLayout(new GridBagLayout());
		
		
		gbc_1.anchor= GridBagConstraints.FIRST_LINE_END;
		gbc_1.insets = new Insets(10,10,0,10); // Extrenal Pad (top, left, bottom, right)
		
		gbc_1.gridx=0;
		gbc_1.gridy=0;
		gbc_1.gridheight=1;
		panelGrid.add(lblDatos[0],gbc_1);
		
		
		gbc_1.insets = new Insets(0,10,0,10); // Extrenal Pad (top, left, bottom, right)
		gbc_1.gridx=0;
		gbc_1.gridy=1;
		 
		panelGrid.add(lblDatos[1],gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=2;
		panelGrid.add(lblDatos[2],gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=3;
		panelGrid.add(lblDatos[3],gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=4;
		panelGrid.add(lblDatos[4],gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=5;
		panelGrid.add(lblDescripcion,gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=6;
		panelGrid.add(lblTipo,gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=7;
		gbc_1.gridwidth=3;
		gbc_1.anchor= GridBagConstraints.CENTER;
		gbc_1.insets = new Insets(20,0,5,10);
		panelGrid.add(btnGuardar,gbc_1);
		btnGuardar.addActionListener(this);
		gbc_1.gridwidth=1;
		
		//Derecha
		gbc_1.anchor= GridBagConstraints.CENTER;
		gbc_1.insets = new Insets(10,0,5,10);
		
		
		gbc_1.gridx=1;
		gbc_1.gridy=0;
		panelGrid.add(txtDatos[0],gbc_1);
		
		
		gbc_1.insets = new Insets(0,0,5,10); // Extrenal Pad (top, left, bottom, right)
		gbc_1.gridx=1;
		gbc_1.gridy=1;
		panelGrid.add(txtDatos[1],gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=2;
		panelGrid.add(txtDatos[2],gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=3;
		panelGrid.add(txtDatos[3],gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=4;
		panelGrid.add(radioPanel,gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=5;
		panelGrid.add(txtaDescripcion,gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=6;
		cbTipo.setBackground(Color.WHITE);
		cbTipo.addActionListener(this);
		panelGrid.add(cbTipo,gbc_1);
		
		gbc_1.gridx=2;
		gbc_1.gridy=0;
		gbc_1.gridheight=7;
		gbc_1.insets = new Insets(0,30,0,30);
		
		
		btnImagenArticulo.setOpaque(false);
		btnImagenArticulo.setBorderPainted(false);
		btnImagenArticulo.setBackground(Color.WHITE);
		btnImagenArticulo.setFocusable(false);
		btnImagenArticulo.addActionListener(this);
		btnImagenArticulo.setPreferredSize(new Dimension(180,150));
		panelGrid.add(btnImagenArticulo,gbc_1);
		
		gbc_1.gridx=2;
		gbc_1.gridy=6;
		gbc_1.gridheight=1;
		gbc_1.insets = new Insets(0,30,0,30);
		
		imgCalificacion = new ImageIcon(getClass().getResource("/recursos/0estrellas.png"));
		lblCalificacion = new JLabel("");
		lblCalificacion.setIcon(imgCalificacion);
		panelGrid.add(lblCalificacion,gbc_1);
		
		
		//Fin Agregar campos
		panelGrid.setBackground(new Color(233,75,62));
		
		ImageIcon imgLogo = new ImageIcon(getClass().getResource("/recursos/BALogo.png"));
		lblLogo = new JLabel("");
		lblLogo.setIcon(imgLogo);
		gbc_1.gridx=0;
		gbc_1.gridy=0;
		gbc_1.gridheight=1;
		gbc_1.insets = new Insets(32,-2,25,0); 
		panelContenedor.add(lblLogo,gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=1;
		gbc_1.insets = new Insets(0,0,0,0);
		panelContenedor.add(panelGrid,gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=2;
		gbc_1.anchor = GridBagConstraints.LINE_END;
		gbc_1.insets = new Insets(25,0,0,0); // Extrenal Pad (top, left, bottom, right)
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		panelContenedor.add(btnAtras,gbc_1);
		
		
		frm.add(panelContenedor);
		
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
			System.out.println("Boton guardar");
		} else if (e.getSource() == btnAtras) {

			LimpiarImagen();
			ClaseHome home = new ClaseHome();

			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.getFrame().revalidate();
			home.getFrame().repaint();

		} else {
			switch (e.getActionCommand()) {
			case "0":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/0estrellas.png")));
				break;
			case "1":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/1estrellas.png")));
				break;
			case "2":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/2estrellas.png")));
				break;
			case "3":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/3estrellas.png")));
				break;
			case "4":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/4estrellas.png")));
				break;
			case "5":
				lblCalificacion.setIcon(new ImageIcon(getClass().getResource(
						"/recursos/5estrellas.png")));
				break;
			default:
				break;
			}
		}

	}
	
	
	public Container getContenedor() {
		return frm;
	}

	/**
	 * Datos libro.
	 */
	public void datosLibro() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strLibro[i]);
			txtDatos[i].setText("");
		}

	}

	/**
	 * Datos revista.
	 */
	public void datosRevista() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strRevista[i]);
			txtDatos[i].setText("");
		}

	}

	/**
	 * Datos pelicula.
	 */
	public void datosPelicula() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strPelicula[i]);
			txtDatos[i].setText("");
		}

	}

	/**
	 * Datos serie.
	 */
	public void datosSerie() {

		for (int i = 0; i < lblDatos.length - 1; i++) {
			lblDatos[i].setText(strSerie[i]);
			txtDatos[i].setText("");
		}

	}

	private void LimpiarImagen() {
		btnImagenArticulo.setIcon(null);
		btnImagenArticulo.setText("<html><p align=\"center\">"
				+ "Imagen de Articulo </br> -Elegir Imagen-" + "</p></html>");
		btnImagenArticulo.setForeground(colorlbl);
		btnImagenArticulo.setPreferredSize(new Dimension(180, 150));
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
