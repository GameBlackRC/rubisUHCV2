package fr.gameblack.rcuhcv2.commands.v1.rc.gameblack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;

public class CommandChoose implements CommandExecutor {

    private Main main;

    public CommandChoose(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (args.length != 0) {

            if (args[0] != null && (args[0].equalsIgnoreCase("gameblack") || args[0].equalsIgnoreCase("coeur") || args[0].equalsIgnoreCase("effet"))) {

                if (joueur.getRole() == Roles.GameBlack) {
                		
                	if(args[0].equalsIgnoreCase("coeur")) {
                			
                		GameBlackV1.CommandChoose(joueur, main, true);
                			
                	}
                	else {
                			
                		GameBlackV1.CommandChoose(joueur, main, false);
                			
                	}

                } else if(joueur.getCamp() == Camps.SOLOS && main.getJoueurByRole(Roles.GameBlack) != null && main.getJoueurByRole(Roles.GameBlack).getPouvoirGB() == Pouvoirs_GB.SPEED && joueur.getGBPourcent() >= 90) {
                	
                	if(args[0].equalsIgnoreCase("coeur")) {
            			
                		GameBlackV1.CommandChooseOther(joueur, main, true);
                			
                	}
                	else {
                			
                		GameBlackV1.CommandChooseOther(joueur, main, false);
                			
                	}
                	
                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre une valeur valide (/rcchoose <coeur|effet>)");

            }

        } else {

            player.sendMessage("Merci de mettre une valeur (/rcchoose <coeur|effet>)");

        }

        return false;
    }

}