package controller;

import model.Goods;
import utils.ArrayList;
import utils.CoordinatesBuilder;
import utils.CoordinatesLinear;

public class GoodsManager {

	private ArrayList<Goods> goodsListAvailable = new ArrayList<>();
	private ArrayList<Goods> goodsListOriginal = new ArrayList<>();
	private ArrayList<Goods> phaseGoods = new ArrayList<>();
	private ArrayList<Goods> playerGoods = new ArrayList<>();
	private CoordinatesLinear coordinatesLinearPhaseGoods = null, coordinatesLinearPlayerGoods = null;

	public GoodsManager() {

		createGoods();
		createCoordinates();
		addThreeRandomGoodsToPlayerGoodsAndRelocate();

	}

	private void createGoods() {

		for (int diceValue = 1; diceValue <= 6; diceValue++)
			for (int counter = 1; counter <= 7; counter++)
				this.goodsListAvailable.addLast(new Goods(diceValue));

		this.goodsListOriginal.addAll(this.goodsListAvailable);

	}

	private void createCoordinates() {

		this.coordinatesLinearPhaseGoods = new CoordinatesBuilder().width(Credentials.DimensionsGoods.x)
				.height(Credentials.DimensionsGoods.y).gapBetweenNodes(Credentials.DimensionsGapBetweenComponents.x)
				.xPointOfInterest(Credentials.CoordinatesPhaseGoods.x)
				.yPointOfInterest(Credentials.CoordinatesPhaseGoods.y).nodesPerRow(5).createCoordinatesLinear();

		this.coordinatesLinearPlayerGoods = new CoordinatesBuilder().width(Credentials.DimensionsGoods.x)
				.height(Credentials.DimensionsGoods.y).gapBetweenNodes(-Credentials.DimensionsGoods.x * 3 / 5)
				.xPointOfInterest(Credentials.CoordinatesPlayerGoods.x)
				.yPointOfInterest(Credentials.CoordinatesPlayerGoods.y).nodesPerRow(100).createCoordinatesLinear();

	}

	public void createNewPhaseGoodsAndRelocate() {

		Goods goods = null;

		for (int counter = 1; counter <= 5; counter++) {

			goods = this.goodsListAvailable.removeRandom();
			this.phaseGoods.addLast(goods);
			int goodsIndex = this.phaseGoods.indexOf(goods);

			goods.setVisible(true);

			goods.relocate(this.coordinatesLinearPhaseGoods.getX(goodsIndex),
					this.coordinatesLinearPhaseGoods.getY(goodsIndex));

		}

	}

	public Goods removeFirstPhaseGoods() {
		return this.phaseGoods.removeFirst();
	}

	public void addPlayerGoodsAndRelocate(ArrayList<Goods> goods) {

		this.playerGoods.addAll(goods);

		ArrayList<Goods> playerGoodsTemp = this.playerGoods.clone();
		this.playerGoods.clear();

		for (Goods goodsTemp : this.goodsListOriginal) {

			if (playerGoodsTemp.contains(goodsTemp))
				this.playerGoods.addLast(goodsTemp);

		}

		relocatePlayerGoods();

	}

	private void relocatePlayerGoods() {

		Goods goods = null;

		for (int counter = 0; counter < this.playerGoods.size(); counter++) {

			goods = this.playerGoods.get(counter);
			goods.relocate(this.coordinatesLinearPlayerGoods.getX(counter),
					this.coordinatesLinearPlayerGoods.getY(counter));
			goods.toFront();

		}

	}

	public Goods testRemoveRandomGoodsFromStack() {
		return this.goodsListAvailable.removeRandom();
	}

	private void addThreeRandomGoodsToPlayerGoodsAndRelocate() {

		ArrayList<Goods> goods = new ArrayList<>();
		Goods goodsTemp = null;

		for (int counter = 1; counter <= 3; counter++) {

			goodsTemp = this.goodsListAvailable.removeRandom();
			goodsTemp.setVisible(true);
			goods.addLast(goodsTemp);

		}

		addPlayerGoodsAndRelocate(goods);

	}

	public boolean playerGoodsSizeAtLeaseFive() {
		return this.playerGoods.size() >= 5;
	}

	public void removeFiveRandomGoodsAndRelocate() {

		for (int counter = 1; counter <= 5; counter++)
			this.playerGoods.removeRandom().setVisible(false);

		relocatePlayerGoods();

	}

	public boolean phaseGoodsIsEmpty() {
		return this.phaseGoods.isEmpty();
	}

	public int getPhaseGoodsSize() {
		return this.phaseGoods.size();
	}

}
