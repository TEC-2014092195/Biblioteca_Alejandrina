package logicaRegistro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Registro {
	
	public static ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();
	public static ArrayList<Articulo> articulosRegistrados = new ArrayList<Articulo>();
	
	//Variables de la clase Clientes. 
		protected static int cantClientes = 0;
		protected int identificadorCliente = 0;
		protected String nombre = null;
		protected String apellido1 = null;
		protected String apellido2 = null;
		protected String telefono = null;
		protected String correo = null; 
		protected String categoria = null;
		protected ArrayList<Articulo> prestamos;
		
	//Variables de la clase Objetos.
		protected static int cantObjetos = 0;
		protected int identificadorObjeto = 0;
		protected String tipo = null;
		protected String titulo = null;
		protected String autor = null;
		protected String dato1 = null;
		protected String dato2 = null;
		protected String dirImg = null;
		protected String calif = null;
		protected boolean prestado = false;
		
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
		    	if ("Cliente".equals(novoEntrada[0])){
		    		clientesRegistrados.add(new Cliente(novoEntrada[1],
		    									novoEntrada[2], novoEntrada[3], 
		    									novoEntrada[4], novoEntrada[5], 
		    									novoEntrada[6]));}
		    	else {
		    		articulosRegistrados.add(new Articulo(novoEntrada[0],
		    								   novoEntrada[1],novoEntrada[2],
		    								   novoEntrada[3],novoEntrada[4],
		    								   novoEntrada[5],novoEntrada[6]));}}}
		catch(Exception e){
			e.printStackTrace();}
		finally{
			try{                    
				if( null != fr ){   
					fr.close();}}
			catch (Exception e2){ 
				e2.printStackTrace();}}}

}

