package org.godsboss.gaming.games.evasion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StartGameOnClick extends MouseAdapter{
	private final Game game;

	public StartGameOnClick(Game game){
		this.game = game;}

	public void mouseClicked(MouseEvent event){
		game.startGame();}}
