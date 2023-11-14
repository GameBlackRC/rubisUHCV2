package fr.gameblack.rcuhcv2.commands.v2.joueur.joko;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.TrialV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.JokoV1;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Joko;

public class CommandSteal implements CommandExecutor {

    private Main main;

    public CommandSteal(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	//if(main.isV2Actif()) {
    	
	        Player player = (Player) sender;
	        
	        Joueur joueur = main.getJoueur(player);
	
	        if (main.getVersion() == 2 && joueur.getRole() == Roles.JOKO || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.JOKO_CUBE))) {
	
	            if (args.length != 0) {
	
	                if (args[0].equalsIgnoreCase("force")) {
	                    Joko.CommandSteal(joueur, main, "force");
	
	                } else if (args[0].equalsIgnoreCase("resi") || args[0].equalsIgnoreCase("resistance")) {
	                    Joko.CommandSteal(joueur, main, "resi");
	
	                }
	
	            } else {
	
	                player.sendMessage("Merci de mettre l'effet que vous souhaitez voler (/rcsteal <force|resi|resistance>)");
	
	            }
	
	        } else if(main.getVersion() == 1 && joueur.getRole() == Roles.Joko) {
	        	
	            if (args.length != 0) {
	            	
	                if (args[0].equalsIgnoreCase("force")) {
	                    JokoV1.CommandSteal(joueur, main, "force");
	
	                } else if (args[0].equalsIgnoreCase("resi") || args[0].equalsIgnoreCase("resistance")) {
	                    JokoV1.CommandSteal(joueur, main, "resi");
	
	                }
	
	            } else {
	
	                player.sendMessage("Merci de mettre l'effet que vous souhaitez voler (/rcsteal <force|resi|resistance>)");
	
	            }
	        	
	        } else if(main.getVersion() == 1 && joueur.getRole() == Roles.Trial) {
	        	
	        	TrialV1.CommandSteal(player, main);
	        	
	        } else {
	
	            player.sendMessage("Vous n'avez pas le bon rôle");
	
	        }
	        
    	//}

        return false;
    }

}