package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v1.Eau;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Electrique {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Foudre");
        coffre.setItemMeta(coffreM);

        player.getInventory().addItem(coffre);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

    }

    public static void InteractFoudre(Player player, Main main) {

        if (!main.getCD().contains(Pouvoirs.ELECTRIQUE_FOUDRE)) {

            main.getCD().add(Pouvoirs.ELECTRIQUE_FOUDRE);

            if (main.getJoueurByRole(Roles.Slup) != null) {

                Joueur slup = main.getJoueurByRole(Roles.Slup);

                slup.getPlayer().sendMessage("Le démon Electrique a utilisé son item 'Foudre'");

            }

            if (player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));

            for (Entity nearbyEntities : player.getNearbyEntities(20, 20, 20)) {

                if (nearbyEntities instanceof Player) {

                    Player cible_ = (Player) nearbyEntities;
                    Joueur cible = main.getJoueur(cible_);

                    if (!main.getCampDemonVie().contains(cible)) {

                        Bukkit.getWorld("world").strikeLightning(cible.getPlayer().getLocation());

                        cible.getPlayer().setFireTicks(0);

                        if (cible.getOrbe() == Orbe.EAU && !cible.isMalusOrbeActif() && cible.isOrbeActif()) {

                            Eau.Malus(cible, main);

                        }

                    }

                }

            }

        } else {

            player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");

        }

    }

    public static void CommandSacrifice(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        joueur.setNofall(true);;

        if (player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3600, 1, false, false));

        joueur.addForce(0.15);

        player.setMaxHealth(player.getMaxHealth() - 2);

        ItemCD cycle = new ItemCD(main, joueur, "sacrifice", 180, joueur, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
        
        player.sendMessage("Vous venez de sacrifier §d1 coeur permanent§r contre les effets §9speed II§r et §9force I§r pendant 3 minutes");

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Electrique\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent\n \nA l'annonce des rôles, vous recevez un item nommé 'Foudre' vous permettant de lancer des éclairs sur tous les joueurs du camps rc dans la zone qui vous donne speed II pendant 1 minute\n \nAvec la commande /rcsacrifice, vous perdez un coeur permanent et les effets force I, speed II et no fall pendant 2 minutes\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}