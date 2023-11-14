package fr.gameblack.rcuhcv2.task.v2;

import fr.gameblack.rcuhcv2.Main;

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

    public RollBackCD(Main main, Location loc, Inventory inv, Double heal, int food) {
        this.main = main;
        this.loc = loc;
        this.inv = inv;
        this.heal = heal;
        this.food = food;
    }

    @Override
    public void run() {
    	
    	if(timer == 0) {
    		
    		main.setTheoochouxLoc(loc);
    		main.setTheoochouxInv(inv);
    		main.setTheoochouxHP(heal);
    		main.setTheoochouxFood(food);
    		
    	}

        timer--;

    }

}