/**====================================================================================
 * Archivo      : ventanaNotificaciones.java � Paquete: Notificaciones � Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
 **==================================================================================== 
 */

package Notificaciones;

import logicaRegistro.Registro;


public class ventanaNotificaciones {

	
	public static void main(String[] args) {
		Registro.recuperarEstadoSistema();
		Notificaciones vn = new Notificaciones();

	}

}
