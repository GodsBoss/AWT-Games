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
		return new Player(new Positionable(startingPosition), size);}

	public Enemy createEnemy(Position startingPosition){
		return new Enemy(startingPosition, Velocity.randomDirection(80), Size.randomWithin(10, 30), bounds, game);}

	public EnemySpawner createEnemySpawner(double threshold){
		return new EnemySpawner(threshold, game, this);}}
