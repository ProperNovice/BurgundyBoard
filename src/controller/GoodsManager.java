package controller;

import model.Goods;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.CoordinatesBuilder.CoordinatesType;

public class GoodsManager {

	private ArrayList<Goods> goodsList = new ArrayList<>();
	private ArrayList<Goods> phaseGoods = new ArrayList<>();
	private Coordinates coordinates = null;

	public GoodsManager() {

		createGoods();
		createCoordinates();

	}

	private void createGoods() {

		for (int counter = 1; counter <= 7; counter++)
			for (int diceValue = 1; diceValue <= 6; diceValue++)
				this.goodsList.addLast(new Goods(diceValue));

	}

	private void createCoordinates() {

		this.coordinates = new CoordinatesBuilder().width(Credentials.DimensionsGoods.x)
				.height(Credentials.DimensionsGoods.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.nodesPerRow(5).type(CoordinatesType.LINEAR).create();

	}

	public void createNewPhaseGoodsAndRelocate() {

		double x = Credentials.CoordinatesPhaseGoods.x;
		double y = Credentials.CoordinatesPhaseGoods.y;
		Goods goods = null;

		for (int counter = 1; counter <= 5; counter++) {

			goods = this.goodsList.removeRandom();
			this.phaseGoods.addLast(goods);
			int goodsIndex = this.phaseGoods.indexOf(goods);

			goods.setVisible(true);

			goods.relocate(x + this.coordinates.getX(goodsIndex), y + this.coordinates.getY(goodsIndex));

		}

	}

	public Goods removeFirst() {
		return this.phaseGoods.removeFirst();
	}

}
