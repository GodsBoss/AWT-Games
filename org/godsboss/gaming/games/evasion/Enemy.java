package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class Enemy{
	private Positionable positionable;
	private Moving moving;
	private Size size;
	private Game game;

	public Enemy(Positionable positionable, Moving moving, Size size, Game game){
		this.positionable = positionable;
		this.size         = size;
		this.moving       = moving;
		this.game         = game;}

	public void tick(double seconds){
		size = size.plus(seconds, seconds);
		moving.tick(seconds);
		positionable.tick(seconds);
		if (game.getPlayer().overlapsWith(getPosition().centerBoundsWithSize(getSize()))){
			game.endGame();}}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(size);}

	public Size getSize(){
		return size;}}
