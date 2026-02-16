package TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMapOptimizedTree {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMapOptimizedTree() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        TreeMap<Integer, String> tempMap = map.get(key);
        Integer floorKey = tempMap.floorKey(timestamp);

        if (floorKey == null) return "";

        return tempMap.get(floorKey);
    }

    public static void main(String[] args) {

        TimeMap tm = new TimeMap();

        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));  // bar
        System.out.println(tm.get("foo", 3));  // bar

        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));  // bar2
        System.out.println(tm.get("foo", 5));  // bar2

        System.out.println(tm.get("foo", 0));  // ""

        tm.set("foo", "bar3", 10);
        System.out.println(tm.get("foo", 10)); // bar3
        System.out.println(tm.get("foo", 9));  // bar2

        tm.set("baz", "hello", 2);
        System.out.println(tm.get("baz", 2));  // hello
        System.out.println(tm.get("baz", 3));  // hello
        System.out.println(tm.get("baz", 1));  // ""
    }
}
