package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Attribute;
import org.godsboss.gaming.physics2d.Position;

class Positionable extends Attribute<Position>{
	public Positionable(Position initialPosition){
		super(initialPosition);}

	public void moveTo(Position newPosition){
		setNext(newPosition);}}
