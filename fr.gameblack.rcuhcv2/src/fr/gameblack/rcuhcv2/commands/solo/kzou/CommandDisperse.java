package fr.gameblack.rcuhcv2.commands.solo.kzou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.solo.Kzou;

public class CommandDisperse implements CommandExecutor {
	
	private Main main;

    public CommandDisperse(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player) sender;
		Joueur joueur = main.getJoueur(player);
		
		if(joueur.getRole() == Roles.KZOU || joueur.getRole() == Roles.TEST) {
			
			Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {
            	
            	Kzou.CommandDisperse(joueur, main.getJoueur(cible_), main);
            	
            }
			
		}
		
		return false;
		
	}

}
