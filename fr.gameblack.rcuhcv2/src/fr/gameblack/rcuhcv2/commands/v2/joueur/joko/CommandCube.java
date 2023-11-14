package fr.gameblack.rcuhcv2.commands.v2.joueur.joko;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.rc.JokoV1;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Joko;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCube implements CommandExecutor {

    private Main main;

    public CommandCube(Main main) {
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
	
	                if (joueur.getRole() == Roles.JOKO || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.JOKO_CUBE))) {
	
	                    if (!main.getCD().contains(Pouvoirs.JOKO_GIVECUBE)) {
	
	                        Joko.CommandCube(joueur, cible, main);
	
	                    } else {
	
	                        player.sendMessage("Attendez 5 minutes avant de réutiliser cette commande");
	
	                    }
	
	                } else if(joueur.getRole() == Roles.Joko) {
	                	
	                	if (!main.getCD().contains(Pouvoirs.JOKO_GIVECUBE)) {
	                		
	                        JokoV1.CommandCube(joueur, cible, main);
	
	                    } else {
	
	                        player.sendMessage("Attendez 5 minutes avant de réutiliser cette commande");
	
	                    }
	                	
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