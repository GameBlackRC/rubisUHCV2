package fr.gameblack.rcuhcv2.classes;

public enum Camps {
	STAFF("§9"), UHC("§2"), JOUEUR("§a"), FARMEURIMMO("§c"), DUO("§5"), SOLOS("§6"),
	RC("§a"), DEMON("§c"),
	NULL("");
	
	private String couleur;
	
	Camps(String couleur) {
		
		this.couleur = couleur;
		
	}

	public String getCouleur() {
		return couleur;
	}
	
}
