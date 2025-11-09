# Reverse Words in a String

## Intuition
Ý tưởng là tách các từ trong chuỗi dựa trên khoảng trắng, sau đó đảo ngược thứ tự của các từ và ghép lại thành
một chuỗi mới. Đây là cách trực quan và hiệu quả để đảo ngược các từ trong câu.

---

## Approach
1. Sử dụng phương thức `split("\\s+")` để tách chuỗi `s` thành mảng các từ.
Biểu thức `\\s+` đảm bảo xử lý nhiều khoảng trắng liên tiếp.
2. Tạo một `StringBuilder` để lưu kết quả.
3. Duyệt mảng từ cuối về đầu:
    - Thêm từ hiện tại vào `StringBuilder`.
    - Nếu không phải từ cuối cùng, thêm một khoảng trắng.
4. Chuyển `StringBuilder` thành chuỗi và trả về kết quả.

---

## Complexity

- **Time complexity:**  
  O(n), với n là độ dài chuỗi đầu vào. Việc tách chuỗi và ghép các từ đều quét từng ký tự một lần.

- **Space complexity:**  
  O(n), do mảng từ và `StringBuilder` được tạo ra.

---

## Code
```java
package Easy.CODE;

public class LC_151_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if(i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC_151_ReverseWordsInAString obj = new LC_151_ReverseWordsInAString();
        System.out.println(obj.reverseWords("havy yeu cau lam")); // Output: "lam cau yeu havy"
        System.out.println(obj.reverseWords("happy you ne")); // Output: "ne you happy"
    }
}
