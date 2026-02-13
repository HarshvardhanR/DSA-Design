package RateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class RateLimiterQueueBased {
    int maxRequests;
    int windowSizeInSeconds;
    Queue<Integer> q;
    public RateLimiterQueueBased(int maxRequests, int windowSizeInSeconds){
        q = new LinkedList<>();
        this.maxRequests = maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
    }

    public boolean allowRequest(int timestamps){
        int diff = timestamps - windowSizeInSeconds;
        while(!q.isEmpty() && q.peek() <= diff){
            q.poll();
        }
        if(q.size() < maxRequests){
            q.add(timestamps);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RateLimiterQueueBased limiter = new RateLimiterQueueBased(3, 10);

        System.out.println(limiter.allowRequest(1));   // true
        System.out.println(limiter.allowRequest(2));   // true
        System.out.println(limiter.allowRequest(3));   // true
        System.out.println(limiter.allowRequest(4));   // false  (3 already in window [ -5 to 4 ])

        System.out.println(limiter.allowRequest(11));  // true   (window now [1 to 11], request at 1 expired)
        System.out.println(limiter.allowRequest(12));  // true
        System.out.println(limiter.allowRequest(13));  // false  (3 active in [3 to 13])

        System.out.println(limiter.allowRequest(21));  // true   (old ones expired)
        System.out.println(limiter.allowRequest(22));  // true
        System.out.println(limiter.allowRequest(23));  // true
        System.out.println(limiter.allowRequest(24));  // false
    }
}
