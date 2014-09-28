/**====================================================================================
 * Archivo      : ClaseConsulta.java » Paquete: consultas » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package consultas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TabableView;

import main.ClaseHome;

@SuppressWarnings("serial")
public class ClaseConsulta extends JFrame implements ActionListener{
	JPanel panelContenedor = new JPanel(); 
	JPanel panelGrid = new JPanel();
	JPanel panelFrame = new JPanel();
	
	JComboBox<String> cbTipoArticulo;
	String[] strTipoArticulo;
	
	JComboBox<String> cbTipoConsulta;
	String[] strTipoConsulta;
	
	JComboBox<String> cbTipoFiltro;
	String[] strTipoFiltro;
	
	JLabel lblVeces, lblMeses, lblVeces2, lblMeses2;
	JTextField txtVeces, txtMeses;
	
	JButton btnGenerarConsulta, btnAtras;
	
	GridBagConstraints grid = new GridBagConstraints();
	
	public ClaseConsulta() {
		
		panelContenedor.setLayout(new GridBagLayout());
		
		
		
		panelGrid.setLayout(new GridBagLayout());
		panelGrid.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		panelGrid.setBackground(Color.LIGHT_GRAY);
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblSelArt = new JLabel("Seleccione el Articulo: ");
		panelGrid.add(lblSelArt,grid);
		
		grid.gridx=1;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 30);
		strTipoArticulo = new String[] { "Libro","Revista","Película","Serie", "General","Todos" };
		cbTipoArticulo = new JComboBox<String>(strTipoArticulo);
		cbTipoArticulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo = (String) cbTipoArticulo.getSelectedItem();
				switch (tipo) {
				case "Libro":
					filtroTipo();
					break;
				case "Revista":
					filtroTipo();
					break;
				case "Película":
					filtroTipo();
					break;
				case "Serie":
					filtroTipo();
					break;
				case "General":
					filtroTipo();
					break;
				case "Todos":
					filtroTipo();
//					System.out.println("Prueba Todos");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción Inválida");
					break;
				}
				
			}
		});
		panelGrid.add(cbTipoArticulo,grid);
		
		
		
		
		grid.gridx=2;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblConsultaPor = new JLabel("Tipo de Consulta: ");
		panelGrid.add(lblConsultaPor,grid);
		
		grid.gridx=3;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 30);
		strTipoConsulta = new String[] { "Artículo","Artículos Prestados","Artículos No Prestados","Más Prestados","Personalizado" };
		cbTipoConsulta = new JComboBox<String>(strTipoConsulta);
		panelGrid.add(cbTipoConsulta,grid);
		
		
		grid.gridx=4;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblOrdenarPor = new JLabel("Filtrar Por: ");
		panelGrid.add(lblOrdenarPor,grid);
		
		grid.gridx=5;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 0);
		strTipoFiltro = new String[] { "Título","Autor","Editorial" };
		cbTipoFiltro = new JComboBox<String>(strTipoFiltro);
		panelGrid.add(cbTipoFiltro,grid);
		
		
		grid.gridx=0;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 10);
		lblVeces = new JLabel("Articulo prestado más de: ");
		panelGrid.add(lblVeces,grid);
		
		
		grid.gridx=1;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		txtVeces = new JTextField(3);
		txtVeces.setText("0");
		panelGrid.add(txtVeces,grid);
		
		grid.gridx=1;
		grid.gridy=1;
		grid.insets = new Insets( 10, 40, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		lblVeces2 = new JLabel(" veces");
		panelGrid.add( lblVeces2,grid);
		
		
		grid.gridx=2;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 10);
		grid.anchor = GridBagConstraints.LINE_END;
		lblMeses = new JLabel("Los últimos: ");
		panelGrid.add(lblMeses,grid);
		
		grid.gridx=3;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		txtMeses = new JTextField(3);
		txtMeses.setText("0");
		panelGrid.add(txtMeses,grid);
		
		grid.gridx=3;
		grid.gridy=1;
		grid.insets = new Insets( 10, 40, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		lblMeses2 = new JLabel(" meses");
		panelGrid.add( lblMeses2,grid);
		
		ocultarConsultaPersonalizado();
		
		grid.gridx=4;
		grid.gridy=1;
		grid.gridwidth = 2;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.CENTER;
		btnGenerarConsulta = new JButton("Generar Consulta");
		panelGrid.add( btnGenerarConsulta,grid);
		
		//-----------------Add tabla
		grid.gridx=0;
		grid.gridy=2;
		grid.gridwidth = 6;
		grid.fill=GridBagConstraints.BOTH;
		TablaConsultas t = new TablaConsultas();
		panelGrid.add(t,grid);
		
		//-----------------
		
		
		
		//ActionListeners
		cbTipoArticulo.addActionListener(this);
		cbTipoConsulta.addActionListener(this);
		cbTipoFiltro.addActionListener(this);
		btnGenerarConsulta.addActionListener(this);
		
		grid.fill=GridBagConstraints.NONE;
		grid.gridx=0;
		grid.gridy=0;
		panelContenedor.add(panelGrid,grid);
		
		
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		
		grid.gridx=0;
		grid.gridy=1;
		grid.anchor = GridBagConstraints.LINE_END;
		panelContenedor.add(btnAtras, grid);
		
		
		
		panelFrame.add(panelContenedor);
		
	}
	
	
	public Container getContenedor(){
		return panelFrame;
	}
	
	
	private void filtroTipo() {
		
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			String itemTipoArticulo = (String)cbTipoArticulo.getSelectedItem();
			rf = RowFilter.regexFilter(itemTipoArticulo, 0); // (Patron a filtrar, int columna) 
			
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaConsultas.sorter.setRowFilter(rf);
		String cb =(String)cbTipoArticulo.getSelectedItem(); 
		
		if( "Todos".equals(cb)){
			System.out.println("priint todo");
			TablaConsultas.sorter.sort();
			rf = RowFilter.regexFilter("", 0);
			TablaConsultas.sorter.setRowFilter(rf);
		}
		
	}


	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbTipoConsulta){
			String consulta = cbTipoConsulta.getSelectedItem().toString();
			
			switch(consulta){
				case "Personalizado":
					mostrarConsultaPersonalizado();
					break;
				default:
					ocultarConsultaPersonalizado();
					break;
			}
			
		} else if (e.getSource() == btnAtras) {

			ClaseHome home = new ClaseHome();

			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.ventana.revalidate();
			home.ventana.repaint();

		}
		
	}
	
	public void mostrarConsultaPersonalizado(){
		lblVeces.setVisible(true);
		txtVeces.setVisible(true);
		lblVeces2.setVisible(true);
		
		lblMeses.setVisible(true);
		txtMeses.setVisible(true);
		lblMeses2.setVisible(true);
	}
		
	public void ocultarConsultaPersonalizado(){
		lblVeces.setVisible(false);
		txtVeces.setVisible(false);
		lblVeces2.setVisible(false);
		
		lblMeses.setVisible(false);
		txtMeses.setVisible(false);
		lblMeses2.setVisible(false);
	}
	


}
