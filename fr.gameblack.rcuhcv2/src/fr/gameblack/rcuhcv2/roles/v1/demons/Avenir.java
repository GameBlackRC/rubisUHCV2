package fr.gameblack.rcuhcv2.roles.v1.demons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;


public class Avenir {

    public static void Items(Joueur joueur) {

        Texte(joueur.getPlayer());
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Ressusciter");

        joueur.getPlayer().getInventory().addItem(coffre);
        joueur.addForce(0.15);

    }
    
    public static void CommandRevive(Player player, Main main) {
    	
    	
    	
    }
    
    public static void Mort(Player player, Main main) {
    	
    	
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Avenir\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nLorsque vous venez à mourrir, vous êtes enfermer dans un cocon dans le sol\n\nSi ce cocon n'est pas casser au bout de 15 secondes, vous réaparaissez aléatoirement sur la map avec 1 coeur permanent en moins\n \nS'il vous reste 3 coeurs permanent et que vous venez à mourrir, vous ne pouvez pas réaparraître et votre mort seras définitive\n \nContre 2 coeurs permanent, vous pouvez, une fois dans la partie, ressusciter un joueur du camps rc avant que sa mort s'affiche\nLe joueur ressusciter devra gagner avec les démons et gardera tous ses pouvoirs\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}