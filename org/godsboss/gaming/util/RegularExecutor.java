package org.godsboss.gaming.util;

public class RegularExecutor{
	private final double threshold;
	private final Command command;

	private double value = 0;

	public RegularExecutor(Command command, double threshold){
		this.command = command;
		this.threshold = threshold;}

	public void pass(double value){
		this.value += value;
		checkForExecutingCommand();}

	private void checkForExecutingCommand(){
		if (value >= threshold){
			value -= threshold;
			command.call();}}}
