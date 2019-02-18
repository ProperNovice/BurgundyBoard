package gameState;

import enums.AnimalTypeEnum;
import model.BoardSpace;
import tiles.Animal;
import tiles.Tile;

public class ResolveTileAddedAnimal extends GameState {

	@Override
	public void handleGameStateChange() {

		Tile tile = super.controller.gameModifiers().getLastTileAddedToBoard();
		Animal tileAnimal = (Animal) tile;
		AnimalTypeEnum animalTypeEnum = tileAnimal.getAnimalTypeEnum();

		BoardSpace boardSpace = super.controller.gameModifiers().getLastBoardspaceTileAddedTo();
		int animalTypeExtraPoints = super.controller.gameModifiers().getAnimalTypeExtraPoints();

		int victoryPoints = super.controller.playerBoard().getTotalAnimalVictoryPoints(boardSpace, animalTypeEnum,
				animalTypeExtraPoints);

		super.controller.victoryPointManager().addCurrentVictoryPoints(victoryPoints);

	}

}
