import java.util.HashMap;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MapService m = new MapManager();
		Map<Object, Object> map = new HashMap<>();
		map.put(1, 100);
		map.put(2, 999);
		map.put(3, 56);
		map.put(4, 58);
		m.setMap(map);
		System.err.println("NonOrdered:\t" + m.getNonSortedMap());
		System.out.println("Ordered:\t" + m.getSortedMap());
		System.err.println("MaxId:\t" + m.getMaxId());
		System.out.println("MinId:\t" + m.getMinId());
		System.err.println("ToString:\t"+m.gettoString());

	}

}
