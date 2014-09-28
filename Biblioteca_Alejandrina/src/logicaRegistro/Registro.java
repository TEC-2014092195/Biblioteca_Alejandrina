package logicaRegistro;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Registro {
	
	public static ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();
	public static ArrayList<Articulo> articulosRegistrados = new ArrayList<Articulo>();
	
	//Variables de la clase Clientes. 
		protected static int cantClientes = 0;
		protected int identificadorCliente = 0;
		protected String cedula = null;
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
		protected String fechaPrestado = null;
		protected String fechaDevolucion = null;
		protected boolean prestado = false;
		protected int diasPrestado  = 0;
		protected int vecesPrestado = 0;
		
		protected static final String dirFile = "Biblioteca_Alejandrina/data/registrodatos.txt";  
		protected static final String dirFile2 = "Biblioteca_Alejandrina/data/registrodatosdecero.txt"; 
		
		
	public static void verificarArchivo() throws IOException { 
		File file = new File(dirFile);
    	if (file.getParentFile().mkdirs()) {
    	    file.createNewFile();
    	    System.out.println(file.getParentFile());
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}
	
	public static boolean cerrarPasoRepetidos (String nuevaCedula){
        for (Cliente cliente : clientesRegistrados ){
        	if ( cliente.getCedula().equals(nuevaCedula)){
        		return false;}}
        return true;}
	
	/*
	 * Esta función lee un txt con información nueva para un inicio de programa
	 * automatizado. 
	 * Utiliza los constructores para nuevo objeto y nuevo cliente. 
	 */
	public static void leerTxtDeCero () {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] novoEntrada = null;
		
		try {
			verificarArchivo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			archivo = new File (dirFile2); 
		    fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
		    br = new BufferedReader(fr);	 
		    String linea;
		    String entrada = null;
		    
		    //Todas las líneas son tratadas de acuerdo al identificador que tienen en el primer espacio. 
			while((linea=br.readLine()) != null){
				entrada = linea;
		    	novoEntrada = entrada.split(";");
		    	if ("Cliente".equals(novoEntrada[0])){
		    		clientesRegistrados.add(new Cliente(novoEntrada[1],
		    								novoEntrada[2], novoEntrada[3], 
		    								novoEntrada[4], novoEntrada[5], 
		    								novoEntrada[6], novoEntrada[7]));}
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
	
	public static void guardarEstadoActualSistema () {
		try {
			verificarArchivo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		File archivo = new File(dirFile);
		try{
			FileWriter w = new FileWriter(archivo.getAbsolutePath() + java.io.File.separator);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			
			/*En este ciclo for se guardan todos los artículos registrados en el txt.
			 * Se guardan en el orden en el que entraron, pues los identificadores son
			 * requeridos después en el reestablecimiento del sistema. 
			 */
			for (Articulo objeto : Registro.articulosRegistrados){
				String entradaTxt = "";
				entradaTxt += objeto.getTipo() + ";";
				entradaTxt += objeto.getTitulo() + ";";
				entradaTxt += objeto.getAutor() + ";";
				entradaTxt += objeto.getDato1() + ";";
				entradaTxt += objeto.getDato2() + ";";
				entradaTxt += objeto.getDirImg() + ";";
				entradaTxt += objeto.getCalif() + ";";
				entradaTxt += objeto.isPrestado() + ";";
				entradaTxt += objeto.getFechaPrestado() + ";";
				entradaTxt += objeto.getFechaDevolucion() + ";";
				entradaTxt += objeto.getDiasPrestado() + ";";
				entradaTxt += objeto.getVecesPrestado() + ";";
				wr.write(entradaTxt);
				bw.newLine();}
			
			/*En este ciclo for se guardan los clientes registrados 
			 *	con los elementos prestados según identificador.
			 *
			 *Cabe destacar que debe realizarse en este orden pues para
			 *	restablecer el sistema este requiere que todos los artículos
			 *	se devuelvan a la lista con su respectivo identificador para 
			 *	poder realizar todos los préstamos a los clientes como estaban
			 *	previamente. 
			 */
			
			for (Cliente cliente : Registro.clientesRegistrados) {
				String entradaTxt = "";
				entradaTxt += "Cliente;";
				entradaTxt += cliente.getCedula() + ";";
				entradaTxt += cliente.getNombre() + ";";
				entradaTxt += cliente.getApellido1() + ";";
				entradaTxt += cliente.getApellido2() + ";";
				entradaTxt += cliente.getTelefono() + ";";
				entradaTxt += cliente.getCorreo() + ";";
				entradaTxt += cliente.getCategoria() + ";0-"; //Ningun artículo tendrá identificador 0. 
				for (Articulo prestamo : cliente.prestamos){
					entradaTxt += prestamo.getIdentificadorObjeto() + "-"; }
				entradaTxt += ";";
				wr.write(entradaTxt);
				bw.newLine();}
				
			wr.close();
			bw.close();}
		
		catch(IOException e){};}
	
	/*
	 * Esta función, similar a leerTxtDeCero, se encarga de usar la lista especial 
	 * creada por la función guardarEstadoActualSistema para reestablecer toda la
	 * información que se guardó por última vez en el Txt. 
	 */
	
	public static void recuperarEstadoSistema (){
		//Se reinician los contadores de objetos. 
		cantClientes = 0;
		cantObjetos = 0;
		clientesRegistrados.clear();
		articulosRegistrados.clear();
		
		try {
			verificarArchivo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] novoEntrada = null;
		
		try {
			archivo = new File (dirFile); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea;
			String entrada = null;
			    
			while((linea=br.readLine()) != null){
				entrada = linea;
			    novoEntrada = entrada.split(";");
			    if ("Cliente".equals(novoEntrada[0])){
			    	String[] reestablecerPrestados = novoEntrada[8].split("-");
			    	ArrayList<Articulo> Prestados = new ArrayList<Articulo>();
			    	for (String unidad : reestablecerPrestados) {
			    		for (Articulo registrados : articulosRegistrados) {
			    			String ident = Integer.toString(registrados.getIdentificadorObjeto());
			    			if (ident.equals(unidad)){
			    				Prestados.add(registrados);
			    			}}}
			    	//Invoco el constructor especial
			   	clientesRegistrados.add(new Cliente(novoEntrada[1],
			   								novoEntrada[2], novoEntrada[3], 
			   								novoEntrada[4], novoEntrada[5], 
			   								novoEntrada[6], novoEntrada[7], Prestados ));}
			   	else {
			   		//Convierto el string prestado en un boolean.
			   		boolean Prest = false;
			   		if (novoEntrada[7].equals("true"))
			   			Prest = true;
			   		//Convierto el string de días prestado en un int.
			   		int Dias = Integer.parseInt(novoEntrada[10]);
			   		int VecesP = Integer.parseInt(novoEntrada[11]);
			    	//Invoco el constructor especial. 
			   		articulosRegistrados.add(new Articulo(novoEntrada[0],
			   								novoEntrada[1],novoEntrada[2],
			   								novoEntrada[3],novoEntrada[4],
			   								novoEntrada[5],novoEntrada[6],
			   								novoEntrada[8],novoEntrada[9],
		    								Prest,Dias,VecesP));}}}
		catch(Exception e){
			e.printStackTrace();}
		finally{
			try{                    
				if( null != fr ){   
					fr.close();}}
			catch (Exception e2){ 
				e2.printStackTrace();}}}

	
}