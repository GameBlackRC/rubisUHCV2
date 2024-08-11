package fr.gameblack.rcuhcv2.scenarios;

import org.bukkit.Material;

public enum Scenarios {
	SKIN("Skin", "Met le skin correspondant au rôle pour chaque joueur", Material.SKULL_ITEM), SON_EN_FOLIE("Sons en folie", "Ajoute tous les sons du pack; ATTENTION : certains sons ne sont pas adapter pour le stream ;pour cause de copyright ou juste de petites insultes; Certains sons peuvent aussi dévo certain rôles lors d'utilisation du pouvoir", Material.JUKEBOX), CUT_CLEAN("Cut clean", "Cuit instantanement les minerais et la nourriture", Material.FURNACE), CATS_EYES("Cat's eyes", "Donne vision nocturne de manière permanente", Material.TORCH), HASTEY_BOYS("Hastey boys", "Les outils sont enchantés avec efficacité III & solidité I au craft", Material.IRON_PICKAXE), RODLESS("Rodless", "La canne à pêche n'est pas obtenable", Material.FISHING_ROD), TIMBERPVP("TimberPVP", "Casse instantanément les arbres lorsque le pvp n'est pas actif", Material.WOOD), BETA_ZOMBIE("Beta Zombie", "Les zombies drop des plumes", Material.FEATHER), COMPO_CACHEE("Compo cachée", "Aucun joueur ne pourras connaître la compo", Material.PAPER), START_AUTO("Start automatique", "Permet de démarrer automatiquement la partie lorsque la partie se fini\nsi elle est en mode rapide", Material.REDSTONE_BLOCK), INTROUVABLE("Introuvable", "Donne le rôle Team à tous les joueurs de la partie\net ne donne pas d'armure", Material.GLASS), NOLAVA("No Lava", "Les seaux de lave deviennent innutilisables", Material.LAVA_BUCKET), DEBUG("Debug", "Debug", Material.COMMAND);
	
	private String nom;
	private String desc;
	private Material item;
	
	Scenarios(String nom, String desc, Material item) {
		
		this.nom = nom;
		this.desc = desc;
		this.item = item;
		
	}
	
	public String getNom() {
		
		return nom;
		
	}
	
	public String getDescription() {
		
		return desc;
		
	}
	
	public Material getItem() {
		
		return item;
		
	}
	
}
