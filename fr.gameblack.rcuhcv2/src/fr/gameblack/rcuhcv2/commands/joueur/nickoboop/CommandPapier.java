package fr.gameblack.rcuhcv2.commands.joueur.nickoboop;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.joueur.Nickoboop;

public class CommandPapier implements CommandExecutor {
	
	private Main main;

    public CommandPapier(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			Player cible_ = Bukkit.getPlayer(args[0]);
			
			if(cible_ != null && (joueur.getRole() == Roles.NICKOBOOP || joueur.getRole() == Roles.TEST)) {
				
				if(!main.getCD().contains(Pouvoirs.NICKOBOOP_PAPIER)) {
					
					main.getCD().add(Pouvoirs.NICKOBOOP_PAPIER);
				
					Joueur cible = main.getJoueur(cible_);
					
					Nickoboop.CommandPapier(joueur, cible, main);
					
				}
				
			}
			
		//}
		
		return false;
		
	}

}
