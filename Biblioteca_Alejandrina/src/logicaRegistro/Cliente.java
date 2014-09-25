package logicaRegistro;

import java.util.*;

public class Cliente extends Registro{
	
	/*
	 * Esta clase recibe los parámetros necesarios para la creación de 
	 * un usuario nuevo de la biblioteca.
	 * Cada usuario tiene dos identificadores fundamentales:
	 * -El número de usuario (definido con cant. clientes)
	 * -El tipo de usuario, que es 1, 2 o 3.
	 * 
	 * Su segundo constructor recibe los parámetros del Txt para 
	 * reestablecer, entre los que viene una lista con los objetos
	 * que tenía prestados, incluída la cantidad de días que tenía con cada
	 * objeto. 
	 */
	
	//Constructor para clientes nuevos. 
	public Cliente( String pCedula,
				    String nNombre,
				    String nApellido1,
				    String nApellido2,
				    String nTelefono,
			        String nCorreo,
				    String nCategoria )
							
	{	cantClientes++;
		setCedula(pCedula);
		setPrestamos(new ArrayList<Articulo>());
		setIdentificadorCliente(cantClientes);
		setNombre(nNombre);
		setApellido1(nApellido1);
		setApellido2(nApellido2);
		setTelefono(nTelefono);
		setCorreo(nCorreo);
		setCategoria(nCategoria);	}
	
	//Constructor para reestablecer sistema. 
	public Cliente( String pCedula,
					String nNombre,
			   		String nApellido1,
			   		String nApellido2,
			   		String nTelefono,
			   		String nCorreo,
			   		String nCategoria,
			   		ArrayList<Articulo> nPrestados)
						
		{	cantClientes++;
			setCedula(pCedula);
			setPrestamos(new ArrayList<Articulo>());
			setIdentificadorCliente(cantClientes);
			setNombre(nNombre);
			setApellido1(nApellido1);
			setApellido2(nApellido2);
			setTelefono(nTelefono);
			setCorreo(nCorreo);
			setCategoria(nCategoria);
			for (Articulo prestado : nPrestados) {prestamos.add(prestado);}		}
	
	//Setters y Getters.------------------------------------------------------//
	public int getCantClientes() {return cantClientes;} //El equivalente al largo de la lista
	public int getIdentificadorCliente() {return identificadorCliente;}
	public String getCedula() {return cedula;}
	public void setCedula(String cedula) {this.cedula = cedula;}
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
	public ArrayList<Articulo> getPrestamos() {return prestamos;}
	public void setPrestamos(ArrayList<Articulo> prestamos) {this.prestamos = prestamos;}
	//------------------------------------------------------------------------//
	public String presentarCategoria(){ //Cambio hecho para PruebaK
		if ("Estudiante".equals(getCategoria())){return "Estudiante";}
		else if ("Colega".equals(getCategoria())){return "Colega";}
		else if ("Familiar".equals(getCategoria())){return "Familiar";}
		else {return "Categoría Desconocida";}}
	
	public void prestar (int ID){
		for (Articulo elemento : articulosRegistrados){
			if (elemento.getIdentificadorObjeto() == ID ){
				prestarInterno (elemento);
				break;}}}
	
	private void prestarInterno (Articulo prestamo){
		prestamo.setPrestado(true);
		//Cambio hecho para PruebaK
//		prestamo.setDiasPrestado(1); 
		prestamos.add(prestamo);}
	
	public void devolver (int ID){
		for (Articulo elemento : articulosRegistrados){
			if (elemento.getIdentificadorObjeto() == ID ){
				devolverInterno (elemento);
				break;}}}
	
	private void devolverInterno (Articulo prestamo){
		prestamo.setPrestado(false);
		prestamo.setDiasPrestado(0);
		prestamos.remove(prestamo);}
	
	public String toString (){
		String msj = "Cliente "+getIdentificadorCliente()+":\n";
		msj += "Cédula: " + getCedula() + "\n";
		msj += "Nombre: " + getNombre()+" "+getApellido1()+" "+getApellido2()+"\n";
		msj += "Teléfono: "+ getTelefono()+"\n";
		msj += "Correo: "+getCorreo()+"\n";
		msj += "Categoria: "+presentarCategoria()+"\n";
		if (prestamos.size() != 0){
			msj += "   Objetos prestados: \n";
			for (Articulo prestado : prestamos) {
				msj += prestado;}}
		return msj;
	}
}

