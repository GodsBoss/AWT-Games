package org.godsboss.gcomp.physics2d;

import org.godsboss.gaming.ecs.Component;

public class Growing implements Component{
	private Sized sized;

	public Growing(Sized sized){
		this.sized = sized;}

	public void tick(double seconds){
		sized.resize(sized.getNext().plus(seconds, seconds));}}
