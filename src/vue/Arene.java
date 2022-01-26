package vue;

import java.awt.BorderLayout;
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
public class Arene extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Arene() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Cr�ation et application d'une image au label lblFond repr�sentant l'arene
		 */
		String chemin = "fonds/fondarene.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
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