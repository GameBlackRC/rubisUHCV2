package fr.gameblack.rcuhcv2.classes;

public enum Roles {
	//V2
	YURI(Camps.STAFF, "Yuri", ""), TEAM(Camps.STAFF, "Team", "Team_Machine_RC"), GAMEBLACK(Camps.STAFF, "GameBlack", "GameBlack_RC"), MAKA(Camps.STAFF, "Maka", "maka_dragon"), TRIAL(Camps.STAFF, "Trial", "Trial_gun"), LOUP(Camps.STAFF, "Loup", "Loup88"), CAPTAIN(Camps.STAFF, "Captain", null), HEKOW(Camps.STAFF, "Hekow", "Hekow_"), RAPTOR(Camps.JOUEUR, "Raptor", "Raptor_delta56"), JEANNOT(Camps.JOUEUR, "Jeannot", null), SLUP(Camps.JOUEUR, "Slup", "SLUP_Slimecruzz"), NICKOBOOP(Camps.JOUEUR, "Nickoboop", null), JOKO(Camps.JOUEUR, "Joko", "jokoYT"), MALIVOL(Camps.UHC, "Malivol", "Malivol1"), TOINOU(Camps.UHC, "Toinou", "toinou1108"), OBSCUR(Camps.UHC, "Obscur", "Obscur_ars0"), NONOBOY(Camps.UHC, "Nonoboy", "NonoboyV2"), THEOOCHOUX(Camps.UHC, "Theoochoux", "theoochoux"), ROMPREMS(Camps.UHC, "RomPrems", "RomPrems"),FARMEURIMMO(Camps.FARMEURIMMO, "Farmeurimmo", "Farmeurimmo"), KZOU(Camps.SOLOS, "Kzou", "Kzou_"), TEST(Camps.SOLOS, "Test", null), 
	//V1
	GameBlack(Camps.RC, "GameBlack", null), Team(Camps.RC, "Team", null), Maka(Camps.RC, "Maka", null), Loup(Camps.RC, "Loup", null), Raptor(Camps.RC, "Raptor", null), Joko(Camps.RC, "Joko", null), Guerrier(Camps.RC, "Guerrier", null), Archer(Camps.RC, "Archer", null), Eclaireur(Camps.RC, "Eclaireur", null), Trial(Camps.DEMON, "Trial", null), Slup(Camps.DEMON, "Slup", null), Farmeurimmo(Camps.SOLOS, "Farmeurimmo", null), Tenebre(Camps.DEMON, "Démon ténèbre", null), Sang(Camps.DEMON, "Démon sang", null), Cosmos(Camps.DEMON, "Démon cosmos", null), Enfer(Camps.DEMON, "Démon enfer", null), Malediction(Camps.DEMON, "Démon malédiction", null), Electrique(Camps.DEMON, "Démon électrique", null), Ange(Camps.DEMON, "Démon ange", null), Avenir(Camps.DEMON, "Démon avenir", null), Demon(Camps.DEMON, "Démon", null), Toinou(Camps.RC, "Toinou", null), Kzou(Camps.SOLOS, "Kzou", null), Malivol(Camps.DEMON, "Malivol", null), Experimental(Camps.SOLOS, "Démon expérimental", null), Tronconeuse(Camps.DEMON, "Démon tronçoneuse", null), Obscur(Camps.DEMON, "Obscur", null), Pantin(Camps.DEMON, "Pantin", null), 
	NONE(Camps.NULL, "Null", null);
	
	private final Camps camp;
	
	private final String txt;
	
	private final String skin;
	
	Roles(Camps camp, String txt, String skin) {
		
		this.camp = camp;
		this.txt = txt;
		this.skin = skin;
		
	}
	
	public Camps getCamp() {
		
		return camp;
		
	}

	public String getTxt() {
		return txt;
	}
	
	public String getSkin() {
		return skin;
	}

}
