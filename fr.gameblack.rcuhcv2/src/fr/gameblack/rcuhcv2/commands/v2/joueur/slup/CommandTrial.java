package fr.gameblack.rcuhcv2.commands.v2.joueur.slup;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Slup;

public class CommandTrial implements CommandExecutor {
	
private Main main;
	
	public CommandTrial(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	Player cible_ = Bukkit.getPlayer(args[0]);
        	
        	if(cible_ != null) {
        		
        		Joueur cible = main.getJoueur(cible_);
        	
        		Slup.CommandTrial(joueur, cible);
        		
        	}

        }

        return false;
    }

}
