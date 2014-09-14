/**====================================================================================
 * Archivo      : LogIn.java » Paquete: Main » Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Main;
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
	JPanel panel;
	JFrame frame;
	JLabel userLabel,passLabel;
	static JTextField passText;
	static JTextField userText;
	JButton logButton, regButton;
	String usuario,clave;
	static ArrayList<String> users;
	private static ArrayList<String> last;
	
	//Fin de Variables
	
	
	public void crearWidgets(JPanel panel) {
		
		panel.setLayout(null);
		userLabel = new JLabel("Usuario:");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passLabel = new JLabel("Contraseña:");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		passText = new JTextField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);

		logButton = new JButton("Iniciar Sesión");
		logButton.setBounds(10, 80, 120, 25);
		panel.add(logButton);
		
		regButton = new JButton("Registrar");
		regButton.setBounds(150, 80, 120, 25);
		panel.add(regButton);
		
		logButton.addActionListener(this);
		regButton.addActionListener(this);
	}
	
	public void crearFrame(){
			frame = new JFrame("Ingreso a la Bibilioteca");
			frame.setSize(300, 150);
			frame.setLocation(550, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new JPanel();
			frame.add(panel);
			crearWidgets(panel);
			frame.setVisible(true);
		}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logButton){
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
			users.add(guardar);
			JOptionPane.showMessageDialog(null, reg);
			limpiarTextos();
		}
	}
	public void limpiarTextos(){
		userText.setText("");
		passText.setText("");
	}
	public boolean revisar(String linea){
		if (users.contains(linea) == true){
			return true;
		}
		else{
			return false;
		}
	}

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

	
	public static void recuperarEstado(String dirFile){
		//Se reinician los contadores de objetos. 
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


