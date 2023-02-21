package fr.gameblack.rubisuhc.roles.demons;

import fr.gameblack.rubisuhc.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cosmos {

    public static void Items(Player player, Main main) {

        Texte(player);
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Zone de speed");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);
        main.addPourcentEffet(player, "force", 0.15);

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Cosmos\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nUne fois dans la partie, vous pourrez créer une zone qui vous donne speed I pendant 3 minutes\n \nLorque vous tué un joueur vous avez le choix entre 3 options :\n- Récupérer un poucentage de speed ou de résistance (aléatoire)\n-Transformer le joueur tué en zombie qui doit désormais gagner avec les démons. Le joueur ressusciter réaparaîtra uniquement avec 10 pommes d'or, une épée en diamant, un full fer et l'effet speed I\n- Récupérer une utilisation de sa zone\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}
