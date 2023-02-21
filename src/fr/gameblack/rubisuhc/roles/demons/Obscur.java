package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;

public class Obscur {
	
	public static void Items(Player player) {
		
		Texte(player);
			
		int slot_arc = -1;
		int slot_epee = -1;
		int i = 0;
				
		for (ItemStack itemStack : player.getInventory().getContents()) {
					
			if(itemStack != null) {
				if (itemStack.getType() == Material.BOW) {
							
					slot_arc = i;
							
				}
				else if (itemStack.getType() == Material.DIAMOND_SWORD) {
						
					slot_epee = i;
						
				}
				
			}
			i += 1;
					
		}
		if(slot_arc != -1) {
					
			ItemMeta epeeM = player.getInventory().getItem(slot_arc).getItemMeta();
			epeeM.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
			ItemStack epee = player.getInventory().getItem(slot_arc);
			epee.setItemMeta(epeeM);
					
		}
		else {
			
			ItemStack pioche = new ItemStack(Material.BOW,1);
			ItemMeta piocheM = pioche.getItemMeta();
			piocheM.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
			pioche.setItemMeta(piocheM);
			player.getInventory().addItem(pioche);
				
		}
		if(slot_epee != -1) {
				
			ItemMeta epeeM = player.getInventory().getItem(slot_epee).getItemMeta();
			epeeM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
			ItemStack epee = player.getInventory().getItem(slot_epee);
			epee.setItemMeta(epeeM);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND,3));
					
		}
		else {
				
			ItemStack pioche = new ItemStack(Material.DIAMOND_SWORD,1);
			ItemMeta piocheM = pioche.getItemMeta();
			piocheM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
			pioche.setItemMeta(piocheM);
			player.getInventory().addItem(pioche);
				
		}
		
	}
	
	public static void CommandCopie(Player player, Player cible, Main main) {
		
		if(main.getNbCopie(cible) == 300) {
			
			if(main.getOrbe(cible) == Orbe.NONE) {
				
				player.sendMessage("Ce joueur ne possède pas d'orbe");
				
			}
			else {
				
				player.sendMessage("Tu viens de copier une orbe ( " + main.getOrbe(cible).toString() + " )");
				main.setOrbeCopier(main.getOrbe(cible));
				
			}
			
		}
		
	}
	
	public static void CommandSetPiece(Player player, String piece, Main main) {
		
		if(main.getOrbeCopier() != Orbe.NONE) {
		
			if(piece.equalsIgnoreCase("casque")) {
				
				main.setOrbeArme("casque", main.getOrbeCopier());
				player.sendMessage("Tu viens d'équiper l'orbe de " + main.getOrbeCopier() + " sur ton casque");
				main.setOrbeCopier(Orbe.NONE);
				
			}
			else if(piece.equalsIgnoreCase("plastron")) {
				
				main.setOrbeArme("plastron", main.getOrbeCopier());
				player.sendMessage("Tu viens d'équiper l'orbe de " + main.getOrbeCopier() + " sur ton plastron");
				main.setOrbeCopier(Orbe.NONE);
				
			}
			else if(piece.equalsIgnoreCase("jambiere") || piece.equalsIgnoreCase("jambieres") || piece.equalsIgnoreCase("jambière") || piece.equalsIgnoreCase("jambières")) {
				
				main.setOrbeArme("jambiere", main.getOrbeCopier());
				player.sendMessage("Tu viens d'équiper l'orbe de " + main.getOrbeCopier() + " sur tes jambières");
				main.setOrbeCopier(Orbe.NONE);
				
			}
			else if(piece.equalsIgnoreCase("bottes") || piece.equalsIgnoreCase("botte")) {
				
				main.setOrbeArme("bottes", main.getOrbeCopier());
				player.sendMessage("Tu viens d'équiper l'orbe de " + main.getOrbeCopier() + " sur tes bottes");
				main.setOrbeCopier(Orbe.NONE);
				
			}
			else if(piece.equalsIgnoreCase("épée") || piece.equalsIgnoreCase("epee")) {
				
				main.setOrbeArme("epee", main.getOrbeCopier());
				player.sendMessage("Tu viens d'équiper l'orbe de " + main.getOrbeCopier() + " sur ton épée");
				main.setOrbeCopier(Orbe.NONE);
				
			}
			
		}
		else {
			
			player.sendMessage("Tu n'as pas d'orbe copier");
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §cObscur\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I la nuit\n \nAvec la commande /rcmaudit <pseudo> <pseudo> <niveau>, vous pourrez maudire 2 joueurs du même camps. Le bonus et le malus dépendent du camps et du niveaux :\n \nPour le camps démon :\n- Niveau 1 : Force I pour les 2 joueurs pendant 3 minutes\n- Niveau 2 : Speed I et force I pour les 2 joueurs pendant 2 minutes\n- Niveau 3 : Force I et speed II pour les 2 joueurs pendant 2 minutes\n \nPour le camps rc :\n- Niveau 1 : Faiblesse I pour les 2 joueurs pendant 2 minutes\n- Niveau 2 : Lenteur I pour les 2 joueurs pendant 3 minutes\n- Niveau 3 : Lenteur I et faiblesse I pour les 2 joueurspendant 2 minutes\n \nVous perdrez des coeurs permanent en fonction du niveau de la malédiction :\n- Niveau 1 : 1 coeur\n- Niveau 2 : 2 coeurs permanent\n- Niveau 3 : 3 coeurs permanent\n \nA chaque kill, vous recevrez 1 coeur supplémentaire (maximum : 12 coeurs)\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
