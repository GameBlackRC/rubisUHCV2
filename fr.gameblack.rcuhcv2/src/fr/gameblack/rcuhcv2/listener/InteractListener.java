package fr.gameblack.rcuhcv2.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.joueur.Joko;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Loup;
import fr.gameblack.rcuhcv2.roles.uhc.Malivol;

public class InteractListener implements Listener {

    private Main main;

    public InteractListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Joueur joueur = main.getJoueur(player);
        
        @SuppressWarnings("unused")
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it == null) return;

        else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Cheat")) {

            Malivol.InteractCheat(joueur, main, true);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Rage")) {

            Raptor.ItemRage(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Pactes")) {

            Slup.interactPacte(joueur);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Slimetification")) {

            if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            	
            	Slup.interactGaucheSlime(joueur);
            	
            }
            else if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            	
            	Slup.interactDroitSlime(joueur, main);
            	
            } 

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("SpeedCubing")) {

            Joko.InteractSpeedcubing(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Fuite")) {

            GameBlack.InteractFuite(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Super bateau")) {

        	if(!main.getCD().contains(Pouvoirs.LOUP_SUPERBATEAU)) {
        		
        		Loup.ItemSuperBateau(joueur, main);
        		
        	}

        } else if (it.getType() == Material.SLIME_BALL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4Orbe") && joueur.getOrbe() == Orbe.NONE) {
        	
        	Random r = new Random();
        	
        	int nb_ = r.nextInt(4);

            if (nb_ == 1) {

            	joueur.setOrbe(Orbe.EAU);
                player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");

            } else if (nb_ == 2) {

            	nb_ = r.nextInt(3);
            	
            	if(joueur.getRole() != Roles.MAKA) {
            	
	            	joueur.setOrbe(Orbe.FEU);
	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			joueur.setOrbe(Orbe.EAU);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			joueur.setOrbe(Orbe.FOUDRE);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			joueur.setOrbe(Orbe.GLACE);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 3) {

            	joueur.setOrbe(Orbe.FOUDRE);
                player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");

            } else {

            	joueur.setOrbe(Orbe.GLACE);
                player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");

            }
            
            player.getInventory().remove(it);
        	
        }

    }

}
