package fr.gameblack.rubisuhc.roles.rc;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;

public class Team {

	public static void Items(Player player, Main main) {
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));
		
		Random r = new Random();
		int nb = r.nextInt(2);
		if(nb == 1) {
			
			main.setConnaissanceTeam(Roles.GAMEBLACK);
			
		}
		else {
			
			main.setConnaissanceTeam(Roles.MAKA);
			
		}
		Texte(player, nb);
		
	}
	
	public static void Texte(Player player, int nb) {
		
		String connaissance;
		
		if(nb == 1) {
			
			connaissance = "GameBlack";
			
		}
		else {
			
			connaissance = "Maka";
			
		}
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aTeam\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet résistance I permanent\n \nA chaque mort d'un joueur de votre camps, vous recevez le rôle ou le pseudo du joueur l'ayant tuer\n \nVous connaissez " + connaissance + "\n \n____________________________________________________");
		
	}
	
}
