package fr.gameblack.rcuhcv2.roles.v2.joueur;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Roles;

public class Jeannot {
	
	public static void Items(Joueur joueur, Main main) {
		
		Texte(joueur.getPlayer(), main);
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Jeannot");
			
		}
		
	}
	
	public static void Texte(Player player, Main main) {
		
		if(main.getMode() == Modes.RAPIDE) {
			
			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §aJeannot\n§r"
					+ "Vous devez gagner avec le §acamp joueur§r\n \n"
					+ "Vous avez §12% de force permanent§r\n \n"
					+ "Avec la commande §b/rcpartage§r, vous pouvez activer et désactiver votre mode partage. Lorsque le mode partage est actif, vous ne recevez plus d'absorption de vos pommes d'or mais tout vos alliés dans un rayon de 20 blocs en recoivent s'il n'en avais pas. Si §aNickoboop§r avait déjà de l'absorption alors il monte jusqu'à §d4 coeurs d'absorption§r\n \n"
					+ "Avec la commande /rcabso, vous pouvez activer/désactiver votre passif vous permettant d'avoir 5% de chance par coup d'empêcher l'adversaire de recevoir de l'absorption pendant 15 secondes\n \n"
					+ "____________________________________________________");
			
		}
		else {
			
			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §aJeannot\n§rVous devez gagner avec le §acamp joueur§r\n \n"
					+ "Vous avez §12% de force§r proche de §aNickoboop§r§r\n \n"
					+ "Avec la commande §b/rcpartage§r, vous pouvez activer et désactiver votre mode partage. Lorsque le mode partage est actif, vous ne recevez plus d'absorption de vos pommes d'or mais tout vos alliés dans un rayon de 20 blocs en recoivent s'il n'en avais pas. Si §aNickoboop§r avait déjà de l'absorption alors il monte jusqu'à §d4 coeurs d'absorption§r\n \n"
					+ "Vous connaissez §aNickoboop§r\n \n"
					+ "____________________________________________________");
			
		}

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
		List<Joueur> allies = main.getJoueurInCamp(Camps.JOUEUR);
		for(Joueur allie : allies) {
			
			if(allie.getRole() == Roles.NICKOBOOP && allie.getPlayer().hasPotionEffect(PotionEffectType.ABSORPTION) && allie.isProche(joueur, main)) {
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT) {
					allie.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 1));
				}
				
			}
			else if(allie.getPlayer().hasPotionEffect(PotionEffectType.ABSORPTION) && allie.isProche(joueur, main)){
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT) {
				
					allie.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
				
				}
					
			}
			else {
				
				if(allie.isAbsoOn() && allie.getRole() != Roles.JEANNOT && allie.isProche(joueur, main)) {
				
					allie.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
				
				}
				
			}
			
		}
		
	}

}
