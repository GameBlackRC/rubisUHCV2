package fr.gameblack.rcuhcv2.commands.v2.staff.trial;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;

public class CommandCorruption implements CommandExecutor {
	
private Main main;
	
	public CommandCorruption(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	Player cible_ = Bukkit.getPlayer(args[0]);
        	Joueur cible = main.getJoueur(cible_);

            if (cible_ != null && (joueur.getRole() == Roles.TRIAL && joueur.getModeTrial(main) == "serieux")) {
            	
            	if(Trial.getNbUtilisationCorruption() < 2) {
            	
	            	if(!joueur.getCD().contains(Pouvoirs.TRIAL_CORRUPTION)) {
	            		
	            		joueur.getCD().add(Pouvoirs.TRIAL_CORRUPTION);
	            	
	            		Trial.commandCorruptionAmes(joueur, cible, main);
	            		
	            	}
	            	else {
	            		
	            		player.sendMessage("Ce pouvoir est en cooldown");
	            		
	            	}
	            	
            	}
            	else {
            		
            		player.sendMessage("Vous ne pouvez plus utiliser cette commande");
            		
            	}
            	
            }
            else {
            	
            	player.sendMessage("Erreur CommandPlay.java");
            	
            }

        }

        return false;
    }

}
