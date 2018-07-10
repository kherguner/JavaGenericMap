import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapManager implements MapService {
	Map<Object, Object> localMap = new HashMap<>();
	Map<Object, Object> sortedMap = new HashMap<>();

	@Override
	public Map<Object, Object> setMap(Map<Object, Object> myMap) {
		localMap = myMap;
		sortedMap = sortingMap(localMap);
		return localMap;

	}

	private <T> HashMap sortingMap(Map<Object, Object> map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;

	}

	@Override
	public Object getNonSortedMap() {
		return localMap;
	}

	@Override
	public Object getSortedMap() {
		return sortedMap;
	}

	@Override
	public Object getMaxId() {
		Set<Object> keys = sortedMap.keySet();
		Object maxId = null;
		for (Object i : keys) {
			maxId = i;
		}
		return maxId;
	}

	@Override
	public Object getMinId() {
		Set<Object> keys = sortedMap.keySet();
		Object minId = null;
		for (Object i : keys) {
			minId = i;
			break;
		}
		return minId;
	}

	@Override
	public Object gettoString() {
		return sortedMap.toString();
	}

}
