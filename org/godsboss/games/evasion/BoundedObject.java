package org.godsboss.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;
import org.godsboss.gcomp.physics2d.Sized;

class BoundedObject{
	private final Positionable positionable;
	private final Sized sized;

	public BoundedObject(Positionable positionable, Sized sized){
		this.positionable = positionable;
		this.sized = sized;}

	public Bounds toBounds(){
		return positionable.get().centerBoundsWithSize(sized.get());}

	public boolean overlaps(BoundedObject other){
		return other.overlaps(toBounds());}

	public boolean overlaps(Bounds bounds){
		return bounds.doesOverlap(toBounds());}}
