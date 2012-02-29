package org.godsboss.games.evasion;

class GameConfiguration{
	public static enum Directions{
		RANDOM,
		MAIN_AXES,
		TARGET_PLAYER}

	private Directions enemyDirections = Directions.RANDOM;

	public void setEnemyDirections(Directions directions){
		enemyDirections = directions;}

	public Directions getEnemyDirections(){
		return enemyDirections;}}
