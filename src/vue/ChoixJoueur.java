package vue;
import controleur.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.net.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Closeable;
import java.awt.Color;
import controleur.Controle;
public class ChoixJoueur extends JFrame implements Global{

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblPersonnage;
	private Controle controle;
	private int numPersonnage;
	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle unControle) {
		this.controle = unControle;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Création d'un label affichant le choix du Personnage
		 */
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(179, 142, 46, 61);
		contentPane.add(lblPersonnage);
		
		/**
		 * Création du lblFond servant de fond pour la fenetre ChoixJoueur
		 */
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 490, 275);
		contentPane.add(lblFond);
		URL resourceChoix = getClass().getClassLoader().getResource(FONDCHOIX);
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
				if(numPersonnage == 1) {
					numPersonnage = 3;
				}
				else {
					numPersonnage--;
				}
				affichePerso();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
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
				if(numPersonnage == 3) {
					numPersonnage = 1;
				}
				else {
					numPersonnage++;
				}
				affichePerso();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
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
				if(!txtPseudo.getText().equals("")) {
					controle.evenementChoixJoueur(txtPseudo.getText(), numPersonnage);
				}
				else{
					JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblGo.setBounds(310, 194, 67, 68);
		contentPane.add(lblGo);		
		
		this.numPersonnage = 1;
		affichePerso();
	}
	
	/**
	 * Methode Affichant le personnage séléctionné
	 */
	private void affichePerso() {
		String nomFichier = IMAGEPERSONNAGE + numPersonnage + "marche" + 1 + "d" + 1 +".gif";
		URL resourcePerso = getClass().getClassLoader().getResource(nomFichier);
		lblPersonnage.setIcon(new ImageIcon(resourcePerso));
	}
	
	/**
	 * Change le curseur en souris normale
	 */
	private void sourisNormale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	/**
	 * Change le curseur en image de doigt
	 */
	private void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void commencer() {
		
	}
}
