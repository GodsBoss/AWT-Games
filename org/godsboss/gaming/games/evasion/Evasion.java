package org.godsboss.gaming.games.evasion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import javax.swing.JFrame;

public class Evasion implements Runnable, WindowListener, MouseListener, MouseMotionListener{
	private boolean isGameOver = true;
	private boolean isRunning = false;
	private JFrame frame;
	private Canvas canvas;
	private BufferStrategy buffer;
	private Thread thread;
	private int x = 320;
	private int y = 240;
	private int size = 20;
	private LinkedList<Enemy> enemies;
	private int intervalBetweenEnemyCreations = 1;
	private double timeUntilNextEnemy;
	private int stepInterval = 15;
	private double enemySpeed = 80;
	private int highScore = 0;

	public static void main(String[] args){
		Evasion evasion = new Evasion();
		evasion.start();}

	public void start(){
		frame = new JFrame("Evasion");
		canvas = new Canvas();
		canvas.setSize(640, 480);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);
		frame.pack();
		frame.setVisible(true);
		canvas.createBufferStrategy(2);
		buffer = canvas.getBufferStrategy();
		isRunning = true;
		thread = new Thread(this);
		thread.start();}

	public void run(){
		while(isRunning){
			try{
				step();
				Thread.sleep(stepInterval);}
			catch(InterruptedException e){}}}

	private void step(){
		update();
		render();}

	private void update(){
		if (isGameOver){}
		else{
			timeUntilNextEnemy -= stepInterval / 1000.0;
			if (timeUntilNextEnemy < 0){
				addEnemy();
				timeUntilNextEnemy += intervalBetweenEnemyCreations;}
			for(Enemy enemy: enemies){
				enemy.tick(stepInterval / 1000.0);
				double ex = enemy.getX();
				double ey = enemy.getY();
				if (Math.abs(ex - x) < size && Math.abs(ey - y) < size){
					endGame();}}}}

	private void render(){
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 480);
		g.setColor(Color.WHITE);
		g.drawString("High score: " + highScore, 20, 20);
		if (isGameOver){
			showGameOver(g);}
		else{
			drawPlayer(g);
			drawEnemies(g);
			drawScore(g);}
		buffer.show();}

	private void showGameOver(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Game over", 300, 230);
		g.drawString("Click for a new game", 280, 250);}

	private void initGame(){
		timeUntilNextEnemy = intervalBetweenEnemyCreations;
		enemies = new LinkedList<Enemy>();
		isGameOver = false;
		addEnemy();}

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

	public void mouseClicked(MouseEvent e){}

	public void mouseEntered(MouseEvent e){}

	public void mouseExited(MouseEvent e){}

	public void mousePressed(MouseEvent e){}

	public void mouseReleased(MouseEvent e){
		if (isGameOver){
			initGame();}}

	public void mouseDragged(MouseEvent e){}

	public void mouseMoved(MouseEvent e){
			x = e.getX();
			y = e.getY();}

	public void windowActivated(WindowEvent e){}

	public void windowClosed(WindowEvent e){
		isRunning = false;}

	public void windowClosing(WindowEvent e){}

	public void windowDeactivated(WindowEvent e){}

	public void windowDeiconified(WindowEvent e){}

	public void windowIconified(WindowEvent e){}

	public void windowOpened(WindowEvent e){}}
