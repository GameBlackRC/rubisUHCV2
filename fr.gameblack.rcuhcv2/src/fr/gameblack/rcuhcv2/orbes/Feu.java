package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;

import org.bukkit.entity.Player;

public class Feu {

    public static void Effets(Joueur joueur, Main main) {

    	joueur.setStatutOrbe(true);
    	Player player = joueur.getPlayer();
    	player.setMaxHealth(player.getMaxHealth() + 2);

    }

    public static void RemoveEffets(Joueur joueur, Main main) {

    	joueur.setStatutOrbe(false);
    	Player player = joueur.getPlayer();
        player.setMaxHealth(player.getMaxHealth() - 2);

    }

    public static void Malus(Joueur joueur, Main main) {

    	RemoveEffets(joueur, main);
    	joueur.removeResi(0.05);
    	joueur.setMalusOrbe(true);
        ItemCD cycle = new ItemCD(main, joueur, "feu_malus", 60, joueur, null, null, null);
        cycle.runTaskTimer(main, 0, 20);

    }

}