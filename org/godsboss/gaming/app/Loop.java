package org.godsboss.gaming.app;

public class Loop implements Runnable{
	private boolean isRunning = false;
	private Step step;
	private int interval;

	public Loop(Step step, int interval){
		this.step = step;
		this.interval = interval;}

	public void start(){
		Thread thread = new Thread(this);
		thread.start();}

	public void stop(){
		isRunning = false;}

	public void run(){
		isRunning = true;
		while(isRunning){
			step.tick(interval / 1000.0);
			sleep();}}

	private void sleep(){
		try{
			Thread.sleep(interval);}
		catch(InterruptedException e){}}}
