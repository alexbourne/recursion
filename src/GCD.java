/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 22/10/2013
 * Time: 22:13
 */
public class GCD {

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x%y);
        }
    }

    public static void main(String[] args) {

        System.out.println("gcd(22,50) = " + gcd(22,50));
        System.out.println("gcd(81,27) = " + gcd(81,27));

    }

}
