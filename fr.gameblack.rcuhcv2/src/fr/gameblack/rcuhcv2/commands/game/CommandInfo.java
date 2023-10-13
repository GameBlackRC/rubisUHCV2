package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandInfo implements CommandExecutor {

    private Main main;

    public CommandInfo(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);
            
            if(joueur.getRole() == Roles.TRIAL) {

            	player.sendMessage("_______________________________\n \nListe des jeux :\n \n- 1, 2, 3 soleil : si un joueur bouge avant la fin du jeu (durée du jeu : 30sec), il perd. Le gagnant reçoit 2% de force pendant 5 minutes ainsi qu'un coeur permanent supplémentaire. Le perdant perd 3% de speed pendant 15 secondes et est immobilisé pendant 2 secondes\n- Takaoni (durée : 5 secondes) : Le joueur le plus haut à la fin du jeu gagne. Le gagnant obtient no fall pendant 5 minutes et 3% de speed supplémentaire permanent. Le perdant perdra 2% de force pendant 5 minutes ainsi qu'un demi coeur permanent\n- Reflex : Le premier joueur à cliquer sur le message envoyer dans le chat gagne le jeu. Le gagnant obtient 3% de speed pendant 5 minutes ainsi que 2% de résistance permanent. Le perdant perdra 2% de speed\n \n_______________________________");
            	
            }
            else if(joueur.getRole() == Roles.FARMEURIMMO) {
            	
            	player.sendMessage("_______________________________\n \nListe des effets du /rchack :\n \n- 10% : empêche le joueur de recevoir de l'absorption pendant 2 minutes\n-10% : connaitre les pourcentages d'effets du joueur ainsi que son orbe\n- 10% : enlever 2 niveaux de tranchant de l'épée de la cible\n 10% : retire 10% d'un effet aléatoire à la cible\n- 10% : connaitre le camp de la cible\n- 5% : activer le malus de l'orbe de la cible\n \n_______________________________");
            	
            }

        }

        return false;
    }

}
