package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandCompo implements CommandExecutor {

    private Main main;

    public CommandCompo(Main main) {
        this.main = main;
    }

    public static void compoGUI(Player player) {

        Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Compo");
        inv_pacte.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "Camp RC", ""));
        inv_pacte.setItem(4, Main.getItem(Material.NETHER_BRICK, "Camp Démon", ""));
        inv_pacte.setItem(5, Main.getItem(Material.GOLD_INGOT, "Solo", ""));

        inv_pacte.setItem(9, Main.getItem(Material.CHEST, "GameBlack", ""));
        inv_pacte.setItem(10, Main.getItem(Material.EMERALD_BLOCK, "Team", ""));
        inv_pacte.setItem(11, Main.getItem(Material.QUARTZ_BLOCK, "Joko", ""));
        inv_pacte.setItem(12, Main.getItem(Material.LAVA_BUCKET, "Maka", ""));
        inv_pacte.setItem(13, Main.getItem(Material.DIAMOND_SWORD, "Toinou", ""));
        inv_pacte.setItem(14, Main.getItem(Material.SUGAR, "Loup", ""));
        inv_pacte.setItem(15, Main.getItem(Material.REDSTONE, "Raptor", ""));
        inv_pacte.setItem(16, Main.getItem(Material.IRON_SWORD, "Guerrier", ""));
        inv_pacte.setItem(17, Main.getItem(Material.BOW, "Archer", ""));
        inv_pacte.setItem(18, Main.getItem(Material.GLASS, "Eclaireur", ""));

        player.openInventory(inv_pacte);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length != 0 && args[0].equalsIgnoreCase("gui")) {

                compoGUI(player);

            } else {

                String txt = "§aCamp Joueur :";
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.RAPTOR))) {

                    txt += "\n §aRaptor§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.JEANNOT))) {

                    txt += "\n §aJeannot§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.NICKOBOOP))) {

                    txt += "\n §aNickoboop§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.SLUP))) {

                    txt += "\n §aSlup§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.JOKO))) {

                    txt += "\n §aJoko§r(1)";

                }
                
                txt += "\n§9Camp Staff :";
                
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TEAM))) {

                    txt += "\n §9Team§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.GAMEBLACK))) {

                    txt += "\n §9GameBlack§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MAKA))) {

                    txt += "\n §9Maka§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TRIAL))) {

                    txt += "\n §9Trial§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.LOUP))) {

                    txt += "\n §9Loup§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.CAPTAIN))) {

                    txt += "\n §9Captain§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.HEKOW))) {

                    txt += "\n §9Hekow§r(1)";

                }
                txt += "\n§2Camp UHC :";
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MALIVOL))) {

                    txt += "\n §2Malivol§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TOINOU))) {

                    txt += "\n §2Toinou§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.OBSCUR))) {

                    txt += "\n §2Obscur§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.NONOBOY))) {

                    txt += "\n §2Nonoboy§r(1)";

                }

                txt += "\n§6Solos :";

                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.FARMEURIMMO))) {

                    txt += "\n §6Farmeurimmo§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.KZOU))) {

                    txt += "\n §6Kzou§r(1)";

                }

                sender.sendMessage(txt);

            }

        }

        return false;

    }

}
