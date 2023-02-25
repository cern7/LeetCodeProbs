package binarySearch;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] < nums[r] ? nums[l] : nums[r];
    }
}
