import java.util.*;

public class QuestionSix {

    public static int findMaxLength(String[] arr) {
        int maxLength = 0;
        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
    }

    public static void radixSort(String[] arr) {
        int maxLength = findMaxLength(arr);

        for (int i = maxLength - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    public static void countingSort(String[] arr, int exp) {
        int n = arr.length;
        String[] output = new String[n];
        //Number 256 represents the number of possible values for a single byte
        int[] count = new int[256];

        for (String s : arr) {
            int index;
            if (s.length() > exp) {
                //https://www.geeksforgeeks.org/java-string-tochararray-example/
                index = (int) s.toCharArray()[exp];
            } else {
                index = 0;
            }
            count[index]++;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index;
            if (arr[i].length() > exp) {
                index = (int) arr[i].charAt(exp);
            } else {
                index = 0;
            }
            int outputIndex = count[index] - 1;
            output[outputIndex] = arr[i];
            count[index]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        String[] arr = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman", "hydra", "surtr"};

        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}