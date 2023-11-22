package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class CommandSetHost implements CommandExecutor {

    private Main main;

    public CommandSetHost(Main main) {
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
	                	
	                Bukkit.broadcastMessage(cible.getPlayer().getName() + " est désormais l'host principal de la partie");
	                main.setHostBase(cible);
	                
                	main.updateScoreboard();
	                	
	            } else {
	
	                player.sendMessage("Merci de mettre un pseudo valide");
	
	            }
	
	        } else {
	
	            player.sendMessage("Utilisation de la commande : /sethost <pseudo>");
	
	        }
	        
        }

        return false;
    }

}