package fr.gameblack.rubisuhc.commands.rc.joko;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Trial;
import fr.gameblack.rubisuhc.roles.rc.Joko;

public class CommandSteal implements CommandExecutor {
	
	private Main main;
	
	public CommandSteal(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player)sender;
		
		if(main.getRole(player) == Roles.JOKO) {
			
			if(args.length != 0) {
				
				if(main.getRoles().contains(Roles.SLUP)) {
					
					Player slup = main.getPlayerByRole(Roles.SLUP);
					
					slup.sendMessage("Joko a utilisé sa commande /rcsteal");
					
				}
				
				if(args[0].equalsIgnoreCase("force")) {
					Joko.CommandSteal(player, main, "force");
					
				}
				else if(args[0].equalsIgnoreCase("resi") || args[0].equalsIgnoreCase("resistance")) {
					Joko.CommandSteal(player, main, "resi");
					
				}
				
			}
			else {
				
				player.sendMessage("Merci de mettre l'effet que vous souhaitez voler (/rcsteal <force|resi|resistance>)");
				
			}
					
		}
		else if(main.getRole(player) == Roles.TRIAL) {
			
			if(args.length != 0) {
				
				if(args[0].equalsIgnoreCase("orbe")) {
					
					Trial.CommandSteal(player, "orbe", main);
					
				}
				else if(args[0].equalsIgnoreCase("pouvoir")) {
					
					Trial.CommandSteal(player, "pouvoir", main);
					
				}
				
				if(main.getRoles().contains(Roles.SLUP)) {
					
					Player slup = main.getPlayerByRole(Roles.SLUP);
					
					slup.sendMessage("Trial a utilisé sa commande /rcsteal");
					
				}
				
			}
			else {
				
				player.sendMessage("Merci de mettre ce que vous souhaitez voler (/rcsteal <orbe|pouvoir>)");
				
			}
			
		}
		else if(main.getRole(player) == Roles.TRONCONEUSE) {
			
			if(main.getOrbeKill() != Orbe.NONE) {
				
				if(main.getRoles().contains(Roles.SLUP)) {
					
					Player slup = main.getPlayerByRole(Roles.SLUP);
					
					slup.sendMessage("Le démon Tronconeuse a utilisé sa commande /rcsteal");
					
				}
				
				main.setOrbe(player, main.getOrbeKill());
				
			}
			else {
				
				player.sendMessage("Vous n'avez tué aucun joueur possèdant une orbe");
				
			}
			
		}
		else {
			
			player.sendMessage("Vous n'avez pas le bon rôle");
			
		}
		
		return false;
	}

}
