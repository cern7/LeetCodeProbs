package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        System.out.println(new Sum3().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;

        // Sort the input array
        Arrays.sort(nums);

        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                } else if (threeSum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
