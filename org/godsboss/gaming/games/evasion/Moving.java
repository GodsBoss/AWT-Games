package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Velocity;

class Moving implements Component{
	private final Positionable positionable;
	private final Bounds bounds;
	private Velocity velocity;

	public Moving(Positionable positionable, Bounds bounds, Velocity velocity){
		this.positionable = positionable;
		this.bounds = bounds;
		this.velocity = velocity;}

	public void tick(double seconds){
		positionable.moveTo(positionable.get().plus(velocity.times(seconds)).modulo(bounds));}}
