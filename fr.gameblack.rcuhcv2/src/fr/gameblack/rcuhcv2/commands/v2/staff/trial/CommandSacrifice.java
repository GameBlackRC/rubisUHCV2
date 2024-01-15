package fr.gameblack.rcuhcv2.commands.v2.staff.trial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.Electrique;
import fr.gameblack.rcuhcv2.roles.v1.solo.Experimental;

public class CommandSacrifice implements CommandExecutor {
	
private Main main;
	
	public CommandSacrifice(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        
        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	if(main.getVersion() == 1 && joueur.getRole() == Roles.Experimental) {
        		
        		Experimental.CommandSacrifice(joueur, main);
        		
        	}
        	else if(main.getVersion() == 1 && joueur.getRole() == Roles.Electrique) {
        		
        		Electrique.CommandSacrifice(joueur, main);
        		
        	}

        }

        return false;
    }

}
