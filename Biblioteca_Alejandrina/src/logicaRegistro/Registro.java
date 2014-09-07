package logicaRegistro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Registro.
 */
public class Registro {
	
	/** The clientes registrados. */
	public static ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();
	
	/** The articulos registrados. */
	public static ArrayList<Articulo> articulosRegistrados = new ArrayList<Articulo>();
	
	//Variables de la clase Clientes. 
		/** The cant clientes. */
	protected static int cantClientes = 0;
		
		/** The identificador cliente. */
		protected int identificadorCliente = 0;
		
		/** The nombre. */
		protected String nombre = null;
		
		/** The apellido1. */
		protected String apellido1 = null;
		
		/** The apellido2. */
		protected String apellido2 = null;
		
		/** The telefono. */
		protected String telefono = null;
		
		/** The correo. */
		protected String correo = null; 
		
		/** The categoria. */
		protected String categoria = null;
		
		/** The prestamos. */
		protected ArrayList<Articulo> prestamos;
		
	//Variables de la clase Objetos.
		/** The cant objetos. */
	protected static int cantObjetos = 0;
		
		/** The identificador objeto. */
		protected int identificadorObjeto = 0;
		
		/** The tipo. */
		protected String tipo = null;
		
		/** The titulo. */
		protected String titulo = null;
		
		/** The autor. */
		protected String autor = null;
		
		/** The dato1. */
		protected String dato1 = null;
		
		/** The dato2. */
		protected String dato2 = null;
		
		/** The dir img. */
		protected String dirImg = null;
		
		/** The calif. */
		protected String calif = null;
		
		/** The prestado. */
		protected boolean prestado = false;
		
	/**
	 * Leer txt.
	 *
	 * @param dirFile the dir file
	 */
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

