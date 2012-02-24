package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.gui.Window;

import java.awt.Color;
import java.awt.Graphics;

class Output implements Renderer{
	private final Game game;
	private final Window window;

	public Output(Game game, Window window){
		this.game  = game;
		this.window = window;}

	public void render(double seconds){
		window.render(this);}

	public void drawOnto(Graphics g){
		clear(g);
	}

	private void clear(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());}
}
