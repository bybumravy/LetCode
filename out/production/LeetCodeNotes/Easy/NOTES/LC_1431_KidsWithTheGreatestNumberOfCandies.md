# Intuition
Bài toán yêu cầu xác định xem mỗi đứa trẻ có thể trở thành **đứa trẻ có nhiều kẹo nhất** nếu nhận thêm một số lượng kẹo nhất định (`extraCandies`).

Điểm quan trọng là **so sánh với số kẹo lớn nhất hiện tại** của tất cả các đứa trẻ.
- Nếu số kẹo hiện tại + `extraCandies` ≥ số kẹo lớn nhất, thì đứa trẻ đó **có thể trở thành hoặc bằng số kẹo nhiều nhất**.
- Nếu không, thì **không thể**.

---

# Approach
1. Duyệt mảng `candies` để tìm số kẹo lớn nhất (`maxi`).
2. Duyệt lại mảng `candies`:
    - Nếu `candies[i] + extraCandies >= maxi` → thêm `true` vào kết quả.
    - Nếu không → thêm `false`.
3. Trả về danh sách kết quả `List<Boolean>`.

---

# Complexity
- **Time complexity:**  
  \(O(n)\) — duyệt mảng 2 lần (tìm max + kiểm tra từng phần tử), với n là số lượng trẻ.

- **Space complexity:**  
  \(O(n)\) — danh sách kết quả chứa n giá trị Boolean.

---

# Code
```java
import java.util.ArrayList;
import java.util.List;

class Solution {

    // Hàm tìm số kẹo nhiều nhất
    public int maxCandy(int[] candies) {
        int maxi = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > maxi) {
                maxi = candies[i];
            }
        }
        return maxi;
    }

    // Hàm chính trả về danh sách các kết quả
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = maxCandy(candies);
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxi) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    // Test ví dụ
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = sol.kidsWithCandies(candies, extraCandies);
        System.out.println(result); // Kết quả: [true, true, true, false, true]
    }
}
