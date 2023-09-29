package fr.gameblack.rcuhcv2.roles.joueur;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Slup {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Pactes");
        coffre.setItemMeta(coffreM);

        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void interactPacte(Joueur joueur) {
		
		Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Choix du pacte");
    	
        inv_pacte.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie. \nCertains rôles changent pour s'adapter à ce mode"));
        inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage\net aucun changement de rôles"));

        yer.openInventory(inv_pacte);
		
	}
	
	public static void CommandTrial(Joueur joueur, Joueur cible) {
	
		if(joueur.getPacteSlup() == 2) {
		
			if(cible.getRole() == Roles.TRIAL) {
				
				cible.setCamp("duo");
				joueur.setCamp("duo");
				joueur.getPlayer().sendMessage("Vous avez trouvé Trial, vous devez désormais gagner ensemble");
				joueur.addResi(0.05);
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Vous n'avez pas trouvé Trial, vous devez donc gagner avec le camp joueur");
				
			}
			
		}
		
	}
	
	public static void fakeMort(Joueur joueur, Main main) {
		
		for(Joueur j : main.getListJoueurs()) {
			
			if(!j.isSpec()) {
				
				j.getPlayer().hidePlayer(joueur.getPlayer());
				
			}
			joueur.setInvulnerable(true);
			ItemCD cycle = new ItemCD(main, joueur, "fakemort_slup", 300, joueur, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void choixPacte1(Joueur joueur) {
		
		if(joueur.getPacteSlup() == 0) {
			
			joueur.setPacteSlup(1);
			joueur.addSpeed(0.07);
			
		}
		
	}
	
	public static void choixPacte2(Joueur joueur) {
		
		if(joueur.getPacteSlup() == 0) {
			
			joueur.setPacteSlup(2);
			
		}
		
	}
	
	public static void trialProche(Joueur joueur, Main main) {
		
		if(joueur.getCamp() != "duo" && joueur.getPacteSlup() == 2) {
		
			for(Entity entity : joueur.getPlayer().getNearbyEntities(10, 10, 10)) {
				
				if(entity instanceof Player) {
					
					Player cible_ = (Player) entity;
					Joueur cible = main.getJoueur(cible_);
					if(cible.getRole() == Roles.TRIAL) {
						
						joueur.getPlayer().sendMessage("Trial se trouve dans un rayon de 10 blocs de vous");
						
						return;
						
					}
					
				}
				
			}
			
			joueur.getPlayer().sendMessage("Trial n'est pas proche de vous");
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aSlup\n§rVous devez gagner avec le §acamp joueur§r\n \nA l'annonce des rôles, vous recevez un coffre nommé 'Pacte' vous permettant de choisir entre 2 pactes :\n - Pacte 1 : Vous gagnez avec le camp joueur et recevez 5% de speed supplémentaire\n- Pacte 2 : Si vous trouvez Trial avant 50 minutes de jeu ave cla commande /rctrial <pseudo>, vous gagnez en duo avec lui et recevez 5% de force et de speed sinon vous rester dans le camp joueur\n \nSi vous avez choisi le pacte 2, de la 40ème à la 45ème minutes, vous recevez un message toutes le sminutes vous informant si vous êtes proche de Trial. Si Loup vient à mourrir avant 50 minutes et que vous avez choisis le pacte 2, vous gagnez avec Trial et vous recevez 5% de force et de speed supplémentaire\n \nAvec la commande /rcmort, vous devenez invisible pendant 5 minutes. Durant ce laps de temps vous êtes invulnérable et vous ne pouvez mettre aucun coup. Votre message de mort apparait dans le chat et vous serez invisible dans la liste des joueurs (TAB) pendant que vous êtes invisible\n \n____________________________________________________");

    }

}
