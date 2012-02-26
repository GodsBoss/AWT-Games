package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class ObjectFactory{
	private final Bounds bounds;
	private final Game game;

	public ObjectFactory(Game game, Bounds bounds){
		this.game   = game;
		this.bounds = bounds;}

	public Player createPlayer(Position startingPosition, Size size){
		return new Player(new Positionable(startingPosition), new Sized(size));}

	public Enemy createEnemy(Position startingPosition){
		Positionable positionable = new Positionable(startingPosition);
		Sized sized = new Sized(Size.randomWithin(10, 30));
		return new Enemy(positionable, createMoving(positionable), sized, new Growing(sized), game);}

	private Moving createMoving(Positionable positionable){
		return new Moving(positionable, bounds, Velocity.randomDirection(80));}

	public EnemySpawner createEnemySpawner(double threshold){
		return new EnemySpawner(threshold, game, this);}}
