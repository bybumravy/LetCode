package Medium.CODE;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC_238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            output[i] = 1;
        }
        int left = 1, right = 1;
        for(int i = 0; i < nums.length; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        LC_238_ProductOfArrayExceptSelf test = new LC_238_ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{1,2,3,4})));
    }
}
