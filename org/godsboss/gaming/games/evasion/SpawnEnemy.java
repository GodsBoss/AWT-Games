package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.util.Command;

class SpawnEnemy implements Command{
	private Game game;

	public SpawnEnemy(Game game){
		this.game = game;}

	public void call(){
		game.addEnemy();}}
