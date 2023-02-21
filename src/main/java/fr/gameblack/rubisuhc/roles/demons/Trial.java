package fr.gameblack.rubisuhc.roles.demons;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trial {

    public static void Items(Player player, Main main) {

        Texte(player);
        main.addPourcentEffet(player, "force", 0.15);

    }

    public static void CommandSteal(Player player, String type, Main main) {

        if (type == "orbe") {

            main.setOrbe(player, main.getOrbeKillTrial());
            main.addVolTrial("orbe");

        } else if (type == "pouvoir") {

            if (main.getRoleKillTrial() == Roles.GAMEBLACK) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("force");
                if (main.getPacteGB() == 1) {

                    pouvoirs.add("speed");

                } else if (main.getPacteGB() == 2) {

                    pouvoirs.add("vie");

                }

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "force") {

                    main.addVolTrial("force_gb");
                    main.addPourcentEffet(player, "force", 0.05);

                } else if (pouvoirs.get(nb) == "speed") {

                    main.addPourcentEffet(player, "speed", 0.05);
                    main.addVolTrial("speed_gb");

                } else {

                    main.addVolTrial("vie_gb");

                }

            } else if (main.getRoleKillTrial() == Roles.JOKO) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("item");
                pouvoirs.add("speed");
                pouvoirs.add("mort_force");

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "item") {

                    main.addVolTrial("item_joko");
                    ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta coffreM = coffre.getItemMeta();
                    coffreM.setDisplayName("SpeedCubing");
                    coffre.setItemMeta(coffreM);
                    player.getInventory().addItem(coffre);

                } else if (pouvoirs.get(nb) == "speed") {

                    main.addPourcentEffet(player, "speed", 0.05);
                    main.addVolTrial("speed_joko");

                } else {

                    main.addVolTrial("mort_joko");

                }

            } else if (main.getRoleKillTrial() == Roles.TEAM) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("resi");
                pouvoirs.add("mort");

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "mort") {

                    main.addVolTrial("mort_team");

                } else {

                    main.addPourcentEffet(player, "resi", 0.05);
                    main.addVolTrial("resi_team");

                }

            } else if (main.getRoleKillTrial() == Roles.LOUP) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("force");
                pouvoirs.add("kill_speed");
                pouvoirs.add("item");

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "item") {

                    main.addVolTrial("item_loup");
                    ItemStack dragon = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta dragonM = dragon.getItemMeta();
                    dragonM.setDisplayName("Transformation");
                    dragon.setItemMeta(dragonM);
                    player.getInventory().addItem(dragon);

                } else if (pouvoirs.get(nb) == "force") {

                    main.addPourcentEffet(player, "force", 0.05);
                    main.addVolTrial("force_loup");

                } else {

                    main.addVolTrial("kill_loup");

                }

            } else if (main.getRoleKillTrial() == Roles.MAKA) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("speed");
                pouvoirs.add("nofall");
                pouvoirs.add("item");

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "item") {

                    main.addVolTrial("item_maka");
                    ItemStack dragon = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta dragonM = dragon.getItemMeta();
                    dragonM.setDisplayName("Furreur du dragon");
                    dragon.setItemMeta(dragonM);
                    player.getInventory().addItem(dragon);

                } else if (pouvoirs.get(nb) == "speed") {

                    main.addPourcentEffet(player, "speed", 0.05);
                    main.addVolTrial("speed_maka");

                } else {

                    main.addVolTrial("nofall_maka");

                }

            } else if (main.getRoleKillTrial() == Roles.RAPTOR) {

                List<String> pouvoirs = new ArrayList<>();

                pouvoirs.add("resi");
                pouvoirs.add("item");

                Random r = new Random();
                int nb = r.nextInt(pouvoirs.size());

                if (pouvoirs.get(nb) == "item") {

                    main.addVolTrial("item_raptor");
                    ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta coffreM = coffre.getItemMeta();
                    coffreM.setDisplayName("Rage");
                    coffre.setItemMeta(coffreM);
                    player.getInventory().addItem(coffre);

                } else {

                    main.addPourcentEffet(player, "resi", 0.05);
                    main.addVolTrial("resi_raptor");

                }

            } else if (main.getRoleKillTrial() == Roles.TOINOU) {

                main.addPourcentEffet(player, "speed", 0.05);
                main.addVolTrial("speed_toinou");

            } else if (main.getRoleKillTrial() == Roles.ARCHER) {

                main.addPourcentEffet(player, "speed", 0.05);
                main.addVolTrial("speed_archer");

            } else if (main.getRoleKillTrial() == Roles.GUERRIER) {

                main.addPourcentEffet(player, "force", 0.05);
                main.addVolTrial("force_guerrier");

            } else if (main.getRoleKillTrial() == Roles.ECLAIREUR) {

                main.addVolTrial("invisible_eclaireur");

            }

        } else {

            player.sendMessage("Merci de mettre ce que vous souhaitez voler (/rcsteal <orbe|pouvoir>");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §cTrial\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez les effets force I permanent, l'effet speed I la nuit et l'effet résistance I le jour\n \nVous pouvez communiquer avec Slup avec la commande /rcmsg\n \nSi vous parvenez à tuer Raptor, vous gagnez l'effet résistance I permanent\n \nA chaque kill, vous recevez 1 demi-coeur en plus\n \nSi vous croisez Kzou dans les 5 dernières minutes, vous recevrez l'effet nausée pendant 5 secondes\n \nSi vous tuer Kzou, vous récupérez 5 pommes d'or\n \nA chaque kill du camps rc que vous faites vous pouvez, 2 fois par partie, choisir entre ces 2 options :\n- Voler l'orbe élémentaire du joueur\n- Voler une des particularité du joueur (un effet, un pouvoir ou ses coeurs en plus => aléatoire)\n \n____________________________________________________");

    }

}
