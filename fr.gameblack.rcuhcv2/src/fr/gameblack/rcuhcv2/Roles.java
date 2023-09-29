package fr.gameblack.rcuhcv2;

public enum Roles {
	
	TEAM("staff", 1), GAMEBLACK("staff", 1), MAKA("staff", 1), TRIAL("staff", 1), LOUP("staff", 1), CAPTAIN("staff", 1), HEKOW("staff", 1), RAPTOR("joueur", 1), JEANNOT("joueur", 1), SLUP("joueur", 1), NICKOBOOP("joueur", 1), JOKO("joueur", 1), MALIVOL("uhc", 1), TOINOU("uhc", 1), OBSCUR("uhc", 1), NONOBOY("uhc", 1), FARMEURIMMO("solo", 1), KZOU("solo", 1), TEST("solo", 1), NONE("null", 0);
	
	private final String camp;
	
	private final int statut;
	
	Roles(String camp, int statut) {
		
		this.camp = camp;
		this.statut = statut;
		
	}
	
	public String getCamp() {
		
		return camp;
		
	}
	
	public int getStatut() {
		
		return statut;
		
	}

}
