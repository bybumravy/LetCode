# Increasing Triplet Subsequence

## Intuition
Bài toán yêu cầu kiểm tra xem trong mảng có tồn tại **một dãy con tăng gồm 3 phần tử** (`nums[i] < nums[j] < nums[k]` với `i < j < k`) hay không.  
Thay vì kiểm tra mọi bộ ba phần tử (mất `O(n³)`), ta có thể chỉ cần theo dõi **2 phần tử nhỏ nhất** cho đến thời điểm hiện tại.  
Nếu ta gặp một phần tử lớn hơn cả hai, điều đó có nghĩa là tồn tại một bộ ba tăng.
---

## Approach
Duy trì hai biến:
- `a`: phần tử nhỏ nhất đã gặp.
- `b`: phần tử nhỏ thứ hai (lớn hơn `a`).

Duyệt qua từng phần tử `num` trong mảng:
1. Nếu `num <= a`, cập nhật `a = num`.  
   → Tìm được giá trị nhỏ hơn hoặc bằng giá trị nhỏ nhất hiện tại.
2. Ngược lại, nếu `num <= b`, cập nhật `b = num`.  
   → Tìm được giá trị lớn hơn `a` nhưng nhỏ hơn hoặc bằng `b`.
3. Nếu `num > b`, nghĩa là `a < b < num` → tồn tại dãy tăng độ dài 3 → trả về `true`.


Nếu duyệt hết mảng mà không tìm được, trả về `false`.

---

## Complexity
- **Time complexity:** `O(n)` — chỉ duyệt mảng một lần.
- **Space complexity:** `O(1)` — chỉ dùng hai biến bổ sung `a` và `b`.

---

## Code
```java
class Solution {
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
                // num > b > a → found an increasing triplet
                return true;
            }
        }

        return false;
    }
}
