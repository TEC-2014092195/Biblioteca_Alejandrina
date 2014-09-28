package logicaRegistro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import tiempo.Tiempo;

public class MainPruebaReg {

	static BufferedReader in;
	static PrintStream out;
	
	public static void main (String[] args) throws IOException {
		//Pruebas de la clase tiempo. 
		Tiempo.calcularFechaReal(); 	//Seteo las variables a la realidad
		Tiempo.simularCambioDia();		//Sin parámetros, avanza un día
		Tiempo.simularCambioDia(365*2); //Dos años, pasa por un bisiesto
		
		//Se hace el registro de todos los articulos y clientes
		Registro.leerTxtDeCero();
		
		/*Si quiere verse apenas se lee del Txt*/
		/*
		System.out.println("\nClientes registrados");
		for (Cliente cliente : Registro.clientesRegistrados) {
			System.out.println("");
			System.out.print(cliente);
			System.out.print("");}
		
		System.out.println("\nArtículos disponibles");
		//Muestro los artículos sin prestar únicamente
		for (Articulo objeto : Registro.articulosRegistrados) {
			if (!objeto.isPrestado()){
				System.out.print(objeto);
				System.out.print("");}}
		/**/
		
		Registro.guardarEstadoActualSistema();
		Registro.recuperarEstadoSistema();
		Registro.clientesRegistrados.get(0).prestar(1);
		Tiempo.simularCambioDia();
		
		Registro.clientesRegistrados.get(0).devolver(1);
		
		Registro.guardarEstadoActualSistema();
		/*Si quiere verse después de reestablecer el sistema.*/
		
		System.out.println("\nClientes registrados");
		for (Cliente cliente : Registro.clientesRegistrados) {
			System.out.println("");
			System.out.print(cliente);
			System.out.print("");}
		
		
		System.out.println("\nArtículos disponibles");
		//Muestro los artículos sin prestar únicamente
		for (Articulo objeto : Registro.articulosRegistrados) {
			if (!objeto.isPrestado()){
				System.out.print(objeto);
				System.out.print("");}}
		/**/
		
		
		/*Registro.recuperarEstadoSistema();
		Cliente cli1 = new Cliente("Kevin","Hernández","Rostrán","22136900","kevinah95@gmail.com","Estudiante");
		Registro.clientesRegistrados.add(cli1);
		Registro.guardarEstadoActualSistema();
		Registro.clientesRegistrados.get(0).prestar(2);
		out.println(Registro.clientesRegistrados.get(Registro.clientesRegistrados.size()-1).toString());
		System.out.println(Registro.clientesRegistrados.size());
		
		Registro.guardarEstadoActualSistema();*/
		/*
		Articulo Caso1 = new Articulo( "Libro","Quijote","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5", false,5);
		Articulo Caso2 = new Articulo( "Libro","Quijote2","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5", false,5 );
		Articulo Caso3 = new Articulo( "Libro","Quijote3","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5", false,5 );
		Articulo Caso4 = new Articulo( "Revista","Rev","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5" , false,5);
		Articulo Caso5 = new Articulo( "Revista","Rev","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5" , false,5);
		Articulo Caso6 = new Articulo( "Revista","Rev","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5" , false,5);
		Articulo Caso7 = new Articulo( "Película","Rev","Miguel de Cervantes","Edit Madrid","16 y algo","Aqui","5" , false,5);
		Registro.articulosRegistrados.add(Caso1);
		Registro.articulosRegistrados.add(Caso4);
		Registro.articulosRegistrados.add(Caso3);
		Registro.articulosRegistrados.add(Caso7);
		Registro.articulosRegistrados.add(Caso2);
		Registro.articulosRegistrados.add(Caso5);
		Registro.articulosRegistrados.add(Caso6);
		Filtro prueba = new Filtro(Registro.clientesRegistrados,Registro.articulosRegistrados);
		prueba.obtPeliculas(Registro.articulosRegistrados);
		prueba.obtLibros(Registro.articulosRegistrados);
		System.out.println(prueba.libros.size());
		for (int i = 0 ; i < prueba.libros.size() ; i++){
			System.out.println(prueba.libros.get(i).toString());
		}
		
		*/
		
//		//Ejemplo de los filtros
//		Filtro registro = new Filtro(Registro.clientesRegistrados,Registro.articulosRegistrados);
//		ArrayList<Cliente> filtro1 = registro.sortNombre(Registro.clientesRegistrados);
//		out.println("Filtrados por Nombre");
//		for (Cliente cliente : filtro1){
//			out.println("");
//			out.print(cliente);
//			out.print("");}
//		
//		ArrayList<Cliente> filtro2 = registro.sortApellido1(Registro.clientesRegistrados);
//		out.println("Filtrados por Apellido");
//		for (Cliente cliente : filtro2){
//			out.println("");
//			out.print(cliente);
//			out.print("");}
//		
//		ArrayList<Cliente> filtro3 = registro.sortCategoria(Registro.clientesRegistrados);
//		out.println("Filtrados por Categoria");
//		for (Cliente cliente :filtro3){
//			out.println("");
//			out.print(cliente);
//			out.print("");}
//		
//		Registro.guardarEstadoActualSistema("pruebaguardado.txt");
		
		
	}
		
}
