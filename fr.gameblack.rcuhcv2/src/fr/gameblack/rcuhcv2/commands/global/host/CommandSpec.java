package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class CommandSpec implements CommandExecutor {

    private Main main;

    public CommandSpec(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);
        
        if(main.getListHost().contains(joueur)) {

	        if (args.length > 1) {
	
	            Player cible_ = Bukkit.getPlayer(args[1]);
	
	            if (cible_ != null) {
	            	
	            	Joueur cible = main.getJoueur(cible_);
	
	                if(args[0].equalsIgnoreCase("add") && !cible.isSpec()) {
	                	
	                	Bukkit.broadcastMessage(cible.getPlayer().getName() + " est désormais spectateur de la partie");
	                	cible.setSpec(true);
	                	
	                }
	                else if(args[0].equalsIgnoreCase("remove") && cible.isSpec()) {
	                	
	                	Bukkit.broadcastMessage(cible.getPlayer().getName() + " n'est plus spectateur de la partie");
	                	cible.setSpec(false);
	                	
	                }
	                
                	main.updateScoreboard();
	
	            } else {
	
	                player.sendMessage("Merci de mettre un pseudo valide");
	
	            }
	
	        } else {
	
	            player.sendMessage("Utilisation de la commande : /spec <add|remove> <pseudo>");
	
	        }
	        
        }

        return false;
    }

}