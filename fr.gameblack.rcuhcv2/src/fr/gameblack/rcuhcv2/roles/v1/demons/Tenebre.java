package fr.gameblack.rcuhcv2.roles.v1.demons;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;

public class Tenebre {
	
	private static int nuit = 0;

    public static void Items(Joueur joueur, Main main) {

        Texte(joueur.getPlayer());
        joueur.removeForce(main.getForceIBaseV1());

    }

    public static void CommandeNuit(Main main) {

        if (!main.isNuitTenebre() && nuit < 2) {

            main.setNuitTenebre(true);
            nuit ++;
            
            main.getJoueurByRole(Roles.Tenebre).getPlayer().sendMessage("Le prochain jour seras changer en nuit");

        }
        else {
        	
        	main.getJoueurByRole(Roles.Tenebre).getPlayer().sendMessage("Vous avez déjà fait cette commande");
        	
        }

    }

    public static void CommandeBlind(Joueur joueur, Player cible, Main main) {

        joueur.getCD().add(Pouvoirs.TENEBRE_BLIND);

        cible.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0, false, false));
        
        main.getJoueurByRole(Roles.Tenebre).getPlayer().sendMessage("Ce joueur a bien été aveugler");

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon ténèbre\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et les effets force I et résistance I la nuit\n \nAvec la commande /rcnuit, vous pourrez, 2 fois dans la partie, transformer le prochain jour en nuit\n \nAvec la commande /rcblind <pseudo>, vous donner à la cible l'effet blindness I pendant 15 secondes\n \nA chaque kill que vous effectuer, vous gagnez 3% de force\n \nVous connaissez Slup\n \n____________________________________________________");

    }

	public int getNuit() {
		return nuit;
	}

	public void setNuit(int nuit) {
		Tenebre.nuit = nuit;
	}

}