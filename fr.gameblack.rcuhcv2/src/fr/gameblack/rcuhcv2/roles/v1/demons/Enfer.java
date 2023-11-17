package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Enfer {

    public static void Items(Joueur joueur, Main main) {

    	Player player = joueur.getPlayer();
    	
        Texte(player);

        joueur.addForce(main.getForceIBaseV1());

        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        meta.addStoredEnchant(Enchantment.ARROW_FIRE, 1, true);
        book.setItemMeta(meta);

        ItemStack book2 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta2 = (EnchantmentStorageMeta) book2.getItemMeta();
        meta2.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true);
        book2.setItemMeta(meta2);

        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Zone de feu");
        coffre.setItemMeta(coffreM);

        player.getInventory().addItem(coffre);
        player.getInventory().addItem(book);
        player.getInventory().addItem(book2);

    }

    public static void InteractFeu(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        if (!joueur.getCD().contains(Pouvoirs.ENFER_ZONE)) {

            joueur.getCD().add(Pouvoirs.ENFER_ZONE);

            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 0, false, false));

            if (main.getJoueurByRole(Roles.Slup) != null) {

                Joueur slup = main.getJoueurByRole(Roles.Slup);

                slup.getPlayer().sendMessage("Le démon enfer a utilisé son item 'Zone de feu'");

            }

            List<Joueur> fire = new ArrayList<>();

            for (Entity nearbyEntities : player.getNearbyEntities(20, 20, 20)) {

                if (nearbyEntities instanceof Player) {

                    Player pls = (Player) nearbyEntities;
                    
                    Joueur j = main.getJoueur(pls);

                    if (j.getCamp().equalsIgnoreCase("demon")) {

                        fire.add(j);

                        int slot = -1;
                        int i = 0;

                        for (ItemStack itemStack : pls.getInventory().getContents()) {

                            if (itemStack != null) {
                                if (itemStack.getType() == Material.DIAMOND_SWORD) {

                                    slot = i;

                                }

                            }
                            i += 1;

                        }
                        if (slot != -1) {

                            ItemMeta epeeM = pls.getInventory().getItem(slot).getItemMeta();
                            epeeM.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
                            ItemStack epee = pls.getInventory().getItem(slot);
                            epee.setItemMeta(epeeM);
                            pls.getInventory().setItem(i, epee);
                            pls.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 0, false, false));


                        }

                    }

                }

            }

            ItemCD cycle = new ItemCD(main, joueur, "fire", 60, joueur, null, fire, 0, null);
            cycle.runTaskTimer(main, 0, 20);

        } else {

            player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Enfer\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nA l'annonce des rôles, vous recevez un livre fire aspect I, un livre flame I et un item nommé 'Zone de feu' vous permettant de créer une zone où tous les joueurs auront fire aspect et où tous les démons dont vous aurons l'effet résistance au feu\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}