

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

import Main.ClaseHome;
import logicaRegistro.Cliente;
import logicaRegistro.Registro;




// TODO: Auto-generated Javadoc
/**
 * The Class ClaseRegistroClientes.
 * Clase de interfaz
 * Crea la interfaz para ingresar un nuevo cliente o
 * editar uno existente
 */
public class ClaseRegistroClientes extends JFrame implements ActionListener{
	
	//-------Declaracion Variables
	/** The panel contenedor. */
	JPanel panel,panelGeneral,panelContenedor;
	
	/** The gridbag. */
	GridBagLayout gridbag;
	
	/** The gbc2. */
	GridBagConstraints c,gbc2;
	
	/** The grid. */
	GridLayout grid;
	
	/** The lbl logo. */
	JLabel lblNombre,lblPApellido,lblSApellido,lblTelefono,lblCorreo,lblCategoria,lblLogo;
	
	/** The txt correo. */
	JTextField txtNombre,txtPApellido,txtSApellido,txtTelefono,txtCorreo;
	
	/** The cb categoria. */
	JComboBox cbCategoria;
	
	/** The str categoria. */
	String[] strCategoria; 
	
	/** The btn atras. */
	JButton btnValidar,btnAtras;
	
	Cliente cliente_reg;
	
	
	//-------Fin declaracion variables
	
	/**
	 * Instantiates a new clase registro clientes.
	 */
	public ClaseRegistroClientes(){
		 panelContenedor = new JPanel();
		 panelContenedor.setLayout(new FlowLayout());
		
		 panelGeneral = new JPanel();
		 panelGeneral.setLayout(new GridBagLayout());
		 //panelGeneral.setBackground(Color.WHITE);
		 gbc2 = new GridBagConstraints();
		 
		 panel = new JPanel();
		 gridbag = new GridBagLayout();
		 c = new GridBagConstraints();
		 panel.setLayout(gridbag);
		 
		 lblNombre = new JLabel("Nombre ");
		 lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		 Color colorlbl = new Color(0,54,43);
		 lblNombre.setForeground(colorlbl);
		 txtNombre = new JTextField(20);
		 
		 lblPApellido = new JLabel("Primer Apellido ");
		 lblPApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblPApellido.setForeground(colorlbl);
		 txtPApellido = new JTextField(20);
		 
		 lblSApellido = new JLabel("Segundo Apellido ");
		 lblSApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblSApellido.setForeground(colorlbl);
		 txtSApellido = new JTextField(20);
		 
		 lblTelefono = new JLabel("Telefono ");
		 lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblTelefono.setForeground(colorlbl);
		 txtTelefono = new JTextField(20);
		 
		 lblCorreo = new JLabel("Correo ");
		 lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		 lblCorreo.setForeground(colorlbl);
		 txtCorreo = new JTextField(20);
		 
		 btnValidar = new JButton("Validar");
		 btnValidar.setBackground(colorlbl);
		 btnValidar.setForeground(Color.WHITE);
		 btnValidar.setBorderPainted(false);
		 btnValidar.setFocusable(false);
		 
		 
		 
		 lblCategoria = new JLabel("Categoria ");
		 lblCategoria.setForeground(colorlbl);
		 
		 strCategoria = new String[] { "Estudiante" , "Familiar" , "Colega" };
		 cbCategoria = new JComboBox(strCategoria);
		 
		 c.gridx=0;
		 c.gridy=0;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.anchor = GridBagConstraints.CENTER;
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblNombre,c);
		 
		 c.gridx=1;
		 c.gridy=0;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtNombre,c);
		 
		 
		 c.gridx=0;
		 c.gridy=1;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblPApellido,c);
		 
		 c.gridx=1;
		 c.gridy=1;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,0,10); // Extrenal Pad (top, left, bottom, right)
		 panel.add(txtPApellido,c);
		 
		 
		 c.gridx=0;
		 c.gridy=2;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,10,0,10); 
		 panel.add(lblSApellido,c);
		 
		 
		 c.gridx=1;
		 c.gridy=2;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,0,10); 
		 panel.add(txtSApellido,c);		 
		 
		 
		 c.gridx=0;
		 c.gridy=3;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblTelefono,c);
		 
		 
		 c.gridx=1;
		 c.gridy=3;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtTelefono,c);

		 
		 c.gridx=0;
		 c.gridy=4;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,10,0,10);
		 panel.add(lblCorreo,c);
		 
		 
		 c.gridx=1;
		 c.gridy=4;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,0,10);
		 panel.add(txtCorreo,c);
		 
		 c.gridx=0;
		 c.gridy=5;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.insets = new Insets(10,10,0,10); // Extrenal Pad (top, left, bottom, right)
		 panel.add(lblCategoria,c);
		 
		 c.gridx=1;
		 c.gridy=5;
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 c.anchor = GridBagConstraints.CENTER;
		 c.insets = new Insets(10,0,0,10);
		 cbCategoria.setBackground(Color.WHITE);
		 cbCategoria.setEditable(true);
		 panel.add(cbCategoria,c);
		 
		 
		 c.gridx=0;
		 c.gridy=6;
		 c.gridwidth=2;
		 c.gridheight=1;
		 c.insets = new Insets(10,0,10,10);
		 
		 
		 btnValidar.addActionListener(this);
		 panel.add(btnValidar,c);
		 
		 
		 panel.setBackground(new Color(24,190,155));
		 
		
	
		 gbc2.gridx=0;
		 gbc2.gridy=0;
		 gbc2.gridheight=1;
		 gbc2.gridwidth=GridBagConstraints.RELATIVE;
		 
		 gbc2.insets = new Insets(32,-2,130,0); 
		 ImageIcon img = new ImageIcon(getClass().getResource("/recursos/BALogo.png")); 
		 lblLogo = new JLabel("");
		 lblLogo.setIcon(img);
		 
		 panelGeneral.add(lblLogo,gbc2);
		 
		 
		 
		 gbc2.gridx=0;
		 gbc2.gridy=1;
		 gbc2.gridheight=1;
		 gbc2.insets = new Insets(-90,0,0,0); 
		 panelGeneral.add(panel,gbc2);
		 
		 
		 
		 gbc2.gridx=0;
		 gbc2.gridy=2;
		 gbc2.gridheight=2;
		 gbc2.anchor = GridBagConstraints.LINE_END;
		 gbc2.insets = new Insets(20,0,0,0);
		 btnAtras = new JButton("Atrás");
		 btnAtras.setBackground(Color.DARK_GRAY);
		 btnAtras.setForeground(Color.WHITE);
		 btnAtras.setBorderPainted(false);
		 btnAtras.addActionListener(this);
		 
		 
		 

		 panelGeneral.add(btnAtras,gbc2);
		 
		 panelContenedor.add(panelGeneral);
		
		
		
	}
	
	public Container getContenedor(){
		return panelContenedor;
	}

	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValidar){
			
			if (verificarDatos()){
				
				if (verificarEmail(txtCorreo.getText())){
					
					
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
					
					
				}else{
					JOptionPane.showMessageDialog(null, "La dirección de correo no es válida");
				}
			}
			
			
			
			
			
			
			
			
		}if(e.getSource()==btnAtras){
			
			ClaseHome home = new ClaseHome();
			home.getCardLayout().show(home.getPanelCards(), "Home");
			home.getFrame().revalidate();
			home.getFrame().repaint();
			
			limpiarTextos();
		}
		
	}
	
	public void guardarDatos(){
		cliente_reg = new Cliente(txtNombre.getText(), txtPApellido.getText(), txtSApellido.getText(), txtTelefono.getText(), txtCorreo.getText(), (String) cbCategoria.getSelectedItem());
		Registro.recuperarEstadoSistema();
		Registro.clientesRegistrados.add(cliente_reg);
		Registro.guardarEstadoActualSistema();
	}
	
	/**
	 * Limpiar textos.
	 */
	public void limpiarTextos(){
//		JTextField txtNombre,txtPApellido,txtSApellido,txtTelefono,txtCorreo;
		txtNombre.setText("");
		txtPApellido.setText("");
		txtSApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cbCategoria.setSelectedIndex(0);
	}
	
    //http://mirastro.wordpress.com/2012/02/09/validar-direccion-email-con-java/
	public static boolean verificarEmail (String email) {

	    // Establecer el patron
	    Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");

	    // Asociar el string al patron
	    Matcher m = p.matcher(email);

	   // Comprobar si encaja
	   return m.matches();

	}
	
	
	public boolean verificarDatos(){
		if ( txtNombre.getText().matches("\\s*") ){ //Verifica si tiene espacios en blanco
			JOptionPane.showMessageDialog(null, "El dato nombre no ha sido ingresado");
			return false;
		}
		if ( txtPApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Primer Apellido no ha sido ingresado");
			return false;
		}
		if ( txtSApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Segundo Apellido no ha sido ingresado");
			return false;
		}
		if ( !txtTelefono.getText().matches("\\d*") || txtTelefono.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El número de Teléfono solo acepta números del 0 al 9");
			return false;
		}
		if ( txtCorreo.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Correo no ha sido ingresado");
			return false;
		}
		
		return true;
		
		
	}
	
	
	
	
	
	
	
	

}
