import java.util.LinkedList;
import java.util.Queue;

public class HitCounterQueueBased {
    private Queue<Integer> queue;
    private final int WINDOW = 300;

    public HitCounterQueueBased() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= WINDOW) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        HitCounterQueueBased counter = new HitCounterQueueBased();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));   

        counter.hit(300);
        System.out.println(counter.getHits(300));  
        System.out.println(counter.getHits(301));  

        counter.hit(302);
        counter.hit(303);
        System.out.println(counter.getHits(305));  

        System.out.println(counter.getHits(600));  
        counter.hit(601);
        System.out.println(counter.getHits(601));  
        System.out.println(counter.getHits(900));  
    }
}
