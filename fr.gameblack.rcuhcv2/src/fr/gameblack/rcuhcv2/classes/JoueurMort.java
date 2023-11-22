package fr.gameblack.rcuhcv2.classes;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.orbes.Orbe;

public class JoueurMort {
	
	private String pseudo;
	private String pseudoCouleur;
	private Roles role;
	private String tueur;
	private Roles roleTueur;
	private String roletxt;
	private String camp;
	private int kill;
	private Orbe orbe;
	
	public JoueurMort(Joueur joueur, Joueur tueur, Main main) {
		
		setPseudo(joueur.getPlayer().getName());
		setRole(joueur.getRole());
		this.setTueur(tueur.getPlayer().getName());
		setRoletxt(joueur.getCouleurCamp(main) + role.getTxt());
		setCamp(joueur.getCamp());
		setKill(joueur.getKill());
		pseudoCouleur = joueur.getCouleurCamp(main) + pseudo;
		this.orbe = joueur.getOrbe();
		roleTueur = tueur.getRole();
		
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getTueur() {
		return tueur;
	}

	public void setTueur(String tueur) {
		this.tueur = tueur;
	}

	public String getRoletxt() {
		return roletxt;
	}

	public void setRoletxt(String roletxt) {
		this.roletxt = roletxt;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}

	public Roles getRoleTueur() {
		return roleTueur;
	}

	public void setRoleTueur(Roles roleTueur) {
		this.roleTueur = roleTueur;
	}

	public String getPseudoCouleur() {
		return pseudoCouleur;
	}

	public void setPseudoCouleur(String pseudoCouleur) {
		this.pseudoCouleur = pseudoCouleur;
	}

	public Orbe getOrbe() {
		return orbe;
	}

	public void setOrbe(Orbe orbe) {
		this.orbe = orbe;
	}

}
