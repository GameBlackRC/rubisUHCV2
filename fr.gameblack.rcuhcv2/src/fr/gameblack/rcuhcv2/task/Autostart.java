package fr.gameblack.rcuhcv2.task;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.GameCycle;
import fr.gameblack.rcuhcv2.task.v1.GameCycleV1;

public class Autostart extends BukkitRunnable {
	
	private Main main;
    private int timer = 10;
    private Scoreboard board_base;
    
    private Scoreboard board_pourcent;

    public Autostart(Main main, Scoreboard board_base, Scoreboard board_pourcent) {
        this.main = main;
        this.board_base = board_base;
        this.board_pourcent = board_pourcent;
    }
    
    @Override
    public void run() {
    	
    	for (Joueur pls : main.getListJoueurs()) {
            pls.getPlayer().setLevel(timer);
        }
    	
        if (timer == 30 || timer == 20 || timer == 15 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
            for (Joueur pls : main.getListJoueurs()) {
                pls.getPlayer().sendMessage("Lancement du jeu dans : §e" + timer + "§6s");
            }
        }
    	
        else if(timer == 0) {
        	
        	Random r = new Random();
            int signe_x = r.nextInt(2);
            int signe_z = r.nextInt(2);
            int cos_x = r.nextInt(100);
            cos_x += 200;
            if (signe_x == 1) {
                cos_x = -cos_x;
            }

            int cos_z = r.nextInt(100);
            cos_z += 200;
            if (signe_z == 1) {
                cos_z = -cos_z;
            }

            for (Joueur j : main.getListJoueurs()) {
            	
            	if(main.getScenarios().contains(Scenarios.CATS_EYES)) {
            	
            		j.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1, false, false));
            		
            	}
            	
            	j.getPlayer().setFlying(false);
            	j.getPlayer().setAllowFlight(false);
                
                World world;
                
                if(main.getWorld() == null) {
                	
                	world = Bukkit.getWorld("world");
                	
                }
                else {
                	
                	world = main.getWorld();
                	
                }
            	
            	Player pls = j.getPlayer();

                pls.setGameMode(GameMode.SURVIVAL);

                pls.setMaxHealth(20);

                pls.setFoodLevel(20);

                pls.setHealth(20);

                pls.getInventory().clear();

                if (pls.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
                    pls.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                if (pls.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
                    pls.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                if (pls.hasPotionEffect(PotionEffectType.HEALTH_BOOST))
                    pls.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                if (pls.hasPotionEffect(PotionEffectType.SPEED)) pls.removePotionEffect(PotionEffectType.SPEED);
                if (pls.hasPotionEffect(PotionEffectType.WEAKNESS)) pls.removePotionEffect(PotionEffectType.WEAKNESS);
                if (pls.hasPotionEffect(PotionEffectType.SLOW)) pls.removePotionEffect(PotionEffectType.SLOW);
                if (pls.hasPotionEffect(PotionEffectType.FAST_DIGGING))
                    pls.removePotionEffect(PotionEffectType.FAST_DIGGING);
                if (pls.hasPotionEffect(PotionEffectType.JUMP)) pls.removePotionEffect(PotionEffectType.JUMP);
                if (pls.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
                    pls.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                if (pls.hasPotionEffect(PotionEffectType.INVISIBILITY))
                    pls.removePotionEffect(PotionEffectType.INVISIBILITY);
                if (pls.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))
                    pls.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                
                if(main.getMode().equalsIgnoreCase("rapide")) {
                	
                	int cos_y = world.getHighestBlockYAt(cos_x, cos_z);

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
	                jambiereM.addEnchant(Enchantment.DURABILITY, 3, false);
	                jambiere.setItemMeta(jambiereM);
	
	                pls.getInventory().setLeggings(jambiere);
	
	                ItemStack casque = new ItemStack(Material.IRON_HELMET, 1);
	                ItemMeta casqueM = casque.getItemMeta();
	                casqueM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
	                casqueM.addEnchant(Enchantment.DURABILITY, 3, false);
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
	                epee_M.addEnchant(Enchantment.ARROW_DAMAGE, 2, false);
	                epee_.setItemMeta(epee_M);
	
	                pls.getInventory().addItem(epee);
	                pls.getInventory().addItem(epee_);
	
	                pls.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 32));
	                pls.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
	                pls.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	                pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 2));
	                pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
	                pls.getInventory().addItem(new ItemStack(Material.WORKBENCH, 1));
	                pls.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));

	                pls.teleport(new Location(world, cos_x, cos_y, cos_z));
	                
            	}
                else if(main.getMode().equalsIgnoreCase("meetup")) {
                	
                	System.out.println("Mode meetup detecter");
                	
                	int cos_y = world.getHighestBlockYAt(cos_x, cos_z);
                	
                	signe_x = r.nextInt(2);
	                signe_z = r.nextInt(2);
	                cos_x = r.nextInt(400);
	                cos_x += 200;
	                if (signe_x == 1) {
	                    cos_x = -cos_x;
	                }

	                cos_z = r.nextInt(400);
	                cos_z += 200;
	                if (signe_z == 1) {
	                    cos_z = -cos_z;
	                }
                	
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
	                jambiereM.addEnchant(Enchantment.DURABILITY, 3, false);
	                jambiere.setItemMeta(jambiereM);
	
	                pls.getInventory().setLeggings(jambiere);
	
	                ItemStack casque = new ItemStack(Material.IRON_HELMET, 1);
	                ItemMeta casqueM = casque.getItemMeta();
	                casqueM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
	                casqueM.addEnchant(Enchantment.DURABILITY, 3, false);
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
	                epee_M.addEnchant(Enchantment.ARROW_DAMAGE, 2, false);
	                epee_.setItemMeta(epee_M);
	
	                pls.getInventory().addItem(epee);
	                pls.getInventory().addItem(epee_);
	
	                pls.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 32));
	                pls.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
	                pls.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	                pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 2));
	                pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
	                pls.getInventory().addItem(new ItemStack(Material.WORKBENCH, 1));
	                pls.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));

	                pls.teleport(new Location(world, cos_x, cos_y, cos_z));
                	
                }
                else {
	
	                ItemStack epee_ = new ItemStack(Material.IRON_PICKAXE, 1);
	                ItemMeta epee_M = epee_.getItemMeta();
	                epee_M.addEnchant(Enchantment.DIG_SPEED, 4, false);
	                epee_.setItemMeta(epee_M);
	                
	                pls.getInventory().addItem(epee_);
	
	                pls.getInventory().addItem(new ItemStack(Material.BOOK, 10));
	                pls.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
	                pls.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	                pls.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
	                pls.getInventory().addItem(new ItemStack(Material.WOOD, 64));
	                pls.getInventory().addItem(new ItemStack(Material.APPLE, 64));
	                pls.getInventory().addItem(new ItemStack(Material.ICE, 2));
	                
	                int cos_y = world.getHighestBlockYAt(cos_x, cos_z);
	                
	                signe_x = r.nextInt(2);
	                signe_z = r.nextInt(2);
	                cos_x = r.nextInt(800);
	                cos_x += 200;
	                if (signe_x == 1) {
	                    cos_x = -cos_x;
	                }

	                cos_z = r.nextInt(800);
	                cos_z += 200;
	                if (signe_z == 1) {
	                    cos_z = -cos_z;
	                }

	                pls.teleport(new Location(world, cos_x, cos_y, cos_z));
                	
                }
                
                j.setInvulnerable(true);

            }
            
            if(main.getVersion() == 2) {
            
	            int nb = r.nextInt(100);
	            
	            if(nb <= 50) {
	            	
	            	main.setFermetureGolden(true);
	            	
	            }
	            
            }

            main.setState(Statut.PVP_OFF);
            
            if(main.getVersion() == 2) {
            
	            Scoreboard board_joko = Bukkit.getScoreboardManager().getNewScoreboard();
	            
	            Scoreboard board_farmeurimmo = Bukkit.getScoreboardManager().getNewScoreboard();
	            
	            Scoreboard board_game = Bukkit.getScoreboardManager().getNewScoreboard();
	
	            Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
	
	            	GameCycle cycle = new GameCycle(main, board_base, board_pourcent, board_game, board_joko, board_farmeurimmo);
		            cycle.runTaskTimer(main, 0, 2);
	
	            });
	            
        	}
            else if(main.getVersion() == 1) {
            	
	            Scoreboard board_gameblack = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_team = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_joko = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_toinou = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_maka = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_loup = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_raptor = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_guerrier = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_archer = Bukkit.getScoreboardManager().getNewScoreboard();
	            
	            Scoreboard board_trial = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_slup = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_malivol = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_obscur = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_ange = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_avenir = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_cosmos = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_demon = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_electrique = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_enfer = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_malediction = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_sang = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_tronconneuse = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_tenebre = Bukkit.getScoreboardManager().getNewScoreboard();
	            
	            Scoreboard board_experimental = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_farmeurimmo = Bukkit.getScoreboardManager().getNewScoreboard();
	            Scoreboard board_kzou = Bukkit.getScoreboardManager().getNewScoreboard();
	
	            Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
	
	            	GameCycleV1 cycle = new GameCycleV1(main, board_base, board_gameblack, board_team, board_joko, board_toinou, board_maka, board_loup, board_raptor, board_guerrier, board_archer, board_trial, board_slup, board_malivol, board_obscur, board_ange, board_avenir, board_cosmos, board_demon, board_electrique, board_enfer, board_malediction, board_sang, board_tronconneuse, board_tenebre, board_experimental, board_farmeurimmo, board_kzou);
		            cycle.runTaskTimer(main, 0, 2);
	
	            });
            	
            }
    		
    		cancel();
    		
    	}
    	
    	timer--;
    	
    }

}
