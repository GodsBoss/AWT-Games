package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.PositionDifference;
import org.godsboss.gaming.physics2d.Velocity;
import org.godsboss.gcomp.physics2d.Positionable;

class TargetPlayerSpawning implements Component{
	private final double threshold;
	private final Game game;
	private final ObjectFactory factory;
	private final Positionable self;
	private final Positionable player;

	private double value = 0.0;

	public TargetPlayerSpawning(double threshold, Positionable self, Positionable player, ObjectFactory factory, Game game){
		this.threshold = threshold;
		this.self = self;
		this.player = player;
		this.factory = factory;
		this.game = game;}

	public void tick(double seconds){
		value += seconds;
		if (value >= threshold){
			value -= threshold;
			PositionDifference diff = player.get().minus(self.get());
			Velocity velocity = (new Velocity(diff.getHorizontal(), diff.getVertical())).normalize().times(80);
			game.addEnemy(factory.createEnemy(self.get(), velocity));}}}
