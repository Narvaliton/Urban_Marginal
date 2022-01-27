package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import outils.connexion.*;
/**
 * Gestion du jeu côté serveur
 *
 */
public class JeuServeur extends Jeu {

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	/**
	 * Collection de joueurs
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>() ;
	
	/**
	 * Constructeur
	 */
	public JeuServeur(Controle unControle) {
		this.controle = unControle;
	}
	
	@Override
	public void connexion(Connection connection) {
		lesJoueurs.put(connection, new Joueur());
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] information = ((String)info).split("~");
		switch (information[0]) {
			case "pseudo":
				lesJoueurs.get(connection).initPerso(information[1],Integer.parseInt(information[2]));
		}
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers tous les clients
	 * fais appel plusieurs fois à l'envoi de la classe Jeu
	 */
	public void envoi() {
	}

	/**
	 * Génération des murs
	 */
	public void constructionMurs() {
	}
	
}
