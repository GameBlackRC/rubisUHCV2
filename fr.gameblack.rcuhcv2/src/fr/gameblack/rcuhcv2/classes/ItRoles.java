package fr.gameblack.rcuhcv2.classes;

public enum ItRoles {
	YURI_AZIZ("Aziz"), JOKO_SPEEDCUBING("SpeedCubing"), RAPTOR_RAGE("Rage"), SLUP_PACTES("Pactes"), SLUP_SLIME("Slimetification"), GAMEBLACK_FUITE("Fuite"), HEKOW_JEU("Jeu meurtrier"), LOUP_BATEAU("Super bateau"), TEAM_JUSTICE("Justice"), TRIAL_COLA("Breizh cola"), TRIAL_BENIHIME("Benihime Aratame"), TRIAL_SAKASHIMA("Sakashima Yokoshima"),MALIVOL_CHEAT("Cheat"), OBSCUR_ADAPTION("Adaption"), THEOCHOUX_ROLLBACK("RollBack"), ROMPREMS_PEARL("§9Pearl"), ROMPREMS_EYE("§cPearl"),TOINOU_LIVRE("Livre des morts"), TOINOU_TOTEM("Totem");
	
	private String nom;
	
	ItRoles(String nom) {
		
		this.setNom(nom);
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
