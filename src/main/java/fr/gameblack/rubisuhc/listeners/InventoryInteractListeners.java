package fr.gameblack.rubisuhc.listeners;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.roles.demons.Ange;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryInteractListeners implements Listener {

    private Main main;

    public InventoryInteractListeners(Main main) {
        this.main = main;
    }

    //public void onRenderName(RenderNameTagEvent event) {
    //Player player = event.getPlayer();
    //if (main.getRole(player) == Roles.GAMEBLACK && main.getPacteGB() == 1) {
    //int health = (int) player.getHealth();
    //event.setTag(event.getTag() + ": " + health);
    //}
    //}

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        //if(current == null) return;

        if (inv.getName().equalsIgnoreCase("§8Compo")) {

            event.setCancelled(true);

            Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Compo");

            switch (current.getType()) {

                case DIAMOND_BLOCK:

                    inv_pacte.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "Camp RC", ""));
                    inv_pacte.setItem(4, Main.getItem(Material.NETHER_BRICK, "Camp Démon", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLD_INGOT, "Solo", ""));

                    inv_pacte.setItem(9, Main.getItem(Material.CHEST, "GameBlack", ""));
                    inv_pacte.setItem(10, Main.getItem(Material.EMERALD_BLOCK, "Team", ""));
                    inv_pacte.setItem(11, Main.getItem(Material.QUARTZ_BLOCK, "Joko", ""));
                    inv_pacte.setItem(12, Main.getItem(Material.LAVA_BUCKET, "Maka", ""));
                    inv_pacte.setItem(13, Main.getItem(Material.DIAMOND_SWORD, "Toinou", ""));
                    inv_pacte.setItem(14, Main.getItem(Material.SUGAR, "Loup", ""));
                    inv_pacte.setItem(15, Main.getItem(Material.REDSTONE, "Raptor", ""));
                    inv_pacte.setItem(16, Main.getItem(Material.IRON_SWORD, "Guerrier", ""));
                    inv_pacte.setItem(17, Main.getItem(Material.BOW, "Archer", ""));
                    inv_pacte.setItem(18, Main.getItem(Material.GLASS, "Eclaireur", ""));

                    player.openInventory(inv_pacte);

                    break;

                case NETHER_BRICK:

                    inv_pacte.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "Camp RC", ""));
                    inv_pacte.setItem(4, Main.getItem(Material.NETHER_BRICK, "Camp Démon", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLD_INGOT, "Solo", ""));

                    inv_pacte.setItem(9, Main.getItem(Material.REDSTONE_BLOCK, "Trial", ""));
                    inv_pacte.setItem(10, Main.getItem(Material.OBSIDIAN, "Slup", ""));
                    inv_pacte.setItem(11, Main.getItem(Material.DIAMOND_ORE, "Malivol", ""));
                    inv_pacte.setItem(12, Main.getItem(Material.DIAMOND_HELMET, "Obscur", ""));
                    inv_pacte.setItem(13, Main.getItem(Material.APPLE, "Démon Ange", ""));
                    inv_pacte.setItem(14, Main.getItem(Material.IRON_BLOCK, "Démon Avenir", ""));
                    inv_pacte.setItem(15, Main.getItem(Material.ENDER_PORTAL, "Démon Cosmos", ""));
                    inv_pacte.setItem(16, Main.getItem(Material.BLAZE_ROD, "Démon Electrique", ""));
                    inv_pacte.setItem(17, Main.getItem(Material.FLINT_AND_STEEL, "Démon Enfer", ""));
                    inv_pacte.setItem(18, Main.getItem(Material.SOUL_SAND, "Démon Malédiction", ""));
                    inv_pacte.setItem(19, Main.getItem(Material.REDSTONE_TORCH_ON, "Démon Sang", ""));
                    inv_pacte.setItem(20, Main.getItem(Material.DIAMOND_AXE, "Démon Tronconeuse", ""));
                    inv_pacte.setItem(21, Main.getItem(Material.COAL_BLOCK, "Démon Tenebre", ""));
                    inv_pacte.setItem(22, Main.getItem(Material.NETHERRACK, "Démon", ""));

                    player.openInventory(inv_pacte);

                    break;

                case GOLD_INGOT:

                    inv_pacte.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "Camp RC", ""));
                    inv_pacte.setItem(4, Main.getItem(Material.NETHER_BRICK, "Camp Démon", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLD_INGOT, "Solo", ""));

                    inv_pacte.setItem(9, Main.getItem(Material.BREWING_STAND_ITEM, "Démon Expérimental", ""));
                    inv_pacte.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "Farmeurimmo", ""));
                    inv_pacte.setItem(11, Main.getItem(Material.STICK, "Kzou", ""));

                    player.openInventory(inv_pacte);

                    break;

                default:
                    break;

            }

        }

        if (inv.getName().equalsIgnoreCase("§8Choix du pacte")) {

            event.setCancelled(true);
            player.closeInventory();

            switch (current.getType()) {

                case APPLE:

                    GameBlack.InteractApple(player, main);

                    break;

                case DIAMOND_SWORD:

                    GameBlack.InteractSword(player, main);

                    break;

                default:
                    break;

            }

        } else if (inv.getName().equalsIgnoreCase("§8Shop")) {

            event.setCancelled(true);
            player.closeInventory();

            switch (current.getType()) {

                case APPLE:

                    Ange.InteractApple(player, main);

                    break;

                case DIAMOND_SWORD:

                    Ange.InteractSword(player, main);

                    break;

                case GOLDEN_APPLE:

                    Ange.InteractGApple(player, main);

                    break;

                case FEATHER:

                    Ange.InteractFeather(player, main);

                default:
                    break;

            }

        }

    }

}
