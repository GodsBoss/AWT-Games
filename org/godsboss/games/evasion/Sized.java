package org.godsboss.games.evasion;

import org.godsboss.gaming.ecs.Attribute;
import org.godsboss.gaming.physics2d.Size;

class Sized extends Attribute<Size>{
	public Sized(Size initialSize){
		super(initialSize);}

	public void resize(Size newSize){
		setNext(newSize);}}
