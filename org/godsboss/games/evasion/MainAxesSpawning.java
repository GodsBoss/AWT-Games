package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Velocity;
import org.godsboss.gcomp.physics2d.Positionable;

class MainAxesSpawning implements Component{
	private final double threshold;
	private final Game game;
	private final ObjectFactory factory;
	private final Positionable player;

	private double value = 0.0;

	public MainAxesSpawning(double threshold, Positionable playerPositionable, ObjectFactory factory, Game game){
		this.threshold = threshold;
		this.game = game;
		this.factory = factory;
		player = playerPositionable;}

	public void tick(double seconds){
		value += seconds;
		if (value >= threshold){
			value -= threshold;
			addEnemy();}}

	private void addEnemy(){
		int dir = (int)Math.floor(Math.random()*4);
		Position position;
		Velocity velocity;
		if (dir == 0 || dir == 1){
			position = player.get().plus(game.getBounds().getWidth() / 2.0, 0.0).modulo(game.getBounds());
			velocity = new Velocity(dir == 0 ? 80 : -80, 0);}
		else{
			position = player.get().plus(0.0, game.getBounds().getHeight() / 2.0).modulo(game.getBounds());
			velocity = new Velocity(0, dir == 2 ? 80 : -80);}
		game.addEnemy(factory.createEnemy(position, velocity));}}
