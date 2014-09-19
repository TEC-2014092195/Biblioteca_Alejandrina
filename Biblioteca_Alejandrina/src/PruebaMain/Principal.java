/**====================================================================================
 * Archivo      : Principal.java » Paquete: PruebaMain » Proyecto: Biblioteca Alejandrina
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Control de préstamo de artículos para una Biblioteca
 **==================================================================================== 
 */

package PruebaMain;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.ClaseIntroduccion;

public class Principal extends JFrame implements ActionListener {
	// ClaseHome Declaracion de variables
	static CardLayout cardlayout;
	static JPanel card = new JPanel();
	static JButton btn1;

	// Fin Declaracion de Variables

	public static void main(String[] args) {
		ClaseIntroduccion vi = new ClaseIntroduccion();
		JFrame frm = new JFrame();
		JPanel contentPane = (JPanel) frm.getContentPane();
		cardlayout = new CardLayout();

		card.setLayout(cardlayout);
		JPanel cardHome = new JPanel();
		cardHome.setLayout(new GridLayout(2, 1));

		JPanel lblP = new JPanel();
		JLabel lbl = new JLabel("Label primer panel");
		lblP.add(lbl);
		cardHome.add(lblP);
		ActionListener AL = new Principal();

		JPanel btnP = new JPanel();
		btn1 = new JButton("Next");

		btn1.addActionListener(AL);
		JButton btn2 = new JButton("Cancel");
		btnP.add(btn1);
		btnP.add(btn2);

		cardHome.add(btnP);

		Prueba prb = new Prueba();

		card.add("Home", prb.getContenedor());

		prb.getContenedor().add(btnP);
		// card.add("Home",cardHome);

		cardlayout.show(card, "Home");
		contentPane.add(card);

		frm.setVisible(true);
		frm.setSize(800, 600);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("Funciona el boton " + btn1.getText()
					+ " de la clase Principal()");
		}

	}

}
