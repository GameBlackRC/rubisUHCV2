package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Tronconeuse {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

    }

    public static void ItemsKillTrial(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        joueur.addSpeed(0.1);
        player.setMaxHealth(player.getMaxHealth() + 6);

        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Affuter ses lames");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);

    }

    public static void InteractLame(Joueur joueur, Main main) {

        if (!joueur.getCD().contains(Pouvoirs.TRONCONEUSE_LAME)) {

            joueur.getCD().add(Pouvoirs.TRONCONEUSE_LAME);

            if (main.getJoueurByRole(Roles.Slup) != null) {

                Joueur slup = main.getJoueurByRole(Roles.Slup);

                slup.getPlayer().sendMessage("Le démon Tronçoneuse a utilisé son item 'Affuter ses lames'");

            }
            
            joueur.addForce(0.10);
            ItemCD cycle = new ItemCD(main, joueur, "speed_moins", 60, joueur, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
            ItemCD cycle2 = new ItemCD(main, joueur, "speed_plus", 360, joueur, null, null, 0, null);
            cycle2.runTaskTimer(main, 0, 20);

        }

    }
    
    public static void Saignement(Joueur joueur, Joueur cible, Main main) {
    	
        if (!cible.isSaigne()) {

            Random r = new Random();
            int nb = r.nextInt(100);

            if (nb < 6) {

                cible.setSaigne(true);
                cible.getPlayer().damage(1);
                ItemCD cycle = new ItemCD(main, joueur, "saigne", 10, cible, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);

            }

        }
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Tronçoneuse\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent et force I la nuit\n \nA chaque coup, vous avez 5% de chance d'infliger un effet de saignement qui retire 0.5 coeur toutes les 2 secondes pendant 10 secondes\n \nSi Trial meurt, vous recevez 10% de speed permanent, gagnez 3 coeurs supplémentaires et recevez un item nommé 'Affuter ses lames' vous permettant de recevoir l'effet force II pendant 1 minute\nUne fois la minute passer, votre speed II devient speed I pendant 5 minutes\n \nA chaque kill du camps rc que vous faites, vous pourrez choisir de récupérer leur orbe 1 fois dans la partie\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}