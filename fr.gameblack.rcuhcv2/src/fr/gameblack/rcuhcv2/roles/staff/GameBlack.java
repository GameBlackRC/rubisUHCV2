package fr.gameblack.rcuhcv2.roles.staff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class GameBlack {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
		
		joueur.addSpeed(0.05);
		joueur.getPlayer().getInventory().addItem(orbes);
		
	}
	
	public static void ItemsUHC(Joueur joueur, Main main) {
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Fuite");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
        
        TexteUHC(joueur.getPlayer());
        
        Random r = new Random();
        int nb = r.nextInt(100);
        
        if(nb <= 10) {
        	
        	joueur.getPlayer().sendMessage("Vous êtes touché par la malédiction de Gyomei");
        	joueur.addSpeed(0.02);
        	joueur.addSpeed(0.02);
        	
        	int nb_2 = r.nextInt(main.getListJoueurs().size());
        	while(main.getListJoueurs().get(nb_2).getCamp() == "uhc") {
        		
        		nb_2 = r.nextInt(main.getListJoueurs().size());
        		
        	}
	        main.setMaledictionGyomei(main.getListJoueurs().get(nb_2));
	        main.getMaledictionGyomei().getPlayer().sendMessage("Vous venez de recevoir " + joueur.getPlayer().getName() + " pour cible. SI vous parvenez à le tuer, vous recevrez 2% de force supplémentaire");
        	
        }
		
	}
	
	@SuppressWarnings("deprecation")
	public static void bedwarsLancement(Joueur joueur, Main main) {
		
		Block bloc1 = main.getWorld().getBlockAt(200, 100, 200);
		
		Block bloc2 = main.getWorld().getBlockAt(200, 100, -200);

        BlockState bedFoot = bloc1.getState();
        BlockState bedHead = bedFoot.getBlock().getRelative(BlockFace.SOUTH).getState();
        bedFoot.setType(Material.BED_BLOCK);
        bedHead.setType(Material.BED_BLOCK);
        bedFoot.setRawData((byte) 0x0);
        bedHead.setRawData((byte) 0x8);
        bedFoot.update(true, false);
        bedHead.update(true, true);
        
        BlockState bedFoot2 = bloc2.getState();
        BlockState bedHead2 = bedFoot2.getBlock().getRelative(BlockFace.SOUTH).getState();
        bedFoot2.setType(Material.BED_BLOCK);
        bedHead2.setType(Material.BED_BLOCK);
        bedFoot2.setRawData((byte) 0x0);
        bedHead2.setRawData((byte) 0x8);
        bedFoot2.update(true, false);
        bedHead2.update(true, true);
		
	}
	
	public static void InteractFuite(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
			
			joueur.setInvulnerable(true);
			joueur.addSpeed(0.1);
			for(Entity entity : joueur.getPlayer().getNearbyEntities(10, 10, 10)) {
				
				if(entity instanceof Player) {
					
					Player p = (Player) entity;
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100 , 0));
					
				}
				
			}
			
			main.getCD().add(Pouvoirs.GAMEBLACK_FUITE);
			
			ItemCD cycle = new ItemCD(main, joueur, "fuite", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}
	
	public static void commandChangeOrbe(Joueur joueur) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Choix de l'orbe");
    	
        inv_orbe.setItem(10, Main.getItem(Material.WATER_BUCKET, "Eau", ""));
        inv_orbe.setItem(12, Main.getItem(Material.LAVA_BUCKET, "Feu", ""));
        inv_orbe.setItem(14, Main.getItem(Material.ICE, "Glace", ""));
        inv_orbe.setItem(16, Main.getItem(Material.REDSTONE_BLOCK, "Foudre", ""));

        joueur.getPlayer().openInventory(inv_orbe);
		
	}
	
	public static void commandCheckOrbe(Joueur joueur, Joueur cible) {
		
		String orbe = null;
		
		if(cible.getOrbe() == Orbe.EAU) {
			
			orbe = "§1orbe d'eau";
			
		}
		else if(cible.getOrbe() == Orbe.FEU) {
			
			orbe = "§corbe de feu";
			
		}
		else if(cible.getOrbe() == Orbe.GLACE) {
			
			orbe = "§borbe de glace";
			
		}
		else if(cible.getOrbe() == Orbe.FOUDRE) {
			
			orbe = "§eorbe de foudre";
			
		}
		
		if(orbe == null) {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " ne possède pas d'orbe");
			
		}
		else {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " possède l'" + orbe);
			
		}
		
	}
	
	public static void CommandeClasse(Joueur joueur, Classe classe, Main main) {
		
		boolean orbe = false;
		
		if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
			
			Eau.RemoveEffets(joueur, main);
			orbe = true;
			
		}
		else if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbeActif()) {
			
			Feu.RemoveEffets(joueur, main);
			orbe = true;
			
		}
		else if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbeActif()) {
			
			Glace.RemoveEffets(joueur, main);
			orbe = true;
			
		}
		else if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
			
			Foudre.RemoveEffets(joueur, main);
			orbe = true;
			
		}
		
		if(classe == Classe.ATTAQUANT) {
			
			joueur.setForce(0.1);
			joueur.setResi(0.03);
			joueur.setSpeed(0);
			
		}
		else if(classe == Classe.DEFENSEUR) {
			
			joueur.setSpeed(-0.1);
			joueur.setResi(0.2);
			joueur.setForce(0);
			
		}
		else if(classe == Classe.DISTANCE) {
			
			joueur.setSpeed(0.05);
			joueur.setForce(-0.1);
			joueur.setResi(0.1);
			
		}
		else if(classe == Classe.RAPIDE) {
			
			joueur.setSpeed(0.15);
			joueur.setForce(-0.03);
			joueur.setResi(0.01);
			
		}
		else if(classe == Classe.SUPPORT) {
			
			joueur.setSpeed(0.05);
			joueur.setResi(0.08);
			joueur.setForce(0);
			
		}
		else if(classe == Classe.RIEN) {
			
			joueur.setSpeed(0);
			joueur.setResi(0.1);
			joueur.setForce(0);
			
		}
		
		if(orbe) {
			
			if(joueur.getOrbe() == Orbe.EAU) {
				
				Eau.Effets(joueur, main);
				
			}
			else if(joueur.getOrbe() == Orbe.FEU) {
				
				Feu.Effets(joueur, main);
				
			}
			else if(joueur.getOrbe() == Orbe.GLACE) {
				
				Glace.Effets(joueur, main);
				
			}
			else if(joueur.getOrbe() == Orbe.FOUDRE) {
				
				Foudre.Effets(joueur, main);
				
			}
			
		}
		
	}
	
	public static void CommandeBuff(Joueur joueur, Joueur cible, String buff, Main main) {
		
		if(buff.equalsIgnoreCase("coeur")) {
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
			cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()+2);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_coeur", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("force")) {
			
			joueur.removeForce(0.02);
			cible.addForce(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_force", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("resi")) {
			
			joueur.removeResi(0.02);
			cible.addResi(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_resi", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("speed")) {
			
			joueur.removeSpeed(0.05);
			cible.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_speed", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §9camp staff§r\n \nVous avez 5% de speed permanent et vous recevez une orbe à l'annonce des rôles\n \nSi vous venez à croiser Malivol avant Team ou Maka, vous passez dans le camp UHC\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec la commande /rccheckorbe <pseudo>, vous pouvez voir quelle orbe possède le joueur ciblé\n \nLorsque Kzou ban un joueur, vous recevez un message vous avertissant du ban et vous avez 25% de chance de connaître le pseudo du banni\n \nAvec la commande /rcconsole, vous pouvez voir la console pendant 30 secondes\nVous recevez un message pour chaque action parmi les suivants : un joueur frappe un autre joueur, un joueur tue un joueur, un joueur a un changemment d'effet, un joueur active son pouvoir.\nChaque action a une certaine chance d'avoir les pseudos brouiller\n \n____________________________________________________");

    }
	
	public static void TexteUHC(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §2camp UHC§r\n \nVous avez 5% de speed permanent\n \nSi l'évènement 'Fermeture de Golden' se déclanche, vous avez 50% de chance de passer dans le camp Joueur\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec l'item 'Fuite', vous devenez invulnérable et vous ne pouvez plus mettre de coup pendant 2 secondes\nVous recevez 10% de speed pendant 1 minute\nLes joueur proche de vous recevront l'effet blindness pendant 10 secondes\nSi Toinou est proche de vous lors de l'utilisation, il reçoit 2% de force pendant 1 minute\n \nA chaque coup d'épée subi, vous avez 5% de chance de recevoir 1% de speed supplémentaire permanent\n \n____________________________________________________");

    }
	
	public static void TexteJoueur(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §acamp joueur§r\n \nVous avez 5% de speed permanent\n \nSi l'évènement 'Fermeture de Golden' se déclanche, vous avez 50% de chance de passer dans le camp Joueur\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec l'item 'Fuite', vous devenez invulnérable et vous ne poupez plus mettre de coup pendant 2 secondes\nVous recevez 10% de speed pendant 1 minute\nLes joueur proche de vous recevront l'effet blindness pendant 10 secondes\nSi Toinou est proche de vous lors de l'utilisation, il reçoit 2% de force pendant 1 minute\n \nA chaque coup d'épée subi, vous avez 5% de chance de recevoir 1% de speed supplémentaire permanent\n \n____________________________________________________");

    }

}
