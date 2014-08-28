import java.util.*;

public class Input {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String entrada = s.nextLine();
		int num = Integer.parseInt(entrada);
		System.out.println("Usted ingreso: "+num);
		s.close(); 
	}

}
