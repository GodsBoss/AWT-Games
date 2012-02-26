package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;
import org.godsboss.gaming.physics2d.Position;

class Positionable implements Component{
	private Position position;
	private Position nextPosition;

	public Positionable(Position initialPosition){
		position = initialPosition;
		nextPosition = initialPosition;}

	public Position get(){
		return position;}

	public void moveTo(Position newPosition){
		nextPosition = newPosition;}

	public void tick(double seconds){
		position = nextPosition;}}
