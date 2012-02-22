package org.godsboss.gaming.gui;

import java.awt.Canvas;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

class WindowImpl implements Window{
	private String title;
	private int width;
	private int height;
	private JFrame frame;
	private Canvas canvas;
	public BufferStrategy buffer;

	public WindowImpl(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;}

	public void init(){
		if (frame == null){
			frame = new JFrame(title);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			canvas = new Canvas();
			canvas.setSize(width, height);
			frame.add(canvas);
			frame.pack();
			frame.setVisible(true);
			canvas.createBufferStrategy(2);
			buffer = canvas.getBufferStrategy();}}

	public BufferStrategy getBuffer(){
		return buffer;}

	public void addMouseListener(MouseListener listener){
		canvas.addMouseListener(listener);}

	public void addMouseMotionListener(MouseMotionListener listener){
		canvas.addMouseMotionListener(listener);}

	public void addWindowListener(WindowListener listener){
		frame.addWindowListener(listener);}}
