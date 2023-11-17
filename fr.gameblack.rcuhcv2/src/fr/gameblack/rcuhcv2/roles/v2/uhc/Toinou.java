package fr.gameblack.rcuhcv2.roles.v2.uhc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Toinou {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.addSpeed(0.05);
		joueur.addForce(0.01);
		
	}
	
	public static void Cheat(Joueur joueur, Main main) {
		
		joueur.addSpeed(0.1);
		joueur.setCheatToinou(true);
		ItemCD cycle = new ItemCD(main, joueur, "speed_cheat_toinou", 120, joueur, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
        ItemCD cycle2 = new ItemCD(main, joueur, "force_cheat_toinou", 60, joueur, null, null, 0, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	public static void CommandVacance(Joueur joueur, Main main) {
		
		joueur.setInvulnerable(true);
		joueur.setInvisible(true);
		joueur.hide(main);
		joueur.addSpeed(0.1);
		
		if(main.getMode().equalsIgnoreCase("rapide")) {
			
			ItemCD cycle = new ItemCD(main, joueur, "vacance_toinou", 15, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		else {
		
			ItemCD cycle = new ItemCD(main, joueur, "vacance_toinou", 120, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void CommandShop(Joueur joueur) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Shop");
    	
        inv_orbe.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "3 gaps", "Coût : 1 point"));
        inv_orbe.setItem(11, Main.getItem(Material.COMPASS, "Pas encore fonctionnel", ""));
        inv_orbe.setItem(12, Main.getItem(Material.BOOK, "Pas encore fonctionnel", "Coût : 1 point"));
        inv_orbe.setItem(13, Main.getItem(Material.GLASS, "Nuage Flottant", "Coût : 2 points"));
        inv_orbe.setItem(14, Main.getItem(Material.NETHERRACK, "Épée maudite", "Coût : 2 points"));
        inv_orbe.setItem(15, Main.getItem(Material.SOUL_SAND, "Épée des âmes", "Coût : 3 points"));
        inv_orbe.setItem(16, Main.getItem(Material.REDSTONE_BLOCK, "Pas encore fonctionnel", "Coût : 4 points"));

        joueur.getPlayer().openInventory(inv_orbe);
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §2Toinou\n§rVous devez gagner avec le §2camp UHC§r\n \nAvec la commande /rcvacance, vous devenez invisible avec votre armure pendant 2 minutes et vous ne pouvez pas recevoir ou mettre de coup pendant que vous êtes invisible\n \nSi Raptor active son cheat contre vous, vous recevez 10% de speed pendant 2 minutes et vos coup mis à Raptor auront 5% de force supplémentaire\n \nAvec la commande /rcshop, vous pouvez acheter des objects avec vos points\nA chaque kill vous obtenez 1 point supplémentaire et à l'annonce des rôles, vous pouvez acheter un objet avec un coût maximum de 2 points hormis les gaps\n \n____________________________________________________");

    }

}
