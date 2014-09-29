/**====================================================================================
 * Archivo      : TablaArticulos.java » Paquete: consultas » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package edicion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import prestamo.articulo.CalificacionRenderer;
import prestamo.articulo.ImagenRenderer;
import logicaRegistro.Articulo;
import logicaRegistro.Registro;

public class TablaArticulos extends JPanel implements ActionListener{

	static JTable table;
	static JPanel panelContenedor = new JPanel();
//	static TableRowSorter<ModeloTabla> sorter;
	static TableRowSorter<DefaultTableModel> sorter;
	public static DefaultTableModel modelo;
	static GridBagConstraints grid = new GridBagConstraints();
	
	public TablaArticulos() {
			
		llenarTabla();
		add(panelContenedor);
		
		
	}
	
	
	public static void llenarTabla(){
		
		panelContenedor.removeAll();
		
		
		// -----------------------------------------------------Tabla-----
			
		String col[] = { "Tipo", "Título", "Detalle1", "Detalle2", "Detalle3",
				"Imagen", "Calificación", "ifPrestado", "Dias Prestamo", "Fecha Prestamo", "Fecha Devolucion" };
		modelo = new DefaultTableModel(col, 0){
			public boolean isCellEditable(int row, int column)  
		    {  
		        // only columns 0 and 1 are editable  
		        return column > 8;  
		    }  
		};
		table = new JTable(modelo);
		
		for (int i = 0; i < Registro.articulosRegistrados.size(); i++){
			   String tipo = Registro.articulosRegistrados.get(i).getTipo();
			   String titulo = Registro.articulosRegistrados.get(i).getTitulo();
			   String detalle1 = Registro.articulosRegistrados.get(i).getAutor();
			   String detalle2 = Registro.articulosRegistrados.get(i).getDato1();
			   String detalle3 = Registro.articulosRegistrados.get(i).getDato2();
			   String imagen = Registro.articulosRegistrados.get(i).getDirImg();
			   String calificacion = Registro.articulosRegistrados.get(i).getCalif();
			   String ifprestado = String.valueOf(Registro.articulosRegistrados.get(i).isPrestado());
			   String diasprestado = String.valueOf(Registro.articulosRegistrados.get(i).getDiasPrestado());
			   String fechaprestamo = String.valueOf(Registro.articulosRegistrados.get(i).getFechaPrestado());
			   String fechadevolucion = String.valueOf(Registro.articulosRegistrados.get(i).getFechaDevolucion());
			   
			   Object[] data = {tipo, titulo, detalle1, detalle2, detalle3, imagen, 
			                               calificacion, ifprestado, diasprestado, fechaprestamo, fechadevolucion};

			   modelo.addRow(data);

		}
		sorter = new TableRowSorter<DefaultTableModel>(modelo);
		//-----------------------------fin llenado
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(900, 400));
		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getClickCount() == 2) {

					System.out.println(table.convertRowIndexToModel(table.getSelectedRow()));
					
 
		        }
		    }
		});
		
		table.getColumn("Imagen").setCellRenderer( new ImagenRenderer() );
		table.getColumn("Imagen").setPreferredWidth(130);
		table.getColumn("Imagen").setMinWidth(60);
		table.getColumn("Calificación").setCellRenderer( new CalificacionRenderer() );
		table.getColumn("Calificación").setPreferredWidth(120);
		table.getColumn("Calificación").setMinWidth(60);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		centerRenderer.setBackground(new Color(217, 217, 217));
		centerRenderer.setForeground(Color.DARK_GRAY);
		for (int i=0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		NormalCellRenderer normal = new NormalCellRenderer();
		table.getColumn("Tipo").setCellRenderer( normal );
		table.getColumn("Título").setCellRenderer( normal );
		table.getColumn("Detalle1").setCellRenderer( normal );
		table.getColumn("Detalle2").setCellRenderer( normal );
		table.getColumn("Detalle3").setCellRenderer( normal );
		table.getColumn("ifPrestado").setCellRenderer( normal );
		table.getColumn("Dias Prestamo").setCellRenderer( normal );
		table.getColumn("Fecha Prestamo").setCellRenderer( normal );
		table.getColumn("Fecha Devolucion").setCellRenderer( normal );
		
		
		JScrollPane scrollPanel = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// -----------------------------------------------------Fin Tabla-----
		grid.fill=GridBagConstraints.BOTH;
		panelContenedor.add(scrollPanel,grid);
	}
	
	
	
	public static class NormalCellRenderer extends JLabel implements TableCellRenderer {
		
		
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {

			
				
				setToolTipText("<html><p>"+(String)value+"</p></html>");
				setHorizontalAlignment(SwingConstants.CENTER);
				setText((String)value);
				setForeground(Color.WHITE);
				setOpaque(true);
				setBackground(Color.DARK_GRAY);
		  
			
		   
		       return this;

		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
