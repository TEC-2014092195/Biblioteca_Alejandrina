/**====================================================================================
 * Archivo      : ClaseConsulta.java » Paquete: consultas » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package consultas;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClaseConsulta extends JFrame implements ActionListener{
	JPanel panelFrame = new JPanel(); 
	JPanel panelContenedor = new JPanel();
	
	JComboBox<String> cbTipoArticulo;
	String[] strTipoArticulo;
	
	JComboBox<String> cbTipoConsulta;
	String[] strTipoConsulta;
	
	JComboBox<String> cbTipoFiltro;
	String[] strTipoFiltro;
	
	JLabel lblVeces, lblMeses, lblVeces2, lblMeses2;
	JTextField txtVeces, txtMeses;
	
	JButton btnGenerarConsulta;
	
	GridBagConstraints grid = new GridBagConstraints();
	
	public ClaseConsulta() {
		panelContenedor.setLayout(new GridBagLayout());
		panelContenedor.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelContenedor.setBackground(Color.LIGHT_GRAY);
		
		grid.gridx=0;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblSelArt = new JLabel("Seleccione el Articulo: ");
		panelContenedor.add(lblSelArt,grid);
		
		grid.gridx=1;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 30);
		strTipoArticulo = new String[] { "Libro","Revista","Película","Serie","Todos" };
		cbTipoArticulo = new JComboBox<String>(strTipoArticulo);
		panelContenedor.add(cbTipoArticulo,grid);
		
		
		
		
		grid.gridx=2;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblConsultaPor = new JLabel("Tipo de Consulta: ");
		panelContenedor.add(lblConsultaPor,grid);
		
		grid.gridx=3;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 30);
		strTipoConsulta = new String[] { "Artículo","Artículos Prestados","Artículos No Prestados","Más Prestados","Personalizado" };
		cbTipoConsulta = new JComboBox<String>(strTipoConsulta);
		panelContenedor.add(cbTipoConsulta,grid);
		
		
		grid.gridx=4;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 10);
		JLabel lblOrdenarPor = new JLabel("Filtrar Por: ");
		panelContenedor.add(lblOrdenarPor,grid);
		
		grid.gridx=5;
		grid.gridy=0;
		grid.insets = new Insets( 0, 0, 0, 0);
		strTipoFiltro = new String[] { "Título","Autor","Editorial" };
		cbTipoFiltro = new JComboBox<String>(strTipoFiltro);
		panelContenedor.add(cbTipoFiltro,grid);
		
		
		grid.gridx=0;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 10);
		lblVeces = new JLabel("Articulo prestado más de: ");
		panelContenedor.add(lblVeces,grid);
		
		
		grid.gridx=1;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		txtVeces = new JTextField(3);
		txtVeces.setText("0");
		panelContenedor.add(txtVeces,grid);
		
		grid.gridx=1;
		grid.gridy=1;
		grid.insets = new Insets( 10, 40, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		lblVeces2 = new JLabel(" veces");
		panelContenedor.add( lblVeces2,grid);
		
		
		grid.gridx=2;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 10);
		grid.anchor = GridBagConstraints.LINE_END;
		lblMeses = new JLabel("Los últimos: ");
		panelContenedor.add(lblMeses,grid);
		
		grid.gridx=3;
		grid.gridy=1;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		txtMeses = new JTextField(3);
		txtMeses.setText("0");
		panelContenedor.add(txtMeses,grid);
		
		grid.gridx=3;
		grid.gridy=1;
		grid.insets = new Insets( 10, 40, 0, 0);
		grid.anchor = GridBagConstraints.LINE_START;
		lblMeses2 = new JLabel(" meses");
		panelContenedor.add( lblMeses2,grid);
		
		ocultarConsultaPersonalizado();
		
		grid.gridx=4;
		grid.gridy=1;
		grid.gridwidth = 2;
		grid.insets = new Insets( 10, 0, 0, 0);
		grid.anchor = GridBagConstraints.CENTER;
		btnGenerarConsulta = new JButton("Generar Consulta");
		panelContenedor.add( btnGenerarConsulta,grid);
		
		
		
		cbTipoArticulo.addActionListener(this);
		cbTipoConsulta.addActionListener(this);
		cbTipoFiltro.addActionListener(this);
		btnGenerarConsulta.addActionListener(this);
		
		panelFrame.add(panelContenedor);
		
	}
	
	
	public Container getContenedor(){
		return panelFrame;
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
