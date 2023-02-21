package fr.gameblack.rubisuhc.listeners;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.State;
import fr.gameblack.rubisuhc.orbes.Glace;
import fr.gameblack.rubisuhc.roles.demons.Tronconeuse;
import fr.gameblack.rubisuhc.task.ItemCD;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class GDamageListeners implements Listener {

    private Main main;

    public GDamageListeners(Main main) {
        this.main = main;
    }

    public static void Mort(Player player, Player killer, Main main, EntityDamageByEntityEvent event) {

        Entity damager = event.getDamager();

        if (main.getRole(player) == Roles.TRIAL) {

            if (main.getCampsDemonVie().contains(Roles.TRONCONEUSE)) {

                Tronconeuse.ItemsKillTrial(main.getPlayerByRole(Roles.TRONCONEUSE), main);

            }

        }

        if ((main.getRole(player) == Roles.LOUP || main.getRole(player) == Roles.MAKA || main.getRole(player) == Roles.TEAM) && (main.getCampsRCVie().contains(Roles.JOKO) || (main.getCampsDemonVie().contains(Roles.TRIAL) && main.getVolTrial().contains("mort_joko")))) {

            if (main.getCampsRCVie().contains(Roles.JOKO)) {

                main.addPourcentEffet(main.getPlayerByRole(Roles.JOKO), "force", 0.03);
                main.getPlayerByRole(Roles.JOKO).sendMessage("Vous avez reçu 3% de force car un membre du staff de Rubis Craft est mort");

            } else {

                main.addPourcentEffet(main.getPlayerByRole(Roles.TRIAL), "force", 0.03);
                main.getPlayerByRole(Roles.TRIAL).sendMessage("Vous avez reçu 3% de force car un membre du staff de Rubis Craft est mort");

            }

        }

        if (main.getRole(player) == Roles.GAMEBLACK && main.getCampsRCVie().contains(Roles.JOKO)) {

            main.addPourcentEffet(main.getPlayerByRole(Roles.JOKO), "force", 0.05);
            main.addPourcentEffet(main.getPlayerByRole(Roles.JOKO), "resi", 0.05);
            main.getPlayerByRole(Roles.JOKO).sendMessage("Vous avez reçu 5% de force et 5% de résistance car GameBlack est mort");

        }

        if (main.getRole(killer) == Roles.MALEDICTION) {

            if (killer.getMaxHealth() <= 24) {

                killer.setMaxHealth(killer.getMaxHealth() + 2);

            }

        }

        if (event != null) {

            if (main.getRole(player) == Roles.TOINOU) {

                if (main.ToinouCanRespawn()) {

                    main.ToinouRespawn();
                    event.setCancelled(true);
                    player.setHealth(player.getMaxHealth());

                }

            }

            if (damager instanceof Arrow) {

                Arrow arrow = (Arrow) damager;
                if (arrow.getShooter() instanceof Player) {
                    killer = (Player) arrow.getShooter();
                }

            }

        }

        if (main.getRole(killer) == Roles.TRONCONEUSE) {

            if (main.getOrbe(player) != Orbe.NONE && main.getOrbe(killer) == Orbe.NONE) {

                main.setOrbeKill(main.getOrbe(player));
                killer.sendMessage(player.getName() + " possède une orbe, vous pouvez donc choisir de lui voler son orbe (orbe de " + main.getOrbe(player).toString().toLowerCase() + ") avec la commande /rcsteal");


            }

        }

        if (main.getTueurNeko() == player && main.getCampsRCVie().contains(Roles.MAKA)) {

            if (main.getRole(killer) == Roles.MAKA) {

                if (main.hasFindTueurNeko()) {

                    killer.sendMessage("Vous venez de tuer le tueur de neko. Vous recevez donc 5% de force, 3% de speed et 3% de résistance et vous récupérez vos 2% de speed perdu");

                } else {

                    killer.sendMessage("Vous venez de tuer le tueur de neko. Vous recevez donc 5% de force, 3% de speed et 3% de résistance");

                }

            } else {

                Player maka = main.getPlayerByRole(Roles.MAKA);

                if (main.hasFindTueurNeko()) {

                    maka.sendMessage("Le tueur de Neko viens de mourrir, vous recevez donc 2% de force et récuperez vos 2 % de speed");

                } else {

                    maka.sendMessage("Le tueur de Neko viens de mourrir, vous recevez donc 2% de force");

                }

            }

        }

        if (main.getRole(killer) == Roles.LOUP) {

            if (main.getPourcentEffet(killer, "speed") != 0.25) {

                main.addPourcentEffet(killer, "speed", 0.05);
                main.getPlayerByRole(Roles.LOUP).sendMessage("Vous venez de faire un kill, vous recevez donc 5% de speed supplémentaire");

            }

        }

        if (main.getRole(killer) == Roles.EXPERIMENTAL) {

            main.addPourcentEffet(killer, "speed", 0.05);

        }

        if (main.getRole(killer) == Roles.DEMON) {

            if (main.getEffetDemon() == "speed") {

                main.addPourcentEffet(killer, "speed", 0.05);

            } else {

                main.addPourcentEffet(killer, "force", 0.05);

            }

        }

        if (main.getRole(killer) == Roles.TRIAL) {

            if (main.getRole(player) == Roles.RAPTOR) {

                main.setTrialKillRaptor();
                killer.sendMessage("Vous venez de tuer Raptor, vous recevez donc l'effet résistance I permanent");

            } else if (main.getRole(player) == Roles.KZOU) {

                killer.sendMessage("Vous venez de tuer Kzou, vous recevez donc 5 pommes d'or");
                killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));

            }

            if (main.GetCampsRC().contains(main.getRole(player))) {

                main.setOrbeKillTrial(main.getOrbe(player));
                main.setRoleKillTrial(main.getRole(player));
                killer.sendMessage(player.getName() + " fait partie du camps RC, vous pouvez donc choisir de lui voler son orbe (orbe de " + main.getOrbe(player).toString().toLowerCase() + ") avec la commande /rcsteal orbe, ou de lui voler une spécificité de son rôle avec la commande /rcsteal pouvoir");

            }

            if (main.getVolTrial().contains("kill_loup")) {

                if (main.getPourcentEffet(killer, "speed") != 0.25) {

                    killer.sendMessage("Vous venez de faire un kill, vous recevez donc 5%¨de speed supplémentaire");

                    main.addPourcentEffet(killer, "speed", 0.05);

                }

            }

            if (main.getVolTrial().contains("vie_gb")) {

                killer.sendMessage("Vous venez de faire un kill, vous recevez donc 1 coeur supplémentaire");
                killer.setMaxHealth(killer.getMaxHealth() + 2);

            } else {

                killer.sendMessage("Vous venez de faire un kill, vous recevez donc 1 demi-coeur supplémentaire");
                killer.setMaxHealth(killer.getMaxHealth() + 1);

            }

        }

        if (main.getRole(killer) == Roles.GAMEBLACK) {

            if (main.getPacteGB() == 2) {

                killer.sendMessage("Vous venez de faire un kill, vous recevez donc 1 coeur supplémentaire");
                killer.setMaxHealth(killer.getMaxHealth() + 2);

            }

        }

        if (main.getRole(killer) == Roles.TENEBRE) {

            killer.sendMessage("Vous venez de faire un kill, vous recevez donc 3% de force supplémentaire");

            main.addPourcentEffet(killer, "force", 0.03);

        }

        if (main.getRole(killer) == Roles.TOINOU) {

            if (main.ToinouKill(Roles.TENEBRE)) {

                main.addKillToinou(Roles.TENEBRE);

                main.addPourcentEffet(killer, "force", 0.03);

            }

            if (main.getRole(player) == Roles.TRIAL) {

                main.addKillToinou(Roles.TRIAL);

                main.addPourcentEffet(killer, "force", 0.15);

            } else if (main.getRole(player) == Roles.SLUP) {

                main.addKillToinou(Roles.SLUP);

                main.addPourcentEffet(killer, "resi", 0.05);

            } else if (main.getRole(player) == Roles.ANGE) {

                main.addKillToinou(Roles.ANGE);

                killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));

            } else if (main.getRole(player) == Roles.AVENIR) {

                main.ToinouKillAvenir();

            } else if (main.getRole(player) == Roles.COSMOS) {

                main.addKillToinou(Roles.COSMOS);

                ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                ItemMeta coffreM = coffre.getItemMeta();
                coffreM.setDisplayName("Zone de speed");
                coffre.setItemMeta(coffreM);
                killer.getInventory().addItem(coffre);

            } else if (main.getRole(player) == Roles.DEMON) {

                main.addKillToinou(Roles.DEMON);

                if (main.getEffetDemon() == "force") {

                    double force = 1 - main.getPourcentEffet(player, "force");
                    main.addPourcentEffet(killer, "force", force);

                } else {

                    double speed = 1 - main.getPourcentEffet(player, "speed");
                    main.addPourcentEffet(killer, "speed", speed);

                }

            } else if (main.getRole(player) == Roles.ELECTRIQUE) {

                main.addKillToinou(Roles.ELECTRIQUE);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

            } else if (main.getRole(player) == Roles.ENFER) {

                killer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false));
                main.addKillToinou(Roles.ENFER);

            } else if (main.getRole(player) == Roles.MALEDICTION) {

                main.addKillToinou(Roles.MALEDICTION);
                //peut mettre des malédiction (lvl1 et 2)

            } else if (main.getRole(player) == Roles.SANG) {

                main.addKillToinou(Roles.SANG);
                //gagne sa commande

            } else if (main.getRole(player) == Roles.MALIVOL) {

                main.addKillToinou(Roles.MALIVOL);

                ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                ItemMeta coffreM = coffre.getItemMeta();
                coffreM.setDisplayName("Cheat");
                coffre.setItemMeta(coffreM);

                player.getInventory().addItem(coffre);

            } else if (main.getRole(player) == Roles.TRONCONEUSE) {

                main.addKillToinou(Roles.TRONCONEUSE);
                //effet saignement

            }
        }

        Random r = new Random();
        int nb = r.nextInt(2);

        if (main.getCampsRCVie().contains(Roles.TEAM) || (main.getCampsDemonVie().contains(Roles.TRIAL) && main.getVolTrial().contains("mort_team"))) {

            Player team;

            if (main.getCampsRCVie().contains(Roles.TEAM)) {

                team = main.getPlayerByRole(Roles.TEAM);

            } else {

                team = main.getPlayerByRole(Roles.TRIAL);

            }

            if (nb == 1) {

                if (main.GetCampsRC().contains(main.getRole(player))) {

                    team.sendMessage("Le joueur " + killer.getName() + " a tué le joueur " + player.getName());

                }

            } else {

                if (main.GetCampsRC().contains(main.getRole(player))) {

                    team.sendMessage("Le role " + main.getRole(killer) + " a tué le joueur " + player.getName());

                }

            }

        }

    }

    @EventHandler
    public void onPvp(EntityDamageByEntityEvent event) {
        Entity victim = event.getEntity();

        if (victim instanceof Player) {
            Player player = (Player) victim;

            Entity damager = event.getDamager();
            Player killer = player;

            double damage;

            if (damager instanceof Player) killer = (Player) damager;

            if (main.getState() == State.PVP_ON || !main.getInvulnerable().contains(victim) || !main.getInvulnerable().contains(killer)) {

                main.setLastHit(player, killer);

                //if(!player.hasPotionEffect(PotionEffectType.ABSORPTION)) {

                //damage = 1-(main.getPourcentEffet(player, "resi")-1);
                //damage *= event.getFinalDamage()*0.15;
                //damage *= main.getPourcentEffet(killer, "force");
                //event.setDamage(damage);

                //}
                //else {

                //if(event.getFinalDamage() < 4) {

                //damage = event.getFinalDamage();

                //}
                //else {

                //damage = 4;

                //}

                //}

                if (!player.hasPotionEffect(PotionEffectType.ABSORPTION)) {

                    if (main.getPourcentEffet(player, "resi") == 1) {

                        damage = event.getFinalDamage() * 1.15;
                        damage *= main.getPourcentEffet(killer, "force");
                        event.setDamage(damage);

                    } else if (main.getPourcentEffet(player, "resi") < 1) {

                        damage = 1 + (1 - main.getPourcentEffet(player, "resi"));
                        damage *= event.getFinalDamage() * 1.15;
                        damage *= main.getPourcentEffet(killer, "force");
                        event.setDamage(damage);

                    } else {

                        damage = 1 - (main.getPourcentEffet(player, "resi") - 1);
                        damage *= event.getFinalDamage() * 1.15;
                        damage *= main.getPourcentEffet(killer, "force");
                        event.setDamage(damage);

                    }

                    if (main.getRole(player) == Roles.ANGE) {

                        Random r = new Random();
                        int nb = r.nextInt(4);

                        if (nb == 1) {

                            main.addPointAnge();

                        }

                    }

                } else {

                    damage = event.getFinalDamage();

                }

                if (main.getRole(killer) == Roles.TRONCONEUSE || (main.getRole(killer) == Roles.TOINOU && main.ToinouKill(Roles.TRONCONEUSE))) {

                    if (main.getSaigne() == null) {

                        Random r = new Random();
                        int nb = r.nextInt(100);

                        if (nb < 6) {

                            main.addSaigne(player);
                            main.addNbSaigne();
                            player.damage(1);
                            ItemCD cycle = new ItemCD(main, killer, "saigne", 10, player, null, null);
                            cycle.runTaskTimer(main, 0, 20);

                        }

                    }

                }

                if (main.getRole(killer) == Roles.JOKO && main.isJokoItem()) {

                    if (main.getCube(player) != 0 && !main.getStun().contains(player)) {

                        Random r = new Random();
                        int nb = r.nextInt(100);
                        int pourcent = main.getCube(player) * 2;

                        if (nb < pourcent + 1) {

                            main.Stun(killer, 200, player);
                            main.removeCube(player);
                            main.getStun().add(player);

                            killer.sendMessage("Vous venez de stun " + player.getName());

                            ItemCD cycle = new ItemCD(main, killer, "stun", 10, player, null, null);
                            cycle.runTaskTimer(main, 0, 20);

                        }

                    }

                }

                if (main.getRole(killer) == Roles.EXPERIMENTAL) {

                    Random r = new Random();
                    int nb = r.nextInt(100);

                    if (nb < 3) {

                        main.Stun(killer, 80, player);
                        ItemCD cycle = new ItemCD(main, killer, "stun", 4, player, null, null);
                        cycle.runTaskTimer(main, 0, 20);
                        killer.sendMessage("Vous venez de stun " + player.getName());

                    }

                }

                if ((main.getRole(player) == Roles.MALIVOL && main.getMalivolCheat() == 4) || (main.getRole(player) == Roles.TOINOU && main.ToinouKill(Roles.MALIVOL))) {

                    event.setCancelled(true);
                    player.damage(damage);

                }

                if (main.getRole(killer) == Roles.FARMEURIMMO) {

                    if (main.isAbsoFarmeur()) {

                        if (player.hasPotionEffect(PotionEffectType.ABSORPTION))
                            player.removePotionEffect(PotionEffectType.ABSORPTION);

                    }

                }

                if (main.getRole(killer) == Roles.TOINOU && main.ToinouKill(Roles.ENFER)) {

                    Random r = new Random();
                    int nb = r.nextInt(100);

                    if (nb < 21) {

                        player.setFireTicks(200);

                    }

                }

                if (main.getOrbe(killer) == Orbe.GLACE && main.isOrbeActif(killer)) {

                    Glace.Freeze(player);

                }

                if (main.getOrbe(killer) == Orbe.FEU && main.isOrbeActif(killer)) {

                    Random r = new Random();
                    int nb = r.nextInt(100);

                    if (nb < 11) {

                        player.setFireTicks(200);

                    }

                }

                if (player.getHealth() <= damage) {

                    ItemCD cycle = new ItemCD(main, killer, "mort", 10, player, event, null);
                    cycle.runTaskTimer(main, 0, 20);
                    event.setDamage(0);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");


                }

            } else {

                event.setCancelled(true);

            }

        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Entity victim = event.getEntity();

        if (!main.getInvulnerable().contains(victim)) {

            if (victim instanceof Player) {

                Player player = (Player) victim;

                if ((event.getCause() == DamageCause.FALL && main.getRole(player) == Roles.MAKA) || (event.getCause() == DamageCause.FALL && main.getRole(player) == Roles.MALIVOL && main.getMalivolCheat() == 2) || (event.getCause() == DamageCause.FALL && main.getRole(player) == Roles.TOINOU && main.getMalivolCheat() == 2 && main.ToinouKill(Roles.MALIVOL)) || event.getCause() == DamageCause.FALL && main.getRole(player) == Roles.EXPERIMENTAL || event.getCause() == DamageCause.FALL && (main.getRole(player) == Roles.ELECTRIQUE && main.isNofallElec()) || event.getCause() == DamageCause.FALL && (main.getRole(player) == Roles.TRIAL && main.getVolTrial().contains("nofall_maka"))) {

                    event.setCancelled(true);

                }

            }

            if (event.getCause() == DamageCause.FIRE || event.getCause() == DamageCause.BLOCK_EXPLOSION || event.getCause() == DamageCause.POISON || event.getCause() == DamageCause.THORNS || event.getCause() == DamageCause.WITHER) {

                if (victim instanceof Player) {

                    Player player = (Player) victim;
                    double damage;

                    if (!player.hasPotionEffect(PotionEffectType.ABSORPTION)) {

                        damage = 1 - (main.getPourcentEffet(player, "resi") - 1);
                        damage *= event.getFinalDamage();
                        event.setDamage(damage);

                    } else {

                        damage = event.getFinalDamage();

                    }

                    if (player.getHealth() <= damage) {
                        event.setDamage(0);
                        Bukkit.broadcastMessage("_________________________\n" + player.getName() + " est mort. Il était : \n" + main.getRole(player) + "\n_________________________");
                        main.eliminate(player, false);

                        Player killer = main.getLastHit(player);

                        ItemCD cycle = new ItemCD(main, killer, "mort", 10, player, null, null);
                        cycle.runTaskTimer(main, 0, 20);
                        event.setDamage(0);
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");

                    }

                }

            }

        } else {

            event.setCancelled(true);

        }

    }

}
