package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.PositionDifference;

class RelativePositioning implements Component{
	private final Positionable self;
	private final Positionable reference;
	private final PositionDifference offset;
	private final Bounds bounds;

	public RelativePositioning(Positionable self, Positionable reference, PositionDifference offset, Bounds bounds){
		this.self = self;
		this.reference = reference;
		this.offset = offset;
		this.bounds = bounds;}

	public void tick(double seconds){
		self.moveTo(reference.get().plus(offset).modulo(bounds));}}
