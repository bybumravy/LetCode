package Easy.CODE;

public class LC_283_MoveZeroes {
    public void moveZero(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
