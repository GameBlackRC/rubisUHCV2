package fr.gameblack.rcuhcv2;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.gameblack.rcuhcv2.database.DatabaseManager;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.commands.global.admin.CommandEpisode;
import fr.gameblack.rcuhcv2.commands.global.admin.CommandSetOrbe;
import fr.gameblack.rcuhcv2.commands.global.admin.CommandSetRole;
import fr.gameblack.rcuhcv2.commands.global.admin.CommandSetRoleOther;
import fr.gameblack.rcuhcv2.commands.global.admin.CommandSetStatut;
import fr.gameblack.rcuhcv2.commands.global.game.CommandCompo;
import fr.gameblack.rcuhcv2.commands.global.game.CommandDoc;
import fr.gameblack.rcuhcv2.commands.global.game.CommandEffet;
import fr.gameblack.rcuhcv2.commands.global.game.CommandInfo;
import fr.gameblack.rcuhcv2.commands.global.game.CommandList;
import fr.gameblack.rcuhcv2.commands.global.game.CommandMe;
import fr.gameblack.rcuhcv2.commands.global.game.CommandOrbe;
import fr.gameblack.rcuhcv2.commands.global.game.CommandSeeall;
import fr.gameblack.rcuhcv2.commands.global.host.CommandAddAllRole;
import fr.gameblack.rcuhcv2.commands.global.host.CommandAddAllRolePVP;
import fr.gameblack.rcuhcv2.commands.global.host.CommandCreate;
import fr.gameblack.rcuhcv2.commands.global.host.CommandSetGroup;
import fr.gameblack.rcuhcv2.commands.global.host.CommandStart;
import fr.gameblack.rcuhcv2.commands.v1.demons.cosmos.CommandKill;
import fr.gameblack.rcuhcv2.commands.v1.demons.obscur.CommandCopie;
import fr.gameblack.rcuhcv2.commands.v1.demons.obscur.CommandSetpiece;
import fr.gameblack.rcuhcv2.commands.v1.demons.sang.CommandSang;
import fr.gameblack.rcuhcv2.commands.v1.demons.tenebre.CommandBlind;
import fr.gameblack.rcuhcv2.commands.v1.demons.tenebre.CommandNuit;
import fr.gameblack.rcuhcv2.commands.v1.demons.trial.CommandBroken;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandBack;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandChoose;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandDemon;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandFlair;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandInspect;
import fr.gameblack.rcuhcv2.commands.v1.rc.gameblack.CommandNerf;
import fr.gameblack.rcuhcv2.commands.v1.rc.maka.CommandDon;
import fr.gameblack.rcuhcv2.commands.v2.admin.CommandFermetureGolden;
import fr.gameblack.rcuhcv2.commands.v2.admin.CommandSpawnMinerais;
import fr.gameblack.rcuhcv2.commands.v2.joueur.jeannot.CommandAbso;
import fr.gameblack.rcuhcv2.commands.v2.joueur.jeannot.CommandPartage;
import fr.gameblack.rcuhcv2.commands.v2.joueur.joko.CommandCube;
import fr.gameblack.rcuhcv2.commands.v2.joueur.joko.CommandSteal;
import fr.gameblack.rcuhcv2.commands.v2.joueur.nickoboop.CommandPapier;
import fr.gameblack.rcuhcv2.commands.v2.joueur.slup.CommandMort;
import fr.gameblack.rcuhcv2.commands.v2.joueur.slup.CommandSlime;
import fr.gameblack.rcuhcv2.commands.v2.joueur.slup.CommandTrial;
import fr.gameblack.rcuhcv2.commands.v2.solo.farmeurimmo.CommandCamp;
import fr.gameblack.rcuhcv2.commands.v2.solo.farmeurimmo.CommandRCCode;
import fr.gameblack.rcuhcv2.commands.v2.solo.farmeurimmo.CommandVol;
import fr.gameblack.rcuhcv2.commands.v2.solo.kzou.CommandBan;
import fr.gameblack.rcuhcv2.commands.v2.solo.kzou.CommandDisperse;
import fr.gameblack.rcuhcv2.commands.v2.solo.kzou.CommandOp;
import fr.gameblack.rcuhcv2.commands.v2.staff.captain.CommandEnchant;
import fr.gameblack.rcuhcv2.commands.v2.staff.captain.CommandRepair;
import fr.gameblack.rcuhcv2.commands.v2.staff.gameblack.CommandBuff;
import fr.gameblack.rcuhcv2.commands.v2.staff.gameblack.CommandChangeOrbe;
import fr.gameblack.rcuhcv2.commands.v2.staff.gameblack.CommandCheckOrbe;
import fr.gameblack.rcuhcv2.commands.v2.staff.gameblack.CommandClasse;
import fr.gameblack.rcuhcv2.commands.v2.staff.gameblack.CommandConsole;
import fr.gameblack.rcuhcv2.commands.v2.staff.loup.CommandBateau;
import fr.gameblack.rcuhcv2.commands.v2.staff.loup.CommandServeur;
import fr.gameblack.rcuhcv2.commands.v2.staff.maka.CommandForme;
import fr.gameblack.rcuhcv2.commands.v2.staff.trial.CommandFirstReflexGame;
import fr.gameblack.rcuhcv2.commands.v2.staff.trial.CommandPlay;
import fr.gameblack.rcuhcv2.commands.v2.staff.trial.CommandSacrifice;
import fr.gameblack.rcuhcv2.commands.v2.uhc.nonoboy.CommandMaudit;
import fr.gameblack.rcuhcv2.commands.v2.uhc.toinou.CommandShop;
import fr.gameblack.rcuhcv2.commands.v2.uhc.toinou.CommandVacance;
import fr.gameblack.rcuhcv2.commands.v2.staff.trial.CommandMode;
import fr.gameblack.rcuhcv2.listener.global.DamageListener;
import fr.gameblack.rcuhcv2.listener.global.InteractListener;
import fr.gameblack.rcuhcv2.listener.global.InventoryInteractListener;
import fr.gameblack.rcuhcv2.listener.v2.BoatActionListener;
import fr.gameblack.rcuhcv2.listener.v2.PlayerActionListener;
import fr.gameblack.rcuhcv2.orbes.Orbe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main extends JavaPlugin {

	private List<Joueur> hosts = new ArrayList<>();
	private Statut state;
	private boolean debug = false;
	private int temps = 0;
    private int episode = 1;
    private int temps_episode = 600;
    private boolean jour = false;
    private String mode = "normal";
    private List<Joueur> joueurs = new ArrayList<>();
    private List<Pouvoirs> cd = new ArrayList<>();
    private List<Roles> compo = new ArrayList<>();
    private String jeuTrial = null;
    private List<Joueur> joueurJeuTrial = new ArrayList<>();
    private boolean fermetureGolden = false;
    private boolean fermetureGoldenActif = false;
    private List<Joueur> joko_stun = new ArrayList<>();
    private World world = Bukkit.getWorld("world");
    private Joueur malediction_gyomei = null;
    private Joueur neko = null;
    private int nbJoueursStaff = 0;
    private Joueur tueurNeko = null;
    private List<Joueur> maudit = new ArrayList<>();
    private int niv_maledition = 0;
    private Location locZoneSlup = null;
    private Joueur advBedwars = null;
    private String modeTrial = null;
    private boolean zoneBenihimeActif = false;
    private List<Pouvoirs> adaptionObscur = new ArrayList<>();
    private List<Pouvoirs> adaptionPermaObscur = new ArrayList<>();
    private boolean adaptionObscurActif = false;
    private List<Pouvoirs> adaptionAvantObscur = new ArrayList<>();
    private Joueur tueurToinou = null;
    private boolean zoneJusticeActif = false;
    private List<Joueur> accesBateauLoup = new ArrayList<>();
    private List<Joueur> specNicko = new ArrayList<>();
    private List<Joueur> giveBoostNicko = new ArrayList<>();
    private Joueur passagerSuperBateau = null;
    private List<Scenarios> scenarios = new ArrayList<>();
    private int version = 0;
    private boolean trialReflexActif = false;
    private Location theoochouxLoc = null;
    private Inventory theoochouxInv = null;
    private Double theoochouxHP = 20.0;
    private int theoochouxFood = 20;
    private int stadeTheoochouxBonus = 0;
    private int stadeTheochouxHack = 0;
    
    private Orbe orbeCopieObscur = Orbe.NONE;
    private Joueur joueurMalusGlaceObscur = null;
    private int pourcentMalusGlaceObscur = 0;
    private int stackFerObscur = 0;
    private boolean nuitTenebre = false;
    private Joueur gbKill = null;
    private Roles connaissanceTeam = null;
    private double forceIBaseV1 = 0.10;
    private double resiIBaseV1 = 0.15;
    private Joueur killCosmos = null;
    
    private DatabaseManager databaseManager;
    
    @Override
    public void onEnable() {
    	
    	databaseManager = new DatabaseManager();
    	
    	ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
    	
    	ShapedRecipe expBottle = new ShapedRecipe(orbes);
    	
    	expBottle.shape("LBW","%*%","RBI");
    	expBottle.setIngredient('L', Material.LAVA_BUCKET);
    	expBottle.setIngredient('I', Material.ICE);
    	expBottle.setIngredient('R', Material.REDSTONE_BLOCK);
    	expBottle.setIngredient('%', Material.IRON_BLOCK);
    	expBottle.setIngredient('*', Material.DIAMOND);
    	expBottle.setIngredient('B', Material.OBSIDIAN);
    	expBottle.setIngredient('W', Material.WATER_BUCKET);
    	getServer().addRecipe(expBottle);
    	
    	ShapedRecipe expBottle2 = new ShapedRecipe(orbes);
    	
    	expBottle2.shape("WBL","%*%","RBI");
    	expBottle2.setIngredient('L', Material.LAVA_BUCKET);
    	expBottle2.setIngredient('I', Material.ICE);
    	expBottle2.setIngredient('R', Material.REDSTONE_BLOCK);
    	expBottle2.setIngredient('%', Material.IRON_BLOCK);
    	expBottle2.setIngredient('*', Material.DIAMOND);
    	expBottle2.setIngredient('B', Material.OBSIDIAN);
    	expBottle2.setIngredient('W', Material.WATER_BUCKET);
    	getServer().addRecipe(expBottle2);
    	
    	getCommand("skipepisode").setExecutor(new CommandEpisode(this));
    	getCommand("setrole").setExecutor(new CommandSetRole(this));
    	getCommand("setroleother").setExecutor(new CommandSetRoleOther(this));
    	getCommand("setorbe").setExecutor(new CommandSetOrbe(this));
    	getCommand("setstatut").setExecutor(new CommandSetStatut(this));
    	getCommand("spawnminerais").setExecutor(new CommandSpawnMinerais(this));
    	getCommand("fermeturegolden").setExecutor(new CommandFermetureGolden(this));
    	getCommand("seeall").setExecutor(new CommandSeeall(this));
    	getCommand("setgroup").setExecutor(new CommandSetGroup(this));
    	
    	getCommand("compo").setExecutor(new CommandCompo(this));
    	getCommand("rceffet").setExecutor(new CommandEffet(this));
    	getCommand("rcorbe").setExecutor(new CommandOrbe(this));
    	getCommand("rcinfo").setExecutor(new CommandInfo(this));
    	getCommand("rcme").setExecutor(new CommandMe(this));
    	getCommand("rclist").setExecutor(new CommandList(this));
    	
    	getCommand("addallrole").setExecutor(new CommandAddAllRole(this));
    	getCommand("addallrolepvp").setExecutor(new CommandAddAllRolePVP(this));
    	getCommand("create").setExecutor(new CommandCreate(this));
    	getCommand("start").setExecutor(new CommandStart(this));
    	getCommand("doc").setExecutor(new CommandDoc(this));
    	
    	getCommand("rcpartage").setExecutor(new CommandPartage(this));
    	getCommand("rcabso").setExecutor(new CommandAbso(this));
    	getCommand("rcpapier").setExecutor(new CommandPapier(this));
    	getCommand("rctrial").setExecutor(new CommandTrial(this));
    	getCommand("rcmort").setExecutor(new CommandMort(this));
    	getCommand("rcslime").setExecutor(new CommandSlime(this));
    	getCommand("rccube").setExecutor(new CommandCube(this));
    	getCommand("rcsteal").setExecutor(new CommandSteal(this));
    	
    	getCommand("rcplay").setExecutor(new CommandPlay(this));
    	getCommand("rccorruption").setExecutor(new CommandForme(this));
    	getCommand("rcclasse").setExecutor(new CommandClasse(this));
    	getCommand("rcbuff").setExecutor(new CommandBuff(this));
    	getCommand("firstreflexgame").setExecutor(new CommandFirstReflexGame(this));
    	getCommand("rcmode").setExecutor(new CommandMode(this));
    	getCommand("rcsacrifice").setExecutor(new CommandSacrifice(this));
    	getCommand("rcserveur").setExecutor(new CommandServeur(this));
    	getCommand("rcbateau").setExecutor(new CommandBateau(this));
    	getCommand("rcchangeorbe").setExecutor(new CommandChangeOrbe(this));
    	getCommand("rccheckorbe").setExecutor(new CommandCheckOrbe(this));
    	getCommand("rcconsole").setExecutor(new CommandConsole(this));
    	getCommand("rcforme").setExecutor(new CommandForme(this));
    	getCommand("rcrepair").setExecutor(new CommandRepair(this));
    	getCommand("rcenchant").setExecutor(new CommandEnchant(this));
    	
    	getCommand("rcshop").setExecutor(new CommandShop(this));
    	getCommand("rcvacance").setExecutor(new CommandVacance(this));
    	getCommand("rcmaudit").setExecutor(new CommandMaudit(this));
    	
    	getCommand("rchack").setExecutor(new CommandRCCode(this));
    	getCommand("rcvol").setExecutor(new CommandVol(this));
    	getCommand("rccamp").setExecutor(new CommandCamp(this));
    	getCommand("rcban").setExecutor(new CommandBan(this));
    	getCommand("rcdisperse").setExecutor(new CommandDisperse(this));
    	getCommand("rcop").setExecutor(new CommandOp(this));
    	
    	//V1
    	getCommand("rcback").setExecutor(new CommandBack(this));
    	getCommand("rcchoose").setExecutor(new CommandChoose(this));
    	getCommand("rcflair").setExecutor(new CommandFlair(this));
    	getCommand("rcinspect").setExecutor(new CommandInspect(this));
    	getCommand("rcnerf").setExecutor(new CommandNerf(this));
    	getCommand("rcdemon").setExecutor(new CommandDemon(this));
    	getCommand("rcdon").setExecutor(new CommandDon(this));
    	
    	getCommand("rcbroken").setExecutor(new CommandBroken(this));
    	getCommand("rccopie").setExecutor(new CommandCopie(this));
    	getCommand("rcsetpiece").setExecutor(new CommandSetpiece(this));
    	getCommand("rckill").setExecutor(new CommandKill(this));
    	getCommand("rcsang").setExecutor(new CommandSang(this));
    	getCommand("rcblind").setExecutor(new CommandBlind(this));
    	getCommand("rcnuit").setExecutor(new CommandNuit(this));
    	
    	getServer().getPluginManager().registerEvents(new PlayerActionListener(this), this);
    	getServer().getPluginManager().registerEvents(new BoatActionListener(this), this);
    	getServer().getPluginManager().registerEvents(new DamageListener(this), this);
    	getServer().getPluginManager().registerEvents(new InteractListener(this), this);
    	getServer().getPluginManager().registerEvents(new InventoryInteractListener(this), this);
    	
    	System.out.println("Le plugin viens de s'allumer");
    	setState(Statut.WAITING);
    	
    	if(Bukkit.getWorld("uhc") != null) {
    		
    		world = Bukkit.getWorld("uhc");
    		
    	}
    	
    	for(Player player : Bukkit.getOnlinePlayers()) {
    		
    		addJoueur(player);
    		
    		
    	}
    	
    }
    
    public void onDisable() {

    	for(Joueur host : hosts) {
    		
    		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + host.getPlayer().getName() + " parent remove host");
    		
    	}

    }
    
	public DatabaseManager getDatabaseManager() {
		
		return databaseManager;
		
	}
    
    public String getTimerInTexte(int timer) {
    	
    	timer = timer/10;
    	
    	String texte = "";
    	
    	int minutes = timer - (timer%60);
    	minutes = minutes/60;
    	
    	int heures = minutes - (minutes%60);
    	heures = heures/60;
    	
    	int secondes = timer - (minutes*60 + (heures*60*60));
    	
    	if(heures != 0) {
    		
    		texte += heures + "h ";
    		
    	}
    	
    	if(minutes != 0 || heures != 0) {
    		
    		texte += minutes + "m ";
    		
    	}
    	
    	texte += secondes + "s";
    	
    	return texte;
    	
    }
    
    public void eliminate(Joueur joueur, boolean Kzou) {

        Roles role = Roles.NONE;
        
        Roles role_base = joueur.getRole();

        if (Kzou) {

        	Random r = new Random();
        	List<Joueur> j_list = getJoueurInGame();
        	j_list.remove(joueur);
        	int nb = r.nextInt(j_list.size());
        	role = j_list.get(nb).getRole();

        } else {

            role = joueur.getRole();

        }
        joueur.setOrbe(Orbe.NONE);
        if(joueur.isInZoneJustice() && getJoueurByRole(Roles.TEAM) != null) {
        	
        	getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("_________________________\n" + joueur.getPlayer().getName() + " est mort. Il était : \n" + joueur.getCouleurCamp(this) + role.getTxt() + "§r\n_________________________\nCe joueur étant mort dans votre zone, seul vous voyez le message de mort");
        	
        }
        else {
        	
        	Bukkit.broadcastMessage("_________________________\n" + joueur.getPlayer().getName() + " est mort. Il était : \n" + joueur.getCouleurCamp(this) + role.getTxt() + "§r\n_________________________");
        	
    	}
        
        if(Kzou) {
        	
        	getJoueurByRole(Roles.KZOU).getPlayer().sendMessage("Son vrai rôle est : " + role_base);
        	
        }
        
        joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
        joueur.setMort(true);
        joueur.setSpec(true);
        
        joueur.hide(this);
        checkWin();

        //MortCD cycle = new MortCD(this, player);
        //cycle.runTaskTimer(this, 0, 20);
    }
    
    public List<Joueur> getCampRCVie() {
    	
    	List<Joueur> joueurs = new ArrayList<>();
    	
    	for(Joueur j : getListJoueurs()) {
    		
    		if(j.getCamp().equalsIgnoreCase("rc") && !j.isMort()) {
    			
    			joueurs.add(j);
    			
    		}
    		
    	}
    	
    	return joueurs;
    	
    }
    
    public List<Joueur> getCampDemonVie() {
    	
    	List<Joueur> joueurs = new ArrayList<>();
    	
    	for(Joueur j : getListJoueurs()) {
    		
    		if(j.getCamp().equalsIgnoreCase("demon") && !j.isMort()) {
    			
    			joueurs.add(j);
    			
    		}
    		
    	}
    	
    	return joueurs;
    	
    }
    
    public List<Joueur> getSoloVie() {
    	
    	List<Joueur> joueurs = new ArrayList<>();
    	
    	for(Joueur j : getListJoueurs()) {
    		
    		if(j.getCamp().equalsIgnoreCase("solo") && !j.isMort()) {
    			
    			joueurs.add(j);
    			
    		}
    		
    	}
    	
    	return joueurs;
    	
    }
    
    public List<Joueur> getCampJoueur() {
    	
    	List<Joueur> camp_joueur = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "joueur" && !joueur.isMort()) {
    			
    			camp_joueur.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_joueur;
    	
    }
    
    public List<Joueur> getCampStaff() {
    	
    	List<Joueur> camp_staff = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "staff" && !joueur.isMort()) {
    			
    			camp_staff.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_staff;
    	
    }
    
    public List<Joueur> getCampUHC() {
    	
    	List<Joueur> camp_uhc = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "uhc" && !joueur.isMort()) {
    			
    			camp_uhc.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_uhc;
    	
    }
    
    public List<Joueur> getSolos() {
    	
    	List<Joueur> camp_solo = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "solo" && !joueur.isMort()) {
    			
    			camp_solo.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_solo;
    	
    }
    
    public List<Joueur> getDuo() {
    	
    	List<Joueur> camp_duo = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "duo" && !joueur.isMort()) {
    			
    			camp_duo.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_duo;
    	
    }
    
    public List<Joueur> getCampFarmeurimmo() {
    	
    	List<Joueur> camp_farmeurimmo = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp() == "farmeurimmo" && !joueur.isMort()) {
    			
    			camp_farmeurimmo.add(joueur);
    			
    		}
    		
    	}
    	
    	return camp_farmeurimmo;
    	
    }
    
    public void checkWin() {
    	
    	if(!getMode().equalsIgnoreCase("rapide") || getJoueurInGame().size() <= 1) {

	        if (getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {
	
	            Bukkit.broadcastMessage("Le camps Joueur remporte la partie !");
	            
	            state = Statut.FINISH;
	
	        } else if (getCampJoueur().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {
	
	            Bukkit.broadcastMessage("Le camps Staff remporte la partie !");
	            
	            state = Statut.FINISH;
	
	        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {
	
	            Bukkit.broadcastMessage("Le camps UHC remporte la partie !");
	            
	            state = Statut.FINISH;
	
	        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getSolos().isEmpty()) {
	
	            Bukkit.broadcastMessage("Le duo Slup - Trial remporte la partie !");
	            
	            state = Statut.FINISH;
	
	        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {
	
	            Bukkit.broadcastMessage("Farmeurimmo remporte la partie !");
	            
	            state = Statut.FINISH;
	
	        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().size() == 1) {
	
	            if (getSolos().get(0).getRole() == Roles.TRIAL) {
	
	                Bukkit.broadcastMessage("Trial remporte la partie !");
	                
	                state = Statut.FINISH;
	
	            } else if (getSolos().get(0).getRole() == Roles.KZOU) {
	
	                Bukkit.broadcastMessage("Kzou remporte la partie !");
	                
	                state = Statut.FINISH;
	
	            }
	
	        }
	        
    	}

    }
    
    public void reloadGame() {
    	
    	for(Joueur joueur : joueurs) {
    		
    		joueur.reset(this);
    		
    	}
    	
    	state = Statut.WAITING;
    	debug = false;
    	temps = 0;
        episode = 1;
        temps_episode = 600;
        jour = false;
        cd = new ArrayList<>();
        jeuTrial = null;
        joueurJeuTrial = new ArrayList<>();
        fermetureGolden = false;
        fermetureGoldenActif = false;
        joko_stun = new ArrayList<>();
        world = null;
        malediction_gyomei = null;
        neko = null;
        nbJoueursStaff = 0;
        tueurNeko = null;
        maudit.clear();
        niv_maledition = 0;
        locZoneSlup = null;
        advBedwars = null;
        modeTrial = null;
        zoneBenihimeActif = false;
        adaptionObscur = new ArrayList<>();
        adaptionPermaObscur = new ArrayList<>();
        adaptionObscurActif = false;
        adaptionAvantObscur = new ArrayList<>();
        tueurToinou = null;
        zoneJusticeActif = false;
        accesBateauLoup.clear();
        specNicko.clear();
        giveBoostNicko.clear();
        passagerSuperBateau = null;
        trialReflexActif = false;
        theoochouxLoc = null;
        theoochouxInv = null;
        theoochouxHP = 20.0;
        theoochouxFood = 20;
        stadeTheoochouxBonus = 0;
        stadeTheochouxHack = 0;
        
        orbeCopieObscur = Orbe.NONE;
        joueurMalusGlaceObscur = null;
        pourcentMalusGlaceObscur = 0;
        stackFerObscur = 0;
        nuitTenebre = false;
        gbKill = null;
        connaissanceTeam = null;
        killCosmos = null;
    	
    }
    
    public List<Roles> getCompo() {
    	
    	return compo;
    	
    }
    
    public void setCompo(List<Roles> compo) {
    	
    	this.compo = compo;
    	
    }
    
    public List<Joueur> getJoueurInGame() {
    	
    	List<Joueur> joueurs_in_game = new ArrayList<>();
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getRole() != Roles.NONE && !joueur.isMort()) {
    			
    			joueurs_in_game.add(joueur);
    			
    		}
    		
    	}
    	
    	return joueurs_in_game;
    	
    }
    
    public Joueur getJoueurByRole(Roles role) {
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getRole() == role && !joueur.isMort()) {
    			
    			return joueur;
    			
    		}
    		
    	}
    	
    	return null;
    	
    }
    
    public List<Joueur> getJoueurInCamp(String camp) {
    	
    	List<Joueur> joueurs_camps = new ArrayList<>();
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getCamp().equalsIgnoreCase(camp)) {
    			
    			joueurs_camps.add(joueur);
    			
    		}
    		
    	}
    	
    	return joueurs_camps;
    	
    }
    
    public List<Pouvoirs> getCD() {

        return cd;

    }
    
    public int getTempsEpisode() {

        return temps_episode;

    }

    public int getTemps() {

        return temps;

    }

    public void addTemps() {

        temps++;

    }

    public void addEpisode() {

        temps = 0;
        episode += 1;

    }

    public int getEpisode() {

        return episode;

    }

    public void setTemps() {

        temps = temps_episode - 1;

    }

    public void setJour(boolean value) {

        jour = value;

    }
    
    public boolean isDay() {

        return jour;

    }
    
    public static ItemStack getItem(Material material, String customName, String desc) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        itM.setLore(Arrays.asList(desc.split(";")));
        itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itM);
        return it;
    }
    
    public boolean isState(Statut state) {
        return this.state == state;
    }

    public Statut getState() {
        return this.state;
    }

    public void setState(Statut state) {
        this.state = state;
    }
    
    public String getMode() {
    	
    	return mode;
    	
    }
    
    public void setMode(String mode) {
    	
    	this.mode = mode;
    	
    }
    
    public Joueur getJoueur(Player player) {
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(player == joueur.getPlayer()) {
    			
    			return joueur;
    			
    		}
    		
    	}
    	
    	return null;
    	
    }
    
    public Joueur getJoueurByPseudo(String pseudo) {
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getPlayer().getName().equalsIgnoreCase(pseudo)) {
    			
    			return joueur;
    			
    		}
    		
    	}
    	
    	return null;
    	
    }

	public Joueur getHostBase() {
		
		if(hosts.isEmpty()) {
			
			return null;
			
		}
		else {
		
			return hosts.get(0);
			
		}
	}

	public void setHostBase(Joueur host) {
		
		if(hosts.isEmpty()) {
			
			hosts.add(host);
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + host.getPlayer().getName() + " parent add host");
			
		}
		else if(hosts.contains(host)) {
			
			if(hosts.get(0) != host) {
				
				Joueur host2 = hosts.get(0);
				hosts.remove(host);
				hosts.set(0, host);
				hosts.add(host2);
				
			}
			
		}
		else {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + host.getPlayer().getName() + " parent add host");
			
			Joueur host2 = hosts.get(0);
			hosts.set(0, host);
			hosts.add(host2);
			
		}
	}
	
	public void addHost(Joueur joueur) {
		
		if(!hosts.contains(joueur)) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + joueur.getPlayer().getName() + " parent add host");
			
			hosts.add(joueur);
			
		}
		
	}
	
	public void removeHost(Joueur joueur) {
		
		if(hosts.contains(joueur)) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + joueur.getPlayer().getName() + " parent remove host");
			
			hosts.remove(joueur);
			
		}
		
	}
	
	public List<Joueur> getListHost() {
		
		return hosts;
		
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	public List<Joueur> getListJoueurs() {
		
		return joueurs;
		
	}
	
	public void addJoueur(Player player) {
		
		Joueur joueur = new Joueur(player);
		joueur.show(this);
		joueurs.add(joueur);
		
		
	}
	
	public void removeJoueur(Joueur joueur) {
		
		joueurs.remove(joueur);
		
	}

	public String getJeuTrial() {
		return jeuTrial;
	}

	public void setJeuTrial(String jeuTrial) {
		this.jeuTrial = jeuTrial;
	}

	public List<Joueur> getJoueurJeuTrial() {
		return joueurJeuTrial;
	}

	public boolean isFermetureGolden() {
		return fermetureGolden;
	}

	public void setFermetureGolden(boolean fermetureGolden) {
		this.fermetureGolden = fermetureGolden;
	}

	public boolean isFermetureGoldenActif() {
		return fermetureGoldenActif;
	}

	public void setFermetureGoldenActif(boolean fermetureGoldenActif) {
		this.fermetureGoldenActif = fermetureGoldenActif;
	}

	public List<Joueur> getJokoStun() {
		return joko_stun;
	}

	public void setJokoStun(List<Joueur> joko_stun) {
		this.joko_stun = joko_stun;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Joueur getMaledictionGyomei() {
		return malediction_gyomei;
	}

	public void setMaledictionGyomei(Joueur malediction_gyomei) {
		this.malediction_gyomei = malediction_gyomei;
	}

	public Joueur getNeko() {
		return neko;
	}

	public void setNeko(Joueur neko) {
		this.neko = neko;
	}

	public int getNbJoueursStaff() {
		return nbJoueursStaff;
	}

	public void setNbJoueursStaff(int nbJoueursStaff) {
		this.nbJoueursStaff = nbJoueursStaff;
	}

	public Joueur getTueurNeko() {
		return tueurNeko;
	}

	public void setTueurNeko(Joueur tueurNeko) {
		this.tueurNeko = tueurNeko;
	}

	public List<Joueur> getMaudit() {
		return maudit;
	}

	public void setMaudit(List<Joueur> maudit) {
		this.maudit = maudit;
	}

	public int getNiv_maledition() {
		return niv_maledition;
	}

	public void setNiv_maledition(int niv_maledition) {
		this.niv_maledition = niv_maledition;
	}

	public Location getLocZoneSlup() {
		return locZoneSlup;
	}

	public void setLocZoneSlup(Location locZoneSlup) {
		this.locZoneSlup = locZoneSlup;
	}

	public Joueur getAdvBedwars() {
		return advBedwars;
	}

	public void setAdvBedwars(Joueur advBedwars) {
		this.advBedwars = advBedwars;
	}

	public String getModeTrial() {
		return modeTrial;
	}

	public void setModeTrial(String modeTrial) {
		this.modeTrial = modeTrial;
	}

	public boolean isZoneBenihimeActif() {
		return zoneBenihimeActif;
	}

	public void setZoneBenihimeActif(boolean zoneBenihimeActif) {
		this.zoneBenihimeActif = zoneBenihimeActif;
	}

	public List<Pouvoirs> getAdaptionObscur() {
		return adaptionObscur;
	}

	public void setAdaptionObscur(List<Pouvoirs> adaptionObscur) {
		this.adaptionObscur = adaptionObscur;
	}

	public List<Pouvoirs> getAdaptionPermaObscur() {
		return adaptionPermaObscur;
	}

	public void setAdaptionPermaObscur(List<Pouvoirs> adaptionPermaObscur) {
		this.adaptionPermaObscur = adaptionPermaObscur;
	}

	public boolean isAdaptionObscurActif() {
		return adaptionObscurActif;
	}

	public void setAdaptionObscurActif(boolean adaptionObscurActif) {
		this.adaptionObscurActif = adaptionObscurActif;
	}

	public List<Pouvoirs> getAdaptionAvantObscur() {
		return adaptionAvantObscur;
	}

	public void setAdaptionAvantObscur(List<Pouvoirs> adaptionAvantObscur) {
		this.adaptionAvantObscur = adaptionAvantObscur;
	}

	public Joueur getTueurToinou() {
		return tueurToinou;
	}

	public void setTueurToinou(Joueur tueurToinou) {
		this.tueurToinou = tueurToinou;
	}

	public boolean isZoneJusticeActif() {
		return zoneJusticeActif;
	}

	public void setZoneJusticeActif(boolean zoneJusticeActif) {
		this.zoneJusticeActif = zoneJusticeActif;
	}

	public List<Joueur> getAccesBateauLoup() {
		return accesBateauLoup;
	}

	public void setAccesBateauLoup(List<Joueur> accesBateauLoup) {
		this.accesBateauLoup = accesBateauLoup;
	}

	public List<Joueur> getSpecNicko() {
		return specNicko;
	}

	public void setSpecNicko(List<Joueur> specNicko) {
		this.specNicko = specNicko;
	}

	public List<Joueur> getGiveBoostNicko() {
		return giveBoostNicko;
	}

	public void setGiveBoostNicko(List<Joueur> giveBoostNicko) {
		this.giveBoostNicko = giveBoostNicko;
	}

	public Joueur getPassagerSuperBateau() {
		return passagerSuperBateau;
	}

	public void setPassagerSuperBateau(Joueur passagerSuperBateau) {
		this.passagerSuperBateau = passagerSuperBateau;
	}

	public List<Scenarios> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenarios> scenarios) {
		this.scenarios = scenarios;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Orbe getOrbeCopieObscur() {
		return orbeCopieObscur;
	}

	public void setOrbeCopieObscur(Orbe orbeCopieObscur) {
		this.orbeCopieObscur = orbeCopieObscur;
	}

	public Joueur getJoueurMalusGlaceObscur() {
		return joueurMalusGlaceObscur;
	}

	public void setJoueurMalusGlaceObscur(Joueur joueurMalusGlaceObscur) {
		this.joueurMalusGlaceObscur = joueurMalusGlaceObscur;
	}

	public int getPourcentMalusGlaceObscur() {
		return pourcentMalusGlaceObscur;
	}

	public void setPourcentMalusGlaceObscur(int pourcentMalusGlaceObscur) {
		this.pourcentMalusGlaceObscur = pourcentMalusGlaceObscur;
	}
	
	public void resetPlayerPourcentGlace() {
		
		if(joueurMalusGlaceObscur != null && pourcentMalusGlaceObscur > 0) { 
		
			joueurMalusGlaceObscur.addSpeed(pourcentMalusGlaceObscur/100);
			
			if(getJoueurByRole(Roles.Obscur) != null) {
				
				getJoueurByRole(Roles.Obscur).addForce(pourcentMalusGlaceObscur/100);
				
			}
			
		}
		
	}

	public int getStackFerObscur() {
		return stackFerObscur;
	}

	public void setStackFerObscur(int stackFerObscur) {
		this.stackFerObscur = stackFerObscur;
	}

	public boolean isNuitTenebre() {
		return nuitTenebre;
	}

	public void setNuitTenebre(boolean nuitTenebre) {
		this.nuitTenebre = nuitTenebre;
	}
	
    public Joueur getFlairGB() {
    	
    	for(Joueur j : this.getListJoueurs()) {
    		
    		if(j.isFlairGB()) {
    			
    			return j;
    			
    		}
    		
    	}
    	
    	return null;
    	
    }

	public Joueur getGbKill() {
		return gbKill;
	}

	public void setGbKill(Joueur gbKill) {
		this.gbKill = gbKill;
	}

	public Roles getConnaissanceTeam() {
		return connaissanceTeam;
	}

	public void setConnaissanceTeam(Roles connaissanceTeam) {
		this.connaissanceTeam = connaissanceTeam;
	}

	public double getForceIBaseV1() {
		return forceIBaseV1;
	}

	public void setForceIBaseV1(double forceIBaseV1) {
		this.forceIBaseV1 = forceIBaseV1;
	}

	public double getResiIBaseV1() {
		return resiIBaseV1;
	}

	public void setResiIBaseV1(double resiIBaseV1) {
		this.resiIBaseV1 = resiIBaseV1;
	}

	public boolean isTrialReflexActif() {
		return trialReflexActif;
	}

	public void setTrialReflexActif(boolean trialReflexActif) {
		this.trialReflexActif = trialReflexActif;
	}

	public Location getTheoochouxLoc() {
		return theoochouxLoc;
	}

	public void setTheoochouxLoc(Location theoochouxLoc) {
		this.theoochouxLoc = theoochouxLoc;
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

	public int getTheoochouxFood() {
		return theoochouxFood;
	}

	public void setTheoochouxFood(int theoochouxFood) {
		this.theoochouxFood = theoochouxFood;
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

	public int getStadeTheochouxHack() {
		return stadeTheochouxHack;
	}

	public void setStadeTheochouxHack(int stadeTheochouxHack) {
		this.stadeTheochouxHack = stadeTheochouxHack;
	}
	
	public void addStadeTheochouxHack(int stadeTheochouxHack) {
		this.stadeTheochouxHack += stadeTheochouxHack;
	}

	public Joueur getKillCosmos() {
		return killCosmos;
	}

	public void setKillCosmos(Joueur killCosmos) {
		this.killCosmos = killCosmos;
	}
	
}
