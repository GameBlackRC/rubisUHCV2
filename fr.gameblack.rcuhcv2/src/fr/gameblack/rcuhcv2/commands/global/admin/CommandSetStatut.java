package fr.gameblack.rcuhcv2.commands.global.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;

public class CommandSetStatut implements CommandExecutor {
	
	private Main main;
	
	public CommandSetStatut(Main main) {
		
		this.main = main;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			if (args.length != 0 && args[0].equalsIgnoreCase("pvp_on")) {
				
				main.setState(Statut.PVP_ON);
				Bukkit.broadcastMessage("Etat de la partie : PVP activé");
				
			}
			else if (args.length != 0 && args[0].equalsIgnoreCase("pvp_off")) {
				
				main.setState(Statut.PVP_OFF);
				Bukkit.broadcastMessage("Etat de la partie : PVP désactivé");
				
			}
			else if (args.length != 0 && args[0].equalsIgnoreCase("waiting")) {
				
				main.setState(Statut.WAITING);
				Bukkit.broadcastMessage("Etat de la partie : Attente");
				
			}
			else if (args.length != 0 && args[0].equalsIgnoreCase("starting")) {
				
				main.setState(Statut.STARTING);
				Bukkit.broadcastMessage("Etat de la partie : Lancement");
				
			}
			else if (args.length != 0 && args[0].equalsIgnoreCase("finish")) {
				
				main.setState(Statut.FINISH);
				Bukkit.broadcastMessage("Etat de la partie : Fin");
				
			}
			
		//}
		
		return false;
		
	}

}
