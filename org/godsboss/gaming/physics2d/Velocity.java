package org.godsboss.gaming.physics2d;

public class Velocity{
	private final double horizontal;
	private final double vertical;

	public Velocity(double horizontal, double vertical){
		this.horizontal = horizontal;
		this.vertical = vertical;}

	public static Velocity randomDirection(double speed){
		double angle = Math.random() * 2 * Math.PI;
		return new Velocity(Math.sin(angle)*speed, Math.cos(angle)*speed);}

	public double getHorizontal(){
		return horizontal;}

	public double getVertical(){
		return vertical;}

	public double getSpeed(){
		return Math.sqrt(horizontal*horizontal + vertical*vertical);}

	public Velocity normalize(){
		return this.times(1 / this.getSpeed());}

	public Velocity times(double factor){
		return new Velocity(factor*horizontal, factor*vertical);}}
