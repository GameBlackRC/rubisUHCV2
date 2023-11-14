package fr.gameblack.rcuhcv2.commands.global.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;

public class CommandSetOrbe implements CommandExecutor {
	
	private Main main;
	
	public CommandSetOrbe(Main main) {
		
		this.main = main;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
	
	        if (args.length != 0 && args[0].equalsIgnoreCase("eau")) {
	
	            if (joueur.getOrbe() == Orbe.EAU) {
	
	                Eau.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FEU) {
	
	                Feu.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FOUDRE) {
	
	                Foudre.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.GLACE) {
	
	                Glace.Passif(joueur, main, false);
	
	            }
	
	            joueur.setOrbe(Orbe.EAU);
	            Eau.Passif(joueur, main, true);
	            player.sendMessage("Vous avez reçu §9l'orbe d'eau§r");
	
	        } else if (args.length != 0 && args[0].equalsIgnoreCase("feu")) {
	
	            if (joueur.getOrbe() == Orbe.EAU) {
	            	
	                Eau.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FEU) {
	
	                Feu.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FOUDRE) {
	
	                Foudre.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.GLACE) {
	
	                Glace.Passif(joueur, main, false);
	
	            }
	
	            joueur.setOrbe(Orbe.FEU);
	            Feu.Passif(joueur, main, true);
	            player.sendMessage("Vous avez reçu §cl'orbe de feu§r");
	
	        } else if (args.length != 0 && args[0].equalsIgnoreCase("glace")) {
	
	            if (joueur.getOrbe() == Orbe.EAU) {
	            	
	                Eau.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FEU) {
	
	                Feu.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FOUDRE) {
	
	                Foudre.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.GLACE) {
	
	                Glace.Passif(joueur, main, false);
	
	            }
	
	            joueur.setOrbe(Orbe.GLACE);
	            Glace.Passif(joueur, main, true);
	            player.sendMessage("Vous avez reçu §bl'orbe de glace§r");
	
	        } else if (args.length != 0 && args[0].equalsIgnoreCase("foudre")) {
	
	            if (joueur.getOrbe() == Orbe.EAU) {
	            	
	                Eau.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FEU) {
	
	                Feu.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.FOUDRE) {
	
	                Foudre.Passif(joueur, main, false);
	
	            } else if (joueur.getOrbe() == Orbe.GLACE) {
	
	                Glace.Passif(joueur, main, false);
	
	            }
	
	            joueur.setOrbe(Orbe.FOUDRE);
	            Foudre.Passif(joueur, main, true);
	            player.sendMessage("Vous avez reçu §el'orbe de foudre§r");
	
	        }
	        else {
	        	
	        	player.sendMessage("Merci de mettre une orbe valide (§b/giveorbe <eau|feu|foudre|glace>§r)");
	        	
	        }
	        
		//}
        
        return false;
		
	}

}
