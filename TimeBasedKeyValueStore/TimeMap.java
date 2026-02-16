package TimeBasedKeyValueStore;

public class TimeMap {

    public TimeMap(){

    }

    public void set(String key, String value, int timestamp){

    }

    public String get(String key, int timestamp){

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

class Pair{
    String key;
    String value;
    public Pair(String key, String value){
        this.key = key;
        this.value = value;
    }
}
