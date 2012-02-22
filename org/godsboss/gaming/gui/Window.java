package org.godsboss.gaming.gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

public interface Window{
	public BufferStrategy getBuffer();
	public void addMouseListener(MouseListener listener);
	public void addMouseMotionListener(MouseMotionListener listener);
	public void addWindowListener(WindowListener listener);}
