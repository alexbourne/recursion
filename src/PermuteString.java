/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 04/11/2013
 * Time: 21:42
 */
public class PermuteString {

    public static void listPermutations(String s) {
        recursivePermute("", s);
    }

    public static void recursivePermute(String prefix, String remainder) {
        if (remainder.equals("")) {
            System.out.println(prefix);
        } else {
            for (int i=0; i < remainder.length(); i++) {
                String newPrefix = prefix + remainder.charAt(i);
                String newRemainder = remainder.substring(0, i) + remainder.substring(i+1);
                recursivePermute(newPrefix, newRemainder);
            }
        }
    }

    public static void listPermutations2(String s) {
        recursivePermute(s, 0);
    }

    public static void recursivePermute(String s, int index) {
        if (s.length() <= index) {
            System.out.println(s);
        } else {

            String fixedPrefix = s.substring(0, index);
            String remainder = s.substring(index);

            for (int i=0; i < remainder.length(); i++) {
                recursivePermute(fixedPrefix + remainder.charAt(i) +remainder.substring(0, i) + remainder.substring(i+1), index + 1);
            }

        }
    }

    public static void main(String[] args) {

        System.out.println("First approach");
        listPermutations("ABCDE");
        System.out.println("\nSecond approach");
        listPermutations2("ABCDE");

    }
}
