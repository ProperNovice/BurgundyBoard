package controller;

import enums.GameStateEnum;
import utils.ArrayList;

public class GroupActionsManager {

	private ArrayList<GameStateEnum> groupActionsList = new ArrayList<>();

	public GroupActionsManager() {

	}

	public void clearGroupActions() {
		this.groupActionsList.clear();
	}

	public void addGroupAction(GameStateEnum gameStateEnum) {
		this.groupActionsList.addLast(gameStateEnum);
	}

	public ArrayList<GameStateEnum> getGroupActionsList() {
		return this.groupActionsList;
	}

}
