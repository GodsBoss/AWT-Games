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
import org.godsboss.gaming.util.RegularExecutor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Game implements Renderer, Step{
	private boolean isGameOver = true;
	private LinkedList<Enemy> enemies;
	private double enemySpeed = 80;
	private int highScore = 0;
	private Bounds bounds = new Bounds(0, 0, 640, 480);
	private Player player = new Player(bounds.getCenter(), new Size(20, 20));
	private Window win;
	private Loop loop;
	private RegularExecutor enemySpawner;
	private Output output;

	public void start(){
		win = Factory.createWindow("Evasion", (int)bounds.getWidth(), (int)bounds.getHeight());
		win.addMouseListener(new StartGameOnClick(this));
		win.addMouseMotionListener(new MovePlayerOnMouseMove(player));
		loop = new Loop(this, 15);
		win.addWindowListener(new LoopShutdownWindowListener(loop));
		enemySpawner = new RegularExecutor(new SpawnEnemy(this), 0.333);
		output = new Output(this, win);
		loop.start();}

	public void tick(double seconds){
		update(seconds);
		render(seconds);}

	private void update(double seconds){
		if (isGameOver){}
		else{
			enemySpawner.pass(seconds);
			for(Enemy enemy: enemies){
				enemy.tick(seconds);
				if (player.toBounds().doesOverlap(enemy.getPosition().centerBoundsWithSize(enemy.getSize()))){
					endGame();}}}}

	private void render(double seconds){
		win.render(this);}

	public void drawOnto(Graphics g){
		output.drawOnto(g);
		g.setColor(Color.WHITE);
		g.drawString("High score: " + highScore, 20, 20);
		if (isGameOver){}
		else{
			drawPlayer(g);
			drawEnemies(g);
			drawScore(g);}}

	public void startGame(){
		if (isGameOver){
			enemies = new LinkedList<Enemy>();
			isGameOver = false;
			addEnemy();}}

	private void endGame(){
		highScore = Math.max(enemies.size(), highScore);
		isGameOver = true;}

	public void addEnemy(){
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
		g.drawString("Your score: " + enemies.size(), 20, 40);}

	public int getWidth(){
		return (int)bounds.getWidth();}

	public int getHeight(){
		return (int)bounds.getHeight();}

	public boolean isOver(){
		return isGameOver;}}
