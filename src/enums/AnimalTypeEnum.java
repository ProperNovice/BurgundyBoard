package enums;

public enum AnimalTypeEnum {

	COW("cow"), HEN("hen"), PIG("pig"), SHEEP("sheep");

	private String text = null;

	private AnimalTypeEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

}
