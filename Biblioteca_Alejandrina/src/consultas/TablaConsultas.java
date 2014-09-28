/**====================================================================================
 * Archivo      : TablaConsultas.java » Paquete: consultas » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package consultas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import prestamo.articulo.CalificacionRenderer;
import prestamo.articulo.ImagenRenderer;
import logicaRegistro.Articulo;
import logicaRegistro.Registro;

public class TablaConsultas extends JPanel implements ActionListener{

	static JTable table;
	
//	static TableRowSorter<ModeloTabla> sorter;
	static TableRowSorter<DefaultTableModel> sorter;
	public static DefaultTableModel modelo;
	
	public TablaConsultas() {
		
		setLayout(new GridLayout());
		GridBagConstraints grid = new GridBagConstraints();
		
		// -----------------------------------------------------Tabla-----
		
		
		String col[] = { "Tipo", "Título", "Detalle1", "Detalle2", "Detalle3",
				"Imagen", "Calificación", "ifPrestado", "Dias Prestamo", "Prestado", "Devolucion" };
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
		table.setPreferredScrollableViewportSize(new Dimension(900, 400));
		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getClickCount() == 2) {
//		        	System.out.println(table.getSelectedRow());
//					System.out.println(table.getSelectedColumn());
					System.out.println(table.convertRowIndexToModel(table.getSelectedRow()));
		        	
 
		        }
		    }
		});
		
		table.getColumn("Imagen").setCellRenderer( new ImagenRenderer() );
		table.getColumn("Calificación").setCellRenderer( new CalificacionRenderer() );
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		centerRenderer.setBackground(new Color(217, 217, 217));
		centerRenderer.setForeground(Color.DARK_GRAY);
		
		table.getColumn("Tipo").setCellRenderer( centerRenderer );
		table.getColumn("Título").setCellRenderer( centerRenderer );
		table.getColumn("Detalle1").setCellRenderer( centerRenderer );
		table.getColumn("Detalle2").setCellRenderer( centerRenderer );
		table.getColumn("Detalle3").setCellRenderer( centerRenderer );
		table.getColumn("ifPrestado").setCellRenderer( centerRenderer );
		table.getColumn("Dias Prestamo").setCellRenderer( centerRenderer );
		
		
		JScrollPane scrollPanel = new JScrollPane(table);
		// -----------------------------------------------------Fin Tabla-----
		grid.fill=GridBagConstraints.BOTH;
		add(scrollPanel,grid);
		
		
	}
	
	
	public static void llenarTabla(){
		String col[] = { "Tipo", "Título", "Detalle1", "Detalle2", "Detalle3",
				"Imagen", "Calificación", "ifPrestado", "Dias Prestamo" };
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
			   
			   Object[] data = {tipo, titulo, detalle1, detalle2, detalle3, imagen, 
			                               calificacion, ifprestado, diasprestado};

			   modelo.addRow(data);

		}
	}
	
	
	
	



	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
