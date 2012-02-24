package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Position;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StoreClickOnClick extends MouseAdapter{
	private final Game game;

	public StoreClickOnClick(Game game){
		this.game = game;}

	public void mouseClicked(MouseEvent event){
		game.mouseClicked(new Position(event.getX(), event.getY()));}}
