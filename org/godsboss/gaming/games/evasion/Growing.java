package org.godsboss.gaming.games.evasion;

class Growing{
	private Sized sized;

	public Growing(Sized sized){
		this.sized = sized;}

	public void tick(double seconds){
		sized.resize(sized.get().plus(seconds, seconds));}}
