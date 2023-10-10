package fr.gameblack.rcuhcv2.roles.solo;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Farmeurimmo {
	
	public static void Items(Joueur joueur) {
		
		joueur.getPlayer().setMaxHealth(22);
		joueur.addForce(0.05);
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §6Farmeurimmo\n§rVous devez gagner §6seul§r\n \nVous avez 5% de force ainsi que 2 coeurs permanents supplémentaires\n \nAu dessus de chaque joueur, vous voyez un poucentage de hack. Losqu'un joueur atteint 50%, vous pouvez utiliser la commande /rchack <joueur> sur lui. Lorsqu'un joueur atteint les 100%, vous pouvez utiliser la commande /rcsteal <joueur> sur lui.\n \nAvec la commande /rcsteal, vous volez un pouvoir du joueur (effets, commandes ou items). Le cooldown du pouvoir voler seras partager avec l'autre joueur. Une fois cette commande utiliser sur un joueur, la commande /rchack n'est plus utilisable sur lui.\n \nAvec la commande /rchack <joueur>, vous pouvez modifier/récuperer des informations sur le joueur (voir les possibilités avec la commande /rcinfo rchack ou sur le doc).\n \nAvec la commande /rccamp <joueur>, vous pouvez modifier le camp d'un joueur qui devra désormais gagner avec vous. La commande est utilisable uniquement sur les joueurs que vous avez voler et qui ont atteint une 2ème fois les 100%. Le pouvoir volé seras innutilisable par le joueur.\n \n____________________________________________________");

    }

	public static void commandCode(Joueur joueur, Joueur cible, Main main) {
		
		main.getCD().add(Pouvoirs.FARMEURIMMO_HACK);
		
		Random r = new Random();
        int nb = r.nextInt(100);
        
        if (nb <= 10) {
        	
        	//clear abso de la cible pendant 2min (fonctionnel)
        	cible.setAbso(false);
        	ItemCD cycle = new ItemCD(main, joueur, "abso", 120, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " ne peux plus recevoir d'absorption pendant 2 minutes");
        	
        }
        else if (nb <= 20) {
        	
        	//connaître les pourcentages d'effets que le joueur possède ainsi que son orbe
        	double speed = cible.getSpeed() - 100;
            double force = cible.getForce() - 100;
            double resi = cible.getResi() - 110;
        	joueur.getPlayer().sendMessage("Effets du joueur " + cible.getPlayer().getName() + ": _______________________________\n \nForce : " + force + "%\nSpeed : " + speed + "%\nRésistance : " + resi + "%\n \n_______________________________\n \nOrbe : " + cible.getOrbe().toString());
        	
        }
        else if (nb <= 30) {
        	
        	//modif l'enchant de l'épée (BUG)
        	
        	if (joueur.getPlayer().getInventory().contains(Material.DIAMOND_SWORD) || joueur.getPlayer().getInventory().contains(Material.IRON_SWORD)) {

                for (ItemStack itemStack : joueur.getPlayer().getInventory().getContents()) {

                    if (itemStack != null) {
                        if (itemStack.getType() == Material.DIAMOND_SWORD || itemStack.getType() == Material.IRON_SWORD) {

                            int niv = itemStack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                            niv -= 2;
                            if(niv < 1) {
                            	niv = 0;
                            }
                            
                            itemStack.removeEnchantment(Enchantment.DAMAGE_ALL);
                            itemStack.addEnchantment(Enchantment.DAMAGE_ALL, niv);

                        }

                    }

                }

            }
        	
        	ItemCD cycle = new ItemCD(main, joueur, "enchant_epee", 60, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("L'enchantement de l'épée de " + cible.getPlayer().getDisplayName() + " a été modifier pendant 1 minute");
        	
        }
        else if(nb <= 40) {
        	
        	//retire 10% d'un effet aléatoire
        	int nb2 = r.nextInt(3);
        	if(nb2 == 1) {
        		
        		cible.removeForce(0.05);
        		ItemCD cycle = new ItemCD(main, joueur, "add_force_farmeurimmo", 60, cible, null, null, null, null);
                cycle.runTaskTimer(main, 0, 20);
                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de force pendant 1 minute");
        		
        	}
        	else if(nb2 == 2) {
        		
        		cible.removeResi(0.05);
        		ItemCD cycle = new ItemCD(main, joueur, "add_resi_farmeurimmo", 60, cible, null, null, null, null);
                cycle.runTaskTimer(main, 0, 20);
                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de résistance pendant 1 minute");
        		
        	}
        	else {
        		
        		cible.removeSpeed(0.05);
        		ItemCD cycle = new ItemCD(main, joueur, "add_speed_farmeurimmo", 60, cible, null, null, null, null);
                cycle.runTaskTimer(main, 0, 20);
                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de speed pendant 1 minute");
        		
        	}
        	
        }
        else if(nb <= 50) {
        	
        	//connaitre le camp du joueur
        	joueur.getPlayer().sendMessage("Ce joueur fait partie du camp " + cible.getCamp());
        	
        }
        else if(nb <= 55) {
        	
        	//désactive l'orbe du joueur et active le malus (s'il n'a pas d'orbe il perd 5% de speed et de force pendant 1min)
        	if(cible.getOrbe() != Orbe.NONE) {
        		
        		if(cible.getOrbe() == Orbe.EAU) {
        			
        			Eau.Malus(cible, main);
        			
        		}
        		else if(cible.getOrbe() == Orbe.FEU){
        			
        			Feu.Malus(cible, main);
        			
        		}
        		else if(cible.getOrbe() == Orbe.GLACE) {
        			
        			Glace.Malus(cible, main);
        			
        		}
        		else {
        			
        			Foudre.Malus(cible, main);
        			
        		}
        		
        		joueur.getPlayer().sendMessage("Le malus de l'orbe de " + cible.getPlayer().getDisplayName() + " a été activer");
        		
        	}
        	
        }
        else if(nb <= 70) {
        	
        	//désactive l'orbe du joueur pendant 1min (s'il n'a pas d'orbe, il perd 5% de force pendant 1min)
        	
        	if(cible.getOrbe() != Orbe.NONE) {
        		
        		if(cible.getOrbe() == Orbe.EAU) {
        			
        			Eau.Malus(cible, main);
        			
        		}
        		else if(cible.getOrbe() == Orbe.FEU){
        			
        			Feu.Malus(cible, main);
        			
        		}
        		else if(cible.getOrbe() == Orbe.GLACE) {
        			
        			Glace.Malus(cible, main);
        			
        		}
        		else {
        			
        			Foudre.Malus(cible, main);
        			
        		}
        		
        		cible.setCanActiveOrbe(false);
        		
        		ItemCD cycle = new ItemCD(main, joueur, "desac_orbe", 60, cible, null, null, null, null);
                cycle.runTaskTimer(main, 0, 20);
                
                joueur.getPlayer().sendMessage("L'orbe de " + cible.getPlayer().getDisplayName() + " est desactivé pendant 1 minute");
        		
        	}
        	else {
        		
        		cible.removeForce(0.05);
        		
        		ItemCD cycle = new ItemCD(main, joueur, "effet_desac_orbe", 60, cible, null, null, null, null);
                cycle.runTaskTimer(main, 0, 20);
        		
        	}
        	
        }
        else if(nb <= 80) {
        	
        	//retire 2 coeurs permanent pendant 1min
        	cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()-4);
        	ItemCD cycle = new ItemCD(main, joueur, "malus_coeur_farmeurimmo", 60, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " perd 2 coeurs permanent pendant 1 minute");
        	
        }
        else if(nb <= 90) {
        	
        	//le joueur a 10% de chance de recevoir des coup enflammé à chaque coup subis pendant 2 minutes
        	cible.setFire(true);
        	
        	if(cible.getOrbe() == Orbe.FEU) {
        		
        		Feu.RemoveEffets(cible, main);
        		
        	}
        	
        	ItemCD cycle = new ItemCD(main, joueur, "malus_feu_farmeurimmo", 60, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " peut être enflammer pendant 1 minute");
        	
        }
        else {
        	
        	//l'arc du joueur est innutilisable (disparait de l'inv pendant 1min)
        	for(ItemStack item : cible.getPlayer().getInventory().getContents()) {
        		if(item != null && item.getType() == Material.BOW) {
        			item.setType(Material.BARRIER);
        		}
        	}
        	ItemCD cycle = new ItemCD(main, joueur, "malus_bow_farmeurimmo", 60, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " ne peux plus utiliser son arc pendant 1 minute");
        	
        }
		
	}
	
}
