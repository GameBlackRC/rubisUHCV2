package fr.gameblack.rcuhcv2.commands.staff.trial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class CommandMode implements CommandExecutor {
	
private Main main;
	
	public CommandMode(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
        	
            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);
            	
            if(joueur.getRole() == Roles.TRIAL && joueur.getModeTrial(main) == null) {
            		
            	if(args[0].equalsIgnoreCase("serieux")) {
            			
            		joueur.setModeTrial("serieux", main);
            		Trial.ItemsSerieux(joueur);
            		player.sendMessage("Vous avez choisi le mode sérieux");
            		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
            			
            			main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().sendMessage("Trial a choisi le mode sérieux");
            			
            		}
            			
            	}
            	else if(args[0].equalsIgnoreCase("fun")) {
            			
            		joueur.setModeTrial("fun", main);
            		Trial.ItemsFun(joueur);
            		player.sendMessage("Vous avez choisi le mode fun");
            		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
            			
            			main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().sendMessage("Trial a choisi le mode fun");
            			
            		}
            			
            	}
            		
            }

        }

        return false;
    }

}
