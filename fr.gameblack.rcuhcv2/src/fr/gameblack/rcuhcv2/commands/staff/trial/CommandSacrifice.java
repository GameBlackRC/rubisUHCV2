package fr.gameblack.rcuhcv2.commands.staff.trial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

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
        	
        	if(joueur.getRole() == Roles.TRIAL && joueur.getModeTrial(main) == "serieux") {
        		
        		if(args[0].equalsIgnoreCase("coeur")) {
        			
        			Trial.CommandSacrifice(joueur, "coeur");
        			
        		}
        		else if(args[0].equalsIgnoreCase("regen")) {
        			
        			Trial.CommandSacrifice(joueur, "regen");
        			
        		}
        		
        	}

        }

        return false;
    }

}
