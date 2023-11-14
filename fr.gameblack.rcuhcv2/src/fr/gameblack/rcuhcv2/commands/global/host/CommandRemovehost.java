package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class CommandRemovehost implements CommandExecutor {

    private Main main;

    public CommandRemovehost(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);
        
        if(main.getListHost().contains(joueur)) {

	        if (args.length != 0) {
	
	            Player cible_ = Bukkit.getPlayer(args[1]);
	
	            if (cible_ != null) {
	            	
	            	Joueur cible = main.getJoueur(cible_);
	                	
	                Bukkit.broadcastMessage(cible.getPlayer().getName() + " n'est plus un host de la partie");
	                main.removeHost(cible);
	
	            } else {
	
	                player.sendMessage("Merci de mettre un pseudo valide");
	
	            }
	
	        } else {
	
	            player.sendMessage("Utilisation de la commande : /addhost <pseudo>");
	
	        }
	        
        }

        return false;
    }

}