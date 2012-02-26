package org.godsboss.gaming.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

public class EventStorage implements MouseListener, MouseMotionListener{
	private LinkedList<MouseEvent> clicks = new LinkedList<MouseEvent>();
	private LinkedList<MouseEvent> moves  = new LinkedList<MouseEvent>();

	public LinkedList<MouseEvent> getMouseClicks(){
		return clicks;}

	public LinkedList<MouseEvent> getMouseMoves(){
		return moves;}

	public void clear(){
		clicks.clear();
		moves.clear();}

	public void mouseClicked(MouseEvent event){
		clicks.add(event);}

	public void mouseEntered(MouseEvent event){}

	public void mouseExited(MouseEvent event){}

	public void mousePressed(MouseEvent event){}

	public void mouseReleased(MouseEvent event){}

	public void mouseDragged(MouseEvent event){}

	public void mouseMoved(MouseEvent event){
		moves.add(event);}}
