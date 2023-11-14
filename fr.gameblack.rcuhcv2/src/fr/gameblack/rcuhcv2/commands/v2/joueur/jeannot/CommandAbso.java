package fr.gameblack.rcuhcv2.commands.v2.joueur.jeannot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandAbso implements CommandExecutor {
	
	private Main main;

    public CommandAbso(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			if(main.getMode().equalsIgnoreCase("rapide") && (joueur.getRole() == Roles.JEANNOT || joueur.getRole() == Roles.TEST)) {
				
				if(joueur.isJeannotAbso()) {
					
					joueur.setJeannotAbso(false);
					player.sendMessage("Vous ne retirer plus l'absorption");
					
				}
				else {
					
					joueur.setJeannotAbso(true);
					player.sendMessage("Vous pouvez désormais retirer l'absorption");
					
				}
				
			}
			else if(joueur.getRole() == Roles.Farmeurimmo && main.getVersion() == 1) {
				
				if(joueur.isJeannotAbso()) {
					
					joueur.setJeannotAbso(false);
					player.sendMessage("Vous ne retirer plus l'absorption");
					
				}
				else {
					
					joueur.setJeannotAbso(true);
					player.sendMessage("Vous pouvez désormais retirer l'absorption");
					
				}
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Vous n'avez pas le bon rôle");
				
			}
			
		//}
		
		return false;
		
	}

}
