package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;

import java.awt.event.MouseEvent;

class Player{
	private Position position;
	private Position nextPosition;
	private Size size;

	public Player(Position initialPosition, Size size){
		position = initialPosition;
		nextPosition = initialPosition;
		this.size = size;}

	public Position getPosition(){
		return position;}

	public Bounds toBounds(){
		return position.centerBoundsWithSize(size);}

	public void moveTo(Position newPosition){
		nextPosition = newPosition;}

	public void tick(double seconds){
		position = nextPosition;}

	public void handleInput(EventStorage eventStorage){
		if (eventStorage.getMouseMoves().size()>0){
			MouseEvent lastMove = eventStorage.getMouseMoves().getLast();
			moveTo(new Position(lastMove.getX(), lastMove.getY()));}}}
