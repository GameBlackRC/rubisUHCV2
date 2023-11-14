package fr.gameblack.rcuhcv2.listener.v1;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.roles.v1.demons.Cosmos;
import fr.gameblack.rcuhcv2.roles.v1.demons.Electrique;
import fr.gameblack.rcuhcv2.roles.v1.demons.Enfer;
import fr.gameblack.rcuhcv2.roles.v1.demons.MalivolV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.TrialV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.Tronconeuse;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.JokoV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.LoupV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.MakaV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.RaptorV1;

public class InteractItemV1 {
	
	public static void whenInteract(Joueur joueur, ItemStack it, Action action, Main main) {
		
		Player player = joueur.getPlayer();
	
        if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Cheat")) {

            MalivolV1.InteractCheat(joueur, main, true);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Rage")) {

            RaptorV1.InteractRage(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Camouflage")) {

            GameBlackV1.InteractCamouflage(joueur, main);

        }  else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("SpeedCubing")) {

            JokoV1.InteractSpeedcubing(joueur, main);

        }  else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Transformation")) {

            LoupV1.InteractLoup(joueur, main);

        }  else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Furreur du dragon")) {

            MakaV1.InteractDragon(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Bankai")) {

            TrialV1.InteractBankai(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Affuter ses lames")) {

            Tronconeuse.InteractLame(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Zone de speed")) {

            Cosmos.InteractZone(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Foudre")) {

            Electrique.InteractFoudre(player, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Zone de feu")) {

            Enfer.InteractFeu(joueur, main);

        } else if (it.getType() == Material.SLIME_BALL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4Orbe") && joueur.getOrbe() == Orbe.NONE) {
        	
        	Random r = new Random();
        	
        	int nb_ = r.nextInt(4);

            if (nb_ == 1) {
                
                if(joueur.getRole() != Roles.MALIVOL) {
	                
	            	joueur.setOrbe(Orbe.EAU);
	            	Eau.Passif(joueur, main, true);
	                player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
    	            	joueur.setOrbe(Orbe.FEU);
    	            	Feu.Passif(joueur, main, true);
    	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			joueur.setOrbe(Orbe.FOUDRE);
            			Foudre.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			joueur.setOrbe(Orbe.GLACE);
            			Glace.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 2) {

            	nb_ = r.nextInt(3);
            	
            	if(joueur.getRole() != Roles.MAKA) {
            	
	            	joueur.setOrbe(Orbe.FEU);
	            	Feu.Passif(joueur, main, true);
	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			joueur.setOrbe(Orbe.EAU);
            			Eau.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			joueur.setOrbe(Orbe.FOUDRE);
            			Foudre.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			joueur.setOrbe(Orbe.GLACE);
            			Glace.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 3) {

            	joueur.setOrbe(Orbe.FOUDRE);
            	Foudre.Passif(joueur, main, true);
                player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");

            } else {

            	joueur.setOrbe(Orbe.GLACE);
            	Glace.Passif(joueur, main, true);
                player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");

            }
            
            player.getInventory().remove(it);
        	
        }
		
	}

}
