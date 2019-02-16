package gameState;

import tiles.Knowledge;
import tiles.Tile;

public class ResolveTileAddedKnowledge extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = super.controller.gameModifiers().getLastTileAddedToBoard();
		Knowledge tileKnowledge = (Knowledge) tile;

		int tileKnowledgeNumber = tileKnowledge.getTileNumber();
		
		

		switch (tileKnowledgeNumber) {

		case 1:
			resolveTileNumber1();
			break;

		case 2:
			resolveTileNumber2();
			break;

		case 3:
			resolveTileNumber3();
			break;

		case 4:
			resolveTileNumber4();
			break;

		case 5:
			resolveTileNumber5();
			break;

		case 6:
			resolveTileNumber6();
			break;

		case 7:
			resolveTileNumber7();
			break;

		case 8:
			resolveTileNumber8();
			break;

		case 9:
			resolveTileNumber9();
			break;

		case 10:
			resolveTileNumber10();
			break;

		case 11:
			resolveTileNumber11();
			break;

		case 12:
			resolveTileNumber12();
			break;

		case 13:
			resolveTileNumber13();
			break;

		case 14:
			resolveTileNumber14();
			break;

		case 15:
			resolveTileNumber15();
			break;

		case 16:
			resolveTileNumber16();
			break;

		case 17:
			resolveTileNumber17();
			break;

		case 18:
			resolveTileNumber18();
			break;

		case 19:
			resolveTileNumber19();
			break;

		case 20:
			resolveTileNumber20();
			break;

		case 21:
			resolveTileNumber21();
			break;

		case 22:
			resolveTileNumber22();
			break;

		case 23:
			resolveTileNumber23();
			break;

		case 24:
			resolveTileNumber24();
			break;

		case 25:
			resolveTileNumber25();
			break;

		case 26:
			resolveTileNumber26();
			break;

		}

	}

	private void resolveTileNumber1() {

	}

	private void resolveTileNumber2() {

	}

	private void resolveTileNumber3() {

	}

	private void resolveTileNumber4() {

	}

	private void resolveTileNumber5() {

	}

	private void resolveTileNumber6() {

	}

	private void resolveTileNumber7() {

	}

	private void resolveTileNumber8() {

	}

	private void resolveTileNumber9() {

	}

	private void resolveTileNumber10() {

	}

	private void resolveTileNumber11() {

	}

	private void resolveTileNumber12() {

	}

	private void resolveTileNumber13() {

	}

	private void resolveTileNumber14() {

	}

	private void resolveTileNumber15() {

	}

	private void resolveTileNumber16() {

	}

	private void resolveTileNumber17() {

	}

	private void resolveTileNumber18() {

	}

	private void resolveTileNumber19() {

	}

	private void resolveTileNumber20() {

	}

	private void resolveTileNumber21() {

	}

	private void resolveTileNumber22() {

	}

	private void resolveTileNumber23() {

	}

	private void resolveTileNumber24() {

	}

	private void resolveTileNumber25() {

	}

	private void resolveTileNumber26() {

	}

}
