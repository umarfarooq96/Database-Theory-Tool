package FDTheory;
import java.util.*;
/**
 * Created by Umar on 1/6/2017.
 */
public class FDStringHandler {

    private static String removeDuplicate(String s)
    {//Source: http://codereview.stackexchange.com/a/46783

        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<Character>();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String merge(String fd1, String fd2){
        String fd = fd1;
        fd = fd.concat(fd2);
        fd = removeDuplicate(fd);
        return sortString(fd);
    }

    public static String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static List<String> powerSet(String s) {
        // the number of subsets is 2^n
        long numSubsets = 1L << s.length();
        return powerSet(s, numSubsets - 1);
    }

    public static List<String> powerSet(String s, long active) {
        if (active < 0) {
            // Recursion base case
            // All 2^n subsets were visited, stop here and return a new list
            return new ArrayList<>();
        }

        StringBuilder subset = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // For each bit
            if (isSet(active, i)) {
                // If the bit is set, add the correspondent char to this subset
                subset.append(s.charAt(i));
            }
        }
        // Make the recursive call, decrementing active to the next state,
        // and get the returning list
        List<String> subsets = powerSet(s, active - 1);
        // Add this subset to the list of subsets
        subsets.add(subset.toString());
        return subsets;
    }

    public static boolean isSet(long bits, int i) {
        // return true if the ith bit is set
        return (bits & (1L << i)) != 0;
    }
}
