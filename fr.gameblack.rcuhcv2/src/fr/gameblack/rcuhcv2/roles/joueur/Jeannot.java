package fr.gameblack.rcuhcv2.roles.joueur;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class Jeannot {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aJeannot\n§rVous devez gagner avec le §acamp joueur§r\n \nVous avez 3% de force permanent\n \nAvec la commande /rcpartage, vous pouvez activer votre mode partage. Lorsque le mode partage est actif, vous ne recevez plus d'absorption de vos pommes d'or mais tout vos alliés dans un rayon de 20 blocs en recoivent s'il n'en avais pas. Si Nickoboop avait déjà de l'absorption alors il monte jusqu'à 4 coeurs d'absorption\n \nVous connaissez Nickoboop\n \n____________________________________________________");

    }
	
	public static void checkProcheNickoboop(Joueur joueur, Main main) {
		
		if(joueur.isProche(Roles.NICKOBOOP, main) && !joueur.isNickoProcheJeannot()) {
			
			joueur.addForce(0.02);
			joueur.setNickoProcheJeannot(true);
			
		}
		else if (!joueur.isProche(Roles.NICKOBOOP, main) && joueur.isNickoProcheJeannot()){
			
			joueur.removeForce(0.02);
			joueur.setNickoProcheJeannot(false);
			
		}
		
	}
	
	public static void PartageAbso(Joueur joueur, Main main) {
		
		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
		List<Joueur> allies = main.getJoueurInCamp("joueur");
		for(Joueur allie : allies) {
			
			if(allie.getRole() == Roles.NICKOBOOP && allie.getPlayer().hasPotionEffect(PotionEffectType.ABSORPTION) && allie.isProche(Roles.JEANNOT, main)) {
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT) {
					allie.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 1));
				}
				
			}
			else if(allie.getPlayer().hasPotionEffect(PotionEffectType.ABSORPTION) && allie.isProche(Roles.JEANNOT, main)){
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT) {
				
					allie.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
				
				}
					
			}
			else {
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT && allie.isProche(Roles.JEANNOT, main)) {
				
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
				
				}
				
			}
			
		}
		
	}

}
