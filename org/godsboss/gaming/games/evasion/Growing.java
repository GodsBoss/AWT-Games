package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;

class Growing implements Component{
	private Sized sized;

	public Growing(Sized sized){
		this.sized = sized;}

	public void tick(double seconds){
		sized.resize(sized.getNext().plus(seconds, seconds));}}
