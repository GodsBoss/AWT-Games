package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

class Player{
	private Positionable positionable;
	private Sized sized;
	private Renderer renderer;

	public Player(Positionable positionable, Sized sized, Renderer renderer){
		this.positionable = positionable;
		this.sized = sized;
		this.renderer = renderer;}

	public void tick(double seconds){
		positionable.tick(seconds);}

	public void handleInput(EventStorage eventStorage){
		if (eventStorage.getMouseMoves().size()>0){
			MouseEvent lastMove = eventStorage.getMouseMoves().getLast();
			positionable.moveTo(new Position(lastMove.getX(), lastMove.getY()));}}

	public void render(Graphics g){
		renderer.drawOnto(g);}}
