package fr.gameblack.rubisuhc.task;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.State;

public class Autostart extends BukkitRunnable{
	
	private Main main;
	
	public Autostart(Main main) {
		this.main = main;
	}
	
	private int timer = 10;

	@Override
	public void run() {
		
		for(Player pls : main.getPlayers()) {
			pls.setLevel(timer);
		}
		
		if(timer == 30 || timer == 20 || timer == 15 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
			for(Player pls : main.getPlayers()) {
				pls.sendMessage("Lancement du jeu dans : §e" + timer + "§6s");
			}
		}
		
		if(timer == 0) {
			
			for(Player pls : main.getPlayers()) {
				
				pls.setGameMode(GameMode.SURVIVAL);
				
				pls.setMaxHealth(20);
				
				pls.setFoodLevel(20);
				
				pls.setHealth(20);
				
				pls.getInventory().clear();
				
				pls.setExp(10000);
				
				if(pls.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) pls.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				if(pls.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) pls.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				if(pls.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) pls.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				if(pls.hasPotionEffect(PotionEffectType.SPEED)) pls.removePotionEffect(PotionEffectType.SPEED);
				if(pls.hasPotionEffect(PotionEffectType.WEAKNESS)) pls.removePotionEffect(PotionEffectType.WEAKNESS);
				if(pls.hasPotionEffect(PotionEffectType.SLOW)) pls.removePotionEffect(PotionEffectType.SLOW);
				if(pls.hasPotionEffect(PotionEffectType.FAST_DIGGING)) pls.removePotionEffect(PotionEffectType.FAST_DIGGING);
				if(pls.hasPotionEffect(PotionEffectType.JUMP)) pls.removePotionEffect(PotionEffectType.JUMP);
				if(pls.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) pls.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				if(pls.hasPotionEffect(PotionEffectType.INVISIBILITY)) pls.removePotionEffect(PotionEffectType.INVISIBILITY);
				
				ItemStack bottes = new ItemStack(Material.DIAMOND_BOOTS, 1);
				ItemMeta bottesM = bottes.getItemMeta();
				bottesM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
				bottes.setItemMeta(bottesM);
				
				pls.getInventory().setBoots(bottes);
				
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemMeta chestplateM = chestplate.getItemMeta();
				chestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
				chestplate.setItemMeta(chestplateM);
				
				pls.getInventory().setChestplate(chestplate);
				
				ItemStack jambiere = new ItemStack(Material.IRON_LEGGINGS, 1);
				ItemMeta jambiereM = jambiere.getItemMeta();
				jambiereM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				jambiere.setItemMeta(jambiereM);
				
				pls.getInventory().setLeggings(jambiere);
				
				ItemStack casque = new ItemStack(Material.IRON_HELMET, 1);
				ItemMeta casqueM = casque.getItemMeta();
				casqueM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				casque.setItemMeta(casqueM);
				
				pls.getInventory().setHelmet(casque);
				
				ItemStack arc = new ItemStack(Material.BOW, 1);
				ItemMeta arcM = arc.getItemMeta();
				arcM.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
				arc.setItemMeta(arcM);
				
				pls.getInventory().setHelmet(casque);
				
				ItemStack epee = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta epeeM = epee.getItemMeta();
				epeeM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
				epee.setItemMeta(epeeM);
				
				ItemStack epee_ = new ItemStack(Material.BOW, 1);
				ItemMeta epee_M = epee_.getItemMeta();
				epee_M.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
				epee_.setItemMeta(epee_M);
				epee_.setItemMeta(epee_M);
				
				pls.getInventory().addItem(epee);
				
				pls.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
				pls.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
				pls.getInventory().addItem(new ItemStack(Material.ANVIL, 1));
				pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				pls.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 32));
				
				main.addInvulnerable(pls);
				
				Random r = new Random();
				int signe_x = r.nextInt(2);
				int signe_y = r.nextInt(2);
				int cos_x = r.nextInt(800);
				cos_x += 200;
				if(signe_x == 1) {
					cos_x = -cos_x;
				}
				
				int cos_y = r.nextInt(800);
				cos_y += 200;
				if(signe_y == 1) {
					cos_y = -cos_y;
				}
				
				pls.teleport(new Location(Bukkit.getWorld("world"), cos_x, 100, cos_y));
				
			}
			
			main.setState(State.PVP_OFF);
			
			Bukkit.getScheduler().runTaskAsynchronously(main, ()-> {
				
				GameCycle cycle = new GameCycle(main);
				cycle.runTaskTimer(main, 0, 2);
				
			});
			
			cancel();
		}
		
		timer--;
		
	}
	public static ItemStack getItem(Material material, String customName, String desc) {
		ItemStack it = new ItemStack(material,1);
		ItemMeta itM = it.getItemMeta();
		if(customName != null) itM.setDisplayName(customName);
		itM.setLore(Arrays.asList(desc.split(";")));
		itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		it.setItemMeta(itM);
		return it;
	}

}
