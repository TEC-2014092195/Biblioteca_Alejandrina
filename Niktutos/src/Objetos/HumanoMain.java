package Objetos;

public class HumanoMain {
	public static void main(String[] args){
		Humano obj = new Humano(19,155,170,"Kevin");
		
		System.out.println("Edad: "+obj.getEdad());
		System.out.println("Altura: "+obj.getAltura());
		System.out.println("Peso: "+obj.getPeso());
		System.out.println("Nombre: "+obj.getNombre());
		System.out.println("--Cambio de Edad--");
		obj.setEdad(25);
		System.out.println("Edad: "+obj.getEdad());
	}

}
