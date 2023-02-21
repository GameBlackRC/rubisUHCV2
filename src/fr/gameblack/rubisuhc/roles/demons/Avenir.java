package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;

public class Avenir {
	
	public static void Items(Player player, Main main) {
		
		Texte(player);
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Ressusciter");
		
		player.getInventory().addItem(coffre);
		main.addPourcentEffet(player, "force", 0.15);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Avenir\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I permanent\n \nLorsque vous venez à mourrir, vous êtes enfermer dans un cocon dans le sol\n\nSi ce cocon n'est pas casser au bout de 15 secondes, vous réaparaissez aléatoirement sur la map avec 1 coeur permanent en moins\n \nS'il vous reste 3 coeurs permanent et que vous venez à mourrir, vous ne pouvez pas réaparraître et votre mort seras définitive\n \nContre 2 coeurs permanent, vous pouvez, une fois dans la partie, ressusciter un joueur du camps rc avant que sa mort s'affiche\nLe joueur ressusciter devra gagner avec les démons et gardera tous ses pouvoirs\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
