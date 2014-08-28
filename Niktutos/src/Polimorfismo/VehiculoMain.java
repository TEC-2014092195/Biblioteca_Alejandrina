package Polimorfismo;


public class VehiculoMain {
	
	public static void main(String[] args){
		Vehiculo v = new Vehiculo("Azul",8,8);
		Vehiculo v2 = new Vehiculo();
		
		System.out.println("Constructor v (con parametros)\n");
		System.out.println("Color: "+v.getColor());
		System.out.println("Ruedas: "+v.getRuedas());
		System.out.println("Puertas: "+v.getPuertas());
		System.out.println("\nConstructor v2 (sin parametros)\n");
		System.out.println("Color: "+v2.getColor());
		System.out.println("Ruedas: "+v2.getRuedas());
		System.out.println("Puertas: "+v2.getPuertas());
	}

}
