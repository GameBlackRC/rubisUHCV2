package fr.gameblack.rcuhcv2.commands.staff.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

@SuppressWarnings("unused")
public class CommandClasse implements CommandExecutor {
	
private Main main;
	
	public CommandClasse(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	String classe = args[0];
        	
        	System.out.println(args[0]);

            if ((joueur.getRole() == Roles.GAMEBLACK && joueur.getModeTrial(main) == "serieux")) {
            	
            	if(classe != null) {
            	
	            	if(classe.equalsIgnoreCase("attaquant")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.ATTAQUANT, main);
	            	
	            	} else if(classe.equalsIgnoreCase("defenseur")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.DEFENSEUR, main);
	            	
	            	} else if(classe.equalsIgnoreCase("rapide")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.RAPIDE, main);
	            	
	            	} else if(classe.equalsIgnoreCase("distance")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.DISTANCE, main);
	            	
	            	} else if(classe.equalsIgnoreCase("support")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.ATTAQUANT, main);
	            	
	            	} else if(classe.equalsIgnoreCase("rien")) {
	            	
	            		GameBlack.CommandeClasse(joueur, Classe.RIEN, main);
	            	
	            	} else {
	            		
	            		joueur.getPlayer().sendMessage("Cette classe n'existe pas");
	            		
	            	}
	            	
            	}
            	else {
            		
            		Inventory inv_orbe = Bukkit.createInventory(null, 36, "§8Choix de la classe");
                	
                    inv_orbe.setItem(11, Main.getItem(Material.IRON_SWORD, "Attaquant", ""));
                    inv_orbe.setItem(13, Main.getItem(Material.IRON_CHESTPLATE, "Défenseur", ""));
                    inv_orbe.setItem(15, Main.getItem(Material.BOW, "Distance", ""));
                    inv_orbe.setItem(19, Main.getItem(Material.FEATHER, "Rapide", ""));
                    inv_orbe.setItem(21, Main.getItem(Material.APPLE, "Support", ""));
                    inv_orbe.setItem(22, Main.getItem(Material.BARRIER, "Rien", ""));

                    joueur.getPlayer().openInventory(inv_orbe);
            		
            	}
            	
            }
            else {
            	
            	player.sendMessage("Erreur CommandPlay.java");
            	
            }

        }

        return false;
    }

}
