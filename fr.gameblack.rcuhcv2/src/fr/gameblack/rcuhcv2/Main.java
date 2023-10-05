package fr.gameblack.rcuhcv2;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.gameblack.rcuhcv2.commands.admin.CommandCheckWorld;
import fr.gameblack.rcuhcv2.commands.admin.CommandCreateWorld;
import fr.gameblack.rcuhcv2.commands.admin.CommandEpisode;
import fr.gameblack.rcuhcv2.commands.admin.CommandFermetureGolden;
import fr.gameblack.rcuhcv2.commands.admin.CommandRandom;
import fr.gameblack.rcuhcv2.commands.admin.CommandSetOrbe;
import fr.gameblack.rcuhcv2.commands.admin.CommandSetRole;
import fr.gameblack.rcuhcv2.commands.admin.CommandSetRoleOther;
import fr.gameblack.rcuhcv2.commands.admin.CommandSetStatut;
import fr.gameblack.rcuhcv2.commands.admin.CommandSpawnMinerais;
import fr.gameblack.rcuhcv2.commands.admin.CommandTpWorld;
import fr.gameblack.rcuhcv2.commands.game.CommandCompo;
import fr.gameblack.rcuhcv2.commands.game.CommandEffet;
import fr.gameblack.rcuhcv2.commands.game.CommandOrbe;
import fr.gameblack.rcuhcv2.commands.host.CommandAddAllRole;
import fr.gameblack.rcuhcv2.commands.host.CommandAddrole;
import fr.gameblack.rcuhcv2.commands.host.CommandCreate;
import fr.gameblack.rcuhcv2.commands.host.CommandRemoverole;
import fr.gameblack.rcuhcv2.commands.host.CommandStart;
import fr.gameblack.rcuhcv2.commands.joueur.jeannot.CommandPartage;
import fr.gameblack.rcuhcv2.commands.joueur.joko.CommandCube;
import fr.gameblack.rcuhcv2.commands.joueur.joko.CommandSteal;
import fr.gameblack.rcuhcv2.commands.joueur.nickoboop.CommandPapier;
import fr.gameblack.rcuhcv2.commands.joueur.slup.CommandTrial;
import fr.gameblack.rcuhcv2.commands.solo.farmeurimmo.CommandRCCode;
import fr.gameblack.rcuhcv2.commands.staff.gameblack.CommandChangeOrbe;
import fr.gameblack.rcuhcv2.commands.staff.gameblack.CommandCheckOrbe;
import fr.gameblack.rcuhcv2.commands.staff.gameblack.CommandConsole;
import fr.gameblack.rcuhcv2.commands.staff.loup.CommandServeur;
import fr.gameblack.rcuhcv2.commands.staff.trial.CommandFirstReflexGame;
import fr.gameblack.rcuhcv2.commands.staff.trial.CommandPlay;
import fr.gameblack.rcuhcv2.commands.staff.trial.CommandSacrifice;
import fr.gameblack.rcuhcv2.commands.staff.trial.CommandMode;
import fr.gameblack.rcuhcv2.listener.DamageListener;
import fr.gameblack.rcuhcv2.listener.InteractListener;
import fr.gameblack.rcuhcv2.listener.InventoryInteractListener;
import fr.gameblack.rcuhcv2.listener.PlayerActionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private World world = null;
    
    @Override
    public void onEnable() {
    	
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
    	getCommand("random").setExecutor(new CommandRandom());
    	getCommand("createworld").setExecutor(new CommandCreateWorld(this));
    	getCommand("spawnminerais").setExecutor(new CommandSpawnMinerais(this));
    	getCommand("tpworld").setExecutor(new CommandTpWorld(this));
    	getCommand("checkworld").setExecutor(new CommandCheckWorld(this));
    	getCommand("fermeturegolden").setExecutor(new CommandFermetureGolden(this));
    	
    	getCommand("compo").setExecutor(new CommandCompo(this));
    	getCommand("rceffet").setExecutor(new CommandEffet(this));
    	getCommand("rcorbe").setExecutor(new CommandOrbe(this));
    	
    	getCommand("addallrole").setExecutor(new CommandAddAllRole(this));
    	getCommand("addrole").setExecutor(new CommandAddrole(this));
    	getCommand("create").setExecutor(new CommandCreate(this));
    	getCommand("removerole").setExecutor(new CommandRemoverole(this));
    	getCommand("start").setExecutor(new CommandStart(this));
    	
    	getCommand("rcpartage").setExecutor(new CommandPartage(this));
    	getCommand("rcpapier").setExecutor(new CommandPapier(this));
    	getCommand("rctrial").setExecutor(new CommandTrial(this));
    	getCommand("rccube").setExecutor(new CommandCube(this));
    	getCommand("rcsteal").setExecutor(new CommandSteal(this));
    	
    	getCommand("rcplay").setExecutor(new CommandPlay(this));
    	getCommand("firstreflexgame").setExecutor(new CommandFirstReflexGame(this));
    	getCommand("rcmode").setExecutor(new CommandMode(this));
    	getCommand("rcsacrifice").setExecutor(new CommandSacrifice(this));
    	getCommand("rcserveur").setExecutor(new CommandServeur(this));
    	getCommand("rcchangeorbe").setExecutor(new CommandChangeOrbe(this));
    	getCommand("rccheckorbe").setExecutor(new CommandCheckOrbe(this));
    	getCommand("rcconsole").setExecutor(new CommandConsole(this));
    	
    	getCommand("rchack").setExecutor(new CommandRCCode(this));
    	
    	getServer().getPluginManager().registerEvents(new PlayerActionListener(this), this);
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


    }
    
    public void eliminate(Joueur joueur, boolean Kzou) {

        Roles role = Roles.NONE;

        if (Kzou) {

        	//A refaire

        } else {

            role = joueur.getRole();

        }
        joueur.setOrbe(Orbe.NONE);
        Bukkit.broadcastMessage("_________________________\n" + joueur.getPlayer().getName() + " est mort. Il était : \n" + role + "\n_________________________");
        checkWin();
        joueur.getPlayer().setGameMode(GameMode.SPECTATOR);

        //MortCD cycle = new MortCD(this, player);
        //cycle.runTaskTimer(this, 0, 20);
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

        if (getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {

            Bukkit.broadcastMessage("Le camps Joueur remporte la partie !");
            
            reloadGame();

        } else if (getCampJoueur().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {

            Bukkit.broadcastMessage("Le camps Staff remporte la partie !");
            
            reloadGame();

        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {

            Bukkit.broadcastMessage("Le camps UHC remporte la partie !");
            
            reloadGame();

        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getSolos().isEmpty()) {

            Bukkit.broadcastMessage("Le duo Slup - Trial remporte la partie !");
            
            reloadGame();

        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getDuo().isEmpty() && getSolos().isEmpty()) {

            Bukkit.broadcastMessage("Farmeurimmo remporte la partie !");
            
            reloadGame();

        } else if (getCampJoueur().isEmpty() && getCampStaff().isEmpty() && getCampUHC().isEmpty() && getCampFarmeurimmo().isEmpty() && getDuo().isEmpty() && getSolos().size() == 1) {

            if (getSolos().get(0).getRole() == Roles.TRIAL) {

                Bukkit.broadcastMessage("Trial remporte la partie !");
                
                reloadGame();

            } else if (getSolos().get(0).getRole() == Roles.KZOU) {

                Bukkit.broadcastMessage("Kzou remporte la partie !");
                
                reloadGame();

            }

        }

    }
    
    public void reloadGame() {
    	
    	for(Joueur joueur : joueurs) {
    		
    		joueur.reset();
    		
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
    		
    		if(joueur.getRole() != Roles.NONE) {
    			
    			joueurs_in_game.add(joueur);
    			
    		}
    		
    	}
    	
    	return joueurs_in_game;
    	
    }
    
    public Joueur getJoueurByRole(Roles role) {
    	
    	for(Joueur joueur : joueurs) {
    		
    		if(joueur.getRole() == role) {
    			
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
			
			Joueur host2 = hosts.get(0);
			hosts.set(0, host);
			hosts.add(host2);
			
		}
	}
	
	public void addHost(Joueur joueur) {
		
		if(!hosts.contains(joueur)) {
			
			hosts.add(joueur);
			
		}
		
	}
	
	public void removeHost(Joueur joueur) {
		
		if(hosts.contains(joueur)) {
			
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
	
}
