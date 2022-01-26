package vue;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.*;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Closeable;
import java.awt.Color;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Création du lblFond servant de fond pour la fenetre ChoixJoueur
		 */
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 490, 275);
		contentPane.add(lblFond);
		String chemin = "fonds/fondchoix.jpg";
		URL resourceChoix = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resourceChoix));
		
		txtPseudo = new JTextField();
		txtPseudo.setBorder(null);
		txtPseudo.setCaretColor(Color.WHITE);
		txtPseudo.setForeground(Color.BLACK);
		txtPseudo.setBounds(144, 247, 123, 17);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		/**
		 * Création du label flèche gauche. Sert de bouton
		 */
		JLabel lblFlecheGauche = new JLabel("");
		lblFlecheGauche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Fleche de gauche");
			}
		});
		lblFlecheGauche.setBounds(66, 142, 31, 48);
		contentPane.add(lblFlecheGauche);
		
		/**
		 * Création du label flèche droit. Sert de bouton
		 */
		JLabel lblFlecheDroite = new JLabel("");
		lblFlecheDroite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Fleche de droite");
			}
		});
		lblFlecheDroite.setBounds(300, 142, 31, 48);
		contentPane.add(lblFlecheDroite);
		
		/**
		 * Création du label Go. Sert de bouton "Start" une fois le choix de l'utilisateur fait
		 */
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Go");
			}
		});
		lblGo.setBounds(310, 194, 67, 68);
		contentPane.add(lblGo);
		
	}
}
