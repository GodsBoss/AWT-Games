package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class Enemy{
	private Positionable positionable;
	private Velocity velocity;
	private Size size;
	private Bounds bounds;
	private Game game;

	public Enemy(Positionable positionable, Velocity velocity, Size size, Bounds bounds, Game game){
		this.positionable = positionable;
		this.velocity     = velocity;
		this.size         = size;
		this.bounds       = bounds;
		this.game         = game;}

	public void tick(double seconds){
		size = size.plus(seconds, seconds);
		positionable.moveTo(positionable.get().plus(velocity.times(seconds)).modulo(bounds));
		positionable.tick(seconds);
		if (game.getPlayer().overlapsWith(getPosition().centerBoundsWithSize(getSize()))){
			game.endGame();}}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(size);}

	public Size getSize(){
		return size;}}
