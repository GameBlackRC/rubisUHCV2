package fr.gameblack.rcuhcv2.roles.uhc;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Obscur {
	
	public static void Items(Joueur joueur) {
		
		TexteTrial(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §2Obscur\n§rVous devez gagner avec le §2camp UHC§r\n \nVous avez 3% de force permanent\n \nAvec la commande /rcmaudit <pseudo> <pseudo> <niveau>, vous pourrez maudire 2 joueurs du même camps. Le bonus et le malus dépendent du camps et du niveaux :\n \nPour le camps UHC :\n- Niveau 1 : 3% de force supplémentaire pour les 2 joueurs pendant 3 minutes\n- Niveau 2 : 10% de speed supplémentaire pour les 2 joueurs pendant 2 minutes\n- Niveau 3 : 3% de force et 5% de speed supplémentaire pour les 2 joueurs pendant 2 minutes\n \nPour les autres camps :\n- Niveau 1 : 2% de force en moins pour les 2 joueurs pendant 2 minutes\n- Niveau 2 : 7% de speed en moins pour les 2 joueurs pendant 2 minutes\n- Niveau 3 : 2% de force et 5% de speed en moins pour les 2 joueurs pendant 1 minute\n \nVous perdrez des coeurs permanent en fonction du niveau de la malédiction :\n- Niveau 1 : 1 coeur\n- Niveau 2 : 2 coeurs permanent\n- Niveau 3 : 3 coeurs permanent\n \nA chaque kill, vous recevrez 1.5 coeur supplémentaire (maximum : 12 coeurs)\n \n____________________________________________________");

    }
	
	public static void TexteTrial(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §2Obscure\n§rVous devez gagner avec le §2camp UHC§r\n \nau début il obtient le pouvoir \"adaption\" cooldawn 1 x ep\nlors qu'il active il obtient 2% de resisance et 3% de speed durant 2min 30 sec\npendant se laps de temps tout les malus divisé par deux (exepte farmeurrimo , kzou , trial solo) et si il reçoit deux fois le meme malus durant deux activation consécutif il aura 30% de chance d'etre immunisé durant tout la reste de la game\n(VOus arrivez toujours à comprendre ???)\nil se trouver a cote de tobou (toinou, oui trial fait vraiment aucun effort) il gagner 2% de force si il n'as pas activer son pouvoir\net si toinou vient a mourir il obtient le pseudo du tueur et si il vient a l tuer il gagner 2% de force ( et 1% de force dans sa fore pouvoir)\n \n(description par Trial, pour avoir une description plus lisible faites /rcme)\n \n____________________________________________________");
		
	}

}
