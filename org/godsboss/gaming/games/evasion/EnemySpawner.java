package org.godsboss.gaming.games.evasion;

class EnemySpawner{
	private final Game game;
	private final double threshold;
	private final ObjectFactory factory;

	private double value = 0;

	public EnemySpawner(double threshold, Game game, ObjectFactory factory){
		this.threshold = threshold;
		this.game = game;
		this.factory = factory;}

	public void tick(double seconds){
		value += seconds;
		if (value >= threshold){
			value -= threshold;
			game.addEnemy(factory.createEnemy(game.getPlayer().getPosition().plus(game.getBounds().getSize().times(0.5)).modulo(game.getBounds())));}}}
