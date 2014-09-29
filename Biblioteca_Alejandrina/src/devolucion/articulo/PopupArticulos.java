/**====================================================================================
 * Archivo      : PopupArticulos.java » Paquete: prestamo.articulo » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package devolucion.articulo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;
import java.util.GregorianCalendar;


import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JSpinner;

import javax.swing.JTextField;

import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.table.DefaultTableModel;








public class PopupArticulos extends JDialog implements ActionListener{
	
		
	
	JPanel panelGrilla = new JPanel();
	JPanel panelContenedor = new JPanel();
	GridBagConstraints grid = new GridBagConstraints();
	JLabel lblTipo,lblTitulo,lblDetalle1,lblDetalle2,lblDetalle3,lblCalificacion,lblSelFecha;
	JTextField txtTipo,txtTitulo,txtDetalle1,txtDetalle2,txtDetalle3,txtCalificacion;
	JButton btnCerrar;
	static int indexCliente=0;
	
	static String fechaDevolucion="";
	TablaArticulos tabla = new TablaArticulos();
	static JDialog ventanaPopup = new JDialog();

	
	public PopupArticulos(JFrame parent, int indexCliente) {
		ventanaPopup = new JDialog(parent,parent.getTitle());
		Dimension parentSize = parent.getSize(); 
		Point p = parent.getLocation(); 
		ventanaPopup.setLocation(p.x + 50, p.y + 50);
		ventanaPopup.setPreferredSize(new Dimension(parentSize.width-100, parentSize.height-100));
		ventanaPopup.setMaximumSize(getPreferredSize());
		ventanaPopup.setResizable(false);
		ventanaPopup.setLayout(new GridBagLayout());
		
		panelContenedor.setLayout(new GridBagLayout());
		
		this.indexCliente = indexCliente;
		crearEncabezadoBusqueda();
		
		grid.gridy=0; //Fila
		grid.gridx=0; //Columna
		panelContenedor.add(panelGrilla,grid);
		
				
				
		grid.gridy=1;
		panelContenedor.add(tabla,grid);
		filtroDevolucion();
		
		ventanaPopup.add(panelContenedor);
		
		grid.fill=GridBagConstraints.NONE;
		grid.anchor=GridBagConstraints.EAST;
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.DARK_GRAY);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBorderPainted(false);
		btnCerrar.addActionListener(this);
		ventanaPopup.add(btnCerrar, grid);
		
		ventanaPopup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventanaPopup.pack(); 
	    
		ventanaPopup.setVisible(true);
		
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCerrar){
			ventanaPopup.dispose();
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
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtTipo.getText(), 0); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroTitulo() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtTitulo.getText(), 1); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle1() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle1.getText(), 2); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle2() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle2.getText(), 3); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroDetalle3() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtDetalle3.getText(), 4); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroCalificacion() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(txtCalificacion.getText(), 6); // (Patron a filtrar, int columna) 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	private void filtroDevolucion() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			TablaArticulos.sorter.sort();
			rf = RowFilter.regexFilter("true", 7);
			TablaArticulos.sorter.setRowFilter(rf);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		
	}
	
	


}
