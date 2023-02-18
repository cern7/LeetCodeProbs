package binarySearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KokoEatingBananas {

     public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1_000_000_000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatInTime(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatInTime(int[] piles, int mid, int h) {
        long result = 0;
        for (int noPiles : piles) {
            result += noPiles / mid;
            result += noPiles % mid != 0 ? 1 : 0;
        }
        return result <= h;
    }
}
