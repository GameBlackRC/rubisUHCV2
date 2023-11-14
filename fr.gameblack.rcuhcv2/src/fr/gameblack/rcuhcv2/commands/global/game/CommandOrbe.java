package fr.gameblack.rcuhcv2.commands.global.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.orbes.Orbe;

public class CommandOrbe implements CommandExecutor {

    private Main main;

    public CommandOrbe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (joueur.getOrbe() != Orbe.NONE) {
            	
            	if(joueur.isOrbePassifActif()) {

	                if (joueur.isOrbeActif()) {
	
	                    joueur.setStatutOrbe(false);
	                    player.sendMessage("Tu viens de §cdésactiver§r ton orbe");
	
	                } else {
	
	                	joueur.setStatutOrbe(true);
	                    player.sendMessage("Tu viens d'§aactiver§r ton orbe");
	
	                }
	                
            	}
            	else {
            		
            		player.sendMessage("§cLe passif de ton orbe est désactivé pour le moment");
            		
            	}

            } else {

                player.sendMessage("§cTu ne possède pas d'orbe");

            }

        }

        return false;
    }

}
