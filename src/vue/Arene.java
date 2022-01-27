package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.net.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import controleur.Controle;
import controleur.Global;

public class Arene extends JFrame implements Global{

	private JPanel contentPane;
	private JTextField textField;
	private Controle controle;
	/**
	 * Create the frame.
	 */
	public Arene(Controle unControle) {
		this.controle = unControle;
		this.getContentPane().setPreferredSize(new Dimension(803, 802));
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Création et application d'une image au label lblFond représentant l'arene
		 */
		URL resource = getClass().getClassLoader().getResource(FONDARENE);
		contentPane.setLayout(null);
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 803, 627);
		lblFond.setIcon(new ImageIcon(resource));
		contentPane.add(lblFond);
		
		/**
		 * Champ de texte du chat
		 */
		textField = new JTextField();
		textField.setBounds(0, 613, 803, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/**
		 * Zone de texte affichant les messages du chat
		 */
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setBounds(0, 635, 803, 155);
		contentPane.add(textArea);
		
		/**
		 * Scroll bar pour naviguer dans la zone de texte du chat
		 */
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(786, 634, 17, 156);
		contentPane.add(scrollBar);
	}
}
