package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Joko {

	public static void Items(Player player) {
		
		Texte(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("SpeedCubing");
		coffre.setItemMeta(coffreM);
		player.getInventory().addItem(coffre);
		
	}
	
	public static void InteractSpeedcubing(Player player, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.JOKO_CUBE)) {
		
			if(main.getRoles().contains(Roles.SLUP)) {
				
				Player slup = main.getPlayerByRole(Roles.SLUP);
				
				slup.sendMessage("Joko a utilisé son item 'SpeedCubing'");
				
			}
			
			main.setJokoItem(true);
			main.addPourcentEffet(player, "speed", 0.1);
			ItemCD cycle = new ItemCD(main, player, "cube", 60, player, null, null);
			cycle.runTaskTimer(main, 0, 20);
			main.getCD().add(Pouvoirs.JOKO_CUBE);
			
		}
		else {
			
			player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aJoko\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet speed I permanent\n \nA l'annonce des rôles, vous recevez un item nommé '§dSpeedCubing§r' vous permettant de recevoir 10% de speed supplémentaire pendant 1 minute.\nChaque coup que vous mettez pendant ce pouvoir à 2% de chance par rubik's cube, que le joueur taper soit stun\n \nA la fin de votre pouvoir, vous recevez 2% de speed permanent et, si vous avez stun au moins un joueur, vous pourrez, avec la commande /rcsteal, voler 3% de force ou 3% de resistance au premier joueur stun\n \nVous possèdez la commande /rccube qui permet de donner un cube à un joueur (5 minutes de cooldown)\n \nA chaque mort d'un membre du staff de Rubis Craft, vous recevez 3% de force supplémentaire\n \nLorsque GameBlack meurt, vous recevez 5% de force et 5% de résistance\n \n____________________________________________________");
		
	}
	
	public static void CommandCube(Player player, Player cible, Main main) {
		
		main.addCube(cible);
		player.sendMessage(cible.getName() + " possède maintenant " + main.getCube(cible) + " rubik's cube");
		main.getCD().add(Pouvoirs.JOKO_GIVECUBE);
		ItemCD cycle = new ItemCD(main, player, "givecube", 300, cible, null, null);
		cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void CommandSteal(Player player, Main main, String effet) {
		
		if(main.getStun().size() != 0) {
		
			Player cible = main.getStun().get(0);
			
			if(effet == "force") {
				
				main.removePourcentEffet(cible, "force", 0.03);
				main.addPourcentEffet(player, "force", 0.03);
				main.getStun().clear();
				player.sendMessage("Vous avez voler 3% de force à " + cible.getName());
				
			}
			else if(effet == "resi" || effet == "resistance") {
				
				main.removePourcentEffet(cible, "resi", 0.03);
				main.addPourcentEffet(player, "resi", 0.03);
				main.getStun().clear();
				player.sendMessage("Vous avez voler 3% de résistance à " + cible.getName());
				
			}
			else {
				
				player.sendMessage("Merci de mettre un effet valide ('force', 'resi', 'resistance')");
				
			}
			
		}
		
	}
	
}
