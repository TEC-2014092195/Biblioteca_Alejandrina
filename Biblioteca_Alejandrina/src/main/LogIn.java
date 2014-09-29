/**====================================================================================
 * Archivo      : LogIn.java » Paquete: main » Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
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


/**
 * La Clase LogIn, maneja el login del sistema
 */
@SuppressWarnings("serial")
public class LogIn extends JFrame implements ActionListener{
	
	//Páneles para los objetos
	JPanel panel = new JPanel();
	JPanel frame = new JPanel();
	
	//Etiquetas para el usuario y el pass
	JLabel userLabel,passLabel;
	
	//Grid nuevo
	GridBagConstraints grid = new GridBagConstraints();
	
	//Campos de texto para el usuario y el pass
	static JTextField passText;
	static JTextField userText;
	
	//Botón para entrar
	JButton logButton, regButton;
	
	//String de usuario y clave
	String usuario,clave;
	
	//ArrayLists para usuarios y para último
	static ArrayList<String> users = new ArrayList<String>();
	private static ArrayList<String> last = new ArrayList<String>();
	
	
	/**
	 * Método crearWidgets para poner los objetos en un panel y en la ventana
	 */
	public void crearWidgets() {
		 
		//Se crear el layout
		panel.setLayout(new GridBagLayout());
		
		//Se inician los grid en x=0 y y=0
		//Se agragn al panel los objetos creados
		grid.gridx = 0;
		grid.gridy = 0;
		
		// Insets (top, left, bottom, right)
		grid.insets = new Insets(0,0,10,10); 
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
		
		//Se agragan los actionListener a los botones
		logButton.addActionListener(this);
		regButton.addActionListener(this);
	}
	
	
	/**
	 * Constructor de la clase LogIn
	 * 
	 * @see #recuperarEstado(String)
	 */
	public LogIn(){
		crearWidgets();
		recuperarEstado("usuarios.txt");
	}
	
	/**
	 * Método Container, para obtener el contenedor
	 * 
	 * @return panel
	 */
	public Container getContenedor(){
		return panel;
	}
	
	
	/**
	 * Implementación del método actionPerformed, para las acciones de los objetos
	 * 
	 * @see #guardarEstado(String)
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Condicional para el botón de log
		if(e.getSource()==logButton){
			String valid = "Usuario válido";
			String invalid = "Usuario no válido";
			usuario = userText.getText();
			clave = passText.getText();
			String comp = usuario+clave;
			if (users.contains(comp)){
				JOptionPane.showMessageDialog(null, valid);
				limpiarTextos();
				ClaseHome.cardlayout.show(ClaseHome.panelCards, "Home" );
			}
			else{
				//Excepción por si lo que ingresó no es correcto 
				JOptionPane.showMessageDialog(null, invalid);
				limpiarTextos();
			}
		}
		
		//Condicional para el botón de registro
		else if(e.getSource()==regButton){
			usuario = userText.getText();
			clave = passText.getText();
			String reg = "Usted está registrado, puede iniciar sesión";
			String guardar = usuario+clave;
			System.out.println(guardar);
			users.add(guardar);
			
			//Guarda el estado del sistema
			guardarEstado("usuarios.txt");
			JOptionPane.showMessageDialog(null, reg);
			limpiarTextos();
		}
	}
	
	/**
	 * Método limpiarTextos, para limpiar los campos de texto
	 */
	public void limpiarTextos(){
		userText.setText("");
		passText.setText("");
	}

	/** 
	 * Recibe una dirección, la cual es el archivo donde quedarán registrados los usuarios
	 * Se encarga de guardar los nuevos usuarios en el archivo de texto
	 */
	public static void guardarEstado (String dirFile) {
		
		//Se crea un nuevo archivo
		File archivo = new File(dirFile);
		last.clear();
		try{
			
			//Escribe sobre el archivo lo nuevo del usuario registrado
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
			
			//Cierra los archivos
			wr.close();
			bw.close();
			br.close();
			System.out.println("Si se hizo");}
		
		catch(IOException e){System.out.println("No se hizo");};
	}

	/**
	 * Recibe la dirección del archivo de texto con los usuarios
	 * Se encarga de leer el archivo de texto y cargar los usuarios en un arreglo
	 */
	public static void recuperarEstado(String dirFile){
		users.clear();
		
		//Crea archivos para leer
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			//Lee los archivos
			archivo = new File (dirFile); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea; 
			while((linea=br.readLine()) != null){
				users.add(linea);
			}
			
			//Cierra los archivos
			fr.close();
			br.close();}
				
		catch(IOException e){};}
	
	
	
}


