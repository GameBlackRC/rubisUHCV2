package fr.gameblack.rcuhcv2.task.v2;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;


public class RollBackCD extends BukkitRunnable {

	private Main main;
    private Location loc;
    private Inventory inv;
    private Double heal;
    private int timer = 5;
	private int food;
	private Joueur joueur;

    public RollBackCD(Main main, Location loc, Inventory inv, Double heal, int food, Joueur joueur) {
        this.main = main;
        this.loc = loc;
        this.inv = inv;
        this.heal = heal;
        this.food = food;
        this.joueur = joueur;
    }

    @Override
    public void run() {
    	
    	if(timer == 2) {
    		
    		joueur.setTheoochouxLoc3sec(loc);
    		
    	}
    	
    	if(timer == 0) {
    		
    		joueur.setTheoochouxLoc(loc);
    		joueur.setTheoochouxInv(inv);
    		joueur.setTheoochouxHP(heal);
    		joueur.setTheoochouxFood(food);
    		cancel();
    		
    	}

        timer--;

    }

}