package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.app.Loop;
import org.godsboss.gaming.app.Step;
import org.godsboss.gaming.control.LoopShutdownWindowListener;
import org.godsboss.gaming.gui.Factory;
import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.gui.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class Evasion implements MouseMotionListener, Renderer, Step{
	private boolean isGameOver = true;
	private int x = 320;
	private int y = 240;
	private int size = 20;
	private LinkedList<Enemy> enemies;
	private double intervalBetweenEnemyCreations = .333;
	private double timeUntilNextEnemy;
	private double enemySpeed = 80;
	private int highScore = 0;
	private Window win;
	private Loop loop;

	public static void main(String[] args){
		Evasion evasion = new Evasion();
		evasion.start();}

	public void start(){
		win = Factory.createWindow("Evasion", 640, 480);
		win.addMouseListener(new StartGameOnClick(this));
		win.addMouseMotionListener(this);
		loop = new Loop(this, 15);
		win.addWindowListener(new LoopShutdownWindowListener(loop));
		loop.start();}

	public void tick(double seconds){
		update(seconds);
		render(seconds);}

	private void update(double seconds){
		if (isGameOver){}
		else{
			timeUntilNextEnemy -= seconds;
			if (timeUntilNextEnemy < 0){
				addEnemy();
				timeUntilNextEnemy += intervalBetweenEnemyCreations;}
			for(Enemy enemy: enemies){
				enemy.tick(seconds);
				double ex = enemy.getX();
				double ey = enemy.getY();
				if (Math.abs(ex - x) < size && Math.abs(ey - y) < size){
					endGame();}}}}

	private void render(double seconds){
		win.render(this);}

	public void drawOnto(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 480);
		g.setColor(Color.WHITE);
		g.drawString("High score: " + highScore, 20, 20);
		if (isGameOver){
			showGameOver(g);}
		else{
			drawPlayer(g);
			drawEnemies(g);
			drawScore(g);}}

	private void showGameOver(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Game over", 300, 230);
		g.drawString("Click for a new game", 280, 250);}

	public void startGame(){
		if (isGameOver){
			timeUntilNextEnemy = intervalBetweenEnemyCreations;
			enemies = new LinkedList<Enemy>();
			isGameOver = false;
			addEnemy();}}

	private void endGame(){
		highScore = Math.max(enemies.size(), highScore);
		isGameOver = true;}

	private void addEnemy(){
		double enemyX = (x + 320) % 640;
		double enemyY = (y + 240) % 480;
		double angle = Math.random() * 2 * Math.PI;
		double enemyDx = Math.sin(angle) * enemySpeed;
		double enemyDy = Math.cos(angle) * enemySpeed;
		Enemy enemy = new Enemy(enemyX, enemyY, enemyDx, enemyDy);
		enemies.add(enemy);}

	private void drawPlayer(Graphics g){
		g.setColor(Color.GREEN);
		g.drawRect(x - size / 2, y - size / 2, size, size);}

	private void drawEnemies(Graphics g){
		g.setColor(Color.RED);
		for(Enemy enemy: enemies){
			g.drawRect((int)enemy.getX() - size/2, (int)enemy.getY() - size/2, size, size);}}

	private void drawScore(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Your score: " + enemies.size(), 20, 40);}

	public void mouseDragged(MouseEvent e){}

	public void mouseMoved(MouseEvent e){
			x = e.getX();
			y = e.getY();}}
