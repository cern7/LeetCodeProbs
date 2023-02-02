package twoPointers;

public class TwoSumIISortedArray167 {

    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        if (size == 2) {
            return new int[]{1, 2};
        }
        int left = 0;
        int right = size - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
    
}
