public class HitCounter {
    private int[] times;
    private int[] hits;
    private final int WINDOW = 300;

    public HitCounter() {
        times = new int[WINDOW];
        hits = new int[WINDOW];
    }

    public void hit(int timestamp) {
        int index = timestamp % WINDOW;

        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    public int getHits(int timestamp) {
        int sum = 0;
        for (int i = 0; i < WINDOW; i++) {
            if (timestamp - times[i] < WINDOW) {
                sum += hits[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

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
