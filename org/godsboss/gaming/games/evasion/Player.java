package org.godsboss.gaming.games.evasion;

class Player{
	private int x;
	private int y;

	public Player(int initialX, int initialY){
		x = initialX;
		y = initialY;}

	public int getX(){
		return x;}

	public int getY(){
		return y;}

	public void moveTo(int newX, int newY){
		x = newX;
		y = newY;}}
