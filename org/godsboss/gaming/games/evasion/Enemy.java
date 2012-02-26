package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class Enemy{
	private Positionable positionable;
	private Moving moving;
	private Sized sized;
	private Game game;

	public Enemy(Positionable positionable, Moving moving, Sized sized, Game game){
		this.positionable = positionable;
		this.sized        = sized;
		this.moving       = moving;
		this.game         = game;}

	public void tick(double seconds){
		sized.resize(sized.get().plus(seconds, seconds));
		sized.tick(seconds);
		moving.tick(seconds);
		positionable.tick(seconds);
		if (game.getPlayer().overlapsWith(getPosition().centerBoundsWithSize(getSize()))){
			game.endGame();}}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(sized.get());}

	public Size getSize(){
		return sized.get();}}
