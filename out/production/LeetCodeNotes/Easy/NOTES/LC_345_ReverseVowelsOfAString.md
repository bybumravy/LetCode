# Reverse Vowels of a String

## Intuition
Ý tưởng chính là sử dụng hai con trỏ để quét từ hai đầu của chuỗi, tìm các nguyên âm và hoán đổi vị trí của chúng.
Bằng cách này, chúng ta có thể đảo ngược các nguyên âm mà không cần tạo một chuỗi phụ mới.

---

## Approach
1. Chuyển chuỗi `s` thành mảng ký tự để dễ dàng thao tác.
2. Khởi tạo hai con trỏ: `start` bắt đầu từ đầu chuỗi và `end` bắt đầu từ cuối chuỗi.
3. Tạo một chuỗi `vowels` chứa tất cả các nguyên âm (cả chữ hoa và chữ thường) để dễ kiểm tra.
4. Trong khi `start < end`:
    - Dịch `start` sang phải cho đến khi gặp nguyên âm.
    - Dịch `end` sang trái cho đến khi gặp nguyên âm.
    - Hoán đổi hai nguyên âm tại vị trí `start` và `end`.
    - Di chuyển `start` sang phải và `end` sang trái.
5. Chuyển mảng ký tự đã được hoán đổi trở lại chuỗi và trả về kết quả.

---

## Complexity

- **Time complexity:**  
  O(n), trong đó n là độ dài chuỗi `s`. Mỗi ký tự được kiểm tra tối đa một lần.

- **Space complexity:**  
  O(n), vì chúng ta tạo một mảng ký tự mới từ chuỗi đầu vào.

---

## Code
```java
class Solution {
    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "ueoaiUEOAI";
        
        while(start < end) {
            while(start < end && vowels.indexOf(words[start]) == -1) {
                start++;
            }

            while(start < end && vowels.indexOf(words[end]) == -1) {
                end--;
            }

            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start += 1;
            end -= 1;
        }
        
        return new String(words);
    }
}
