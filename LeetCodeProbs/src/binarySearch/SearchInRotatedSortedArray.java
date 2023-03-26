package binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] nums = {1};
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) { // mid belongs the left sorted portion
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // right sorted portion
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
