/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 24/10/2013
 * Time: 21:00
 */
public class DigitSum {

    public static void main(String[] args) {
        System.out.println("digitSum(1729) = " + digitSum(1729));
        System.out.println("digitalRoot(1729) = " + digitalRoot(1729));
        System.out.println("digitalRoot(2222) = " + digitalRoot(2222));
    }

    public static int digitSum(int n) {
        if (n < 1) return 0;
        return n%10 + digitSum(n/10);
    }

    public static int digitalRoot(int n) {
        if (n < 10) return n;
        return digitalRoot(digitSum(n));
    }
}
