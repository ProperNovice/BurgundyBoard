package controller;

import utils.ArrayList;
import utils.Instances;
import utils.SaveLoadAble;

public class SaveLoadManager {

	private ArrayList<SaveLoadAble> list = new ArrayList<>();

	public SaveLoadManager() {
		createList();
	}

	private void createList() {

		Controller controller = Instances.getControllerInstance();

		addSaveLoadAble(controller.depotNumberedManager());
		addSaveLoadAble(controller.depotBlackManager());
		addSaveLoadAble(controller.victoryPointManager());
		addSaveLoadAble(controller.storageSpaceManager());

	}

	private void addSaveLoadAble(SaveLoadAble saveLoadAble) {
		this.list.addLast(saveLoadAble);
	}

	public void saveState() {

		for (SaveLoadAble saveLoadAble : this.list) {
			saveLoadAble.saveState();
		}

	}

	public void loadState() {

		for (SaveLoadAble saveLoadAble : this.list) {
			saveLoadAble.loadState();
		}

	}

}
