package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sang {

    public static void Items(Joueur joueur) {

    	Player player = joueur.getPlayer();
    	
        Texte(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

    }

    public static void CommandSang(Joueur joueur, Joueur cible, Main main) {
    	
    	Player player = joueur.getPlayer();

        if (cible.getCamp() == joueur.getCamp()) {

            List<String> effet = new ArrayList<>();

            if (!cible.getPlayer().hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {

                effet.add("resi");

            }

            if (cible.getForce() < 1.25) {

                effet.add("force");

            }

            if (!cible.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {

                effet.add("speed");

            }

            if (effet.size() == 0) {

                player.sendMessage("Ce joueur possède déjà tout les effets");

            } else {

                joueur.getCD().add(Pouvoirs.SANG_SANG);

                Random r = new Random();
                int nb = r.nextInt(effet.size());

                if (effet.get(nb) == "force") {

                    cible.addForce(0.15);
                    ItemCD cycle = new ItemCD(main, joueur, "sangforce", 300, cible, null, null, 0, null);
                    cycle.runTaskTimer(main, 0, 20);
                    player.sendMessage("Ce joueur a bien reçu un effet");

                } else if (effet.get(nb) == "speed") {

                    cible.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 0, 6000, false, false));
                    player.sendMessage("Ce joueur a bien reçu un effet");

                } else {

                    cible.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 0, 6000, false, false));
                    cible.addResi(0.15);
                    ItemCD cycle = new ItemCD(main, joueur, "sangresi", 300, cible, null, null, 0, null);
                    cycle.runTaskTimer(main, 0, 20);
                    player.sendMessage("Ce joueur a bien reçu un effet");

                }

            }

        } else {

            List<String> effet = new ArrayList<>();

            if (!cible.getPlayer().hasPotionEffect(PotionEffectType.SLOW)) {

                effet.add("lenteur");

            }

            if (!cible.getPlayer().hasPotionEffect(PotionEffectType.WEAKNESS)) {

                effet.add("faiblesse");

            }

            if (effet.size() == 0) {

                player.sendMessage("Ce joueur possède déjà tout les effets");

            } else {

                Random r = new Random();
                int nb = r.nextInt(effet.size());

                joueur.getCD().add(Pouvoirs.SANG_SANG);

                if (effet.get(nb) == "lenteur") {

                    cible.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 0, 3600, false, false));
                    player.sendMessage("Ce joueur a bien reçu un effet");

                } else {

                    cible.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 0, 3600, false, false));
                    player.sendMessage("Ce joueur a bien reçu un effet");

                }

            }

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Sang\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent et l'effet force I la nuit\n \nAvec la commande /rcsang <pseudo>, vous pourrez donner aléatoirement speed I, force I ou résistance I pendant 5 minutes si le joueur ciblé est un démon ou faiblesse I ou lenteur I pendant 3 minutes si le joueur ciblé n'est pas un démon\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}