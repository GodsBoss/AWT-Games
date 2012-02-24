package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.gui.Window;
import org.godsboss.gaming.physics2d.Bounds;

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
		if (game.isOver()){
			drawGameOver(g);}
		else{
			drawEnemies(g);
			drawPlayer(g);}}

	private void clear(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());}

	private void drawGameOver(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Game over", 300, 230);
		g.drawString("Click for a new game", 280, 250);}

	private void drawPlayer(Graphics g){
		g.setColor(Color.GREEN);
		drawBounds(g, game.getPlayer().toBounds());}

	private void drawEnemies(Graphics g){
		g.setColor(Color.RED);
		for(Enemy enemy: game.getEnemies()){
			drawBounds(g, enemy.toBounds());}}

	private void drawBounds(Graphics g, Bounds b){
		g.drawRect((int)b.getLeft(), (int)b.getTop(), (int)b.getWidth(), (int)b.getHeight());}}
