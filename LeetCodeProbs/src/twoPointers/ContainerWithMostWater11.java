package twoPointers;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVolum = -1;
        while (left < right) {
            int containerHeight = height[height[left] < height[right] ? left : right];
            int containerLength = right - left;
            maxVolum = maxVolum > containerLength * containerHeight ? maxVolum : containerLength * containerHeight;
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVolum;
    }
}
