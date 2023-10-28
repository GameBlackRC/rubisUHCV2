package fr.gameblack.rcuhcv2;

public enum Roles {
	
	TEAM("staff", 1, "Team"), GAMEBLACK("staff", 1, "GameBlack"), MAKA("staff", 1, "Maka"), TRIAL("staff", 1, "Trial"), LOUP("staff", 1, "Loup"), CAPTAIN("staff", 1, "Captain"), HEKOW("staff", 1, "Hekow"), RAPTOR("joueur", 1, "Raptor"), JEANNOT("joueur", 1, "Jeannot"), SLUP("joueur", 1, "Slup"), NICKOBOOP("joueur", 1, "Nickoboop"), JOKO("joueur", 1, "Joko"), MALIVOL("uhc", 1, "Malivol"), TOINOU("uhc", 1, "Toinou"), OBSCUR("uhc", 1, "Obscur"), NONOBOY("uhc", 1, "Nonoboy"), FARMEURIMMO("farmeurimmo", 1, "Farmeurimmo"), KZOU("solo", 1, "Kzou"), TEST("solo", 1, "Test"), NONE("null", 0, "Null");
	
	private final String camp;
	
	private final int statut;
	
	private final String txt;
	
	Roles(String camp, int statut, String txt) {
		
		this.camp = camp;
		this.statut = statut;
		this.txt = txt;
		
	}
	
	public String getCamp() {
		
		return camp;
		
	}
	
	public int getStatut() {
		
		return statut;
		
	}

	public String getTxt() {
		return txt;
	}

}
