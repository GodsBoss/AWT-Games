package org.godsboss.gcomp.physics2d;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Velocity;

public class Moving implements Component{
	private final Positionable positionable;
	private Velocity velocity;

	public Moving(Positionable positionable, Velocity velocity){
		this.positionable = positionable;
		this.velocity = velocity;}

	public void tick(double seconds){
		positionable.moveTo(positionable.getNext().plus(velocity.times(seconds)));}}
