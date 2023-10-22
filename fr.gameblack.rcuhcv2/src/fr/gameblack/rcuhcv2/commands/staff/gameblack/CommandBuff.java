package fr.gameblack.rcuhcv2.commands.staff.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;

public class CommandBuff implements CommandExecutor {
	
private Main main;
	
	public CommandBuff(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player && args.length > 1) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	Player cible_ = Bukkit.getPlayer(args[0]);
        	Joueur cible = main.getJoueur(cible_);
        	
        	String buff = args[1];

            if (cible_ != null && (joueur.getRole() == Roles.GAMEBLACK && joueur.getModeTrial(main) == "serieux")) {
            	
            	if(buff.equalsIgnoreCase("coeur") || buff.equalsIgnoreCase("force") || buff.equalsIgnoreCase("speed") || buff.equalsIgnoreCase("resi")) {
                	
            		GameBlack.CommandeBuff(joueur, cible, msg, main);
            	
            	}
            	
            }

        }

        return false;
    }

}
