package Easy.CODE;

public class LC_345_ReverseVowelsOfAString {
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
        String answer = new String(words);
        return answer;
    }

    public static void main(String[] args) {
        LC_345_ReverseVowelsOfAString obj = new LC_345_ReverseVowelsOfAString();
        System.out.println(obj.reverseVowels("IceCreAm"));
    }
}
