package org.godsboss.games.evasion;

public class Evasion{
	public static void main(String[] args){
		Game game = new Game(getConfiguration(args));
		game.start();}

	private static GameConfiguration getConfiguration(String[] args){
		GameConfiguration config = new GameConfiguration();
		for(int i=0;i<args.length;i++){
			if (args[i].equals("--enemy-directions")){
				if (args.length>i+1){
					String enemyDirections = args[i+1];
					if (enemyDirections.equals("random")){
						config.setEnemyDirections(GameConfiguration.Directions.RANDOM);}
					if (enemyDirections.equals("main-axes")){
						config.setEnemyDirections(GameConfiguration.Directions.MAIN_AXES);}
					if (enemyDirections.equals("target-player")){
						config.setEnemyDirections(GameConfiguration.Directions.TARGET_PLAYER);}}}}
		return config;}}
