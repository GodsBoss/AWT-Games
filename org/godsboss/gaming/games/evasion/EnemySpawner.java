package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Position;

class EnemySpawner{
	private final Positionable playerPositionable;
	private final double threshold;
	private final ObjectFactory factory;
	private final Game game;

	private double value = 0;
	private Position position;

	public EnemySpawner(double threshold, Positionable playerPositionable, Game game, ObjectFactory factory){
		this.threshold = threshold;
		this.playerPositionable = playerPositionable;
		this.factory = factory;
		this.game = game;}

	public void tick(double seconds){
		value += seconds;
		position = playerPositionable.get().plus(game.getBounds().getSize().times(0.5)).modulo(game.getBounds());
		if (value >= threshold){
			value -= threshold;
			game.addEnemy(factory.createEnemy(position));}}}
