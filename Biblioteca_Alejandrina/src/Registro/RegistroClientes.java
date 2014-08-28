/**====================================================================================
 * Archivo      : RegistroClientes.java » Paquete: Registro » Proyecto: Biblioteca_Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package Registro;

public class RegistroClientes extends Registro{
	
	/*
	 * Esta clase recibe los parámetros necesarios para la creación de 
	 * un usuario nuevo de la biblioteca, y guarda la información en un .txt
	 * para generar toda la información en su última actualización
	 * cuando se reinicia la aplicación
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
			return "Categoría Desconocida";}}
	
	public String toString (){
		String msj = "Cliente "+getIdentificadorCliente()+":\n";
		msj += "Nombre: " + getNombre()+" "+getApellido1()+" "+getApellido2()+"\n";
		msj += "Teléfono: "+ getTelefono()+"\n";
		msj += "Correo: "+getCorreo()+"\n";
		msj += "Categoria: "+presentarCategoria()+"\n";
		return msj;
	}
}
