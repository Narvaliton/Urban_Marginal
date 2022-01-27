package controleur;

import vue.*;
import modele.*;
import outils.connexion.*;
/**
 * Contrôleur et point d'entrée de l'applicaton 
 * @author emds
 *
 */
public class Controle implements AsyncResponse{

	private EntreeJeu frmEntreeJeu ;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private final int PORT = 6666;
	private Jeu leJeu;
	/**
	 * Méthode de démarrage
	 * @param args non utilisé
	 */
	
	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Constructeur
	 */
	private Controle() {
		
		this.frmEntreeJeu = new EntreeJeu(this) ;
		this.frmEntreeJeu.setVisible(true);
	}

	public void evenementEntreeJeu (String info) {
		if(info == "serveur") {
			ServeurSocket serveur = new ServeurSocket(this, PORT);
			this.leJeu = new JeuServeur(this);
			frmEntreeJeu.setVisible(false);
			this.frmArene = new Arene(this);
			this.frmArene.setVisible(true);
		}
		else {
			ClientSocket client = new ClientSocket(this, info, PORT);
		}
	}

	public void evenementChoixJoueur(String pseudo, int numPersonnage) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
		((JeuClient)this.leJeu).envoi("pseudo" + "~" + pseudo + "~" + numPersonnage);;
	}
	
	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch(ordre) {
			case "connexion":
				if(!(leJeu instanceof JeuServeur)) {
					this.leJeu = new JeuClient(this);
					this.leJeu.connexion(connection);
					frmEntreeJeu.setVisible(false);
					this.frmChoixJoueur = new ChoixJoueur(this);
					this.frmChoixJoueur.setVisible(true);
					this.frmArene = new Arene(this);
				}
				else {
					this.leJeu.connexion(connection);
				}
				break;
			case "réception":
				leJeu.reception(connection, info);
				break;
			case "déconnexion":
				break;
		}
		
	}
	
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}
}
