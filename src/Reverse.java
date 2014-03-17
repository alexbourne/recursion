/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 24/10/2013
 * Time: 21:39
 */
public class Reverse {

    public static void main(String[] args) {

        System.out.println("reverse(\"program\") = " + reverse("program"));
    }

    public static String reverse(String s) {
        if (s.equals("")) return s;
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() -1));
    }

}
