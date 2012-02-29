package org.godsboss.gcomp.physics2d;

import org.godsboss.gaming.ecs.Attribute;
import org.godsboss.gaming.physics2d.Position;

public class Positionable extends Attribute<Position>{
	public Positionable(Position initialPosition){
		super(initialPosition);}

	public void moveTo(Position newPosition){
		setNext(newPosition);}}
