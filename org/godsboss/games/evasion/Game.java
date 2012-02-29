package org.godsboss.games.evasion;

import org.godsboss.gaming.app.Loop;
import org.godsboss.gaming.app.Step;
import org.godsboss.gaming.control.EventStorage;
import org.godsboss.gaming.control.LoopShutdownWindowListener;
import org.godsboss.gaming.ecs.Entity;
import org.godsboss.gaming.gui.Factory;
import org.godsboss.gaming.gui.Window;
import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gaming.physics2d.Size;

import java.util.LinkedList;
import java.util.List;

public class Game implements Step{
	private final GameConfiguration config;
	private boolean isGameOver = true;
	private LinkedList<Entity> enemies;
	private int highScore = 0;
	private Bounds bounds = new Bounds(0, 0, 640, 480);
	private Loop loop;
	private Entity enemySpawner;
	private Output output;
	private EventStorage eventStorage;
	private ObjectFactory factory;
	private Entity player;

	public Game(GameConfiguration config){
		this.config = config;}

	public void start(){
		factory = new ObjectFactory(config, this, bounds);
		Window win = Factory.createWindow("Evasion", (int)bounds.getWidth(), (int)bounds.getHeight());
		eventStorage = new EventStorage();
		win.addMouseListener(eventStorage);
		win.addMouseMotionListener(eventStorage);
		loop = new Loop(this, 15);
		win.addWindowListener(new LoopShutdownWindowListener(loop));
		player = factory.createPlayer(bounds.getCenter(), new Size(20, 20));
		enemySpawner = factory.createEnemySpawner(0.333);
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
			player.tick(seconds);
			enemySpawner.tick(seconds);
			for(Entity enemy: enemies){
				enemy.tick(seconds);}}}

	private void render(double seconds){
		output.render(seconds);}

	private void startGame(){
		if (isGameOver){
			enemies = new LinkedList<Entity>();
			isGameOver = false;}}

	public void endGame(){
		highScore = Math.max(enemies.size(), highScore);
		isGameOver = true;}

	public void addEnemy(Entity enemy){
		enemies.add(enemy);}

	public int getWidth(){
		return (int)bounds.getWidth();}

	public int getHeight(){
		return (int)bounds.getHeight();}

	public boolean isOver(){
		return isGameOver;}

	public Entity getPlayer(){
		return player;}

	public List<Entity> getEnemies(){
		return enemies;}

	public int getScore(){
		return enemies.size();}

	public int getHighScore(){
		return highScore;}

	public Bounds getBounds(){
		return bounds;}}
