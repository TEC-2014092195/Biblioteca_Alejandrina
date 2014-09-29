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


import consultas.TablaConsultas;
import prestamo.articulo.PrestarArticulo.ModeloTabla;
import logicaRegistro.Articulo;
import logicaRegistro.Cliente;
import logicaRegistro.Filtro;
import logicaRegistro.Registro;
import main.ClaseHome;




/**
 * The Class PopupArticulos. Clase para la ventana que muestra los artículos para prestar
 */
public class PopupArticulos extends JDialog implements ActionListener{
	
		
	//Panel para la Grilla
	JPanel panelGrilla = new JPanel();
	
	//Panel para contener todo
	JPanel panelContenedor = new JPanel();
	
	//Grid para los label
	GridBagConstraints grid = new GridBagConstraints();
	
	//Etiquetas para los detalles de préstamo
	JLabel lblTipo,lblTitulo,lblDetalle1,lblDetalle2,lblDetalle3,lblCalificacion,lblSelFecha,lblDias,lblTotalDias;
	
	//Cuadros de texto para los detalles de préstamo 
	JTextField txtTipo,txtTitulo,txtDetalle1,txtDetalle2,txtDetalle3,txtCalificacion;

	
	//Spinner para elegir la fecha
	//JSpinnerDateEditor dateEditor = new JSpinnerDateEditor();
	
	//Botón para cerrar

	JButton btnCerrar;
	
	//Enteros para saber el cliente y los días de préstamo
	static int indexCliente=0;
	static int diasprestamo=0;
	
	//Strings para fecha de préstamo y fecha de devolución
	static String fechaPrestamo="";
	static String fechaDevolucion="";
	
	//Tabla para los artículos
	TablaArticulos tabla = new TablaArticulos();
	
	//Dialog (Ventana), para el popup
	static JDialog ventanaPopup = new JDialog();

	/**
	 * Constructor de la clase PopupArticulos
	 */
	public PopupArticulos(JFrame parent, int indexCliente) {
		
		//Configuración de la ventana popup (Dialog)
		ventanaPopup = new JDialog(parent,parent.getTitle());
		Dimension parentSize = parent.getSize(); 
		Point p = parent.getLocation(); 
		ventanaPopup.setLocation(p.x + 50, p.y + 50);
		ventanaPopup.setPreferredSize(new Dimension(parentSize.width-100, parentSize.height-100));
		ventanaPopup.setMaximumSize(getPreferredSize());
		ventanaPopup.setResizable(false);
		ventanaPopup.setLayout(new GridBagLayout());
		
		//Layout del panel contenedor
		panelContenedor.setLayout(new GridBagLayout());
		
		this.indexCliente = indexCliente;
		crearEncabezadoBusqueda();
		
		//Inicio del grid en x=0 y y=0
		grid.gridy=0; //Fila
		grid.gridx=0; //Columna
		
		//Se agrega al panel contenedor el panel Grilla
		panelContenedor.add(panelGrilla,grid);
		
				
		//Configurar y agregar la tabla al panel contenedor
		grid.gridy=1;
		panelContenedor.add(tabla,grid);
		
		//Instancia de la clase filtroPrestado
		filtroPrestado();
		
		//Se agrega el panel contenedor a la ventana popup
		ventanaPopup.add(panelContenedor);
		
		//Se configuran otros aspectos del grid
		grid.fill=GridBagConstraints.NONE;
		grid.anchor=GridBagConstraints.EAST;
		
		//Configuración del botón Cerrar
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.DARK_GRAY);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBorderPainted(false);
		btnCerrar.addActionListener(this);
		ventanaPopup.add(btnCerrar, grid);
		
		ventanaPopup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventanaPopup.pack(); 
	    
		//Se hace visible la ventana
		ventanaPopup.setVisible(true);
		
	}
	
	
	
	
	/**
	 * Implementación de la clase actionPerformed
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Condicional para la acción de Cerrar
		if (e.getSource()==btnCerrar){
			ventanaPopup.dispose();
		}
		
	}	
	
	
	/**
	 * El método crearEncabezadoBusqueda, crea todos los objetos para el encabezado superior de la ventana
	 * 
	 * @see #filtroTipo()
	 * @see #filtroCalificacion()
	 * @see #filtroDetalle1()
	 * @see #filtroDetalle2()
	 * @see #filtroDetalle3()
	 * @see #filtroTitulo()
	 */
	public void crearEncabezadoBusqueda(){
		
		//Se asigna el Layout al panelGrilla
		panelGrilla.setLayout(new GridBagLayout());

		Border borde =  BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		//Se crean todas las etiquetas para los espacios del filtro
		lblTipo = new JLabel("Tipo:");
		lblTitulo = new JLabel("Título:");
		lblDetalle1 = new JLabel("Detalle1:");
		lblDetalle2 = new JLabel("Detalle2:");
		lblDetalle3 = new JLabel("Detalle3:");
		lblCalificacion = new JLabel("Calificación:");
		lblSelFecha = new JLabel("Seleccione Fecha de Entrega:");
		lblDias = new JLabel("Total de días:");
		lblTotalDias = new JLabel("0");
		
		//Se crean todos los campos de texto para los espacios del filtro
		txtTipo = new JTextField(15);
		txtTitulo = new JTextField(15);
		txtDetalle1 = new JTextField(15);
		txtDetalle2 = new JTextField(15);
		txtDetalle3 = new JTextField(15);
		txtCalificacion = new JTextField(15);

		//Se asignan todos los bordes a las etiquetas
		lblTipo.setBorder(borde);
		lblTitulo.setBorder(borde);
		lblDetalle1.setBorder(borde);
		lblDetalle2.setBorder(borde);
		lblDetalle3.setBorder(borde);
		lblCalificacion.setBorder(borde);
		lblSelFecha.setBorder(borde);
		lblDias.setBorder(borde);
		
		
		//Se crea el campo de texto para el filtro según el tipo
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
		
		//Se crea el campo de texto para el filtro según el título
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
		
		//Se crea el campo de texto para el filtro según el Detalle1
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
		
		//Se crea el campo de texto para el filtro según el Detalle2
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
		
		//Se crea el campo de texto para el filtro según el Detalle3
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
		
		//Se crea el campo de texto para el filtro según la calificación
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

		//Se ponen los grid x=0 y y=0
		//Se configura las posiciones de todos los objetos para el filtro 
		grid.gridy=0; 
		grid.gridx=0; 
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
		
		
//		grid.gridx = 5;
//		grid.gridwidth=2;
//		panelGrilla.add(lblSelFecha,grid);
//		
//		
//		
//		grid.gridx = 7;
//		grid.gridwidth=1;
//		grid.fill = GridBagConstraints.HORIZONTAL;
//		Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//		SimpleDateFormat format= new SimpleDateFormat("dd;MM;yyyy");
//		dateEditor.addChangeListener(new ChangeListener() {
//			
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				
//				Date fechaelegida = (Date) ((JSpinner) e.getSource()).getValue();
//				SimpleDateFormat format= new SimpleDateFormat("dd;MM;yyyy");
//                
//                Calendar cal1 = new GregorianCalendar();
//                Calendar cal2 = new GregorianCalendar();
//                Calendar fechahoy = Calendar.getInstance();
//                cal1.setTime(fechahoy.getTime());         
//                cal2.setTime(fechaelegida);
//                if(format.format(cal1.getTime()).equals(format.format(cal2.getTime()))){
//                	lblTotalDias.setText(""+0);
//                	diasprestamo=0;
//                }else{
//                	int diferencia =daysBetween(cal1.getTime(),cal2.getTime());
//                	if (diferencia>=0){
//                		diferencia+=1;
//                		lblTotalDias.setText(""+diferencia);
//                		diasprestamo=diferencia;
//                	}else{
//                		
//                		lblTotalDias.setText(""+diferencia);
//                		diasprestamo=diferencia;
//                	}
//                }
//                fechaPrestamo = format.format(cal1.getTime());
//                fechaDevolucion = format.format(cal2.getTime());
//
//			}
//			
//			public int daysBetween(Date d1, Date d2){
//				 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
//			}
//		});
//		
//		format = ((JSpinner.DateEditor) dateEditor.getEditor()).getFormat();
//        format.applyPattern("dd-MMM-yyyy");
//        dateEditor.setValue(date);
//        fechaPrestamo = format.format(date);
//        fechaDevolucion = format.format(date);
//		panelGrilla.add(dateEditor,grid);
//		
//		
//		grid.gridy = 2; //Fila
//		grid.gridx = 6; //Columna
//		grid.fill = GridBagConstraints.NONE;
//		panelGrilla.add(lblDias,grid);
//		
//		
//		grid.gridx = 7;
//		grid.anchor = GridBagConstraints.WEST;
//		panelGrilla.add(lblTotalDias,grid);
		
		
		
		
		
	}
	
	/**
	 * El método filtroTipo hace el filtro por tipo
	 */
	private void filtroTipo() {
		RowFilter<DefaultTableModel, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtTipo.getText(), 0);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	/**
	 * El método filtroTitulo hace el filtro por título
	 */
	private void filtroTitulo() {
		RowFilter<DefaultTableModel, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtTitulo.getText(), 1);  
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	/**
	 * El método filtroDetalle1 hace el filtro por Detalle1
	 */
	private void filtroDetalle1() {
		RowFilter<DefaultTableModel, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(txtDetalle1.getText(), 2); 
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		TablaArticulos.sorter.setRowFilter(rf);
	}
	
	/**
	 * El método filtroDetalle2 hace el filtro por Detalle2
	 */
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
	
	/**
	 * El método filtroDetalle3 hace el filtro por Detalle3
	 */
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
	
	/**
	 * El método filtroCalificacion hace el filtro por Calificación
	 */
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
	
	/**
	 * El método filtroPrestado hace el filtro por el estado de Prestado
	 */
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
