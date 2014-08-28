/**====================================================================================
 * Archivo    : asdaf.java » Paquete: PruebaReloj » Proyecto: Biblioteca_Alejandrina
 * Autor      : Kevin Hernández Rostrán
 * Carné      : 2014092195
 * Curso      : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion:
 **==================================================================================== 
 */

package PruebaReloj;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Monillo007
 * :: Visita http://monillo007.blogspot.com ::
 */
public class Reloj extends javax.swing.JFrame implements Runnable {

    String hora, minutos, segundos, ampm; //Creo los strings que se van a presentar en pantalla. 
    Calendar calendario; 				  //De tipo calendario, viene de la librería importada
    Thread h1;							  //Los hilos hacen que la aplicacion tenga este proceso en segundo plano. 

    public Reloj() {
        initComponents();				  //Esto llama a los labels y elementos a mostrar
        h1 = new Thread(this);			  //Comienzo el hilo
        h1.start();
        setLocationRelativeTo(null);	  //Centra la ventana en la pantalla.
        setVisible(true);}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    
    private void initComponents() {
        lbHora = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	//Se cierra con la x. A la ventana debe definirsele
        setTitle("Reloj");														//El titulo de la ventana
        lbHora.setFont(new java.awt.Font("Arial", 1, 55));						//El tipo de letra, tamaño, etc
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);		//Ubico el label en el centro de la ventana
        lbHora.setText("jLabel1");												//--------------------------------------------//

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }
    
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);} 
            catch (InterruptedException e) {}}}
    
    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;} 
        else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);}
        	minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        	segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);}
    
    public static void main(String[] args) {
        new Reloj();}
}