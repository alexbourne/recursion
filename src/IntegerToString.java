/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 24/10/2013
 * Time: 21:48
 */
public class IntegerToString {

    public static void main(String[] args) {
        System.out.println("integerToString(1729) = " + integerToString(1729));
    }

    public static String integerToString(int n) {
        if (n < 1) return "";
        return "" + integerToString(n/10) + n%10;
    }

}
