package utils;

public interface ArrayListAble<T> {

	public static HashMap<Object, ArrayList<? extends Object>> map = new HashMap<>();

	@SuppressWarnings("unchecked")
	public default ArrayList<T> getList() {
		return (ArrayList<T>) map.get(this);
	}

	public void zCreateArrayList();

}
