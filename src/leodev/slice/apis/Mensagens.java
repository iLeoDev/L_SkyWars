package leodev.slice.apis;

public interface Mensagens {
	public String prefix = "§b§lSKYWARS§r ";
	public String COMANDO_INVALIDO = prefix + "§cUse:\n §f/sw criar <arena>\n/sw setspawns <arena>\n /sw setopen <arena>";
	public String ARENA_JA_EXISTE = prefix + "§cEsta arena já existe.";
	public String ARENA_CRIADA = prefix + "§cArena %s criada com sucesso.";
	public String JA_ESTA_SETANDO_SPAWNS = prefix + "§cVocê já está setando os spawns da arena %s";
	public String WAIT_AREA_SUCESS_SET = prefix + "§aVocê setou a WaitArea com sucesso!";
	public String PLAYER_JOIN_ARENA = prefix + "§aVocê entrou na Arena %s. §7[§a%s§f/§c%s§7]";
	public String PLAYER_JOIN_WAIT_AREA_TITLE = "§aVocê entrou na Arena §f%s";
	
	public String SCOREBOARD_1 = "§c%s";
	public String SCOREBOARD_2 = "§7Jogadores: §7[§f%s/%s§7]";
	public String SCOREBOARD_3 = "§7Kills:§c§l EM BREVE";
	public String SCOREBOARD_4 = "TESTE";
	public String SCOREBOARD_5 = "%s";
	
	public String FORM_NAME_PLAYER = "§b§lArenas";
	public String FORM_NAME_STAFF = "§b§lCONFIGS";
	public String FORM_PLAYER_CONTENT = "§bClique em alguma sala disponivel para entrar.\n §7(§fBranco: §fBUGADA, §aVERDE: §fDISPONIVEL, §4VERMELHO: §fEM JOGO, §6OUR0: §fREINICIANDO, §cVINHO: §fNÃO CONFIGURADA)";
	public String FORM_STAFF_CONTENT = "§bConfigure as arenas por aqui.";
	
	public String FORM_ACTIVATE_WORLD_TP = "Ativar world TP";
	public String FORM_WORLD_TP = "§7Ir para o mundo: §b";
	public String FORM_CREATE_NAME = " §aCriar sala";
	public String FORM_CREATE_BUTTON_NAME = "§7Criar";
	public String FORM_CREATE_FORM_NAME = "§7Criar sala";
	public String FORM_CREATE_PLACEHOLDER = "§7Digite aqui";
	public String FORM_CREATE_ARENA = "§aNome da sala";
	public String FORM_SET_SPAWNS_BUTTON_NAME = "§7SetSpawns";
	public String FORM_STAFF_PLAY_BUTTON = "§bJogar";
	public String FORM_CONTENT_ARENA_IS_IN_GAME = "§4Está arena está em jogo!";
	
	public String PLAYER_WIN_GAME_TITLE = prefix;
	public String PLAYER_WIN_GAME_SUBTITLE = "§aParabens você ganhou!";
	
	public String PLAYER_DEATH = "§4Você morreu e entrou no modo espectador.";
	

}
