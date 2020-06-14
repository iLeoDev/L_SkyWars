package leodev.slice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

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
	public Config players;
	public HashMap<Player, SkywarsAPI> setingSpawns = new HashMap<Player, SkywarsAPI>();
	public HashMap<Player, SkywarsAPI> playersSpawn = new HashMap<>();
	public void onEnable(){
		configs = new Config(getDataFolder() + "/" + "configs" +".yml",Config.YAML);
		players = new Config(getDataFolder() + "/" + "playerStats" +".yml",Config.YAML);
		loadArenas();
		getServer().getConsoleSender().sendMessage("§c" + salas.size());
		getServer().getCommandMap().register("SkywarsCommand", new SkywarsCommand(this));
		getServer().getPluginManager().registerEvents(new SkywarsOpEvents(this), this);
		File worlds = new File(getServer().getDataPath() + "/worlds");
        if (worlds.exists()) {
            for (String world : Objects.requireNonNull(worlds.list())) {
                if (!getServer().isLevelLoaded(world)) {
                    getServer().loadLevel(world);
                }
            }
        }
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
				SkywarsAPI s = new SkywarsAPI(this, config.getString("Nome"), config.getInt("MaxPlayers"));
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
					   s.setMaxPlayers(config.getInt("MaxPlayers"));
					 }
			      }
				ConfigSection sec = config.getSection("WaitArea");
				int x = sec.getInt("X");
				int y = sec.getInt("Y");
				int z = sec.getInt("Z");
				String m = sec.getString("Level");
				Level level = this.getServer().getLevelByName(m);
				if(level != null){
				   Location loc = new Location(x, y, z, level);
				   s.waitArea = loc;
				}
				salas.add(s);
				}else {
					String nome = sky.getName();
					nome.replaceAll(".yml", "");
					SkywarsAPI s = new SkywarsAPI(this, nome.replaceAll(".yml", ""), 12);
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
				//if(c.exists("Configurada") && c.getInt("Configurada") == 1 || c.get("Configurada") == "1"){
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
					Location loc = s.waitArea;
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					Level lvl = loc.getLevel();
					ConfigSection sec = new ConfigSection();
					sec.put("X", x);
					sec.put("Y", y);
					sec.put("Z", z);
					sec.put("Level", lvl.getName());
					c.set("WaitArea", sec);
					c.save();
				//} else if(c.exists("Configurada") && c.getInt("Configurada") == 0 || c.get("Configurada") == "0"){
				//getServer().getConsoleSender().sendMessage("§c§lSALA §f" + s.getName() + " NÃO CONFIGURADA.");
			//}
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
	public void saveMap(Level world){
		File file = new File("worlds/");
		File file2 = new File(getDataFolder() + "/Mapas/" + world.getName() + "/");
		file2.mkdir();
		file.mkdir();
		if (!file.isDirectory()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		for(File a : file.listFiles()){
			if(world.getFolderName().equals(a.getName())){
				if(a.isDirectory()){
					try {
						copyDir(a.getAbsoluteFile(), file2);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//********************* créditos BITESKYWARS *********************
	 public void copyDir(File source, File target)
			    throws IOException
			  {
			    if (source.isDirectory())
			    {
			      if (!target.exists()) {
			        target.mkdir();
			      }
			      String[] files = source.list();
			      for (String file : files)
			      {
			        File srcFile = new File(source, file);
			        File destFile = new File(target, file);
			        copyDir(srcFile, destFile);
			      }
			    }
			    else
			    {
			      InputStream in = new FileInputStream(source);
			      OutputStream out = new FileOutputStream(target);
			      byte[] buffer = new byte[1024];
			      int length;
			      while ((length = in.read(buffer)) > 0)
			      {
			        out.write(buffer, 0, length);
			      }
			      in.close();
			      out.close();
			    }
			  }
	 // ******************* FIM DOS CRÉDITOS **********************
}
