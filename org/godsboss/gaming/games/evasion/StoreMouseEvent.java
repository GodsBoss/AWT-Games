package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class StoreMouseEvent implements MouseListener, MouseMotionListener{
	private final Game game;

	public StoreMouseEvent(Game game){
		this.game = game;}

	public void mouseClicked(MouseEvent event){
		game.mouseClicked(new Position(event.getX(), event.getY()));}

	public void mouseEntered(MouseEvent event){}

	public void mouseExited(MouseEvent event){}

	public void mousePressed(MouseEvent event){}

	public void mouseReleased(MouseEvent event){}

	public void mouseDragged(MouseEvent event){}

	public void mouseMoved(MouseEvent event){
		game.mouseMoved(new Position(event.getX(), event.getY()));}}
