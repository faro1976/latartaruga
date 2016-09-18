package it.framework.core.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

	private MapUtil() {
	}

	public static Map<String, Object> single(String key, Object value) {
		HashMap<String, Object> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

	public static Map<String, Object> add(String key, Object value) {
		HashMap<String, Object> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

	public static <K, V> ChainMap<K, V> chainMap() {
		return new ChainMap<>();
	}

	public static class ChainMap<K, V> {

		private HashMap<K, V> map = new HashMap<>();

		public ChainMap<K, V> put(K key, V value) {
			map.put(key, value);
			return this;
		}

		public Map<K, V> build() {
			return map;
		}
	}

}
