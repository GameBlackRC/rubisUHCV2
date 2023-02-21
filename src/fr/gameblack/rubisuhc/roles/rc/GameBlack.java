package fr.gameblack.rubisuhc.roles.rc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;

public class GameBlack {

	public static void Items(Player player, Main main) {
		
		Texte(player);
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Pactes");
		coffre.setItemMeta(coffreM);
		player.getInventory().addItem(coffre);
		
		main.addPourcentEffet(player, "force", 0.15);
		
	}
	
	public static void InteractChest(Player player) {
		
		Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Choix du pacte");
		inv_pacte.setItem(11, Main.getItem(Material.APPLE, "Pacte 1", "En échange de 2 coeurs permanent,;vous obtenez l'effet speed I permanent et;vous pouvez utilisé la commande /rcrecrut"));
		inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_SWORD, "Pacte 2", "En échange de 3 coeurs permanent,;vous recevez une épée en diamant tranchant III (ou 2 diamants si vous avez déjà une épée).;Pour chaque kill vous recevrez 1 coeur en plus.;Vous pouvez aussi utilisé la commande /rcinspect"));
		player.openInventory(inv_pacte);
		
	}
	
	public static void InteractApple(Player player, Main main) {
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		player.setMaxHealth(16);
		main.setPacteGB(1);
		player.getInventory().remove(Material.NETHER_STAR);
		player.sendMessage("Vous avez choisis le pacte 1");
		
	}
	
	public static void InteractSword(Player player, Main main) {
		
		player.setMaxHealth(14);
		if(!player.getInventory().contains(new ItemStack(Material.DIAMOND_SWORD,1))) {
			
			ItemStack coffre = new ItemStack(Material.DIAMOND_SWORD,1);
			ItemMeta coffreM = coffre.getItemMeta();
			coffreM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
			coffre.setItemMeta(coffreM);
			player.getInventory().addItem(coffre);
			
		}
		else {
			
			ItemStack coffre = new ItemStack(Material.DIAMOND,2);
			player.getInventory().addItem(coffre);
			
		}
		main.setPacteGB(2);
		player.getInventory().remove(Material.NETHER_STAR);
		player.sendMessage("Vous avez choisis le pacte 2");
		
	}
	
	public static void CommandNerf(Player player, Main main) {
		
		main.getCD().add(Pouvoirs.GB_NERF);
		
		Random r = new Random();
		int nb = r.nextInt(2);
		
		if(nb == 1) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, false, false));
		}
		else {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, false, false));
		}
		
	}
	
	public static void CommandRecrut(Player player, Player cible, Main main) {
		
		main.getCD().add(Pouvoirs.GB_RECRUT);
		
		if(main.getRole(cible) == Roles.FARMEURIMMO || main.getRole(cible) == Roles.GAMEBLACK || main.getRole(cible) == Roles.JOKO || main.getRole(cible) == Roles.MAKA || main.getRole(cible) == Roles.LOUP || main.getRole(cible) == Roles.TEAM || main.getRole(cible) == Roles.TRIAL) {
			
			player.sendMessage("§aCe joueur fait partie du staff de Rubis Craft");
			
		}
		else {
			
			player.sendMessage("§cCe joueur ne fait pas partie du staff de Rubis Craft");
			
		}
		
	}
	
	public static void CommandInspect(Player player, Player cible, Main main) {
		
		main.getCD().add(Pouvoirs.GB_INSPECT);
		
		List<String> effets = new ArrayList<>();
		if(cible.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			
			effets.add("§7résistance");
			
		}
		else if(cible.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
			
			effets.add("§ehaste");
			
		}
		else if(cible.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
			
			effets.add("§6résistance au feu");
			
		}
		else if(main.getPourcentEffet(cible, "force") >= 1.25) {
			
			effets.add("§cforce");
			
		}
		else if(cible.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			
			effets.add("§binvisibilité");
			
		}
		else if(cible.hasPotionEffect(PotionEffectType.SPEED)) {
			
			effets.add("§9rapidité");
			
		}
		else if(cible.hasPotionEffect(PotionEffectType.WEAKNESS)) {
			
			effets.add("§4faiblesse");
			
		}
		
		if(effets.size() == 0) {
			
			player.sendMessage("§cCe joueur n'a pas d'effet");
			
		}
		else {
			
			Random r = new Random();
			int nb = r.nextInt(effets.size());
			
			player.sendMessage("Ce joueur possède l'effet " + effets.get(nb));
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet §9force I §rpermanent\n \nA l'annonce des rôles, vous recevez un item nommé '§dPactes§r' vous permettant de choisir entre 2 pactes :\n- Pacte 1 : Contre §92 coeurs §rpermanents, vous recevez l'effet §9speed I §ret vous possèdez la commande §b/rcrecrut §rqui vous permet de savoir si le joueur fait parti du staff de Rubis Craft\n- Pacte 2 : Contre §93 coeurs §rpermanents, vous recevez une §dépée en diamant tranchant III §r(§d2 diamants §rsi vous en avez déjà une) et à chaque kill effectuer, vous recevez §91 coeur §rpermanent supplémentaire. Vous possèdez aussi la commande §b/rcinspect §rqui vous permet de connaitre un effet de la personne ciblé\n \nVous possèdez la commande §b/rcnerf §rvous permettant de donner aléatoirement l'effet §9faiblesse I §rou §9lenteur I §rpendant 10 secondes\n \n____________________________________________________");
		
	}
	
}
