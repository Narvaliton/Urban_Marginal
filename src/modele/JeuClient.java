package modele;
import controleur.Controle;
import outils.connexion.*;
/**
 * Gestion du jeu côté client
 *
 */
public class JeuClient extends Jeu {
	private Connection connection;
	/**
	 * Controleur
	 */
	public JeuClient(Controle unControle) {
		this.controle = unControle;
	}
	
	@Override
	public void connexion(Connection UneConnection) {
		this.connection = UneConnection;
	}

	@Override
	public void reception(Connection connection, Object info) {
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers le serveur
	 * fais appel une fois à l'envoi dans la classe Jeu
	 */
	public void envoi(String info) {
		super.envoi(this.connection, info);
	}

}
