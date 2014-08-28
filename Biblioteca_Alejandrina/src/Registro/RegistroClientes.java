/**====================================================================================
 * Archivo      : RegistroClientes.java � Paquete: Registro � Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Control de pr�stamo de art�culos para una Biblioteca
 **==================================================================================== 
 */

package Registro;

public class RegistroClientes extends Registro{
	
	/*
	 * Esta clase recibe los par�metros necesarios para la creaci�n de 
	 * un usuario nuevo de la biblioteca, y guarda la informaci�n en un .txt
	 * para generar toda la informaci�n en su �ltima actualizaci�n
	 * cuando se reinicia la aplicaci�n
	 */
	
	//Variables de la clase. 
	private static int cantClientes = 0;
	private int identificadorCliente = 0;
	private String nombre = null;
	private String apellido1 = null;
	private String apellido2 = null;
	private String telefono = null;
	private String correo = null; 
	private String categoria = null;
	
	//Constructor para clientes nuevos. 
	public RegistroClientes(String nNombre,
							String nApellido1,
							String nApellido2,
							String nTelefono,
							String nCorreo,
							String nCategoria) 
	{	cantClientes++;
		setIdentificadorCliente(cantClientes);
		setNombre(nNombre);
		setApellido1(nApellido1);
		setApellido2(nApellido2);
		setTelefono(nTelefono);
		setCorreo(nCorreo);
		setCategoria(nCategoria);	}
	
	//Setters y Getters.------------------------------------------------------//
	public int getCantClientes() {return cantClientes;} //El equivalente al largo de la lista
	public int getIdentificadorCliente() {return identificadorCliente;}
	public void setIdentificadorCliente(int identificadorCliente) {this.identificadorCliente = identificadorCliente;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getApellido1() {return apellido1;}
	public void setApellido1(String apellido1) {this.apellido1 = apellido1;}
	public String getApellido2() {return apellido2;}
	public void setApellido2(String apellido2) {this.apellido2 = apellido2;}
	public String getTelefono() {return telefono;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	public String getCorreo() {return correo;}
	public void setCorreo(String correo) {this.correo = correo;}
	public String getCategoria() {return categoria;}	
	public void setCategoria(String categoria) {this.categoria = categoria;}
	//------------------------------------------------------------------------//
	
	public String presentarCategoria(){
		if (getCategoria() == "1"){
			return "Estudiante";}
		else if (getCategoria() == "2"){
			return "Colega";}
		else if (getCategoria() == "3"){
			return "Familiar";}
		else {
			return "Categor�a Desconocida";}}
	
	public String toString (){
		String msj = "Cliente "+getIdentificadorCliente()+":\n";
		msj += "Nombre: " + getNombre()+" "+getApellido1()+" "+getApellido2()+"\n";
		msj += "Tel�fono: "+ getTelefono()+"\n";
		msj += "Correo: "+getCorreo()+"\n";
		msj += "Categoria: "+presentarCategoria()+"\n";
		return msj;
	}
}
