package controller;

import model.Goods;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;

public class GoodsManager {

	private ArrayList<Goods> goodsList = new ArrayList<>();
	private ArrayList<Goods> phaseGoods = new ArrayList<>();
	private CoordinatesLinear coordinatesLinear = null;

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

		this.coordinatesLinear = new CoordinatesBuilder().width(Credentials.DimensionsGoods.x)
				.height(Credentials.DimensionsGoods.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesPhaseGoods.x)
				.yPointOfInterest(Credentials.CoordinatesPhaseGoods.y).nodesPerRow(5).createCoordinatesLinear();

	}

	public void createNewPhaseGoodsAndRelocate() {

		Goods goods = null;

		for (int counter = 1; counter <= 5; counter++) {

			goods = this.goodsList.removeRandom();
			this.phaseGoods.addLast(goods);
			int goodsIndex = this.phaseGoods.indexOf(goods);

			goods.setVisible(true);

			goods.relocate(this.coordinatesLinear.getX(goodsIndex), this.coordinatesLinear.getY(goodsIndex));

		}

	}

	public Goods removeFirst() {
		return this.phaseGoods.removeFirst();
	}

}
