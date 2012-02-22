package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class MovePlayerOnMouseMove extends MouseMotionAdapter{
	private final Player player;

	public MovePlayerOnMouseMove(Player player){
		this.player = player;}

	public void mouseMoved(MouseEvent e){
		player.moveTo(new Position(e.getX(), e.getY()));}}
