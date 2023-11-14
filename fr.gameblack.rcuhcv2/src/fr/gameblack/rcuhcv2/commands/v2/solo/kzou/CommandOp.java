package fr.gameblack.rcuhcv2.commands.v2.solo.kzou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.solo.KzouV1;
import fr.gameblack.rcuhcv2.roles.v2.solo.Kzou;

public class CommandOp implements CommandExecutor {
	
	private Main main;

    public CommandOp(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			if(main.getVersion() == 2 && (joueur.getRole() == Roles.KZOU || joueur.getRole() == Roles.TEST)) {
	            	
	            Kzou.CommandOP(joueur, main);
				
			}
			else if(main.getVersion() == 1 && joueur.getRole() == Roles.Kzou) {
				
				KzouV1.CommandOP(joueur, main);
				
			}
			
		//}
		
		return false;
		
	}

}
