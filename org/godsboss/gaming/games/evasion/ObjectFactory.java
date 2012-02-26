package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Control;
import org.godsboss.gaming.ecs.Entity;
import org.godsboss.gaming.ecs.NullControl;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

import java.awt.Color;

class ObjectFactory{
	private final Bounds bounds;
	private final Game game;
	private final Control nullControl = new NullControl();

	private KillPlayer killPlayer;
	private BoundedObject playerBounded;
	private Positionable playerPositionable;

	public ObjectFactory(Game game, Bounds bounds){
		this.game   = game;
		this.bounds = bounds;}

	public Entity createPlayer(Position startingPosition, Size size){
		playerPositionable = new Positionable(startingPosition);
		Sized sized = new Sized(size);
		playerBounded = new BoundedObject(playerPositionable, sized);
		RectangleRenderer renderer = new RectangleRenderer(playerBounded, Color.GREEN);
		Entity player = new Entity(renderer, new MoveObjectToMousePosition(playerPositionable));
		player.addComponent(playerPositionable);
		player.addComponent(sized);
		return player;}

	public Entity createEnemy(Position startingPosition){
		if (killPlayer == null){
			killPlayer = new KillPlayer(game);}
		Positionable positionable = new Positionable(startingPosition);
		Sized sized = new Sized(Size.randomWithin(10, 30));
		BoundedObject enemyBounded = new BoundedObject(positionable, sized);
		RectangleRenderer renderer = new RectangleRenderer(enemyBounded, Color.RED);
		Entity enemy = new Entity(renderer, nullControl);
		enemy.addComponent(positionable);
		enemy.addComponent(createMoving(positionable));
		enemy.addComponent(sized);
		enemy.addComponent(new Growing(sized));
		enemy.addComponent(new CollidesWithPlayer(enemyBounded, playerBounded, killPlayer));
		return enemy;}

	private Moving createMoving(Positionable positionable){
		return new Moving(positionable, bounds, Velocity.randomDirection(80));}

	public EnemySpawner createEnemySpawner(double threshold){
		return new EnemySpawner(threshold, playerPositionable, game, this);}}
