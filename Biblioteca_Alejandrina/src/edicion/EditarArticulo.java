/**====================================================================================
 * Archivo      : DevolverArticulo.java » Paquete: prestamo.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package edicion;

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
import javax.swing.JOptionPane;
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

public class EditarArticulo implements ActionListener {

	JPanel panelGrilla;
	JPanel panelContenedor;
	JPanel panelFrame;

	JLabel lblCedula,lblNombre, lblPApellido, lblSApellido, lblTelefono, lblCorreo,
			lblCategoria;
	JTextField txtCedula,txtNombre, txtPApellido, txtSApellido, txtTelefono, txtCorreo,
			txtCategoria;

	JTable table;

	JScrollPane scrollPanel;

	TableRowSorter<ModeloTabla> sorter;

	JButton btnAtras;

	GridBagConstraints grid = new GridBagConstraints();

	public EditarArticulo() {

		panelFrame = new JPanel();
		panelFrame.setLayout(new GridBagLayout());

		panelContenedor = new JPanel();
		panelGrilla = new JPanel();

		panelGrilla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelGrilla.setLayout(new GridBagLayout());
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Control de Préstamos");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setBorder(BorderFactory.createEtchedBorder());
		panelGrilla.setBorder(title);
		
		
		grid.gridy = 0; // fila
		grid.gridx = 0; // columna
		grid.anchor = GridBagConstraints.LINE_END;
		lblNombre = new JLabel("Cédula:");
		lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblNombre, grid);
		
		grid.gridy = 0; // fila
		grid.gridx = 1; // columna
		grid.anchor = GridBagConstraints.LINE_START;
		txtCedula = new JTextField(15);
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
		

		grid.gridy = 0; // fila
		grid.gridx = 2; // columna
		grid.anchor = GridBagConstraints.LINE_END;
		grid.gridwidth = 1;
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblNombre, grid);

		grid.gridy = 0; // fila
		grid.gridx = 3; // columna
		txtNombre = new JTextField(15);
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

		grid.gridy = 0; // fila
		grid.gridx = 4; // columna
		lblPApellido = new JLabel("Primer Apellido:");
		lblPApellido.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblPApellido, grid);

		grid.gridy = 0; // fila
		grid.gridx = 5; // columna
		txtPApellido = new JTextField(15);
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

		grid.gridy = 1; // fila
		grid.gridx = 0; // columna
		lblSApellido = new JLabel("Segundo Apellido:");
		lblSApellido.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblSApellido, grid);

		grid.gridy = 1; // fila
		grid.gridx = 1; // columna
		txtSApellido = new JTextField(15);
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

		grid.gridy = 1; // fila
		grid.gridx = 2; // columna
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblTelefono, grid);

		grid.gridy = 1; // fila
		grid.gridx = 3; // columna
		txtTelefono = new JTextField(15);
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

		grid.gridy = 1; // fila
		grid.gridx = 4; // columna
		lblCorreo = new JLabel("Correo Electrónico:");
		lblCorreo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblCorreo, grid);

		grid.gridy = 1; // fila
		grid.gridx = 5; // columna
		txtCorreo = new JTextField(15);
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

		grid.gridy = 2; // fila
		grid.gridx = 0; // columna
		lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelGrilla.add(lblCategoria, grid);

		grid.gridy = 2; // fila
		grid.gridx = 1; // columna
		txtCategoria = new JTextField(15);
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

		// -----------------------------------------------------Tabla-----

		ModeloTabla modelo = new ModeloTabla(Registro.clientesRegistrados);
		sorter = new TableRowSorter<ModeloTabla>(modelo);
		table = new JTable(modelo);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setFillsViewportHeight(true);

		// For the purposes of this example, better to have a single
		// selection.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			

		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        
		        if (evt.getButton() == evt.BUTTON1) {
		        	

	
					
						PopupArticulos poparticulos = new PopupArticulos(ClaseHome.ventana);
					
					
 
		        }else if (evt.getButton() == evt.BUTTON3){
		        	
		        	
		        	Registro.guardarEstadoActualSistema();
		        	
		        	
		        }
		    }
		});
		
		
		JScrollPane scrollPanel = new JScrollPane(table);

		// ---------------------------------------Add Tabla
		grid.gridy = 3; // fila
		grid.gridx = 0; // columna
		grid.gridwidth = 6;
		grid.anchor = GridBagConstraints.CENTER;
		grid.fill = GridBagConstraints.BOTH;
		// grid.ipady=5;

		panelGrilla.add(scrollPanel, grid);

		panelContenedor.add(panelGrilla);

		grid.gridy = 0; // fila
		grid.gridx = 0; // columna
		grid.gridwidth = 1;
		// grid.anchor=GridBagConstraints.LINE_END;
		panelFrame.add(panelContenedor, grid);

		grid.gridy = 1; // fila
		grid.gridx = 0; // columna
		grid.anchor = GridBagConstraints.LINE_END;
		grid.fill = GridBagConstraints.NONE;
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		panelFrame.add(btnAtras, grid);

	}
	
	private void filtroCedula() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtCedula.getText(), 0); // (Patron a
																// filtrar, int
																// columna en la
																// que quiero
																// buscar) TODO
																// patron para
																// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	
	private void filtroNombre() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtNombre.getText(), 1); // (Patron a
																// filtrar, int
																// columna en la
																// que quiero
																// buscar) TODO
																// patron para
																// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void filtroPApellido() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtPApellido.getText(), 2); // (Patron a
																	// filtrar,
																	// int
																	// columna
																	// en la que
																	// quiero
																	// buscar)
																	// TODO
																	// patron
																	// para
																	// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void filtroSApellido() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtSApellido.getText(), 3); // (Patron a
																	// filtrar,
																	// int
																	// columna
																	// en la que
																	// quiero
																	// buscar)
																	// TODO
																	// patron
																	// para
																	// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void filtroTelefono() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtTelefono.getText(), 4); // (Patron a
																	// filtrar,
																	// int
																	// columna
																	// en la que
																	// quiero
																	// buscar)
																	// TODO
																	// patron
																	// para
																	// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void filtroCorreo() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtCorreo.getText(), 5); // (Patron a
																// filtrar, int
																// columna en la
																// que quiero
																// buscar) TODO
																// patron para
																// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	private void filtroCategoria() {
		RowFilter<ModeloTabla, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtCategoria.getText(), 6); // (Patron a
																	// filtrar,
																	// int
																	// columna
																	// en la que
																	// quiero
																	// buscar)
																	// TODO
																	// patron
																	// para
																	// buscar
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	@SuppressWarnings("serial")
	class ModeloTabla extends AbstractTableModel {
		private String[] columnNames = { "Cédula","Nombre", "Primer Apellido",
				"Segundo Apellido", "Teléfono", "Correo Electrónico",
				"Categoría" };
		private List<Cliente> data = new ArrayList();

		public ModeloTabla(List<Cliente> list) {
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

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {

			if (col > 5) {
				return false;
			} else {
				return true;
			}
		}

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

	// TODO ActionListener()
	public void actionPerformed(ActionEvent e) {
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
