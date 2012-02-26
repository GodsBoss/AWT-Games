package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;

import java.awt.event.MouseEvent;

class Player{
	private Positionable positionable;
	private Size size;

	public Player(Positionable positionable, Size size){
		this.positionable = positionable;
		this.size = size;}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(size);}

	public void moveTo(Position newPosition){
		positionable.moveTo(newPosition);}

	public void tick(double seconds){
		positionable.tick(seconds);}

	public void handleInput(EventStorage eventStorage){
		if (eventStorage.getMouseMoves().size()>0){
			MouseEvent lastMove = eventStorage.getMouseMoves().getLast();
			positionable.moveTo(new Position(lastMove.getX(), lastMove.getY()));}}}
