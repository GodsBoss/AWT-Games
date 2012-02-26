package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.control.EventStorage;
import org.godsboss.gaming.ecs.Control;
import org.godsboss.gaming.gui.Renderer;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

class Player{
	private Positionable positionable;
	private Sized sized;
	private Renderer renderer;
	private Control control;

	public Player(Positionable positionable, Sized sized, Renderer renderer, Control control){
		this.positionable = positionable;
		this.sized = sized;
		this.renderer = renderer;
		this.control = control;}

	public void tick(double seconds){
		positionable.tick(seconds);}

	public void handleInput(EventStorage eventStorage){
		control.handleInput(eventStorage);}

	public void render(Graphics g){
		renderer.drawOnto(g);}}
