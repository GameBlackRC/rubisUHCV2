package fr.gameblack.rcuhcv2.roles.staff;

import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class Maka {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
		
	}
	
	public static void FormeSimp(Joueur joueur, Main main) {
		
		joueur.setForme("simp");
		
		Random r = new Random();
		
		List<Joueur> campStaff = main.getCampStaff();
		
        int nb = r.nextInt(campStaff.size());
		
		main.setNeko(campStaff.get(nb));
		
		main.setNbJoueursStaff(campStaff.size()-1);
		
		joueur.getPlayer().sendMessage("Voici le pseudo de Neko : " + main.getNeko().getPlayer().getName());
		
		main.getNeko().getPlayer().sendMessage("Maka vient de passer dans sa forme simp, vous êtes Neko");       
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Maka\n§rVous devez gagner avec le §9camp staff§r\n \n____________________________________________________");

    }

}
