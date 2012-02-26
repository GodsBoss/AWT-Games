package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class Enemy{
	private Positionable positionable;
	private Moving moving;
	private Growing growing;
	private Sized sized;
	private Game game;
	private CollidesWithPlayer collision;

	public Enemy(Positionable positionable, Moving moving, Sized sized, Growing growing, Game game){
		this.positionable = positionable;
		this.sized        = sized;
		this.growing      = growing;
		this.moving       = moving;
		this.game         = game;
		this.collision    = collision;}

	public void addCollision(CollidesWithPlayer collision){
		this.collision = collision;}

	public void tick(double seconds){
		growing.tick(seconds);
		sized.tick(seconds);
		moving.tick(seconds);
		positionable.tick(seconds);
		collision.tick(seconds);}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(sized.get());}

	public Size getSize(){
		return sized.get();}}
