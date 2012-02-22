package org.godsboss.gaming.physics2d;

public class Bounds{
	private final double left;
	private final double top;
	private final double right;
	private final double bottom;

	public Bounds(double left, double top, double right, double bottom){
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;}

	public double getLeft(){
		return left;}

	public double getTop(){
		return top;}

	public double getRight(){
		return right;}

	public double getBottom(){
		return bottom;}

	public double getWidth(){
		return right - left;}

	public double getHeight(){
		return bottom - top;}

	public Size getSize(){
		return new Size(right - left, bottom - top);}

	public Position getCenter(){
		return new Position((right - left)/2, (bottom - top)/2);}

	public boolean doesOverlap(Bounds bounds){
		return bounds.getLeft() <= right && bounds.getRight() >= left && bounds.getTop() <= bottom && bounds.getBottom() >= top;}}
