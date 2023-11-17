package fr.gameblack.rcuhcv2.commands.v2.staff.captain;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.staff.Captain;

public class CommandRepair implements CommandExecutor {
	
private Main main;
	
	public CommandRepair(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	if(!joueur.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
	        	
	        	if(joueur.getRepairCaptain() == 1) {
	        		
	        		joueur.setRepairCaptain(0);
	        		joueur.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        		
	        	}
	        	else {
	        		
	        		joueur.setRepairCaptain(1);
	        		
	        	}
	
	        	Player cible_ = Bukkit.getPlayer(args[0]);
	        	Joueur cible = main.getJoueur(cible_);
	
	            if (cible_ != null && (joueur.getRole() == Roles.CAPTAIN || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().add(Pouvoirs.CAPTAIN_REPAIR)))) {
	                	
	            	Captain.commandRepair(joueur, cible);
	            	
	            }
            
        	}

        }

        return false;
    }

}
