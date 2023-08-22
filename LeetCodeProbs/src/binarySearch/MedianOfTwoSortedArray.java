package binarySearch;

public class MedianOfTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if (size1 > size2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int start = 0;
        int end = size1;
        int midOfMergedArray = (size1 + size2 + 1) / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int partitionPointA = mid;
            int partitionPointB = midOfMergedArray - mid;

            int maxLeftPartitionA = partitionPointA > 0
                    ? nums1[partitionPointA - 1] : Integer.MIN_VALUE;
            int maxLeftPartitionB = partitionPointB > 0
                    ? nums2[partitionPointB - 1] : Integer.MIN_VALUE;
            int minRightPartitionA = partitionPointA < size1
                    ? nums1[partitionPointA] : Integer.MAX_VALUE;
            int minRightPartitionB = partitionPointB < size2
                    ? nums2[partitionPointB] : Integer.MAX_VALUE;
            if (maxLeftPartitionA <= minRightPartitionB
                    && maxLeftPartitionB <= minRightPartitionA) {
                if ((size1 + size2) % 2 == 0) {
                    return (Math.max(maxLeftPartitionA, maxLeftPartitionB)
                            + Math.min(minRightPartitionA, minRightPartitionB))
                            / 2.0;
                }
                return Math.max(maxLeftPartitionA, maxLeftPartitionB);
            } else if (maxLeftPartitionA > minRightPartitionB) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return 0.0;

//        while (partition1 < partition2) {
//            if (nums1[partition1 - 1] > nums2[partition2]) {
//                partition1--;
//            } else {
//                partition2++;
//            }
//            if (nums1[partition1 - 1] <= nums2[partition2]
//                    && nums2[partition2 - 1] <= nums1[partition1]) {
//
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {1, 1, 3, 5, 9, 10, 11, 12};
        // {1, 1, 3, 5, 9, 10, 11, 12, 30}

        System.out.println(findMedianSortedArrays(nums2, nums1));
    }
}
