package org.godsboss.gaming.games.evasion;

class Enemy{
	private double x;
	private double y;
	private double dx;
	private double dy;

	public Enemy(double startX, double startY, double startDx, double startDy){
		x = startX;
		y = startY;
		dx = startDx;
		dy = startDy;}

	public void tick(double seconds){
		x = (x + dx * seconds + 640) % 640;
		y = (y + dy * seconds + 480) % 480;}

	public double getX(){
		return x;}

	public double getY(){
		return y;}}
