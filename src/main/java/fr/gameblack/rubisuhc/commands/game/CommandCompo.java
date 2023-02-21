package fr.gameblack.rubisuhc.commands.game;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

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

            if (args.length != 0 && args[0] == "gui") {

                compoGUI(player);

            } else {

                String txt = "Camps RC :";
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.GAMEBLACK)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.GAMEBLACK))) {

                    txt += "\n §aGameBlack§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TEAM)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.TEAM))) {

                    txt += "\n §aTeam§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.JOKO)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.JOKO))) {

                    txt += "\n §aJoko§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MAKA)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.MAKA))) {

                    txt += "\n §aMaka§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.RAPTOR)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.RAPTOR))) {

                    txt += "\n §aRaptor§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.LOUP)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.LOUP))) {

                    txt += "\n §aLoup§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TOINOU)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.TOINOU))) {

                    txt += "\n §aToinou§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.GUERRIER)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.GUERRIER))) {

                    txt += "\n §aGuerrier§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.ARCHER)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.ARCHER))) {

                    txt += "\n §aArcher§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.ECLAIREUR)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.ECLAIREUR))) {

                    txt += "\n §aEclaireur§r(1)";

                }
                txt += "\n§cCamps Démon :";
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TRIAL)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.TRIAL))) {

                    txt += "\n §cTrial§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.SLUP)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.SLUP))) {

                    txt += "\n §cSlup§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MALIVOL)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.MALIVOL))) {

                    txt += "\n §cMalivol§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.OBSCUR)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.OBSCUR))) {

                    txt += "\n §cObscur§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.ANGE)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.ANGE))) {

                    txt += "\n §cDémon Ange§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.AVENIR)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.AVENIR))) {

                    txt += "\n §cDémon Avenir§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.COSMOS)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.COSMOS))) {

                    txt += "\n §cDémon Cosmos§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.ELECTRIQUE)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.ELECTRIQUE))) {

                    txt += "\n §cDémon Electrique§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.ENFER)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.ENFER))) {

                    txt += "\n §cDémon Enfer§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MALEDICTION)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.MALEDICTION))) {

                    txt += "\n §cDémon Malédiction§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.SANG)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.SANG))) {

                    txt += "\n §cDémon Sang§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TENEBRE)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.TENEBRE))) {

                    txt += "\n §cDémon Ténèbre§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TRONCONEUSE)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.TRONCONEUSE))) {

                    txt += "\n §cDémon Tronconeuse§r(1)";

                }

                txt += "\n§6Solos :";

                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.FARMEURIMMO)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.FARMEURIMMO))) {

                    txt += "\n §6Farmeurimmo§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.KZOU)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.KZOU))) {

                    txt += "\n §6Kzou§r(1)";

                }
                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.EXPERIMENTAL)) || (main.getCampsRCVie().size() != 0 && main.getCampsRCVie().contains(Roles.EXPERIMENTAL))) {

                    txt += "\n §6Démon Expérimental§r(1)";

                }

                sender.sendMessage(txt);

            }

        }

        return false;

    }

}
