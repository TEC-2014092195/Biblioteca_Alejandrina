package logicaRegistro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainPruebaReg {

	static BufferedReader in;
	static PrintStream out;
	
	public static void main (String[] args) throws IOException {
		in = new BufferedReader (new InputStreamReader(System.in));
		out = System.out;
		
		//Se hace el registro de todos los articulos y clientes
		//Registro.leerTxtDeCero("archivo.txt");
		//Prestar un articulo
		//Registro.clientesRegistrados.get(0).prestar(Registro.articulosRegistrados.get(1));
		//out.println(Registro.clientesRegistrados.get(0).toString());
		
		//Aquí elimino todo el sistema, y lo reestablezco
		//Registro.guardarEstadoActualSistema("pruebaguardado.txt");
		//Registro.recuperarEstadoSistema("pruebaguardado.txt");
		//---------------
		
		
		//----Printeo todos los resultados: Hacerlo antes o después de la 
		//reestauración debe dar el mismo resultado. 
		//out.println("\nClientes registrados");
		//Muestro todos los clientes
		//for (Cliente cliente : Registro.clientesRegistrados) {
			//out.println("");
			//out.print(cliente);
			//out.print("");}
		
		//out.println("\nArtículos disponibles");
		//Muestro los artículos sin prestar únicamente
		//for (Articulo objeto : Registro.articulosRegistrados) {
			//if (!objeto.isPrestado()){
				//out.print(objeto);
				//out.print("");}}
		
		out.print("Esta prueba de casos consiste en los siguiente:\n"
				+ "Se lee un documento de texto con clientes y artículos,\n"
				+ "se crean nuevos clientes y artículos y se agregan al registro,\n"
				+ "se realizan préstamos de algunos artículos y se genera un archivo nuevo");
		Registro.recuperarEstadoSistema("archivo.txt");
		for (Cliente cliente : Registro.clientesRegistrados) {
			out.println("");
			out.print(cliente);
			out.print("");}
		out.println("Muestro los clientes que se cargaron desde el archivo");
		out.println("SE CREAN CLIENTES DE CADA TIPO");
		Cliente caso1 = new Cliente("Roberto","Aguilar","Quesada", "22490339", "roberto-aq@tumail.com", "Familiar");
		Cliente caso2 = new Cliente("Manuel","Quesada","Jiménez", "24167913", "manuel.quesada@tumail.com", "Funcionario");
		Cliente caso3 = new Cliente("Mariana","Mora","Alpízar", "88861748", "mariana.ma@tumail.com", "Estudiante");
		out.println("SE CREAN ARTÍCULOS DE CADA TIPO");
		Articulo caso4 = new Articulo("Libro","Don Quijote de la Mancha","Miguel de Cervantes","Editorial Madrid", "Quinta Edicion","sistema/carpetaImagenes/img.jpg","5",false,7);
		Articulo caso5 = new Articulo("Revista","mtbPRO","Sports Team","Editorial Deportiva", "Edicion de Setiembre","sistema/carpetaImagenes/img2.jpg","4",false,4);
		Articulo caso6 = new Articulo("Pelicula","The Avengers","Marvel","Marvel Movies", "Version Extendida","sistema/carpetaImagenes/img3.jpg","3",false,2);
		Articulo caso7 = new Articulo("Serie","The Walking Death","Fox","Fox Studios", "Primera Remporada","sistema/carpetaImagenes/img4.jpg","4",false,15);
		out.println("SE AÑADEN LOS CLIENTES Y LOS ARTICULOS AL REGISTRO RESPECTIVO");
		Registro.clientesRegistrados.add(caso1);
		Registro.clientesRegistrados.add(caso2);
		Registro.clientesRegistrados.add(caso3);
		Registro.articulosRegistrados.add(caso4);
		Registro.articulosRegistrados.add(caso5);
		Registro.articulosRegistrados.add(caso6);
		Registro.articulosRegistrados.add(caso7);
		Registro.guardarEstadoActualSistema("pruebaguardado.txt");
		out.println("Muestro los clientes que exitían y los que se crearon");
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
		out.println("Realizo el préstamo de algunos articulos");
		caso1.prestar(caso7);
		caso2.prestar(caso6);
		out.println("\nArtículos disponibles después de los préstamos");
		//Muestro los artículos sin prestar únicamente
		for (Articulo objeto : Registro.articulosRegistrados) {
			if (!objeto.isPrestado()){
				out.print(objeto);
				out.print("");}}
		out.println("\nGuardo el estado actual de los ");
		Registro.guardarEstadoActualSistema("pruebaguardado.txt");
	}

}
