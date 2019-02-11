package controller;

import enums.GameStateEnum;
import utils.ArrayList;
import utils.Logger;

public class GroupActionsManager {

	private ArrayList<GameStateEnum> groupActionsList = new ArrayList<>();

	public GroupActionsManager() {

	}

	public void clearGroupActions() {
		this.groupActionsList.clear();
	}

	public void addGroupAction(GameStateEnum gameStateEnum) {

		Logger.log("adding group action");
		Logger.logNewLine(gameStateEnum);

		this.groupActionsList.addLast(gameStateEnum);

	}

	public void removeGroupAction(GameStateEnum gameStateEnum) {

		Logger.log("removing group action");
		Logger.logNewLine(gameStateEnum);

		this.groupActionsList.remove(gameStateEnum);

	}

	public ArrayList<GameStateEnum> getGroupActionsList() {
		return this.groupActionsList;
	}

}
