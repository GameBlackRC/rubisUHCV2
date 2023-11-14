package fr.gameblack.rcuhcv2.commands.v2.joueur.slup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Slup;

public class CommandSlime implements CommandExecutor {

    private Main main;

    public CommandSlime(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur != null) {

            	if (joueur.getRole() == Roles.SLUP) {
		            	
		           	Slup.commandSlime(joueur);
		
		        }
		        else {
		            	
		          	player.sendMessage("Tu n'as pas le bon rôle");
		            	
		        }
	            
            }
            else {
            	
            	player.sendMessage("Vous n'avez pas été enregistrer dans la partie, veuillez déco-reco");
            	
            }

        }

        return false;

    }

}
