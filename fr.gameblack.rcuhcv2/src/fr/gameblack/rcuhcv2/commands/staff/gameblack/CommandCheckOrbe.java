package fr.gameblack.rcuhcv2.commands.staff.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;

public class CommandCheckOrbe implements CommandExecutor {
	
	private Main main;

    public CommandCheckOrbe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if ((joueur.getRole() == Roles.GAMEBLACK && joueur.getCamp().equalsIgnoreCase("staff")) || joueur.getRole() == Roles.TEST) {
        	
        	Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {
            	
            	if(!main.getCD().contains(Pouvoirs.GAMEBLACK_CHECKORBE)) {
            		
            		main.getCD().add(Pouvoirs.GAMEBLACK_CHECKORBE);
            	
	            	Joueur cible = main.getJoueur(cible_);
	
	            	GameBlack.commandCheckOrbe(joueur, cible);
	            	
            	}
            	else {
            		
            		player.sendMessage("Ce pouvoir est en cooldown");
            		
            	}
            	
            } else {

                player.sendMessage("Merci de donner le pseudo de la cible (/rccode <pseudo>");

            }

        } else {

        	player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}
