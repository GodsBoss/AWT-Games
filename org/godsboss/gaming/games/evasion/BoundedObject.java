package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.physics2d.Bounds;

class BoundedObject{
	private final Positionable positionable;
	private final Sized sized;

	public BoundedObject(Positionable positionable, Sized sized){
		this.positionable = positionable;
		this.sized = sized;}

	public boolean overlaps(BoundedObject other){
		return other.overlaps(positionable.get().centerBoundsWithSize(sized.get()));}

	public boolean overlaps(Bounds bounds){
		return bounds.doesOverlap(positionable.get().centerBoundsWithSize(sized.get()));}}
