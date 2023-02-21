package fr.gameblack.rubisuhc.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.gameblack.rubisuhc.orbes.Feu;
import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.State;

public class GPlayerListeners implements Listener {

	private static Main main;
	
	@SuppressWarnings("static-access")
	public GPlayerListeners(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		if(!main.getPlayers().contains(player)) {
			main.addPlayer(player);
		}
		else if(main.getState() == State.PVP_OFF || main.getState() == State.PVP_ON) {
			
			player.setGameMode(GameMode.SPECTATOR);
			
		}
		
		Bukkit.broadcastMessage("<RubisUHC> [+]" + player.getName() + " [" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + "]");
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		
		Bukkit.broadcastMessage("<RubisUHC> [-]" + player.getName() + " [" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + "]");
		
		
		main.checkWin();
		
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		if(main.getRole(player) != Roles.NONE && player.getGameMode() == GameMode.SPECTATOR) {
			
			e.setCancelled(true);
			
		}
		
	    Material m = e.getPlayer().getLocation().getBlock().getType();
	    if (m == Material.STATIONARY_WATER || m == Material.WATER) {

	    	if(main.getOrbe(player) == Orbe.FEU  && !main.isOrbeMalus(player) && main.isOrbeActif(player)) {
	    		
	    		Feu.Malus(player, main);
	    		
	    	}
	    	
	    }
	}
	
	@EventHandler
	public void onPlayerWrite(AsyncPlayerChatEvent event) {
		
		if(main.getState() == State.PVP_ON) {
		
			event.setCancelled(true);
			
		}
	
	}

}
