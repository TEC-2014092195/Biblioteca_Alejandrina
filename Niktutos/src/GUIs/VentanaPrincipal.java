package GUIs;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	JButton btnEnviar;
	JTextField txtTexto;
	JLabel lblMensaje;
	
	public VentanaPrincipal(){
		super("Mi primer GUI");
		
		crearWidgets();
		this.setResizable(false);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	public void crearWidgets(){
		this.setLayout( new FlowLayout() );
		txtTexto = new JTextField(20);
		btnEnviar = new JButton("Enviar");
		lblMensaje = new JLabel("\"Label\"");
		
		
		
		
		btnEnviar.setBackground(Color.CYAN);
		this.add(txtTexto);
		this.add(btnEnviar);
		this.add(lblMensaje);
		
		
		btnEnviar.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnEnviar){
			lblMensaje.setText(lblMensaje.getText()+txtTexto.getText());
		}
	}

}
