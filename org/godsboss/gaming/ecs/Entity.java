package org.godsboss.gaming.ecs;

import org.godsboss.gaming.gui.Renderer;

import java.awt.Graphics;
import java.util.LinkedList;

public class Entity{
	private LinkedList<Component> components = new LinkedList<Component>();
	private Renderer renderer;

	public Entity(Renderer renderer){
		this.renderer = renderer;}

	public void addComponent(Component component){
		components.add(component);}

	public void tick(double seconds){
		for(Component component: components){
			component.tick(seconds);}}

	public void render(Graphics g){
		renderer.drawOnto(g);}}
