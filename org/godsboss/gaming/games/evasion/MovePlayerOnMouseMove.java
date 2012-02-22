package org.godsboss.gaming.games.evasion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class MovePlayerOnMouseMove extends MouseMotionAdapter{
	private final Evasion evasion;

	public MovePlayerOnMouseMove(Evasion evasion){
		this.evasion = evasion;}

	public void mouseMoved(MouseEvent e){
		evasion.setPlayerPosition(e.getX(), e.getY());}}
