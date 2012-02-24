package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.app.Loop;
import org.godsboss.gaming.app.Step;
import org.godsboss.gaming.control.LoopShutdownWindowListener;
import org.godsboss.gaming.gui.Factory;
import org.godsboss.gaming.gui.Window;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Position;
import org.godsboss.gaming.physics2d.Size;
import org.godsboss.gaming.physics2d.Velocity;
import org.godsboss.gaming.util.RegularExecutor;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Game implements Step{
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
		win.render(output);}

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

	public int getWidth(){
		return (int)bounds.getWidth();}

	public int getHeight(){
		return (int)bounds.getHeight();}

	public boolean isOver(){
		return isGameOver;}

	public Player getPlayer(){
		return player;}

	public List<Enemy> getEnemies(){
		return enemies;}

	public int getHighScore(){
		return highScore;}}
