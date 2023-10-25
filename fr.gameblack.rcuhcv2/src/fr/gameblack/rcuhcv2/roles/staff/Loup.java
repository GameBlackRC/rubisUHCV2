package fr.gameblack.rcuhcv2.roles.staff;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

import java.util.ArrayList;
import java.util.List;

public class Loup {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		joueur.addResi(0.02);
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Super bateau");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void ItemSuperBateau(Joueur joueur, Main main) {
		
		main.getCD().add(Pouvoirs.LOUP_SUPERBATEAU);
		
		joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLAZE_DEATH, 10, 1);
		
		joueur.getPlayer().sendMessage("Vous activez votre pouvoirs");
		
		Random r = new Random();
        int nb = r.nextInt(100);
		
		joueur.setNofall(true);
		joueur.getPlayer().setAllowFlight(true);
		joueur.getPlayer().setFlying(true);
		joueur.setInvulnerable(true);
		
		if(nb <= 10) {
	        
	        ItemCD cycle = new ItemCD(main, joueur, "vol_loup_pb", 5, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
	        ItemCD cycle2 = new ItemCD(main, joueur, "vol_loup_nf", 8, joueur, null, null, null, null);
	        cycle2.runTaskTimer(main, 0, 20);
			
		}
		else {
			
			ItemCD cycle = new ItemCD(main, joueur, "vol_loup", 10, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
	        ItemCD cycle2 = new ItemCD(main, joueur, "vol_loup_nf", 13, joueur, null, null, null, null);
	        cycle2.runTaskTimer(main, 0, 20);
			
		}
		
		ItemCD cycle3 = new ItemCD(main, joueur, "vol_loup_cd", 300, joueur, null, null, null, null);
        cycle3.runTaskTimer(main, 0, 20);
		
	}
	
	public static void CommandServeur(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.LOUP_SERVEUR)) {
			
			joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
			
			main.getCD().add(Pouvoirs.LOUP_SERVEUR);
		
			List<Joueur> joueurs = new ArrayList<>();
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(j.getRole() != Roles.NONE && j.getRole() != Roles.TRIAL && j.getRole() != Roles.LOUP) {
					
					j.removeForce(0.05);
					joueurs.add(j);
					
				}
				
			}
			
			ItemCD cycle = new ItemCD(main, joueur, "serveur_loup", 30, joueur, null, joueurs, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Loup\n§rVous devez gagner avec le §9camp staff§r\n \nA l'annonce des rôles, vous recevez un item nommé 'Super bateau' qui vous permet de voler pendant 10secondes\nIl y a 10% de chance que la durée de vol soit de 5 secondes. Dans ce cas vous recevrez le message 'Flying is not enable on this server' à la fin du vol\n \nAvec la commande /rcserveur, si Trial est proche de vous, tous les joueurs de la partie, sauf vous et Trial, perdent 5% de force pendant 30 secondes\n \n____________________________________________________");

    }

}
