package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cosmos {

    public static void Items(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Zone de speed");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);
        joueur.addForce(main.getForceIBaseV1());

    }
    
    public static void InteractZone(Joueur joueur, Main main) {
    	
    	//main.setZoneCosmos(true);
    	//main.getCoZone().set(0, joueur.getPlayer().getLocation().getX());
    	//main.getCoZone().set(1, player.getLocation().getZ());
    	ItemCD cycle = new ItemCD(main, joueur, "zone", 180, joueur, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
    	
    }
    
    public static void CommandeKill(Joueur joueur, Main main, String choix, Joueur cible) {
    	
    	Player player = joueur.getPlayer();
    	
    	if(choix.equalsIgnoreCase("effet")) {
    		
    		Random r = new Random();
            int nb = r.nextInt(2);
            
            if(nb == 1) {
    		
            	joueur.addForce(0.03);
            	player.sendMessage("Vous avez reçu 3% de force supplémentaire");
            	
            }
            else {
            	
            	joueur.addResi(0.03);
            	player.sendMessage("Vous avez reçu 3% de résistance supplémentaire");
            	
            }
            
            //main.getKillCosmos().remove(cible);
    		
    	}
    	else if(choix.equalsIgnoreCase("pantin")) {
    		
    		//main.addRespawn(cible, "cosmos");
    		player.sendMessage(cible.getPlayer().getName() + " est désormais votre pantin");
    		
    	}
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Cosmos\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nUne fois dans la partie, vous pourrez créer une zone qui vous donne speed I pendant 3 minutes\n \nLorque vous tué un joueur vous avez le choix entre 3 options :\n- Récupérer un poucentage de speed ou de résistance (aléatoire)\n-Transformer le joueur tué en zombie qui doit désormais gagner avec les démons. Le joueur ressusciter réaparaîtra uniquement avec 10 pommes d'or, une épée en diamant, un full fer et l'effet speed I\n- Récupérer une utilisation de sa zone\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}