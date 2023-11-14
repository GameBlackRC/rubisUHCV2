package fr.gameblack.rcuhcv2.listener.v2;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.evenement.v2.Minerais;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Joko;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Hekow;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;
import fr.gameblack.rcuhcv2.roles.v2.staff.Team;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Malivol;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Obscur;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Theoochoux;

public class InteractItemV2 {
	
	@SuppressWarnings("deprecation")
	public static void whenInteract(Joueur joueur, ItemStack it, Action action, Main main) {
		
		Player player = joueur.getPlayer();
	
        if (it.getTypeId() == 351 && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Cheat")) {

            Malivol.InteractCheat(joueur, main, true);

        } else if (it.getTypeId() == 351 && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Rage")) {

            Raptor.ItemRage(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Pactes")) {

            Slup.interactPacte(joueur);

        } else if (it.getTypeId() == 351 && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Slimetification")) {

            if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            	
            	Slup.interactGaucheSlime(joueur);
            	
            }
            else if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            	
            	Slup.interactDroitSlime(joueur, main);
            	
            } 

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Benihime Aratame")) {

            Trial.ItemBenihimeAratame(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Justice")) {

            Team.InteractJusticeStaff(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Sakashima Yokoshima")) {

            Trial.ItemSakashimaYokoshima(joueur, main);

        } else if (it.getTypeId() == 351 && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("SpeedCubing")) {

            Joko.InteractSpeedcubing(joueur, main);

        } else if (it.getTypeId() == 351 && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Fuite")) {

            GameBlack.InteractFuite(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Adaption")) {

            Obscur.InteractAdaption(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("RollBack")) {

            Theoochoux.interactRollback(main, joueur);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Jeu meurtrier")) {

            Hekow.interactJeu(joueur, main);

        } else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Super bateau")) {

        	if(!main.getCD().contains(Pouvoirs.LOUP_SUPERBATEAU)) {
        		
        		Loup.ItemSuperBateau(joueur, main);
        		
        	}

        } else if (it.getType() == Material.GLOWSTONE_DUST) {

            Minerais.InteractItemTopaze(joueur, main);

        } else if (it.getType() == Material.NETHER_BRICK_ITEM) {

            Minerais.InteractItemRubis(joueur, main);

        } else if (it.getType() == Material.QUARTZ) {

            Minerais.InteractItemRubisBleu(joueur, main);

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
