# Intuition
Ý tưởng chính là duyệt qua từng ô trong luống hoa và kiểm tra xem có thể trồng hoa tại vị trí đó hay không.  
Một vị trí có thể trồng được hoa nếu:
- Ô đó hiện đang trống (`0`)
- Ô bên trái (nếu có) **không có hoa**
- Ô bên phải (nếu có) **không có hoa**

Nếu đủ ba điều kiện trên, ta trồng hoa tại vị trí đó và tăng số lượng hoa đã trồng.  
Nếu trong quá trình duyệt mà số hoa trồng được `>= n`, ta có thể dừng sớm và trả về `true`.

---

# Approach
1. Khởi tạo biến `count = 0` để lưu số lượng hoa đã trồng được.
2. Duyệt qua từng phần tử trong mảng `fl`:
    - Nếu `fl[i] == 0`, kiểm tra hai điều kiện:
        - **Trái trống:** `i == 0` hoặc `fl[i - 1] == 0`
        - **Phải trống:** `i == fl.length - 1` hoặc `fl[i + 1] == 0`
    - Nếu cả hai điều kiện đều đúng, trồng hoa (`fl[i] = 1`) và tăng `count`.
    - Nếu `count >= n`, trả về `true`.
3. Sau khi duyệt xong, nếu `count < n`, trả về `false`.

---

# Complexity
- **Time complexity:**  
  $$O(m)$$ — với `m` là độ dài của mảng `fl`, vì chỉ duyệt qua một lần.

- **Space complexity:**  
  $$O(1)$$ — chỉ dùng vài biến tạm, không cần thêm bộ nhớ phụ.

---

# Code
```java
public class Solution {
   public boolean canPlaceFlowers(int[] fl, int n) {
        boolean left, right;
        int count = 0;
        for (int i = 0; i < fl.length; i++) {
            left = false;
            right = false;
            if (fl[i] == 0) {
                if (i == 0 || fl[i - 1] == 0) {
                    left = true;
                }
                if (i == fl.length - 1 || fl[i + 1] == 0) {
                    right = true;
                }
                if (left && right) {
                    count++;
                    fl[i] = 1;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}
