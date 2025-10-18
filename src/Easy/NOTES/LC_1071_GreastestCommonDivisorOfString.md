# Intuition
Khi một chuỗi có thể tạo nên cả `str1` và `str2` bằng cách lặp lại nhiều lần, chuỗi đó được gọi là **divisible string**.  
Nếu tồn tại một chuỗi như vậy, thì hai chuỗi khi nối theo hai chiều phải bằng nhau: str1 + str2 == str2 + str1

Ngược lại, nếu khác nhau → không có chuỗi nào chia được cả hai.

Nếu tồn tại chuỗi chia được, thì **độ dài của chuỗi GCD** chính là **Ước chung lớn nhất (GCD)** của độ dài hai chuỗi.  
Khi đó, chỉ cần lấy **tiền tố (prefix)** của `str1` có độ dài bằng GCD đó là kết quả.

---

# Approach
1. Kiểm tra xem `(str1 + str2)` có bằng `(str2 + str1)` không.
    - Nếu **không bằng**, trả về chuỗi rỗng `""`.
    - Nếu **bằng**, tức là có chuỗi chia được.
2. Tính `gcdLength = gcd(len(str1), len(str2))`.
3. Trả về `str1.substring(0, gcdLength)` là **GCD string**.

---

# Complexity
- **Time complexity:**  
  \(O(m + n)\)
    - So sánh hai chuỗi nối dài: \(O(m + n)\).
    - Tính GCD độ dài: \(O(\log(\min(m, n)))\).  
      ⇒ Tổng thể: \(O(m + n)\).

- **Space complexity:**  
  \(O(1)\) — chỉ dùng vài biến tạm.

---

# Code
```java
class Solution {

    // Hàm tính UCLN (GCD) của hai số nguyên
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    // Hàm tìm GCD của hai chuỗi
    public String gcdOfStrings(String str1, String str2) {
        // Kiểm tra xem có chuỗi chia được hay không
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Tính GCD độ dài
        int gcdLength = gcd(str1.length(), str2.length());

        // Trả về tiền tố có độ dài bằng GCD
        return str1.substring(0, gcdLength);
    }
}
