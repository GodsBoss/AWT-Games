package org.godsboss.gaming.gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

public interface Window{
	public void render(Renderer renderer);
	public void addMouseListener(MouseListener listener);
	public void addMouseMotionListener(MouseMotionListener listener);
	public void addWindowListener(WindowListener listener);}
