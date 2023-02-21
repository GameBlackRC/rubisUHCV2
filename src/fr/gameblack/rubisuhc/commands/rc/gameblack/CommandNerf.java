package fr.gameblack.rubisuhc.commands.rc.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;

public class CommandNerf implements CommandExecutor {
	
	private Main main;

	public CommandNerf(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player player = (Player)sender;
		
		if(args.length != 0) {
			
			Player cible = Bukkit.getPlayer(args[0]);
			
			if(cible != null) {
		
				if(main.getRole(player) == Roles.GAMEBLACK) {
					
					if(!main.getCD().contains(Pouvoirs.GB_NERF)) {
					
						GameBlack.CommandNerf(cible, main);
						
						player.sendMessage("Le joueur " + cible.getName() + " a bien été nerf");
						
						if(main.getRoles().contains(Roles.SLUP)) {
						
							Player slup = main.getPlayerByRole(Roles.SLUP);
							
							slup.sendMessage("GameBlack a utilisé sa commande /rcnerf");
							
						}
						
					}
					else {
						
						player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");
						
					}
					
				}
				else {
					
					player.sendMessage("Vous n'avez pas le bon rôle");
					
				}
				
			}
			else {
				
				player.sendMessage("Merci de mettre un pseudo valide");
				
			}
			
		}
		else {
			
			player.sendMessage("Merci de donner le pseudo de la cible (/rcnerf <pseudo>");
			
		}
		
		return false;
	}

}
