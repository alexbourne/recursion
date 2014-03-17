/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 16/10/2013
 * Time: 21:33
 */
public class RaiseToPower {

    public static int raiseToPower(int n, int k) {
        if (k == 0) {
            return 1;
        } else {
            return n * raiseToPower(n, k - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println("raiseToPower(4, 2) = " + raiseToPower(4, 2));

    }
}
