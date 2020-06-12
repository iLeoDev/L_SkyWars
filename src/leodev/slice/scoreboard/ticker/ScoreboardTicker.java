package leodev.slice.scoreboard.ticker;

import leodev.slice.Loader;
import leodev.slice.scoreboard.scoreboard.Scoreboard;
import cn.nukkit.Player;
import cn.nukkit.scheduler.Task;
public class ScoreboardTicker extends Task{
	
	public void onRun(int currentTick) {
		for(Player player : board.getServer().getOnlinePlayers().values()) {
			if(Loader.getScoreboard(player) != null) {
				Scoreboard b = Loader.getScoreboard(player);
				/*if(b.getObjective().objectiveName.equals("SW")){
					cancel();
				} else {*/
				Loader.boards.remove(player);
			//	this.board.darScore(player);
				b.onUpdate();
			//	}
			}
		}
	}
	
	public ScoreboardTicker(Loader b) {
		board = b;
	}
	
	public Loader board;

}
