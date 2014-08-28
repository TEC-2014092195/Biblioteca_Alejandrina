package Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public abstract class Registro {
	
	public static ArrayList<RegistroClientes> clientesRegistrados = new ArrayList<RegistroClientes>();
	public static ArrayList<RegistroObjetos> objetosRegistrados = new ArrayList<RegistroObjetos>();
	static BufferedReader in;
	static PrintStream out;
	
	public static void leerTxt(String dirFile) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] novoEntrada = null;
		try {
			archivo = new File (dirFile); //El archivo debe estar en la carpeta Biblioteca Alejandrina
		    fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
		    br = new BufferedReader(fr);	 
		    String linea;
		    String entrada = null;
			while((linea=br.readLine()) != null){
				entrada = linea;
		    	novoEntrada = entrada.split(";");
		    	//if (novoEntrada[0] == "Cliente"){
		    		out.println(novoEntrada[0]=="Cliente");
		    		clientesRegistrados.add(new RegistroClientes(novoEntrada[1],
		    									novoEntrada[2], novoEntrada[3], 
		    									novoEntrada[4], novoEntrada[5], 
		    									novoEntrada[6]));
		    		//}
		    	/*else {
		    		objetosRegistrados.add(new RegistroObjetos(novoEntrada[0],
		    								   novoEntrada[1],novoEntrada[2],
		    								   novoEntrada[3],novoEntrada[4],
		    								   novoEntrada[5],novoEntrada[6]));} */
		    								   }}
		catch(Exception e){
			e.printStackTrace();}
		finally{
			try{                    
				if( null != fr ){   
					fr.close();}}
			catch (Exception e2){ 
				e2.printStackTrace();}}}
	
	public static void main (String[] args) throws IOException {
		in = new BufferedReader (new InputStreamReader(System.in));
		out = System.out;
		
		leerTxt("archivo.txt");
		
		for (RegistroClientes cliente : clientesRegistrados) {
			out.println("");
			out.print(cliente/*.toString()*/); //Fun fact: si llamo que printee la vara automáticamente llama al to String.
			out.print("");}
	}
}
