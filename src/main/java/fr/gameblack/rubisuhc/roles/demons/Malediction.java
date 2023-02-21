package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.entity.Player;

public class Malediction {

    public static void Items(Player player) {

        Texte(player);

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Malédiction\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet force I la nuit\n \nAvec la commande /rcmaudit <pseudo> <pseudo> <niveau>, vous pourrez maudire 2 joueurs du même camps. Le bonus et le malus dépendent du camps et du niveaux :\n \nPour le camps démon :\n- Niveau 1 : Force I pour les 2 joueurs pendant 3 minutes\n- Niveau 2 : Speed I et force I pour les 2 joueurs pendant 2 minutes\n- Niveau 3 : Force I et speed II pour les 2 joueurs pendant 2 minutes\n \nPour le camps rc :\n- Niveau 1 : Faiblesse I pour les 2 joueurs pendant 2 minutes\n- Niveau 2 : Lenteur I pour les 2 joueurs pendant 3 minutes\n- Niveau 3 : Lenteur I et faiblesse I pour les 2 joueurspendant 2 minutes\n \nVous perdrez des coeurs permanent en fonction du niveau de la malédiction :\n- Niveau 1 : 1 coeur\n- Niveau 2 : 2 coeurs permanent\n- Niveau 3 : 3 coeurs permanent\n \nA chaque kill, vous recevrez 1 coeur supplémentaire (maximum : 12 coeurs)\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}
