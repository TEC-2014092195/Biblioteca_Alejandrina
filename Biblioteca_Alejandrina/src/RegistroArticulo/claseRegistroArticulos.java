/**====================================================================================
 * Archivo    : claseRegistroArticulos.java » Paquete: RegistroArticulo » Proyecto: Biblioteca_Alejandrina
 * Autor      : Kevin Hernández Rostrán
 * Carné      : 2014092195
 * Curso      : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion:
 **==================================================================================== 
 */

package RegistroArticulo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class claseRegistroArticulos extends JFrame implements ActionListener{
	JLabel lblTipo,lblLogo;
	JLabel[] lblDatos = new JLabel[5];
	JTextField txtTitulo,txtAutor,txtEditorial,txtEdicion;
	JTextField[] txtDatos =new JTextField[5];
	JPanel panelGrid,panelContenedor;
	String[] strTipo;
	String[] strLibro = { "Título de obra", "Autor(es)", "Editorial", "Edición", "Datos5" };
	String[] strRevista = { "Título de obra", "Autor", "Editorial", "Edición", "Datos5" };
	String[] strPelicula = { "Título de obra", "Género", "Fecha", "Estrellas", "Datos5" };
	String[] strSerie = { "Nombre", "Temporada", "Año", "Empresa", "Datos5" };
	
	JComboBox cbTipo;
	JFrame frm;
	GridBagConstraints gbc_1,gbc_2;
	
	
	public void crearObjetos(){
		frm = new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(800, 600);
		frm.setLocationRelativeTo(null);
		frm.setLayout(new FlowLayout());
		
		panelContenedor = new JPanel();
		panelGrid = new JPanel();
		
		Color colorlbl = new Color(80,30,26);
		
		
		lblDatos[0] = new JLabel("Titulo de obra");
		lblDatos[0].setForeground(colorlbl);
		
		lblDatos[1] = new JLabel("Autor(es)");
		lblDatos[1].setForeground(colorlbl);
		
		lblDatos[2] = new JLabel("Editorial");
		lblDatos[2].setForeground(colorlbl);
		
		lblDatos[3] = new JLabel("Edicion");
		lblDatos[3].setForeground(colorlbl);
		
		lblDatos[4] = new JLabel("Dato 5");
		lblDatos[4].setForeground(colorlbl);
		
		lblTipo = new JLabel("Tipo Articulo");
		lblTipo.setForeground(colorlbl);
		
		txtDatos[0] = new JTextField(20);
		txtDatos[1] = new JTextField(20);
		txtDatos[2] = new JTextField(20);
		txtDatos[3] = new JTextField(20);
		txtDatos[4] = new JTextField(20);
		
		strTipo = new String[] { "Libro","Revista","Película","Serie" };
		cbTipo = new JComboBox(strTipo);
		
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
		panelGrid.add(lblTipo,gbc_1);
		
		
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
		panelGrid.add(txtDatos[4],gbc_1);
		
		gbc_1.gridx=1;
		gbc_1.gridy=5;
		cbTipo.setBackground(Color.WHITE);
		cbTipo.addActionListener(this);
		panelGrid.add(cbTipo,gbc_1);
		
		
		//Fin Agregar campos
		panelGrid.setBackground(new Color(233,75,62));
		
		
		
		ImageIcon img = new ImageIcon(getClass().getResource("/recursos/BALogo.png"));
		lblLogo = new JLabel("");
		lblLogo.setIcon(img);
		gbc_1.gridx=0;
		gbc_1.gridy=0;
		gbc_1.insets = new Insets(32,-5,50,0); 
		panelContenedor.add(lblLogo,gbc_1);
		
		gbc_1.gridx=0;
		gbc_1.gridy=1;
		gbc_1.insets = new Insets(0,0,0,0);
		panelContenedor.add(panelGrid,gbc_1);
		
		
		
		frm.add(panelContenedor);
		
		frm.setVisible(true);
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args){
		claseRegistroArticulos n = new claseRegistroArticulos();
		n.crearObjetos();
	}
	
	public void datosLibro(){
		
		for (int i=0; i < lblDatos.length -1 ; i++){
			lblDatos[i].setText(strLibro[i]);
			txtDatos[i].setText("");
		}
		
	}
	
	public void datosRevista(){
		
		for (int i=0; i < lblDatos.length -1 ; i++){
			lblDatos[i].setText(strRevista[i]);
			txtDatos[i].setText("");
		}
		
	}
	
	public void datosPelicula(){
		
		for (int i=0; i < lblDatos.length -1 ; i++){
			lblDatos[i].setText(strPelicula[i]);
			txtDatos[i].setText("");
		}
		
	}
	public void datosSerie(){
		
		for (int i=0; i < lblDatos.length -1 ; i++){
			lblDatos[i].setText(strSerie[i]);
			txtDatos[i].setText("");
		}
		
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cbTipo){
			String tipo = (String)cbTipo.getSelectedItem();
			
			
			switch(tipo){
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
			
		}
		
	}
	

}
