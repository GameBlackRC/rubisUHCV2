package fr.gameblack.rcuhcv2.commands.v2.solo.farmeurimmo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.solo.Farmeurimmo;

public class CommandRCCode implements CommandExecutor {
	
	private Main main;

    public CommandRCCode(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	//if(main.isV2Actif()) {
    	
	        Player player = (Player) sender;
	        Joueur joueur = main.getJoueur(player);
	
	        if (joueur.getRole() == Roles.FARMEURIMMO || joueur.getRole() == Roles.TEST) {
	        	
	        	Player cible_ = Bukkit.getPlayer(args[0]);
	
	            if (cible_ != null) {
	            	
	            	if(!joueur.getCD().contains(Pouvoirs.FARMEURIMMO_HACK)) {
	            	
		            	Joueur cible = main.getJoueur(cible_);
		            	
		            	if(cible.getRole() != Roles.MAKA) {
		
		            		Farmeurimmo.commandCode(joueur, cible, main);
		            		
		            	}
		            	else {
		            		
		            		player.sendMessage("Vous ne pouvez pas hacker cette cible");
		            		
		            	}
		            	
	            	}
	            	else {
	            		
	            		player.sendMessage("Ce pouvoir est en cooldown");
	            		
	            	}
	            	
	            } else {
	
	                player.sendMessage("Merci de donner le pseudo de la cible (/rccode <pseudo>");
	
	            }
	
	        } else {
	
	        	player.sendMessage("Vous n'avez pas le bon rôle");
	
	        }
	        
    	//}

        return false;
    }

}
