package fr.gameblack.rubisuhc.task;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.listeners.GDamageListeners;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItemCD extends BukkitRunnable {

    private Main main;
    private Player player;
    private String item;
    private int timer;
    private Player cible;
    private EntityDamageByEntityEvent event;
    private List<Player> players = new ArrayList<>();

    public ItemCD(Main main, Player player, String item, int timer, Player cible, EntityDamageByEntityEvent event, List<Player> players) {
        this.main = main;
        this.player = player;
        this.item = item;
        this.timer = timer;
        this.cible = cible;
        this.event = event;
        this.players = players;
    }

    @Override
    public void run() {

        if (timer == 0) {
            cancel();
            if (item == "mort") {

                if (main.getRole(player) == Roles.KZOU) {

                    if (main.hasOP()) {

                        main.setOP(false);
                        main.eliminate(cible, true);

                    } else {

                        main.eliminate(cible, false);

                    }

                } else {

                    main.eliminate(cible, false);

                }

                for (ItemStack item : cible.getInventory().getContents()) {

                    if (item != null && item.getType() != Material.NETHER_STAR) {

                        if (item.getItemMeta().hasEnchant(Enchantment.DEPTH_STRIDER)) {

                            ItemMeta itemM = item.getItemMeta();
                            itemM.removeEnchant(Enchantment.DEPTH_STRIDER);
                            item.setItemMeta(itemM);

                        }

                        if (item.getItemMeta().hasEnchant(Enchantment.FIRE_ASPECT)) {

                            ItemMeta itemM = item.getItemMeta();
                            itemM.removeEnchant(Enchantment.FIRE_ASPECT);
                            item.setItemMeta(itemM);

                        }

                        if (item.getItemMeta().hasEnchant(Enchantment.ARROW_FIRE)) {

                            ItemMeta itemM = item.getItemMeta();
                            itemM.removeEnchant(Enchantment.ARROW_FIRE);
                            item.setItemMeta(itemM);

                        }

                        cible.getWorld().dropItemNaturally(cible.getLocation(), item);

                    }

                }

                GDamageListeners.Mort(cible, player, main, event);

            } else if (item == "foudre_malus") {

                main.setMalusOrbe(player, false);
                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");

            } else if (item == "eau_malus") {

                main.addPourcentEffet(player, "speed", 0.05);
                main.setMalusOrbe(player, false);
                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");

            } else if (item == "feu_malus") {

                main.addPourcentEffet(player, "resi", 0.05);
                main.setMalusOrbe(player, false);
                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");

            } else if (item == "glace_malus") {

                main.addPourcentEffet(player, "force", 0.05);
                main.setMalusOrbe(player, false);
                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");

            } else if (main.getRole(player) == Roles.ENFER) {

                if (item == "fire") {

                    for (Player player : players) {

                        int i = 0;

                        for (ItemStack itemStack : player.getInventory().getContents()) {

                            if (itemStack != null) {
                                if (itemStack.getType() == Material.DIAMOND_SWORD) {

                                    ItemMeta itemM = itemStack.getItemMeta();
                                    itemM.removeEnchant(Enchantment.FIRE_ASPECT);

                                    itemStack.setItemMeta(itemM);
                                    player.getInventory().setItem(i, itemStack);

                                }

                            }
                            i += 1;

                        }

                    }

                }

            } else if (main.getRole(player) == Roles.MAKA) {

                if (item == "neko") {

                    if (cible == main.getTueurNeko()) {

                        player.sendMessage("Le joueur " + cible.getName() + " a bien reçu votre cadeau");
                        main.removePourcentEffet(player, "speed", 0.02);
                        main.addPourcentEffet(cible, "speed", 0.02);
                        cible.sendMessage("Vous avez reçu 2% de speed de la part de maka");
                        main.setFindTueurNeko(true);
                        main.getCD().remove(Pouvoirs.MAKA_DON);

                    } else {

                        player.sendMessage("Le joueur " + cible.getName() + " vous a renvoyé le cadeau");

                    }

                }

            } else if (main.getRole(player) == Roles.RAPTOR) {

                if (item == "rage") {

                    main.removePourcentEffet(player, "force", 0.15);

                }

            } else if (main.getRole(player) == Roles.TRONCONEUSE) {

                if (item == "saigne") {

                    cible.damage(1);

                } else if (item == "speed_moins") {

                    main.removePourcentEffet(player, "speed", 0.1);
                    main.removePourcentEffet(player, "force", 0.15);

                } else if (item == "speed_plus") {

                    main.addPourcentEffet(player, "speed", 0.1);

                }

            } else if (main.getRole(player) == Roles.KZOU) {

                if (item == "ban") {

                    cible.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 0, false, false));
                    main.getInvulnerable().remove(cible);

                } else if (item == "disperse") {

                    main.getInvulnerable().remove(cible);

                }

            } else if (main.getRole(player) == Roles.EXPERIMENTAL) {

                main.getInvulnerable().remove(cible);

            } else if (main.getRole(player) == Roles.JOKO) {

                if (item == "cube") {

                    main.removePourcentEffet(player, "speed", 0.08);
                    main.setJokoItem(false);
                    player.sendMessage("Ton pouvoir est fini");
                    if (main.isStun()) {

                        player.sendMessage("Tu peux voler 3% de force ou de résistance à " + main.getStun().get(0).getName() + " (pour choisir fait la commande /rcsteal <force|resi|resistance>)");

                    }

                } else if (item == "stun") {

                    main.removeInvulnerable(cible);

                } else if (item == "givecube") {

                    main.getCD().remove(Pouvoirs.JOKO_GIVECUBE);

                }

            } else if (main.getRole(player) == Roles.LOUP) {

                if (item == "loup") {

                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3600, 0, false, false));
                    if (main.isDay()) {
                        main.removePourcentEffet(player, "force", 0.15);
                    }
                    player.sendMessage("Ton pouvoir est fini");
                    main.setLoupPouvoir(false);

                }

            } else if (main.getRole(player) == Roles.SANG) {

                if (item == "sangforce") {

                    main.removePourcentEffet(cible, "force", 0.15);

                }

            } else if (main.getRole(player) == Roles.ELECTRIQUE) {

                if (item == "sacrifice") {

                    main.setNofallElec(false);
                    main.removePourcentEffet(player, "force", 0.15);

                }

            } else if (main.getRole(player) == Roles.ANGE) {

                if (item == "shopforce") {

                    main.removePourcentEffet(player, "force", 0.15);

                }

            } else if (main.getRole(player) == Roles.MALIVOL) {

                if (item == "speedhack") {

                    if (player.getInventory().getBoots().getType() != null) {

                        ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
                        epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
                        ItemStack epee = player.getInventory().getBoots();
                        epee.setItemMeta(epeeM);
                        player.getInventory().setBoots(epee);

                    }

                } else if (item == "nofall") {

                    main.removePourcentEffet(player, "resi", 0.05);

                } else if (item == "fullcrit") {

                    main.removePourcentEffet(player, "force", 0.20);

                }

                main.setMalivolCheat(0);

            }

        } else if (timer == 8 || timer == 6 || timer == 4 || timer == 2) {

            if (main.getRole(player) == Roles.TRONCONEUSE && item == "saigne") {

                cible.damage(1);

            }

        }

        timer--;

    }

    public ItemStack getItem(Material material, String customName, String desc) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        itM.setLore(Arrays.asList(desc.split(",")));
        itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itM);
        return it;
    }

}

