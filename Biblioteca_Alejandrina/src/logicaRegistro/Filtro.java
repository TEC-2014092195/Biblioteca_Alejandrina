/**====================================================================================
 * Archivo      : Ordenar.java » Paquete: logicaRegistro » Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package logicaRegistro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Filtro {
	public ArrayList<Cliente> tempClientes =  new ArrayList<Cliente>();//Se guardan las copias de los clientes ordenadas por los metodos
	public ArrayList<Articulo> tempArticulos = new ArrayList<Articulo>();//Se guardan las copias de los articulos ordenadas por los metodos
	public ArrayList<Articulo> libros = new ArrayList<Articulo>();
	public ArrayList<Articulo> revistas = new ArrayList<Articulo>();
	public ArrayList<Articulo> peliculas = new ArrayList<Articulo>();
	public ArrayList<Articulo> series = new ArrayList<Articulo>();
	public ArrayList<Articulo> prestados = new ArrayList<Articulo>();
	public ArrayList<Articulo> noPrestados = new ArrayList<Articulo>();
	
	/**
	 * @param clientesRegistrados
	 * @param articulosRegistrados
	 */
	public Filtro(ArrayList<Cliente> clientes,ArrayList<Articulo> articulos){
		tempClientes = clientes;
		tempArticulos = articulos;
	}
	/**
	 * 
	 * Los siguientes métodos se encargan de filtrar la lista de clientes registrados de acuerdo a un atributo determinado
	 * Recibe: la lista original con los objetos cliente
	 * Retorna: una nueva lista con los objetos ordenados de acuerdo al atributo a filtrar 
	 */
	public void sortNombre(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getNombre().compareTo(p2.getNombre());
			}
	});
	}
	public void sortApellido1(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getApellido1().compareTo(p2.getApellido1());
			}
	});
	}
	public void sortApellido2(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getApellido2().compareTo(p2.getApellido2());
			}
	});
	}
	public void sortTelefono(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getTelefono().compareTo(p2.getTelefono());
			}
	});
	}
	public void sortCorreo(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getCorreo().compareTo(p2.getCorreo());
			}
	});
	}
	public void sortCategoria(ArrayList<Cliente> lista){
		tempClientes.clear();
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getCategoria().compareTo(p2.getCategoria());
			}
	});
	}
	/**
	 * 
	 * Los siguientes métodos se encargan de filtrar la lista de artículos registrados de acuerdo a un atributo determinado
	 * Recibe: la lista original con los objetos artículo
	 * Retorna: una nueva lista con los objetos ordenados de acuerdo al atributo a filtrar 
	 */
	public void sortTitulo(ArrayList<Articulo> lista){
		tempArticulos.clear();
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getTitulo().compareTo(p2.getTitulo());
			}
	});
	}
	public void sortAutor(ArrayList<Articulo> lista){
		tempArticulos.clear();
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getAutor().compareTo(p2.getAutor());
			}
	});
	}
	public void sortDato1(ArrayList<Articulo> lista){
		tempArticulos.clear();
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getDato1().compareTo(p2.getDato1());
			}
	});
	}
	public void sortDato2(ArrayList<Articulo> lista){
		tempArticulos.clear();
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getDato2().compareTo(p2.getDato2());
			}
	});
	}
	public void sortCalif(ArrayList<Articulo> lista){
		tempArticulos.clear();
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getCalif().compareTo(p2.getCalif());
			}
	});
	}
	//Estos métodos generan una lista con los respectivos articulos de cada tipo
	public void obtLibros(ArrayList<Articulo> lista){
		for (int i = 0 ; i < lista.size() ; i++){
			if (lista.get(i).getTipo().equals("Libro")){
				libros.add(lista.get(i));
			}
		}
	}
	public void obtRevistas(ArrayList<Articulo> lista){
		for (int i = 0 ; i < lista.size() ; i++){
			if (lista.get(i).getTipo().equals("Revista")){
				revistas.add(lista.get(i));
			}
		}
	}
	public void obtPeliculas(ArrayList<Articulo> lista){
		for (int i = 0 ; i < lista.size() ; i++){
			if (lista.get(i).getTipo().equals("Película")){
				peliculas.add(lista.get(i));
			}
		}
	}
	public void obtSeries(ArrayList<Articulo> lista){
		for (int i = 0 ; i < lista.size() ; i++){
			if (lista.get(i).getTipo().equals("Serie")){
				series.add(lista.get(i));
			}
		}
	}
	public void asignarPrestados(ArrayList<Articulo> lista){
		for (int i = 0 ; i < lista.size() ; i++){
			if (lista.get(i).isPrestado() == true){
				prestados.add(lista.get(i));
			}
			else{
				noPrestados.add(lista.get(i));
			}
		}
	}
	/*La idea de estas funciones es que a la hora de llamar a la ventana de consulta de artículos  ejecutar 
	 * los metodos que sean VOID para llenarlos con los datos correspondientes en el momento de la consulta.
	 * así las listas quedan llenas y se pueden poner en la interfaz de acuerdo a lo que el cliente requiera
	 * EJEMPLO: se llama a la ventana de consultas y se ejecutan los metodos,  Con las listas ya creadas nada mas
	 * se imprime en forma de interfaz grafica la que el cliente seleccione*/
	
}
