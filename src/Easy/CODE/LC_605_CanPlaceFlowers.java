package Easy.CODE;

public class LC_605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] fl, int n) {
        boolean left,right;
        int count = 0;
        for (int i = 0; i < fl.length; i++) {
            left = false;
            right = false;
            if(fl[i] == 0) {
                if( i == 0 || fl[i - 1] == 0) {
                    left = true;
                }
                if( i == (fl.length - 1) || fl[i + 1] == 0) {
                    right = true;
                }
                if (left && right) {
                    count += 1;
                    fl[i] = 1;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        LC_605_CanPlaceFlowers obj = new LC_605_CanPlaceFlowers();
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(obj.canPlaceFlowers(flowerbed, 1)); // true
        System.out.println(obj.canPlaceFlowers(flowerbed, 2)); // false
    }
}
