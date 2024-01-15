package fr.gameblack.rcuhcv2.commands.v2.staff.gameblack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class CommandConsole implements CommandExecutor {

    private Main main;

    public CommandConsole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur.getRole() == Roles.GAMEBLACK && joueur.getCamp() == Camps.STAFF) {

	            if (!joueur.getCD().contains(Pouvoirs.GAMEBLACK_CONSOLE)) {
	            	
		            	joueur.setConsoleGBActif(true);
		            	ItemCD cycle = new ItemCD(main, joueur, "console", 30, joueur, null, null, 0, null);
		                cycle.runTaskTimer(main, 0, 20);
	
	            }
	            else {
	            	
	            	player.sendMessage("Ce pouvoir est en cooldown");
	            	
	            }
	            
            }
            else {
            	
            	player.sendMessage("Vous n'avez pas le bon rôle");
            	
            }

        }

        return false;

    }

}
