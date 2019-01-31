package controller;

import enums.ActionEnum;
import model.Action;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.Logger;

public class ActionManager {

	private ArrayList<Action> actionsOriginal = new ArrayList<>();
	private ArrayList<Action> actionsShowing = new ArrayList<>();
	private CoordinatesLinear coordinatesLinear = null;

	public ActionManager() {

		createActions();

		this.coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsAction.x)
				.height(Credentials.DimensionsAction.y).gapBetweenNodes(1)
				.xPointOfInterest(Credentials.CoordinatesActions.x).yPointOfInterest(Credentials.CoordinatesActions.y)
				.nodesPerRow(10).createCoordinatesLinear();

	}

	private void createActions() {

		for (ActionEnum actionEnum : ActionEnum.values())
			this.actionsOriginal.addLast(new Action(actionEnum));

	}

	public void showActions(ArrayList<ActionEnum> actionsToShow) {

		Logger.log("available actions");

		ActionEnum actionEnum = null;

		for (Action action : this.actionsOriginal) {

			actionEnum = action.getActionEnum();

			if (actionsToShow.contains(actionEnum)) {

				this.actionsShowing.addLast(action);
				Logger.log(actionEnum);
			}

		}

		Logger.newLine();

		relocateActionsAndSetVisibleTrue();

	}

	public void showAction(ActionEnum actionEnumToShow) {

		Logger.log("available action");
		Logger.logNewLine(actionEnumToShow);

		ActionEnum actionEnum = null;

		for (Action action : this.actionsOriginal) {

			actionEnum = action.getActionEnum();

			if (actionEnum == actionEnumToShow) {
				this.actionsShowing.addLast(action);
			}

		}

		relocateActionsAndSetVisibleTrue();

	}

	private void relocateActionsAndSetVisibleTrue() {

		double x, y;

		for (Action action : this.actionsShowing) {

			x = this.coordinatesLinear.getX(this.actionsShowing.indexOf(action));
			y = this.coordinatesLinear.getY(this.actionsShowing.indexOf(action));

			action.relocate(x, y);
			action.setVisible(true);

		}

	}

	public void concealActions() {

		for (Action action : this.actionsShowing) {
			action.setVisible(false);
		}

		this.actionsShowing.clear();

	}

}
