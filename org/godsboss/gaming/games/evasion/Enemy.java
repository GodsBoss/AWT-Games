package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

class Enemy{
	private Position position;
	private Velocity velocity;
	private Size size;
	private Bounds bounds;

	public Enemy(Position position, Velocity velocity, Size size, Bounds bounds){
		this.position = position;
		this.velocity = velocity;
		this.size     = size;
		this.bounds   = bounds;}

	public void tick(double seconds){
		size = size.plus(seconds, seconds);
		position = position.plus(velocity.times(seconds)).modulo(bounds);}

	public Position getPosition(){
		return position;}

	public Bounds toBounds(){
		return position.centerBoundsWithSize(size);}

	public Size getSize(){
		return size;}}
