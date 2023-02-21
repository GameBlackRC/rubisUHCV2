package fr.gameblack.rubisuhc.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.roles.demons.Ange;
import fr.gameblack.rubisuhc.roles.demons.Electrique;
import fr.gameblack.rubisuhc.roles.demons.Enfer;
import fr.gameblack.rubisuhc.roles.demons.Malivol;
import fr.gameblack.rubisuhc.roles.demons.Tronconeuse;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;
import fr.gameblack.rubisuhc.roles.rc.Joko;
import fr.gameblack.rubisuhc.roles.rc.Loup;
import fr.gameblack.rubisuhc.roles.rc.Maka;
import fr.gameblack.rubisuhc.roles.rc.Raptor;

public class InteractListeners implements Listener {
	
	private Main main;
	
	public InteractListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		@SuppressWarnings("unused")
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;
		
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Pactes")) {
			
			GameBlack.InteractChest(player);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Furreur du dragon")) {
			
			Maka.InteractDragon(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Cheat")) {
			
			Malivol.InteractCheat(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("SpeedCubing")) {
			
			Joko.InteractSpeedcubing(player, main);;
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Shop")) {
			
			Ange.InteractShop(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Foudre")) {
			
			Electrique.InteractFoudre(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Transformation")) {
			
			Loup.InteractLoup(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Zone de feu")) {
			
			Enfer.InteractFeu(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Affuter ses lames")) {
			
			Tronconeuse.InteractLame(player, main);
			
		}
		else if(it.getType() == Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Rage")) {
			
			Raptor.InteractRage(player, main);
			
		}
		
	}
	
}
