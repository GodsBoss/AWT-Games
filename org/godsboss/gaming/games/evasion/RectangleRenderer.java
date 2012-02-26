package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.gui.Renderer;
import org.godsboss.gaming.physics2d.Bounds;

import java.awt.Color;
import java.awt.Graphics;

class RectangleRenderer implements Renderer{
	private final Color color;
	private final BoundedObject object;

	public RectangleRenderer(BoundedObject object, Color color){
		this.object = object;
		this.color = color;}

	public void drawOnto(Graphics g){
		g.setColor(color);
		Bounds b = object.toBounds();
		g.drawRect((int)b.getLeft(), (int)b.getTop(), (int)b.getWidth(), (int)b.getHeight());}}
