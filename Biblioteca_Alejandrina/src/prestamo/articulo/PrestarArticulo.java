/**====================================================================================
 * Archivo      : DevolverArticulo.java » Paquete: prestamo.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package prestamo.articulo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import main.ClaseHome;
import logicaRegistro.*;

/**
 * Clase PrestarArticulo para prestar artículos
 */
public class PrestarArticulo implements ActionListener {

	//Páneles para la clase
	JPanel panelGrilla;
	JPanel panelContenedor;
	JPanel panelFrame;
	
	//Etiqueta para los datos
	JLabel lblCedula,lblNombre, lblPApellido, lblSApellido, lblTelefono, lblCorreo,
			lblCategoria;
	
	//Campo de texto para los datos
	JTextField txtCedula,txtNombre, txtPApellido, txtSApellido, txtTelefono, txtCorreo,
			txtCategoria;

	//Tabla
	JTable table;

	//El scroll panel
	JScrollPane scrollPanel;

	//Ordenador de la tabla
	TableRowSorter<ModeloTabla> sorter;

	//botón para devolverse
	JButton btnAtras;

	//El grid
	GridBagConstraints grid = new GridBagConstraints();

	/**
	 * Constructor de la clase PrestarArticulo
	 */
	public PrestarArticulo() {

		//Páneles para la clase
		panelFrame = new JPanel();
		panelFrame.setLayout(new GridBagLayout());

		//Panel contenedor
		panelContenedor = new JPanel();
		panelGrilla = new JPanel();

		//Configuración para el filtro
		panelGrilla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelGrilla.setLayout(new GridBagLayout());
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Control de Préstamos");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setBorder(BorderFactory.createEtchedBorder());
		panelGrilla.setBorder(title);
		

		//Grid en x=0 y y=0
		//Agregar los objetos a los páneles
		grid.gridy = 0; 
		grid.gridx = 0; 
		grid.anchor = GridBagConstraints.LINE_END;
		lblNombre = new JLabel("Cédula:");
		lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblNombre, grid);
		
		grid.gridy = 0; 
		grid.gridx = 1; 
		grid.anchor = GridBagConstraints.LINE_START;
		txtCedula = new JTextField(15);
		//Crear Filtro por cédulas
		txtCedula.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroCedula();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroCedula();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroCedula();
			}
		});
		panelGrilla.add(txtCedula, grid);
		

		grid.gridy = 0; 
		grid.gridx = 2; 
		grid.anchor = GridBagConstraints.LINE_END;
		grid.gridwidth = 1;
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblNombre, grid);

		grid.gridy = 0; // fila
		grid.gridx = 3; // columna
		txtNombre = new JTextField(15);
		//Crear Filtro por Nombre
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroNombre();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroNombre();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroNombre();
			}
		});
		panelGrilla.add(txtNombre, grid);

		grid.gridy = 0; 
		grid.gridx = 4; 
		lblPApellido = new JLabel("Primer Apellido:");
		lblPApellido.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblPApellido, grid);

		grid.gridy = 0; 
		grid.gridx = 5; 
		txtPApellido = new JTextField(15);
		//Crear Filtro por cédulas
		txtPApellido.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroPApellido();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroPApellido();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroPApellido();
			}
		});
		panelGrilla.add(txtPApellido, grid);

		grid.gridy = 1; 
		grid.gridx = 0; 
		lblSApellido = new JLabel("Segundo Apellido:");
		lblSApellido.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblSApellido, grid);

		grid.gridy = 1; 
		grid.gridx = 1; 
		txtSApellido = new JTextField(15);
		//Crear Filtro por cédulas
		txtSApellido.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroSApellido();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroSApellido();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroSApellido();
			}
		});
		panelGrilla.add(txtSApellido, grid);

		grid.gridy = 1; 
		grid.gridx = 2;
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblTelefono, grid);

		grid.gridy = 1; 
		grid.gridx = 3; 
		txtTelefono = new JTextField(15);
		//Crear Filtro por Teléfono
		txtTelefono.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroTelefono();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroTelefono();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroTelefono();
			}
		});
		panelGrilla.add(txtTelefono, grid);

		grid.gridy = 1; 
		grid.gridx = 4; 
		lblCorreo = new JLabel("Correo Electrónico:");
		lblCorreo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblCorreo, grid);

		grid.gridy = 1; 
		grid.gridx = 5; 
		txtCorreo = new JTextField(15);
		//Crear Filtro por Correo
		txtCorreo.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroCorreo();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroCorreo();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroCorreo();
			}
		});
		panelGrilla.add(txtCorreo, grid);

		grid.gridy = 2; 
		grid.gridx = 0; 
		lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblCategoria, grid);

		grid.gridy = 2; 
		grid.gridx = 1; 
		txtCategoria = new JTextField(15);
		//Crear Filtro por Categoría
		txtCategoria.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				filtroCategoria();
			}

			public void insertUpdate(DocumentEvent e) {
				filtroCategoria();
			}

			public void removeUpdate(DocumentEvent e) {
				filtroCategoria();
			}
		});
		panelGrilla.add(txtCategoria, grid);

		// Tabla

		ModeloTabla modelo = new ModeloTabla(Registro.clientesRegistrados);
		sorter = new TableRowSorter<ModeloTabla>(modelo);
		table = new JTable(modelo);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			
		//Se agrega el evento de apretar el mouse
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getClickCount() == 2) {
		        	System.out.println(table.getSelectedRow());
					System.out.println(table.getSelectedColumn());

					int indexCliente = table.convertRowIndexToModel(table.getSelectedRow());
					System.out.println(table.convertRowIndexToModel(table.getSelectedRow()));
					PopupArticulos poparticulos = new PopupArticulos(ClaseHome.ventana, indexCliente);
 
		        }
		    }
		});
		
		
		JScrollPane scrollPanel = new JScrollPane(table);

		// Add Tabla
		grid.gridy = 3; 
		grid.gridx = 0; 
		grid.gridwidth = 6;
		grid.anchor = GridBagConstraints.CENTER;
		grid.fill = GridBagConstraints.BOTH;
		

		panelGrilla.add(scrollPanel, grid);

		panelContenedor.add(panelGrilla);

		grid.gridy = 0; 
		grid.gridx = 0; 
		grid.gridwidth = 1;
		panelFrame.add(panelContenedor, grid);

		grid.gridy = 1; 
		grid.gridx = 0; 
		grid.anchor = GridBagConstraints.LINE_END;
		grid.fill = GridBagConstraints.NONE;
		
		//Se hace el botón de atrás y se agrega
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		panelFrame.add(btnAtras, grid);

	}
	
	/**
	 * Filtro para la Cédula
	 */
	private void filtroCedula() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtCedula.getText(), 0); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	
	/**
	 * Filtro para la Nombre
	 */
	private void filtroNombre() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtNombre.getText(), 1); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * Filtro para la Apellido
	 */
	private void filtroPApellido() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtPApellido.getText(), 2);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * Filtro para la Segundo Apellido
	 */
	private void filtroSApellido() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtSApellido.getText(), 3); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * Filtro para la Teléfono
	 */
	private void filtroTelefono() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtTelefono.getText(), 4); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * Filtro para la Correo
	 */
	private void filtroCorreo() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtCorreo.getText(), 5); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * Filtro para la Categoría
	 */
	private void filtroCategoria() {
		RowFilter<ModeloTabla, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtCategoria.getText(), 6); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	/**
	 * ModeloTabla, para hacer el modelo de la tabla
	 */
	@SuppressWarnings("serial")
	class ModeloTabla extends AbstractTableModel {
		
		//String para los datos
		private String[] columnNames = { "Cédula","Nombre", "Primer Apellido",
				"Segundo Apellido", "Teléfono", "Correo Electrónico",
				"Categoría" };
		
		//ListString para los datos
		private List<Cliente> data = new ArrayList();

		//Modelo de la tabla
		public ModeloTabla(List<Cliente> list) {
			this.data = list;
		}

		//Int conseguir la columna
		public int getColumnCount() {
			return columnNames.length;

		}

		//Int conseguir la columna
		public int getRowCount() {
			return data.size();
		}

		//String conseguir la columna
		public String getColumnName(int col) {
			return columnNames[col];
		}

		//Instancia de Object
		public Object getValueAt(int rowIndex, int columnIndex) {
			Cliente si = data.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return si.getCedula();
			case 1:
				return si.getNombre();
			case 2:
				return si.getApellido1();
			case 3:
				return si.getApellido2();
			case 4:
				return si.getTelefono();
			case 5:
				return si.getCorreo();
			case 6:
				return si.getCategoria();
			}
			return null;
		}

		//Clase para obtener las columnas
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		//Para poner las celdas no editables
		public boolean isCellEditable(int row, int col) {

			if (col < 6) {
				return false;
			} else {
				return true;
			}
		}

		//Setear los valores
		public void setValueAt(Object value, int row, int col) {

			Cliente si = data.get(row);
			switch (col) {
			case 0:
				si.setCedula((String) value);
			case 1:
				si.setNombre((String) value);
			case 2:
				si.setApellido1((String) value);
			case 3:
				si.setApellido2((String) value);
			case 4:
				si.setTelefono((String) value);
			case 5:
				si.setCorreo((String) value);
			case 6:
				si.setCategoria((String) value);
			}
			fireTableCellUpdated(row, col);

		}

	}

	/**
	 * Implementación de actionPerformed
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Condicional de botón Atras
		if (e.getSource() == btnAtras) {
			ClaseHome home = new ClaseHome();

			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.ventana.revalidate();
			home.ventana.repaint();

		}

	}

	public Container getContenedor() {
		return panelFrame;
	}

}
