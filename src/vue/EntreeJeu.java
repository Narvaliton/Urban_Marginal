package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIpServer;

	/**
	 * Create the frame.
	 */
	public EntreeJeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Créations des labels à caractère informatif
		 */
		JLabel lblServer = new JLabel("Start a server :");
		lblServer.setBounds(10, 11, 86, 14);
		contentPane.add(lblServer);
		JLabel lblNewLabel_1 = new JLabel("Connect an existing server :");
		lblNewLabel_1.setBounds(10, 36, 172, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("IP Server :");
		lblNewLabel_2.setBounds(10, 61, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		/**
		 * Création de txtIpServer permettant de rentrer l'IP Serveur
		 */
		txtIpServer = new JTextField();
		txtIpServer.setText("127.0.0.1");
		txtIpServer.setBounds(71, 58, 116, 20);
		contentPane.add(txtIpServer);
		txtIpServer.setColumns(10);
		
		/**
		 * Création du bouton Start
		 */
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start();
			}
		});
		btnStart.setBounds(212, 7, 89, 23);
		contentPane.add(btnStart);
		
		/**
		 * Création du bouton Connect
		 */
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixJoueur();
			}
		});
		btnConnect.setBounds(212, 57, 89, 23);
		contentPane.add(btnConnect);
		
		/**
		 * Création du bouton Exit
		 */
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(212, 91, 89, 23);
		contentPane.add(btnExit);
	}
	
	/**
	 * Méthode ouvrant la fenetre Arene
	 */
	public void Start() {
		Arene frmArene = new Arene();
		frmArene.setVisible(true);
	}
	
	/**
	 * Methode ouvrant la fenetre ChoixJoueur
	 */
	public void ChoixJoueur() {
		ChoixJoueur frmChoixJoueur = new ChoixJoueur();
		frmChoixJoueur.setVisible(true);
	}
}

