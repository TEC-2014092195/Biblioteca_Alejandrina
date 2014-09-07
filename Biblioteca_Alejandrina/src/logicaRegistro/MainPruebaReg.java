package logicaRegistro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

// TODO: Auto-generated Javadoc
/**
 * The Class MainPruebaReg.
 */
public class MainPruebaReg {

	/** The in. */
	static BufferedReader in;
	
	/** The out. */
	static PrintStream out;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main (String[] args) throws IOException {
		in = new BufferedReader (new InputStreamReader(System.in));
		out = System.out;
		
		//Se hace el registro de todos los articulos y clientes
		Registro.leerTxt("archivo.txt");
		
		//Prestar un articulo
		Registro.clientesRegistrados.get(0).prestar(Registro.articulosRegistrados.get(1));
		
		//out.println(Registro.clientesRegistrados.get(0).toString());
		
		out.println("\nClientes registrados");
		//Muestro todos los clientes
		for (Cliente cliente : Registro.clientesRegistrados) {
			out.println("");
			out.print(cliente);
			out.print("");}
		
		out.println("\nArtículos disponibles");
		//Muestro los artículos sin prestar únicamente
		for (Articulo objeto : Registro.articulosRegistrados) {
			if (!objeto.isPrestado()){
				out.print(objeto);
				out.print("");}}
	}

}
