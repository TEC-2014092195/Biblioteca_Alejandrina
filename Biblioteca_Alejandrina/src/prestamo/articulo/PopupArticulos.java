/**====================================================================================
 * Archivo      : PopupArticulos.java » Paquete: prestamo.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package prestamo.articulo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import prestamo.articulo.PrestarArticulo.ModeloTabla;
import logicaRegistro.Articulo;
import logicaRegistro.Registro;
import main.ClaseHome;





public class PopupArticulos extends JDialog implements ActionListener{
	
	JTable table;
	
	TableRowSorter<ModeloTabla> sorter;
	
	
	JPanel panelGrilla = new JPanel();
	JPanel panelContenedor = new JPanel();
	GridBagConstraints grid = new GridBagConstraints();
	JLabel lblTipo,lblTitulo,lblDetalle1,lblDetalle2,lblDetalle3,lblCalificacion;
	JTextField txtTipo,txtTitulo,txtDetalle1,txtDetalle2,txtDetalle3,txtCalificacion;
	JButton btnCerrar;

	
	public PopupArticulos(JFrame parent) {
		super(parent,parent.getTitle());
		Dimension parentSize = parent.getSize(); 
		Point p = parent.getLocation(); 
		setLocation(p.x + 50, p.y + 50);
		setPreferredSize(new Dimension(parentSize.width-100, parentSize.height-100));
		setMaximumSize(getPreferredSize());
		setResizable(false);
		setLayout(new GridBagLayout());
		
		panelContenedor.setLayout(new GridBagLayout());
		
		crearEncabezadoBusqueda();
		
		grid.gridy=0; //Fila
		grid.gridx=0; //Columna
		panelContenedor.add(panelGrilla,grid);
		
		// -----------------------------------------------------Tabla-----

		ModeloTabla modelo = new ModeloTabla(Registro.articulosRegistrados);		
		sorter = new TableRowSorter<ModeloTabla>(modelo);
		table = new JTable(modelo);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(400, 400));
		table.setFillsViewportHeight(true);

		// For the purposes of this example, better to have a single
		// selection.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			

		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getClickCount() == 2) {
		        	System.out.println(table.getSelectedRow());
					System.out.println(table.getSelectedColumn());
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
		
		
		JScrollPane scrollPanel = new JScrollPane(table);
		// -----------------------------------------------------Fin Tabla-----		
				
		grid.gridy=1;
		grid.fill=GridBagConstraints.HORIZONTAL;
		grid.insets = new Insets(10, 10, 10, 10);
		panelContenedor.add(scrollPanel,grid);
		
		
		add(panelContenedor);
		
		grid.fill=GridBagConstraints.NONE;
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.DARK_GRAY);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBorderPainted(false);
		btnCerrar.addActionListener(this);
		add(btnCerrar, grid);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack(); 
	    
	    setVisible(true);
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCerrar){
			dispose();
		}
		
	}	
	
	
	public void crearEncabezadoBusqueda(){
		
		panelGrilla.setLayout(new GridBagLayout());

		Border borde =  BorderFactory.createEmptyBorder(5, 5, 5, 5);
		lblTipo = new JLabel("Tipo:");
		lblTitulo = new JLabel("Título:");
		lblDetalle1 = new JLabel("Detalle1:");
		lblDetalle2 = new JLabel("Detalle2:");
		lblDetalle3 = new JLabel("Detalle3:");
		lblCalificacion = new JLabel("Calificación:");
		
		txtTipo = new JTextField(15);
		txtTitulo = new JTextField(15);
		txtDetalle1 = new JTextField(15);
		txtDetalle2 = new JTextField(15);
		txtDetalle3 = new JTextField(15);
		txtCalificacion = new JTextField(15);

		lblTipo.setBorder(borde);
		lblTitulo.setBorder(borde);
		lblDetalle1.setBorder(borde);
		lblDetalle2.setBorder(borde);
		lblDetalle3.setBorder(borde);
		lblCalificacion.setBorder(borde);
		
		txtTipo.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroTipo();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroTipo();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroTipo();
			}
		});
		
		txtTitulo.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroTitulo();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroTitulo();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroTitulo();
			}
		});
		
		txtDetalle1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroDetalle1();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroDetalle1();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroDetalle1();
			}
		});
		
		txtDetalle2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroDetalle2();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroDetalle2();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroDetalle2();
			}
		});
		
		txtDetalle3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroDetalle3();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroDetalle3();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroDetalle3();
			}
		});
		
		txtCalificacion.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroCalificacion();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroCalificacion();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroCalificacion();
			}
		});
		
		
		
		
		grid.gridy=0; //Fila
		grid.gridx=0; //Columna
		grid.anchor=GridBagConstraints.LINE_END;
		panelGrilla.add( lblTipo,grid );
		grid.gridx=1;
		panelGrilla.add( txtTipo,grid );
		
		grid.gridx=2;
		panelGrilla.add( lblTitulo,grid );
		grid.gridx=3;
		panelGrilla.add( txtTitulo,grid );
		
		grid.gridx=4;
		panelGrilla.add( lblDetalle1,grid );
		grid.gridx=5;
		panelGrilla.add( txtDetalle1,grid );
		
		grid.gridx=6;
		panelGrilla.add( lblDetalle2,grid );
		grid.gridx=7;
		panelGrilla.add( txtDetalle2,grid );
		
		grid.gridy=1; //Fila
		grid.gridx=0; //Columna
		panelGrilla.add( lblDetalle3,grid );
		grid.gridx=1;
		panelGrilla.add( txtDetalle3,grid );
		
		grid.gridx=2; 
		panelGrilla.add( lblCalificacion,grid );
		grid.gridx=3;
		panelGrilla.add( txtCalificacion,grid );
		
		
		
		
		
	}
	
	private void filtroTipo() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtTipo.getText(), 0); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void filtroTitulo() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtTitulo.getText(), 1); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle1() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle1.getText(), 2); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle2() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle2.getText(), 3); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle3() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle3.getText(), 4); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	private void filtroCalificacion() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtCalificacion.getText(), 6); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	
	class ModeloTabla extends AbstractTableModel {
		private String[] columnNames = { "Tipo","Título", "Detalle1",
				"Detalle2", "Detalle3", "Imagen",
				"Calificación" };
		private List<Articulo> data = new ArrayList();

		public ModeloTabla(List<Articulo> list) {
			this.data = list;
		}

		public int getColumnCount() {
			return columnNames.length;

		}

		public int getRowCount() {
			return data.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Articulo si = data.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return si.getTipo();
			case 1:
				return si.getTitulo();
			case 2:
				return si.getAutor();
			case 3:
				return si.getDato1();
			case 4:
				return si.getDato2();
			case 5:
				return si.getDirImg();
			case 6:
				return si.getCalif();
			}
			return null;
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {

			if (col < 6) {
				return false;
			} else {
				return true;
			}
		}

		public void setValueAt(Object value, int row, int col) {

			Articulo si = data.get(row);
			switch (col) {
			case 0:
				si.setTipo((String) value);
			case 1:
				si.setTitulo((String) value);
			case 2:
				si.setAutor((String) value);
			case 3:
				si.setDato1((String) value);
			case 4:
				si.setDato2((String) value);
			case 5:
				si.setDirImg((String) value);
			case 6:
				si.setCalif((String) value);
			}
			fireTableCellUpdated(row, col);

		}

	}

	
	
	
	

}
