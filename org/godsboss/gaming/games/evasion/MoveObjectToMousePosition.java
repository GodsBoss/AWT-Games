package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.control.EventStorage;
import org.godsboss.gaming.ecs.Control;
import org.godsboss.gaming.physics2d.Position;

import java.awt.event.MouseEvent;

class MoveObjectToMousePosition implements Control{
	private final Positionable positionable;

	public MoveObjectToMousePosition(Positionable positionable){
		this.positionable = positionable;}

	public void handleInput(EventStorage eventStorage){
		if (eventStorage.getMouseMoves().size()>0){
			MouseEvent lastMove = eventStorage.getMouseMoves().getLast();
			positionable.moveTo(new Position(lastMove.getX(), lastMove.getY()));}}}
