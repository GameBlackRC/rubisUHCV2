package fr.gameblack.rcuhcv2.scenarios.v2;

import org.bukkit.Bukkit;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class Skin {

	public static void setSkin(Main main) {
		
		for(Joueur j : main.getJoueurInGame()) {
			
			if(j.getRole().getSkin() != null) {
				
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "skin set " + j.getRole().getSkin() + " " + j.getPlayer().getName());
				
			}
			
		}
		
	}
	
}
