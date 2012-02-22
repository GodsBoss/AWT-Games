package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;

class Player{
	private Position position;
	private Size size;

	public Player(Position initialPosition, Size size){
		position = initialPosition;
		this.size = size;}

	public Position getPosition(){
		return position;}

	public Bounds toBounds(){
		return position.centerBoundsWithSize(size);}

	public void moveTo(Position newPosition){
		position = newPosition;}}
