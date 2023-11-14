package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.VolTrial;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class TrialV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        joueur.addForce(0.15);
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Bankai");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);

    }
    
    public static void InteractBankai(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        if (!main.getCD().contains(Pouvoirs.TRIAL_BANKAI)) {

            main.getCD().add(Pouvoirs.TRIAL_BANKAI);

            joueur.addForce(0.07);
            
            if(player.hasPotionEffect(PotionEffectType.SPEED)) {
        		
        		player.removePotionEffect(PotionEffectType.SPEED);
        		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1, false, false));
        		
        	}
            else {
            	
            	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1, false, false));
            	
            }
            ItemCD cycle = new ItemCD(main, joueur, "bankai", 150, joueur, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
            if (main.getJoueurByRole(Roles.Slup) != null) {

                Player slup = main.getJoueurByRole(Roles.Slup).getPlayer();

                slup.sendMessage("Trial a utilisé son item 'Bankai'");

            }

        } else {

            player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void CommandBroken(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        if(player.getInventory().contains(Material.NETHER_STAR)) {
        	
        	player.getInventory().remove(Material.NETHER_STAR);
        	joueur.addForce(0.07);
        	if(player.hasPotionEffect(PotionEffectType.SPEED)) {
        		
        		player.removePotionEffect(PotionEffectType.SPEED);
        		
        	}
        	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false, false));
        	player.setMaxHealth(player.getMaxHealth()-5);
        	player.sendMessage("Vous venez de casser votre item, vous recevez donc 7% de force et speed II permanent");
        	
        }
        else {
        	
        	player.sendMessage("Votre item est déjà cassé");
        	
        }

    }
    
    public static void CommandSteal(Player player, Main main) {
    	
    	
    	
    }
    
    public static void InteractObsidian(Joueur joueur, Main main, Boolean sacrifice) {
    	
    	Player player = joueur.getPlayer();
    	
    	if(sacrifice) {
    		player.setMaxHealth(player.getMaxHealth()-4);
    		joueur.getVolTrial().add(VolTrial.SLUP);
    		if(!main.isDay()) {
    			
    			joueur.addForce(0.05);
    			
    		}
    		
    	}
    	else {
    		
    		joueur.getVolTrial().add(VolTrial.OK);
    		
    	}
    	joueur.addResi(0.1);
    	
    }
    
    public static void InteractCasqueDiams(Joueur joueur, Main main, int sacrifice) {
    	
    	Player player = joueur.getPlayer();
    	
    	joueur.getVolTrial().add(VolTrial.OBSCUR);
    		
    		Random r = new Random();
            int nb = r.nextInt(5);
            
            player.setMaxHealth(player.getMaxHealth()-(1.5*sacrifice));
            
            for (int i = 0; i < nb+3; i++) {
            	
            	nb = r.nextInt(5);
            
	            //if(nb == 1) {
	            	
	            	//if(!main.getTrialVolObscur().contains("casque")) {
	            		//main.addTrialVolObscur("casque");
	            	//}
	            	//else {
	            		
	            		//i -= 1;
	            		
	            	//}
	            	
	            //}
	            //else if(nb == 2) {
	            	
	            	//if(!main.getTrialVolObscur().contains("plastron")) {
	            		//main.addTrialVolObscur("plastron");
	            	//}
	            	//else {
	            		
	            		//i -= 1;
	            		
	            	//}
	            	
	            //}
	            //else if(nb == 3) {
	            	
	            	//if(!main.getTrialVolObscur().contains("jambiere")) {
	            		//main.addTrialVolObscur("jambiere");
	            	//}
	            	//else {
	            		
	            		//i -= 1;
	            		
	            	//}
	            	
	            //}
	            //else if(nb == 4) {
	            	
	            	//if(!main.getTrialVolObscur().contains("bottes")) {
	            		//main.addTrialVolObscur("bottes");
	            	//}
	            	//else {
	            		
	            		//i -= 1;
	            		
	            	//}
	            	
	            //}
	            //else {
	            	
	            	//if(!main.getTrialVolObscur().contains("epee")) {
	            		//main.addTrialVolObscur("epee");
	            	//}
	            	//else {
	            		
	            		//i -= 1;
	            		
	            	//}
	            	
	            //}
	            
            }
    	
    }
    
    public static void InteractDiamond(Joueur joueur, Main main, Boolean sacrifice) {
    	
    	Player player = joueur.getPlayer();
    	
    	joueur.getVolTrial().add(VolTrial.MALIVOL);
    	if(sacrifice) {
    		
    		player.setMaxHealth(player.getMaxHealth()-4);
    		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("Cheat");
            coffre.setItemMeta(coffreM);

            player.getInventory().addItem(coffre);
    		
    	}
    	else {
    		
    		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("Cheat (30 secondes)");
            coffre.setItemMeta(coffreM);

            player.getInventory().addItem(coffre);
    		
    	}
    	
    }
    
    public static void InteractApple(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.ANGE);
    	ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Shop");
        coffre.setItemMeta(coffreM);

        joueur.getPlayer().getInventory().addItem(coffre);
    	
    }
    
    public static void InteractIron(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.AVENIR);
    	joueur.setRespawn(true);
    	
    }
    
    public static void InteractPortal(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.COSMOS);
    	
    }
    
    public static void InteractBlaze(Joueur joueur, Main main) {
    	
    	joueur.addSpeed(0.15);
    	joueur.getVolTrial().add(VolTrial.OK);
    	
    }
    
    public static void InteractFlint(Joueur joueur, Main main, boolean sacrifice) {
    	
    	if(sacrifice) {
    		
    		joueur.getVolTrial().add(VolTrial.ENFER_SACRIFICE);
    		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-4);
    		
    	}
    	else {
    	
    		joueur.getVolTrial().add(VolTrial.ENFER);
    		
    	}
    	
    }
    
    public static void InteractSoulsand(Joueur joueur, Main main, boolean sacrifice) {
    	
    	if(sacrifice) {
    		
    		joueur.getVolTrial().add(VolTrial.MALEDICTION_SACRIFICE);
    		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-4);
    		
    	}
    	else {
    	
    		joueur.getVolTrial().add(VolTrial.MALEDICTION);
    		
    	}
    	
    }
    
    public static void InteractTorch(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.SANG);
    	
    }
    
    public static void InteractAxe(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.TRONCONNEUSE);
    	
    }
    
    public static void InteractCoal(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.TENEBRE);
    	
    }
    
    public static void InteractNetherrack(Joueur joueur, Main main) {
    	
    	joueur.getVolTrial().add(VolTrial.DEMON);
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §cTrial\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l’effet §9force I§r la nuit\n \nVous pouvez communiquer avec Slup avec la commande §b/rcmsg§r\n \nSi vous parvenez à tuer Raptor, vous gagnez l'effet §9résistance I§r permanent\n \nSi vous parvenez à tuer Kzou, vous gagnez l'effet §9speed I§r permanent\n \nA chaque kill, vous recevez 1 demi-coeur en plus\n \nSi vous croisez Kzou dans les 5 dernières minutes, vous recevrez l'effet §9nausée§r pendant 5 secondes\n \nA l'annonce des rôles, vous recevez un item nommé 'Bankai' vous permettant de recevoir les effets §9speed II§r et §97% de force§r pendant 2 minutes 30 \n \nAvec la commande §b/rcbroken§r, vous pouvez casser votre item qui seras alors supprimer de votre inventaire. Vous recevrez alors en échange de 2,5 cœurs permanent, les effets de l’item de façon permanente\n \nAvec la commande §b/rcsteal§r, vous pourrez, en échange de cœurs permanent, récupérer un pouvoir d’un démon mort 1 fois dans la partie\n \n____________________________________________________");

    }

}