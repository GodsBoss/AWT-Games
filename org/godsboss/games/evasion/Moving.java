package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Velocity;

class Moving implements Component{
	private final Positionable positionable;
	private Velocity velocity;

	public Moving(Positionable positionable, Velocity velocity){
		this.positionable = positionable;
		this.velocity = velocity;}

	public void tick(double seconds){
		positionable.moveTo(positionable.getNext().plus(velocity.times(seconds)));}}
