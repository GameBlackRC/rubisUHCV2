package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Glace {

    public static void Effets(Joueur joueur, Main main) {

    	joueur.setStatutOrbe(true);
    	joueur.addResi(0.03);

    }

    public static void RemoveEffets(Joueur joueur, Main main) {

    	joueur.setStatutOrbe(false);
    	joueur.removeResi(0.03);

    }

    public static void Malus(Joueur joueur, Main main) {
    	
    	Random r = new Random();
        int nb = r.nextInt(100);
    	
    	if(joueur.getRole() != Roles.GAMEBLACK || (joueur.getRole() == Roles.GAMEBLACK && nb <= 50)) {
    	
	    	RemoveEffets(joueur, main);
	    	joueur.removeForce(0.05);
	    	joueur.setMalusOrbe(true);
	        ItemCD cycle = new ItemCD(main, joueur, "glace_malus", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
    	}

    }

    public static void Freeze(Player player) {

        Random r = new Random();
        int nb = r.nextInt(100);

        if (nb <= 5) {

            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1, false, false));

        }

    }

}
