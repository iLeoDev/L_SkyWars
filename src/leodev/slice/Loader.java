package leodev.slice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import leodev.slice.apis.Mensagens;
import leodev.slice.apis.SkywarsAPI;
import leodev.slice.comandos.SkywarsCommand;
import leodev.slice.eventos.SkywarsOpEvents;
import leodev.slice.scoreboard.protocol.RemoveObjectivePacket;
import leodev.slice.scoreboard.scoreboard.Scoreboard;
import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;

public class Loader extends PluginBase{
	
	public ArrayList<SkywarsAPI> salas = new ArrayList<>();
	public Config configs;
	public HashMap<Player, SkywarsAPI> playersSpawn = new HashMap<>();
	public void onEnable(){
		configs = new Config(getDataFolder() + "/" + "configs" +".yml",Config.YAML);
		loadArenas();
		getServer().getConsoleSender().sendMessage("§c" + salas.size());
		getServer().getCommandMap().register("SkywarsCommand", new SkywarsCommand(this));
		getServer().getPluginManager().registerEvents(new SkywarsOpEvents(this), this);
	}
	public void loadArenas(){
		salas.clear();
		File file = new File(getDataFolder(), "/Arenas/");
		if (!file.isDirectory()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (file.listFiles().length >= 1) {
			int is = 0;
			for (File sky : file.listFiles()) {
				Config config = new Config(sky);
				if(config.exists("Nome")){
				SkywarsAPI s = new SkywarsAPI(this, config.getString("Nome"));
				for(int i = 0; i < 13; i++){
					ConfigSection sec = config.getSection("Spawn." + i);
					int x = sec.getInt("X");
					int y = sec.getInt("Y");
					int z = sec.getInt("Z");
					String m = sec.getString("Level");
					Level level = this.getServer().getLevelByName(m);
					if(level != null){
					   Location loc = new Location(x, y, z, level);
					   s.setSpawns(loc);
					   s.setConfigurada(1);
					 }
			      }
				salas.add(s);
				}else {
					String nome = sky.getName();
					nome.replaceAll(".yml", "");
					SkywarsAPI s = new SkywarsAPI(this, nome.replaceAll(".yml", ""));
					salas.add(s);
					s.setConfigurada(0);
					getServer().getConsoleSender().sendMessage(Mensagens.prefix + "§4§lSALA §f" + nome.replaceAll(".yml", "") + "§4 NÃO CONFIGURADA.");
				}
			}
		}
	}
	public void saveAllMaps(){
		for(SkywarsAPI s : salas){
			Config c = s.getC();
				if(c.exists("Configurada") && c.getInt("Configurada") == 1 || c.get("Configurada") == "1"){
					c.set("Nome", s.getName());
					c.set("Configurada", 1);
					c.set("MaxPlayers", s.getMaxPlayers());
					c.set("Configurada", 1);
					c.save();
					for(Integer i : s.getSpawns().keySet()){
						Location loc = s.getSpawns().get(i);
						double x = loc.getX();
						double y = loc.getY();
						double z = loc.getZ();
						Level lvl = loc.getLevel();
						ConfigSection sec = new ConfigSection();
						sec.put("X", x);
						sec.put("Y", y);
						sec.put("Z", z);
						sec.put("Level", lvl.getName());
						c.set("Spawn." + i, sec);
					}
					c.save();
				} else if(c.exists("Configurada") && c.getInt("Configurada") == 0 || c.get("Configurada") == "0"){
					getServer().getConsoleSender().sendMessage("§c§lSALA §f" + s.getName() + " NÃO CONFIGURADA.");
			}
		}
	}
	public SkywarsAPI getSkywars(String nome){
		for(SkywarsAPI sky : salas){
			if(sky.getName().equals(nome)){
				return sky;
			}
		}
		return null;
	}
	public void onDisable(){
		saveAllMaps();
	}
	public static HashMap<Player, Scoreboard> boards = new HashMap<Player, Scoreboard>();
	public static void sendScoreboard(Player player, Scoreboard scoreboard) {
		if(!boards.containsKey(player)) {
			scoreboard.player = player;
			boards.put(player, scoreboard);
		} else {
			boards.remove(player);
			scoreboard.player = player;
			boards.put(player, scoreboard);
		}
	}
	
	public static void removeScoreboard(Player player) {
		if(boards.containsKey(player)) {
			RemoveObjectivePacket packet = new RemoveObjectivePacket();
			packet.objectiveName = getScoreboard(player).getObjective().objectiveName;
			player.dataPacket(packet);
			boards.remove(player);
		}
	}
	
	public static Scoreboard getScoreboard(Player player) {
		try {
			return boards.get(player);
		} catch(NullPointerException e) {
			return null;
		}
	}
	private static final class LoaderNukkit {
        private static final Loader instance = new Loader();
    }
	public static Loader getSingleton() {
        return LoaderNukkit.instance;
    }
}
