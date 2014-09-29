/**====================================================================================
 * Archivo      : main.java » Paquete: main » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
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
		ClaseIntroduccion ci = new ClaseIntroduccion(); //Inicia con la imagen del logotipo (comentado para no atrasar el proceso hasta la versión final)
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 PopupControles pcontroles = new PopupControles();
	        	 Notificaciones notif = new Notificaciones();
	         }
	      });
	                	

		
		
		
	}

}
