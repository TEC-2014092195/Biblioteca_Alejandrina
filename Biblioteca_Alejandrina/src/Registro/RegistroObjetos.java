

package Registro;

public class RegistroObjetos extends Registro {
	/*
	 * Esta clase se encarga de la creación de objetos en memoria para 
	 * préstamos en la biblioteca. 
	 * Cada objeto necesita un identificador para entender cual objeto está tratando
	 * y poder trabajar a futuro cada selección de objetos por separado. 
	 */
	
	private static int cantObjetos = 0;
	private int identificadorObjeto = 0;
	private String tipo = null;
	private String titulo = null;
	private String autor = null;
	private String dato1 = null;
	private String dato2 = null;
	private String dirImg = null;
	private String calif = null;
	
	//Constructor para objetos
	public RegistroObjetos( String nTipo,
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
		setCalif (nCalif);	}
	
	
	//Getters y Setters
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
	//------------------------------------------------------------------------------//
	
	public String toString (){
		String msj = "Cliente "+getIdentificadorObjeto()+":\n";
		msj += "Tipo: " + getTipo()+"\n";
		msj += "Titulo: "+getTitulo()+"\n";
		msj += "Autor: "+getAutor()+"\n";
		msj += "DATO 1: "+ getDato1()+"\n";
		msj += "DATO 2: "+ getDato2()+"\n";
		msj += "Calificacion: "+getCalif()+"\n";
		return msj;
	}
}

