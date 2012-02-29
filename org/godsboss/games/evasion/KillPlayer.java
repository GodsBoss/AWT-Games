package org.godsboss.games.evasion;

import org.godsboss.gaming.util.Command;

class KillPlayer implements Command{
	private final Game game;

	public KillPlayer(Game game){
		this.game = game;}

	public void call(){
		game.endGame();}}
