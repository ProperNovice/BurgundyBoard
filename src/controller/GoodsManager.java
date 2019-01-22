package controller;

import models.Goods;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;

public class GoodsManager {

	private ArrayList<Goods> goodsList = new ArrayList<>();
	private ArrayList<Goods> phaseGoods = new ArrayList<>();
	private Coordinates coordinates = null;

	public GoodsManager() {

		createGoods();

		this.coordinates = new CoordinatesBuilder().width(Credentials.DimensionsGoods.x)
				.height(Credentials.DimensionsGoods.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.nodesPerRow(5).create();

	}

	private void createGoods() {

		for (int counter = 1; counter <= 7; counter++)
			for (int diceValue = 1; diceValue <= 6; diceValue++)
				this.goodsList.addLast(new Goods(diceValue));

	}

	public void createNewPhaseGoodsAndRelocate() {

		double x = Credentials.CoordinatesPhaseGoods.x;
		double y = Credentials.CoordinatesPhaseGoods.y;
		this.coordinates.resetCoordinates();

		for (int counter = 1; counter <= 5; counter++) {

			this.phaseGoods.addLast(this.goodsList.removeRandom());
			this.phaseGoods.getLast().setVisible(true);

			this.coordinates.setUpNextCoordinates();
			this.phaseGoods.getLast().relocate(x + this.coordinates.getX(), y + this.coordinates.getY());

		}

	}
	
	public Goods removeFirst() {
		return this.phaseGoods.removeFirst();
	}

}
