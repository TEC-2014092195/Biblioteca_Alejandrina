/**====================================================================================
 * Archivo      : TablaArticulos.java » Paquete: consultas » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import prestamo.articulo.CalificacionRenderer;
import prestamo.articulo.ImagenRenderer;
import logicaRegistro.Articulo;
import logicaRegistro.Filtro;
import logicaRegistro.Registro;

public class TablaArticulos extends JPanel implements ActionListener{

	static JTable table;
	static JPanel panelContenedor = new JPanel();
	static TableRowSorter<DefaultTableModel> sorter;
	public static DefaultTableModel modelo;
	static GridBagConstraints grid = new GridBagConstraints();
	static Calendar calFechaPrestamo = Calendar.getInstance();
	static SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy");
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
		        return column > 10;  
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
		table.setPreferredScrollableViewportSize(new Dimension(900, 600));
		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getClickCount() == 2) {
		        	int row =table.getSelectedRow();
		        	int column = table.getSelectedColumn();
		        	
		        	
	                	
		        	
		        		
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
		
		
		table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
            	
                JPanel pane = new JPanel(new GridBagLayout());
                
                JLabel label = new JLabel();
                int modelRow = table.convertRowIndexToModel(row);
                String type = (String)table.getModel().getValueAt(modelRow, 10); //Obtener Valor 
                //----------------------------
                SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy");
	        	Calendar cal1 = new GregorianCalendar();
                Calendar cal2 = new GregorianCalendar();
	        	Calendar fechahoy = Calendar.getInstance();
	        	cal1.setTime(fechahoy.getTime());       
	        	int diaspasados=0;
                try {
                	if (!"0".equals(type)){
                		cal2.setTime(format.parse(""+type));
                	}else{
                		label.setText(type);
                	}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                if(format.format(cal1.getTime()).equals(format.format(cal2.getTime()))){
                	//cerodias de diferencia
                }else{
                	int diferencia =daysBetween(cal1.getTime(),cal2.getTime());
                	if (diferencia>=0){
                		diferencia+=1;
                		
                		pane.setBackground(Color.RED);
    					label.setText(type);
    					label.setForeground(Color.WHITE);
    					
                		diaspasados=diferencia;
                		
                		
                	}else{
                		pane.setBackground(Color.GREEN);
    					label.setText(type);
    					label.setForeground(Color.WHITE);
                		
                		diaspasados=diferencia;
                	}
                }

	        	//------------------------------
                
				
				if(column==10){
					pane.add(label);
				}else{
					label.setText((String)value);
					pane.add(label);
				}
                
                return pane;
            }
            public int daysBetween(Date d1, Date d2){
				 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
			}
        });
		
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
//				setBackground(Color.DARK_GRAY);
		  
			
		   
		       return this;

		}
	}
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
