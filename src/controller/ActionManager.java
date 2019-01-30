package controller;

import enums.ActionEnum;
import model.Action;
import utils.ArrayList;

public class ActionManager {

	private ArrayList<Action> actionsOriginal = new ArrayList<>();

	public ActionManager() {
		createActions();
	}

	private void createActions() {

		for (ActionEnum actionEnum : ActionEnum.values())
			this.actionsOriginal.addLast(new Action(actionEnum));

	}

}
