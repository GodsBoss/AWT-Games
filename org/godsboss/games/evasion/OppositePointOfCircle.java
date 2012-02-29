package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.PositionDifference;
import org.godsboss.gaming.physics2d.Velocity;
import org.godsboss.gcomp.physics2d.Positionable;

class OppositePointOfCircle implements Component{
	private final Position center;
	private final Positionable conterpart;
	private final Positionable self;
	private final double distance;

	public OppositePointOfCircle(Positionable self, Positionable conterpart, Position center, double distance){
		this.self = self;
		this.conterpart = conterpart;
		this.center = center;
		this.distance = distance;}

	public void tick(double seconds){
		PositionDifference diff = center.minus(conterpart.get());
		if (diff.getHorizontal() != 0 || diff.getVertical() != 0){
			self.moveTo(center.plus(Velocity.fromPositionDifference(diff).normalize().times(distance)));}}}
