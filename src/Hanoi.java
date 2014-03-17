import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 28/10/2013
 * Time: 20:45
 */
public class Hanoi {

    public static void moveSingleDisk(char start, char finish) {
        System.out.printf("%s -> %s\n", start, finish);
    }

    public static void moveTower(int numDisks, char start, char finish, char temp) {
        if (numDisks == 1) {
            moveSingleDisk(start, finish);
        } else {
            moveTower(numDisks - 1, start, temp, finish);
            moveSingleDisk(start, finish);
            moveTower(numDisks - 1, temp, finish, start);
        }
    }

    public static void numHanoiMoves(int numDisks, char start, char finish, char temp) {
        AtomicInteger count = new AtomicInteger();
        countHanoiMoves(numDisks, start, finish, temp, count);
        System.out.println(numDisks + " disks results in " + count.get() + " moves.");
    }


    private static void countHanoiMoves(int numDisks, char start, char finish, char temp, AtomicInteger count) {
        if (numDisks == 1) {
            count.getAndIncrement();
        } else {
            countHanoiMoves(numDisks - 1, start, temp, finish, count);
            count.getAndIncrement();
            countHanoiMoves(numDisks - 1, temp, finish, start, count);
        }
    }

    public static void moveTowerCheckZero(int numDisks, char start, char finish, char temp) {
        if (numDisks == 0) {
            return;
        } else {
            moveTower(numDisks - 1, start, temp, finish);
            moveSingleDisk(start, finish);
            moveTower(numDisks - 1, temp, finish, start);
        }
    }

    public static void main(String[] args) {
        moveTower(3, 'A', 'B', 'C');
        numHanoiMoves(16, 'A', 'B', 'C');
        moveTowerCheckZero(3, 'A', 'B', 'C');
    }
}
