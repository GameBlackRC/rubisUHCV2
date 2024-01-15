package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Obscur {
	
	public static void Items(Joueur joueur) {
		        
		if(joueur.isBot()) {
			
			joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.OBSCUR_ADAPTION));
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Obscur");
			
		}
		else {
			
			joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.OBSCUR_ADAPTION));
			
		}
		
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
			
			if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
				
				Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
				
				Random r = new Random();
				
	            int nb = r.nextInt(100);
	            
	            if(nb <= 80) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'utiliser un item");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'utiliser un item");
	            	
	            }
				
			}
			
			joueur.getPlayer().sendMessage("Vous activez votre pouvoir");
		
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

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §2Obscur\n§r"
        		+ "Vous devez gagner avec le §2camp UHC§r\n \n"
        		+ "Lorsque vous êtes proche de Toinou ou si Toinou n'est pas dans la compo, vous recevez 2% de force\n \n"
        		+ "Avec votre item 'Adaption', vous obtenez 2% de résistance ainsi que 5% de speed pendant 2min30.\n"
        		+ "Tout les malus que vous obtenez pendant votre pouvoir ont leur durée divisé par 2\n"
        		+ "Si vous obtenez le même malus lors de 2 utilisations consécutif de votre pouvoir, vous devenez immunisé à ce malus durant toute la partie\n \n"
        		+ "Si Toinou vient à mourrir, vous obtenez le pseudo de son tueur et si vous parvenez à l'éliminé, vous obtiendrez 2% de force permanent et vous perdrez 1% de force lorsque votre pouvoir est actif\n \n"
        		+ "____________________________________________________");

    }
	
	public static void TexteTrial(Player player) {
		
		player.sendMessage("____________________________________________________\n \n"
				+ "Vous êtes §2Obscure\n§r"
				+ "Vous devez gagner avec le §2camp UHC§r\n \n"
				+ "au début il obtient le pouvoir \"adaption\" cooldawn 1 x ep\n"
				+ "lors qu'il active il obtient 2% de resisance et 3% de speed durant 2min 30 sec\n"
				+ "pendant se laps de temps tout les malus divisé par deux (exepte farmeurrimo , kzou , trial solo) et si il reçoit deux fois le meme malus durant deux activation consécutif il sera immunisé durant tout la reste de la game\n"
				+ "(Vous arrivez toujours à comprendre ???)\n"
				+ "il se trouver a cote de tobou (toinou, oui trial fait vraiment aucun effort) il gagner 2% de force si il n'as pas activer son pouvoir\net si toinou vient a mourir il obtient le pseudo du tueur et si il vient a l tuer il gagner 2% de force ( et 1% de force dans sa fore pouvoir)\n \n"
				+ "(description par Trial, pour avoir une description plus lisible faites /rcme)"
				+ "\n \n____________________________________________________");
		
	}

}
