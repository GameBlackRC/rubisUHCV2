package fr.gameblack.rcuhcv2.commands.v2.joueur.jeannot;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

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
					if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
						
						Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
						
						Random r = new Random();
						
			            int nb = r.nextInt(100);
			            
			            if(nb <= 80) {
			            	
			            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'effectuer une commande");
			            	
			            }
			            else {
			            	
			            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'effectuer une commande");
			            	
			            }
						
					}
					
				}
				
			}
			
		//}
		
		return false;
		
	}

}
