package fr.gameblack.rcuhcv2.listener.v2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CompoV2 {
	
	@SuppressWarnings("deprecation")
	public static void getCompoJoueur(Player player, Main main, boolean gestion) {
		
		int slot = 18;
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", "")); 
        inv_compo.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
        inv_compo.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
        ItemStack rage = new ItemStack(351, 1, (short) 2);
        ItemMeta rageM = rage.getItemMeta();
        rageM.setDisplayName("§a Raptor");
        rage.setItemMeta(rageM);
        
        if(main.getCompo().contains(Roles.RAPTOR)) {
        	
        	rage.setAmount(1);
        	inv_compo.setItem(slot, rage);
        	slot += 1;
        	
        }
        else {
        	
        	rage.setAmount(0);
        	inv_compo.setItem(slot, rage);
        	slot += 1;
        	
        }
        
        ItemStack houe = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta houeM = houe.getItemMeta();
        houeM.setDisplayName("§a Jeannot");
        houe.setItemMeta(houeM);
        
        if(main.getCompo().contains(Roles.JEANNOT)) {
        	
        	houe.setAmount(1);
        	inv_compo.setItem(slot, houe);
        	slot += 1;
        	
        }
        else {
        	
        	houe.setAmount(0);
        	inv_compo.setItem(slot, houe);
        	slot += 1;
        	
        }
        
        ItemStack paper = new ItemStack(Material.PAPER, 1);
        ItemMeta paperM = paper.getItemMeta();
        paperM.setDisplayName("§a Nickoboop");
        paper.setItemMeta(paperM);
        
        if(main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	paper.setAmount(1);
        	inv_compo.setItem(slot, paper);
        	slot += 1;
        	
        }
        else {
        	
        	paper.setAmount(0);
        	inv_compo.setItem(slot, paper);
        	slot += 1;
        	
        }
        
        ItemStack slime = new ItemStack(351, 1, (short) 11);
        ItemMeta slimeM = slime.getItemMeta();
        slimeM.setDisplayName("§a Slup");
        slime.setItemMeta(slimeM);
        
        if(main.getCompo().contains(Roles.SLUP)) {
        	
        	slime.setAmount(1);
        	inv_compo.setItem(slot, slime);
        	slot += 1;
        	
        }
        else {
        	
        	slime.setAmount(0);
        	inv_compo.setItem(slot, slime);
        	slot += 1;
        	
        }
        
        ItemStack cube = new ItemStack(351, 1, (short) 13);
        ItemMeta cubeM = cube.getItemMeta();
        cubeM.setDisplayName("§a Joko");
        cube.setItemMeta(cubeM);
        
        if(main.getCompo().contains(Roles.JOKO)) {
        	
        	cube.setAmount(1);
        	inv_compo.setItem(slot, cube);
        	slot += 1;
        	
        }
        else {
        	
        	cube.setAmount(0);
        	inv_compo.setItem(slot, cube);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void getCompoStaff(Player player, Main main, boolean gestion) {
		
		int slot = 18;
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", "")); 
        inv_compo.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
        inv_compo.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
        ItemStack team = new ItemStack(Material.GLASS, 1);
        ItemMeta teamM = team.getItemMeta();
        teamM.setDisplayName("§9 Team");
        team.setItemMeta(teamM);
        
        if(main.getCompo().contains(Roles.TEAM)) {
        	
        	team.setAmount(1);
        	inv_compo.setItem(slot, team);
        	slot += 1;
        	
        }
        else {
        	
        	team.setAmount(0);
        	inv_compo.setItem(slot, team);
        	slot += 1;
        	
        }
        
        ItemStack fuite = new ItemStack(351, 1, (short) 6);
        ItemMeta fuiteM = fuite.getItemMeta();
        fuiteM.setDisplayName("§9 GameBlack");
        fuite.setItemMeta(fuiteM);
        
        if(main.getCompo().contains(Roles.GAMEBLACK)) {
        	
        	fuite.setAmount(1);
        	inv_compo.setItem(slot, fuite);
        	slot += 1;
        	
        }
        else {
        	
        	fuite.setAmount(0);
        	inv_compo.setItem(slot, fuite);
        	slot += 1;
        	
        }
        
        ItemStack rose = new ItemStack(Material.RED_ROSE, 1);
        ItemMeta roseM = rose.getItemMeta();
        roseM.setDisplayName("§9 Maka");
        rose.setItemMeta(roseM);
        
        if(main.getCompo().contains(Roles.MAKA)) {
        	
        	rose.setAmount(1);
        	inv_compo.setItem(slot, rose);
        	slot += 1;
        	
        }
        else {
        	
        	rose.setAmount(0);
        	inv_compo.setItem(slot, rose);
        	slot += 1;
        	
        }
        
        ItemStack trial = new ItemStack(Material.NETHERRACK, 1);
        ItemMeta trialM = trial.getItemMeta();
        trialM.setDisplayName("§9 Trial");
        trial.setItemMeta(trialM);
        
        if(main.getCompo().contains(Roles.TRIAL)) {
        	
        	trial.setAmount(1);
        	inv_compo.setItem(slot, trial);
        	slot += 1;
        	
        }
        else {
        	
        	trial.setAmount(0);
        	inv_compo.setItem(slot, trial);
        	slot += 1;
        	
        }
        
        ItemStack boat = new ItemStack(Material.BOAT, 1);
        ItemMeta boatM = boat.getItemMeta();
        boatM.setDisplayName("§9 Loup");
        boat.setItemMeta(boatM);
        
        if(main.getCompo().contains(Roles.LOUP)) {
        	
        	boat.setAmount(1);
        	inv_compo.setItem(slot, boat);
        	slot += 1;
        	
        }
        else {
        	
        	boat.setAmount(0);
        	inv_compo.setItem(slot, boat);
        	slot += 1;
        	
        }
        
        ItemStack plastron = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta plastronM = plastron.getItemMeta();
        plastronM.setDisplayName("§9 Captain");
        plastron.setItemMeta(plastronM);
        
        if(main.getCompo().contains(Roles.CAPTAIN)) {
        	
        	plastron.setAmount(1);
        	inv_compo.setItem(slot, plastron);
        	slot += 1;
        	
        }
        else {
        	
        	plastron.setAmount(0);
        	inv_compo.setItem(slot, plastron);
        	slot += 1;
        	
        }
        
        ItemStack gold = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta goldM = gold.getItemMeta();
        goldM.setDisplayName("§9 Hekow");
        gold.setItemMeta(goldM);
        
        if(main.getCompo().contains(Roles.HEKOW)) {
        	
        	gold.setAmount(1);
        	inv_compo.setItem(slot, gold);
        	slot += 1;
        	
        }
        else {
        	
        	gold.setAmount(0);
        	inv_compo.setItem(slot, gold);
        	slot += 1;
        	
        }
        
        ItemStack aziz = new ItemStack(397, 1, (short) 2);
        ItemMeta azizM = aziz.getItemMeta();
        azizM.setDisplayName("§9 Yuri");
        aziz.setItemMeta(azizM);
        
        if(main.getCompo().contains(Roles.YURI)) {
        	
        	aziz.setAmount(1);
        	inv_compo.setItem(slot, aziz);
        	slot += 1;
        	
        }
        else {
        	
        	aziz.setAmount(0);
        	inv_compo.setItem(slot, aziz);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void getCompoUHC(Player player, Main main, boolean gestion) {
		
		int slot = 18;
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", "")); 
        inv_compo.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
        inv_compo.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
        ItemStack cheat = new ItemStack(351, 1, (short) 9);
        ItemMeta cheatM = cheat.getItemMeta();
        cheatM.setDisplayName("§2 Malivol");
        cheat.setItemMeta(cheatM);
        
        if(main.getCompo().contains(Roles.MALIVOL)) {
        	
        	cheat.setAmount(1);
        	inv_compo.setItem(slot, cheat);
        	slot += 1;
        	
        }
        else {
        	
        	cheat.setAmount(0);
        	inv_compo.setItem(slot, cheat);
        	slot += 1;
        	
        }
        
        ItemStack epee = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta epeeM = epee.getItemMeta();
        epeeM.setDisplayName("§2 Toinou");
        epee.setItemMeta(epeeM);
        
        if(main.getCompo().contains(Roles.TOINOU)) {
        	
        	epee.setAmount(1);
        	inv_compo.setItem(slot, epee);
        	slot += 1;
        	
        }
        else {
        	
        	epee.setAmount(0);
        	inv_compo.setItem(slot, epee);
        	slot += 1;
        	
        }
        
        ItemStack obsi = new ItemStack(Material.OBSIDIAN, 1);
        ItemMeta obsiM = obsi.getItemMeta();
        obsiM.setDisplayName("§2 Obscur");
        obsi.setItemMeta(obsiM);
        
        if(main.getCompo().contains(Roles.OBSCUR)) {
        	
        	obsi.setAmount(1);
        	inv_compo.setItem(slot, obsi);
        	slot += 1;
        	
        }
        else {
        	
        	obsi.setAmount(0);
        	inv_compo.setItem(slot, obsi);
        	slot += 1;
        	
        }
        
        ItemStack soul = new ItemStack(Material.SOUL_SAND, 1);
        ItemMeta soulM = soul.getItemMeta();
        soulM.setDisplayName("§a Nonoboy");
        soul.setItemMeta(soulM);
        
        if(main.getCompo().contains(Roles.NONOBOY)) {
        	
        	soul.setAmount(1);
        	inv_compo.setItem(slot, soul);
        	slot += 1;
        	
        }
        else {
        	
        	soul.setAmount(0);
        	inv_compo.setItem(slot, soul);
        	slot += 1;
        	
        }
        
        ItemStack lag = new ItemStack(Material.BARRIER, 1);
        ItemMeta lagM = lag.getItemMeta();
        lagM.setDisplayName("§a Theoochoux");
        lag.setItemMeta(lagM);
        
        if(main.getCompo().contains(Roles.THEOOCHOUX)) {
        	
        	lag.setAmount(1);
        	inv_compo.setItem(slot, lag);
        	slot += 1;
        	
        }
        else {
        	
        	lag.setAmount(0);
        	inv_compo.setItem(slot, lag);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
        
        ItemStack dirt = new ItemStack(Material.GRASS, 1);
        ItemMeta dirtM = dirt.getItemMeta();
        dirtM.setDisplayName("§a RomPrems");
        dirt.setItemMeta(dirtM);
        
        if(main.getCompo().contains(Roles.ROMPREMS)) {
        	
        	dirt.setAmount(1);
        	inv_compo.setItem(slot, dirt);
        	slot += 1;
        	
        }
        else {
        	
        	dirt.setAmount(0);
        	inv_compo.setItem(slot, dirt);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	public static void getCompoSolos(Player player, Main main, boolean gestion) {
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", "")); 
        inv_compo.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
        inv_compo.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
		int slot = 18;
		
        ItemStack command = new ItemStack(Material.BEDROCK, 1);
        ItemMeta commandM = command.getItemMeta();
        commandM.setDisplayName("§c Farmeurimmo");
        command.setItemMeta(commandM);
        
        if(main.getCompo().contains(Roles.FARMEURIMMO)) {
        	
        	command.setAmount(1);
        	inv_compo.setItem(slot, command);
        	slot += 1;
        	
        }
        else {
        	
        	command.setAmount(0);
        	inv_compo.setItem(slot, command);
        	slot += 1;
        	
        }
        
        ItemStack diams = new ItemStack(Material.DIAMOND, 1);
        ItemMeta diamsM = diams.getItemMeta();
        diamsM.setDisplayName("§6 Kzou");
        diams.setItemMeta(diamsM);
        
        if(main.getCompo().contains(Roles.KZOU)) {
        	
        	diams.setAmount(1);
        	inv_compo.setItem(slot, diams);
        	slot += 1;
        	
        }
        else {
        	
        	diams.setAmount(0);
        	inv_compo.setItem(slot, diams);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void interactCompo(ItemStack current, Player player, Main main, boolean gestion) {
        
        if(current.getTypeId() == 351) {
        	
        	if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§a Raptor")) {
        		
        		if(main.getCompo().contains(Roles.RAPTOR)) {
        			
        			main.getCompo().remove(Roles.RAPTOR);
        			current.setAmount(0);
        			getCompoJoueur(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.RAPTOR);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	else if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§a Slup")) {
        		
        		if(main.getCompo().contains(Roles.SLUP)) {
        			
        			main.getCompo().remove(Roles.SLUP);
        			current.setAmount(0);
        			getCompoJoueur(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.SLUP);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	else if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§a Joko")) {
        		
        		if(main.getCompo().contains(Roles.JOKO)) {
        			
        			main.getCompo().remove(Roles.JOKO);
        			current.setAmount(0);
        			getCompoJoueur(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.JOKO);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	else if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§9 GameBlack")) {
        		
        		if(main.getCompo().contains(Roles.GAMEBLACK)) {
        			
        			main.getCompo().remove(Roles.GAMEBLACK);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.GAMEBLACK);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	else if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§2 Malivol")) {
        		
        		if(main.getCompo().contains(Roles.MALIVOL)) {
        			
        			main.getCompo().remove(Roles.MALIVOL);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.MALIVOL);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	
        }

        switch (current.getType()) {
        
        	case DIAMOND_HOE:
        		
        		if(main.getCompo().contains(Roles.JEANNOT)) {
        			
        			main.getCompo().remove(Roles.JEANNOT);
        			current.setAmount(0);
        			getCompoJoueur(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.JEANNOT);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case PAPER:
        		
        		if(main.getCompo().contains(Roles.NICKOBOOP)) {
        			
        			main.getCompo().remove(Roles.NICKOBOOP);
        			current.setAmount(0);
        			getCompoJoueur(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.NICKOBOOP);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case GLASS:
        		
        		if(main.getCompo().contains(Roles.TEAM)) {
        			
        			main.getCompo().remove(Roles.TEAM);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.TEAM);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case RED_ROSE:
        		
        		if(main.getCompo().contains(Roles.MAKA)) {
        			
        			main.getCompo().remove(Roles.MAKA);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.MAKA);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case NETHERRACK:
        		
        		if(main.getCompo().contains(Roles.TRIAL)) {
        			
        			main.getCompo().remove(Roles.TRIAL);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.TRIAL);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BOAT:
        		
        		if(main.getCompo().contains(Roles.LOUP)) {
        			
        			main.getCompo().remove(Roles.LOUP);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.LOUP);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case IRON_CHESTPLATE:
        		
        		if(main.getCompo().contains(Roles.CAPTAIN)) {
        			
        			main.getCompo().remove(Roles.CAPTAIN);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.CAPTAIN);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case GOLD_BLOCK:
        		
        		if(main.getCompo().contains(Roles.HEKOW)) {
        			
        			main.getCompo().remove(Roles.HEKOW);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.HEKOW);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case SKULL_ITEM:
        		
        		if(main.getCompo().contains(Roles.YURI)) {
        			
        			main.getCompo().remove(Roles.YURI);
        			current.setAmount(0);
        			getCompoStaff(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.YURI);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND_SWORD:
        		
        		if(main.getCompo().contains(Roles.TOINOU)) {
        			
        			main.getCompo().remove(Roles.TOINOU);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.TOINOU);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case OBSIDIAN:
        		
        		if(main.getCompo().contains(Roles.OBSCUR)) {
        			
        			main.getCompo().remove(Roles.OBSCUR);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.OBSCUR);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case SOUL_SAND:
        		
        		if(main.getCompo().contains(Roles.NONOBOY)) {
        			
        			main.getCompo().remove(Roles.NONOBOY);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.NONOBOY);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BARRIER:
        		
        		if(main.getCompo().contains(Roles.THEOOCHOUX)) {
        			
        			main.getCompo().remove(Roles.THEOOCHOUX);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.THEOOCHOUX);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case GRASS:
        		
        		if(main.getCompo().contains(Roles.ROMPREMS)) {
        			
        			main.getCompo().remove(Roles.ROMPREMS);
        			current.setAmount(0);
        			getCompoUHC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.ROMPREMS);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BEDROCK:
        		
        		if(main.getCompo().contains(Roles.FARMEURIMMO)) {
        			
        			main.getCompo().remove(Roles.FARMEURIMMO);
        			current.setAmount(0);
        			getCompoSolos(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.FARMEURIMMO);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND:
        		
        		if(main.getCompo().contains(Roles.KZOU)) {
        			
        			main.getCompo().remove(Roles.KZOU);
        			current.setAmount(0);
        			getCompoSolos(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.KZOU);
        			current.setAmount(1);
        			
        		}
        		
        		break;

            case DIAMOND_PICKAXE:
                
            	getCompoJoueur(player, main, gestion);
            	break;

            case COMMAND:

            	getCompoStaff(player, main, gestion);
                break;

            case GOLDEN_APPLE:

            	getCompoUHC(player, main, gestion);
                break;
                
            case GOLD_INGOT:

            	getCompoSolos(player, main, gestion);

                break;

            default:
                break;

        }
		
	}
	
}
