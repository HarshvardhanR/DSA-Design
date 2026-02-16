package TimeBasedKeyValueStore;

import java.util.*;

public class TimeMapList {

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMapList() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;  // candidate
                left = mid + 1;               // try to find larger valid
            } else {
                right = mid - 1;
            }
        }

        return result;
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
