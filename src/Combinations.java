/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 24/10/2013
 * Time: 21:19
 */
public class Combinations {

    public static void main(String[] args) {

        for ( int i=0; i < 7; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(c(i, j) + " ");
//                System.out.print("c(" + i + "," + j + ") ");
            }
            System.out.println("");
        }
    }

    public static int c(int i, int j) {
        if (i < 2) return 1;
        if (j == 0 || i == j) return 1;
        return c(i-1, j-1) + c(i-1, j);
    }
}
