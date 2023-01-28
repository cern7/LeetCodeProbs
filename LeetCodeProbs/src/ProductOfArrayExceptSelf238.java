import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
//        int size = nums.length;
//        int[] prefix = new int[size];
//        int[] sufix = new int[size];
//        prefix[0] = 1;
//        sufix[size - 1] = 1;
//
//        for (int i = 1; i < size; i++) {
//            prefix[i] = prefix[i - 1] * nums[i - 1];
//            sufix[size - i - 1] = sufix[size - i] * nums[size - i];
//        }
//        int[] result = new int[size];
//        for (int i = 0; i < size; i++) {
//            result[i] = prefix[i] * sufix[i];
//        }
//        return result;
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result, 1);
        int temp = 1;
        for (int i = 0; i < size; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp *= nums[i];
        }

        return result;
    }
}
