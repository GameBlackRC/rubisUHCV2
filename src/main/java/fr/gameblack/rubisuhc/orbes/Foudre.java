package fr.gameblack.rubisuhc.orbes;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.task.ItemCD;
import org.bukkit.entity.Player;

public class Foudre {

    public static void Effets(Player player, Main main) {

        main.changeStatutOrbe(player, true);
        main.addPourcentEffet(player, "speed", 0.1);
        main.addPourcentEffet(player, "force", 0.03);

    }

    public static void RemoveEffets(Player player, Main main) {

        main.changeStatutOrbe(player, false);
        main.removePourcentEffet(player, "speed", 0.1);
        main.removePourcentEffet(player, "force", 0.03);

    }

    public static void Malus(Player player, Main main) {

        RemoveEffets(player, main);
        main.removePourcentEffet(player, "speed", 0.05);
        main.setMalusOrbe(player, true);
        ItemCD cycle = new ItemCD(main, player, "foudre_malus", 60, player, null, null);
        cycle.runTaskTimer(main, 0, 20);

    }

}
