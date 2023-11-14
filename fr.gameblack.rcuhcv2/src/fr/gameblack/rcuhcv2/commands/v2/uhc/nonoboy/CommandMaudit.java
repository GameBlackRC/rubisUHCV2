package fr.gameblack.rcuhcv2.commands.v2.uhc.nonoboy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.Malediction;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Nonoboy;

public class CommandMaudit implements CommandExecutor {

    private Main main;

    public CommandMaudit(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	//if(main.isV2Actif()) {
    	
	    	Player player = (Player) sender;
	    	
	    	Joueur joueur = main.getJoueur(player);
	
	        if (args.length >= 3 || (main.getMode().equalsIgnoreCase("rapide") && args.length >= 2)) {
	
	            Player cible1_ = Bukkit.getPlayer(args[0]);
	            
	            Joueur cible1 = main.getJoueur(cible1_);
	            
	            Player cible2_ = Bukkit.getPlayer(args[1]);
	            
	            Joueur cible2 = main.getJoueur(cible2_);
	            
	            int niveau;
	            
	            if(main.getMode().equalsIgnoreCase("rapide")) {
	            	niveau = Integer.parseInt(args[1]);
	            }
	            else {
	            	niveau = Integer.parseInt(args[2]);
	            }
	
	            if ((cible1 != null && cible2 != null && args[2] != null && niveau > 0 && niveau < 4) || (cible1 != null && args[1] != null && niveau > 0 && niveau < 4)) {
	
	                if ((joueur.getRole() == Roles.NONOBOY && main.getVersion() == 2) || (joueur.getRole() == Roles.Malediction && main.getVersion() == 1)) {
	
	                    if (main.getNiv_maledition() == 0) {
	                    	
	                    	if(!main.getMode().equalsIgnoreCase("rapide")) {
	                    		
	                    		if(joueur.getRole() == Roles.NONOBOY && main.getVersion() == 2) {
	                    	
	                    			Nonoboy.CommandMaudit(joueur, cible1, cible2, main, niveau);
	                    		
	                    		}
	                    		else {
	                    			
	                    			Malediction.CommandMaudit(joueur, cible1, cible2, main, niveau);
	                    			
	                    		}
	                    		
	                    	}
	                    	else {
	                    		
	                    		if(joueur.getRole() == Roles.NONOBOY && main.getVersion() == 2) {
	    	                    	
	                    			Nonoboy.CommandMauditRapide(joueur, cible1, main, niveau);
	                    		
	                    		}
	                    		else {
	                    			
	                    			Malediction.CommandMauditRapide(joueur, cible1, main, niveau);
	                    			
	                    		}
	                    		
	                    	}
	
	                    } else {
	
	                        player.sendMessage("Vous avez déjà une malédiction en cours");
	
	                    }
	
	                } else {
	
	                    player.sendMessage("Vous n'avez pas le bon rôle");
	
	                }
	
	            } else {
	
	                player.sendMessage("Merci de mettre un pseudo valide");
	
	            }
	
	        } else {
	
	            player.sendMessage("Merci de donner le pseudo de la cible (/rcmaudit <pseudo1> <pseudo2> <1|2|3>");
	
	        }
	        
    	//}

        return false;

    }

}
