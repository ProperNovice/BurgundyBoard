package controller;

import enums.DiceColor;
import model.Dice;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.Logger;

public class DiceManager {

	private ArrayList<Dice> diceRoundOriginal = new ArrayList<>();
	private ArrayList<Dice> diceAvailableThisRound = new ArrayList<>();
	private ArrayList<Dice> diceFreeActionOriginal = new ArrayList<>();
	private ArrayList<Dice> diceFreeAction = new ArrayList<>();
	private ArrayList<Dice> diceCurrentlyShowing = null;
	private CoordinatesLinear coordinatesLinear = null;

	public DiceManager() {

		createDice();
		createCoordinatesLinear();

	}

	private void createDice() {

		// dice original

		this.diceRoundOriginal.addLast(new Dice(DiceColor.RED));
		this.diceRoundOriginal.addLast(new Dice(DiceColor.RED));
		this.diceRoundOriginal.addLast(new Dice(DiceColor.GRAY));

		// dice free action

		for (int counter = 1; counter <= 6; counter++) {

			Dice dice = new Dice(DiceColor.RED);
			dice.setValue(counter);
			this.diceFreeAction.addLast(dice);

		}

	}

	private void createCoordinatesLinear() {

		this.coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsDice.x)
				.height(Credentials.DimensionsDice.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesDice.x).yPointOfInterest(Credentials.CoordinatesDice.y)
				.nodesPerRow(3).createCoordinatesLinear();

	}

	public void rollDiceAndRelocate() {

		this.diceAvailableThisRound.addAll(this.diceRoundOriginal);

		for (Dice dice : this.diceAvailableThisRound) {

			dice.relocate(this.coordinatesLinear.getX(this.diceAvailableThisRound.indexOf(dice)),
					this.coordinatesLinear.getY(this.diceAvailableThisRound.indexOf(dice)));

			dice.rollDice();
			dice.setVisible(true);

		}

		Logger.newLine();

	}

	public int getDiceGrayValue() {
		return this.diceAvailableThisRound.getLast().getDiceValue();
	}

	public void setDiceGrayInactive() {

		this.diceAvailableThisRound.getLast().setVisible(false);
		this.diceAvailableThisRound.removeLast();

	}

	public void removeDiceFromAction(Dice dice) {

		this.diceAvailableThisRound.remove(dice);
		dice.setVisible(false);

	}

	public int diceAvailableThisRoundAmount() {
		return this.diceAvailableThisRound.size();
	}

	public Dice getFirstDieAvailableThisRound() {
		return this.diceAvailableThisRound.getFirst();
	}

	public void testSetRedDiceValuesAndRelocate(int diceValueFirst, int diceValueSecond) {

		this.diceAvailableThisRound.addAll(this.diceRoundOriginal);
		this.diceAvailableThisRound.removeLast();

		this.diceAvailableThisRound.get(0).setValue(diceValueFirst);
		this.diceAvailableThisRound.get(1).setValue(diceValueSecond);

		for (Dice dice : this.diceAvailableThisRound) {

			dice.relocate(this.coordinatesLinear.getX(this.diceAvailableThisRound.indexOf(dice)),
					this.coordinatesLinear.getY(this.diceAvailableThisRound.indexOf(dice)));

			dice.setVisible(true);

		}

		Logger.newLine();

	}

	public void testRemoveDiceFromAction(int index) {

		Dice dice = this.diceAvailableThisRound.get(index);
		removeDiceFromAction(dice);

	}

	public void setDiceCurrentlyShowingAvailableCurrentRound() {
		this.diceCurrentlyShowing = this.diceAvailableThisRound;
	}

	public void setDiceCurrentlyShowingFreeAction() {
		this.diceCurrentlyShowing = this.diceFreeAction;
	}

}
