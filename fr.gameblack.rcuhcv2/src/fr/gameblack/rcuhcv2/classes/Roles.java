package fr.gameblack.rcuhcv2.classes;

public enum Roles {
	//V2
	TEAM("staff", "Team", "Team_Machine_RC"), GAMEBLACK("staff", "GameBlack", "GameBlack_RC"), MAKA("staff", "Maka", "maka_dragon"), TRIAL("staff", "Trial", "Trial_gun"), LOUP("staff", "Loup", "Loup88"), CAPTAIN("staff", "Captain", null), HEKOW("staff", "Hekow", "Hekow_"), RAPTOR("joueur", "Raptor", "Raptor_delta56"), JEANNOT("joueur", "Jeannot", null), SLUP("joueur", "Slup", "SLUP_Slimecruzz"), NICKOBOOP("joueur", "Nickoboop", null), JOKO("joueur", "Joko", "jokoYT"), MALIVOL("uhc", "Malivol", "Malivol1"), TOINOU("uhc", "Toinou", "toinou1108"), OBSCUR("uhc", "Obscur", "Obscur_ars0"), NONOBOY("uhc", "Nonoboy", "NonoboyV2"), THEOOCHOUX("uhc", "Theoochoux", "theoochoux"), FARMEURIMMO("farmeurimmo", "Farmeurimmo", "Farmeurimmo"), KZOU("solo", "Kzou", "Kzou_"), TEST("solo", "Test", null), 
	//V1
	GameBlack("rc", "GameBlack", null), Team("rc", "Team", null), Maka("rc", "Maka", null), Loup("rc", "Loup", null), Raptor("rc", "Raptor", null), Joko("rc", "Joko", null), Guerrier("rc", "Guerrier", null), Archer("rc", "Archer", null), Eclaireur("rc", "Eclaireur", null), Trial("demon", "Trial", null), Slup("demon", "Slup", null), Farmeurimmo("solo", "Farmeurimmo", null), Tenebre("demon", "Démon ténèbre", null), Sang("demon", "Démon sang", null), Cosmos("demon", "Démon cosmos", null), Enfer("demon", "Démon enfer", null), Malediction("demon", "Démon malédiction", null), Electrique("demon", "Démon électrique", null), Ange("demon", "Démon ange", null), Avenir("demon", "Démon avenir", null), Demon("demon", "Démon", null), Toinou("rc", "Toinou", null), Kzou("solo", "Kzou", null), Malivol("demon", "Malivol", null), Experimental("solo", "Démon expérimental", null), Tronconeuse("demon", "Démon tronçoneuse", null), Obscur("demon", "Obscur", null), Pantin("demon", "Pantin", null), 
	NONE("null", "Null", null);
	
	private final String camp;
	
	private final String txt;
	
	private final String skin;
	
	private
	
	Roles(String camp, String txt, String skin) {
		
		this.camp = camp;
		this.txt = txt;
		this.skin = skin;
		
	}
	
	public String getCamp() {
		
		return camp;
		
	}

	public String getTxt() {
		return txt;
	}
	
	public String getSkin() {
		return skin;
	}

}
