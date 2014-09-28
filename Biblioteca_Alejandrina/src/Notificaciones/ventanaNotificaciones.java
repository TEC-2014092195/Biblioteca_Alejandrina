/**====================================================================================
 * Archivo      : ventanaNotificaciones.java » Paquete: Notificaciones » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
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
