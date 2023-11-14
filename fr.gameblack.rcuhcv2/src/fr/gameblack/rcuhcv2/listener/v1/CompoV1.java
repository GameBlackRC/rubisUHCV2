package fr.gameblack.rcuhcv2.listener.v1;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CompoV1 {
	
	@SuppressWarnings("deprecation")
	public static void getCompoRC(Player player, Main main, boolean gestion) {
		
		int slot = 18;
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "§aCamp RC", ""));
        inv_compo.setItem(4, Main.getItem(Material.NETHER_BRICK, "§cCamp Démon", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
        ItemStack rage = new ItemStack(Material.CHEST, 1);
        ItemMeta rageM = rage.getItemMeta();
        rageM.setDisplayName("§a GameBlack");
        rage.setItemMeta(rageM);
        
        if(main.getCompo().contains(Roles.GameBlack)) {
        	
        	rage.setAmount(1);
        	inv_compo.setItem(slot, rage);
        	slot += 1;
        	
        }
        else {
        	
        	rage.setAmount(0);
        	inv_compo.setItem(slot, rage);
        	slot += 1;
        	
        }
        
        ItemStack houe = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemMeta houeM = houe.getItemMeta();
        houeM.setDisplayName("§a Team");
        houe.setItemMeta(houeM);
        
        if(main.getCompo().contains(Roles.Team)) {
        	
        	houe.setAmount(1);
        	inv_compo.setItem(slot, houe);
        	slot += 1;
        	
        }
        else {
        	
        	houe.setAmount(0);
        	inv_compo.setItem(slot, houe);
        	slot += 1;
        	
        }
        
        ItemStack cube = new ItemStack(351, 1, (short) 13);
        ItemMeta cubeM = cube.getItemMeta();
        cubeM.setDisplayName("§a Joko");
        cube.setItemMeta(cubeM);
        
        if(main.getCompo().contains(Roles.Joko)) {
        	
        	cube.setAmount(1);
        	inv_compo.setItem(slot, cube);
        	slot += 1;
        	
        }
        else {
        	
        	cube.setAmount(0);
        	inv_compo.setItem(slot, cube);
        	slot += 1;
        	
        }
        
        ItemStack lave = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta laveM = lave.getItemMeta();
        laveM.setDisplayName("§a Maka");
        lave.setItemMeta(laveM);
        
        if(main.getCompo().contains(Roles.Maka)) {
        	
        	lave.setAmount(1);
        	inv_compo.setItem(slot, lave);
        	slot += 1;
        	
        }
        else {
        	
        	lave.setAmount(0);
        	inv_compo.setItem(slot, lave);
        	slot += 1;
        	
        }
        
        ItemStack epee = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta epeeM = epee.getItemMeta();
        epeeM.setDisplayName("§a Toinou");
        epee.setItemMeta(epeeM);
        
        if(main.getCompo().contains(Roles.Toinou)) {
        	
        	epee.setAmount(1);
        	inv_compo.setItem(slot, epee);
        	slot += 1;
        	
        }
        else {
        	
        	epee.setAmount(0);
        	inv_compo.setItem(slot, epee);
        	slot += 1;
        	
        }
        
        ItemStack sucre = new ItemStack(Material.SUGAR, 1);
        ItemMeta sucreM = sucre.getItemMeta();
        sucreM.setDisplayName("§a Loup");
        sucre.setItemMeta(sucreM);
        
        if(main.getCompo().contains(Roles.Loup)) {
        	
        	sucre.setAmount(1);
        	inv_compo.setItem(slot, sucre);
        	slot += 1;
        	
        }
        else {
        	
        	sucre.setAmount(0);
        	inv_compo.setItem(slot, sucre);
        	slot += 1;
        	
        }
        
        ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
        ItemMeta redstoneM = redstone.getItemMeta();
        redstoneM.setDisplayName("§a Raptor");
        redstone.setItemMeta(redstoneM);
        
        if(main.getCompo().contains(Roles.Raptor)) {
        	
        	redstone.setAmount(1);
        	inv_compo.setItem(slot, redstone);
        	slot += 1;
        	
        }
        else {
        	
        	redstone.setAmount(0);
        	inv_compo.setItem(slot, redstone);
        	slot += 1;
        	
        }
        
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName("§a Guerrier");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Guerrier)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.BOW, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§a Archer");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Archer)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	public static void getCompoDemons(Player player, Main main, boolean gestion) {
		
		int slot = 18;
		
		Inventory inv_compo;
		
		if(gestion) {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Gestion Compo");
			
		}
		else {
			
			inv_compo = Bukkit.createInventory(null, 36, "§8Compo");
			
		}
        inv_compo.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "§aCamp RC", ""));
        inv_compo.setItem(4, Main.getItem(Material.NETHER_BRICK, "§cCamp Démon", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
        ItemStack item = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName("§c Trial");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Trial)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.OBSIDIAN, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Slup");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Slup)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.DIAMOND_ORE, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Malivol");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Malivol)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.DIAMOND_HELMET, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Obscur");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Obscur)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.APPLE, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Ange");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Ange)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.IRON_BLOCK, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Avenir");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Avenir)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.ENDER_PORTAL, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Cosmos");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Cosmos)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.BLAZE_ROD, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Electrique");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Electrique)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.FLINT_AND_STEEL, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Enfer");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Enfer)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.SOUL_SAND, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Malédiction");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Malediction)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Sang");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Sang)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.OBSIDIAN, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Slup");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Slup)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.DIAMOND_AXE, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Tronçonneuse");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Tronconeuse)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.COAL_BLOCK, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon Ténèbre");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Tenebre)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.NETHERRACK, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§c Démon");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Demon)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
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
        inv_compo.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "§aCamp RC", ""));
        inv_compo.setItem(4, Main.getItem(Material.NETHER_BRICK, "§cCamp Démon", ""));
        inv_compo.setItem(5, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
		
		int slot = 18;
		
        ItemStack item = new ItemStack(Material.BREWING_STAND_ITEM, 1);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName("§6 Démon Expérimental");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Experimental)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.GOLDEN_APPLE, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§6 Farmeurimmo");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Farmeurimmo)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        
        item = new ItemStack(Material.STICK, 1);
        itemM = item.getItemMeta();
        itemM.setDisplayName("§6 Kzou");
        item.setItemMeta(itemM);
        
        if(main.getCompo().contains(Roles.Kzou)) {
        	
        	item.setAmount(1);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }
        else {
        	
        	item.setAmount(0);
        	inv_compo.setItem(slot, item);
        	slot += 1;
        	
        }

        player.openInventory(inv_compo);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void interactCompo(ItemStack current, Player player, Main main, boolean gestion) {

		Roles role;
		
		if(current.getTypeId() == 351) {
        	
        	if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§a Joko")) {
        		
        		if(main.getCompo().contains(Roles.Joko)) {
        			
        			main.getCompo().remove(Roles.Joko);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(Roles.Joko);
        			current.setAmount(1);
        			
        		}
        		
        	}
        	
        }
		
        switch (current.getType()) {
        
        	case CHEST:
        		
        		role = Roles.GameBlack;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case EMERALD_BLOCK:
        		
        		role = Roles.Team;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case LAVA_BUCKET:
        		
        		role = Roles.Maka;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND_SWORD:
        		
        		role = Roles.Toinou;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case SUGAR:
        		
        		role = Roles.Loup;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case REDSTONE:
        		
        		role = Roles.Raptor;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case IRON_SWORD:
        		
        		role = Roles.Guerrier;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BOW:
        		
        		role = Roles.Archer;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoRC(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case REDSTONE_BLOCK:
        		
        		role = Roles.Trial;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case OBSIDIAN:
        		
        		role = Roles.Slup;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND_ORE:
        		
        		role = Roles.Malivol;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND_HELMET:
        		
        		role = Roles.Obscur;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case APPLE:
        		
        		role = Roles.Ange;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case IRON_BLOCK:
        		
        		role = Roles.Avenir;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case ENDER_PORTAL:
        		
        		role = Roles.Cosmos;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case NETHERRACK:
        		
        		role = Roles.Demon;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BLAZE_ROD:
        		
        		role = Roles.Electrique;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case FLINT_AND_STEEL:
        		
        		role = Roles.Enfer;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case SOUL_SAND:
        		
        		role = Roles.Malediction;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case REDSTONE_TORCH_ON:
        		
        		role = Roles.Sang;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case DIAMOND_AXE:
        		
        		role = Roles.Tronconeuse;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case COAL_BLOCK:
        		
        		role = Roles.Tenebre;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoDemons(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case BREWING_STAND_ITEM:
        		
        		role = Roles.Experimental;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoSolos(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case GOLDEN_APPLE:
        		
        		role = Roles.Farmeurimmo;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoSolos(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;
        		
        	case STICK:
        		
        		role = Roles.Kzou;
        		
        		if(main.getCompo().contains(role)) {
        			
        			main.getCompo().remove(role);
        			current.setAmount(0);
        			getCompoSolos(player, main, gestion);
        			
        		}
        		else {
        			
        			main.getCompo().add(role);
        			current.setAmount(1);
        			
        		}
        		
        		break;

            case DIAMOND_BLOCK:
                
            	getCompoRC(player, main, gestion);
            	break;

            case NETHER_BRICK:

            	getCompoDemons(player, main, gestion);
                break;
                
            case GOLD_INGOT:

            	getCompoSolos(player, main, gestion);

                break;

            default:
                break;

        }
		
	}
	
}
