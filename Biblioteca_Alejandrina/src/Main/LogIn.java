/**====================================================================================
 * Archivo      : LogIn.java » Paquete: Main » Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Main;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.*;




@SuppressWarnings("serial")
public class LogIn extends JFrame implements ActionListener{
	// Variables
	JPanel panel = new JPanel();;
	JPanel frame = new JPanel();;
	JLabel userLabel,passLabel;
	GridBagConstraints grid = new GridBagConstraints();
	static JTextField passText;
	static JTextField userText;
	JButton logButton, regButton;
	String usuario,clave;
	static ArrayList<String> users;
	private static ArrayList<String> last;
	
	//Fin de Variables
	
	
	public void crearWidgets() {
		
		panel.setLayout(new GridBagLayout());
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(0,0,10,10); // Extrenal Pad (top, left, bottom, right)
		grid.anchor = GridBagConstraints.FIRST_LINE_END;
		userLabel = new JLabel("Usuario:");
		panel.add( userLabel, grid );

		grid.gridx = 1;
		grid.gridy = 0;
		userText = new JTextField(20);
		panel.add( userText, grid );

		grid.gridx = 0;
		grid.gridy = 1;
		passLabel = new JLabel("Contraseña:");
		panel.add(passLabel, grid);

		grid.gridx = 1;
		grid.gridy = 1;
		passText = new JTextField(20);
		panel.add(passText, grid);

		grid.gridx = 0;
		grid.gridy = 2;
		grid.anchor = GridBagConstraints.CENTER;
		grid.gridwidth = 2;
		logButton = new JButton("Iniciar Sesión");
		panel.add(logButton, grid);
		
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridwidth = 2;
		regButton = new JButton("Registrar");
		panel.add(regButton, grid);
		
		logButton.addActionListener(this);
		regButton.addActionListener(this);
	}
	
	
	
	public LogIn(){
		crearWidgets();
	}
	
	public Container getContenedor(){
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logButton){

			recuperarEstado("usuarios.txt");
			String valid = "Usuario válido";
			String invalid = "Usuario no válido";
			usuario = userText.getText();
			clave = passText.getText();
			String comp = usuario+clave;
			if (revisar(comp) == true){
				JOptionPane.showMessageDialog(null, valid);
				limpiarTextos();
			}
			else{
				JOptionPane.showMessageDialog(null, invalid);
				limpiarTextos();
			}
		}
		else if(e.getSource()==regButton){
			usuario = userText.getText();
			clave = passText.getText();
			String reg = "Usted está registrado, puede iniciar sesión";
			String guardar = usuario+clave;
			users.add(""+guardar);
			guardarEstado("usuarios.txt");
			JOptionPane.showMessageDialog(null, reg);
			limpiarTextos();
		}
	}
	public void limpiarTextos(){
		userText.setText("");
		passText.setText("");
	}
	//revisa en la lista con los usuarios existe el usuario
	public boolean revisar(String linea){
		if (users.contains(linea) == true){
			return true;
		}
		else{
			return false;
		}
	}
	//Escribe los usuarios que no estaban en el txt 
	public static void guardarEstado (String dirFile) {
		File archivo = new File(dirFile);
		last = null;
		try{
			FileWriter w = new FileWriter(archivo.getAbsolutePath() + java.io.File.separator);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			
			FileReader r = new FileReader(archivo.getAbsolutePath() + java.io.File.separator);
			BufferedReader br = new BufferedReader(r);
			String line;
			while((line = br.readLine())!= null){
				last.add(line);
			}
			for (int i = 0; i < users.size(); i++) {
				String objeto = users.get(i);
				if (last.contains(objeto) == true){
					wr.write(objeto);
					bw.newLine();
				}
			}
			wr.close();
			bw.close();
			br.close();}
		
		catch(IOException e){};
	}

	//Saca todos los usuarios del TXT y los mete a las lista
	public static void recuperarEstado(String dirFile){
		users.clear();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File (dirFile); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea; 
			while((linea=br.readLine()) != null){
				users.add(linea);
			}
			fr.close();
			br.close();}
				
		catch(IOException e){};}
	
}


