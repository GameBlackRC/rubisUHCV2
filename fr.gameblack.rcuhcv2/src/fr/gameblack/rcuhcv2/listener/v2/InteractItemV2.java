package fr.gameblack.rcuhcv2.listener.v2;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.Stats;
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
import fr.gameblack.rcuhcv2.roles.v2.staff.Yuri;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Malivol;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Obscur;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Theoochoux;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class InteractItemV2 {
	
	public static void whenInteract(Joueur joueur, ItemStack it, PlayerInteractEvent event, Main main) {
		
		Action action = event.getAction();
		
		Player player = joueur.getPlayer();
	
        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.MALIVOL_CHEAT.getNom())) {

            Malivol.InteractCheat(joueur, main, true);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.RAPTOR_RAGE.getNom())) {

            Raptor.ItemRage(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.SLUP_PACTES.getNom())) {

            Slup.interactPacte(joueur);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.SLUP_SLIME.getNom())) {

            if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            	
            	Slup.interactGaucheSlime(joueur);
            	
            }
            else if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            	
            	Slup.interactDroitSlime(joueur, main);
            	
            } 

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TRIAL_BENIHIME.getNom())) {

            Trial.ItemBenihimeAratame(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TRIAL_COLA.getNom())) {

            Trial.InteractBouteille(joueur);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TEAM_JUSTICE.getNom())) {

            Team.InteractJusticeStaff(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TRIAL_SAKASHIMA.getNom())) {

            Trial.ItemSakashimaYokoshima(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.JOKO_SPEEDCUBING.getNom())) {

            Joko.InteractSpeedcubing(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.GAMEBLACK_FUITE.getNom())) {

            GameBlack.InteractFuite(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.OBSCUR_ADAPTION.getNom())) {

            Obscur.InteractAdaption(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.THEOCHOUX_ROLLBACK.getNom())) {

        	if(joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.THEOOCHOUX_MINIROLLBACK)) {
        		
        		Theoochoux.interactRollBackPetit(main, joueur);
        		
        	}
        	else if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            	
            	Theoochoux.interactRollBackPetit(main, joueur);
            	
            }
            else if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            	Theoochoux.interactRollback(main, joueur);
            	
            } 

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.HEKOW_JEU.getNom())) {

            Hekow.interactJeu(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.ROMPREMS_PEARL.getNom())) {

            joueur.getPlayer().getInventory().setItemInHand(Main.getItemRole(ItRoles.ROMPREMS_EYE));
            
            int cd = 180;
            if(joueur.getNbKillEnderman() == 1) {
            	cd = 120;
            } else if(joueur.getNbKillEnderman() >= 2) {
            	cd = 60;            	
            }
            
            ItemCD cycle = new ItemCD(main, joueur, "romprems_pearl", cd, joueur, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);

        } else if (it.getType() == Material.EYE_OF_ENDER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.ROMPREMS_EYE.getNom())) {

            event.setCancelled(true);
            joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");

        } else if (it.getType() == Material.BOOK && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TOINOU_LIVRE.getNom())) {

            Toinou.InteractBook(joueur, main);

        } else if (it.getType() == Material.REDSTONE_BLOCK && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.TOINOU_TOTEM.getNom())) {

            Toinou.InteractTotem(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.YURI_AZIZ.getNom())) {
        	
        	event.setCancelled(true);
            Yuri.ItemAziz(joueur, main);

        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ItRoles.LOUP_BATEAU.getNom())) {

        	if(!joueur.getCD().contains(Pouvoirs.LOUP_SUPERBATEAU)) {
        		
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

            	nb_ = r.nextInt(3);
            	
            	if(joueur.getRole() != Roles.CAPTAIN) {
            	
            		joueur.setOrbe(Orbe.FOUDRE);
	            	Foudre.Passif(joueur, main, true);
	                player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			joueur.setOrbe(Orbe.EAU);
            			Eau.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			joueur.setOrbe(Orbe.FEU);
    	            	Feu.Passif(joueur, main, true);
    	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			joueur.setOrbe(Orbe.GLACE);
            			Glace.Passif(joueur, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else {

            	joueur.setOrbe(Orbe.GLACE);
            	Glace.Passif(joueur, main, true);
                player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");

            }
            
            player.getInventory().remove(it);
            
            main.setStat(Stats.ORBE, joueur);
        	
        }
		
	}

}
