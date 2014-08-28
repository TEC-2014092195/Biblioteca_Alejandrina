/**====================================================================================
 * Archivo    : ApiCuenta.java
 * Autor      : Kevin Hern�ndez Rostr�n
 * Carn�      : 2014092195
 * Curso      : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion: Aplicaci�n de estados de cuenta y transacciones
 **==================================================================================== 
 */
package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class AplCuenta {
	static String[] nombres;
    static String[] cedulas;
    static String[] idCuentas;
    static double[] saldos;
    static int numCuentas;
    //Objeto de entraja y salida
    static BufferedReader in;
    static PrintStream out;
    
    public static void main(String[] args) throws IOException {
    	nombres = new String[10];
    	cedulas = new String[10];
    	idCuentas = new String[10];
    	saldos = new double[10];
    	numCuentas = 0;
    	//Crear Objetos de E/S:
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = System.out;
    	boolean salir = false;
    	int opcion;
    	
        
        do {
        	mostrarMenu();
        	opcion = leerOpcion();
        	salir = ejecutarOpcion(opcion); 
            }
        while (!salir); 
    	
    }
    
    static void mostrarMenu(){
    	out.println("1. Registrar Cliente");
    	out.println("2. Abrir Cuenta");
    	out.println("3. Realizar Transacci�n");
    	out.println("4. Consultar Informaci�n");
    	out.println("5. Salir");
    }
    
    static int leerOpcion() throws IOException{
    	int opcion;
    	out.print("Seleccione su opci�n: ");
    	opcion = Integer.parseInt(in.readLine());
    	out.println();
    	return opcion;
    	
    }
    
    static boolean ejecutarOpcion(int opcion) throws IOException {
    	boolean salir = false;
    	int opc = 0;
    	
    	switch(opcion) {
    		case 1: registrarCliente(); break;
    		case 2: abrirCuenta(); break;
    		case 3: opcionTransacciones(); break;
    		case 4: mostrarMenuConsultas(); opc = leerOpcion(); opcionConsultas(opc); break;
    		case 5: salir = true; break;
    		default: out.println("Error: Opci�n no v�lida"); break; }
    	out.println();
    	return salir; 
    	
    }
    
    static void registrarCliente() throws IOException {
    	String nombre = "";
    	String cedula = "";
    	int indice = 0;
    	int buscar = 0;
    	boolean flag = false;
    	String salir = "s";
    	
    	while(salir.charAt(0) =='s'){
    		flag = false;
	    	out.print("Digite n�mero de c�dula: ");
	    	cedula = in.readLine();
	    	out.print("Digite nombre de cliente: ");
	    	nombre = in.readLine();
	    	buscar = buscarCliente(cedula);
	    	
	    	
	    	
	    	if (buscar == -1){
	    		
	    		
	    		for (int i = 0; i < cedulas.length;i++){
	    			if(cedulas[i] == null && flag == false){
	    				flag = true;
	    				indice = i; 
	    			}
	    		}
	    		
	    		cedulas[indice]=cedula;
	    		nombres[indice]=nombre;
	    		
	    		out.println("Cliente registrado");
	    		
	    		
	    	}else{
	    		out.println("Error: cliente ya est� registrado");
	    		
	    	}
	    	out.print("Desea registrar otro cliente (s/n): ");
    		salir = in.readLine();
    	}
    	  
    	
    }
    
    static void abrirCuenta() throws IOException { // pag7 Al abrir una cuenta, debe registrarse el n�mero de cuenta como String, el cual deber� estar compuesto del primer car�cter de la c�dula del cliente m�s el �ndice de la posici�n en el arreglo donde se almacen� el nombre del cliente.
    	String cedula;
    	int indice;
    	double monto = 0;
    	boolean salir = false;
    	
    	do{
    		out.print("Ingrese el n�mero de c�dula del cliente que ser� due�o de la cuenta: ");
    		cedula = in.readLine();
    		out.println();
    		indice = buscarCliente(cedula);
    		
    		if (indice != -1){
    			if (buscarCuenta("" + cedula.charAt(0) + indice) == -1 ) {
    				do{
    					out.print("Ingrese el monto (>= 1000) con el que desea abrir la cuenta: ");
    					monto = Double.parseDouble(in.readLine());
    					out.println();
    				}while (monto < 1000);
    				saldos[indice] = monto;
    				idCuentas[indice] = "" + cedula.charAt(0) + indice;
    				out.println("La cuenta fue abierta correctamente. El n�mero de cuenta es: " + idCuentas[indice]);
    				
    				
    			}else {
    				out.println("Error: El cliente ya tiene una cuenta");
    			}
    			salir = true;
    		}else {
    			out.println("Error: El cliente todav�a no se ha registrado");
    			out.print("Desea ingresar buscar otro cleinte? (s/n)");
    			salir = in.readLine().charAt(0) != 's';
    			out.println();
    		}
    		
    	}while(!salir);
    	
    }
    
    static int buscarCliente(String pCedula) {
    	boolean encontrado = false;
    	int i = 0;
    	int indice = -1;
    	while (!encontrado && i < cedulas.length && cedulas[i] != null){
    		if (cedulas[i].equals(pCedula)){
    			indice = i;
    			encontrado = true;	
    		}
    		i++;
    		
    	}
    	return indice;
    }
    
    static void listarCuentasIds() {
    	int i = 0;
    	while(i < idCuentas.length) {
    		if (idCuentas[i] != null){
    			out.println(idCuentas[i]);
    		}
    		i++;
    	}
    }
    
    static void mostrarMenuTransacciones(){
    	out.println("1. Depositar");
    	out.println("2. Retirar");
    	out.println("3. Ver Saldo");
    	out.println("4. Transferir Fondos");
    	out.println("5. Salir");
    	out.println();
    }
    
    static int verificarCuenta() throws IOException {
    	String numCuenta;
    	int indice = -1;
    	out.print("Ingrese el n�mero de cuenta: ");
    	numCuenta = in.readLine();
    	out.println();
    	indice = buscarCuenta(numCuenta);
    	return indice;
    }
    
    static int buscarCuenta(String pNumero){
    	int indice = -1;
    	int i = 0;
    	while(i < idCuentas.length && indice == -1){
    		if (idCuentas[i] != null && idCuentas[i].equals(pNumero)){
    			indice = i;
    		}
    		i++;
    	}
    	return indice;
    }

    static void  mostrarMenuConsultas(){
    	out.println("1. Ver clientes por c�dula");
    	out.println("2. Ver clientes por nombre");
    	out.println("3. Ver cuentas por n�mero");
    	out.println();
    }
    
    static void opcionConsultas(int pOpcion){
    	switch(pOpcion){
    		case 1: listarInformacion(cedulas);
    			break;
    		case 2: listarInformacion(nombres);
    			break;
    		case 3: listarCuentasIds();
    			break;
    		default: out.println("valor no v�lido");
    			break;
    			
    	}
    }
    
    static void listarInformacion(String[] pLista){
    	int i = 0;
    	while(i < pLista.length && pLista[i] != null){
    		out.println(pLista[i]);
    		i++;
    	}
    }
    
    static boolean ejecutarTransaccion(int pOpcion, int pIndice) throws IOException {
    	boolean seguir = true;
    	
    	switch(pOpcion){
    		case 1: depositar(pIndice); break;
    		case 2: retirar(pIndice); break;
    		case 3: verSaldo(pIndice); break;
    		case 4: transferir(pIndice); break;
    		case 5: seguir = false; break;
    		default : out.println("Error: Opci�n no v�lida"); break;
    		
    	}
    	out.println();
    	return seguir;
    }

    private static void transferir(int pIndice) throws IOException{
    	int indicetrans = 0;
    	double monto = 0;
    	out.println("N�mero de cuenta a transferir");
    	indicetrans = verificarCuenta();
    	if (indicetrans != pIndice && indicetrans != -1){
    		out.print("Ingrese el monto a transferir: ");
        	monto = Double.parseDouble(in.readLine());
        	out.println();
    		if (saldos[pIndice] >= monto){
        		saldos[pIndice] -= monto;
        		saldos[indicetrans] += monto;
        		out.println("El monto que transfiri� fue de: " + monto + " colones, a la cuenta: " + idCuentas[indicetrans] + " colones.");
        	}else{
        		out.println("Error: No cuenta con saldo suficiente. Verifique su saldo de cuenta.");
        	}
    	}else{
    		out.println("Error: Esta es su propia cuenta o la cuenta a la que desea transferir no existe");
    	}
    	
		
	}

	static void  opcionTransacciones() throws IOException{
    	int opc = 0;
    	boolean seguir = true;
    	int indice = verificarCuenta();
    	if (indice != -1){
    		out.println("C�ula: "+ cedulas[indice]);
    		out.println("Cliente: "+ nombres[indice]);
    		out.println();
    		do{
    			mostrarMenuTransacciones();
    			opc = leerOpcion();
    			seguir = ejecutarTransaccion(opc, indice);
    		}while(seguir);
    	}else{
    		out.println("Error: La cuenta no existe");
    	}
    	
    }

    static void depositar(int pIndice) throws IOException{
    	double monto = 0;
    	out.print("Ingrese el monto del dep�sito: ");
    	monto = Double.parseDouble(in.readLine());
    	out.println();
    	saldos[pIndice] += monto;
    	out.println("Su dep�sito fue de " + monto + " colones, el saldo es de " + saldos[pIndice] + " colones.");
    }
    
    static void retirar(int pIndice) throws IOException{
    	double monto = 0;
    	out.print("Ingrese el monto a retirar: ");
    	monto = Double.parseDouble(in.readLine());
    	out.println();
    	if (saldos[pIndice] >= monto){
    		saldos[pIndice] -= monto;
    		out.println("El monto que retir� fue de " + monto + " colones, el saldo es de " + saldos[pIndice] + " colones.");
    	}else{
    		out.println("No cuenta con saldo suficiente. Verifique su saldo de cuenta.");
    	}
    	
    	
    	
    }

    static void verSaldo(int pIndice) throws IOException{
    	out.println("Su saldo es de: " + saldos[pIndice] + " colones.");
    }


}
