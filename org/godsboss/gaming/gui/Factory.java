package org.godsboss.gaming.gui;

public class Factory{
	public static Window createWindow(String title, int width, int height){
		WindowImpl win = new WindowImpl(title, width, height);
		win.init();
		return win;}}
