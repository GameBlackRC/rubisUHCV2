package fr.gameblack.rcuhcv2.listener.global;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.listener.v1.InteractItemV1;
import fr.gameblack.rcuhcv2.listener.v2.InteractItemV2;

public class InteractListener implements Listener {

    private Main main;

    public InteractListener(Main main) {
        this.main = main;
    }

	@EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Joueur joueur = main.getJoueur(player);
        
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it == null) return;

        else if (it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§8Paramètre de la partie")) {

        	Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Paramètre de la partie");
        	inv_pacte.setItem(11, Main.getItem(Material.DIAMOND_PICKAXE, "Mode", ""));
            inv_pacte.setItem(13, Main.getItem(Material.COMMAND, "Scénarios", ""));
            inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_SWORD, "Compo", ""));

            player.openInventory(inv_pacte);

        }
        else {
        	
        	if(main.getVersion() == 1) {
        		
        		InteractItemV1.whenInteract(joueur, it, action, main);
        		
        	}
        	else if(main.getVersion() == 2) {
        		
        		InteractItemV2.whenInteract(joueur, it, action, main);
        		
        	}
        	
        }

    }

}
