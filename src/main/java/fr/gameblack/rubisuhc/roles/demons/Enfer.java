package fr.gameblack.rubisuhc.roles.demons;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;
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

    public static void Items(Player player, Main main) {

        Texte(player);

        main.addPourcentEffet(player, "force", 0.15);

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

    public static void InteractFeu(Player player, Main main) {

        if (!main.getCD().contains(Pouvoirs.ENFER_ZONE)) {

            main.getCD().add(Pouvoirs.ENFER_ZONE);

            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 0, false, false));

            if (main.getRoles().contains(Roles.SLUP)) {

                Player slup = main.getPlayerByRole(Roles.SLUP);

                slup.sendMessage("Le démon enfer a utilisé son item 'Zone de feu'");

            }

            List<Player> fire = new ArrayList<>();

            for (Entity nearbyEntities : player.getNearbyEntities(20, 20, 20)) {

                if (nearbyEntities instanceof Player) {

                    Player pls = (Player) nearbyEntities;

                    if (main.getCampsDemonVie().contains(main.getRole(pls))) {

                        fire.add(pls);

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

            ItemCD cycle = new ItemCD(main, player, "fire", 60, player, null, fire);
            cycle.runTaskTimer(main, 0, 20);

        } else {

            player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Enfer\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nA l'annonce des rôles, vous recevez un livre fire aspect I, un livre flame I et un item nommé 'Zone de feu' vous permettant de créer une zone où tous les joueurs auront fire aspect et où tous les démons dont vous aurons l'effet résistance au feu\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}
