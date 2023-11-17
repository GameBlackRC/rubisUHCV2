package fr.gameblack.rcuhcv2.roles.v1.rc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;

public class ToinouV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

    }
    
    public static void kill(Joueur tueur, Joueur joueur, Main main) {
    	
    	if(joueur.getRole() == Roles.Trial) {
    		
    		tueur.addForce(main.getForceIBaseV1());
    		tueur.getPlayer().sendMessage("Vous venez de tuer Trial, vous recevez donc force I permanent");
    		
    	} else if(joueur.getRole() == Roles.Slup) {
    		
    		tueur.addResi(0.05);
    		tueur.getPlayer().sendMessage("Vous venez de tuer Slup, vous recevez donc 5% de résistance permanent");
    		
    	} else if(joueur.getRole() == Roles.Malivol) {
    		
    		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("Cheat");
            coffre.setItemMeta(coffreM);

            tueur.getPlayer().getInventory().addItem(coffre);
    		tueur.getPlayer().sendMessage("Vous venez de tuer Malivol, vous recevez donc son item 'Cheat'");
    		
    	} else if(joueur.getRole() == Roles.Obscur) {
    		
    		tueur.getVol().add(Pouvoirs.OBSCUR_ORBE);
    		tueur.getPlayer().sendMessage("Vous venez de tuer Obscur, vous recevez donc une pièce contenent une orbe aléatoire");
    		
    	} else if(joueur.getRole() == Roles.Ange) {
    		
    		tueur.addResi(main.getResiIBaseV1());
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Ange, vous recevez donc résistance I permanent");
    		
    	} else if(joueur.getRole() == Roles.Avenir) {
    		
    		tueur.setRespawn(true);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Avenir, vous pouvez donc respawn une fois");
    		
    	} else if(joueur.getRole() == Roles.Cosmos) {
    		
    		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("Zone de speed");
            coffre.setItemMeta(coffreM);
            tueur.getPlayer().getInventory().addItem(coffre);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Cosmos, vous recevez donc son item 'Zone de speed'");
    		
    	} else if(joueur.getRole() == Roles.Demon) {
    		
    		
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon, vous recevez donc ses pourcentages d'effets");
    		
    	} else if(joueur.getRole() == Roles.Electrique) {
    		
    		tueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Electrique, vous recevez donc Speed I permanent");
    		
    	} else if(joueur.getRole() == Roles.Enfer) {
    		
    		tueur.getVol().add(Pouvoirs.ENFER_FEU);
    		tueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false));
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Enfer, vous recevez donc résistance au feu permanent et vous avez 20% de chance de mettre en feu");
    		
    	} else if(joueur.getRole() == Roles.Malediction) {
    		
    		tueur.getVol().add(Pouvoirs.MALEDICTION_MAUDIT);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Malédiction, vous pouvez donc mettre des malédictions de niveaux 1 et 2");
    		
    	} else if(joueur.getRole() == Roles.Sang) {
    		
    		tueur.getVol().add(Pouvoirs.SANG_SANG);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Sang, vous pouvez donc utiliser la commande /rcsang");
    		
    	} else if(joueur.getRole() == Roles.Tenebre) {
    		
    		tueur.getVol().add(Pouvoirs.TENEBRE_KILL);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Ténèbre, vous recevez donc 3% de force à chaque kill");
    		
    	} else if(joueur.getRole() == Roles.Tronconeuse) {
    		
    		tueur.getVol().add(Pouvoirs.TRONCONNEUSE_SAIGNEMENT);
    		tueur.getPlayer().sendMessage("Vous venez de tuer le démon Tronçonneuse, vous gagnez donc l'effet de saignement");
    		
    	}
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aToinou\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet speed I tant que vous n'avez pas kill de démon\n \nA chaque kill du camps démon, il gagne des bonus cumulable (voir les bonus avec la commande /rcbonus)\n \n____________________________________________________");

    }

    public static void Texte_bonus(Player player) {

        player.sendMessage("____________________________________________________\n \nTrial:\nIl gagne l'effet force I permanent\n \nSlup :\nVous gagnez 5% de résistance\n \nMalivol :\nIl récupère son item 'Cheat'\n \nDémon ténèbre :\nGagne 3% de force à chaque kill\n \nDémon du sang :\nGagne la commande /rcsang\n \nDémon cosmos :\nRécupère la zone qui lui donne speed I\n \nDémon enfer :\nIl gagne l'effet résistance au feu I et à 20% de chance de mettre en feu\n \nDémon malédiction :\nIl peut mettre des malédictions de niveau 1 et niveau 2\n \nDémon éléctrique :\nIl gagne l'effet speed I\n \nDémon ange\nIl gagne résistance I\n \nDémon avenir :\nIl gagne une deuxième vie\n \nDémon tronçoneuse :\nIl inflige un saignement de 0.5 pendant 10 secondes\n \nDémon :\nIl gagne les pourcentages que le démon avait");

    }

}