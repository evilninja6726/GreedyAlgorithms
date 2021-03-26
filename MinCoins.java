package greedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class MinCoins {
    public static void main(String[] args) {
        System.out.println(minCoins(new Integer[]{5, 1, 2, 10}, 52));
    }

    public static int minCoins(Integer[] arr, int x) {
        int res = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (x >= arr[i]) {
                int count = x / arr[i];
                res += count;
                x -= count * arr[i];
            }
            if (x == 0)
                break;
        }
        return res;
    }
}
