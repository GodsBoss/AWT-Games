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
	private int highScore = 0;
	private Bounds bounds = new Bounds(0, 0, 640, 480);
	private Loop loop;
	private RegularExecutor enemySpawner;
	private Output output;
	private EventStorage eventStorage;
	private ObjectFactory factory = new ObjectFactory(this, bounds);
	private Player player = factory.createPlayer(bounds.getCenter(), new Size(20, 20));

	public void start(){
		Window win = Factory.createWindow("Evasion", (int)bounds.getWidth(), (int)bounds.getHeight());
		eventStorage = new EventStorage();
		win.addMouseListener(eventStorage);
		win.addMouseMotionListener(eventStorage);
		loop = new Loop(this, 15);
		win.addWindowListener(new LoopShutdownWindowListener(loop));
		enemySpawner = new RegularExecutor(new SpawnEnemy(this), 0.333);
		output = new Output(this, win);
		loop.start();}

	public void tick(double seconds){
		handleInput();
		update(seconds);
		render(seconds);}

	private void handleInput(){
		if (eventStorage.getMouseClicks().size()>0){
			startGame();}
		player.handleInput(eventStorage);
		eventStorage.clear();}

	private void update(double seconds){
		if (isGameOver){}
		else{
			enemySpawner.pass(seconds);
			for(Enemy enemy: enemies){
				enemy.tick(seconds);}}}

	private void render(double seconds){
		output.render(seconds);}

	private void startGame(){
		if (isGameOver){
			enemies = new LinkedList<Enemy>();
			isGameOver = false;
			addEnemy();}}

	public void endGame(){
		highScore = Math.max(enemies.size(), highScore);
		isGameOver = true;}

	public void addEnemy(){
		Enemy enemy = factory.createEnemy(player.getPosition().plus(bounds.getSize().times(0.5)).modulo(bounds));
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

	public int getScore(){
		return enemies.size();}

	public int getHighScore(){
		return highScore;}}
