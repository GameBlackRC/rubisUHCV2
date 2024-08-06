package fr.gameblack.rcuhcv2.scenarios.v2;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Introuvable {

	public static void setIntrouvable(Main main) {
		
		for(Joueur j : main.getListJoueurs()) {
			
			j.setRole(Roles.TEAM, main);
			j.setOrbe(Orbe.FOUDRE);
			j.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
			j.addSpeed(0.2);
			
		}
		
	}
	
	public static void reveal(Main main) {
		
		List<Joueur> js = new ArrayList<>();
		
		for(Joueur j : main.getJoueurInGame()) {
			
			j.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
			js.add(j);
			
		}
		
		ItemCD cycle = new ItemCD(main, null, "fun_invi", 10, null, null, js, 0, null);
	    cycle.runTaskTimer(main, 0, 1);
		
	}
	
}
