package fr.gameblack.rcuhcv2.commands.v2.uhc.toinou;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Toinou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTraque implements CommandExecutor {

    private Main main;

    public CommandTraque(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	//if(main.isV2Actif()) {
    	
	        Player player = (Player) sender;
	        
	        Joueur joueur = main.getJoueur(player);
	
	        if (args.length != 0) {
	
	            Player cible_ = Bukkit.getPlayer(args[0]);
	
	            if (cible_ != null) {
	            	
	            	Joueur cible = main.getJoueur(cible_);
	
	                if(joueur.getRole() == Roles.TOINOU) {
	                	
	                	Toinou.CommandTraque(joueur, cible, main);
	                	
	                } else {
	
	                    player.sendMessage("Vous n'avez pas le bon rôle");
	
	                }
	
	            } else {
	
	                player.sendMessage("Merci de mettre un pseudo valide");
	
	            }
	
	        } else {
	
	            player.sendMessage("Merci de mettre un pseudo (/rccube <pseudo>");
	
	        }
	        
    	//}

        return false;
    }

}