package org.godsboss.gaming.control;

import org.godsboss.gaming.app.Loop;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoopShutdownWindowListener extends WindowAdapter{
	private Loop loop;

	public LoopShutdownWindowListener(Loop loop){
		this.loop = loop;}

	public void windowClosed(WindowEvent e){
		loop.stop();}}
