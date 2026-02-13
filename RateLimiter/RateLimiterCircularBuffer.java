package RateLimiter;

public class RateLimiterCircularBuffer {
    int maxRequests;
    int windowSizeInSeconds;
    int time[];
    int hits[];
    int totalSoFar;

    public RateLimiterCircularBuffer(int maxRequests, int windowSizeInSeconds){
        this.maxRequests = maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        time = new int[windowSizeInSeconds];
        hits = new int[windowSizeInSeconds];
        totalSoFar = 0;
    }

    public boolean allowRequest(int timestamp) {
        int index = timestamp % windowSizeInSeconds;
        
        if (timestamp - time[index] >= windowSizeInSeconds) {
            totalSoFar -= hits[index];
            hits[index] = 0;
            time[index] = timestamp;
        }

        if (totalSoFar < maxRequests) {
            hits[index]++;
            totalSoFar++;
            return true;
    }

    return false;
}

    public static void main(String[] args) {
        RateLimiterCircularBuffer limiter = new RateLimiterCircularBuffer(3, 10);

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
