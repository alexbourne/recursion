import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 24/10/2013
 * Time: 20:24
 */
public class FibCount {

    public static void main(String[] args) {

        System.out.printf(" N\tFib1\tFib2\n");
        System.out.printf("--\t----\t----\n");

        for ( int i = 0; i < 13; i++ ) {
            AtomicInteger depth1 = new AtomicInteger();
            AtomicInteger depth2 = new AtomicInteger();
            countFib1(i, depth1);
            countFib2(i, depth2);
            System.out.printf("%2d\t%4d\t%4d\n", i, depth1.get(), depth2.get());
        }

    }

    public static int countFib1(int n, AtomicInteger depth) {
        depth.getAndIncrement();
        if (n < 2) {
            return n;
        }
        return countFib1(n - 1, depth) + countFib1(n - 2, depth);
    }

    public static int countFib2(int n, AtomicInteger depth) {
        depth.getAndIncrement();
        return additiveSequence(n, 0, 1, depth);
    }

    public static int additiveSequence(int n, int t0, int t1, AtomicInteger depth) {
        depth.getAndIncrement();
        if (n == 0) return t0;
        if (n == 1) return t1;
        return additiveSequence(n - 1, t1, t0 + t1, depth);
    }
}
