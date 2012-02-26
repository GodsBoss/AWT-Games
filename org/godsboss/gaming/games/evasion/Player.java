package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;

import java.awt.event.MouseEvent;

class Player{
	private Positionable positionable;
	private Sized sized;

	public Player(Positionable positionable, Sized sized){
		this.positionable = positionable;
		this.sized = sized;}

	public Position getPosition(){
		return positionable.get();}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(sized.get());}

	public void moveTo(Position newPosition){
		positionable.moveTo(newPosition);}

	public boolean overlapsWith(Bounds bounds){
		return bounds.doesOverlap(positionable.get().centerBoundsWithSize(sized.get()));}

	public void tick(double seconds){
		positionable.tick(seconds);}

	public void handleInput(EventStorage eventStorage){
		if (eventStorage.getMouseMoves().size()>0){
			MouseEvent lastMove = eventStorage.getMouseMoves().getLast();
			positionable.moveTo(new Position(lastMove.getX(), lastMove.getY()));}}}
