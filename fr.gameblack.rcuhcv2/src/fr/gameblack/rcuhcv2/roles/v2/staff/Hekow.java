package fr.gameblack.rcuhcv2.roles.v2.staff;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Hekow {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.addResi(0.02);
		
        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.HEKOW_JEU));
		
	}
	
	public static void interactJeu(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.HEKOW_JEU)) {
			
			joueur.getCD().add(Pouvoirs.HEKOW_JEU);
			joueur.getPlayer().sendMessage("Vous activez votre pouvoir");
		
			joueur.setHekowJeuActif(true);
			ItemCD cycle = new ItemCD(main, joueur, "jeu_hekow", 30, joueur, null, null, 0, null);
	    	cycle.runTaskTimer(main, 0, 20);
	    	
		}
		
	}
	
	public static void activeJackpot(Joueur joueur, Main main) {
			
		Bukkit.getWorld("world").playSound(joueur.getPlayer().getLocation(), Sound.GHAST_DEATH, 10, 1);
		
		joueur.addSpeed(0.1);
		
		if(!joueur.getCamp().equalsIgnoreCase("farmeurimmo")) {
		
			joueur.removeResi(0.02);
		
		}
		
		joueur.addForce(0.02);
		ItemCD cycle = new ItemCD(main, joueur, "jackpot_hekow", 120, joueur, null, null, 0, null);
    	cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Hekow\n§rVous devez gagner avec le §9camp staff§r\n \nVous avez 2% de résistance permanent\n \nAvec votre item 'Jeu meurtrier', vous vaez 30 secondes pour monter le plus haut possible vos pourcents. A la fin des 30 secondes, en fonction de votre pourcentage, vous avez une chance que votre compétence jackpot s'active\n \nLorsque votre compétence jackpot est fini, vous avez 50% de chance de pouvoir réutiliser votre item\n \nLa compétence jackpot dure 2 minutes et vous donne 10% de speed ainsi que 2% de force supplémentaire et une régénération de 1 demi coeur toutes les 10 secondes (vous perdez vos 2% de résistance pendant que votre compétence est active\n \n____________________________________________________");

    }

}
