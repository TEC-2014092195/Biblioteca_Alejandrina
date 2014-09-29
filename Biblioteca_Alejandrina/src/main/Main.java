/**====================================================================================
 * Archivo      : main.java � Paquete: main � Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
 **==================================================================================== 
 */

package main;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import Notificaciones.Notificaciones;
import controles.PopupControles;
import tiempo.Tiempo;
import logicaRegistro.Registro;


public class Main {

	
	public static void main(String[] args) {
		// Recupera el estado del archivo de texto "Biblioteca_Alejandrina/data/registrodatos.txt".
		Registro.recuperarEstadoSistema();
		
		Tiempo.calcularFechaReal(); 
		ClaseIntroduccion ci = new ClaseIntroduccion(); //Inicia con la imagen del logotipo (comentado para no atrasar el proceso hasta la versi�n final)
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 PopupControles pcontroles = new PopupControles();
	        	 Notificaciones notif = new Notificaciones();
	         }
	      });
	                	

		
		
		
	}

}
