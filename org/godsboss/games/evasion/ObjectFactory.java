package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Control;
import org.godsboss.gaming.ecs.Entity;
import org.godsboss.gaming.ecs.NullControl;
import org.godsboss.gaming.gui.NullRenderer;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.PositionDifference;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;
import org.godsboss.gcomp.physics2d.BoundedPositioning;
import org.godsboss.gcomp.physics2d.Growing;
import org.godsboss.gcomp.physics2d.Moving;
import org.godsboss.gcomp.physics2d.Positionable;
import org.godsboss.gcomp.physics2d.RelativePositioning;
import org.godsboss.gcomp.physics2d.Sized;

import java.awt.Color;

class ObjectFactory{
	private final GameConfiguration config;
	private final Bounds bounds;
	private final Game game;

	private KillPlayer killPlayer;
	private BoundedObject playerBounded;
	private Positionable playerPositionable;

	public ObjectFactory(GameConfiguration config, Game game, Bounds bounds){
		this.config = config;
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
		return createEnemy(startingPosition, Velocity.randomDirection(80));}

	public Entity createEnemy(Position startingPosition, Velocity velocity){
		if (killPlayer == null){
			killPlayer = new KillPlayer(game);}
		Positionable positionable = new Positionable(startingPosition);
		Sized sized = new Sized(Size.randomWithin(10, 30));
		BoundedObject enemyBounded = new BoundedObject(positionable, sized);
		RectangleRenderer renderer = new RectangleRenderer(enemyBounded, Color.RED);
		Entity enemy = new Entity(renderer, NullControl.NULL_CONTROL);
		enemy.addComponent(positionable);
		enemy.addComponent(new Moving(positionable, velocity));
		enemy.addComponent(new BoundedPositioning(positionable, bounds));
		enemy.addComponent(sized);
		enemy.addComponent(new Growing(sized));
		enemy.addComponent(new CollidesWithPlayer(enemyBounded, playerBounded, killPlayer));
		return enemy;}

	public Entity createEnemySpawner(double threshold){
		Entity spawner = new Entity(NullRenderer.NULL_RENDERER, NullControl.NULL_CONTROL);
		switch(config.getEnemyDirections()){
			case RANDOM:
				addRandomDirectionComponents(spawner, threshold);
				break;
			case MAIN_AXES:
				addMainAxesComponents(spawner, threshold);
				break;
			case TARGET_PLAYER:
				addTargetPlayerComponents(spawner, threshold);
				break;}
		return spawner;}

	private void addRandomDirectionComponents(Entity spawner, double threshold){
		Positionable self = new Positionable(new Position(0, 0));
		PositionDifference diff = (new Position(0, 0)).minus(bounds.getCenter());
		RelativePositioning positioning = new RelativePositioning(self, playerPositionable, diff, bounds);
		spawner.addComponent(positioning);
		spawner.addComponent(self);
		spawner.addComponent(new EnemySpawning(threshold, self, this, game));}

	private void addMainAxesComponents(Entity spawner, double threshold){
		spawner.addComponent(new MainAxesSpawning(threshold, playerPositionable, this, game));}

	private void addTargetPlayerComponents(Entity spawner, double threshold){
		Positionable self = new Positionable(new Position(0, 0));
		PositionDifference diff = (new Position(0, 0)).minus(bounds.getCenter());
		spawner.addComponent(new OppositePointOfCircle(self, playerPositionable, bounds.getCenter(), 100));
		spawner.addComponent(self);
		spawner.addComponent(new TargetPlayerSpawning(threshold, self, playerPositionable, this, game));}}
