package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.app.Loop;
import org.godsboss.gaming.app.Step;
import org.godsboss.gaming.control.LoopShutdownWindowListener;
import org.godsboss.gaming.gui.Factory;
import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.gui.Window;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Evasion implements Renderer, Step{
	private boolean isGameOver = true;
	private LinkedList<Enemy> enemies;
	private double intervalBetweenEnemyCreations = .333;
	private double timeUntilNextEnemy;
	private double enemySpeed = 80;
	private int highScore = 0;
	private Bounds bounds = new Bounds(0, 0, 640, 480);
	private Player player = new Player(bounds.getCenter(), new Size(20, 20));
	private Window win;
	private Loop loop;

	public static void main(String[] args){
		Evasion evasion = new Evasion();
		evasion.start();}

	public void start(){
		win = Factory.createWindow("Evasion", (int)bounds.getWidth(), (int)bounds.getHeight());
		win.addMouseListener(new StartGameOnClick(this));
		win.addMouseMotionListener(new MovePlayerOnMouseMove(player));
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
				if (player.toBounds().doesOverlap(enemy.getPosition().centerBoundsWithSize(enemy.getSize()))){
					endGame();}}}}

	private void render(double seconds){
		win.render(this);}

	public void drawOnto(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight());
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
		Enemy enemy = new Enemy(player.getPosition().plus(bounds.getSize().times(0.5)).modulo(bounds), Velocity.randomDirection(enemySpeed), Size.randomWithin(10, 30), bounds);
		enemies.add(enemy);}

	private void drawPlayer(Graphics g){
		g.setColor(Color.GREEN);
		drawBounds(g, player.toBounds());}

	private void drawEnemies(Graphics g){
		g.setColor(Color.RED);
		for(Enemy enemy: enemies){
			drawBounds(g, enemy.toBounds());}}

	private void drawBounds(Graphics g, Bounds b){
		g.drawRect((int)b.getLeft(), (int)b.getTop(), (int)b.getWidth(), (int)b.getHeight());}

	private void drawScore(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Your score: " + enemies.size(), 20, 40);}}
