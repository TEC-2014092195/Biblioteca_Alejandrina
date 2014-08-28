package PruebaMain;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Prueba implements ActionListener{
	
	private JPanel cardHome;
	private JButton btn1;
	
	public Prueba(){
		cardHome = new JPanel();
		cardHome.setLayout(new GridLayout(2,1));
		 
		 
		 JPanel lblP = new JPanel();
		 JLabel lbl = new JLabel("Label primer panel");
		 lblP.add(lbl);
		 cardHome.add(lblP);
		 
		 
		 JPanel btnP = new JPanel();
		 btn1 = new JButton("Next");
		 btn1.addActionListener(this);
		 JButton btn2 = new JButton("Cancel");
		 btnP.add(btn1);   btnP.add(btn2);
		 
		 
		 cardHome.add(btnP);
	}
	
	public Container getContenedor(){
		return cardHome;
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==btn1){
			System.out.println("Funciona el boton "+btn1.getText()+" de la clase Prueba()");
		}
		
	}

}
