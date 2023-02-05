package twoPointers;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        int size = height.length;
        int result = 0;
        int l = 0;
        int r = size - 1;
        int maxL = height[0];
        int maxR = height[size - 1];
        while (l <= r) {
            //min(maxL, maxR) - h[i]
            if (maxL <= maxR) {
                if (maxL - height[l] <= 0) maxL = height[l];
                else result += (maxL - height[l]);
                l++;
            } else {
                if (maxR - height[r] <= 0) maxR = height[r];
                else result += (maxR - height[r]);
                r--;
            }
        }
        return result;
    }
}
