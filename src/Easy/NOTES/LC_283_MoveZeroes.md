# Intuition

Ý tưởng chính là đẩy tất cả số 0 về cuối mảng, đồng thời giữ nguyên thứ
tự của các phần tử khác 0. Ta dùng hai con trỏ `left` và `right` để thực
hiện việc này.

# Approach

1.  Khởi tạo `left = 0`.
2.  Duyệt mảng bằng `right`.
3.  Nếu `nums[right] != 0`, hoán đổi `nums[left]` và `nums[right]`, sau
    đó tăng `left`.

# Ví dụ minh hoạ

**Input:**

    [0, 1, 0, 3, 12]

  right   nums\[right\]   Hành động                    Mảng sau khi xử lý   left
  ------- --------------- ---------------------------- -------------------- ------
  0       0               Bỏ qua                       \[0, 1, 0, 3, 12\]   0
  1       1               Swap nums\[1\] ↔ nums\[0\]   \[1, 0, 0, 3, 12\]   1
  2       0               Bỏ qua                       \[1, 0, 0, 3, 12\]   1
  3       3               Swap nums\[3\] ↔ nums\[1\]   \[1, 3, 0, 0, 12\]   2
  4       12              Swap nums\[4\] ↔ nums\[2\]   \[1, 3, 12, 0, 0\]   3

**Output:**

    [1, 3, 12, 0, 0]

# Complexity

-   **Time Complexity:** O(n)
-   **Space Complexity:** O(1)

# Code

``` java
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }        
    }
}
```
