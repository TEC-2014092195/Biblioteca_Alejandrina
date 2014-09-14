/**====================================================================================
 * Archivo      : Ordenar.java � Paquete: logicaRegistro � Proyecto: Biblioteca_Alejandrina JoseManuel
 * Autores      : Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
 **==================================================================================== 
 */

package logicaRegistro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Filtro {
	public ArrayList<Cliente> tempClientes;
	public ArrayList<Articulo> tempArticulos;
	
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
	 * Los siguientes m�todos se encargan de filtrar la lista de clientes registrados de acuerdo a un atributo determinado
	 * Recibe: la lista original con los objetos cliente
	 * Retorna: una nueva lista con los objetos ordenados de acuerdo al atributo a filtrar 
	 */
	public ArrayList<Cliente> sortNombre(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getNombre().compareTo(p2.getNombre());
			}
	});
		return tempClientes;
	}
	public ArrayList<Cliente> sortApellido1(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getApellido1().compareTo(p2.getApellido1());
			}
	});
		return tempClientes;
	}
	public ArrayList<Cliente> sortApellido2(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getApellido2().compareTo(p2.getApellido2());
			}
	});
		return tempClientes;
	}
	public ArrayList<Cliente> sortTelefono(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getTelefono().compareTo(p2.getTelefono());
			}
	});
		return tempClientes;
	}
	public ArrayList<Cliente> sortCorreo(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getCorreo().compareTo(p2.getCorreo());
			}
	});
		return tempClientes;
	}
	public ArrayList<Cliente> sortCategoria(ArrayList<Cliente> lista){
		tempClientes = lista;
		Collections.sort(tempClientes, new Comparator<Cliente>(){
			@Override
			public int compare(Cliente p1, Cliente p2){
				return p1.getCategoria().compareTo(p2.getCategoria());
			}
	});
		return tempClientes;
	}
	/**
	 * 
	 * Los siguientes m�todos se encargan de filtrar la lista de art�culos registrados de acuerdo a un atributo determinado
	 * Recibe: la lista original con los objetos art�culo
	 * Retorna: una nueva lista con los objetos ordenados de acuerdo al atributo a filtrar 
	 */
	public ArrayList<Articulo> sortTitulo(ArrayList<Articulo> lista){
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getTitulo().compareTo(p2.getTitulo());
			}
	});
		return tempArticulos;
	}
	public ArrayList<Articulo> sortAutor(ArrayList<Articulo> lista){
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getAutor().compareTo(p2.getAutor());
			}
	});
		return tempArticulos;
	}
	public ArrayList<Articulo> sortDato1(ArrayList<Articulo> lista){
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getDato1().compareTo(p2.getDato1());
			}
	});
		return tempArticulos;
	}
	public ArrayList<Articulo> sortDato2(ArrayList<Articulo> lista){
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getDato2().compareTo(p2.getDato2());
			}
	});
		return tempArticulos;
	}
	public ArrayList<Articulo> sortCalif(ArrayList<Articulo> lista){
		tempArticulos = lista;
		Collections.sort(tempArticulos, new Comparator<Articulo>(){
			@Override
			public int compare(Articulo p1, Articulo p2){
				return p1.getCalif().compareTo(p2.getCalif());
			}
	});
		return tempArticulos;
	}
	
}