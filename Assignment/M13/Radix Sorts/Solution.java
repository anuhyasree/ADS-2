import java.util.Scanner;
import java.util.Arrays;
/**
 * this is a class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * Client Program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LSD lsd = new LSD();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextLine();
        }
        lsd.sort(tokens, tokens[0].length());
        System.out.println(Arrays.toString(tokens));
    }
}





