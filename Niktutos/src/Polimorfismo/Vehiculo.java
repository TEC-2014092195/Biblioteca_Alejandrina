package Polimorfismo;

public class Vehiculo {
	
	private String color;
	private int ruedas;
	private int puertas;
	
	
	public Vehiculo(String color, int ruedas, int puertas){
		this.color = color;
		this.ruedas = ruedas;
		this.puertas = puertas;
	}
	
	public Vehiculo(){
		this.color = "Verde";
		this.ruedas = 2;
		this.puertas = 100;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public int getRuedas(){
		return this.ruedas;
	}
	
	public int getPuertas(){
		return this.puertas;
	}

}
