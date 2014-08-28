
public class Vectores {
	
	public static void main(String[] args){
		int a[] = new int[5]; //Crea cinco elemento
		
		a[0]=34;
		for(int i = 0; i < a.length ;i++){
			System.out.println("a["+i+"]="+a[i]);
		}
		
		if(!(a[0]==0)){
			System.out.println("0 ya tiene");
		}
	}

}
