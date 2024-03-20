import java.util.*;

public class QuestionFive {
    public static String isSubset(int[] S, int[] T) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : T) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            }
        }

        for (int num : S) {
            if (!hashMap.containsKey(num)) {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        // Sample Inputs
        int[] S1 = {32, 3};
        int[] T1 = {1, 2, 3, 52, 32, 54};
        System.out.println(isSubset(S1, T1)); //Output:Yes

        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};
        System.out.println(isSubset(S2, T2)); //Output:No

        int[] S3 = {0, 67};
        int[] T3 = {100, 5, 66, 2, 32, 90};
        System.out.println(isSubset(S3, T3)); //Output:No

        int[] S4 = {0};
        int[] T4 = {54, 32, 99};
        System.out.println(isSubset(S4, T4)); //Output:Yes
    }
}