/**====================================================================================
 * Archivo      : LogIn.java � Paquete: main � Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
 **==================================================================================== 
 */

package main;
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
	static ArrayList<String> users = new ArrayList<String>();
	private static ArrayList<String> last = new ArrayList<String>();
	
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
		passLabel = new JLabel("Contrase�a:");
		panel.add(passLabel, grid);

		grid.gridx = 1;
		grid.gridy = 1;
		passText = new JTextField(20);
		panel.add(passText, grid);

		grid.gridx = 0;
		grid.gridy = 2;
		grid.anchor = GridBagConstraints.CENTER;
		grid.gridwidth = 2;
		logButton = new JButton("Iniciar Sesi�n");
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
		recuperarEstado("usuarios.txt");
	}
	
	public Container getContenedor(){
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logButton){
			String valid = "Usuario v�lido";
			String invalid = "Usuario no v�lido";
			usuario = userText.getText();
			clave = passText.getText();
			String comp = usuario+clave;
			if (users.contains(comp)){
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
			String reg = "Usted est� registrado, puede iniciar sesi�n";
			String guardar = usuario+clave;
			System.out.println(guardar);
			users.add(guardar);
			guardarEstado("usuarios.txt");
			JOptionPane.showMessageDialog(null, reg);
			limpiarTextos();
		}
	}
	public void limpiarTextos(){
		userText.setText("");
		passText.setText("");
	}

	/* 
	 * Recibe una direcci�n, la cual es el archivo donde quedar�n registrados los usuarios
	 * Se encarga de guardar los nuevos usuarios en el archivo de texto
	 */
	public static void guardarEstado (String dirFile) {
		File archivo = new File(dirFile);
		last.clear();
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
				if (last.contains(objeto)== false){
					wr.write(objeto);
					bw.newLine();
				}
			}
			wr.close();
			bw.close();
			br.close();
			System.out.println("Si se hizo");}
		
		catch(IOException e){System.out.println("No se hizo");};
	}

	/*
	 * Recibe la direcci�n del archivo de texto con los usuarios
	 * Se encarga de leer el archivo de texto y cargar los usuarios en un arreglo
	 */
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


