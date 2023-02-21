package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.orbes.Eau;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Electrique {
	
	public static void Items(Player player) {
		
		Texte(player);
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Foudre");
		coffre.setItemMeta(coffreM);
		
		player.getInventory().addItem(coffre);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
	}
	
	public static void InteractFoudre(Player player, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.ELECTRIQUE_FOUDRE)) {
			
			main.getCD().add(Pouvoirs.ELECTRIQUE_FOUDRE);
			
			if(main.getRoles().contains(Roles.SLUP)) {
				
				Player slup = main.getPlayerByRole(Roles.SLUP);
				
				slup.sendMessage("Le démon Electrique a utilisé son item 'Foudre'");
				
			}
		
			if(player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);
			
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));
			
			for(Entity nearbyEntities : player.getNearbyEntities(20, 20, 20)) {
			
				if(nearbyEntities instanceof Player) {
					
					Player cible = (Player) nearbyEntities;
				
					if(!main.GetCampsDemon().contains(main.getRole(cible))) {
					
						Bukkit.getWorld("world").strikeLightning(cible.getLocation());
						
						cible.setFireTicks(0);
						
						if(main.getOrbe(cible) == Orbe.EAU  && !main.isOrbeMalus(cible)) {
							
							Eau.Malus(cible, main);
							
						}
						
					}
					
				}
			
			}
			
		}
		else {
			
			player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");
			
		}
		
	}
	
	public static void CommandSacrifice(Player player, Main main) {
		
		main.setNofallElec(true);
		
		if(player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3600, 1, false, false));
		
		main.addPourcentEffet(player, "force", 0.15);
		
		player.setMaxHealth(player.getMaxHealth() - 2);
		
		ItemCD cycle = new ItemCD(main, player, "sacrifice", 180, player, null, null);
		cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Electrique\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent\n \nA l'annonce des rôles, vous recevez un item nommé 'Foudre' vous permettant de lancer des éclairs sur tous les joueurs du camps rc dans la zone qui vous donne speed II pendant 1 minute\n \nAvec la commande /rcsacrifice, vous perdez un coeur permanent et les effets force I, speed II et no fall pendant 2 minutes\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
