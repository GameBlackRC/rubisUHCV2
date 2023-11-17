package fr.gameblack.rcuhcv2.classes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.v1.Pieces;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.classes.v1.VolTrial;
import fr.gameblack.rcuhcv2.classes.v2.Classe;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.roles.v1.demons.Ange;
import fr.gameblack.rcuhcv2.roles.v1.demons.Avenir;
import fr.gameblack.rcuhcv2.roles.v1.demons.Cosmos;
import fr.gameblack.rcuhcv2.roles.v1.demons.Demon;
import fr.gameblack.rcuhcv2.roles.v1.demons.Electrique;
import fr.gameblack.rcuhcv2.roles.v1.demons.Enfer;
import fr.gameblack.rcuhcv2.roles.v1.demons.Malediction;
import fr.gameblack.rcuhcv2.roles.v1.demons.MalivolV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.ObscurV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.Sang;
import fr.gameblack.rcuhcv2.roles.v1.demons.SlupV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.Tenebre;
import fr.gameblack.rcuhcv2.roles.v1.demons.TrialV1;
import fr.gameblack.rcuhcv2.roles.v1.demons.Tronconeuse;
import fr.gameblack.rcuhcv2.roles.v1.rc.Archer;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.Guerrier;
import fr.gameblack.rcuhcv2.roles.v1.rc.JokoV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.LoupV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.MakaV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.RaptorV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.TeamV1;
import fr.gameblack.rcuhcv2.roles.v1.rc.ToinouV1;
import fr.gameblack.rcuhcv2.roles.v1.solo.Experimental;
import fr.gameblack.rcuhcv2.roles.v1.solo.FarmeurimmoV1;
import fr.gameblack.rcuhcv2.roles.v1.solo.KzouV1;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Jeannot;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Joko;
import fr.gameblack.rcuhcv2.roles.v2.staff.Team;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Maka;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;
import fr.gameblack.rcuhcv2.roles.v2.staff.Captain;
import fr.gameblack.rcuhcv2.roles.v2.staff.Hekow;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Malivol;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Toinou;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v1.GameCycleV1;
import fr.gameblack.rcuhcv2.task.v2.GameCycle;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Obscur;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Theoochoux;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Nonoboy;
import fr.gameblack.rcuhcv2.roles.v2.solo.Farmeurimmo;
import fr.gameblack.rcuhcv2.roles.v2.solo.Kzou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {
	
	private Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
	private int deco_timer = 600;
	private boolean deco = false;
	
	private Player player;
	private Roles role = Roles.NONE;
	private Orbe orbe = Orbe.NONE;
	private boolean orbe_actif = false;
	private boolean orbe_passif_actif = false;
	private boolean bonus_orbe_actif = false;
	private boolean malus_orbe_actif = false;
	private int kill = 0;
	private boolean invulnerable = true;
	private Joueur lastHit = null;
	private boolean respawn = false;
	private double speed = 100;
	private double force = 100;
	private double resi = 110;
	private boolean abso = true;
	private boolean fire = false;
	private boolean can_have_malus_bonus_orbe = true;
	private int malivol_cheat = 0;
	private boolean antiKB = false;
	private List<Pouvoirs> vol = new ArrayList<>();
	private boolean jeannotPartageActif = false;
	private boolean spec = false;
	private String camp = "rien";
	private int comboSubi = 0;
	private boolean nofall = false;
	private boolean nofallPerma = false;
	private boolean cheatToinou = false;
	private boolean CanFight = true;
	private int pourcentHack = 0;
	private int pacteSlup = 0;
	private boolean bonPapiers = false;
	private boolean nickoProcheJeannot = false;
	private boolean cheatRaptorActif = false;
	private boolean cheatToinouActif = false;
	private boolean jokoItemActif = false;
	private int cube = 0;
	private boolean opKzou = false;
	private int nbOpKzou = 0;
	private boolean mort = false;
	private boolean respawnTrial = false;
	private boolean choixGbCamp = false;
	private boolean checkMalusEau = true;
	private boolean consoleGBActif = false;
	private Classe classeGB = null;
	private String forme = "normal";
	private boolean resiProche = false;
	private boolean frappeNeko = false;
	private boolean speedProche = false;
	private boolean forceProche = false;
	private int slime = 0;
	private boolean malusZoneSlup = false;
	private boolean slupBonusPalierActif = false;
	private int palierSlup = 0;
	private boolean malusSlupActif = false;
	private int timerPalierSlup = 0;
	private boolean hack = false;
	private boolean invisible = false;
	private int utilisationSacrificeTrial = 0;
	private boolean inZoneBenihime = false;
	private boolean corrompu = false;
	private boolean corrompuIndirect = false;
	private boolean inZoneSkinTrial = false;
	private boolean tueurToinouKill = false;
	private boolean inZoneJustice = false;
	private int points = 0;
	private boolean firstItemToinou = false;
	private boolean bonusToinouNuage = false;
	private boolean bonusToinouMaudit = false;
	private boolean useRubisBleu = false;
	private int repairCaptain = 0;
	private boolean hekowJeuActif = false;
	private int HekowPourcent = 0;
	private boolean superBateauLoup = false;
	private boolean JeannotAbso = false;
	private boolean pouvoirRaptorActif = false;
    private Location theoochouxLoc = null;
    private Location theoochouxLoc3sec = null;
    private Inventory theoochouxInv = null;
    private Double theoochouxHP = 20.0;
    private int theoochouxFood = 20;
    private int theo = 5;
    private int stadeTheoochouxBonus = theo;
    private int stadeTheochouxHack = theo;
    private List<Pouvoirs> cd = new ArrayList<>();
	
	private int NBObscurCopie = 0;
	private Orbe casqueObscur = Orbe.NONE;
	private Orbe plastronObscur = Orbe.NONE;
	private Orbe jambiereObscur = Orbe.NONE;
	private Orbe bottesObscur = Orbe.NONE;
	private Orbe epeeObscur = Orbe.NONE;
	private boolean casqueObscurActif = false;
	private boolean plastronObscurActif = false;
	private boolean jambiereObscurActif = false;
	private boolean bottesObscurActif = false;
	private boolean epeeObscurActif = false;
	private List<VolTrial> volTrial = new ArrayList<>();
	private Pouvoirs_GB pouvoirGB = Pouvoirs_GB.NONE;
	private boolean flairGB = false;
	private boolean canUseChoose = false;
	private boolean useChoose = false;
	private boolean GBFindThisDemon = false;
	private int GBPourcent = 0;
	private int LVLGBRestant = 0;
	private String bonusPalier10GB = null;
	private boolean effetProcheGB = false;
	private boolean nerfFlairGB = false;
	private boolean makaRageActif = false;
	private boolean findTueurNeko = false;
	private int procheSlup = 0;
	private boolean speedIIActif = false;
	private boolean saigne = false;

	public Joueur(Player player) {
		
		this.player = player;
		
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Roles getRole() {
		
		return role;
		
	}
	
	public void reset(Main main) {
		
		role = Roles.NONE;
		orbe = Orbe.NONE;
		orbe_actif = false;
		bonus_orbe_actif = false;
		malus_orbe_actif = false;
		kill = 0;
		invulnerable = true;
		lastHit = null;
		respawn = false;
		speed = 100;
		force = 100;
		resi = 110;
		abso = true;
		fire = false;
		can_have_malus_bonus_orbe = true;
		malivol_cheat = 0;
		antiKB = false;
		vol = new ArrayList<>();
		jeannotPartageActif = false;
		spec = false;
		camp = "rien";
		comboSubi = 0;
		nofall = false;
		cheatToinou = false;
		CanFight = true;
		pourcentHack = 0;
		pacteSlup = 0;
		bonPapiers = false;
		nickoProcheJeannot = false;
		cheatRaptorActif = false;
		cheatToinouActif = false;
		jokoItemActif = false;
		cube = 0;
		opKzou = false;
		nbOpKzou = 0;
		mort = false;
		respawnTrial = false;
		choixGbCamp = false;
		checkMalusEau = false;
		consoleGBActif = false;
		classeGB = null;
		forme = "normal";
		resiProche = false;
		frappeNeko = false;
		speedProche = false;
		setRespawnTrial(false);
		slime = 0;
		show(main);
		malusZoneSlup = false;
		slupBonusPalierActif = false;
		palierSlup = 0;
		malusSlupActif = false;
		timerPalierSlup = 0;
		hack = false;
		invisible = false;
		utilisationSacrificeTrial = 0;
		inZoneBenihime = false;
		corrompu = false;
		corrompuIndirect = false;
		inZoneSkinTrial = false;
		tueurToinouKill = false;
		inZoneJustice = false;
		points = 0;
		firstItemToinou = false;
		bonusToinouNuage = false;
		bonusToinouMaudit = false;
		useRubisBleu = false;
		repairCaptain = 0;
		setHekowJeuActif(false);
		setHekowPourcent(0);
		setSuperBateauLoup(false);
		JeannotAbso = false;
	    setTheoochouxLoc(null);
	    setTheoochouxLoc3sec(null);
	    setTheoochouxInv(null);
	    setTheoochouxHP(20.0);
	    setTheoochouxFood(20);
	    theo = 5;
	    setStadeTheoochouxBonus(theo);
	    setStadeTheochouxHack(theo);
		deco_timer = 600;
		deco = false;
		pouvoirRaptorActif = false;
		cd.clear();
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "skin set " + player.getName() + " " + player.getName());
		if(main.getScenarios().contains(Scenarios.CATS_EYES) && player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
			
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			
		}
		
		NBObscurCopie = 0;
		casqueObscur = Orbe.NONE;
		plastronObscur = Orbe.NONE;
		jambiereObscur = Orbe.NONE;
		bottesObscur = Orbe.NONE;
		epeeObscur = Orbe.NONE;
		casqueObscurActif = false;
		plastronObscurActif = false;
		jambiereObscurActif = false;
		bottesObscurActif = false;
		epeeObscurActif = false;
		volTrial = new ArrayList<>();
		pouvoirGB = Pouvoirs_GB.NONE;
		flairGB = false;
		canUseChoose = false;
		useChoose = false;
		GBFindThisDemon = false;
		GBPourcent = 0;
		LVLGBRestant = 0;
		bonusPalier10GB = null;
		effetProcheGB = false;
		nerfFlairGB = false;
		makaRageActif = false;
		findTueurNeko = false;
		procheSlup = 0;
		setSpeedIIActif(false);
		
		if(main.getListHost().contains(this)) {
			
			player.getInventory().clear();
    		
    		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("§8Paramètre de la partie");
            coffre.setItemMeta(coffreM);
            getPlayer().getInventory().addItem(coffre);
            
            getPlayer().setGameMode(GameMode.SURVIVAL);
			
		}
		
	}
	
	public void addOrbe(Main main) {
		
		if(main.getVersion() == 2) {
			
			Random r = new Random();
        	
        	int nb_ = r.nextInt(4);

            if (nb_ == 1) {
                
                if(getRole() != Roles.MALIVOL) {
	                
	            	setOrbe(Orbe.EAU);
	            	Eau.Passif(this, main, true);
	                player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
    	            	setOrbe(Orbe.FEU);
    	            	Feu.Passif(this, main, true);
    	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			setOrbe(Orbe.FOUDRE);
            			Foudre.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			setOrbe(Orbe.GLACE);
            			Glace.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 2) {

            	nb_ = r.nextInt(3);
            	
            	if(getRole() != Roles.MAKA) {
            	
	            	setOrbe(Orbe.FEU);
	            	Feu.Passif(this, main, true);
	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			setOrbe(Orbe.EAU);
            			Eau.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			setOrbe(Orbe.FOUDRE);
            			Foudre.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			setOrbe(Orbe.GLACE);
            			Glace.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 3) {

            	nb_ = r.nextInt(3);
            	
            	if(getRole() != Roles.CAPTAIN) {
            	
	            	setOrbe(Orbe.FOUDRE);
	            	Foudre.Passif(this, main, true);
	                player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			setOrbe(Orbe.EAU);
            			Eau.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
    	            	setOrbe(Orbe.FEU);
    	            	Feu.Passif(this, main, true);
    	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			setOrbe(Orbe.GLACE);
            			Glace.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else {

            	setOrbe(Orbe.GLACE);
            	Glace.Passif(this, main, true);
                player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");

            }
			
		}
		else if(main.getVersion() == 1) {
			
			Random r = new Random();
        	
        	int nb_ = r.nextInt(4);

            if (nb_ == 1) {
	                
	            setOrbe(Orbe.EAU);
	            Eau.Passif(this, main, true);
	            player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            	

            } else if (nb_ == 2) {

            	nb_ = r.nextInt(3);
            	
            	if(getRole() != Roles.Maka) {
            	
	            	setOrbe(Orbe.FEU);
	            	Feu.Passif(this, main, true);
	                player.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
	                
            	}
            	else {
            		
            		if(nb_ == 1) {
            			
            			setOrbe(Orbe.EAU);
            			Eau.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else if(nb_ == 2) {
            			
            			setOrbe(Orbe.FOUDRE);
            			Foudre.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		else {
            			
            			setOrbe(Orbe.GLACE);
            			Glace.Passif(this, main, true);
                        player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
            			
            		}
            		
            	}

            } else if (nb_ == 3) {

            	setOrbe(Orbe.FOUDRE);
            	Foudre.Passif(this, main, true);
                player.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");

            } else {

            	setOrbe(Orbe.GLACE);
            	Glace.Passif(this, main, true);
                player.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");

            }
			
		}
		
	}
	
	public String getCouleurCamp(Main main) {
		
		if(main.getVersion() == 2) {
		
			if(camp.equalsIgnoreCase("joueur")) {
				
				return "§a";
				
			}
			else if(camp.equalsIgnoreCase("uhc")) {
				
				return "§2";
				
			}
			else if(camp.equalsIgnoreCase("staff")) {
				
				return "§9";
				
			}
			else if(camp.equalsIgnoreCase("duo")) {
				
				return "§5";
				
			}
			else if(camp.equalsIgnoreCase("farmeurimmo")) {
				
				return "§c";
				
			}
			else {
				
				return "§6";
				
			}
			
		}
		else if(main.getVersion() == 1) {
			
			if(camp.equalsIgnoreCase("rc")) {
				
				return "§a";
				
			}
			else if(camp.equalsIgnoreCase("demon")) {
				
				return "§c";
				
			}
			else {
				
				return "§6";
				
			}
			
		}
		else {
			
			return "";			
		}
		
	}
	
	public boolean isProche(Roles role, Main main) {
		
		for(Entity entity : player.getNearbyEntities(20, 20, 20)) {
			
			if(entity instanceof Player) {
				
				Player p = (Player) entity;
				Joueur j = main.getJoueur(p);
			
				if(j.getRole() == role && !j.isMort()) {
					
					return true;
					
				}
			
			}
			
		}
		
		return false;
		
	}
	
	public boolean isProche10(Roles role, Main main) {
		
		for(Entity entity : player.getNearbyEntities(10, 10, 10)) {
			
			if(entity instanceof Player) {
				
				Player p = (Player) entity;
				Joueur j = main.getJoueur(p);
			
				if(j.getRole() == role && !j.isMort()) {
					
					return true;
					
				}
			
			}
			
		}
		
		return false;
		
	}
	
	public boolean isProcheNb(Roles role, Main main, int nb) {
		
		for(Entity entity : player.getNearbyEntities(nb, nb, nb)) {
			
			if(entity instanceof Player) {
				
				Player p = (Player) entity;
				Joueur j = main.getJoueur(p);
			
				if(j.getRole() == role && !j.isMort()) {
					
					return true;
					
				}
			
			}
			
		}
		
		return false;
		
	}
	
	public boolean isAccesSuperBateau(Main main) {
		
		if(main.getAccesBateauLoup().contains(this)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	public boolean isNickoSpecPapier(Main main) {
		
		if(main.getSpecNicko().contains(this)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void setRole(Roles role, Main main) {
		
		this.role = role;
		this.camp = role.getCamp();
		
		if(main.getVersion() == 2) {
		
			if(role == Roles.RAPTOR) {
				
				Raptor.Items(this);
				this.bonPapiers = true;
				
			}
			else if(role == Roles.JEANNOT) {
				
				Jeannot.Items(this, main);
				this.bonPapiers = true;
				
			}
			else if(role == Roles.NICKOBOOP) {
				
				Nickoboop.Items(this);
				this.bonPapiers = true;
				
			}
			else if(role == Roles.SLUP) {
				
				Slup.Items(this);
				this.bonPapiers = true;
				
			}
			else if(role == Roles.JOKO) {
				
				Joko.Items(this);
				this.bonPapiers = true;
				
			}
			else if(role == Roles.TEAM) {
				
				Team.Items(this);
				
			}
			else if(role == Roles.GAMEBLACK) {
				
				GameBlack.Items(this);
				
				this.bonPapiers = true;
				
			}
			else if(role == Roles.MAKA) {
				
				Maka.Items(this);
				
			}
			else if(role == Roles.TRIAL) {
				
				Trial.Items(this);
				
			}
			else if(role == Roles.LOUP) {
				
				Loup.Items(this);
				
			}
			else if(role == Roles.CAPTAIN) {
				
				Captain.Items(this);
				
			}
			else if(role == Roles.HEKOW) {
				
				Hekow.Items(this);
				
			}
			else if(role == Roles.MALIVOL) {
				
				Malivol.Items(this);
				
			}
			else if(role == Roles.TOINOU) {
				
				Toinou.Items(this);
				
			}
			else if(role == Roles.OBSCUR) {
				
				Obscur.Items(this);
				
			}
			else if(role == Roles.NONOBOY) {
				
				Nonoboy.Items(this);
				
			}
			else if(role == Roles.THEOOCHOUX) {
				
				Theoochoux.Items(this, main);
				
			}
			else if(role == Roles.FARMEURIMMO) {
				
				Farmeurimmo.Items(this);
				
				this.bonPapiers = true;
				
			}
			else if(role == Roles.KZOU) {
				
				Kzou.Items(this);
				
			}
			
		}
		else if(main.getVersion() == 1) {
			
			if(role == Roles.GameBlack) {
				
				GameBlackV1.Items(this, main);
				
			}
			else if(role == Roles.Team) {
				
				TeamV1.Items(this, main);
				
			}
			else if(role == Roles.Joko) {
				
				JokoV1.Items(this);
				
			}
			else if(role == Roles.Toinou) {
				
				ToinouV1.Items(this);
				
			}
			else if(role == Roles.Maka) {
				
				MakaV1.Items(this);
				
			}
			else if(role == Roles.Loup) {
				
				LoupV1.Items(this);
				
			}
			else if(role == Roles.Raptor) {
				
				RaptorV1.Items(this);
				
			}
			else if(role == Roles.Guerrier) {
				
				Guerrier.Items(this, main);
				
			}
			else if(role == Roles.Archer) {
				
				Archer.Items(this);
				
			}
			else if(role == Roles.Trial) {
				
				TrialV1.Items(this);
				
			}
			else if(role == Roles.Slup) {
				
				SlupV1.Items(this, main);
				
			}
			else if(role == Roles.Malivol) {
				
				MalivolV1.Items(this);
				
			}
			else if(role == Roles.Obscur) {
				
				ObscurV1.Items(this);
				
			}
			else if(role == Roles.Ange) {
				
				Ange.Items(this);
				
			}
			else if(role == Roles.Avenir) {
				
				Avenir.Items(this);
				
			}
			else if(role == Roles.Cosmos) {
				
				Cosmos.Items(this, main);
				
			}
			else if(role == Roles.Demon) {
				
				Demon.Items(this, main);
				
			}
			else if(role == Roles.Electrique) {
				
				Electrique.Items(this);
				
			}
			else if(role == Roles.Enfer) {
				
				Enfer.Items(this, main);
				
			}
			else if(role == Roles.Malediction) {
				
				Malediction.Items(this);
				
			}
			else if(role == Roles.Sang) {
				
				Sang.Items(this);
				
			}
			else if(role == Roles.Tronconeuse) {
				
				Tronconeuse.Items(this);
				
			}
			else if(role == Roles.Tenebre) {
				
				Tenebre.Items(this, main);
				
			}
			else if(role == Roles.Farmeurimmo) {
				
				FarmeurimmoV1.Items(this, main);
				
			}
			else if(role == Roles.Kzou) {
				
				KzouV1.Items(this);
				
			}
			else if(role == Roles.Experimental) {
				
				Experimental.Items(this, main);
				
			}
			
		}
		
	}
	
	public Orbe getOrbe() {
		
		return orbe;
		
	}
	
	public void setOrbe(Orbe orbe) {
		
		this.orbe = orbe;
		
	}
	
	public boolean isOrbeActif() {
		
		return orbe_actif;
		
	}
	
	public void setStatutOrbe(boolean orbe_actif) {
		
		this.orbe_actif = orbe_actif;
		
	}
	
	public boolean isBonusOrbeActif() {
		
		return bonus_orbe_actif;
		
	}
	
	public void setBonusOrbe(boolean bonus_orbe_actif) {
		
		this.bonus_orbe_actif = bonus_orbe_actif;
		
	}
	
	public boolean isMalusOrbeActif() {
		
		return malus_orbe_actif;
		
	}
	
	public void setMalusOrbe(boolean malus_orbe_actif) {
		
		this.malus_orbe_actif = malus_orbe_actif;
		
	}
	
	public int getKill() {
		
		return kill;
		
	}
	
	public void addKill() {
		
		kill += 1;
		
	}
	
	public void removeKill() {
		
		kill -= 1;
		
	}
	
	public void resetKill() {
		
		kill = 0;
		
	}
	
	public void setKill(int kill) {
		
		this.kill = kill;
		
	}
	
	public boolean isInvulnerable() {
		
		return invulnerable;
		
	}
	
	public void setInvulnerable(boolean invulnerable) {
		
		this.invulnerable = invulnerable;
		
	}
	
	public Joueur getLastHit() {
		
		return lastHit;
		
	}
	
	public void setLastHit(Joueur joueur) {
		
		lastHit = joueur;
		
	}
	
	public boolean canRespawn() {
		
		return respawn;
		
	}
	
	public void setRespawn(boolean respawn) {
		
		this.respawn =  respawn;
		
	}

	public double getSpeed() {
		return speed;
	}
	
	public int getSpeedInt() {
		return (int) speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed*100;
	}
	
	public void setSpeedInt(int speed) {
		this.speed = speed;
	}
	
	public void addSpeed(double speed) {
		this.speed += speed*100;
	}
	
	public void removeSpeed(double speed) {
		this.speed -= speed*100;
	}

	public double getForce() {
		return force;
	}

	public void setForce(double force) {
		this.force = force*100;
	}
	
	public void addForce(double force) {
		this.force += force*100;
	}
	
	public void removeForce(double force) {
		this.force -= force*100;
	}

	public double getResi() {
		return resi;
	}

	public void setResi(double resi) {
		this.resi = resi*100;
	}
	
	public void addResi(double resi) {
		this.resi += resi*100;
	}
	
	public void removeResi(double resi) {
		this.resi -= resi*100;
	}

	public boolean isAbsoOn() {
		return abso;
	}

	public void setAbso(boolean abso) {
		this.abso = abso;
	}

	public boolean isFireOn() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	public boolean canHaveMalusBonusOrbe() {
		return can_have_malus_bonus_orbe;
	}

	public void setCanHaveMalusBonusOrbe(boolean can_active_orbe) {
		this.can_have_malus_bonus_orbe = can_active_orbe;
	}

	public int getMalivolCheat() {
		return malivol_cheat;
	}

	public void setMalivolCheat(int malivol_cheat) {
		this.malivol_cheat = malivol_cheat;
	}

	public boolean isAntiKB() {
		return antiKB;
	}

	public void setAntiKB(boolean antiKB) {
		this.antiKB = antiKB;
	}

	public List<Pouvoirs> getVol() {
		return vol;
	}

	public boolean isJeannotPartageActif() {
		return jeannotPartageActif;
	}

	public void setJeannotPartageActif(boolean jeannotPartageActif) {
		this.jeannotPartageActif = jeannotPartageActif;
	}

	public boolean isSpec() {
		return spec;
	}

	public void setSpec(boolean spec) {
		this.spec = spec;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public int getComboSubi() {
		return comboSubi;
	}

	public void setComboSubi(int comboSubi) {
		this.comboSubi = comboSubi;
	}

	public boolean isNofall() {
		return nofall;
	}

	public void setNofall(boolean nofall) {
		this.nofall = nofall;
	}

	public boolean isCheatToinou() {
		return cheatToinou;
	}

	public void setCheatToinou(boolean cheatToinou) {
		this.cheatToinou = cheatToinou;
	}

	public boolean canFight() {
		return CanFight;
	}

	public void setCanFight(boolean canFight) {
		CanFight = canFight;
	}

	public String getModeTrial(Main main) {
		return main.getModeTrial();
	}

	public void setModeTrial(String modeTrial, Main main) {
		main.setModeTrial(modeTrial);
	}
	
	public boolean isFarmeurimmoProche(Main main) {
		
		for(Entity entity : player.getNearbyEntities(25, 25, 25)) {
			
			if(entity instanceof Player && main.getJoueur((Player)entity).getRole() == Roles.FARMEURIMMO) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	public int getPourcentHack() {
		return pourcentHack;
	}

	public void setPourcentHack(int pourcentHack, Main main, Scoreboard board_hack) {
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
			this.pourcentHack = pourcentHack;
			Objective objective_hack;
			if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("hack") == null) {
				objective_hack = board_hack.registerNewObjective("hack", "dummy");
			}
			else {
				objective_hack = board_hack.getObjective("hack");
			}
	        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
	        objective_hack.setDisplayName("%");
	        @SuppressWarnings("deprecation")
			Score score = objective_hack.getScore(player);
	        score.setScore(pourcentHack);
	        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
	        
		}
	}
	
	public void addPourcentHack(int nb, Main main, Scoreboard board_hack) {
		
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
		
			if(role != Roles.FARMEURIMMO) {
			
				if(role != Roles.MAKA) {
				
					if(pourcentHack + nb >= 100) {
						
						if(pourcentHack != 100) {
						
							pourcentHack = 100;
						
						}
						
					}
					else {
						
						pourcentHack += nb;
						
					}
					
				}
				else {
					
					if(pourcentHack + nb >= 40) {
						
						if(pourcentHack != 40) {
						
							pourcentHack = 40;
						
						}
						
					}
					else {
						
						pourcentHack += nb;
						
					}
					
				}
				
				Objective objective_hack;
				if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("hack") == null) {
					objective_hack = board_hack.registerNewObjective("hack", "dummy");
				}
				else {
					objective_hack = board_hack.getObjective("hack");
				}
		        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
		        objective_hack.setDisplayName("%");
		        @SuppressWarnings("deprecation")
				Score score = objective_hack.getScore(player);
		        score.setScore(pourcentHack);
		        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
				
			}
			
		}
		
	}
	
	public void removePourcentHack(int nb, Main main, Scoreboard board_hack) {
		
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
		
			if(role != Roles.FARMEURIMMO) {
				
				if(pourcentHack - nb <= 100) {
						
					if(pourcentHack != 0) {
						
						pourcentHack = 0;
						
					}
						
				}
				else {
						
					pourcentHack -= nb;
						
				}
				
				Objective objective_hack;
				if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("hack") == null) {
					objective_hack = board_hack.registerNewObjective("hack", "dummy");
				}
				else {
					objective_hack = board_hack.getObjective("hack");
				}
		        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
		        objective_hack.setDisplayName("%");
		        @SuppressWarnings("deprecation")
				Score score = objective_hack.getScore(player);
		        score.setScore(pourcentHack);
		        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
				
			}
			
		}
		
	}

	public int getPacteSlup() {
		return pacteSlup;
	}

	public void setPacteSlup(int pacteSlup) {
		this.pacteSlup = pacteSlup;
	}

	public boolean isBonPapiers() {
		return bonPapiers;
	}

	public void setBonPapiers(boolean bonPapiers) {
		this.bonPapiers = bonPapiers;
	}

	public boolean isNickoProcheJeannot() {
		return nickoProcheJeannot;
	}

	public void setNickoProcheJeannot(boolean nickoProcheJeannot) {
		this.nickoProcheJeannot = nickoProcheJeannot;
	}

	public boolean isCheatRaptorActif() {
		return cheatRaptorActif;
	}

	public void setCheatRaptorActif(boolean cheatRaptorActif) {
		this.cheatRaptorActif = cheatRaptorActif;
	}

	public boolean isCheatToinouActif() {
		return cheatToinouActif;
	}

	public void setCheatToinouActif(boolean cheatToinouActif) {
		this.cheatToinouActif = cheatToinouActif;
	}

	public boolean isJokoItemActif() {
		return jokoItemActif;
	}

	public void setJokoItemActif(boolean jokoItemActif) {
		this.jokoItemActif = jokoItemActif;
	}

	public int getCube() {
		return cube;
	}

	public void setCube(int cube, Main main) {
		
		Scoreboard board_cube = GameCycle.getScoreboardJoko();
		Roles role = Roles.JOKO;
		
		if(main.getVersion() == 1) {
			
			board_cube = GameCycleV1.getScoreboardJoko();
			role = Roles.Joko;
			
		}
		
		this.cube = cube;
		Objective objective_cube;
		if(board_cube.getObjectives().isEmpty() || board_cube.getObjective("cube") == null) {
			objective_cube = board_cube.registerNewObjective("cube", "dummy");
		}
		else {
			objective_cube = board_cube.getObjective("cube");
		}
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("%");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(role).getPlayer().setScoreboard(board_cube);
        
        if(main.getVersion() == 2 && (main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.JOKO_CUBE))) {
        	
        	Scoreboard board_hack = GameCycle.getScoreboardFarmeurimmo();
        	Objective objective_hack;
    		if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("cube") == null) {
    			objective_hack = board_hack.registerNewObjective("cube", "dummy");
    		}
    		else {
    			objective_hack = board_hack.getObjective("cube");
    		}
            objective_hack.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective_hack.setDisplayName("%");
            @SuppressWarnings("deprecation")
    		Score score_ = objective_hack.getScore(player);
            score_.setScore(cube);
            main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
        	
        }
        
	}
	
	public void addCube(Main main) {
		
		Scoreboard board_cube = GameCycle.getScoreboardJoko();
		Roles role = Roles.JOKO;
		
		if(main.getVersion() == 1) {
			
			board_cube = GameCycleV1.getScoreboardJoko();
			role = Roles.Joko;
			
		}
		
		this.cube += 1;
		Objective objective_cube;
		if(board_cube.getObjectives().isEmpty() || board_cube.getObjective("cube") == null) {
			objective_cube = board_cube.registerNewObjective("cube", "dummy");
		}
		else {
			objective_cube = board_cube.getObjective("cube");
		}
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("%");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(role).getPlayer().setScoreboard(board_cube);
        
        if(main.getVersion() == 2 && (main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.JOKO_CUBE))) {
        	
        	Scoreboard board_hack = GameCycle.getScoreboardFarmeurimmo();
        	Objective objective_hack;
    		if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("cube") == null) {
    			objective_hack = board_hack.registerNewObjective("cube", "dummy");
    		}
    		else {
    			objective_hack = board_hack.getObjective("cube");
    		}
            objective_hack.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective_hack.setDisplayName("%");
            @SuppressWarnings("deprecation")
    		Score score_ = objective_hack.getScore(player);
            score_.setScore(cube);
            main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
        	
        }
		
	}
	
	public void addCubes(int cube, Main main) {
		
		Scoreboard board_cube = GameCycle.getScoreboardJoko();
		Roles role = Roles.JOKO;
		
		if(main.getVersion() == 1) {
			
			board_cube = GameCycleV1.getScoreboardJoko();
			role = Roles.Joko;
			
		}
		
		this.cube += cube;
		Objective objective_cube;
		if(board_cube.getObjectives().isEmpty() || board_cube.getObjective("cube") == null) {
			objective_cube = board_cube.registerNewObjective("cube", "dummy");
		}
		else {
			objective_cube = board_cube.getObjective("cube");
		}
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("%");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(role).getPlayer().setScoreboard(board_cube);
        
        if(main.getVersion() == 2 && (main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.JOKO_CUBE))) {
        	
        	Scoreboard board_hack = GameCycle.getScoreboardFarmeurimmo();
        	Objective objective_hack;
    		if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("cube") == null) {
    			objective_hack = board_hack.registerNewObjective("cube", "dummy");
    		}
    		else {
    			objective_hack = board_hack.getObjective("cube");
    		}
            objective_hack.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective_hack.setDisplayName("%");
            @SuppressWarnings("deprecation")
    		Score score_ = objective_hack.getScore(player);
            score_.setScore(cube);
            main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
        	
        }
		
	}
	
	public void hide(Main main) {
		
		for(Joueur j : main.getListJoueurs()) {
			
			if(!j.isMort()) {
				
				j.getPlayer().hidePlayer(player);
			
			}
			
		}
		
	}
	
	public void show(Main main) {
		
		for(Joueur j : main.getListJoueurs()) {
			
			j.getPlayer().showPlayer(player);
			
		}
		
	}
	
	public void removeCube(Main main) {
		
		Scoreboard board_cube = GameCycle.getScoreboardJoko();
		Roles role = Roles.JOKO;
		
		if(main.getVersion() == 1) {
			
			board_cube = GameCycleV1.getScoreboardJoko();
			role = Roles.Joko;
			
		}
		
		this.cube -= 1;
		Objective objective_cube;
		if(board_cube.getObjectives().isEmpty() || board_cube.getObjective("cube") == null) {
			objective_cube = board_cube.registerNewObjective("cube", "dummy");
		}
		else {
			objective_cube = board_cube.getObjective("cube");
		}
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("%");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(role).getPlayer().setScoreboard(board_cube);
        
        if(main.getVersion() == 2 && (main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.JOKO_CUBE))) {
        	
        	Scoreboard board_hack = GameCycle.getScoreboardFarmeurimmo();
        	Objective objective_hack;
    		if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("cube") == null) {
    			objective_hack = board_hack.registerNewObjective("cube", "dummy");
    		}
    		else {
    			objective_hack = board_hack.getObjective("cube");
    		}
            objective_hack.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective_hack.setDisplayName("%");
            @SuppressWarnings("deprecation")
    		Score score_ = objective_hack.getScore(player);
            score_.setScore(cube);
            main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
        	
        }
		
	}
	
	public void removeCubes(int cube, Main main) {
		
		Scoreboard board_cube = GameCycle.getScoreboardJoko();
		
		Roles role = Roles.JOKO;
		
		if(main.getVersion() == 1) {
			
			board_cube = GameCycleV1.getScoreboardJoko();
			role = Roles.Joko;
			
		}
		
		this.cube -= cube;
		Objective objective_cube;
		if(board_cube.getObjectives().isEmpty() || board_cube.getObjective("cube") == null) {
			objective_cube = board_cube.registerNewObjective("cube", "dummy");
		}
		else {
			objective_cube = board_cube.getObjective("cube");
		}
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("%");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(role).getPlayer().setScoreboard(board_cube);
        
        if(main.getVersion() == 2 && (main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.JOKO_CUBE))) {
        	
        	Scoreboard board_hack = GameCycle.getScoreboardFarmeurimmo();
        	Objective objective_hack;
    		if(board_hack.getObjectives().isEmpty() || board_hack.getObjective("cube") == null) {
    			objective_hack = board_hack.registerNewObjective("cube", "dummy");
    		}
    		else {
    			objective_hack = board_hack.getObjective("cube");
    		}
            objective_hack.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective_hack.setDisplayName("%");
            @SuppressWarnings("deprecation")
    		Score score_ = objective_hack.getScore(player);
            score_.setScore(cube);
            main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_hack);
        	
        }
		
	}
	
    public void Stun(int timer, Main main) {

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, timer*20, 100, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, timer*20, 100, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, timer*20, 250, false, false));
        invulnerable = true;
        ItemCD cycle = new ItemCD(main, this, "stun", timer, this, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);

    }

	public boolean isOpKzou() {
		return opKzou;
	}

	public void setOpKzou(boolean opKzou) {
		this.opKzou = opKzou;
	}

	public int getNbOpKzou() {
		return nbOpKzou;
	}

	public void setNbOpKzou(int nbOpKzou) {
		this.nbOpKzou = nbOpKzou;
	}
	
	public void addNbOpKzou() {
		
		this.nbOpKzou += 1;
		
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}

	public boolean isRespawnTrial() {
		return respawnTrial;
	}

	public void setRespawnTrial(boolean respawnTrial) {
		this.respawnTrial = respawnTrial;
	}

	public boolean isChoixGbCamp() {
		return choixGbCamp;
	}

	public void setChoixGbCamp(boolean choixGbCamp) {
		this.choixGbCamp = choixGbCamp;
	}

	public boolean isCheckMalusEau() {
		return checkMalusEau;
	}

	public void setCheckMalusEau(boolean checkMalusEau) {
		this.checkMalusEau = checkMalusEau;
	}

	public boolean isConsoleGBActif() {
		return consoleGBActif;
	}

	public void setConsoleGBActif(boolean consoleGBActif) {
		this.consoleGBActif = consoleGBActif;
	}

	public Classe getClasseGB() {
		return classeGB;
	}

	public void setClasseGB(Classe classeGB) {
		this.classeGB = classeGB;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public boolean isFrappeNeko() {
		return frappeNeko;
	}

	public void setFrappeNeko(boolean frappeNeko) {
		this.frappeNeko = frappeNeko;
	}

	public boolean isSpeedProche() {
		return speedProche;
	}

	public void setSpeedProche(boolean speedProche) {
		this.speedProche = speedProche;
	}

	public boolean isResiProche() {
		return resiProche;
	}

	public void setResiProche(boolean resiProche) {
		this.resiProche = resiProche;
	}

	public int getSlime() {
		return slime;
	}

	public void setSlime(int slime) {
		this.slime = slime;
	}
	
	public void addSlime(int slime) {
		this.slime += slime;
	}
	
	public void removeSlime(int slime) {
		this.slime -= slime;
	}

	public boolean isMalusZoneSlup() {
		return malusZoneSlup;
	}

	public void setMalusZoneSlup(boolean malusZoneSlup) {
		this.malusZoneSlup = malusZoneSlup;
	}
	
	public boolean isInSlupZone(Main main) {
		if(player.getLocation().getX() < (main.getLocZoneSlup().getX() + 20) && player.getLocation().getX() > (main.getLocZoneSlup().getX() - 20) && player.getLocation().getY() < (main.getLocZoneSlup().getY() + 20) && player.getLocation().getY() > (main.getLocZoneSlup().getY() - 20) && player.getLocation().getZ() < (main.getLocZoneSlup().getZ() + 20) && player.getLocation().getZ() > (main.getLocZoneSlup().getZ() - 20)) {
			
			return true;
			
		}
		else {
			return false;
		}
	}

	public boolean isSlupBonusPalierActif() {
		return slupBonusPalierActif;
	}

	public void setSlupBonusPalierActif(boolean slupBonusPalierActif) {
		this.slupBonusPalierActif = slupBonusPalierActif;
	}

	public int getPalierSlup() {
		return palierSlup;
	}

	public void setPalierSlup(int palierSlup) {
		this.palierSlup = palierSlup;
	}

	public boolean isMalusSlupActif() {
		return malusSlupActif;
	}

	public void setMalusSlupActif(boolean malusSlupActif) {
		this.malusSlupActif = malusSlupActif;
	}
	
	public boolean hasNbSlime() {
		
		if(palierSlup < 4 && slime >= 1) {
			
			return true;
			
		}
		else if(palierSlup == 4 && slime >= 2) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}

	public int getTimerPalierSlup() {
		return timerPalierSlup;
	}

	public void setTimerPalierSlup(int timerPalierSlup) {
		this.timerPalierSlup = timerPalierSlup;
	}
	
	public void addTimerPalierSlup() {
		this.timerPalierSlup += 1;
	}

	public boolean isHack() {
		return hack;
	}

	public void setHack(boolean hack) {
		this.hack = hack;
	}

	public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

	public int getUtilisationSacrificeTrial() {
		return utilisationSacrificeTrial;
	}

	public void setUtilisationSacrificeTrial(int utilisationSacrificeTrial) {
		this.utilisationSacrificeTrial = utilisationSacrificeTrial;
	}
	
	public void addUtilisationSacrificeTrial() {
		this.utilisationSacrificeTrial += 1;
	}

	public boolean isInZoneBenihime() {
		return inZoneBenihime;
	}

	public void setInZoneBenihime(boolean inZoneBenihime) {
		this.inZoneBenihime = inZoneBenihime;
	}

	public boolean isCorrompu() {
		return corrompu;
	}

	public void setCorrompu(boolean corrompu) {
		this.corrompu = corrompu;
	}

	public boolean isCorrompuIndirect() {
		return corrompuIndirect;
	}

	public void setCorrompuIndirect(boolean corrompuIndirect) {
		this.corrompuIndirect = corrompuIndirect;
	}

	public boolean isInZoneSkinTrial() {
		return inZoneSkinTrial;
	}

	public void setInZoneSkinTrial(boolean inZoneSkinTrial) {
		this.inZoneSkinTrial = inZoneSkinTrial;
	}

	public boolean isTueurToinouKill() {
		return tueurToinouKill;
	}

	public void setTueurToinouKill(boolean tueurToinouKill) {
		this.tueurToinouKill = tueurToinouKill;
	}

	public boolean isOrbePassifActif() {
		return orbe_passif_actif;
	}

	public void setOrbePassifActif(boolean orbe_passif_actif) {
		this.orbe_passif_actif = orbe_passif_actif;
	}

	public boolean isInZoneJustice() {
		return inZoneJustice;
	}

	public void setInZoneJustice(boolean inZoneJustice) {
		this.inZoneJustice = inZoneJustice;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addPoint() {
		
		points += 1;
		
	}
	
	public void removePoints(int points) {
		
		this.points -= points;
		
	}

	public boolean isFirstItemToinou() {
		return firstItemToinou;
	}

	public void setFirstItemToinou(boolean firstItemToinou) {
		this.firstItemToinou = firstItemToinou;
	}

	public boolean isBonusToinouNuage() {
		return bonusToinouNuage;
	}

	public void setBonusToinouNuage(boolean bonusToinouNuage) {
		this.bonusToinouNuage = bonusToinouNuage;
	}

	public boolean isBonusToinouMaudit() {
		return bonusToinouMaudit;
	}

	public void setBonusToinouMaudit(boolean bonusToinouMaudit) {
		this.bonusToinouMaudit = bonusToinouMaudit;
	}

	public boolean isUseRubisBleu() {
		return useRubisBleu;
	}

	public void setUseRubisBleu(boolean useRubisBleu) {
		this.useRubisBleu = useRubisBleu;
	}

	public int getRepairCaptain() {
		return repairCaptain;
	}

	public void setRepairCaptain(int repairCaptain) {
		this.repairCaptain = repairCaptain;
	}

	public boolean isHekowJeuActif() {
		return hekowJeuActif;
	}

	public void setHekowJeuActif(boolean hekowJeuActif) {
		this.hekowJeuActif = hekowJeuActif;
	}

	public int getHekowPourcent() {
		return HekowPourcent;
	}
	
	public void addHekowPourcent(int nb) {
		
		if(HekowPourcent+nb < 100) {
		
			HekowPourcent += nb;
			
		}
		else {
			
			HekowPourcent = 100;
			
		}
		
	}

	public void setHekowPourcent(int hekowPourcent) {
		HekowPourcent = hekowPourcent;
	}

	public boolean isSuperBateauLoup() {
		return superBateauLoup;
	}

	public void setSuperBateauLoup(boolean superBateauLoup) {
		this.superBateauLoup = superBateauLoup;
	}

	public boolean isJeannotAbso() {
		return JeannotAbso;
	}

	public void setJeannotAbso(boolean jeannotAbso) {
		JeannotAbso = jeannotAbso;
	}

	public int getNBObscurCopie() {
		return NBObscurCopie;
	}

	public void setNBObscurCopie(int nBObscurCopie) {
		NBObscurCopie = nBObscurCopie;
	}

	public Orbe getCasqueObscur() {
		return casqueObscur;
	}

	public void setCasqueObscur(Orbe casqueObscur) {
		this.casqueObscur = casqueObscur;
	}

	public Orbe getPlastronObscur() {
		return plastronObscur;
	}

	public void setPlastronObscur(Orbe plastronObscur) {
		this.plastronObscur = plastronObscur;
	}

	public Orbe getJambiereObscur() {
		return jambiereObscur;
	}

	public void setJambiereObscur(Orbe jambiereObscur) {
		this.jambiereObscur = jambiereObscur;
	}

	public Orbe getBottesObscur() {
		return bottesObscur;
	}

	public void setBottesObscur(Orbe bottesObscur) {
		this.bottesObscur = bottesObscur;
	}

	public Orbe getEpeeObscur() {
		return epeeObscur;
	}

	public void setEpeeObscur(Orbe epeeObscur) {
		this.epeeObscur = epeeObscur;
	}

	public boolean isCasqueObscurActif() {
		return casqueObscurActif;
	}

	public void setCasqueObscurActif(boolean casqueObscurActif) {
		this.casqueObscurActif = casqueObscurActif;
	}

	public boolean isPlastronObscurActif() {
		return plastronObscurActif;
	}

	public void setPlastronObscurActif(boolean plastronObscurActif) {
		this.plastronObscurActif = plastronObscurActif;
	}

	public boolean isJambiereObscurActif() {
		return jambiereObscurActif;
	}

	public void setJambiereObscurActif(boolean jambiereObscurActif) {
		this.jambiereObscurActif = jambiereObscurActif;
	}

	public boolean isBottesObscurActif() {
		return bottesObscurActif;
	}

	public void setBottesObscurActif(boolean bottesObscurActif) {
		this.bottesObscurActif = bottesObscurActif;
	}

	public boolean isEpeeObscurActif() {
		return epeeObscurActif;
	}

	public void setEpeeObscurActif(boolean epeeObscurActif) {
		this.epeeObscurActif = epeeObscurActif;
	}
	
	public void setOrbePiece(Pieces piece, Orbe orbe) {
		
		if(piece == Pieces.CASQUE) {
			
			this.casqueObscur = orbe;
			
		}
		else if(piece == Pieces.PLASTRON) {
			
			this.plastronObscur = orbe;
			
		}
		else if(piece == Pieces.JAMBIERE) {
			
			this.jambiereObscur = orbe;
			
		}
		else if(piece == Pieces.BOTTES) {
			
			this.bottesObscur = orbe;
			
		}
		else if(piece == Pieces.EPEE) {
			
			this.epeeObscur = orbe;
			
		}
		
	}
	
	public Orbe getOrbePiece(Pieces piece) {
		
		if(piece == Pieces.CASQUE) {
			
			return casqueObscur;
			
		}
		else if(piece == Pieces.PLASTRON) {
			
			return plastronObscur;
			
		}
		else if(piece == Pieces.JAMBIERE) {
			
			return jambiereObscur;
			
		}
		else if(piece == Pieces.BOTTES) {
			
			return bottesObscur;
			
		}
		else {
			
			return epeeObscur;
			
		}
		
	}
	
	public boolean obscurHasOrbe(Orbe orbe) {
		
		if(casqueObscur == orbe || jambiereObscur == orbe || plastronObscur == orbe || bottesObscur == orbe || epeeObscur == orbe) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}

	public List<VolTrial> getVolTrial() {
		return volTrial;
	}

	public void setVolTrial(List<VolTrial> volTrial) {
		this.volTrial = volTrial;
	}

	public Pouvoirs_GB getPouvoirGB() {
		return pouvoirGB;
	}

	public void setPouvoirGB(Pouvoirs_GB pouvoirGB) {
		this.pouvoirGB = pouvoirGB;
	}

	public boolean isFlairGB() {
		return flairGB;
	}

	public void setFlairGB(boolean flairGB) {
		this.flairGB = flairGB;
	}

	public boolean isCanUseChoose() {
		return canUseChoose;
	}

	public void setCanUseChoose(boolean canUseChoose) {
		this.canUseChoose = canUseChoose;
	}

	public boolean isUseChoose() {
		return useChoose;
	}

	public void setUseChoose(boolean useChoose) {
		this.useChoose = useChoose;
	}

	public boolean isGBFindThisDemon() {
		return GBFindThisDemon;
	}

	public void setGBFindThisDemon(boolean gBFindThisDemon) {
		GBFindThisDemon = gBFindThisDemon;
	}

	public int getGBPourcent() {
		return GBPourcent;
	}

	public void setGBPourcent(int gBPourcent) {
		GBPourcent = gBPourcent;
	}

	public int getLVLGBRestant() {
		return LVLGBRestant;
	}

	public void setLVLGBRestant(int lVLGBRestant) {
		LVLGBRestant = lVLGBRestant;
	}

	public String getBonusPalier10GB() {
		return bonusPalier10GB;
	}

	public void setBonusPalier10GB(String bonusPalier10GB) {
		this.bonusPalier10GB = bonusPalier10GB;
	}

	public boolean isEffetProcheGB() {
		return effetProcheGB;
	}

	public void setEffetProcheGB(boolean effetProcheGB) {
		this.effetProcheGB = effetProcheGB;
	}

	public boolean isNerfFlairGB() {
		return nerfFlairGB;
	}

	public void setNerfFlairGB(boolean nerfFlairGB) {
		this.nerfFlairGB = nerfFlairGB;
	}

	public boolean isMakaRageActif() {
		return makaRageActif;
	}

	public void setMakaRageActif(boolean makaRageActif) {
		this.makaRageActif = makaRageActif;
	}

	public boolean isForceProche() {
		return forceProche;
	}

	public void setForceProche(boolean forceProche) {
		this.forceProche = forceProche;
	}

	public boolean isNofallPerma() {
		return nofallPerma;
	}

	public void setNofallPerma(boolean nofallPerma) {
		this.nofallPerma = nofallPerma;
	}

	public boolean isFindTueurNeko() {
		return findTueurNeko;
	}

	public void setFindTueurNeko(boolean findTueurNeko) {
		this.findTueurNeko = findTueurNeko;
	}

	public int getProcheSlup() {
		return procheSlup;
	}

	public void setProcheSlup(int procheSlup) {
		this.procheSlup = procheSlup;
	}
	
	public void addProcheSlup() {
		
		this.procheSlup ++;
		
	}

	public boolean isSpeedIIActif() {
		return speedIIActif;
	}

	public void setSpeedIIActif(boolean speedIIActif) {
		this.speedIIActif = speedIIActif;
	}

	public boolean isPouvoirRaptorActif() {
		return pouvoirRaptorActif;
	}

	public void setPouvoirRaptorActif(boolean pouvoirRaptorActif) {
		this.pouvoirRaptorActif = pouvoirRaptorActif;
	}

	public boolean isSaigne() {
		return saigne;
	}

	public void setSaigne(boolean saigne) {
		this.saigne = saigne;
	}

	public Location getTheoochouxLoc() {
		return theoochouxLoc;
	}

	public void setTheoochouxLoc(Location theoochouxLoc) {
		this.theoochouxLoc = theoochouxLoc;
	}

	public Location getTheoochouxLoc3sec() {
		return theoochouxLoc3sec;
	}

	public void setTheoochouxLoc3sec(Location theoochouxLoc3sec) {
		this.theoochouxLoc3sec = theoochouxLoc3sec;
	}

	public Inventory getTheoochouxInv() {
		return theoochouxInv;
	}

	public void setTheoochouxInv(Inventory theoochouxInv) {
		this.theoochouxInv = theoochouxInv;
	}

	public Double getTheoochouxHP() {
		return theoochouxHP;
	}

	public void setTheoochouxHP(Double theoochouxHP) {
		this.theoochouxHP = theoochouxHP;
	}

	public int getStadeTheoochouxBonus() {
		return stadeTheoochouxBonus;
	}

	public void setStadeTheoochouxBonus(int stadeTheoochouxBonus) {
		this.stadeTheoochouxBonus = stadeTheoochouxBonus;
	}
	
	public void addStadeTheoochouxBonus(int stadeTheoochouxBonus) {
		this.stadeTheoochouxBonus += stadeTheoochouxBonus;
	}

	public int getTheoochouxFood() {
		return theoochouxFood;
	}

	public void setTheoochouxFood(int theoochouxFood) {
		this.theoochouxFood = theoochouxFood;
	}

	public int getStadeTheochouxHack() {
		return stadeTheochouxHack;
	}

	public void setStadeTheochouxHack(int stadeTheochouxHack) {
		this.stadeTheochouxHack = stadeTheochouxHack;
	}
	
	public void addStadeTheochouxHack(int stadeTheochouxHack) {
		this.stadeTheochouxHack += stadeTheochouxHack;
	}

	public List<Pouvoirs> getCD() {
		return cd;
	}

	public void setCD(List<Pouvoirs> cd) {
		this.cd = cd;
	}

	public Scoreboard getBoard() {
		return board;
	}

	public void setBoard(Scoreboard board) {
		this.board = board;
	}

	public int getDeco_timer() {
		return deco_timer;
	}

	public void setDeco_timer(int deco_timer) {
		this.deco_timer = deco_timer;
	}

	public boolean isDeco() {
		return deco;
	}

	public void setDeco(boolean deco) {
		this.deco = deco;
	}
	
	public void removeDecoTimer() {
		deco_timer -= 1;
	}
	
}
