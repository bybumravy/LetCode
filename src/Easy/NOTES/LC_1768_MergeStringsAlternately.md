# Intuition
Bài toán yêu cầu **trộn hai chuỗi theo thứ tự xen kẽ ký tự** — lần lượt lấy một ký tự từ `word1`, rồi một ký tự từ `word2`, cho đến khi **cả hai chuỗi đều hết**.  
Nếu một chuỗi dài hơn chuỗi kia, ta chỉ cần **thêm nốt phần còn lại** của chuỗi đó vào kết quả.

Ví dụ:
word1 = "abc"
word2 = "pqrstu"
Kết quả: "apbqcrstu"

# Approach
1. Lấy độ dài của hai chuỗi `m` và `n`.
2. Duyệt vòng lặp từ `i = 0` đến `max(m, n) - 1`.
3. Ở mỗi bước:
    - Nếu `i < m`, thêm ký tự thứ `i` của `word1` vào kết quả.
    - Nếu `i < n`, thêm ký tự thứ `i` của `word2` vào kết quả.
4. Dùng `StringBuilder` để nối chuỗi hiệu quả hơn so với phép cộng chuỗi thông thường (`+`).
5. Sau khi lặp xong, chuyển `StringBuilder` thành chuỗi kết quả và trả về.

---

# Complexity
- **Time complexity:**  
  \(O(\max(m, n))\) — vì ta duyệt qua từng ký tự của cả hai chuỗi.

- **Space complexity:**  
  \(O(m + n)\) — do `StringBuilder` chứa toàn bộ chuỗi kết quả.

---

# Code
```java
package Easy.CODE;

public class LC_1768_MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                res.append(word1.charAt(i)); // Thêm ký tự từ word1 nếu còn
            }
            if (i < n) {
                res.append(word2.charAt(i)); // Thêm ký tự từ word2 nếu còn
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        LC_1768_MergeStringsAlternately sol = new LC_1768_MergeStringsAlternately();
        String word1 = "abcfudhads";
        String word2 = "pqrstu";
        String result = sol.mergeAlternately(word1, word2);
        System.out.println("Kết quả: " + result);
    }
}
