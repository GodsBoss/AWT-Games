package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Position;

class EnemySpawner{
	private final Game game;
	private final double threshold;
	private final ObjectFactory factory;

	private double value = 0;
	private Position position;

	public EnemySpawner(double threshold, Game game, ObjectFactory factory){
		this.threshold = threshold;
		this.game = game;
		this.factory = factory;}

	public void tick(double seconds){
		value += seconds;
		position = game.getPlayer().getPosition().plus(game.getBounds().getSize().times(0.5)).modulo(game.getBounds());
		if (value >= threshold){
			value -= threshold;
			game.addEnemy(factory.createEnemy(position));}}}
