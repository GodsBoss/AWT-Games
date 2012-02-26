package org.godsboss.gaming.games.evasion;

class EnemySpawner{
	private final Game game;
	private final double threshold;

	private double value = 0;

	public EnemySpawner(double threshold, Game game){
		this.threshold = threshold;
		this.game = game;}

	public void tick(double seconds){
		value += seconds;
		if (value >= threshold){
			value -= threshold;
			game.addEnemy();}}}
