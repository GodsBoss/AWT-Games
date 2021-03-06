package org.godsboss.gcomp.physics2d;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Bounds;

public class BoundedPositioning implements Component{
	private final Positionable positionable;
	private final Bounds bounds;

	public BoundedPositioning(Positionable positionable, Bounds bounds){
		this.positionable = positionable;
		this.bounds = bounds;}

	public void tick(double seconds){
		positionable.moveTo(positionable.getNext().modulo(bounds));}}
