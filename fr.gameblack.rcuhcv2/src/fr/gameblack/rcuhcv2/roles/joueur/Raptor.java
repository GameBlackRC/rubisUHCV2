package fr.gameblack.rcuhcv2.roles.joueur;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Raptor {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Rage");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aRaptor\n§rVous devez gagner avec le §acamp joueur§r\n \nA l'annonce des rôles, vous recevez un item nommé 'Rage' vous permettant de recevoir 7% de force pendant 20 secondes. A la fin du pouvoir, vous recevrez l'effet Nausée I pendant 20 secondes. Lorsque vous subissez 5 coups du même adversaire sans l'avoir toucher, vous activer un cheat qui vous donne un avantage parmi les suivant aléatoirement :\n- 10% de chance de rien recevoir\n- 10% de chance d'avoir un anti-kb pendant 5 secondes\n- 15% de chance de recevoir 5% de force supplémentaire pendant 1 minute\n- 20% de chance de recevoir 3% de force supplémentaire pendant 1 minute\n- 20% de chance de recevoir 3% de resistance supplémentaire pendant 1 minute\n- 25% de chance de recevoir 10% de speed supplémentaire pendant 1 minute\n \n____________________________________________________");

    }
	
	public static void ItemRage(Joueur joueur, Main main) {
		
		joueur.addForce(0.07);
		ItemCD cycle = new ItemCD(main, joueur, "rage_raptor", 20, joueur, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);
		
	}

	public static void cheat(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.RAPTOR_CHEAT)) {
			
			main.getCD().add(Pouvoirs.RAPTOR_CHEAT);
		
			Random r = new Random();
	        int nb = r.nextInt(100);
	        
	        if(nb <= 10) {
	        	
	        	//rien
	        	
	        }
	        else if(nb <= 20) {
	        	
	        	//anti-kb pendant 5 secondes
	        	joueur.setAntiKB(true);
	        	ItemCD cycle = new ItemCD(main, joueur, "antikb_raptor", 5, joueur, null, null, null, null);
	            cycle.runTaskTimer(main, 0, 20);
	        	
	        }
	        else if(nb <= 35) {
	        	
	        	//10% de force pendant 1min
	        	joueur.addForce(0.05);
	        	ItemCD cycle = new ItemCD(main, joueur, "force_raptor", 60, joueur, null, null, null, null);
	            cycle.runTaskTimer(main, 0, 20);
	        	
	        }
	        else if(nb <= 55) {
	        	
	        	//5% de force pendant 1min
	        	joueur.addForce(0.03);
	        	ItemCD cycle = new ItemCD(main, joueur, "5_force_raptor", 60, joueur, null, null, null, null);
	            cycle.runTaskTimer(main, 0, 20);
	        	
	        }
	        else if(nb <= 75) {
	        	
	        	//5% de resi pendant 1min
	        	joueur.addResi(0.03);
	        	ItemCD cycle = new ItemCD(main, joueur, "resi_raptor", 60, joueur, null, null, null, null);
	            cycle.runTaskTimer(main, 0, 20);
	        	
	        }
	        else {
	        	
	        	//10% de speed pendant 1min
	        	joueur.addSpeed(0.10);
	        	ItemCD cycle = new ItemCD(main, joueur, "speed_raptor", 60, joueur, null, null, null, null);
	            cycle.runTaskTimer(main, 0, 20);
	        	
	        }
	        
		}
		
	}
	
}
