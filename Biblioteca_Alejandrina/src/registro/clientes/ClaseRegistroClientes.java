

package registro.clientes;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import logicaRegistro.Cliente;
import logicaRegistro.Registro;
import main.ClaseHome;




// TODO: Auto-generated Javadoc
/**
 * The Class ClaseRegistroClientes.
 * Clase de interfaz
 * Crea la interfaz para ingresar un nuevo cliente o
 * editar uno existente
 */
public class ClaseRegistroClientes extends JFrame implements ActionListener{
	
	//-------Declaracion Variables
	
	//P�neles para la contrucci�n de la ventana
	JPanel panel,panelGeneral,panelContenedor;
	
	//Para el Layout de la ventana
	GridBagLayout gridbag;
	
	//Para el Layout de la ventana
	GridBagConstraints c,gbc2;
	
	//EL grid normal para Layout
	GridLayout grid;
	
	//Etiquetas para todos lo elementos de la ventana
	JLabel lblCedula,lblNombre,lblPApellido,lblSApellido,lblTelefono,lblCorreo,lblCategoria,lblLogo;
	
	//Campos de texto para todos los datos de la ventana
	JTextField txtCedula,txtNombre,txtPApellido,txtSApellido,txtTelefono,txtCorreo;
	
	//COmboBox para elegir la categoria
	JComboBox cbCategoria;
	
	//String para elegir la categor�a
	String[] strCategoria; 
	
	//Botones para Guardar(Validar) y Devolverse
	JButton btnValidar,btnAtras;
	
	//Instancia de la clase Cliente para registrar personas
	Cliente cliente_reg;
	
	//Color para el fondo del panel
	Color colorlbl = new Color(0,54,43);
	//-------Fin declaracion variables
	
	/**
	 * Constructor de la clase ClaseRegistroClientes
	 */
	public ClaseRegistroClientes(){
		
		//Creaci�n del panel panelContenedor
		 panelContenedor = new JPanel();
		 
		 //Asignar Layout al panelContenedor
		 panelContenedor.setLayout(new FlowLayout());
		
		 //Creaci�n del panel panelGeneral
		 panelGeneral = new JPanel();
		 panelGeneral.setLayout(new GridBagLayout());
		 
		 //Creaci�n del Grid para las posiciones de los objetos
		 gbc2 = new GridBagConstraints();
		 
		 //Creaci�n del panel panel, y asignaci�n respectiva del Layout
		 panel = new JPanel();
		 gridbag = new GridBagLayout();
		 c = new GridBagConstraints();
		 panel.setLayout(gridbag);
		 
		 //Configuraci�n de la etiqueta para C�dula
		 lblCedula = new JLabel("C�dula ");
		 lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblCedula.setForeground(colorlbl);
		 txtCedula = new JTextField(20);
		 
		//Configuraci�n de la etiqueta para Nombre
		 lblNombre = new JLabel("Nombre ");
		 lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblNombre.setForeground(colorlbl);
		 txtNombre = new JTextField(20);
		 
		//Configuraci�n de la etiqueta para Primer Apellido
		 lblPApellido = new JLabel("Primer Apellido ");
		 lblPApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblPApellido.setForeground(colorlbl);
		 txtPApellido = new JTextField(20);
		 
		//Configuraci�n de la etiqueta para Segundo Apellido
		 lblSApellido = new JLabel("Segundo Apellido ");
		 lblSApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblSApellido.setForeground(colorlbl);
		 txtSApellido = new JTextField(20);
		 
		//Configuraci�n de la etiqueta para Tel�fono
		 lblTelefono = new JLabel("Tel�fono ");
		 lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblTelefono.setForeground(colorlbl);
		 txtTelefono = new JTextField(20);
		 
		//Configuraci�n de la etiqueta para Correo Electr�nico
		 lblCorreo = new JLabel("Correo Electr�nico");
		 lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblCorreo.setForeground(colorlbl);
		 txtCorreo = new JTextField(20);
		 
		//Configuraci�n del bot�n Validar
		 btnValidar = new JButton("Validar");
		 btnValidar.setBackground(colorlbl);
		 btnValidar.setForeground(Color.WHITE);
		 btnValidar.setBorderPainted(false);
		 btnValidar.setFocusable(false);
		 
		 
		//Creaci�n de la etiqueta para la Categor�a
		 lblCategoria = new JLabel("Categoria ");
		 lblCategoria.setForeground(colorlbl);
		 
		//String para los tres tipos de categor�a
		 strCategoria = new String[] { "Estudiante" , "Familiar" , "Colega" };
		 cbCategoria = new JComboBox(strCategoria);
		 
		//Inicio del grid en x=0 y y=0
		 c.gridx=0;
		 c.gridy=0;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.anchor = GridBagConstraints.CENTER;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblCedula,c);
		 
		 c.gridx=1;
		 c.gridy=0;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
	    // Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtCedula,c);
		 
		 
		 c.gridx=0;
		 c.gridy=1;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblNombre,c);
		 
		 c.gridx=1;
		 c.gridy=1;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10); // Extrenal Pad (top, left, bottom, right)
		 panel.add(txtNombre,c);
		 
		 
		 c.gridx=0;
		 c.gridy=2;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10); 
		 panel.add(lblPApellido,c);
		 
		 
		 c.gridx=1;
		 c.gridy=2;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10); 
		 panel.add(txtPApellido,c);		 
		 
		 
		 c.gridx=0;
		 c.gridy=3;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblSApellido,c);
		 
		 
		 c.gridx=1;
		 c.gridy=3;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtSApellido,c);

		 
		 c.gridx=0;
		 c.gridy=4;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblTelefono,c);
		 
		 
		 c.gridx=1;
		 c.gridy=4;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtTelefono,c);
		 
		 c.gridx=0;
		 c.gridy=5;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10); 
		 panel.add(lblCorreo,c);
		 
		 c.gridx=1;
		 c.gridy=5;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtCorreo,c);
		 
		 c.gridx=0;
		 c.gridy=6;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,10,0,10); 
		 panel.add(lblCategoria,c);
		 
		 c.gridx=1;
		 c.gridy=6;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.anchor = GridBagConstraints.CENTER;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,0,10);
		 cbCategoria.setBackground(Color.WHITE);
		 cbCategoria.setEditable(true);
		 panel.add(cbCategoria,c);
		 
		 
		 c.gridx=0;
		 c.gridy=7;
		 c.gridwidth=2;
		 c.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 c.insets = new Insets(10,0,10,10);
		 
		 //Se agrega el actionListener a btnValidar
		 btnValidar.addActionListener(this);
		 panel.add(btnValidar,c);
		//Fin de posicionar los objetos
		 
		//Color del panel panel
		 panel.setBackground(new Color(24,190,155));
		 
		
		//Inicio del grid para el panel panel
		 gbc2.gridx=0;
		 gbc2.gridy=0;
		 gbc2.gridheight=1;
		 gbc2.gridwidth=GridBagConstraints.RELATIVE;
		 
		// Insets (top, left, bottom, right)
		 gbc2.insets = new Insets(32,-2,130,0); 
		 
		 //Configuraci�n del panelGeneral
		 ImageIcon img = new ImageIcon(getClass().getResource("/recursos/BALogo.png")); 
		 lblLogo = new JLabel("");
		 lblLogo.setIcon(img);
		 
		 panelGeneral.add(lblLogo,gbc2);
		 
		 
		 
		 gbc2.gridx=0;
		 gbc2.gridy=1;
		 gbc2.gridheight=1;
		 
		// Insets (top, left, bottom, right)
		 gbc2.insets = new Insets(-90,0,0,0); 
		 panelGeneral.add(panel,gbc2);
		 
		 
		 
		 gbc2.gridx=0;
		 gbc2.gridy=2;
		 gbc2.gridheight=2;
		 gbc2.anchor = GridBagConstraints.LINE_END;
		 
		// Insets (top, left, bottom, right)
		 gbc2.insets = new Insets(20,0,0,0);
		 
		 //Configuraci�n de btnAtras
		 btnAtras = new JButton("Atr�s");
		 btnAtras.setBackground(Color.DARK_GRAY);
		 btnAtras.setForeground(Color.WHITE);
		 btnAtras.setBorderPainted(false);
		 
		 //Se agrega el actionListener al btnAtras
		 btnAtras.addActionListener(this);
		 
		 
		 //Se agrega a los p�neles todo lo configurado
		 panelGeneral.add(btnAtras,gbc2);
		 panelContenedor.add(panelGeneral);
	}
	
	
	/**
	 * Obtine el JPanel <code>panelContenedor</code> para que otras clases lo puedan usar
	 * 
	 * @return panelContenedor
	 */
	public Container getContenedor(){
		return panelContenedor;
	}

	
	/**
	 * Implementaci�n del <code>actionPerformed</code>() para asignar acciones a los botones y ComboBox
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Condicional del bot�n validar
		if(e.getSource()==btnValidar){
			
			if (verificarDatos()){
				
				if (verificarEmail()){
					
					
					if( Registro.cerrarPasoRepetidos( txtCedula.getText() ) ){
						guardarDatos();
						
						String s = "";
						
						s+="Nombre: "+txtNombre.getText()+"\n";
						s+="PrimerApe: "+txtPApellido.getText()+"\n";
						s+="SegundoApe: "+txtSApellido.getText()+"\n";
						s+="Telefono: "+txtTelefono.getText()+"\n";
						s+="Correo: "+txtCorreo.getText()+"\n";
						s+="Categoria: "+cbCategoria.getSelectedItem()+"\n";
						
						JOptionPane.showMessageDialog(null, s);
						
						limpiarTextos();
					}
					//Excepci�n para asegurarse que los datos ingresados son v�lidos
					else{
						JOptionPane.showMessageDialog(null, "El cliente ya est� registrado en el sistema.","Error valores duplicados",JOptionPane.ERROR_MESSAGE);
						limpiarTextos();
					}
				}
			}
			
			
			
			
			
			
			
		//Condicional para el bot�n btnAtras, que instancia a la Clase Home para regresar	
		}if(e.getSource()==btnAtras){
			//Instancia de clase ClaseHome
			ClaseHome home = new ClaseHome();
			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.ventana.revalidate();
			home.ventana.repaint();
			
			limpiarTextos();
		}
		
	}
	
	/**
	 * M�todo para guardar los Datos en un <code>Cliente</code>
	 * 
	 * @see #Registro.clientesRegistrados()
	 * @see #Registro.guardarEstadoActualSistema()
	 */
	public void guardarDatos(){
		
		//Se crea un cliente nuevo con la informaci�n otorgada
		cliente_reg = new Cliente(txtCedula.getText(), txtNombre.getText(), txtPApellido.getText(), txtSApellido.getText(), txtTelefono.getText(), txtCorreo.getText(), (String) cbCategoria.getSelectedItem());
		Registro.clientesRegistrados.add(cliente_reg);
		
		//Guarda el estado actual del Sistema mediante un txt
		Registro.guardarEstadoActualSistema();
	}
	
	/**
	 * Limpiar textos. Limpia todos los campos de texto de la ventana
	 */
	public void limpiarTextos(){
		txtCedula.setText("");
		txtNombre.setText("");
		txtPApellido.setText("");
		txtSApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cbCategoria.setSelectedIndex(0);
	}
	
    
	/**
	 * M�todo para verificar si la direcci�n ingresada sea un email v�lido
	 */
	public boolean verificarEmail () {

	    // Establecer el patr�n
	    Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");

	    // Asociar el string al patr�n
	    Matcher matchCorreo = p.matcher( txtCorreo.getText() );

	   // Comprobar si encaja
	   if ( matchCorreo.matches() ){
		   return true;
	   }else{
		   JOptionPane.showMessageDialog(null, "La direcci�n de correo no es v�lida");
		   return false;
	   }
	   

	}
	
	/**
	 * M�todo para verificar si los datos ingresados est�n correctos
	 * 
	 * @return true or false 
	 */
	public boolean verificarDatos(){
		
		//Comprobar c�dula
		if (!txtCedula.getText().matches("\\d*") || txtCedula.getText().matches("\\s*")){
			JOptionPane.showMessageDialog(null, "El n�mero de C�dula solo acepta digitos");
			return false;
		}
		
		//Comprobar Nombre
		if ( txtNombre.getText().matches("\\s*") ){ //Verifica si tiene espacios en blanco
			JOptionPane.showMessageDialog(null, "El dato Nombre no ha sido ingresado");
			return false;
		}
		
		//Comprobar Primer apellido
		if ( txtPApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Primer Apellido no ha sido ingresado");
			return false;
		}
		
		//Comprobar segundo apellido
		if ( txtSApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Segundo Apellido no ha sido ingresado");
			return false;
		}
		
		//Comprobar tel�fono
		if ( !txtTelefono.getText().matches("\\d*") || txtTelefono.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El n�mero de Tel�fono solo acepta n�meros del 0 al 9");
			return false;
		}
		
		//Comprobar Correo
		if ( txtCorreo.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Correo no ha sido ingresado");
			return false;
		}
		
		return true;
		
		
	}
	
	
	
	
	
	
	
	

}
