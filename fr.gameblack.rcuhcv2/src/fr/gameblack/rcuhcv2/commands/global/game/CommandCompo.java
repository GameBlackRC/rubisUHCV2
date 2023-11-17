package fr.gameblack.rcuhcv2.commands.global.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.listener.v1.CompoV1;
import fr.gameblack.rcuhcv2.listener.v2.CompoV2;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;

public class CommandCompo implements CommandExecutor {

    private Main main;

    public CommandCompo(Main main) {
        this.main = main;
    }

    public static void compoGUI(Player player, Main main) {

    	if(main.getVersion() == 1) {
    		
    		CompoV1.getCompoDemons(player, main, false);
    		
    	}
    	else if(main.getVersion() == 2) {
    		
    		CompoV2.getCompoJoueur(player, main, false);
    		
    	}

    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
    	
    	if(!main.getScenarios().contains(Scenarios.COMPO_CACHEE)) {

	        if (sender instanceof Player) {
	
	            Player player = (Player) sender;
	
	            if (args.length != 0 && args[0].equalsIgnoreCase("gui")) {
	
	                compoGUI(player, main);
	
	            } else {
	            	
	            	if(main.getVersion() == 2) {
	
		                String txt = "_______________________________\n \n§aCamp Joueur :§r";
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.RAPTOR))) {
		
		                    txt += "\n §aRaptor§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.JEANNOT))) {
		
		                    txt += "\n §aJeannot§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.NICKOBOOP))) {
		
		                    txt += "\n §aNickoboop§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.SLUP))) {
		
		                    txt += "\n §aSlup§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.JOKO))) {
		
		                    txt += "\n §aJoko§r(1)";
		
		                }
		                
		                txt += "\n§9Camp Staff :§r";
		                
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TEAM))) {
		
		                    txt += "\n §9Team§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.GAMEBLACK))) {
		
		                    txt += "\n §9GameBlack§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MAKA))) {
		
		                    txt += "\n §9Maka§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TRIAL))) {
		
		                    txt += "\n §9Trial§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.LOUP))) {
		
		                    txt += "\n §9Loup§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.CAPTAIN))) {
		
		                    txt += "\n §9Captain§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.HEKOW))) {
		
		                    txt += "\n §9Hekow§r(1)";
		
		                }
		                txt += "\n§2Camp UHC :§r";
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.MALIVOL))) {
		
		                    txt += "\n §2Malivol§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.TOINOU))) {
		
		                    txt += "\n §2Toinou§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.OBSCUR))) {
		
		                    txt += "\n §2Obscur§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.NONOBOY))) {
		
		                    txt += "\n §2Nonoboy§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.THEOOCHOUX))) {
		                	
		                    txt += "\n §2Theoochoux§r(1)";
		
		                }
		
		                txt += "\n§6Solos :§r";
		
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.FARMEURIMMO))) {
		
		                    txt += "\n §6Farmeurimmo§r(1)";
		
		                }
		                if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.KZOU))) {
		
		                    txt += "\n §6Kzou§r(1)";
		
		                }
		
		                sender.sendMessage(txt + "\n \n_______________________________");
		                
	            	}
	            	else if(main.getVersion() == 1) {
	            		
	                    String txt = "_______________________________\n \n§aCamp Joueur :";
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.GameBlack))) {
	
	                        txt += "\n §aGameBlack§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Team))) {
	
	                        txt += "\n §aTeam§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Maka))) {
	
	                        txt += "\n §aMaka§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Joko))) {
	
	                        txt += "\n §aJoko§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Toinou))) {
	
	                        txt += "\n §aToinou§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Loup))) {
	
	                        txt += "\n §aLoup§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Raptor))) {
	
	                        txt += "\n §aRaptor§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Guerrier))) {
	
	                        txt += "\n §aGuerrier§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Archer))) {
	
	                        txt += "\n §aArcher§r(1)";
	
	                    }
	                    
	                    txt += "\n§cCamp Démon :";
	                    
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Trial))) {
	
	                        txt += "\n §cTrial§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Slup))) {
	
	                        txt += "\n §cSlup§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Malivol))) {
	
	                        txt += "\n §cMalivol§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Obscur))) {
	
	                        txt += "\n §cObscur§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Ange))) {
	
	                        txt += "\n §cAnge§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Cosmos))) {
	
	                        txt += "\n §cCosmos§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Electrique))) {
	
	                        txt += "\n §cDémon Electrique§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Enfer))) {
	
	                        txt += "\n §cDémon Enfer§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Malediction))) {
	
	                        txt += "\n §cDémon Malédiction§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Sang))) {
	
	                        txt += "\n §cDémon Sang§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Tronconeuse))) {
	
	                        txt += "\n §cDémon Tronçoneuse§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Tenebre))) {
	
	                        txt += "\n §cDémon Ténèbre§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Demon))) {
	
	                        txt += "\n §cDémon§r(1)";
	
	                    }
	
	                    txt += "\n§6Solos :";
	
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Farmeurimmo))) {
	
	                        txt += "\n §6Farmeurimmo§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Kzou))) {
	
	                        txt += "\n §6Kzou§r(1)";
	
	                    }
	                    if ((main.getCompo().size() != 0 && main.getCompo().contains(Roles.Experimental))) {
	
	                        txt += "\n §6Démon Expérimental§r(1)";
	
	                    }
	
	                    sender.sendMessage(txt + "\n \n_______________________________");
	            		
	            	}
	
	            }
	
	        }
	        
    	}
    	else {
    		
    		sender.sendMessage("Vous ne pouvez pas voir la compo de la partie car le scénario 'Compo cachée' est actif'");
    		
    	}

        return false;

    }

}
