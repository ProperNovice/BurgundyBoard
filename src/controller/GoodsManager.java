package controller;

import goods.Goods;
import utils.ArrayList;

public class GoodsManager {

	private ArrayList<Goods> goods = new ArrayList<>();

	public GoodsManager() {
		createGoods();
	}

	private void createGoods() {

		for (int counter = 1; counter <= 7; counter++)
			for (int diceValue = 1; diceValue <= 6; diceValue++)
				this.goods.addLast(new Goods(diceValue));

	}

	public Goods removeRandom() {
		return this.goods.removeRandom();
	}

}
