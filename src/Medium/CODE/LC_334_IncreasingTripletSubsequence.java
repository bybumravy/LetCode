package Medium.CODE;

public class LC_334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC_334_IncreasingTripletSubsequence obj = new LC_334_IncreasingTripletSubsequence();
        System.out.println(obj.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(obj.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
    }
}
