package binarySearch;

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(new BinarySearch704().search(arr, target));
    }

    public int search(int[] nums, int target) {

        int result = -1;
        int size = nums.length;

        if (size < 2) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            result = mid;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
