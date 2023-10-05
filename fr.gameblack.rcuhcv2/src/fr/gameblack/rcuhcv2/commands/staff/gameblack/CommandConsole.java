package fr.gameblack.rcuhcv2.commands.staff.gameblack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

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
            
            if(joueur.getRole() == Roles.GAMEBLACK && joueur.getCamp().equalsIgnoreCase("staff")) {

	            if (!main.getCD().contains(Pouvoirs.GAMEBLACK_CONSOLE)) {
	            	
		            	joueur.setConsoleGBActif(true);
		            	ItemCD cycle = new ItemCD(main, joueur, "console", 30, joueur, null, null, null, null);
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
