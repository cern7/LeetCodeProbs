package arraysHashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return 1;
        }
        int length = 0;

        Set<Integer> neigbhours = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int tempLength = 1;
            if (!neigbhours.contains(number - 1)) {
                while (neigbhours.contains(number + tempLength)) {
                    tempLength++;
                }
                length = length < tempLength ? tempLength : length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
