package gameState;

import enums.GameStateEnum;
import tiles.Tile;

public class ResolveTileAdded extends GameState {

	@Override
	public void handleGameStateChange() {

		GameStateEnum gameStateEnum = null;
		Tile lastTileAddedToBoard = super.controller.playerBoard().getLastTileAddedToBoard();

		switch (lastTileAddedToBoard.getTileTypeEnum()) {

		case ANIMAL:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_ANIMAL;
			break;

		case BUILDING:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_BUILDING;
			break;

		case CASTLE:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_CASTLE;
			break;

		case KNOWLEDGE:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_KNOWLEDGE;
			break;

		case MINE:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_MINE;
			break;

		case SHIP:
			gameStateEnum = GameStateEnum.RESOLVE_TILE_ADDED_SHIP;
			break;

		}

	}

}
