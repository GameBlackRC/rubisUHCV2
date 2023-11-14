package fr.gameblack.rcuhcv2.commands.global.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

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

            	player.sendMessage("_______________________________\n \nListe des jeux :\n \n- 1, 2, 3 soleil : si un joueur bouge avant la fin du jeu (durée du jeu : 30sec), il perd. Le gagnant reçoit §12% de force§r pendant 5 minutes ainsi §dqu'un coeur permanent§r supplémentaire. Le perdant perd §13% de speed§r pendant 15 secondes et est immobilisé pendant 2 secondes\n- Takaoni (durée : 5 secondes) : Le joueur le plus haut à la fin du jeu gagne. Le gagnant obtient §1no fall§r pendant 5 minutes et §13% de speed supplémentaire§r permanent. Le perdant perdra §12% de force§r pendant 5 minutes ainsi §dqu'un demi coeur permanent§r\n- Reflex : Le premier joueur à cliquer sur le message envoyer dans le chat gagne le jeu. Le gagnant obtient §13% de speed§r pendant 5 minutes ainsi que §12% de résistance permanent§r. Le perdant perdra §12% de speed§r\n \n_______________________________");
            	
            }
            else if(joueur.getRole() == Roles.FARMEURIMMO) {
            	
            	player.sendMessage("_______________________________\n \nListe des effets du /rchack :\n \n- 15% : désactive l'orbe du joueur pendant 1 minute\n- 10% : empêche le joueur de recevoir de l'absorption pendant 2 minutes\n-10% : connaitre les pourcentages d'effets du joueur ainsi que son orbe\n- 10% : enlever 2 niveaux de tranchant de l'épée de la cible\n 10% : retire 10% d'un effet aléatoire à la cible\n- 10% : connaitre le camp de la cible\n- 10% : retire 2 coeurs permanent à la cible pendant 1 minute\n- 10% : chaque coup que la cible subi à 10% de chance de l'enflammer pendanr 2 minutes\n- 10% : l'arc de la cible n'est plus utilisable pendant 30 secondes\n- 5% : activer le malus de l'orbe de la cible\n \n_______________________________");
            	
            }

        }

        return false;
    }

}
