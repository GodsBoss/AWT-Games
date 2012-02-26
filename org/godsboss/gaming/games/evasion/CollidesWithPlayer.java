package org.godsboss.gaming.games.evasion;import org.godsboss.gaming.ecs.Component;import org.godsboss.gaming.util.Command;class CollidesWithPlayer implements Component{	private final BoundedObject player;	private final BoundedObject self;	private final Command command;	public CollidesWithPlayer(BoundedObject self, BoundedObject player, Command command){		this.self = self;		this.player = player;		this.command = command;}	public void tick(double seconds){		if (self.overlaps(player)){			command.call();}}}