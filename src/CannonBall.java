/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 16/10/2013
 * Time: 21:13
 */
public class CannonBall {

    public static int cannonball(int height) {
        if (height < 1) {
            return 0;
        } else {
            return (int) Math.pow(height, 2.0) + cannonball(height - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println("cannonball(1) = " + cannonball(1));
        System.out.println("cannonball(2) = " + cannonball(2));
        System.out.println("cannonball(3) = " + cannonball(3));
        System.out.println("cannonball(4) = " + cannonball(4));

    }

//    public static int additiveSequence(int n, int t0, int t1) {
//        if (n == 0) return t0;
//        if (n == 1) return t1;
//        return additiveSequence(n - 1, t1, t0 + t1);
//    }
}
