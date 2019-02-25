package controller;

import enums.DiceColor;
import model.Dice;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.Logger;
import utils.SaveLoadAble;

public class DiceManager implements SaveLoadAble {

	private ArrayList<Dice> diceRoundOriginal = new ArrayList<>();
	private ArrayList<Dice> diceRoundAvailable = new ArrayList<>();
	private ArrayList<Dice> diceRoundAvailableSave = new ArrayList<>();
	private ArrayList<Dice> diceFreeActionOriginal = new ArrayList<>();
	private ArrayList<Dice> diceFreeActionAvailable = new ArrayList<>();
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
			this.diceFreeActionOriginal.addLast(dice);

		}

		// set dice currently showing

		this.diceCurrentlyShowing = this.diceRoundAvailable;

	}

	private void createCoordinatesLinear() {

		this.coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsDice.x)
				.height(Credentials.DimensionsDice.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesDice.x).yPointOfInterest(Credentials.CoordinatesDice.y)
				.nodesPerRow(3).createCoordinatesLinear();

	}

	public void rollDiceAndRelocate() {

		this.diceRoundAvailable.addAll(this.diceRoundOriginal);

		for (Dice dice : this.diceRoundAvailable) {

			dice.relocate(this.coordinatesLinear.getX(this.diceRoundAvailable.indexOf(dice)),
					this.coordinatesLinear.getY(this.diceRoundAvailable.indexOf(dice)));

			dice.rollDice();
			dice.setVisible(true);

		}

		printDiceCurrentlyShowing();

	}

	public int getDiceGrayValue() {
		return this.diceRoundAvailable.getLast().getDiceValue();
	}

	public void setDiceGrayInactive() {

		this.diceRoundAvailable.getLast().setVisible(false);
		this.diceRoundAvailable.removeLast();

	}

	public void removeDiceFromAction(Dice dice) {

		// TODO
		this.diceCurrentlyShowing.remove(dice);
		dice.setVisible(false);

	}

	public int diceCurrentlyShowingAmount() {
		return this.diceCurrentlyShowing.size();
	}

	public Dice getFirstDieAvailableThisRound() {
		return this.diceCurrentlyShowing.getFirst();
	}

	public void testSetRedDiceValuesAndRelocate(int diceValueFirst, int diceValueSecond) {

		this.diceRoundAvailable.addAll(this.diceRoundOriginal);
		this.diceRoundAvailable.removeLast();

		this.diceRoundAvailable.get(0).setValue(diceValueFirst);
		this.diceRoundAvailable.get(1).setValue(diceValueSecond);

		for (Dice dice : this.diceRoundAvailable) {

			dice.relocate(this.coordinatesLinear.getX(this.diceRoundAvailable.indexOf(dice)),
					this.coordinatesLinear.getY(this.diceRoundAvailable.indexOf(dice)));

			dice.setVisible(true);

		}

		Logger.newLine();

	}

	public void testRemoveDiceFromAction(int index) {

		Dice dice = this.diceRoundAvailable.get(index);
		removeDiceFromAction(dice);

	}

	public void setDiceCurrentlyShowingAvailableCurrentRound() {

		setDiceCurrentlyShowingVisible(false);
		this.diceCurrentlyShowing = this.diceRoundAvailable;
		setDiceCurrentlyShowingVisible(true);

		relocateDiceCurrentlyShowing();

	}

	public void setDiceCurrentlyShowingFreeActionAndRelocate() {

		setDiceCurrentlyShowingVisible(false);

		this.diceCurrentlyShowing = this.diceFreeActionAvailable;

		this.diceFreeActionAvailable.clear();
		this.diceFreeActionAvailable.addAll(this.diceFreeActionOriginal);

		setDiceCurrentlyShowingVisible(true);

		relocateDiceCurrentlyShowing();

	}

	private void setDiceCurrentlyShowingVisible(boolean value) {

		for (Dice dice : this.diceCurrentlyShowing) {
			dice.setVisible(value);
		}

	}

	public void relocateDiceCurrentlyShowing() {

		for (Dice dice : this.diceCurrentlyShowing) {

			dice.relocate(this.coordinatesLinear.getX(this.diceCurrentlyShowing.indexOf(dice)),
					this.coordinatesLinear.getY(this.diceCurrentlyShowing.indexOf(dice)));

		}

	}

	public void removeAllDiceCurrentlyShowingButThisAndRelocate(Dice dice) {

		for (Dice diceTemp : this.diceCurrentlyShowing)
			diceTemp.setVisible(false);

		this.diceCurrentlyShowing.clear();
		this.diceCurrentlyShowing.addLast(dice);

		relocateDiceCurrentlyShowing();
		dice.setVisible(true);

	}

	public void printDiceCurrentlyShowing() {

		Logger.log("dice currently showing");

		for (Dice dice : this.diceCurrentlyShowing) {
			Logger.log(dice.getDiceColor() + " - " + dice.getDiceValue());
		}

		Logger.newLine();

	}

	public int getDiceRoundAvailableSize() {
		return this.diceRoundAvailable.size();
	}

	@Override
	public void saveState() {
		this.diceRoundAvailableSave = this.diceRoundAvailable.clone();
	}

	@Override
	public void loadState() {

		for (Dice dice : this.diceCurrentlyShowing) {
			dice.setSelected(false);
		}

		this.diceRoundAvailable = this.diceRoundAvailableSave.clone();

		for (Dice dice : this.diceCurrentlyShowing) {
			dice.setVisible(true);
		}

		setDiceCurrentlyShowingAvailableCurrentRound();

	}

}
