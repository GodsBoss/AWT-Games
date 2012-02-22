package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.util.Command;

class SpawnEnemy implements Command{
	private Evasion evasion;

	public SpawnEnemy(Evasion evasion){
		this.evasion = evasion;}

	public void call(){
		evasion.addEnemy();}}
