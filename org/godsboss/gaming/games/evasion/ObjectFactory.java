package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

import java.awt.Color;

class ObjectFactory{
	private final Bounds bounds;
	private final Game game;

	private KillPlayer killPlayer;
	private BoundedObject playerBounded;

	public ObjectFactory(Game game, Bounds bounds){
		this.game   = game;
		this.bounds = bounds;}

	public Player createPlayer(Position startingPosition, Size size){
		Positionable positionable = new Positionable(startingPosition);
		Sized sized = new Sized(size);
		playerBounded = new BoundedObject(positionable, sized);
		RectangleRenderer renderer = new RectangleRenderer(playerBounded, Color.GREEN);
		return new Player(positionable, sized, renderer);}

	public Enemy createEnemy(Position startingPosition){
		if (killPlayer == null){
			killPlayer = new KillPlayer(game);}
		Positionable positionable = new Positionable(startingPosition);
		Sized sized = new Sized(Size.randomWithin(10, 30));
		BoundedObject enemyBounded = new BoundedObject(positionable, sized);
		RectangleRenderer renderer = new RectangleRenderer(enemyBounded, Color.RED);
		Enemy enemy = new Enemy(positionable, createMoving(positionable), sized, new Growing(sized), game, renderer);
		enemy.addCollision(new CollidesWithPlayer(enemyBounded, playerBounded, killPlayer));
		return enemy;}

	private Moving createMoving(Positionable positionable){
		return new Moving(positionable, bounds, Velocity.randomDirection(80));}

	public EnemySpawner createEnemySpawner(double threshold){
		return new EnemySpawner(threshold, game, this);}}
