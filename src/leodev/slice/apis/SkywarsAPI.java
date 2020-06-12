package leodev.slice.apis;

import java.util.ArrayList;
import java.util.HashMap;










import com.sun.jna.IntegerType;

import leodev.slice.Loader;
import leodev.slice.enums.Estado;
import leodev.slice.scoreboard.scoreboard.Criteria;
import leodev.slice.scoreboard.scoreboard.DisplaySlot;
import leodev.slice.scoreboard.scoreboard.Scoreboard;
import leodev.slice.scoreboard.scoreboard.ScoreboardObjective;
import leodev.slice.scoreboard.ticker.ScoreboardTicker;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;

public class SkywarsAPI {
	public HashMap<Player, Integer> players = new HashMap<>();
	public HashMap<Player, Integer> specs = new HashMap<>();
	public HashMap<Integer, Location> spawns = new HashMap<>();
	public ArrayList<Player> winner = new ArrayList<>();
	public String arenaname;
	public Config c;
	public Loader pl;
	public Integer configurada;
	public Integer maxPlayers;
	private int timeIntoStart;
	private int timeIntoRestart;
	private int gameTime;
	private int WinnerTime;
	private Estado state;
	public HashMap<Integer, Location> getSpawns() {
		return spawns;
	}
	public Config getC() {
		return c;
	}
	public void setC(Config c) {
		this.c = c;
	}
	public Loader getPlugin() {
		return pl;
	}
	public void setPl(Loader pl) {
		this.pl = pl;
	}
	public Integer getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public int getTimeIntoStart() {
		return timeIntoStart;
	}
	public void setTimeIntoStart(int timeIntoStart) {
		this.timeIntoStart = timeIntoStart;
	}
	public int getTimeIntoRestart() {
		return timeIntoRestart;
	}
	public void setTimeIntoRestart(int timeIntoRestart) {
		this.timeIntoRestart = timeIntoRestart;
	}
	public int getTimeIntoGameOver() {
		return timeIntoGameOver;
	}
	public void setTimeIntoGameOver(int timeIntoGameOver) {
		this.timeIntoGameOver = timeIntoGameOver;
	}
	private int timeIntoGameOver;

	
	public SkywarsAPI(Loader ps, String nome){
		this.pl = ps;
		setState(Estado.ESPERANDO);
		setArenaname(nome);
		setMaxPlayers(12);
		setTimeIntoGameOver(10);
		setTimeIntoRestart(10);
		setTimeIntoStart(3);
		setGameTime(0);
		setWinnerTime(10);
		this.getPlugin().getServer().getScheduler().scheduleRepeatingTask(new Task() {
	        @Override
	        public void onRun(int i) {
	            Server server = getPlugin().getServer();
	           if(getPlayersCount() > 0){
	        	   setTimeIntoStart(getTimeIntoStart() - 1);
	        	   for(Player p : getPlayers().keySet()){
	        		   if(getState().equals(Estado.ESPERANDO))
	        		   p.sendTip(getTimeIntoStart() + "");
	        	   }
	        	   if(getTimeIntoStart() <= 0 && getState().equals(Estado.ESPERANDO)){
	        		   for(Player p : getPlayers().keySet()){
	        			   Integer is = getPlayers().get(p);
	        			   teleportPlayer(p, is);
	        			   setState(Estado.INICIANDO);
	        			   setGameTime(0);
	        		   }
	        	   }
	           }else {
	        	   setTimeIntoStart(3);
	           }
	           if(getState().equals(Estado.INICIANDO)){
	        	   if(getPlayers().size() == 1){
	        		   for(Player p : getPlayers().keySet()){
	        			   winGame(p);
	        			   setState(Estado.FINAL);
	        		   }
	        	   }
	        	   }else if(getState().equals(Estado.EM_JOGO)){
	        	   setGameTime(getGameTime() + 1);
	        	   for(Player p : getPlayers().keySet()){
	        	   p.sendTip(getGameTime() + "");
	        	   }
	           }else if(getState().equals(Estado.FINAL)){
        		   if (!winner.isEmpty()){
	        		   if(getWinnerTime() > 0){
	        			   setWinnerTime(getWinnerTime() - 1);
	        			   getWinner().get(0).sendTip("§a" + getWinnerTime());
	        		   }else if(getWinnerTime() <= 0){
	        			   getWinner().get(0).setGamemode(0);
	        			   setState(Estado.RESETANDO);
	        		   }
	        	   }
        	   }
	        }
	    }, 20);
			Config sss = new Config(pl.getDataFolder() + "/Arenas/" + this.getName() + ".yml",Config.YAML);
			if(sss.getInt("Configurada") == 1 || sss.get("Configurada") == "1"){
				setConfigurada(1);
			}else
				setConfigurada(0);
			setC(sss);
			}
	public HashMap<Player, Integer> getSpecs() {
		return specs;
	}
	public void setSpecs(HashMap<Player, Integer> specs) {
		this.specs = specs;
	}
	public ArrayList<Player> getWinner() {
		return winner;
	}
	public void setWinner(ArrayList<Player> winner) {
		this.winner = winner;
	}
	public int getWinnerTime() {
		return WinnerTime;
	}
	public void setWinnerTime(int winnerTime) {
		WinnerTime = winnerTime;
	}
	public HashMap<Player, Integer> getPlayers() {
		return players;
	}
	public void setPlayers(HashMap<Player, Integer> players) {
		this.players = players;
	}
	public String getArenaname() {
		return arenaname;
	}
	public void setArenaname(String arenaname) {
		this.arenaname = arenaname;
	}
	public Integer getConfigurada() {
		return configurada;
	}
	public void setConfigurada(Integer configurada) {
		this.configurada = configurada;
	}
	public String getName(){
		return arenaname;
	}
	public Integer getPlayersCount(){
		return players.size();
	}
	public void teleportWaitArea(Player p){
		if(getPlugin().configs.exists("WaitArea")){
			ConfigSection sec = getPlugin().configs.getSection("WaitArea");
			int x = sec.getInt("X");
			int y = sec.getInt("Y");
			int z = sec.getInt("Z");
			String mundo = sec.getString("Level");
			if(getPlugin().getServer().getLevelByName(mundo) != null){
				Level level = getPlugin().getServer().getLevelByName(mundo);
				Location loc = new Location(x,y,z,level);
				p.teleport(loc);
				p.sendTitle(Mensagens.prefix, String.format(Mensagens.PLAYER_JOIN_WAIT_AREA_TITLE, getName()), 2, 10, 2);
			}else {
			}
		}
	}
	public void teleportPlayer(Player p, int i){
		if(getPlayersCount() < getMaxPlayers()){
			Location loc = getSpawns().get(1);
			getPlayers().put(p, 1);
			p.teleport(loc);
		}
	}
	public void join(Player p){
		p.setGamemode(0);
		p.getInventory().clearAll();
		p.setHealth(p.getMaxHealth());
		p.getFoodData().setFoodLevel(p.getFoodData().getMaxLevel());
		teleportWaitArea(p);
		getPlayers().put(p, getPlayersCount() + 1);
		p.sendMessage(String.format(Mensagens.PLAYER_JOIN_ARENA, getName(), getPlayers().size(), getMaxPlayers()));
				Scoreboard board = new Scoreboard();
				ScoreboardObjective obj = board.registerNewObjective("SW", Criteria.DUMMY);
				obj.setDisplaySlot(DisplaySlot.SIDEBAR);
				obj.setDisplayName(Mensagens.prefix);
				//obj.registerScore("fake1"," ", 6);
				obj.registerScore("Arena", String.format(Mensagens.SCOREBOARD_1, getState().toString()), 8);
				obj.registerScore("fake56","§s ", 7);
				obj.registerScore("rankatual",String.format(Mensagens.SCOREBOARD_2, getPlayersCount(), getMaxPlayers()) , 6);
				obj.registerScore("ranknext",Mensagens.SCOREBOARD_3, 5);
				obj.registerScore("porcentagem","§a", 4);
				obj.registerScore("fake3",Mensagens.SCOREBOARD_4, 3);
				obj.registerScore("coins",String.format(Mensagens.SCOREBOARD_5, getTimeIntoStart()), 2);
				obj.registerScore("twitter",Mensagens.prefix, 1);
				this.pl.sendScoreboard(p, board);
				this.pl.getServer().getScheduler().scheduleRepeatingTask(new ScoreboardTicker(this.pl), 20);
		
	}
	public int getGameTime() {
		return gameTime;
	}
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	public Estado getState() {
		return state;
	}
	public void setState(Estado state) {
		this.state = state;
	}
	public boolean setSpawns(Location loc){
		if(getSpawns().size() < 12){
			setConfigurada(0);
			getSpawns().put(getSpawns().size() + 1, loc);
			return true;
		}else {
			setConfigurada(1);
			return false;
		}
	}
	public void killedPlayer(Player p){
		getPlayers().remove(p);
		getSpecs().put(p, getSpecs().size() + 1);
		//p.sendMessage(Mensagens.);
	}
	public void winGame(Player p){
		p.getInventory().clearAll();
		p.setGamemode(3);
		p.sendTitle(Mensagens.PLAYER_WIN_GAME_TITLE, Mensagens.PLAYER_WIN_GAME_SUBTITLE, 3, 10, 2);
		getPlayers().remove(p);
		getWinner().add(p);
	}
	public void resetMap(){
		
	}
}
