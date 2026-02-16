package TimeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, Map<Integer, String>> map;

    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        Map<Integer, String> tempMap = map.get(key);
        tempMap.put(timestamp, value);
    }

    public String get(String key, int timestamp){
        if(!map.containsKey(key)) return "";
        Map<Integer, String> tempMap = map.get(key);
        List<Integer> temp = new ArrayList<>(tempMap.keySet());
        return binarySearch(temp, tempMap, timestamp);
    }

    public String binarySearch(List<Integer> temp, Map<Integer, String> tempMap, int timestamp){
        int low= 0;
        int high = temp.size() - 1;
        int result = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            int tempTime = temp.get(mid);
            if(tempTime==timestamp){
                result = tempTime;
                break;
            }
            else if(tempTime > timestamp){
                high = mid - 1;
            }
            else{
                result = tempTime;
                low = mid + 1;
            }
        }
        if(result==-1) return "";
        return tempMap.get(result);
    }

    public static void main(String[] args) {

        TimeMap tm = new TimeMap();

        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));  // bar
        System.out.println(tm.get("foo", 3));  // bar (closest <= 3 is 1)

        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));  // bar2
        System.out.println(tm.get("foo", 5));  // bar2 (closest <= 5 is 4)

        System.out.println(tm.get("foo", 0));  // "" (nothing <= 0)

        tm.set("foo", "bar3", 10);
        System.out.println(tm.get("foo", 10)); // bar3
        System.out.println(tm.get("foo", 9));  // bar2

        tm.set("baz", "hello", 2);
        System.out.println(tm.get("baz", 2));  // hello
        System.out.println(tm.get("baz", 3));  // hello
        System.out.println(tm.get("baz", 1));  // ""
    }
}

