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
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import consultas.TablaConsultas;
import prestamo.articulo.PrestarArticulo.ModeloTabla;
import logicaRegistro.Articulo;
import logicaRegistro.Cliente;
import logicaRegistro.Filtro;
import logicaRegistro.Registro;
import main.ClaseHome;





public class PopupArticulos extends JDialog implements ActionListener{
	
		
	
	JPanel panelGrilla = new JPanel();
	JPanel panelContenedor = new JPanel();
	GridBagConstraints grid = new GridBagConstraints();
	JLabel lblTipo,lblTitulo,lblDetalle1,lblDetalle2,lblDetalle3,lblCalificacion,lblSelFecha,lblDias,lblTotalDias;
	JTextField txtTipo,txtTitulo,txtDetalle1,txtDetalle2,txtDetalle3,txtCalificacion;
	JSpinnerDateEditor dateEditor = new JSpinnerDateEditor();
	JButton btnCerrar;
	static int indexCliente=0;
	static int diasprestamo=0;
	static String fechaPrestamo="";
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
		filtroPrestado();
		
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
		lblSelFecha = new JLabel("Seleccione Fecha de Entrega:");
		lblDias = new JLabel("Total de días:");
		lblTotalDias = new JLabel("0");
		
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
		lblSelFecha.setBorder(borde);
		lblDias.setBorder(borde);
		
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
		
		
		grid.gridx = 5;
		grid.gridwidth=2;
		panelGrilla.add(lblSelFecha,grid);
		
		
		
		grid.gridx = 7;
		grid.gridwidth=1;
		grid.fill = GridBagConstraints.HORIZONTAL;
		Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
		SimpleDateFormat format= new SimpleDateFormat("dd;MM;yyyy");
		dateEditor.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				Date fechaelegida = (Date) ((JSpinner) e.getSource()).getValue();
				SimpleDateFormat format= new SimpleDateFormat("dd;MM;yyyy");
                
                Calendar cal1 = new GregorianCalendar();
                Calendar cal2 = new GregorianCalendar();
                Calendar fechahoy = Calendar.getInstance();
                cal1.setTime(fechahoy.getTime());         
                cal2.setTime(fechaelegida);
                if(format.format(cal1.getTime()).equals(format.format(cal2.getTime()))){
                	lblTotalDias.setText(""+0);
                	diasprestamo=0;
                }else{
                	int diferencia =daysBetween(cal1.getTime(),cal2.getTime());
                	if (diferencia>=0){
                		diferencia+=1;
                		lblTotalDias.setText(""+diferencia);
                		diasprestamo=diferencia;
                	}else{
                		
                		lblTotalDias.setText(""+diferencia);
                		diasprestamo=diferencia;
                	}
                }
                fechaPrestamo = format.format(cal1.getTime());
                fechaDevolucion = format.format(cal2.getTime());

			}
			
			public int daysBetween(Date d1, Date d2){
				 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
			}
		});
		
		format = ((JSpinner.DateEditor) dateEditor.getEditor()).getFormat();
        format.applyPattern("dd-MMM-yyyy");
        dateEditor.setValue(date);
        fechaPrestamo = format.format(date);
        fechaDevolucion = format.format(date);
		panelGrilla.add(dateEditor,grid);
		
		
		grid.gridy = 2; //Fila
		grid.gridx = 6; //Columna
		grid.fill = GridBagConstraints.NONE;
		panelGrilla.add(lblDias,grid);
		
		
		grid.gridx = 7;
		grid.anchor = GridBagConstraints.WEST;
		panelGrilla.add(lblTotalDias,grid);
		
		
		
		
		
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
	
	private void filtroPrestado() {
		RowFilter<DefaultTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			TablaArticulos.sorter.sort();
			rf = RowFilter.regexFilter("false", 7);
			TablaArticulos.sorter.setRowFilter(rf);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		
	}
	
	


}
