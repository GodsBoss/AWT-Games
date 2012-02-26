package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;

class EnemySpawning implements Component{
	private final double threshold;
	private final Positionable positionable;
	private final ObjectFactory factory;
	private final Game game;

	private double value = 0;

	public EnemySpawning(double threshold, Positionable positionable, ObjectFactory factory, Game game){
		this.threshold = threshold;
		this.positionable = positionable;
		this.factory = factory;
		this.game = game;}

	public void tick(double seconds){
		value += seconds;
		if (value >= threshold){
			value -= threshold;
			game.addEnemy(factory.createEnemy(positionable.get()));}}}
