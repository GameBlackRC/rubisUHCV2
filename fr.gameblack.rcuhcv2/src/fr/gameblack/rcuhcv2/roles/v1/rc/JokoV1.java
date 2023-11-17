package fr.gameblack.rcuhcv2.roles.v1.rc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

public class JokoV1 {

    public static void Items(Joueur joueur) {

        Texte(joueur.getPlayer());
        joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("SpeedCubing");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);

    }

    public static void InteractSpeedcubing(Joueur joueur, Main main) {

        if (!joueur.getCD().contains(Pouvoirs.JOKO_CUBE)) {

        	joueur.setJokoItemActif(true);
            joueur.addSpeed(0.1);
            ItemCD cycle = new ItemCD(main, joueur, "cube", 60, joueur, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getCD().add(Pouvoirs.JOKO_CUBE);

        } else {

            joueur.getPlayer().sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aJoko\n§rVous devez gagner avec le §acamps joueur§r\n \nVous avez 5% de speed permanent\n \nA l'annonce des rôles, vous recevez un item nommé '§dSpeedCubing§r' vous permettant de recevoir 5% de speed supplémentaire pendant 1 minute.\nChaque coup que vous mettez pendant ce pouvoir à 2% de chance par rubik's cube, que le joueur taper soit stun\n \nA la fin de votre pouvoir, vous recevez 1% de speed permanent et, si vous avez stun au moins un joueur, vous pourrez, avec la commande /rcsteal, voler 1% de force ou 1% de resistance au premier joueur stun\n \nVous possèdez la commande /rccube qui permet de donner un cube à un joueur (5 minutes de cooldown)\n \n____________________________________________________");

    }

    public static void CommandCube(Joueur joueur, Joueur cible, Main main) {

    	cible.addCube(main);
        joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " possède maintenant " + cible.getCube() + " rubik's cube");
        joueur.getCD().add(Pouvoirs.JOKO_GIVECUBE);
        ItemCD cycle = new ItemCD(main, joueur, "givecube", 300, cible, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);

    }

    public static void CommandSteal(Joueur joueur, Main main, String effet) {

        if (main.getJokoStun().size() != 0) {

            Joueur cible = main.getJokoStun().get(0);

            if (effet == "force") {

            	cible.removeForce(0.03);
            	joueur.addForce(0.03);
            	main.getJokoStun().clear();
                joueur.getPlayer().sendMessage("Vous avez voler 3% de force à " + cible.getPlayer().getName());

            } else if (effet == "resi" || effet == "resistance") {
            	
            	cible.removeResi(0.03);
            	joueur.addResi(0.03);
            	main.getJokoStun().clear();
                joueur.getPlayer().sendMessage("Vous avez voler 3% de résistance à " + cible.getPlayer().getName());

            } else {

                joueur.getPlayer().sendMessage("Merci de mettre un effet valide ('force', 'resi', 'resistance')");

            }

        }

    }
	
}
