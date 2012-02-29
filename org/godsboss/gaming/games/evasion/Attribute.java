package org.godsboss.gaming.games.evasion;

import org.godsboss.gaming.ecs.Component;

class Attribute<Type> implements Component{
	private Type actualValue;
	private Type nextValue;

	public Attribute(Type initialValue){
		actualValue = initialValue;
		nextValue = initialValue;}

	public Type get(){
		return actualValue;}

	public Type getNext(){
		return nextValue;}

	public void setNext(Type newValue){
		nextValue = newValue;}

	public void tick(double seconds){
		actualValue = nextValue;}}
