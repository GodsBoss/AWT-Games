package org.godsboss.gaming.physics2d;

public class Size{
	private final double width;
	private final double height;

	public Size(double width, double height){
		this.width = width;
		this.height = height;}

	public Size(double size){
		this(size, size);}

	public double getWidth(){
		return width;}

	public double getHeight(){
		return height;}

	public Size times(double factor){
		return new Size(factor*width, factor*height);}}
