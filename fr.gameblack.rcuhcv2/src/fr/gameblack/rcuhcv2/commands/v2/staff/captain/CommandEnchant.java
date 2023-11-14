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

public class CommandEnchant implements CommandExecutor {
	
private Main main;
	
	public CommandEnchant(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	Player cible_ = Bukkit.getPlayer(args[0]);
        	Joueur cible = main.getJoueur(cible_);

            if (joueur.getRole() == Roles.CAPTAIN) {
            	
            	if(cible_ != null && cible_ != player) {
            		
            		if(!main.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_OTHER)) {
            			
            			main.getCD().add(Pouvoirs.CAPTAIN_ENCHANT_OTHER);
                	
            			Captain.commandEnchant(joueur, cible);
            		
            		}
            	
            	}
            	else {
            		
            		if(!main.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_SELF)) {
            			
            			main.getCD().add(Pouvoirs.CAPTAIN_ENCHANT_SELF);
            			
            			Captain.commandEnchant(joueur, joueur);
            			
            		}
            		
            	}
            	
            	
            }

        }

        return false;
    }

}
