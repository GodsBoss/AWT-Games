package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Entity;
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
			game.getPlayer().render(g);
			drawScore(g);}
		drawHighScore(g);}

	private void clear(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());}

	private void drawGameOver(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Game over", 300, 230);
		g.drawString("Click for a new game", 280, 250);}

	private void drawEnemies(Graphics g){
		for(Entity enemy: game.getEnemies()){
			enemy.render(g);}}

	private void drawScore(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Your score: " + game.getScore(), 20, 40);}

	private void drawHighScore(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("High score: " + game.getHighScore(), 20, 20);}}
