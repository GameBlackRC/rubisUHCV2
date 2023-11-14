package fr.gameblack.rcuhcv2.listener.v2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class BoatActionListener implements Listener{
	
	private Main main;
	
	public BoatActionListener(Main main) {
		
		this.main = main;
		
	}
	
	@EventHandler
	public void onPlayerEnterInBoat(VehicleEnterEvent event) {
		
		Entity entity = event.getEntered();
		
		if(event.getVehicle().getCustomName() == "Super Bateau") {
			
			if(entity instanceof Player) {
				
				Player player = (Player) entity;
				Joueur joueur = main.getJoueur(player);
				
				if(!main.getAccesBateauLoup().contains(joueur)) {
					
					joueur.getPlayer().sendMessage("Vous n'êtes pas autorisé à rentrer dans ce bateau");
					event.setCancelled(true);
					
				}
				else {
					
					main.setPassagerSuperBateau(joueur);
					joueur.setNofall(true);
					
				}
			
			}
			else {
				
				event.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onPlayerExitInBoat(VehicleExitEvent event) {
		
		Entity entity = event.getExited();
		
		if(event.getVehicle().getCustomName() == "Super Bateau") {
			
			if(entity instanceof Player) {
				
				Player player = (Player) entity;
				Joueur joueur = main.getJoueur(player);
					
				main.setPassagerSuperBateau(null);
				ItemCD cycle = new ItemCD(main, joueur, "no_fall", 23, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
			
			}
			
		}
		
	}
	
	@EventHandler
	public void onBoatDestroy(VehicleDestroyEvent event) {
		
		if(event.getVehicle().getCustomName() == "Super Bateau") {
			
			event.setCancelled(true);
			
		}
		
	}

}
