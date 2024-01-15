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
	private Camps camp;
	private int kill;
	private Orbe orbe;
	private String modeTrial = null;
	
	public JoueurMort(Joueur joueur, Joueur tueur, Main main) {
		
		setPseudo(joueur.getPlayer().getName());
		setRole(joueur.getRole());
		this.setTueur(tueur.getPlayer().getName());
		setRoletxt(joueur.getCamp().getCouleur() + role.getTxt());
		setCamp(joueur.getCamp());
		setKill(joueur.getKill());
		pseudoCouleur = joueur.getCamp().getCouleur() + pseudo;
		this.orbe = joueur.getOrbe();
		roleTueur = tueur.getRole();
		modeTrial = joueur.getModeTrial();
		
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

	public Camps getCamp() {
		return camp;
	}

	public void setCamp(Camps camp) {
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

	public String getModeTrial() {
		return modeTrial;
	}

	public void setModeTrial(String modeTrial) {
		this.modeTrial = modeTrial;
	}

}
