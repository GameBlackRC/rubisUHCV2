package fr.gameblack.rcuhcv2.commands.staff.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class CommandClasse implements CommandExecutor {
	
private Main main;
	
	public CommandClasse(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	String classe = args[0];

            if (classe != null && (joueur.getRole() == Roles.GAMEBLACK && joueur.getModeTrial(main) == "serieux")) {
            	
            	if(classe.equalsIgnoreCase("attaquant")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.ATTAQUANT, main);
            	
            	} else if(classe.equalsIgnoreCase("defenseur")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.DEFENSEUR, main);
            	
            	} else if(classe.equalsIgnoreCase("rapide")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.RAPIDE, main);
            	
            	} else if(classe.equalsIgnoreCase("distance")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.DISTANCE, main);
            	
            	} else if(classe.equalsIgnoreCase("support")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.ATTAQUANT, main);
            	
            	} else if(classe.equalsIgnoreCase("rien")) {
            	
            		GameBlack.CommandeClasse(joueur, Classe.RIEN, main);
            	
            	} else {
            		
            		joueur.getPlayer().sendMessage("Cette classe n'existe pas");
            		
            	}
            	
            }
            else {
            	
            	player.sendMessage("Erreur CommandPlay.java");
            	
            }

        }

        return false;
    }

}
