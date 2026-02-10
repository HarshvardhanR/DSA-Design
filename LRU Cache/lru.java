import java.util.HashMap;
import java.util.Map;

public class lru{
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public lru(int capacity){
        map = new HashMap<>();
        tail = new Node(0,0);
        head = new Node(0, 0);
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        if(!map.containsKey(key)) return -1;
        remove(map.get(key));
        addToTail(map.get(key));
        return map.get(key).value;
    }

    public void addToTail(Node node){
        Node tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            map.get(key).value = value;
            remove(map.get(key));
            addToTail(map.get(key));
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToTail(newNode);
        if(map.size() > capacity){
            map.remove(head.next.key);
            remove(head.next);   
        }
        // System.out.println(head);
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String args[]){
        lru lru = new lru(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        System.out.println(lru.get(2)); // 20
        lru.put(4, 40);  
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 30
        System.out.println(lru.get(4)); // 40
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = this.next;
        while(temp != null && temp.next != null){
            sb.append(temp.value).append(" -> ");
            temp = temp.next;
        }
        if(temp != null) sb.append(temp.value);
        return sb.toString();
    }
}