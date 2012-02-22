package org.godsboss.gaming.physics2d;

public class Position{
	private final double x;
	private final double y;

	public Position(double x, double y){
		this.x = x;
		this.y = y;}

	public double getX(){
		return x;}

	public double getY(){
		return y;}

	public Position plus(double x, double y){
		return new Position(this.x + x, this.y + y);}

	public Position plus(Velocity velocity){
		return plus(velocity.getHorizontal(), velocity.getVertical());}

	public Position plus(Size size){
		return plus(size.getWidth(), size.getHeight());}

	public Position modulo(Bounds bounds){
		double x = (this.x - bounds.getLeft() + bounds.getWidth())  % bounds.getWidth()  + bounds.getLeft();
		double y = (this.y - bounds.getTop()  + bounds.getHeight()) % bounds.getHeight() + bounds.getTop();
		return new Position(x, y);}

	public Bounds centerBoundsWithSize(double size){
		return centerBoundsWithSize(size, size);}

	public Bounds centerBoundsWithSize(Size size){
		return centerBoundsWithSize(size.getWidth(), size.getHeight());}

	public Bounds centerBoundsWithSize(double width, double height){
		return new Bounds(x-width/2, y-height/2, x+width/2, y+height/2);}}
