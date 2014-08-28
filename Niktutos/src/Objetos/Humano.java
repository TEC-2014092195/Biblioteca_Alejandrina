package Objetos;

public class Humano{
	private int edad1;
	private int peso1;
	private int altura1;
	private String nombre1;
	
	public Humano(int edad, int peso, int altura, String nombre){
		this.edad1 = edad;
		this.peso1 = peso;
		this.altura1 = altura;
		this.nombre1 = nombre;
	}
	
	public void setEdad(int edad){
		this.edad1 = edad;
		
	}
	
	public int getEdad(){
		return this.edad1;
	}
	
	public int getPeso(){
		return this.peso1;
	}
	
	public int getAltura(){
		return this.altura1;
	}
	
	public String getNombre(){
		return this.nombre1;
	}
	
}
