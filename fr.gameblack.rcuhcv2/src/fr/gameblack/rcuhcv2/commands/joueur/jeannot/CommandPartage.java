package fr.gameblack.rcuhcv2.commands.joueur.jeannot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandPartage implements CommandExecutor {
	
	private Main main;

    public CommandPartage(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			if(joueur.getRole() == Roles.JEANNOT || joueur.getRole() == Roles.TEST) {
				
				if(joueur.isJeannotPartageActif()) {
					
					joueur.setJeannotPartageActif(false);
					player.sendMessage("Vous ne partagez plus votre absorption");
					
				}
				else {
					
					joueur.setJeannotPartageActif(true);
					player.sendMessage("Vous partagez désormais votre absorption");
					
				}
				
			}
			
		//}
		
		return false;
		
	}

}
