package fr.gameblack.rcuhcv2.task.v2;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.evenement.v2.FermetureGolden;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Team;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.roles.v2.uhc.RomPrems;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.scenarios.v2.Skin;

public class GameCycle extends BukkitRunnable {

    private Main main;

    private int timer = 0;
    
    //private boolean objectif_pourcent_creer = false;
    
    private static Scoreboard board_base;
    
    private static Scoreboard board_joko;
    
    private static Scoreboard board_farmeurimmo;
    
    private static Scoreboard board_game;
    
    @SuppressWarnings("unused")
	private Scoreboard board_pourcent;
    
    private boolean score_board = true;

    @SuppressWarnings("static-access")
	public GameCycle(Main main, Scoreboard board_base, Scoreboard board_pourcent, Scoreboard board_game, Scoreboard board_joko, Scoreboard board_farmeurimmo) {
        this.main = main;
        this.board_base = board_base;
        this.board_pourcent = board_pourcent;
        this.setBoard_game(board_game);
        this.board_joko = board_joko;
        this.board_farmeurimmo = board_farmeurimmo;
    }

    public static void Nuit(Main main) {
    	
    	if(main.getJoueurByRole(Roles.KZOU) != null) {
    		
    		main.getJoueurByRole(Roles.KZOU).removeResi(0.02);
    		
    	}
    	
    	if(main.isFermetureGolden()) {

	        if(main.getEpisode() == 1 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP)) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 2) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 3) {
	        	
	        	if(main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) {
	        		
	        		FermetureGolden.Active(main);
	        		
	        	}
	        	else {
	        		
	        		Random r = new Random();
	                int nb = r.nextInt(100);
	                
	                if(nb <= 25) {
	                	
	                	FermetureGolden.Active(main);
	                	
	                }
	        		
	        	}
	        	
	        }
	        else if(main.getEpisode() == 4 && main.getMode() == Modes.NORMAL) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 5 && main.getMode() == Modes.NORMAL) {
	            	
	            FermetureGolden.Active(main);
	        	
	        }
        
    	}

    }

    public static void Jour(Main main) {
    	
    	if(main.getJoueurByRole(Roles.KZOU) != null) {
    		
    		main.getJoueurByRole(Roles.KZOU).addResi(0.02);
    		
    	}
    	
    	if(main.isFermetureGolden()) {

	    	if(main.getEpisode() == 1 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP)) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 2) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 3) {
	        	
	        	if(main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) {
	        		
	        		FermetureGolden.Active(main);
	        		
	        	}
	        	else {
	        		
	        		Random r = new Random();
	                int nb = r.nextInt(100);
	                
	                if(nb <= 25) {
	                	
	                	FermetureGolden.Active(main);
	                	
	                }
	        		
	        	}
	        	
	        }
	        else if(main.getEpisode() == 4 && main.getMode() == Modes.NORMAL) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 5 && main.getMode() == Modes.NORMAL) {
	            	
	            FermetureGolden.Active(main);
	        	
	        }
	    	
    	}

    }
    
    public static void resetCD(Main main) {
    	
    	for(Joueur j : main.getJoueurInGame()) {
    	
	    	if(j.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {
	    		
	    		j.getCD().remove(Pouvoirs.MALIVOL_CHEAT);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.HEKOW_JEU)) {
	    		
	    		j.getCD().remove(Pouvoirs.HEKOW_JEU);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.THEOOCHOUX_ROLLBACK)) {
	    		
	    		j.getCD().remove(Pouvoirs.THEOOCHOUX_ROLLBACK);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_OTHER)) {
	    		
	    		j.getCD().remove(Pouvoirs.CAPTAIN_ENCHANT_OTHER);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_SELF)) {
	    		
	    		j.getCD().remove(Pouvoirs.CAPTAIN_ENCHANT_SELF);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
	    		
	    		j.getCD().remove(Pouvoirs.CAPTAIN_REPAIR);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.OBSCUR_ADAPTION)) {
	    		
	    		j.getCD().remove(Pouvoirs.OBSCUR_ADAPTION);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
	    		
	    		j.getCD().remove(Pouvoirs.RAPTOR_RAGE);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.TRIAL_JEU)) {
	    		
	    		j.getCD().remove(Pouvoirs.TRIAL_JEU);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.TRIAL_BENIHIME)) {
	    		
	    		j.getCD().remove(Pouvoirs.TRIAL_BENIHIME);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.TRIAL_SAKASHIMA)) {
	    		
	    		j.getCD().remove(Pouvoirs.TRIAL_SAKASHIMA);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.FARMEURIMMO_HACK)) {
	    		
	    		j.getCD().remove(Pouvoirs.FARMEURIMMO_HACK);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.GAMEBLACK_CHECKORBE)) {
	    		
	    		j.getCD().remove(Pouvoirs.GAMEBLACK_CHECKORBE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.GAMEBLACK_CONSOLE)) {
	    		
	    		j.getCD().remove(Pouvoirs.GAMEBLACK_CONSOLE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
	    		
	    		j.getCD().remove(Pouvoirs.GAMEBLACK_FUITE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.JOKO_CUBE)) {
	    		
	    		j.getCD().remove(Pouvoirs.JOKO_CUBE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.KZOU_BAN)) {
	    		
	    		j.getCD().remove(Pouvoirs.KZOU_BAN);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {
	    		
	    		j.getCD().remove(Pouvoirs.KZOU_DISPERSE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.NICKOBOOP_PAPIER)) {
	    		
	    		j.getCD().remove(Pouvoirs.NICKOBOOP_PAPIER);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.TOINOU_VACANCES)) {
	    		
	    		j.getCD().remove(Pouvoirs.TOINOU_VACANCES);
	    		
	    	}
	    	
    	}
    	
    }
    
    public static void setRole(Main main) {
    	
    	main.setState(Statut.PVP_ON);
    	
    	List<Roles> compo = main.getCompo();
    	
    	int nombre = compo.size()-1;
    	
    	List<Roles> compo_ = new ArrayList<>();
    	
    	System.out.println("____________________________");
    	
    	System.out.println("taille : " + nombre);
    	
    	for(Roles role : compo) {
    		
    		System.out.println("Role : " + role.toString());
    		
    	}
    	
    	System.out.println("____________________________");

        for (Joueur j : main.getListJoueurs()) {
        	
        	if(!j.isSpec()) {
        	
	        	if(nombre > 0) {
	        		
	        		System.out.println("____________________________");
	            	
	            	System.out.println("taille : " + nombre);
	            	
	            	for(Roles role : compo) {
	            		
	            		System.out.println("Role : " + role.toString());
	            		
	            	}
	            	
	            	System.out.println("____________________________");
	        	
		        	Player pls = j.getPlayer();
		
		            Random r = new Random();
		            int nb = r.nextInt(nombre);
		            System.out.println("Random (nb) : " + nb);
		            
		            Roles role = compo.get(nb);
		            
	            	System.out.println("Joueur : " + j.getPlayer().getName());
	            	System.out.println("Role : " + role.getTxt());
	            	System.out.println("____________________________");
		            
		            compo_.add(role);
		            j.setRole(role, main);
		            compo.remove(role);
		            nombre -= 1;
		            j.setInvulnerable(false);
		
		            pls.setHealth(pls.getMaxHealth());
		            
		            if(main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) {
			            
		            	j.addOrbe(main);
		            	
		            }
		            
	        	}
	        	else {
	        		
	        		Player pls = j.getPlayer();
	        		
	        		Roles role = compo.get(0);
	        		compo_.add(role);
	        		j.setRole(role, main);
	        		compo.remove(role);
	        		j.setInvulnerable(false);
	        		pls.setHealth(pls.getMaxHealth());
	        		
		            if(main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) {
			            
		            	j.addOrbe(main);
		            	
		            }
	        		
	        	}
	        	
        	}

        }
        
        main.setCompo(compo_);
        
        if(main.getCompo().contains(Roles.ROMPREMS)) {
        	
        	if(main.getMode() == Modes.RAPIDE) {
        		
        		RomPrems.setEndermanBlazeRapide(main.getJoueurByRole(Roles.ROMPREMS), main);
        		
        	}
        	else {
        		
        		RomPrems.setEndermanBlazeBase(main.getJoueurByRole(Roles.ROMPREMS), main);
        		
        	}
        	
        }
        
        if(main.getCompo().contains(Roles.JEANNOT) && main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	Joueur jeannot = main.getJoueurByRole(Roles.JEANNOT);
        	Joueur nickoboop = main.getJoueurByRole(Roles.NICKOBOOP);
        	jeannot.getPlayer().sendMessage("§aNickoboop§r : " + nickoboop.getPlayer().getDisplayName());
        	nickoboop.getPlayer().sendMessage("§aJeannot§r : " + jeannot.getPlayer().getDisplayName());
        	
        }
        else if(main.getCompo().contains(Roles.JEANNOT)) {
        	
        	main.getJoueurByRole(Roles.JEANNOT).addForce(0.02);
        	main.getJoueurByRole(Roles.JEANNOT).getPlayer().sendMessage("§aNickoboop§r n'étant pas dans la compo, vous recevez 2% de force permanent");
        	
        }
        else if(main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	main.getJoueurByRole(Roles.NICKOBOOP).addResi(0.02);
        	main.getJoueurByRole(Roles.NICKOBOOP).getPlayer().sendMessage("§aJeannot§r n'étant pas dans la compo, vous recevez 2% de résistance permanent");
        	
        }
        
        if(main.getCompo().contains(Roles.MALIVOL) && main.getCompo().contains(Roles.TOINOU)) {
        	
        	Joueur malivol = main.getJoueurByRole(Roles.MALIVOL);
        	Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
        	
        	malivol.getPlayer().sendMessage("§2Toinou§r : " + toinou.getPlayer().getName());
        	
        }
        
        if(main.getCompo().contains(Roles.OBSCUR) && !main.getCompo().contains(Roles.TOINOU)) {
        	
        	Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
        	obscur.setTueurToinouKill(true);
        	obscur.addForce(0.02);
        	obscur.getPlayer().sendMessage("§2Toinou§r n'étant pas dans la compo, vous recevez 2% de force permanent");
        	
        }
        
        if(main.getCompo().contains(Roles.TRIAL) && main.getCompo().contains(Roles.LOUP)) {
        	
        	Joueur trial = main.getJoueurByRole(Roles.TRIAL);
        	Joueur loup = main.getJoueurByRole(Roles.LOUP);
        	trial.getPlayer().sendMessage("§9Loup§r : " + loup.getPlayer().getDisplayName());
        	
        }
        
        if(main.getCompo().contains(Roles.HEKOW) && main.getCompo().contains(Roles.CAPTAIN)) {
        	
        	Joueur hekow = main.getJoueurByRole(Roles.HEKOW);
        	Joueur captain = main.getJoueurByRole(Roles.CAPTAIN);
        	
        	hekow.getPlayer().sendMessage("§9Captain§r : " + captain.getPlayer().getName());
        	
        }
        
        if(main.getScenarios().contains(Scenarios.SKIN)) {
        	
        	Skin.setSkin(main);
        	
        }
    	
    }
    
    public static Scoreboard getScoreboardFarmeurimmo() {
    	return board_farmeurimmo;
    }
    
    public static Scoreboard getScoreboardJoko() {
    	return board_joko;
    }
    
    public static void ScoreboardBase(Main main, int timer, Joueur j) {
    	
    	Scoreboard board = j.getBoard();
    	
    	if(j.getRole() == Roles.FARMEURIMMO) {
    		
    		board = board_farmeurimmo;
    		
    	}
    	
    	if(j.getRole() == Roles.JOKO) {
    		
    		board = board_joko;
    		
    	}
    	
    	if(board.getObjective(j.getPlayer().getName()) != null) {
    		board.getObjective(j.getPlayer().getName()).unregister();
		}
    		
    	Objective objective = board.registerNewObjective(j.getPlayer().getName(), "dummy");
        
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("RC UHC V2");
        Score score1 = objective.getScore("Durée: " + main.getTimerInTexte(timer));
        score1.setScore(10);
        Score scoreep = objective.getScore("Episode : " + main.getEpisode());
        scoreep.setScore(9);
        int nb_joueurs = main.getJoueurInGame().size();
        for(Joueur j_ : main.getJoueurInGame()) {
        	
        	if(j_.getRole() == Roles.SLUP && j_.isInvisible()) {
        		
        		nb_joueurs -= 1;
        		
        	}
        	
        }
        Score score2 = objective.getScore("Joueurs : " + nb_joueurs);
        score2.setScore(8);
        Score scorekill = objective.getScore("Kill : " + j.getKill() );
        scorekill.setScore(7);
        Score score3 = objective.getScore("Role: " + j.getCamp().getCouleur() + j.getRole().getTxt());
        score3.setScore(6);
        Score score4;
        if(j.getOrbe() == Orbe.EAU) {
        	
        	score4 = objective.getScore("Orbe: §1Eau");
        	
        }
        else if(j.getOrbe() == Orbe.FEU) {
        	
        	score4 = objective.getScore("Orbe: §cFeu");
        	
        }
        else if(j.getOrbe() == Orbe.GLACE) {
        	
        	score4 = objective.getScore("Orbe: §bGlace");
        	
        }
        else if(j.getOrbe() == Orbe.FOUDRE) {
        	
        	score4 = objective.getScore("Orbe: §eFoudre");
        	
        }
        else {
        	
        	score4 = objective.getScore("Orbe: Aucune");
        	
        }
        
        score4.setScore(5);
        Score score5;
        if(j.isOrbeActif()) {
        	
        	score5 = objective.getScore("Etat de l'orbe: §aActive");
        	
        }
        else {
        	
        	score5 = objective.getScore("Etat de l'orbe: §cInactive");
        	
        }
        score5.setScore(4);
        
        if(j.getRole() == Roles.JEANNOT) {
        	
        	Score scorepartage_jeannot;
	        if(j.isJeannotPartageActif()) {
	        	
	        	scorepartage_jeannot = objective.getScore("Partage: §aActif");
	        	
	        }
	        else {
	        	
	        	scorepartage_jeannot = objective.getScore("Partage: §cInnactif");
	        	
	        }
	        scorepartage_jeannot.setScore(3);
	        
        	Score scoreabso_jeannot;
	        if(j.isJeannotAbso()) {
	        	
	        	scoreabso_jeannot = objective.getScore("Absorption: §aActif");
	        	
	        }
	        else {
	        	
	        	scoreabso_jeannot = objective.getScore("Absorption: §cInnactif");
	        	
	        }
	        scoreabso_jeannot.setScore(2);
        	
        }
        else if(j.getRole() == Roles.SLUP) {
        	
        	Score scoreslime_slup = objective.getScore("Slime: " + j.getSlime());
	        scoreslime_slup.setScore(3);
	        Score scoreinvi_slup;
	        if(j.isInvisible()) {
	        	
	        	scoreinvi_slup = objective.getScore("Invisible: §aActif");
	        	
	        }
	        else {
	        	
	        	scoreinvi_slup = objective.getScore("Invisible: §cInnactif");
	        	
	        }
	        scoreinvi_slup.setScore(2);
        	
        }
        else if(j.getRole() == Roles.MAKA) {
        	
        	if(j.getForme().equalsIgnoreCase("simp") && main.getNeko() != null) {
        		
        		Score scoreneko_maka = objective.getScore("Neko: " + main.getNeko().getPlayer().getName());
		        scoreneko_maka.setScore(3);
        		
        	}
        	
        }
        else if(j.getRole() == Roles.TRIAL && j.getModeTrial() != null) {
        	
        	Score scoremode_trial = objective.getScore("Mode : " + j.getModeTrial());
	        scoremode_trial.setScore(3);
	        
	        if(j.getModeTrial().equalsIgnoreCase("serieux") && j.getCamp() != Camps.SOLOS) {
	        	
	        	Score scorecola_trial = objective.getScore("Hydratation : " + j.getTrialHydratation());
		        scorecola_trial.setScore(2);
	        	
	        }
        	
        }
        else if(j.getRole() == Roles.HEKOW) {
        	
        	Score scorepourcent_hekow = objective.getScore("Pourcent: " + j.getHekowPourcent());
        	scorepourcent_hekow.setScore(3);
        	
        }
        else if(j.getRole() == Roles.MALIVOL) {
        	
        	if(j.getMalivolCheat() != 0) {
	        	
	        	Score score5_malivol;
	        	
	        	if(j.getMalivolCheat() == 1) {
	        		
	        		score5_malivol = objective.getScore("Cheat: §9SpeedHack");
	        		
	        	}
	        	else if(j.getMalivolCheat() == 2) {
	        		
	        		score5_malivol = objective.getScore("Cheat: §aNoFall");
	        		
	        	}
	        	else if(j.getMalivolCheat() == 3) {
	        		
	        		score5_malivol = objective.getScore("Cheat: §cFullcrit");
	        		
	        	}
	        	else {
	        		
	        		score5_malivol = objective.getScore("Cheat: §7Anti-KB");
	        		
	        	}
	        	
	        	score5_malivol.setScore(3);
	        	
	        }
        	
        }
        else if(j.getRole() == Roles.TOINOU) {
        	
        	Score scoreslime_slup = objective.getScore("Points: " + j.getPoints());
	        scoreslime_slup.setScore(3);
	        
	        Score scoreinvi_toinou;
	        if(j.isInvisible()) {
	        	
	        	scoreinvi_toinou = objective.getScore("Invisible: §aActif");
	        	
	        }
	        else {
	        	
	        	scoreinvi_toinou = objective.getScore("Invisible: §cInnactif");
	        	
	        }
	        scoreinvi_toinou.setScore(2);
        	
        }
        
        Score scoreip = objective.getScore("§9play.rubis§ccraft.fr§r");
        scoreip.setScore(1);
        j.getPlayer().setScoreboard(board);
    	
    }

    public static void setScoreboard(Main main, int timer) {
    	
    	Objective objective_hp = board_base.getObjective("hp");
    	
    	if(!board_base.getObjectives().isEmpty()) {
			board_base.getObjective("test").unregister();
		}
        
        Objective objective_base = board_base.registerNewObjective("test", "dummy");
        objective_base.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective_base.setDisplayName("RC UHC V2");
        Score score1_base = objective_base.getScore("Durée: " + main.getTimerInTexte(timer));
        score1_base.setScore(4);
        Score scoreep_base = objective_base.getScore("Episode : " + main.getEpisode());
        scoreep_base.setScore(3);
        Score score2_base = objective_base.getScore("Joueurs : " + main.getListJoueurs().size() );
        score2_base.setScore(2);
        Score scoreip = objective_base.getScore("§9play.rubis§ccraft.fr§r");
        scoreip.setScore(1);
        if(objective_hp == null) {
        	objective_hp = board_base.registerNewObjective("hp", "health");
        }
        objective_hp.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective_hp.setDisplayName("HP");
        
        for(Joueur joueur : main.getListJoueurs()) {
        	
        	Player player = joueur.getPlayer();
        	
        	//System.out.println("Joueur : " + player.getName());
        	//System.out.println("Role : " + joueur.getRole().toString());
        	
        	if(joueur.getRole() == Roles.NONE || joueur.isMort()) {
        		
	            player.setScoreboard(board_base);
	            
            }
        	else {
        		
        		ScoreboardBase(main, timer, joueur);
        		
        	}
            
        }
    	
    }
    
	@Override
    public void run() {
		
		if(main.getState() == Statut.FINISH) {
			
			main.reloadGame();
			
			cancel();
			
		}
		
		if((timer > 2400 && timer < 3600 && timer%600 == 0 && main.getMode() == Modes.NORMAL) || (timer > 0 && timer < 12000 && timer%600 == 0 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP))) {
			
			if(main.getJoueurByRole(Roles.TRIAL) != null && main.getJoueurByRole(Roles.SLUP) != null && main.getJoueurByRole(Roles.SLUP).getCamp() != Camps.DUO && main.getJoueurByRole(Roles.SLUP).getPacteSlup() == 2) {
				
				Joueur slup = main.getJoueurByRole(Roles.SLUP);
				
				if(slup.isProche10(Roles.TRIAL, main)) {
					
					slup.getPlayer().sendMessage("Trial se trouve dans un rayon de 10 blocs");
					
				}
				else {
					
					slup.getPlayer().sendMessage("Trial n'est pas proche de vous");
					
				}
				
			}
			
		}
		
		if(timer % 200 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() != 3) {
			
			if(main.getMode() == Modes.RAPIDE) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur nono = main.getMaudit().get(1);
				
				if(!cible1.isProche(nono.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 3) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-1);
						
					}
					
				}
				
			}
			else {
			
				Joueur cible1 = main.getMaudit().get(0);
				Joueur cible2 = main.getMaudit().get(1);
				
				if(!cible1.isProche(cible2.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 3) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-2);
						
					}
					
					if(cible2.getPlayer().getHealth() > 3) {
						
						cible2.getPlayer().setHealth(cible2.getPlayer().getHealth()-2);
						
					}
					
				}
				
			}
			
		}
		
		if(timer % 150 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() == 3) {
			
			if(main.getMode() == Modes.RAPIDE) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur nono = main.getMaudit().get(1);
				
				if(!cible1.isProche(nono.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 4) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-1);
						
					}
					
				}
				
			}
			else {
			
				Joueur cible1 = main.getMaudit().get(0);
				Joueur cible2 = main.getMaudit().get(1);
				
				if(!cible1.isProche(cible2.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 4) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-3);
						
					}
					
					if(cible2.getPlayer().getHealth() > 4) {
						
						cible2.getPlayer().setHealth(cible2.getPlayer().getHealth()-3);
						
					}
					
				}
				
			}
			
		}
		
		if(timer % 140 == 0 && ((main.getEpisode() > 2 && main.getTemps() > 1 && main.getMode() == Modes.NORMAL) || (main.getEpisode() >= 1 && main.getTemps() > 11 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP)))) {
			
			if(!main.getJoueursByRole(Roles.FARMEURIMMO).isEmpty()) {
			
				for(Joueur joueur : main.getListJoueurs()) {
					
					if(!joueur.isMort() && joueur.getRole() != Roles.FARMEURIMMO && joueur.getRole() != Roles.NONE && !joueur.isProche(Roles.FARMEURIMMO, main)) {
						
						joueur.addPourcentHack(1, main, board_farmeurimmo);
						
					}
					
				}
				
			}
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.LOUP) != null && main.getJoueurByRole(Roles.LOUP).isSuperBateauLoup()) {
    		
    		for(Entity entity : Bukkit.getWorld("world").getEntities()) {
    			
    			if(entity instanceof Vehicle) {
    				
    				Vehicle boat = (Vehicle) entity;
    				
    				if(boat.isCustomNameVisible() && boat.getCustomName().equalsIgnoreCase("Super Bateau")) {
    					
    					System.out.println("c'est super bateau");
    					
    					if(boat.getPassenger() != null) {
    					
	    					Entity passager = boat.getPassenger();
	    					boat.eject();
	    					boat.teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
	    					boat.setPassenger(passager);
    					
    					}
    					else {
    						
    						boat.teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
    						
    					}
    					
    				}
    				
    			}
    			
    		}
    		
    		//Loup.getBoat().teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
    		
    	}
        
        if(timer % 10 == 0) {
        	
        	if(!main.getJoueursByRole(Roles.TRIAL).isEmpty()) {
        		
        		List<Joueur> trial_list = main.getJoueursByRole(Roles.TRIAL);
        		
        		for(Joueur trial : trial_list) {
        			
        			if(trial.getModeTrial() != null && trial.getModeTrial().equalsIgnoreCase("serieux")) {
        				
        				if(trial.isBouge()) {
        					
        					trial.setBouge(false);
        					
        					Random r = new Random();
        					
        		            int nb = r.nextInt(100);
        		            
        		            if(nb <= 1) {
        		            	
        		            	trial.removeTrialHydratation(1);
        		            	
        		            }
        					
        				}
        				
        				boolean changeStade = false;
        				
        				if(trial.getTrialStadeActif() == 0 && !(trial.getTrialHydratation() < 11)) {
        					
        					trial.addForce(0.01);
        					trial.addResi(0.01);
        					trial.addSpeed(0.05);
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 1 && !(trial.getTrialHydratation() > 10 && trial.getTrialHydratation() < 26)) {
        					
        					trial.addSpeed(0.05);
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.addForce(0.01);
        						
        					}
        					else {
        						
        						trial.addResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 2 && !(trial.getTrialHydratation() > 25 && trial.getTrialHydratation() < 51)) {
        					
        					trial.addSpeed(0.03);
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.addForce(0.01);
        						
        					}
        					else {
        						
        						trial.addResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 3 && !(trial.getTrialHydratation() > 50 && trial.getTrialHydratation() < 76)) {
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 4 && !(trial.getTrialHydratation() > 75 && trial.getTrialHydratation() < 91)) {
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.removeForce(0.01);
        						
        					}
        					else {
        						
        						trial.removeResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 5 && !(trial.getTrialHydratation() > 90 && trial.getTrialHydratation() < 96)) {
        					
        					trial.removeSpeed(0.03);
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.removeForce(0.01);
        						
        					}
        					else {
        						
        						trial.removeResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 6 && !(trial.getTrialHydratation() > 95 && trial.getTrialHydratation() < 106)) {
        					
        					trial.removeSpeed(0.03);
        					trial.removeForce(0.01);
        					trial.removeResi(0.01);
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 7 && !(trial.getTrialHydratation() > 105 && trial.getTrialHydratation() < 111)) {
        					
        					trial.removeSpeed(0.03);
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.removeForce(0.01);
        						
        					}
        					else {
        						
        						trial.removeResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 8 && !(trial.getTrialHydratation() > 110 && trial.getTrialHydratation() < 126)) {
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.removeForce(0.01);
        						
        					}
        					else {
        						
        						trial.removeResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 9 && !(trial.getTrialHydratation() > 125 && trial.getTrialHydratation() < 151)) {
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 10 && !(trial.getTrialHydratation() > 150 && trial.getTrialHydratation() < 176)) {
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.addForce(0.01);
        						
        					}
        					else {
        						
        						trial.addResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				else if(trial.getTrialStadeActif() == 11 && !(trial.getTrialHydratation() > 175)) {
        					
        					trial.addSpeed(0.03);
        					
        					if(trial.getTrialEffetRandom().equalsIgnoreCase("force")) {
        						
        						trial.addForce(0.01);
        						
        					}
        					else {
        						
        						trial.addResi(0.01);
        						
        					}
        					
        					changeStade = true;
        					
        				}
        				
        				if(changeStade) {
        					
        					if(trial.getTrialHydratation() < 11) {
            					
            					trial.removeForce(0.01);
            					trial.removeResi(0.01);
            					trial.removeSpeed(0.05);
            					trial.setTrialStadeActif(0);
            					
            				}
            				else if(trial.getTrialHydratation() > 10 && trial.getTrialHydratation() < 26) {
            					
            					trial.removeSpeed(0.05);
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.removeForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.removeResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            					trial.setTrialStadeActif(1);
            					
            				}
            				else if(trial.getTrialHydratation() > 25 && trial.getTrialHydratation() < 51) {
            					
            					trial.removeSpeed(0.03);
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.removeForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.removeResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            					trial.setTrialStadeActif(2);
            					
            				}
            				else if(trial.getTrialHydratation() > 50 && trial.getTrialHydratation() < 76) {
            					
            					trial.setTrialStadeActif(3);
            					
            				}
            				else if(trial.getTrialHydratation() > 75 && trial.getTrialHydratation() < 91) {
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.addForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.addResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            					trial.setTrialStadeActif(4);
            					
            				}
            				else if(trial.getTrialHydratation() > 90 && trial.getTrialHydratation() < 96) {
            					
            					trial.addSpeed(0.03);
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.addForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.addResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            		            trial.setTrialStadeActif(5);
            					
            				}
            				else if(trial.getTrialHydratation() > 95 && trial.getTrialHydratation() < 106) {
            					
            					trial.addSpeed(0.03);
            					trial.addForce(0.01);
            					trial.addResi(0.01);
            					
            					trial.setTrialStadeActif(6);
            					
            				}
            				else if(trial.getTrialHydratation() > 105 && trial.getTrialHydratation() < 111) {
            					
            					trial.addSpeed(0.03);
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.addForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.addResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            		            trial.setTrialStadeActif(7);
            					
            				}
            				else if(trial.getTrialHydratation() > 110 && trial.getTrialHydratation() < 126) {
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.addForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.addResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            		            trial.setTrialStadeActif(8);
            					
            				}
            				else if(trial.getTrialHydratation() > 125 && trial.getTrialHydratation() < 151) {
            					
            					trial.setTrialStadeActif(9);
            					
            				}
            				else if(trial.getTrialHydratation() > 150 && trial.getTrialHydratation() < 176) {
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.removeForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.removeResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            		            trial.setTrialStadeActif(10);
            					
            				}
            				else if(trial.getTrialHydratation() > 175) {
            					
            					trial.removeSpeed(0.03);
            					
            					Random r = new Random();
            					
            		            int nb = r.nextInt(2);
            		            
            		            if(nb == 1) {
            						
            						trial.removeForce(0.01);
            						trial.setTrialEffetRandom("force");
            						
            					}
            					else {
            						
            						trial.removeResi(0.01);
            						trial.setTrialEffetRandom("resi");
            						
            					}
            					
            		            trial.setTrialStadeActif(11);
            					
            				}
        					
        				}
        				
        			}
        			
        		}
        		
        	}
        	
        	if(!main.getJoueursByRole(Roles.TOINOU).isEmpty()) {
        		
        		List<Joueur> toinou_list = main.getJoueursByRole(Roles.TOINOU);
        		
        		for(Joueur toinou : toinou_list) {
        			
        			if(toinou.getTraqueToinou() != toinou && toinou.getTraqueToinou() != null) {
        				
        				toinou.getPlayer().setCompassTarget(toinou.getTraqueToinou().getPlayer().getLocation());
        				
        			}
        		
	        		ItemStack maudit = new ItemStack(Material.DIAMOND_SWORD, 1);
	                ItemMeta mauditM = maudit.getItemMeta();
	                mauditM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
	                mauditM.setDisplayName("Épée maudite");
	                maudit.setItemMeta(mauditM);
	                
	                ItemStack nuage = new ItemStack(Material.DIAMOND_SWORD, 1);
	                ItemMeta nuageM = nuage.getItemMeta();
	                nuageM.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
	                nuageM.setDisplayName("Nuage Flottant");
	                nuage.setItemMeta(nuageM);
	        		
	        		if(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Nuage Flottant" && !toinou.isBonusToinouNuage()) {
	        			
	        			toinou.addSpeed(0.05);
	        			toinou.setBonusToinouNuage(true);
	        			
	        		}
	        		else if(!(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Nuage Flottant") && toinou.isBonusToinouNuage()){
	        			
	        			toinou.removeSpeed(0.05);
	        			toinou.setBonusToinouNuage(false);
	        			
	        		}
	        		
	        		if(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Épée maudite" && !toinou.isBonusToinouMaudit()) {
	        			
	        			toinou.addForce(0.02);
	        			toinou.setBonusToinouMaudit(true);
	        			
	        		}
	        		else if(!(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Épée maudite") && toinou.isBonusToinouMaudit()){
	        			
	        			toinou.removeForce(0.02);
	        			toinou.setBonusToinouMaudit(false);
	        			
	        		}
	        		
        		}
        		
        	}
        	
        	for(Joueur j_ : main.getListJoueurs()) {
        		
        		if(j_.isDeco()) {
        			
        			j_.removeDecoTimer();
        			if(j_.getDeco_timer() <= 0) {
        				
        				Bukkit.broadcastMessage("_________________________\n" + j_.getPlayer().getName() + " est mort. Il était : \n" + j_.getCamp().getCouleur() + j_.getRole().getTxt() + "§r\n_________________________");
        				main.getListJoueurs().remove(j_);
        				
        			}
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.TEAM_INVISIBLE)) {
        		
        		Joueur team = main.getJoueurByRole(Roles.FARMEURIMMO);
        		
        		if(team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && (team.getPlayer().getInventory().getHelmet() != null || team.getPlayer().getInventory().getChestplate() != null || team.getPlayer().getInventory().getLeggings() != null || team.getPlayer().getInventory().getBoots() != null)) {
        			
        			team.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
        			team.removeSpeed(0.20);
        			team.setNofall(false);
        			team.removeResi(0.05);
        			team.removeForce(0.02);
        			if(main.getMode() == Modes.RAPIDE) {
	        			ItemCD cycle = new ItemCD(main, team, "force_team", 15, team, null, null, 0, null);
	        	        cycle.runTaskTimer(main, 0, 20);
        			}
        			else {
        				
        				ItemCD cycle = new ItemCD(main, team, "force_team", 60, team, null, null, 0, null);
	        	        cycle.runTaskTimer(main, 0, 20);
        				
        			}
        			
        		}
        		else if(!team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && team.getPlayer().getInventory().getHelmet() == null && team.getPlayer().getInventory().getChestplate() == null && team.getPlayer().getInventory().getLeggings() == null && team.getPlayer().getInventory().getBoots() == null){
        			
        			team.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
        			team.addSpeed(0.20);
        			team.setNofall(true);
        			team.addResi(0.05);
        			
        		}
        		
        	}
        	
        	if(!main.getJoueursByRole(Roles.TEAM).isEmpty()) {
        		
        		List<Joueur> team_list = main.getJoueursByRole(Roles.TEAM);
        		
        		for(Joueur team : team_list) {
        		
	        		if(team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && (team.getPlayer().getInventory().getHelmet() != null || team.getPlayer().getInventory().getChestplate() != null || team.getPlayer().getInventory().getLeggings() != null || team.getPlayer().getInventory().getBoots() != null)) {
	        			
	        			team.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
	        			team.removeSpeed(0.20);
	        			team.setNofall(false);
	        			team.removeResi(0.05);
	        			team.removeForce(0.02);
	        			if(main.getMode() == Modes.RAPIDE) {
		        			ItemCD cycle = new ItemCD(main, team, "force_team", 30, team, null, null, 0, null);
		        	        cycle.runTaskTimer(main, 0, 20);
	        			}
	        			else {
	        				
	        				ItemCD cycle = new ItemCD(main, team, "force_team", 120, team, null, null, 0, null);
		        	        cycle.runTaskTimer(main, 0, 20);
	        				
	        			}
	        			
	        		}
	        		else if(team.getCamp() != Camps.FARMEURIMMO && !team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && team.getPlayer().getInventory().getHelmet() == null && team.getPlayer().getInventory().getChestplate() == null && team.getPlayer().getInventory().getLeggings() == null && team.getPlayer().getInventory().getBoots() == null){
	        			
	        			team.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
	        			team.addSpeed(0.20);
	        			team.setNofall(true);
	        			team.addResi(0.05);
	        			
	        		}
        		
        		}
        		
        	}
        	
        	Bukkit.getWorld("world").setStorm(false);
        	
        	if((main.getEpisode() == 2 && main.getMode() == Modes.NORMAL) || main.getMode() != Modes.NORMAL) {
        		
        		if(timer % 3000 == 0 && main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
        			
        			for(Joueur theo : main.getJoueursByRole(Roles.THEOOCHOUX)) {
            		
            			theo.addStadeTheoochouxBonus(1);
                    
            		}
        			
        		}
        		if(timer % 1800 == 0 && main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
        			
        			for(Joueur theo : main.getJoueursByRole(Roles.THEOOCHOUX)) {
                		
        				theo.addStadeTheochouxHack(1);
                    
            		}
        			
        		}
        		
        	}
        	
        	if(!main.getJoueursByRole(Roles.THEOOCHOUX).isEmpty()) {
        		
        		for(Joueur theo_ : main.getJoueursByRole(Roles.THEOOCHOUX)) {
        		
	        			Player theo = theo_.getPlayer();
	        		
	        			RollBackCD cycle = new RollBackCD(main, theo.getLocation(), theo.getInventory(), theo.getHealth(), theo.getFoodLevel(), theo_);
	        			cycle.runTaskTimer(main, 0, 20);
                
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.THEOOCHOUX_MINIROLLBACK)) {
        		
        		Player theo = main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer();
        		
        		RollBackCD cycle = new RollBackCD(main, theo.getLocation(), theo.getInventory(), theo.getHealth(), theo.getFoodLevel(), main.getJoueurByRole(Roles.FARMEURIMMO));
    			cycle.runTaskTimer(main, 0, 20);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.NICKOBOOP) != null && !main.getSpecNicko().isEmpty() && main.getMode() == Modes.RAPIDE) {
        		
        		Joueur nicko = main.getJoueurByRole(Roles.NICKOBOOP);
        		
        		for(Joueur j : main.getSpecNicko()) {
        			
        			if(!main.getGiveBoostNicko().contains(j) && j.isProche(Roles.NICKOBOOP, main)) {
        				
        				if(j.isBonPapiers()) {
        					
        					nicko.addForce(0.01);
        					main.getGiveBoostNicko().add(j);
        					
        					
        				}
        				else {
        					
        					main.getGiveBoostNicko().add(j);
        					nicko.addResi(0.01);
        					
        				}
        				
        			}
        			else if(main.getGiveBoostNicko().contains(j) && !j.isProche(Roles.NICKOBOOP, main)) {
        				
        				
        				if(j.isBonPapiers()) {
        					
        					main.getGiveBoostNicko().remove(j);
        					nicko.removeForce(0.01);
        					
        				}
        				else {
        					
        					main.getGiveBoostNicko().remove(j);
        					nicko.removeResi(0.01);
        					
        				}
        				
        			}
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.SLUP) != null) {
        		
        		Joueur slup = main.getJoueurByRole(Roles.SLUP);
        		
        		slup.addTimerPalierSlup();
        		
        		if(slup.getTimerPalierSlup() > 600 && slup.getPalierSlup() == 1 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.01);
        				slup.removeSpeed(0.05);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 2 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.02);
        				slup.removeSpeed(0.07);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 300 && slup.getPalierSlup() == 3 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.03);
        				slup.removeSpeed(0.1);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 4 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(2);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.05);
        				slup.removeSpeed(0.015);
        				
        			}
        			
        		}
        		
        		if(main.getLocZoneSlup() != null) {
            		
            		for(Joueur j : main.getJoueurInGame()) {
            			
            			if(j.isInSlupZone(main) && !j.isMalusZoneSlup() && j.getCamp() != slup.getCamp()) {
            				
            				if(main.isAdaptionObscurActif()) {
            					
            					if(main.getAdaptionAvantObscur().contains(Pouvoirs.SLUP_SLIME)) {
        	            			
        	            			main.getAdaptionPermaObscur().add(Pouvoirs.SLUP_SLIME);
        	            			
        	            		}
            					else if(!main.getAdaptionPermaObscur().contains(Pouvoirs.SLUP_SLIME)) {
            						
            						j.setMalusZoneSlup(true);
                    				j.removeSpeed(0.05);
            						
            					}
            					
            				}
            				else if(!main.getAdaptionPermaObscur().contains(Pouvoirs.SLUP_SLIME)) {
        						
        						j.setMalusZoneSlup(true);
                				j.removeSpeed(0.05);
        						
        					}
            				
            			}
            			else if(!j.isInSlupZone(main) && j.isMalusZoneSlup() && j.getCamp() != slup.getCamp()) {
            				
            				j.setMalusZoneSlup(false);
            				j.addSpeed(0.05);
            				
            			}
            			
            		}
            		
            	}
        		
        	}
        	
        	if(!main.getMaudit().isEmpty() && main.getNiv_maledition() > 1) {
        		
        		if(main.getMode() == Modes.RAPIDE) {
        			
            		Joueur cible1 = main.getMaudit().get(0);
        			Joueur nono = main.getMaudit().get(1);
        			
        			if(!cible1.isProche(nono.getRole(), main)) {
        				
        				cible1.setAbso(false);
        				
        			}
        			else {
        				
        				cible1.setAbso(true);
        				
        			}
        			
        		}
        		else {
        		
	        		Joueur cible1 = main.getMaudit().get(0);
	    			Joueur cible2 = main.getMaudit().get(1);
	    			
	    			if(!cible1.isProche(cible2.getRole(), main)) {
	    				
	    				cible1.setAbso(false);
	    				cible2.setAbso(false);
	    				
	    			}
	    			else {
	    				
	    				cible1.setAbso(true);
	    				cible2.setAbso(true);
	    				
	    			}
	    			
        		}
        		
        	}
        	
        	if(main.getNeko() != null && !main.getNeko().isMort() && main.getNeko().isProche(Roles.MAKA, main) && !main.getNeko().isSpeedProche() && !main.getJoueurByRole(Roles.MAKA).isMort()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().addSpeed(0.01);
        			main.getNeko().addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().addSpeed(0.02);
        			main.getNeko().addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().addSpeed(0.05);
        			main.getNeko().addForce(0.01);
        			main.getNeko().addResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().addSpeed(0.05);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().addSpeed(0.07);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.02);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().addSpeed(0.10);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.02);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		
        	}
        	else if(main.getNeko() != null && !main.getNeko().isProche(Roles.MAKA, main) && main.getNeko().isSpeedProche()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().removeSpeed(0.01);
        			main.getNeko().removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().removeSpeed(0.02);
        			main.getNeko().removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().removeSpeed(0.05);
        			main.getNeko().removeForce(0.01);
        			main.getNeko().removeResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().removeSpeed(0.05);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().removeSpeed(0.07);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.02);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().removeSpeed(0.1);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.02);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.MAKA) != null && main.getJoueurByRole(Roles.MAKA).getForme().equalsIgnoreCase("normal") && main.getJoueurByRole(Roles.MAKA).isProche(Roles.TEAM, main) && !main.getJoueurByRole(Roles.MAKA).isResiProche()) {
        		
        		Joueur maka = main.getJoueurByRole(Roles.MAKA);
        		maka.addResi(0.02);
        		maka.setResiProche(true);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.MAKA) != null && (!main.getJoueurByRole(Roles.MAKA).getForme().equalsIgnoreCase("normal") || !main.getJoueurByRole(Roles.MAKA).isProche(Roles.TEAM, main)) && main.getJoueurByRole(Roles.MAKA).isResiProche()) {
        		
        		Joueur maka = main.getJoueurByRole(Roles.MAKA);
        		maka.removeResi(0.02);
        		maka.setResiProche(false);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.GAMEBLACK) != null && !main.getJoueurByRole(Roles.GAMEBLACK).isChoixGbCamp()) {
        		
        		Joueur gameblack = main.getJoueurByRole(Roles.GAMEBLACK);
        		
        		if(main.getJoueurByRole(Roles.MALIVOL) == null) {
        			
        			gameblack.setChoixGbCamp(true);
        			
        		}
        		else if(main.getJoueurByRole(Roles.TEAM) == null && main.getJoueurByRole(Roles.MAKA) == null) {
        			
        			gameblack.setChoixGbCamp(true);
        			gameblack.setCamp(Camps.UHC);
        			GameBlack.ItemsUHC(gameblack, main);
        			
        		}
        		else {
        			
        			if(gameblack.isProche(Roles.MALIVOL, main)) {
        				
        				gameblack.setChoixGbCamp(true);
        				gameblack.setCamp(Camps.UHC);
        				GameBlack.ItemsUHC(gameblack, main);
        				
        			}
        			else if(gameblack.isProche(Roles.MAKA, main) || gameblack.isProche(Roles.TEAM, main)) {
        				
        				gameblack.setChoixGbCamp(true);
        				
        			}
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.JEANNOT) != null) {
        		
        		if(main.getJoueurByRole(Roles.NICKOBOOP) != null && (main.getJoueurByRole(Roles.FARMEURIMMO) == null || main.getJoueurByRole(Roles.NICKOBOOP).getCamp() != Camps.FARMEURIMMO)) {
        		
        			Nickoboop.checkProcheJeannot(main.getJoueurByRole(Roles.NICKOBOOP), main);
        			
        		}
        		
        		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.NICKOBOOP_PROCHE_JEANNOT)) {
        			
        			Nickoboop.checkProcheJeannot(main.getJoueurByRole(Roles.FARMEURIMMO), main);
        			
        		}
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode() / 2 && main.getEpisode() != 1) {
        		
        		Joueur slup = main.getJoueurByRole(Roles.SLUP);
        		
        		if(slup != null) {
        			slup.addSlime(1);
        		}
        		
        		resetCD(main);

                if (main.isDay()) {

                    main.setJour(false);
                    Bukkit.broadcastMessage("§1LA NUIT TOMBE");
                    Nuit(main);

                } else {

                    main.setJour(true);
                    Bukkit.broadcastMessage("§6LE JOUR SE LEVE");
                    Jour(main);

                }

            }
        	
        	if(main.getTemps() == 10 && main.getEpisode() == 1 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP)) {
        		
        		Bukkit.broadcastMessage("Attribution des rôles");
        		setRole(main);
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode()) {
            	
            	resetCD(main);

                int episode = main.getEpisode() + 1;

                Bukkit.broadcastMessage("_________________________\n \nEpisode " + episode + "\n_________________________");

                if (main.getEpisode() == 1 && main.getMode() == Modes.NORMAL) {

                	Bukkit.broadcastMessage("Attribution des rôles");
                	setRole(main);

                }

                main.addEpisode();
                if (main.isDay()) {

                    main.setJour(false);
                    Bukkit.broadcastMessage("§1LA NUIT TOMBE");

                } else {

                    main.setJour(true);
                    Bukkit.broadcastMessage("§6LE JOUR SE LEVE");

                }

            }
            
            main.addTemps();
            
            if(score_board) {
            
            	Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
            	
            		setScoreboard(main, timer);
	            
            	});
	            
        	}
            
            for (Joueur joueur : main.getJoueurInGame()) {
    	    	
    	    	Player player = joueur.getPlayer();
    	    	
    	    	Trial.checkZoneBenihimeAratame(main);
    	    	Team.checkZoneJustice(main);
    	    	
    	    	if(joueur.isCorrompu()) {
    	    		
    	    		List<Joueur> corruption = new ArrayList<>();
    	    		
    	    		for(Entity entity : player.getNearbyEntities(20, 20, 20)) {
    	    			
    	    			if(entity instanceof Player) {
    	    				
    	    				Player pls = (Player) entity;
    	    				Joueur j = main.getJoueur(pls);
    	    				if(!j.isCorrompuIndirect()) {
    	    					
    	    					j.setCorrompuIndirect(true);
    	    					j.removeForce(0.02);
    	    					
    	    				}
    	    				corruption.add(j);
    	    				
    	    			}
    	    			
    	    		}
    	    		
    	    		for(Joueur j : main.getJoueurInGame()) {
    	    			
    	    			if(!corruption.contains(j) && j.isCorrompuIndirect()) {
    	    				
    	    				j.addForce(0.02);
    	    				
    	    			}
    	    			
    	    		}
    	    		
    	    	}
    	
    	        if (player.getWalkSpeed() != 0.2 * (joueur.getSpeed()/100)) {
    	
    	        	player.setWalkSpeed((float) (0.2 * (joueur.getSpeed())/100));
    	
    	        }
    	
    	    }
        	
        }

        timer++;

    }

	public static Scoreboard getBoard_game() {
		return board_game;
	}

	public static void setBoard_game(Scoreboard board_game) {
		GameCycle.board_game = board_game;
	}

}
