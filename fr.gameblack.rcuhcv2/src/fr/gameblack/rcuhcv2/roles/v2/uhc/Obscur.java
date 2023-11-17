package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Obscur {
	
	public static void Items(Joueur joueur) {
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Adaption");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
		Random r = new Random();
        int nb = r.nextInt(100);
        
        if(nb <= 10) {
        	
        	TexteTrial(joueur.getPlayer());
        	
        }
        else {
        	
        	Texte(joueur.getPlayer());
        	
        }
		
	}
	
	public static void InteractAdaption(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.OBSCUR_ADAPTION)) {
		
			joueur.getCD().add(Pouvoirs.OBSCUR_ADAPTION);
			main.setAdaptionObscurActif(true);
			if(joueur.isTueurToinouKill()) {
				joueur.removeForce(0.01);
			}
			joueur.addResi(0.02);
			joueur.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "adaption", 150, joueur, null, null, 0, null);
	    	cycle.runTaskTimer(main, 0, 20);
	    	
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §2Obscur\n§rVous devez gagner avec le §2camp UHC§r\n \nLorsque vous êtes proche de Toinou ou si Toinou n'est pas dans la compo, vous recevez 2% de force\n \nAvec votre item 'Adaption', vous obtenez 2% de résistance ainsi que 5% de speed pendant 2min30.\nTout les malus que vous obtenez pendant votre pouvoir ont leur durée divisé par 2\nSi vous obtenez le même malus lors de 2 utilisations consécutif de votre pouvoir, vous devenez immunisé à ce malus durant toute la partie\n \nSi Toinou vient à mourrir, vous obtenez le pseudo de son tueur et si vous parvenez à l'éliminé, vous obtiendrez 2% de force permanent et vous perdrez 1% de force lorsque votre pouvoir est actif\n \n____________________________________________________");

    }
	
	public static void TexteTrial(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §2Obscure\n§rVous devez gagner avec le §2camp UHC§r\n \nau début il obtient le pouvoir \"adaption\" cooldawn 1 x ep\nlors qu'il active il obtient 2% de resisance et 3% de speed durant 2min 30 sec\npendant se laps de temps tout les malus divisé par deux (exepte farmeurrimo , kzou , trial solo) et si il reçoit deux fois le meme malus durant deux activation consécutif il aura 30% de chance d'etre immunisé durant tout la reste de la game\n(VOus arrivez toujours à comprendre ???)\nil se trouver a cote de tobou (toinou, oui trial fait vraiment aucun effort) il gagner 2% de force si il n'as pas activer son pouvoir\net si toinou vient a mourir il obtient le pseudo du tueur et si il vient a l tuer il gagner 2% de force ( et 1% de force dans sa fore pouvoir)\n \n(description par Trial, pour avoir une description plus lisible faites /rcme)\n \n____________________________________________________");
		
	}

}
