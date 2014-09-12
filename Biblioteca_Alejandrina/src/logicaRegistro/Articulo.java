package logicaRegistro;


public class Articulo extends Registro {
	/*
	 * Esta clase se encarga de la creación de objetos en memoria para 
	 * préstamos en la biblioteca. 
	 * Cada objeto necesita un identificador para entender cual objeto está tratando
	 * y poder trabajar a futuro cada selección de objetos por separado. 
	 */
	
	//Constructor para objetos nuevos. 
	public Articulo( String nTipo,
			   				String nTitulo,
			   				String nAutor,
			   				String nDato1,
			   				String nDato2,
			   				String nDirImg,
			   				String nCalif) 
			   				
	{	cantObjetos++;
		setIdentificadorObjeto(cantObjetos);
		setTipo(nTipo);
		setTitulo(nTitulo);
		setAutor(nAutor);
		setDato1(nDato1);
		setDato2(nDato2);
		setDirImg(nDirImg);
		setCalif (nCalif);	
		setPrestado(false);	
		setDiasPrestado(1);		}
	
	//Constructor para reestablecer el sistema, recibe el dato de si el objeto
	//ya fue prestado o no, y si lo fué, cuántos días lleva prestado. 
	public Articulo( String nTipo,
				String nTitulo,
				String nAutor,
				String nDato1,
				String nDato2,
				String nDirImg,
				String nCalif,
				boolean nPrestado,
				int DiasPrestado) 
				
	{	cantObjetos++;
		setIdentificadorObjeto(cantObjetos);
		setTipo(nTipo);
		setTitulo(nTitulo);
		setAutor(nAutor);
		setDato1(nDato1);
		setDato2(nDato2);
		setDirImg(nDirImg);
		setCalif (nCalif);	
		setPrestado(nPrestado);	
		setDiasPrestado(DiasPrestado);		}
	
	
	//Getters y Setters-----------------------------------------------------------//
	public static int getCantObjetos() {return cantObjetos;}
	public int getIdentificadorObjeto() {return identificadorObjeto;}
	public void setIdentificadorObjeto(int identificadorObjeto) {this.identificadorObjeto = identificadorObjeto;}
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getDato1() {return dato1;}
	public void setDato1(String dato1) {this.dato1 = dato1;}
	public String getDato2() {return dato2;}
	public void setDato2(String dato2) {this.dato2 = dato2;}
	public String getDirImg() {return dirImg;}
	public void setDirImg(String dirImg) {this.dirImg = dirImg;}
	public String getCalif() {return calif;}
	public void setCalif(String calif) {this.calif = calif;}
	public boolean isPrestado() {return prestado;}
	public void setPrestado(boolean prestado) {this.prestado = prestado;}
	public int getDiasPrestado() {return diasPrestado;}
	public void setDiasPrestado(int diasPrestado) {this.diasPrestado = diasPrestado;}
	//------------------------------------------------------------------------------//
	
	public String toString (){
		String msj = "    Objeto "+getIdentificadorObjeto()+":\n";
		msj += "\tTipo: " + getTipo()+"\n";
		msj += "\tTitulo: "+getTitulo()+"\n";
		msj += "\tAutor: "+getAutor()+"\n";
		msj += "\tDATO 1: "+ getDato1()+"\n";
		msj += "\tDATO 2: "+ getDato2()+"\n";
		msj += "\tCalificacion: "+getCalif()+"\n";
		return msj;
	}
}
