package org.godsboss.gaming.games.evasion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StartGameOnClick extends MouseAdapter{
	private final Evasion evasion;

	public StartGameOnClick(Evasion evasion){
		this.evasion = evasion;}

	public void mouseClicked(MouseEvent event){
		evasion.startGame();}}
