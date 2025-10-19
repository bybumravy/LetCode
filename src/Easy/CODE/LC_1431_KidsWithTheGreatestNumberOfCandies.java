package Easy.CODE;

import java.util.ArrayList;
import java.util.List;

public class LC_1431_KidsWithTheGreatestNumberOfCandies {
    public int maxCandy(int[] candies, int extraCandy) {
        int maxi = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if(candies[i] > maxi) {
                maxi = candies[i];
            }
        }
        return maxi;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = maxCandy(candies, extraCandies);
        List<Boolean> result = new ArrayList<>() {
        };
        for (int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= maxi) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC_1431_KidsWithTheGreatestNumberOfCandies sol = new LC_1431_KidsWithTheGreatestNumberOfCandies();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> result = sol.kidsWithCandies(candies, extraCandies);
        System.out.println(result);
    }

}
