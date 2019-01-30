package controller;

import enums.DiceColor;
import model.Dice;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;
import utils.Logger;

public class DiceManager {

	private ArrayList<Dice> diceOriginal = new ArrayList<>();
	private ArrayList<Dice> diceAvailableThisRound = new ArrayList<>();
	private CoordinatesLinear coordinatesLinear = null;

	public DiceManager() {

		createDice();
		createCoordinatesLinear();

	}

	private void createDice() {

		this.diceOriginal.addLast(new Dice(DiceColor.RED));
		this.diceOriginal.addLast(new Dice(DiceColor.RED));
		this.diceOriginal.addLast(new Dice(DiceColor.GRAY));

	}

	private void createCoordinatesLinear() {

		this.coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsDice.x)
				.height(Credentials.DimensionsDice.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesDice.x).yPointOfInterest(Credentials.CoordinatesDice.y)
				.nodesPerRow(10).createCoordinatesLinear();

	}

	public void rollDiceAndRelocate() {

		this.diceAvailableThisRound.addAll(this.diceOriginal);

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

}
