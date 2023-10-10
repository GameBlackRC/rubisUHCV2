package fr.gameblack.rcuhcv2.commands.solo.kzou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.solo.Kzou;

public class CommandOp implements CommandExecutor {
	
	private Main main;

    public CommandOp(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player) sender;
		Joueur joueur = main.getJoueur(player);
		
		if(joueur.getRole() == Roles.KZOU || joueur.getRole() == Roles.TEST) {
            	
            Kzou.CommandOP(joueur, main);
			
		}
		
		return false;
		
	}

}
