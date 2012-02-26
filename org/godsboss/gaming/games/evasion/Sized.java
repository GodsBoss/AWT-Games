package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Size;

class Sized{
	private Size size;
	private Size nextSize;

	public Sized(Size initialSize){
		size = initialSize;
		nextSize = initialSize;}

	public Size get(){
		return size;}

	public void resize(Size newSize){
		nextSize = newSize;}

	public void tick(double seconds){
		size = nextSize;}}
