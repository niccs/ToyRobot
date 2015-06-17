package com.anz.toyrobot.model;
/**
 * Contains data of toyrobot position and table top.
 * 
 * @author Neetika
 * 
 */
public class RobotModel {

	private TableTop tabletop;
	private Position currentPosition;

	public TableTop getTabletop() {
		return tabletop;
	}

	public void setTabletop(TableTop tabletop) {
		this.tabletop = tabletop;
	}

	public RobotModel(final TableTop tabletop, final Position position) {
		this.tabletop = tabletop;
		this.currentPosition = position;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	@Override
	public String toString() {
		return (currentPosition.toString());
	}
}
